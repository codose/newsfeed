# News Feed
## Features 🎨

- **100% Kotlin-only project**.
- Coroutine, Jetpack compose, Hilt, Flow, AndroidX,MVVM, Junit Tests.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- CI Setup with GitHub Actions.
- Kotlin Static Analysis via `ktlint`.

## Gradle Setup 🐘

This project is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [buildSrc](buildSrc/src/main/kotlin) folder. This provides convenient auto-completion when writing your gradle files.

## Static Analysis 🔍

This project is using [**ktlint**](https://github.com/pinterest/ktlint) to format your code. To reformat all the source code as well as the buildscript you can run
```bash
# Run lint and display issues
./gradlew ktlintCheck
```


To fix the issues, run:
```bash
# Run lint and try to fix issues automatically (not all issues are fixable this way)
./gradlew ktlintFormat
```

## CI ⚙️

There are currently the following workflows available:
- [Android Pull Request & Master CI](.github/workflows/workflow.yml) - Will run the `build`, `check` and `assembleDebug` tasks.

## How To Build
Pull the code on this branch, import into Android Studio, from there you can run it like a standard
android project project or run ./gradlew assembleDebug. Further notes can be found here https://developer.android.com/studio/build/building-cmdline#DebugMode

## Screenshots
<img src="screenshots/1.png" width="30%" height="30%" alt="Screenshot 1">
<img src="screenshots/2.png" width=30% height=30% alt="Screenshot 2">
<img src="screenshots/3.png" width=30% height=30% alt="Screenshot 3">
<img src="screenshots/4.png" width=30% height=30% alt="Screenshot 4">