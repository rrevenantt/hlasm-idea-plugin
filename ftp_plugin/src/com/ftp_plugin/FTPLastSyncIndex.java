package com.ftp_plugin;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.*;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.io.KeyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by anisik on 07.07.2017.
 */
public class FTPLastSyncIndex extends SingleEntryFileBasedIndexExtension<Date> {

    public static final ID<Integer, Date> FTP_ID = ID.create("FTP.timestamp.index");

    @NotNull
    @Override
    public SingleEntryIndexer<Date> getIndexer() {
        return new SingleEntryIndexer<Date>(false) {
            @Nullable
            @Override
            protected Date computeValue(@NotNull FileContent inputData) {
                if (inputData.getFile().isDirectory()
                        || inputData.getProject() == null) return null;



//                System.out.println("index calculating " + inputData.getFileName());
                Date newValue = inputData.getFile().getUserData(FTPServiceProvider.FTP_LAST_SYNC);
                if (newValue != null) {
                    return  newValue;
                }
//                List<Date> values = FileBasedIndex.getInstance().getValues(FTP_ID, FileBasedIndex.getFileId(inputData.getFile()), GlobalSearchScope.everythingScope(inputData.getProject()));
//                return values.isEmpty()?null:values.get(0);
                return null;
            }
        };
    }

    @NotNull
    @Override
    public ID<Integer, Date> getName() {
        return FTP_ID;
    }

    @Override
    public boolean dependsOnFileContent() {
        return true ;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @NotNull
    @Override
    public DataExternalizer<Date> getValueExternalizer() {
        return new DataExternalizer<Date>() {
            @Override
            public void save(@NotNull DataOutput out, Date value) throws IOException {
                out.writeLong(value.getTime());
            }

            @Override
            public Date read(@NotNull DataInput in) throws IOException {
                return new Date(in.readLong());
            }
        };
    }

    @NotNull
    @Override
    public FileBasedIndex.InputFilter getInputFilter() {
        return new FileBasedIndex.InputFilter() {
            @Override
            public boolean acceptInput(@NotNull VirtualFile file) {
                return !file.isDirectory()
                        /*file.getExtension() != null
                        && (file.getExtension().equals("asm")
                            ||file.getExtension().equals("jcl")
                            ||file.getExtension().equals("rexx "))*/;
            }
        };
    }
}
