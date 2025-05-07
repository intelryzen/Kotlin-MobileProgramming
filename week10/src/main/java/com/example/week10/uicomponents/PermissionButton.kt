package com.example.week10.uicomponents

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.net.toUri

@Composable
fun PermissionButton(
    permission: String,
    label: String,
    onGranted: () -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val activity = context as Activity

    var showCallDialog by remember { mutableStateOf(false) }
    var showSettingDialog by remember { mutableStateOf(false) }
    var showRationaleCheck by remember { mutableStateOf(false) }
    var showSettingsCheck by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            onGranted()
        } else {
            val shouldShowRationale = shouldShowRequestPermissionRationale(activity, permission)

            if (shouldShowRationale) {
                showRationaleCheck = true
            } else {
                showSettingsCheck = true
            }
        }
    }

    fun requestPermission() {
        when {
            checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED -> {
                onGranted()
            }

            showRationaleCheck -> {
                showCallDialog = true
            }

            showSettingsCheck -> {
                showSettingDialog = true
            }

            else -> {
                launcher.launch(permission)
            }
        }
    }

    if (showCallDialog) {
        RationaleDialog(
            onDismiss = {
                showCallDialog = false
            },
            onConfirm = {
                showCallDialog = false
                launcher.launch(permission)
            }
        )
    }

    if (showSettingDialog) {
        SettingsDialog(
            onDismiss = {
                showSettingDialog = false
            },
            onGoToSettings = {
                showSettingDialog = false

                val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                ).apply {
                    data = "package:${context.packageName}".toUri()
                }
                context.startActivity(intent)
            }
        )
    }

    Button(onClick = {
        requestPermission()
    }, modifier = Modifier.width(200.dp)) {
        Text(label)
    }


}