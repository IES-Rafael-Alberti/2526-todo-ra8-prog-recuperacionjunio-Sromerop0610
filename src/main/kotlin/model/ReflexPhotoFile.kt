package org.iesra.model

class ReflexPhotoFile(
    var orderKey: String
) {
    fun buildValidReflexPhotos(names: List<String>): List<ReflexPhotoFile> {
        var smartPhotos = mutableListOf<SmartphonePhotoFile>()
        names.forEach { name ->
            var partes = name.substringAfter("IMG").split("_")
            var orderKey = partes[0] + partes[1]
            smartPhotos.add(SmartphonePhotoFile(name))
        }

        return smartPhotos
    }
}