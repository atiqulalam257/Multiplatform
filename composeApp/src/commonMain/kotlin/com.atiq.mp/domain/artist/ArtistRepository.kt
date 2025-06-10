package com.atiq.mp.domain.artist

interface ArtistRepository {

    suspend fun getArtistDetail(personId: Int): Result<ArtistDetail>

    suspend fun getArtistCredits(personId: Int): Result<List<ArtistCredit>>
}
