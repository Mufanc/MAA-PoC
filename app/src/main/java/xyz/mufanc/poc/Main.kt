package xyz.mufanc.poc

import android.graphics.ImageFormat
import android.hardware.display.DisplayManager
import android.hardware.display.DisplayManagerGlobal.VirtualDisplayCallback
import android.hardware.display.IDisplayManager
import android.hardware.display.VirtualDisplayConfig
import android.media.ImageReader
import android.os.Handler
import android.os.HandlerThread
import android.os.ServiceManager

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val builder = VirtualDisplayConfig.Builder("MAA@Virtual0", 1920, 1080, 600)
        builder.setFlags(DisplayManager.VIRTUAL_DISPLAY_FLAG_PRESENTATION)

        val dm = IDisplayManager.Stub.asInterface(ServiceManager.getService("display"))

        println("DisplayManager: $dm")

        val imageReader = ImageReader.newInstance(1920, 1080, ImageFormat.JPEG, 1)
        var count = 0

        builder.setSurface(imageReader.surface)

        val callback = VirtualDisplayCallback(null, null)
        val displayId = dm.createVirtualDisplay(builder.build(), callback, null, "android")

        println("displayId: $displayId")

        val worker = HandlerThread("screen")
        worker.start()

        imageReader.setOnImageAvailableListener({ reader ->
            val image = reader.acquireNextImage()
            if (image != null) {
                count += 1
                print("\r[ $count ] $image")

                // do something

                image.close()
            }
        }, Handler(worker.looper))

        worker.join()
    }
}
