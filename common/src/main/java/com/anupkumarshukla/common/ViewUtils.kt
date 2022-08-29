package com.anupkumarshukla.common

import android.widget.TextView
import androidx.annotation.StringRes


fun TextView.attributedText(@StringRes id: Int, vararg args: String?) {
    text = String.format(resources.getString(id), *args)
}