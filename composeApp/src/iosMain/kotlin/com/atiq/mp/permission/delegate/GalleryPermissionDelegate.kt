package com.atiq.mp.permission.delegate

import com.atiq.mp.permission.PermissionDelegate
import com.atiq.mp.permission.PermissionStatus
import platform.Photos.PHAuthorizationStatus
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHAuthorizationStatusDenied
import platform.Photos.PHAuthorizationStatusNotDetermined
import platform.Photos.PHPhotoLibrary

internal class GalleryPermissionDelegate : PermissionDelegate {

    override fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit) {
        PHPhotoLibrary.requestAuthorization { onPermissionResult(it.toCommonStatus()) }
    }

    override suspend fun getPermissionStatus(): PermissionStatus {
        return PHPhotoLibrary.authorizationStatus().toCommonStatus()
    }
}

private fun PHAuthorizationStatus.toCommonStatus(): PermissionStatus {
    return when (this) {
        PHAuthorizationStatusAuthorized -> PermissionStatus.Granted
        PHAuthorizationStatusNotDetermined -> PermissionStatus.NotDetermined
        PHAuthorizationStatusDenied -> PermissionStatus.Denied(true)
        else -> error("unknown gallery authorization status $this")
    }
}

