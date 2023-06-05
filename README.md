# MAA-PoC

## Usage

* 拉取代码并编译

* 推送 apk 到设备

```shell
adb push app/build/outputs/apk/debug/app-debug.apk /data/local/tmp
```

* 运行 app_process

```shell
> adb shell
diting:/ $ app_process64 -Djava.class.path=/data/local/tmp/app-debug.apk /system/bin xyz.mufanc.poc.Main
DisplayManager: android.hardware.display.IDisplayManager$Stub$Proxy@96d91a1
displayId: 2
[ 1 ] android.media.ImageReader$SurfaceImage@98c3fc6
```

* 开启 scrcpy 投屏

```shell
scrcpy --display=2
```

* 启动游戏到虚拟屏

```shell
adb shell am start --display 2 -n com.hypergryph.arknights/com.u8.sdk.U8UnityContext
```
