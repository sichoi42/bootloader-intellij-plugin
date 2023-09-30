package dev.bootloader.intellij.utils

import com.intellij.openapi.project.Project
import java.text.MessageFormat
import java.util.*

object PluginResource {
    private val bundle = ResourceBundle.getBundle("resources")
    private val bundles = Collections.synchronizedMap(HashMap<Project?, ResourceBundle>())

    fun getText(key: String): String {
        return getText(key, null)
    }

    private fun getText(key: String, project: Project?): String {
        val customText = Optional.ofNullable(bundles[project])
                .map { customBundle: ResourceBundle -> customBundle.getString(key) }
        return if (customText.isEmpty) bundle.getString(key) else customText.get()
    }

    private fun getAndReplaceText(key: String, project: Project?,
                                  vararg arguments: Any?): String {
        return MessageFormat.format(getText(key, project), *arguments)
    }
}
