package info.javaway.spend_sense.settings.auth.signin.model

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val identifier: String,
    val password: String,
)
