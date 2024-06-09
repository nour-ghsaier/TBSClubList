package com.example.finalghsiaer.model
import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class club(
    @StringRes val nameResourceId: Int,
    @StringRes val goalResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
