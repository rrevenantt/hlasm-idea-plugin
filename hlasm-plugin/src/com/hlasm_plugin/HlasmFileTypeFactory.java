package com.hlasm_plugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer){
        fileTypeConsumer.consume(HlasmFileType.INSTANCE,"asm");
    }
}
