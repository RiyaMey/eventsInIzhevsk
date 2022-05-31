package com.example.vkeventsinizhevsk.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    @DrawableRes val avatarResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val dateTimeResId: Int) {
}
