package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmFileType;
import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.stubs.HlasmPsiFileStub;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.StubBuilder;
import com.intellij.psi.stubs.*;
import com.intellij.psi.tree.IStubFileElementType;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmIFileElementType extends IStubFileElementType<HlasmPsiFileStub> {
    public HlasmIFileElementType() {
        super(HlasmLanguage.INSTANCE);
    }

    @Override
    public int getStubVersion() {
        return 20;
    }

    @Override
    public void indexStub(@NotNull PsiFileStub stub, @NotNull IndexSink sink) {
        //sink.occurrence(StubIndexKey.createIndexKey("test"),);
    }

    @Override
    public boolean shouldBuildStubFor(VirtualFile file) {
        return file.getFileType() == HlasmFileType.INSTANCE && file.getLength() < 2000000;
    }

    @Override
    public StubBuilder getBuilder() {
        return new DefaultStubBuilder(){
            @Override
            public boolean skipChildProcessingWhenBuildingStubs(@NotNull ASTNode parent, @NotNull ASTNode node) {
                return node.getElementType() instanceof RuleIElementType
                        && ((RuleIElementType) node.getElementType()).getRuleIndex() == HlasmParser.RULE_lines
                        && !(parent instanceof FileASTNode) ;
            }

            @Override
            public StubElement buildStubTree(@NotNull PsiFile file) {
                System.out.println("building stub tree for " + file.getName());
                ASTNode statement = file.getNode().getFirstChildNode().getFirstChildNode();
                while(statement != null){
                    if (statement.getFirstChildNode() != null &&
                            statement.getFirstChildNode().getElementType() instanceof HlasmMacroIElementType)
                        break;

                    statement = statement.getTreeNext();
                }
                StubElement root = createStubForFile(file);
                if (statement != null) {

                    StubElement first = buildStubTreeFor(statement, root);

                    ((ObjectStubBase) first).markDangling();
                }
                return root;
            }


        };
    }

}
