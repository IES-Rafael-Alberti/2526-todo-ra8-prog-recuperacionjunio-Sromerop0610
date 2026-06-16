package org.iesra.service

import org.iesra.model.PhotoFile
import org.iesra.model.ProcessingResult
import org.iesra.model.ReflexPhotoFile
import org.iesra.model.SmartphonePhotoFile
import org.iesra.model.TripInput
import kotlin.text.substringAfter

class PhotoProcessor {
    fun process(input: TripInput) : ProcessingResult{
        var commands = mutableListOf<String>()

        var photosFile = buildValidSmartphonePhotos(input.namesSmartphone) + buildValidReflexPhotos(input.namesReflex)
        photosFile.sortedBy { it.orderKey }

        var index = 0
        photosFile.forEach {
            var command = input.destination + "00$index"
        }
        return ProcessingResult()
    }

    fun buildValidSmartphonePhotos(names: List<String>): List<PhotoFile> {
        var smartPhotos = mutableListOf<PhotoFile>()
        names.forEach { name ->
            var partes = name.substringAfter("IMG").split("_")
            var orderKey = partes[0] + partes[1]
            smartPhotos.add(PhotoFile(
                name,
                orderKey
            ))
        }

        return smartPhotos
    }

    fun buildValidReflexPhotos(names: List<String>): List<PhotoFile> {
        var reflexPhotos = mutableListOf<PhotoFile>()

        names.forEach { name ->
            var partes = name.substringAfter("P").split("_")
            var anioMesDia = listOf(partes[0])
            var anio = "20" + anioMesDia[4] + anioMesDia[5]
            var mes = anioMesDia[2] + anioMesDia[3]
            var dia = anioMesDia[1] + anioMesDia[2]

            var orderKey = anio+mes+dia+partes[2]
            reflexPhotos.add(PhotoFile(
                name,
                orderKey
            ))
        }
    }
}