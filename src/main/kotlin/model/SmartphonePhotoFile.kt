package org.iesra.model

class SmartphonePhotoFile (
    originalName: String
) : PhotoFile(originalName){


    override var orderKey = orderKeySmartphonePhotos(originalName)

    private fun orderKeySmartphonePhotos(name: String): String {
            var partes = name.substringAfter("IMG").split("_")
            var orderKey = partes[0] + partes[1]
            return orderKey
    }


}
