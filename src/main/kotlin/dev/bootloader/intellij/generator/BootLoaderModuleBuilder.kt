package dev.bootloader.intellij.generator

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.Disposable
import javax.swing.JComponent
import javax.swing.JLabel

class BootLoaderModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): BootLoaderModuleType {
        return BootLoaderModuleType.instance
    }

    override fun canCreateModule(): Boolean {
        return false
    }

    override fun isOpenProjectSettingsAfter(): Boolean {
        return true
    }

    override fun getCustomOptionsStep(context: WizardContext, parentDisposable: Disposable): ModuleWizardStep? {
        return object : ModuleWizardStep() {
            override fun getComponent(): JComponent {
                return JLabel("Put your content here")
            }

            override fun updateDataModel() {
                // don't do anything
            }
        }
    }
}
