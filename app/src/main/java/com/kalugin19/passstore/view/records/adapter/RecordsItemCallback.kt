package com.kalugin19.passstore.view.records.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kalugin19.passstore.db.enteties.Record

class RecordsItemCallback: DiffUtil.ItemCallback<Record>() {

    override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
        return oldItem == newItem
    }
}