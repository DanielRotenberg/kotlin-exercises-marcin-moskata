@file:Suppress("KotlinConstantConditions")

package essentials.conditions

import org.junit.Test
import kotlin.test.assertEquals

const val MINUTE = 60
const val HOUR = 3600
const val SECONDS = 60

val Int.minutes get() = this / SECONDS
val Int.seconds get() = this % SECONDS

fun secondsToPrettyTime(seconds: Int): String {
    return when {
        seconds.negative -> "Invalid input"
        seconds.zero -> "Now"
        seconds.secondsOnly() -> "$seconds sec"
        seconds.oneMinute() -> "1 min"
        seconds.greaterThanMinuteNoHours() -> seconds.minutesAndSeconds()
        seconds.includeHours() -> seconds.hoursMinutesSeconds()
        else -> "Invalid input"
    }
}

fun Int.secondsOnly() = toString().length == 2 && this < 60

fun Int.oneMinute(): Boolean {
    return this == 60
}

val Int.negative get() = this < -0

val Int.zero get() = this == 0

fun Int.greaterThanMinuteNoHours() = this in (61 until 3600)

fun Int.minutesAndSeconds(): String {
    val minutes = this / 60
    val seconds = this % 60
    return "$minutes min $seconds sec"
}

fun Int.includeHours() = this >= 3600

fun Int.hoursMinutesSeconds(): String {
    val hours = this / 3600
    val minutesInSeconds = this % 3600
    val minutes = minutesInSeconds / 60
    val seconds = minutesInSeconds % 60
    return when {
        roundHours() -> "$hours h"
        hoursSecondsNoMinutes() -> "$hours h $seconds sec"
        minutes > 0 -> {
            "$hours h $minutes min $seconds sec"
        }

        else ->
            "$hours h $seconds sec"
    }
}

fun Int.roundMinutes() = this % 60 == 0

fun Int.roundHours() = this % 3600 == 0

fun Int.hoursSecondsNoMinutes() = this > 3600 && !roundHours() && roundMinutes()


fun main() {
    println(secondsToPrettyTime(-1)) // Invalid input -> done
    println(secondsToPrettyTime(0)) // Now -> done
    println(secondsToPrettyTime(45)) // 45 sec -> done
    println(secondsToPrettyTime(60)) // 1 min -> done
    println(secondsToPrettyTime(150)) // 2 min 30 sec -> done
    println(secondsToPrettyTime(1410)) // 23 min 30 sec -> done
    println(secondsToPrettyTime(60 * 60)) // 1 h -> done
    println(secondsToPrettyTime(3665)) // 1 h 1 min 5 sec
}

class PrettyTimeTest {

    @Test
    fun testNegativeSeconds() {
        val seconds = -1
        val expected = "Invalid input"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testOnlySeconds() {
        val seconds = 45
        val expected = "45 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testOnlyMinutes() {
        val seconds = 60
        val expected = "1 min"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testMinutesAndSeconds() {
        val seconds = 150
        val expected = "2 min 30 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testMinutesAndSecondsWithRemainder() {
        val seconds = 1410
        val expected = "23 min 30 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testOnlyHours() {
        val seconds = 3600
        val expected = "1 h"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testHoursMinutesAndSeconds() {
        val seconds = 3665
        val expected = "1 h 1 min 5 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testZeroSeconds() {
        val seconds = 0
        val expected = "Now"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testHoursMinutesSecondsWithZeroMinutes() {
        val seconds = 3605
        val expected = "1 h 5 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testHoursMinutesWithZeroSeconds() {
        val seconds = 7200
        val expected = "2 h"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testMinutesSecondsWithZeroHours() {
        val seconds = 150
        val expected = "2 min 30 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }

    @Test
    fun testLargeValue() {
        val seconds = 123456789
        val expected = "34293 h 33 min 9 sec"
        assertEquals(expected, secondsToPrettyTime(seconds))
    }
}
