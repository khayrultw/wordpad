package com.khayrultw.wordpad.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.khayrultw.wordpad.R
import com.khayrultw.wordpad.data.apis.model.Word
import com.khayrultw.wordpad.databinding.ItemLayoutWordBinding

class WordsAdapter(private val items: List<Word>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = DataBindingUtil.inflate<ItemLayoutWordBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_layout_word,
            parent,
            false
        )
        return WordItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if(holder is WordItemHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class WordItemHolder(private val binding: ItemLayoutWordBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Word) {
            binding.model = model
            binding.onItemClicked = View.OnClickListener {
                listener?.onItemClicked()
            }
        }
    }

    interface Listener {
        fun onItemClicked()
    }
}