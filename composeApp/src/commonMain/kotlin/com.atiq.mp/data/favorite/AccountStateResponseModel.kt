package com.atiq.mp.data.favorite

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class AccountStateResponseModel(
    val favorite: Boolean?,
    val id: Int?,
    @Serializable(RatingDeserializer::class) val rated: Float?,
    val watchlist: Boolean?,
)

@Serializable
data class Rated(
    val value: Float?,
)

private object RatingDeserializer : KSerializer<Float?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("rating", PrimitiveKind.FLOAT)

    override fun deserialize(decoder: Decoder): Float? {
        val input = decoder as? JsonDecoder
            ?: throw SerializationException("Expected JsonDecoder")

        val element = input.decodeJsonElement()
        return when (element) {
            is JsonObject -> element["value"]?.jsonPrimitive?.floatOrNull
            is JsonPrimitive -> null // Handles the case where it's just "false"
            else -> null
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Float?) {
        // Optional: Implement if needed
        if (value == null) {
            encoder.encodeNull()
        } else {
            encoder.encodeFloat(value)
        }
    }
}


/*
private object RatingDeserializer : KSerializer<Float?> {
    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): Float? {
        return try {
            decoder.decodeBoolean()
            null
        } catch (e: Exception) {
            val rated = decoder.decodeNullableSerializableValue(Rated.serializer())
            rated?.value
        }
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("rating", PrimitiveKind.FLOAT)

    override fun serialize(encoder: Encoder, value: Float?) {
    }
}*/
