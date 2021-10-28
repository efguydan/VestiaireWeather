# My Vestiaire Weather
[![Android CI](https://github.com/efguydan/VestiaireWeather/actions/workflows/android.yml/badge.svg)](https://github.com/efguydan/VestiaireWeather/actions/workflows/android.yml)
[![Download Sample](https://img.shields.io/badge/Download-v1.0.0-blue.svg)](https://github.com/efguydan/VestiaireWeather/raw/master/showcase/VestiaireWeather-1.0.0.apk)

My Vestiaire Weather is an app to view a list of Weather Forecast for 16 days

## App Screenshots
![Showcase](https://raw.githubusercontent.com/efguydan/VestiaireWeather/master/showcase/showcase.png)

## Dependencies
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for managing asynchronous operations
- JetPack
    - LiveData - notify domain layer data to views.
    - ViewModel - UI related data holder, lifecycle aware.
    - Room Persistence - database for the weather entities. for offline usage
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - Dagger 2 - Dependency Injection to manage and scope dependencies across the project.
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API to make API calls
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor and logging for the API calls
- [Mockito](https://github.com/mockito/mockito-kotlin) - For mocking dependencies behaviours during Unit Tests

## System Architecture



## Code Formatting

Code Formatting is done with the gradle spotless plugin, using [ktlint](https://github.com/pinterest/ktlint) as the linter. Other settings for the plugin can be configured in [spotless.gradle](spotless.gradle).
To format code, run

```gradle
./gradlew spotlessApply
```
