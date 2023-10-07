package dev.bootloader.intellij.module

import com.intellij.openapi.projectRoots.*
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.util.xmlb.XmlSerializer
import org.jdom.Element
import java.io.File
import javax.swing.Icon

class BootLoaderSdkType : SdkType("bootloader") {
    override fun suggestHomePath(): String? {
        return System.getenv()["BOOTLOADER_HOME"]
    }

    override fun isValidSdkHome(s: String): Boolean {
        val home = LocalFileSystem.getInstance().findFileByIoFile(File(s))
        if (home != null && home.exists() && home.isDirectory) {
            val lib = home.findChild("lib")
            val rt = home.findChild("rt")
            if (lib != null && lib.isDirectory && rt != null && rt.isDirectory) {
                return true
            }
        }
        return false
    }

    override fun suggestSdkName(s: String?, s2: String): String {
        return "BootLoader SDK"
    }

    override fun createAdditionalDataConfigurable(sdkModel: SdkModel,
                                                  sdkModificator: SdkModificator): AdditionalDataConfigurable? {
        return null
    }

    override fun getPresentableName(): String {
        return "BootLoader SDK"
    }

    override fun loadAdditionalData(additional: Element): SdkAdditionalData? {
        return XmlSerializer.deserialize(additional, BootLoaderSdkData::class.java)
    }

    override fun getIcon(): Icon {
        return BootLoaderIcons.BootLoader
    }

    override fun getIconForAddAction(): Icon {
        return icon
    }

    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {
        if (additionalData is BootLoaderSdkData) {
            XmlSerializer.serializeInto(additionalData, additional)
        }
    }

    override fun getVersionString(sdk: Sdk): String? {
        val path = sdk.homePath ?: return null
        val file = File(path)
        val home = LocalFileSystem.getInstance().findFileByIoFile(file)
        if (home != null) {
            val lib = home.findChild("lib")
            if (lib != null) {
                for (jar in lib.children) {
                    var name = jar.name
//                    if (name.startsWith("bootloader-") && "jar".equals(jar.getExtension(), ignoreCase = true)) {
//                        name = name.substring(8)
//                        name = name.replace("-SNAPSHOT", "")
//                        name = name.replace(".jar", "")
//                        return name
//                    }
                    return name
                }
            }
        }
        return null
    }

    companion object {
        val instance: SdkTypeId
            get() = findInstance(BootLoaderSdkType::class.java)
    }
}