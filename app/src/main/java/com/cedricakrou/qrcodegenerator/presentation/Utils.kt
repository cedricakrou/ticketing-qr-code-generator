package com.cedricakrou.qrcodegenerator.presentation

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Point
import android.media.MediaScannerConnection
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.WriterException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

object Utils {

    private const val IMAGE_DIRECTORY = "/qrCodeGenerator/temp/"

    fun hideAndShowView( hide : View, show : View ) {
        hide.visibility = View.GONE
        show.visibility = View.VISIBLE
    }


    fun createQrCode(context: Context, message: String?): Bitmap? {
        var qrgEncoder: QRGEncoder? = null
        var bitmapQrCode: Bitmap? = null
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = manager.defaultDisplay
        val point = Point()
        display.getSize(point)
        val width = point.x
        val height = point.y
        var smallerDimension = if (width < height) width else height
        smallerDimension = smallerDimension * 3 / 4
        qrgEncoder = QRGEncoder(
            message, null,
            QRGContents.Type.TEXT,
            smallerDimension
        )
        try {
            bitmapQrCode = qrgEncoder.encodeAsBitmap()
        } catch (e: WriterException) {
            Log.v(" ceka ", e.toString())
        }
        return bitmapQrCode
    }

    fun saveImage(activity: Activity, myBitmap: Bitmap, number : Long): Boolean {

        if (ContextCompat.checkSelfPermission(
                activity.applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) === PackageManager.PERMISSION_GRANTED
        ) {
            val bytes = ByteArrayOutputStream()
            myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
            val wallpaperDirectory = File(
                Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOCUMENTS)
                    .toString() + IMAGE_DIRECTORY
            )
            // have the object build the directory structure, if needed.
            if (!wallpaperDirectory.exists()) {
                Log.d("dirrrrrr", "" + wallpaperDirectory.mkdirs())
                wallpaperDirectory.mkdirs()
            }
            try {
                val f = File(
                    wallpaperDirectory, number.toString() + ".jpg"
                )
                f.createNewFile() //give read write permission
                val fo = FileOutputStream(f)
                fo.write(bytes.toByteArray())
                MediaScannerConnection.scanFile(
                    activity,
                    arrayOf(f.path),
                    arrayOf("image/jpeg"),
                    null
                )
                fo.close()
                Log.d("TAG", "File Saved::--->" + f.absolutePath)
                Toast.makeText(activity, "Sauvegarde effectuée", Toast.LENGTH_SHORT)
                return true
            } catch (e1: IOException) {
                e1.printStackTrace()
                Toast.makeText(activity, "Sauvegarde echouée", Toast.LENGTH_SHORT)
            }
        } else {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                0
            )
        }
        return false
    }

}