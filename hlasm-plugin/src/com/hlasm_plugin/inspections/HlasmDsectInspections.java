package com.hlasm_plugin.inspections;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.psi.HlasmPSIFileRoot;
import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import com.intellij.psi.search.PsiShortNamesCache;
import com.intellij.psi.tree.IElementType;
import com.map_dump.model.dsect.Dsect;
import com.map_dump.model.dsect.DsectStatement;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Created by anisik on 15.12.2016.
 */
public class HlasmDsectInspections extends LocalInspectionTool {
    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return "dsect analyzer";
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
        return new PsiElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
//                if (element instanceof LabelDefLineSubtree){
//                    element.
//                }
            }

            @Override
            public void visitFile(PsiFile file) {
                if (!file.getLanguage().is(HlasmLanguage.INSTANCE))
                    return;

                System.out.println("visited " + file.getName());
                file.acceptChildren(new MrRecursivePsiVisitor((HlasmPSIFileRoot) file));

                super.visitFile(file);
            }
        };
    }

    @NotNull
    @Override
    public String getShortName() {
        return "AnalyzeDsects";
    }

    public class MrRecursivePsiVisitor extends PsiRecursiveElementVisitor {
        Map<String, MacroVar> currLocals = new HashMap<>();
        Map<String, MacroVar> currGlobals;
        Map<String, DsectStatement> fieldMap;
        public String currDsect;
        public int currCounter = 0;
        public int backedCounter;
        public boolean macro = false;
        public int recursionDepth = 0;
        public HlasmPSIFileRoot rootFile;
        PsiElement currElement;

        //        Map
        public MrRecursivePsiVisitor() {
            currGlobals = new HashMap<>();
            fieldMap = new HashMap<>();
        }

        public MrRecursivePsiVisitor(HlasmPSIFileRoot rootFile) {
            this.rootFile = rootFile;
        }

        public MrRecursivePsiVisitor(final PsiElement[] macroArguments, Map<String, MacroVar> globals, boolean macro, HlasmPSIFileRoot rootFile) {
            for (PsiElement argument :
                    macroArguments) {
                if (argument.getNode().getElementType() instanceof RuleIElementType &&
                        ((RuleIElementType) argument.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_named_argument) {
                    currLocals.put(argument.getFirstChild().getText(),
                            new MacroVar(argument.getFirstChild().getText(),
                                    argument.getFirstChild().getText(),
                                    argument.getLastChild().getNode(),
                                    MacroVarType.String));
                }
//                else{
//
//                }
            }
            currGlobals = globals;
            this.macro = macro;
            this.rootFile = rootFile;
        }

        @Override
        public void visitElement(PsiElement element) {

            if (!(element.getNode().getElementType() instanceof RuleIElementType))
                return;
            switch (((RuleIElementType) element.getNode().getElementType()).getRuleIndex()) {
                case HlasmParser.RULE_macro_def_wr:
                    return;
                case HlasmParser.RULE_macro:
                    if (macro) {
                        break;
                    }
                    PsiElement macroDef = element.getNode().findChildByType((IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro_def_wr)).getPsi().getFirstChild().getFirstChild();
                    rootFile.macros.put(((LabelDefLineSubtree) macroDef).getCommand().getText(), element);
                    System.out.println(" macro added " + ((LabelDefLineSubtree) macroDef).getCommand().getText());
//                    break;
                    currDsect = null;
                    return;
                case HlasmParser.RULE_line:
                    if (!(element instanceof LabelDefLineSubtree))
                        return;

                    if (((LabelDefLineSubtree) element).getCommand() == null)
                        return;

                    String command = ((LabelDefLineSubtree) element).getCommand().getText();
//                    System.out.println(command);
                    switch (((TokenIElementType) ((LabelDefLineSubtree) element).getCommand().getElementType()).getANTLRTokenType()) {
                        case HlasmLexer.COMMAND:
                            if (recursionDepth > 10)
                                return;
//                            PsiDocumentManager.getInstance(element.getProject()).getPsiFile();
//                            FileEditorManagerEx.getInstanceEx(element.getProject()).getSelectedTextEditor().getDocument();



                            PsiElement elementToVisit = null;
                            if (rootFile.macros.containsKey(command)) {
                                elementToVisit = ((HlasmPSIFileRoot) element.getContainingFile()).macros.get(command);
                            } else {
                                PsiFile[] macroFiles = PsiShortNamesCache.getInstance(element.getProject()).getFilesByName(command + ".asm");
                                if (macroFiles.length > 0) {
                                    System.out.println(macroFiles[0].getVirtualFile().getCanonicalPath());
                                    elementToVisit = macroFiles[0].getFirstChild();//.getNode().findChildByType(
//                                            (IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro)).getPsi();
                                    if (macroFiles[0] == element.getContainingFile())
                                        elementToVisit = null;
                                }
                            }
                            if (elementToVisit != null) {

                                MrRecursivePsiVisitor recursiveVisitor = new MrRecursivePsiVisitor(element.getChildren(), currGlobals, true, rootFile);
                                recursiveVisitor.currCounter = currCounter;
                                recursiveVisitor.currDsect = currDsect;
                                recursiveVisitor.recursionDepth = recursionDepth + 1;

                                elementToVisit.acceptChildren(recursiveVisitor);
                                currCounter = recursiveVisitor.currCounter;
                                currDsect = recursiveVisitor.currDsect;
                            }
                            break;
                        case HlasmLexer.DSECT:
                            if (rootFile.dsects.containsKey(((LabelDefLineSubtree) element).getName())) {
                                System.out.println("duplicate def?!!"); // todo remove temp workaround
                                break;
                            }
                            currDsect = ((LabelDefLineSubtree) element).getName();
                            System.out.println("dsect started " + currDsect);
                            rootFile.dsects.putIfAbsent(currDsect, new Dsect(currDsect));
                            currCounter = 0;
                            break;
                        case HlasmLexer.PROLOG_MACRO:
                            currDsect = null;
                            break;
                        case HlasmLexer.DS:
                            if (currDsect != null) {
                                Dsect dsect = rootFile.dsects.get(currDsect);
                                for (PsiElement argument :
                                        element.getChildren()) {
                                    if (argument.getNode().getElementType() instanceof RuleIElementType) {
                                        Matcher matcher = HlasmRegexLibrary.ds_statement.matcher(argument.getText());
                                        if (matcher.find()) {
                                            int rep;
                                            try {
                                                rep = Integer.parseInt(matcher.group(1));
                                            } catch (NumberFormatException e) {
                                                rep = 1;
                                            }
                                            char type = matcher.group(2).charAt(0);
                                            int len;
                                            try {
                                                len = Integer.parseInt(matcher.group(4));
                                            } catch (NumberFormatException e) {
                                                switch (type) {
                                                    case 'X':
                                                        len = 1;
                                                        break;
                                                    case 'C':
                                                        len = 1;
                                                        break;
                                                    case 'H':
                                                        len = 2;
                                                        break;
                                                    case 'F':
                                                        len = 4;
                                                        break;
                                                    case 'A':
                                                        len = 4;
                                                        break;
                                                    default:
                                                        len = 1;
                                                }
                                            }
                                            dsect.getDsectStmts().add(new DsectStatement(currCounter,
                                                    ((LabelDefLineSubtree) element).getName(),
                                                    "DS", rep, type, len, null));
                                            System.out.println(currDsect + " field added " + ((LabelDefLineSubtree) element).getName() +
                                                    " " + currCounter + " " + rep + " " + type + " " + len);
                                            currCounter += rep * len;
                                        }
                                    }
                                }
                            }
                            break;
                        case HlasmLexer.EQU:
//                            PsiElement argument = element.getNode().findChildByType(
//                                    (IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_argument)).getPsi();

                            break;
                        case HlasmLexer.ORG:

                            break;
                        case HlasmLexer.AIF:

                    }

                    return;
                default:
//                    System.out.println("go inside " + HlasmParser.ruleNames[((RuleIElementType) element.getNode().getElementType()).getRuleIndex()]);
            }
//            super.visitElement(element);
            element.acceptChildren(this);
        }

        public int calculateArgument(PsiElement expression) {
            PsiElement firstChild = expression.getFirstChild();
            if (((RuleIElementType) firstChild.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_simple_expr) {

                switch (((TokenIElementType) firstChild.getNode().getFirstChildNode().getElementType()).getANTLRTokenType()){
                    case HlasmLexer.LABEL:
//                        return fieldMap.get(firstChild.getNode().getFirstChildNode().getText()).
                    case HlasmLexer.NUMBER:
                }
            }
            return 0;
        }
    }


    public class MacroVar{
        public MacroVar(String name, String value, MacroVarType type) {
            this.name = name;
            this.value = value;
            this.parsed = null; // might need to parse here
            this.type = type;
        }

        public MacroVar(String name, String value, ASTNode parsed, MacroVarType type) {
            this(name,value,type);
            this.parsed = parsed;
        }

        public MacroVarType type;
        public String name;
        public String value;
        public ASTNode parsed;
    }

    public enum MacroVarType{
        String,
        Int,
        Bool
    }


    public enum VarType {
        B,
        X,
        C,
        H,
        F,
        A,
        Y,
        D,
        U   //undefined
    }



}
