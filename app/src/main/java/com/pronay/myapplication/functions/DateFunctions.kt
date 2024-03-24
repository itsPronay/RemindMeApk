import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


const val dateFormat = "dd-MM-yyyy"

fun milliSecondsToDate(milliseconds: Long?): String {
    val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
    val date = Date(milliseconds ?: System.currentTimeMillis())
    return sdf.format(date)
}

fun dateToMilliseconds(dateString: String): Long {
    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    sdf.timeZone = TimeZone.getTimeZone("GMT")
    val date = sdf.parse(dateString)
    return date?.time ?: System.currentTimeMillis()
}