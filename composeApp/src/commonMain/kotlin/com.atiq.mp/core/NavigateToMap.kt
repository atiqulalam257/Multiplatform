package com.atiq.mp.core

import com.atiq.mp.domain.location.DeviceLocation


expect fun navigateToMap(context: PlatformContext, deviceLocation: DeviceLocation?, destinationName: String = "")