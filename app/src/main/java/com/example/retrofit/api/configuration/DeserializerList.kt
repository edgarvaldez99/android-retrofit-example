package com.example.retrofit.api.configuration

import com.google.gson.*
import java.lang.reflect.Type

class DeserializerList<T> : JsonDeserializer<T> {

    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, type: Type, jdc: JsonDeserializationContext): T {
        // Get the "data" element from the parsed JSON
        val data = je.asJsonObject
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return Gson().fromJson<T>(data, type)
    }
}
