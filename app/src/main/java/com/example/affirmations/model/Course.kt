//  Scott Lindsay
//  OSU
//  CS492

package com.example.affirmations.model

import androidx.annotation.StringRes

data class Course(
    @StringRes val titleResId: Int, // String resource ID for the title
    val department: String,
    val number: Int,
    val capacity: Int
)
