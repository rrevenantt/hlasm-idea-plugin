package com.ftp_plugin;

import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by anisik on 11.07.2017.
 */
public class HlasmForceGetAction extends HlasmGetRemotePDSAction {

    @Override
    public void actionPerformed(AnActionEvent ev) {
        super.actionPerformed(ev,true);
    }
}
