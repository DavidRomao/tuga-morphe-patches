package pt.tuga.morphepatches.rtpplay.ads

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall

/**
 * Both [VodAdTagUrlFingerprint] and [LiveAdTagUrlFingerprint] match a small, no-argument
 * `String` builder method that fills in the `[placeholder]` / `[correlator]` macros of the
 * remote `android_tv_ads_url` VAST ad tag template (fetched from RTP's
 * `config_tv_android_all_in_one.json` remote config) and returns the final ad tag URL.
 *
 * The returned URL is passed into `androidx.leanback.transition.e.g(Uri, int, ArrayList,
 * String)`, which builds the ExoPlayer/media3 `MediaItem` played by the activity. When the
 * ad tag URL argument is null, no `MediaItem.AdsConfiguration` is attached, and no pre-roll
 * ad is ever requested.
 *
 * Both methods are identified only by their call to the (app-wide unique) template
 * substitution helper `Lag/d;->b(...)`, not by their own (unobfuscated, but unstable
 * across updates) names, nor by any local register numbers at their call sites. This
 * keeps the fingerprint resilient to app updates that might renumber registers or inline
 * code at the call sites, as long as the ad tag URL is still built the same way.
 */
private val AD_TAG_TEMPLATE_SUBSTITUTION_CALL = methodCall(
    smali = "Lag/d;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;"
)

/**
 * Matches `Lpt/rtp/play/PlaybackActivity;->E()Ljava/lang/String;`, which builds the ad tag
 * URL used before on-demand (VOD) episode playback.
 */
object VodAdTagUrlFingerprint : Fingerprint(
    definingClass = "Lpt/rtp/play/PlaybackActivity;",
    returnType = "Ljava/lang/String;",
    parameters = emptyList(),
    filters = listOf(AD_TAG_TEMPLATE_SUBSTITUTION_CALL)
)

/**
 * Matches `Lpt/rtp/play/PlaybackStreamActivity;->D()Ljava/lang/String;`, which builds the
 * ad tag URL used before live TV channel playback.
 */
object LiveAdTagUrlFingerprint : Fingerprint(
    definingClass = "Lpt/rtp/play/PlaybackStreamActivity;",
    returnType = "Ljava/lang/String;",
    parameters = emptyList(),
    filters = listOf(AD_TAG_TEMPLATE_SUBSTITUTION_CALL)
)
