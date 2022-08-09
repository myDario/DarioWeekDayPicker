package com.labstyle.darioweekdaypicker

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DarioWeekDayPickerTest {
    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun setSelected_outOfBound() {
        val picker = DarioWeekDayPicker(appContext)
        picker.clearSelection()
        picker.setSelected(-1, true)
        picker.setSelected(7, true)
        assert(picker.selectedWeekdaysIndex.isEmpty())
    }
}