package com.hlasm_plugin.stubs;

import com.hlasm_plugin.psi.HlasmMacroIElementType;
import com.hlasm_plugin.psi.HlasmMacroPsiElement;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;
import org.stringtemplate.v4.ST;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by anisik on 30.06.2017.
 */
public class HlasmStubIndex extends StringStubIndexExtension<HlasmMacroPsiElement> {
    public static HlasmStubIndex INSTANCE = new HlasmStubIndex();

    public Collection<String> cache = null;
    public String[] cacheAsArray = null;

    public static final StubIndexKey<String,HlasmMacroPsiElement> KEY = StubIndexKey.createIndexKey("macros");
    @NotNull
    @Override
    public StubIndexKey<String, HlasmMacroPsiElement> getKey() {
        return KEY;
    }

    @Override
    public int getVersion() {
        return 20;
    }

    @Override
    public Collection<String> getAllKeys(Project project) {
        if (cache == null) {
            cache = super.getAllKeys(project);
            cacheAsArray = null;
        }

        return cache;
    }

    public String[] getAllKeysAsArray(Project project){
        if (cacheAsArray == null)
            cacheAsArray = getAllKeys(project).toArray(new String[0]);
        return cacheAsArray;
    }


    public Collection<HlasmMacroPsiElement> getSorted(@NotNull String s, @NotNull Project project, @NotNull GlobalSearchScope scope, Comparator<HlasmMacroPsiElement> comparator) {
        // todo in case it is not list create new sorted one
        List<HlasmMacroPsiElement> got = (List<HlasmMacroPsiElement>) super.get(s, project, scope);
        got.sort(comparator);
        return got;
    }
}
