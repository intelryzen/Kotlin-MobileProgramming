package com.example.week10.example05

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.net.toUri
import com.example.week10.functions.makeCall
import com.example.week10.functions.showCamera
import com.example.week10.uicomponents.RationaleDialog
import com.example.week10.uicomponents.SettingsDialog

@Composable
fun MainScreen05(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val activity = context as Activity

    val permissions = arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA)

    var showRationaleDialog by remember { mutableStateOf(false) }
    var showSettingDialog by remember { mutableStateOf(false) }
    var showRationaleCheck by remember { mutableStateOf(false) }
    var showSettingsCheck by remember { mutableStateOf(false) }

    val requestMultiplePermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) {
        when {
            it.all { map -> map.value } -> {
                Toast.makeText(context, "모든 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
            }

            shouldShowRequestPermissionRationale(
                activity,
                it.keys.first()
            ) || shouldShowRequestPermissionRationale(activity, it.keys.last())
                -> {
                showRationaleCheck = true
            }

            else -> {
                showSettingsCheck = true
            }
        }
    }

    fun requestPermissions() {
        when {
            permissions.all { permission ->
                checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
            } -> {
                Toast.makeText(context, "모든 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
            }


            showRationaleCheck -> {
                showRationaleDialog = true
            }

            showSettingsCheck -> {
                showSettingDialog = true
            }

            else -> {
                requestMultiplePermissionLauncher.launch(permissions)
            }
        }
    }

    fun callPhonePermissionGranted() =
        checkSelfPermission(
            context,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED

    fun cameraPermissionGranted() =
        checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    LaunchedEffect(Unit) {
        requestPermissions()
    }

    if (showRationaleDialog) {
        RationaleDialog(
            onDismiss = {
                showRationaleDialog = false
            },
            onConfirm = {
                showRationaleDialog = false
                showRationaleCheck = false
                requestMultiplePermissionLauncher.launch(permissions)
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

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Button(onClick = {
//            val web = Uri.parse("https://www.naver.com")
//            val webIntent = Intent(Intent.ACTION_VIEW, web)
            val webIntent = Intent(Intent.ACTION_VIEW).apply {
                data = "https://www.naver.com".toUri()
            }
            context.startActivity(webIntent)

        }, modifier = Modifier.width(200.dp)) {
            Text("네이버")
        }

        Button(onClick = {
            val location = "geo:37.543684,127.077130?z=16".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            context.startActivity(mapIntent)
        }, modifier = Modifier.width(200.dp)) {
            Text("맵")
        }

        Button(onClick = {
            val message = "sms:010-1234-1234".toUri()
            val messageIntent = Intent(Intent.ACTION_SENDTO, message)
            messageIntent.putExtra("sms_body", "집에 가자....")
            context.startActivity(messageIntent)
        }, modifier = Modifier.width(200.dp)) {
            Text("문자보내기")
        }

        Button(onClick = {
            if (callPhonePermissionGranted()) {
                makeCall(context)
            } else {
                requestPermissions()
            }
        }, modifier = Modifier.width(200.dp)) {
            Text("전화걸기")
        }


        Button(onClick = {
            if (cameraPermissionGranted()) {
                showCamera(context)
            } else {
                requestPermissions()
            }
        }, modifier = Modifier.width(200.dp)) {
            Text("카메라")
        }

//        Button(onClick = {
//            val number = Uri.parse("tel:010-1234-1234")
//            val callIntent = Intent(Intent.ACTION_CALL, number)
//            context.startActivity(callIntent)
//        }, modifier = Modifier.width(200.dp)) {
//            Text("전화걸기")
//        }
    }
}

@Preview
@Composable
private fun MainScreen04Preview() {
    MainScreen05()
}