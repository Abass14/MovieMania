package com.example.moviemania.home.model

import ARCANE

data class MovieModel(
    val title: String,
    val image: String,
    val episode: String? = null,
    val genre: String? = null,
    val description: String? = null
) {
    companion object {
        val list = arrayListOf(
            MovieModel("Arcane", ARCANE, "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
            MovieModel("Venom", "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/venom_onesheet_1400x2100_rated.png?itok=0tO6umMg", "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
            MovieModel("Spider Man", "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_.jpg", "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
            MovieModel("Arcane", ARCANE, "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
            MovieModel("Venom", "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/venom_onesheet_1400x2100_rated.png?itok=0tO6umMg", "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
            MovieModel("Spider Man", "https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_.jpg", "Episode 1", "Drama", "Peter Parker seeks Doctor Strange's help to make people forget about Spiderman's identity. However, when the spell he casts gets corrupted, several unwanted guests enter their universe."),
        )
    }
}
