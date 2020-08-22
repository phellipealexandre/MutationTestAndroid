package com.ph.mutationtestandroid.error

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorModel(
    val errorMessage: String
): Parcelable