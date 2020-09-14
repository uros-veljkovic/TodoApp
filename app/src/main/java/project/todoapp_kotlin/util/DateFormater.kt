package project.todoapp_kotlin.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormater {

    fun toDate(timeInMillis: Long): String{
        val date = Date(timeInMillis)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy.")
        return simpleDateFormat.format(date)
    }

    fun toLong(date: String) : Long{
        val sdf = SimpleDateFormat("dd.MM.yyyy.")
        return sdf.parse(date).time
    }

}