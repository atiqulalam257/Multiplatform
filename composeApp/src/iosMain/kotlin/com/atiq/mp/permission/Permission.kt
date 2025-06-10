package com.atiq.mp.permission

import com.atiq.mp.permission.delegate.AVCapturePermissionDelegate
import com.atiq.mp.permission.delegate.AlwaysGrantedPermissionDelegate
import com.atiq.mp.permission.delegate.BluetoothPermissionDelegate
import com.atiq.mp.permission.delegate.GalleryPermissionDelegate
import com.atiq.mp.permission.delegate.LocationManagerDelegate
import com.atiq.mp.permission.delegate.LocationPermissionDelegate
import com.atiq.mp.permission.delegate.RemoteNotificationPermissionDelegate
import com.atiq.mp.permission.Permission
import platform.AVFoundation.AVMediaTypeAudio
import platform.AVFoundation.AVMediaTypeVideo

internal fun Permission.getDelegate(): PermissionDelegate {
    return when (this) {
        Permission.LOCATION,
        Permission.COARSE_LOCATION -> LocationPermissionDelegate(LocationManagerDelegate())

        Permission.RECORD_AUDIO -> AVCapturePermissionDelegate(AVMediaTypeAudio)
        Permission.CAMERA -> AVCapturePermissionDelegate(AVMediaTypeVideo)
        Permission.GALLERY -> GalleryPermissionDelegate()

        Permission.STORAGE, Permission.WRITE_STORAGE -> AlwaysGrantedPermissionDelegate()

        Permission.REMOTE_NOTIFICATION -> RemoteNotificationPermissionDelegate()

        Permission.BLUETOOTH_LE,
        Permission.BLUETOOTH_SCAN,
        Permission.BLUETOOTH_ADVERTISE,
        Permission.BLUETOOTH_CONNECT -> BluetoothPermissionDelegate()
    }
}
