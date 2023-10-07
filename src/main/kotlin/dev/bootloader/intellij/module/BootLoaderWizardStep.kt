package dev.bootloader.intellij.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import javax.swing.JComponent
import javax.swing.JLabel

class BootLoaderWizardStep(val wizardContext: WizardContext, val moduleBuilder: ModuleBuilder) : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return JLabel("Hello World")
    }

    override fun updateDataModel() {
//        TODO: This is where we can update the data model
    }
}
