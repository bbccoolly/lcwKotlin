package com.lcw.kt.data

import androidx.room.TypeConverter
import com.lcw.kt.room.Urls
import com.lcw.kt.room.User
import org.json.JSONObject
import java.util.*


/**
 *
 * desc: Type converters to allow Room to reference complex data types.
 *
 * create by lcz on 2021/9/24
 */
class Converters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }

    @TypeConverter
    fun fromString(stringListString: String): List<String> {
        return stringListString.split(",").map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>): String {
        return stringList.joinToString(separator = ",")
    }

    @TypeConverter
    fun fromSource1(source: Urls): String {
        return JSONObject().apply {
            put("small", source.small)
        }.toString()
    }

    @TypeConverter
    fun toSource1(source: String): Urls {
        val json = JSONObject(source)
        return Urls(json.get("small").toString())
    }

    @TypeConverter
    fun fromSource2(source: User): String {
        return JSONObject().apply {
            put("username", source.username)
        }.toString()
    }

    @TypeConverter
    fun toSource2(source: String): User {
        val json = JSONObject(source)
        return User(json.get("username").toString())
    }
}