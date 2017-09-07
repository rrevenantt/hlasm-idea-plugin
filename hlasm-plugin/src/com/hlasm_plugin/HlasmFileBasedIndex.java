package com.hlasm_plugin;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.Consumer;
import com.intellij.util.indexing.*;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.io.EnumeratorStringDescriptor;
import com.intellij.util.io.KeyDescriptor;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmFileBasedIndex extends ScalarIndexExtension<String> {
    public HlasmFileBasedIndex() {
    }

    @NotNull
    @Override
    public FileBasedIndex.InputFilter getInputFilter() {
        return new FileBasedIndex.FileTypeSpecificInputFilter() {
            @Override
            public void registerFileTypesUsedForIndexing(@NotNull Consumer<FileType> fileTypeSink) {
                fileTypeSink.consume(HlasmFileType.INSTANCE);
            }

            @Override
            public boolean acceptInput(@NotNull VirtualFile file) {
                return file.getExtension().equalsIgnoreCase("asm");
            }
        };
    }

    @Override
    public boolean dependsOnFileContent() {
        return false;
    }

    @NotNull
    @Override
    public ID<String,Void> getName() {
        return ID.create("Macros");
    }

    @NotNull
    @Override
    public DataIndexer<String, Void, FileContent> getIndexer() {
        return new DataIndexer<String, Void, FileContent>() {
            @NotNull
            @Override
            public Map<String, Void> map(@NotNull FileContent inputData) {
                return null;//PsiTreeUtil.findCh inputData.getPsiFile();
            }
        };
    }

    @NotNull
    @Override
    public KeyDescriptor<String> getKeyDescriptor() {
        return EnumeratorStringDescriptor.INSTANCE;
    }

    @Override
    public int getVersion() {
        return 0;
    }
}
