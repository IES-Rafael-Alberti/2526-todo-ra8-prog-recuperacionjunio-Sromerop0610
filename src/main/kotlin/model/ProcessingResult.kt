package org.iesra.model

data class ProcessingResult(
    var commands: List<RenameCommand>,
    var reflexStats: PhotoTypeStats,
    var smartphoneStats: PhotoTypeStats,
    var totalCorrectPhotos: Int
)
