package dev.bootloader.intellij.module

import com.intellij.ide.util.projectWizard.*
import com.intellij.openapi.Disposable
import com.intellij.openapi.roots.ui.configuration.ModulesProvider


class BootLoaderModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): BootLoaderModuleType {
        return BootLoaderModuleType.instance
    }

    override fun canCreateModule(): Boolean {
        return false
    }

    /**
     * @return true if the module builder should be shown in the project wizard.
     * @see https://github.com/JetBrains/intellij-sdk-docs/blob/main/topics/reference_guide/project_wizard.md
     */
    override fun isAvailable(): Boolean {
        return true;
    }

    override fun isOpenProjectSettingsAfter(): Boolean {
        return true
    }

    override fun createWizardSteps(wizardContext: WizardContext,
                                   modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
//        TODO: This is where we can add custom steps to the wizard
//        TODO: Change name of Class that implements ModuleWizardStep more appropriately
        return arrayOf<ModuleWizardStep>(BootLoaderWizardStep(wizardContext, this))
    }

    override fun getCustomOptionsStep(context: WizardContext, parentDisposable: Disposable): ModuleWizardStep {
        val moduleBuilder: BootLoaderModuleBuilder = this
        return object : ProjectJdkForModuleStep(context, null) {
            override fun updateDataModel() {
                super.updateDataModel()
                moduleBuilder.moduleJdk = jdk
            }
        }
    }
}
