package org.iesra.model

class ReflexPhotoFile (
    originalName: String
) : PhotoFile(originalName){

    override var orderKey = orderKeyReflexPhotos(originalName)

    private fun orderKeyReflexPhotos(name: String): String {
        var partes = name.substringAfter("P").split("_")
        var anioMesDia = listOf(partes[0])
        var anio = "20" + anioMesDia[4] + anioMesDia[5]
        var mes = anioMesDia[2] + anioMesDia[3]
        var dia = anioMesDia[1] + anioMesDia[2]

        var orderKey = anio+mes+dia+partes[2]

        return orderKey
    }
}