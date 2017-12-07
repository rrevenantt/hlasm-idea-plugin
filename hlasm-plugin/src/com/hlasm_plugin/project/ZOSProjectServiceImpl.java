package com.hlasm_plugin.project;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.project.Project;
import org.jdom.Element;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(name = "MacroDatasetConcatenation",storages = @Storage(StoragePathMacros.MODULE_FILE))
public class ZOSProjectServiceImpl implements ZOSProjectService,PersistentStateComponent<Element> {

    Project project;

    public ZOSProjectServiceImpl(Project project) {
        this.project = project;
    }

    public List<String> macroDatasets = new LinkedList<>();

    @Override
    public List<String> getMacroConcatenation() {
        return macroDatasets;
    }

    @Override
    public void setMacroConcatenation(List<String> set) {
        macroDatasets = set;
    }

    @Nullable
    @Override
    public Element getState() {
        Element root = new Element("MacroConcat");
        for (String name :
                macroDatasets) {
            Element newElement = new Element("MacroDataset");
            newElement.setAttribute("DSN",name);
            root.addContent(newElement);
        }
        return root;
    }

    @Override
    public void loadState(Element state) {
        List<Element> data = state.getChildren("MacroDataset");
        macroDatasets = new ArrayList<>(data.size());
        for (Element dataset: data
             ) {
            macroDatasets.add(dataset.getAttributeValue("DSN"));
        }
    }
}
