package br.com.bookmanagement.data.local.typeconverter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListStringConverter {
    @TypeConverter
    fun fromList(value: List<String>) = Json.encodeToString<List<String>>(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<String>>(value)
}