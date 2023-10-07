package dev.bootloader.intellij.module

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.projectRoots.SdkAdditionalData
import com.intellij.util.xmlb.XmlSerializerUtil

class BootLoaderSdkData : SdkAdditionalData, PersistentStateComponent<BootLoaderSdkData>, Cloneable {
    var homePath = ""
        private set
    var version = ""
        private set

    constructor()
    constructor(homePath: String, version: String) {
        this.homePath = homePath
        this.version = version
    }

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        return super.clone()
    }

    override fun getState(): BootLoaderSdkData {
        return this
    }

    override fun loadState(state: BootLoaderSdkData) {
        XmlSerializerUtil.copyBean(state, this)
    }
}