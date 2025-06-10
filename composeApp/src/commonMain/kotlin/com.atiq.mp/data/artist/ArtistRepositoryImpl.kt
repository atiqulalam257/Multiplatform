package com.example.moveeapp_compose_kmm.data.artist

import com.atiq.mp.data.artist.ArtistService
import com.atiq.mp.domain.artist.ArtistCredit
import com.atiq.mp.domain.artist.ArtistDetail
import com.atiq.mp.domain.artist.ArtistRepository
import com.atiq.mp.utils.resultOf

class ArtistRepositoryImpl(
    private val service: ArtistService
) : ArtistRepository {

    override suspend fun getArtistDetail(personId: Int): Result<ArtistDetail> {
        return resultOf {
            service.artistDetail(personId).toDomain()
        }
    }

    override suspend fun getArtistCredits(personId: Int): Result<List<ArtistCredit>> {
        return resultOf {
            service.artistCredit(personId).cast?.map { it.toDomain() } ?: listOf()
        }
    }
}
