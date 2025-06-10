package com.atiq.mp.permission.delegate

import com.atiq.mp.permission.PermissionDelegate
import com.atiq.mp.permission.PermissionStatus

internal class AlwaysGrantedPermissionDelegate : PermissionDelegate {

    override fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit) {
        onPermissionResult(PermissionStatus.Granted)
    }

    override suspend fun getPermissionStatus(): PermissionStatus = PermissionStatus.Granted
}
