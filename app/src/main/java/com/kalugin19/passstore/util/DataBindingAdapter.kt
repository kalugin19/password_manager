package com.kalugin19.passstore.util

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.kalugin19.passstore.db.enteties.Record
import com.kalugin19.passstore.view.records.adapter.RecordsAdapter

@BindingAdapter("custom:error")
fun TextInputLayout.setErrorText(errorMessage: String) {
    error = errorMessage
}

@BindingAdapter("imgRes")
fun ImageView.setImgRes(imgRes: Int) {
    val drawable = ContextCompat.getDrawable(context, imgRes)
    setImageDrawable(drawable)
}

@BindingAdapter("records")
fun RecyclerView.setRecords(records: List<Record>?) {

    if (adapter == null) {
        setHasFixedSize(true)
        adapter = RecordsAdapter()
        addItemDecoration(GridViewItemDecoration())
    }

    records?.let { data ->
        (adapter as RecordsAdapter).submitList(data)
    }
}