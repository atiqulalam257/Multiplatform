package com.atiq.mp.domain.location

data class DeviceLocation(
    val latitude: Double,
    val longitude: Double,
    val zoom: Float = 10f
) {
    override fun toString(): String {
        return "$latitude,$longitude"
    }
}
