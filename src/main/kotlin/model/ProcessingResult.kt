package org.iesra.model

data class ProcessingResult(
    var commands: List<String>,
    var reflexStats: PhotoTypeStats,
    var smartphoneStats: PhotoTypeStats,
    var totalCorrectPhotos: Int
)
