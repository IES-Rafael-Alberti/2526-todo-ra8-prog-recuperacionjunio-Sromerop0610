package org.iesra.service

import org.iesra.model.PhotoFile
import org.iesra.model.PhotoTypeStats
import org.iesra.model.ProcessingResult
import org.iesra.model.ReflexPhotoFile
import org.iesra.model.RenameCommand
import org.iesra.model.SmartphonePhotoFile
import org.iesra.model.TripInput
import kotlin.text.substringAfter
//string.format(
class PhotoProcessor {
    fun process(input: TripInput) : ProcessingResult{
        var commands = mutableListOf<RenameCommand>()

        var photosFile = buildValidSmartphonePhotos(input.namesSmartphone) + buildValidReflexPhotos(input.namesReflex)
        photosFile.sortedBy { it.orderKey }

        var index = 0
        photosFile.forEach { name ->
            var contador = String.format("%d3%", index)
            var newName = input.destination + "_" + contador + ".jpg"
            var command = "mv ${name.originalName} $newName"

            commands.add(RenameCommand(command, newName))
            index ++
        }

        var procesadosSmart = buildValidSmartphonePhotos(input.namesSmartphone).size
        var noProcesadosSmart = input.namesSmartphone.size - procesadosSmart

        var procesadosReflex = buildValidReflexPhotos(input.namesSmartphone).size
        var noProcesadosReflex = input.namesReflex.size - procesadosSmart

        return ProcessingResult(
            commands,
            PhotoTypeStats(
                buildValidReflexPhotos(input.namesSmartphone).size,
                procesadosReflex,
                noProcesadosReflex
            ),
            PhotoTypeStats(
                buildValidSmartphonePhotos(input.namesSmartphone).size,
                procesadosSmart,
                noProcesadosSmart
            ),
            procesadosSmart + procesadosReflex
        )
    }

    fun buildValidSmartphonePhotos(namesSmartphone: List<String>): List<SmartphonePhotoFile> {
        var photos = mutableListOf<SmartphonePhotoFile>()
        namesSmartphone.forEach { name ->
            var parserName = name.substringAfter("IMG").substringBefore(".jpg")
            var parts = parserName.split("_")
            var contName = listOf(parserName)
            var parseAnioMesDia = listOf(contName[1])
            var parseHourMinuteSeconds = listOf(contName[3])
            var originalName = contName[1] + contName[3]

            if (name.startsWith("IMG") && name.endsWith(".jpg") && parts.size == 4 && parts[0] == "_" && parts[2] == "_" && parseAnioMesDia.size == 8 && parseHourMinuteSeconds.size == 6) {
                photos.add(SmartphonePhotoFile(name))
            }
        }
        return photos
    }

    fun buildValidReflexPhotos(namesSmartphone: List<String>): List<ReflexPhotoFile> {
        var photos = mutableListOf<ReflexPhotoFile>()
        namesSmartphone.forEach { name ->
            var parserName = name.substringAfter("P").substringBefore(".jpg")
            var parts = parserName.split("_")
            var contName = listOf(parserName)
            var parseAnioMesDia = listOf(contName[0])
            var parseHourMinuteSeconds = listOf(contName[2])
            var originalName = contName[0] + contName[2]

            if (name.startsWith("IMG") && name.endsWith(".jpg") && parts.size == 3 && parts[1] == "_" && parseAnioMesDia.size == 8 && parseHourMinuteSeconds.size == 6) {
                photos.add(ReflexPhotoFile(name))
            }
        }
        return photos
    }
}