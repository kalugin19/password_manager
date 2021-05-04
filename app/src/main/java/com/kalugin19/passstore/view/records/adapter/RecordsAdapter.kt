package com.kalugin19.passstore.view.records.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kalugin19.passstore.databinding.ItemRecordBinding
import com.kalugin19.passstore.db.enteties.Record
import com.kalugin19.passstore.db.enteties.Service
import com.kalugin19.passstore.util.passgenerator.inflater

class RecordsAdapter : ListAdapter<Record, RecordViewHolder>(RecordsItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val binding = ItemRecordBinding.inflate(parent.context.inflater, parent, false)
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecordViewHolder,
        position: Int
    ) = holder.bind(getItem(position))
}

class RecordViewHolder(
    private val binding: ItemRecordBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(record: Record) {
        binding.record = record
        binding.service =
            Service(name = "Instagram", imageRes = com.kalugin19.passstore.R.drawable.ic_instagram)

    }

}