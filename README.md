# Field
<https://play.google.com/store/apps/details?id=pgm.poolp.ugcanvas>

A Jetpack compose app using Sports Martial Arts icons to run on the field.

Libraries and components used
--------------
* [Realtime Database][0] - Store and sync our field board in a cloud.
* [Kotlin flows][1] - Using [callbackflow][2] to listen to Realtime Database and return Flow type.
* [ViewModel][3] - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
* [Moshi][5] - It makes it easy to parse JSON into Kotlin classes.

[0]: https://firebase.google.com/docs/database?hl=en
[1]: https://developer.android.com/kotlin/flow
[2]: https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/callback-flow.html
[3]: https://developer.android.com/topic/libraries/architecture/viewmodel
[5]: https://github.com/square/moshi

