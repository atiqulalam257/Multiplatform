package com.atiq.mp.permission

import com.atiq.mp.permission.PermissionStatus

internal interface PermissionDelegate {
    fun requestPermission(onPermissionResult: (PermissionStatus) -> Unit)
    suspend fun getPermissionStatus(): PermissionStatus
}
