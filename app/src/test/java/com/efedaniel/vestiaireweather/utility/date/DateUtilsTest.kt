package com.efedaniel.vestiaireweather.utility.date

import org.junit.Assert
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `should convert valid time in long to short date format`() {
        val epochTime = 1635427574000
        val expectedDate = "28.10"

        Assert.assertEquals(expectedDate, epochTime.convertToDateString(SHORT_DATE_FORMAT))
    }

    @Test
    fun `should convert zero time to respective short date format`() {
        val epochTime = 0L
        val expectedDate = "01.01"

        Assert.assertEquals(expectedDate, epochTime.convertToDateString(SHORT_DATE_FORMAT))
    }

    @Test
    fun `should convert valid time in long to long date format`() {
        val epochTime = 1635427574000
        val expectedDate = "28 October, 2021"

        Assert.assertEquals(expectedDate, epochTime.convertToDateString(LONG_DATE_FORMAT))
    }

    @Test
    fun `should convert zero to respective long date format`() {
        val epochTime = 0L
        val expectedDate = "01 January, 1970"

        Assert.assertEquals(expectedDate, epochTime.convertToDateString(LONG_DATE_FORMAT))
    }

    @Test
    fun `should convert time in long to valid day of week - Thursday`() {
        val epochTime = 1635427574000
        val expectedDay = "Thursday"

        Assert.assertEquals(expectedDay, epochTime.getDayOfWeek())
    }

    @Test
    fun `should convert time in long to valid day of week - Friday`() {
        val epochTime = 1635513967000
        val expectedDay = "Friday"

        Assert.assertEquals(expectedDay, epochTime.getDayOfWeek())
    }

    @Test
    fun `should convert time in long to valid day of week - Sunday`() {
        val epochTime = 1635686767000
        val expectedDay = "Sunday"

        Assert.assertEquals(expectedDay, epochTime.getDayOfWeek())
    }

}