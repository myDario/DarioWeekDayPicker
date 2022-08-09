# DarioWeekDayPicker
A localized weekday picker for Android

<img src="art/screen0.png" width="200"/>

## Install
root `build.gradle` file:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

app `build.gradle` file:
```gradle
implementation 'com.github.myDario:DarioWeekDayPicker:1.0.2'
```

## Usage
```xml
<com.labstyle.darioweekdaypicker.DarioWeekDayPicker
    android:id="@+id/weekdayPicker"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## Selection change listener
```kotlin
findViewById<DarioWeekDayPicker>(R.id.weekdayPicker).onSelectionChanged = { indexList ->
    // ...
}
```

## Select weekday at runtime
```kotlin
with (findViewById<DarioWeekDayPicker>(R.id.weekdayPicker)) {
    clearSelection()
    setSelected(weekdayIndex = 0, selected = true)
}
```