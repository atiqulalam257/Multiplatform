package com.atiq.mp.domain.location

interface LocationRepository {
    suspend fun getCurrentLocation(): DeviceLocation
}
