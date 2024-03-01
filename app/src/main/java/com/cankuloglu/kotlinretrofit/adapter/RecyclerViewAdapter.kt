package com.cankuloglu.kotlinretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cankuloglu.kotlinretrofit.R
import com.cankuloglu.kotlinretrofit.databinding.RowLayoutBinding
import com.cankuloglu.kotlinretrofit.model.CryptoModel
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener{
        fun onItemClicked(cryptoModel: CryptoModel)
    }

    private val colours : Array<String> = arrayOf("#61311d","#000000","#6e6ea0","#fc8d2b","#ff2701","#0000ff")

    class RowHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClicked(cryptoList.get(position))
        }
        holder.itemView.setBackgroundColor(Color.parseColor(colours[position % 6]))

        holder.binding.textName.text = cryptoList.get(position).currency
        holder.binding.textPrice.text = cryptoList.get(position).price

    }
}

