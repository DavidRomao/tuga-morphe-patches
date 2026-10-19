package pt.tuga.morphepatches.rtpplay.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    /**
     * RTP Play - Android TV.
     *
     * Source file distributed as an Android App Bundle (.apkm on APKMirror), with a
     * base.apk plus arm64_v8a / armeabi_v7a ABI splits. All three files share the same
     * versionCode (1070), confirmed via `aapt dump badging` on each split, so no
     * per-ABI versionCode map is required.
     */
    val COMPATIBILITY_RTP_PLAY = Compatibility(
        name = "RTP Play",
        packageName = "pt.rtp.play",
        apkFileType = ApkFileType.APKM,
        // Primary brand color used throughout the RTP Play config/UI.
        appIconColor = 0x0074FF,
        targets = listOf(
            AppTarget(
                version = "1.0.70"
            )
        )
    )
}
