package dev.bootloader.intellij.generator

import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import com.intellij.openapi.util.IconLoader
import dev.bootloader.intellij.utils.PluginResource
import javax.swing.Icon

class BootLoaderModuleType : ModuleType<BootLoaderModuleBuilder>(ID) {
    override fun createModuleBuilder(): BootLoaderModuleBuilder {
        return BootLoaderModuleBuilder()
    }

    override fun getName(): String {
        return PluginResource.getText("intellij.ProjectBuilder.name")
    }

    override fun getDescription(): String {
        return PluginResource.getText("intellij.ProjectBuilder.description")
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return IconLoader.getIcon("/META-INF/icons/bootloader_logo_16x16.svg", BootLoaderModuleType::class.java)
    }

    companion object {
        private const val ID = "BOOTLOADER_MODULE_TYPE"

        @JvmStatic
        val instance: BootLoaderModuleType
            get() {
                return ModuleTypeManager.getInstance().findByID(ID) as? BootLoaderModuleType
                        ?: BootLoaderModuleType()
            }
    }
}
