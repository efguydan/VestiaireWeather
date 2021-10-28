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
    - Navigation - To manage destinations (fragments) & actions (navigations) 
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - Dagger 2 - Dependency Injection to manage and scope dependencies across the project.
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API to make API calls
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor and logging for the API calls
- [Mockito](https://github.com/mockito/mockito-kotlin) - For mocking dependencies behaviours during Unit Tests
- [Spotless](https://github.com/mockito/mockito-kotlin) - To format and fix code errors

## System Architecture

The Architecture used in the project is MVVM. Some reasons it was used include:
- MVVM does a very good job in separating concern. Data and User Interface know nothing about one another. The ViewModel handles all the logic and also
  knows nothing about the view. This eases the process of testing components as they are not couple tightly with one another.
- The ViewModel (used in implementing the MVVM architecture) is lifecycle-aware. This implies that it disposes of resources as soon as the fragment hosting
  it is destroyed, preventing Memory Leaks. It also survives configuration changes. Therefore user can have access to their current state when they undergo
  a configuration change.
  
The application consists a single activity hosting multiple fragments with a NavHostFragment. The Navigation Component is used to define destinations and actions.

Dependencies in the project are managed and scoped with Dependency Injection using Dagger2.

For persistence, Room Database was used.

View Binding is used to provide null safe references to view elements. Data Binding is also used in the project to bind UI elements to data sources in the 
view model in a lifecycle aware way.

## Code Formatting

Code Formatting is done with the gradle spotless plugin, using [ktlint](https://github.com/pinterest/ktlint) as the linter. Other settings for the plugin can be configured in [spotless.gradle](spotless.gradle).
To format code, run

```gradle
./gradlew spotlessApply
```
