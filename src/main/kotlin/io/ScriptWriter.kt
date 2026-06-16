package org.iesra.io

import org.iesra.model.PhotoFile
import org.iesra.model.TripInput
import java.nio.file.Files
import java.nio.file.Path

class ScriptWriter {
    fun write(
        tripInput: TripInput,
        photoFile: List<PhotoFile>,
        outPutRoute: Path
    ) {
        var outPutFile = outPutRoute.resolve("$tripInput.destination.sh")

        var lines = buildList {
            photoFile.forEach { image ->
                add("mv ${image.originalName} ${image.orderKey}")
            }

        }
        Files.write(outPutFile, lines)
    }
}
