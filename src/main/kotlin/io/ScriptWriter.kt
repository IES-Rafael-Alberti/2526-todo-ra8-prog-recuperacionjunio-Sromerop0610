package org.iesra.io

import org.iesra.model.PhotoFile
import org.iesra.model.ProcessingResult
import org.iesra.model.RenameCommand
import org.iesra.model.TripInput
import java.nio.file.Files
import java.nio.file.Path

class ScriptWriter {
    fun write(
        outPutRoute: Path,
        place: String,
        comandos: List<RenameCommand>
    ) {
        var outPutFile = outPutRoute.resolve("$place.sh")

        comandos.forEach {
            file.write(it.toScriptLine())
        }
        Files.write(outPutFile, lines)
    }
}

/*
fun write(
        outPutRoute: Path,
        place: String,
        comandos: List<RenameCommand>
    ) {
        var outPutFile = outPutRoute.resolve("$place.sh")

        var lines = buildList {
            comandos.forEach {
                add(it.toScriptLine())
            }
        }

        Files.write(outPutFile, lines)
    }
}
 */