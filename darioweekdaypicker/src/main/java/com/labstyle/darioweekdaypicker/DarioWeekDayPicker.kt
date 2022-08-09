package com.labstyle.darioweekdaypicker

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.text.DateFormatSymbols
import java.util.*

class DarioWeekDayPicker @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
): HorizontalScrollView(context, attrs, defStyle, defStyleRes) {

    private val symbols = DateFormatSymbols(Locale.getDefault())
    private val textViews = arrayListOf<TextView>()
    private val circles = arrayListOf<ConstraintLayout>()

    val selectedWeekdaysIndex = arrayListOf<Int>()
    var onSelectionChanged: (List<Int>) -> Unit = {}

    init {
        inflate(context, R.layout.weekdays_layout, this)

        textViews.addAll(listOf(
            findViewById(R.id.text1),
            findViewById(R.id.text2),
            findViewById(R.id.text3),
            findViewById(R.id.text4),
            findViewById(R.id.text5),
            findViewById(R.id.text6),
            findViewById(R.id.text7)
        ))
        circles.addAll(listOf(
            findViewById(R.id.circle1),
            findViewById(R.id.circle2),
            findViewById(R.id.circle3),
            findViewById(R.id.circle4),
            findViewById(R.id.circle5),
            findViewById(R.id.circle6),
            findViewById(R.id.circle7)
        ))

        // set texts
        textViews.forEachIndexed { index, textView ->
            textView.text = symbols.shortWeekdays[index + 1]
        }

        // set all days not selected
        clearSelection()

        // handle clicks
        circles.forEachIndexed { index, circle ->
            circle.setOnClickListener {
                val isSelected = selectedWeekdaysIndex.contains(index)
                setSelected(index, !isSelected)
            }
        }

        // set today as selected
        val cal = Calendar.getInstance()
        cal.timeInMillis = System.currentTimeMillis()
        val dow = cal.get(Calendar.DAY_OF_WEEK)
        setSelected(dow - 1, true)
    }

    fun clearSelection() {
        circles.forEachIndexed { index, _ -> setSelected(index, false) }
    }

    fun setSelected(weekdayIndex: Int, selected: Boolean) {
        if (weekdayIndex < 0 || weekdayIndex > 6) {
            return
        }

        circles[weekdayIndex].setBackgroundResource(
            if (selected) R.drawable.circle_selected
            else R.drawable.circle_not_selected
        )
        textViews[weekdayIndex].setTextAppearance(
            if (selected) R.style.WeekdayTextSelected
            else R.style.WeekdayText
        )

        if (selected && !selectedWeekdaysIndex.contains(weekdayIndex)) {
            selectedWeekdaysIndex.add(weekdayIndex)
        }
        if (!selected && selectedWeekdaysIndex.contains(weekdayIndex)) {
            selectedWeekdaysIndex.remove(weekdayIndex)
        }

        onSelectionChanged(selectedWeekdaysIndex)
    }
}
