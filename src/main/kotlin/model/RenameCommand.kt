package org.iesra.model

class RenameCommand (
    var source : String,
    var target : String,
) {
    fun toScriptLine(): String {
        return "mv $source $target"
    }
}