package com.atiq.mp.core

import com.atiq.mp.core.PlatformContext
import com.atiq.mp.domain.location.DeviceLocation
import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.MapKit.MKMapItem
import platform.MapKit.MKPlacemark


@OptIn(ExperimentalForeignApi::class)
actual fun navigateToMap(
    context: PlatformContext,
    deviceLocation: DeviceLocation?,
    destinationName: String
) {

    val coordinates = CLLocationCoordinate2DMake(deviceLocation?.latitude ?: 0.0, deviceLocation?.longitude ?: 0.0)
    val mapItem = MKMapItem(MKPlacemark(coordinates, null))
    mapItem.name = destinationName

    mapItem.openInMapsWithLaunchOptions(null)
}
