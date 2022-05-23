package com.example.moviemania.home.model

data class MovieModel(
    val title: String,
    val image: String,
    val episode: String? = null
) {
    companion object {
        val list = arrayListOf(
            MovieModel("Captain Marvel", "https://s3.amazonaws.com/com.marvel.terrigen/prod/captainmarvel_lob_crd_06.jpg"),
            MovieModel("Venom", "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/venom_onesheet_1400x2100_rated.png?itok=0tO6umMg"),
            MovieModel("Spider Man", "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_.jpg"),
        )
    }
}
