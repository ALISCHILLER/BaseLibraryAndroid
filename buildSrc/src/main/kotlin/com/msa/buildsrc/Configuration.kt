

package com.msa.buildsrc

object Configuration {
  const val compileSdk = 32
  const val targetSdk = 32
  const val minSdk = 16
  const val minSdkDemo = 21
  const val majorVersion = 1
  const val minorVersion = 2
  const val patchVersion = 6
  const val versionName = "$majorVersion.$minorVersion.$patchVersion"
  const val versionCode = 18
  const val snapshotVersionName = "$majorVersion.$minorVersion.${patchVersion + 1}-SNAPSHOT"
  const val artifactGroup = "com.github.AliSoleimani"
}
