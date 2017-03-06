package com.jcl_plugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 16.02.2017.
 */
public class JCLFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer){
        fileTypeConsumer.consume(JclFileType.INSTANCE,"jcl");
    }
}
