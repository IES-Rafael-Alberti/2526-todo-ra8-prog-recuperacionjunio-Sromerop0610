package org.iesra.io

import org.iesra.model.TripInput
import java.nio.file.Files.readAllLines
import java.nio.file.Path

class InputFileReader {
    fun readInputFile(file: Path): TripInput {
        var content = readAllLines(file)

        require(content.size != 3){
            "Input file debe tener 3 elementos."
        }

        var destination = content[0].toString()
        var namesSmarthphone = content[1].split(" ")
        var namesReflex = content[2].split(" ")

        // TODO hacer validacion
        /*for (line in content) {
            namesSmarthphone = line
                .firstOrNull("")

         */

        return TripInput(
            destination,
            namesSmarthphone,
            namesReflex,
        )
    }
}