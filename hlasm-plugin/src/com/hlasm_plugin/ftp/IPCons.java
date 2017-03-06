package com.hlasm_plugin.ftp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;

public class IPCons {
    private static final long NUMBER_OD_SKIP_BYTES = 7;
    private static final char START_CHAR = (char) 0;
    private static final String IPCON_COMMAND_PREFIX = "IPcon   ";
    private static final int TIMEOUT = 5000;
    private static final int SO_TIMEOUT = 20000;

    private static Logger logger = LogManager.getLogger(IPCons.class);
    private static IPCons instance;

    private final String host;
    public final int clayNumber;
    private int port = 51100;

    private IPCons(String host, int portLastNumber) {
        this.host = host;
        this.clayNumber = portLastNumber;
        port = port + portLastNumber;
    }

    public static IPCons getInstance() {
        return instance;
    }

    public static void init(String host, int portLastNumber) {
        if (instance == null) {
            instance = new IPCons(host, portLastNumber);
        }
    }

    public static void delete() {
        instance = null;
    }

    public ArrayList<String> runCommand(String command) throws IOException/*,IPConsException */{
        logger.debug("Host = " + host + " connecting by IPCON...");

        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(host, port);
        socket.connect(socketAddress, TIMEOUT);
        socket.setSoTimeout(SO_TIMEOUT);

        PrintStream pout = new PrintStream(socket.getOutputStream());
        InputStream is = socket.getInputStream();
        DataInputStream din = new DataInputStream(is);

        pout.print(getCommand(command));
        logger.info("executing... " + command);

        ArrayList<String> result = new ArrayList<>();
        while (true) {
            byte[] dummy = new byte[1];
            if (din.read(dummy) == -1) break;

            long numberOfSkipBytes = din.skip(NUMBER_OD_SKIP_BYTES);
        //    if (numberOfSkipBytes != NUMBER_OD_SKIP_BYTES) {
        //        throw new IPConsException("Skipped wrong number of bytes");
        //    }

            int length = din.readInt();
            byte[] data = new byte[length];
            din.readFully(data, 0, length);
            Collections.addAll(result, new String(data).split("\n"));
        }

        socket.close();
        logger.debug("IPCON session closed");

        return result;
    }

    private static String getDisplayInfo() {
        StringBuilder sb = new StringBuilder(128);
        String hex = "00";
        int intVal = Integer.parseInt(hex, 16);
        char charVal = (char) intVal;
        sb.append(charVal);
        for (int i2 = 0; i2 < 127; i2++)
            sb.append(' ');
        return sb.toString();
    }

    private String getCommand(String line) {
        char myChar4 = (char) line.length();
        return IPCON_COMMAND_PREFIX + START_CHAR + START_CHAR + START_CHAR + myChar4 + getDisplayInfo() + line;
    }
}
