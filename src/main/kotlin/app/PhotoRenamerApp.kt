package org.iesra.app

import org.iesra.cli.ArgumentParser
import org.iesra.io.InputFileReader
import org.iesra.io.ScriptWriter
import org.iesra.service.PhotoProcessor
import java.nio.file.Path

class PhotoRenamerApp {

    fun run(inputPath: Path) {
        var readFile = InputFileReader()
        var processor = PhotoProcessor()

        // Leer el fichero de entrada ya validado por ArgumentParser.
        // Validar el formato general del fichero y construir el objeto TripInput.

        var tripInput = readFile.readInputFile(inputPath)

        // Procesar las fotos validas y generar el resultado con comandos y estadisticas.

        var processingResult = processor.process(tripInput)

        // Escribir el script <lugar>.sh con los comandos mv generados.
        ScriptWriter().write(inputPath, tripInput.destination, processingResult.commands)

        // Mostrar por consola el resumen de fotos leidas, correctas y erroneas.

    }
}
