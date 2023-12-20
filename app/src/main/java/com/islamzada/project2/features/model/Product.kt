package com.islamzada.project2.features.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product (val id : Int,
                    val name: String,
                    val desc: String) : Parcelable {
}