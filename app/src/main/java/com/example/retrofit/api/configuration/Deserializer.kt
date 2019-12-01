package com.example.retrofit.api.configuration

import com.google.gson.*
import java.lang.reflect.Type

class Deserializer<T> : JsonDeserializer<T> {

    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): T {
        // Get the "content" element from the parsed JSON
        val content = je.asJsonObject.get("data")
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return Gson().fromJson<T>(content, type)
    }
}
