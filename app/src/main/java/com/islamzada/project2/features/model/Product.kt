package com.islamzada.project2.features.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product (val name: String,
                    val code : Int,
                    val desc: String) : Parcelable {
}