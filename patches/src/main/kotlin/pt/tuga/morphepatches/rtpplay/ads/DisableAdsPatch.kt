package pt.tuga.morphepatches.rtpplay.ads

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import pt.tuga.morphepatches.rtpplay.shared.Constants.COMPATIBILITY_RTP_PLAY

/**
 * Disables the client-requested VAST pre-roll ad for both on-demand (VOD) and live TV
 * playback in RTP Play.
 *
 * RTP Play fetches a remote config (`config_tv_android_all_in_one.json`) containing an
 * `android_tv_ads_url` Google Ad Manager / DoubleClick VAST ad tag template. Both
 * `PlaybackActivity` (VOD) and `PlaybackStreamActivity` (live TV) resolve this template
 * into a final ad tag URL via a small helper method, then attach it to the ExoPlayer/media3
 * `MediaItem` as an ads configuration.
 *
 * This patch overrides both helper methods to unconditionally return `null`, so no ads
 * configuration is ever attached and no pre-roll ad is requested, regardless of the
 * `ads_url` value supplied by the app or its remote config.
 *
 * See [VodAdTagUrlFingerprint] and [LiveAdTagUrlFingerprint] for how the target methods
 * are located.
 */
@Suppress("unused")
val disableAdsPatch = bytecodePatch(
    name = "Disable ads",
    description = "Disables the pre-roll ad request for both on-demand and live TV playback.",
    default = true
) {
    compatibleWith(COMPATIBILITY_RTP_PLAY)

    execute {
        listOf(VodAdTagUrlFingerprint, LiveAdTagUrlFingerprint).forEach { fingerprint ->
            fingerprint.method.addInstructions(
                0,
                """
                    const/4 v0, 0x0
                    return-object v0
                """
            )
        }
    }
}
