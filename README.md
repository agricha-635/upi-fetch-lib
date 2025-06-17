# UPI Fetch Lib


A simple Android library to detect installed UPI apps on the user's device.

---

## ✨ Features

- Detect UPI apps like PhonePe, Paytm, GPay, etc.
- Easily open UPI apps via package name
- Lightweight and fast

---

## 🔧 How to Use

### 1. Add JitPack to your root `settings.gradle.kts`

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
