# 👋🧩 Tuga Morphe Patches

Community Morphe patches for RTP Play Android TV app.

## ❓ About

Currently includes a patch for **RTP Play (Android TV)** that disables the client-requested
pre-roll VAST ad for both on-demand and live TV playback.

### How to use these patches

Click here to add these patches to Morphe: https://morphe.software/add-source?github=DavidRomao/tuga-morphe-patches

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.0.0-dev.1](https://github.com/DavidRomao/tuga-morphe-patches/releases/tag/v1.0.0-dev.1)**&nbsp;&nbsp;•&nbsp;&nbsp;`dev`&nbsp;&nbsp;•&nbsp;&nbsp;1 patches total
<details open>
<summary>📦 RTP Play&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.0.70 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable ads](#disable-ads) | Disables the pre-roll ad request for both on-demand and live TV playback. |  |

</details>

<!-- PATCHES_END -->

### 🛠️ Building locally

- Run `./gradlew buildAndroid`
- The built patches .mpp file is found in `patches/build/libs/patches-*.mpp`
- Patch the mpp file using [Morphe-Desktop](https://github.com/MorpheApp/morphe-desktop)
  like any other patch bundle.

See the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation) for more information.

## 📜 License

Tuga Morphe Patches are licensed under the [GNU General Public License v3.0](LICENSE)
