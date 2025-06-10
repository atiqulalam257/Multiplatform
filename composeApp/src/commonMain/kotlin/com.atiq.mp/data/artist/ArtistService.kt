package com.atiq.mp.data.artist

interface ArtistService {

    suspend fun artistDetail(personId: Int): ArtistDetailModel

    suspend fun artistCredit(personId: Int): ArtistCreditsModel
}
