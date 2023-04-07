package com.example.manorroom

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.manorroom.databinding.ListItemZodiacBinding


class ZodiacHolder(
    private val binding: ListItemZodiacBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(zodiac: Zodiac) {

        binding.zodiacName.text = zodiac.name

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${zodiac.name} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class ZodiacListAdapter(
    private val zodiacs: List<Zodiac>
) : RecyclerView.Adapter<ZodiacHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ZodiacHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemZodiacBinding.inflate(inflater, parent, false)
        return ZodiacHolder(binding)
    }

    override fun onBindViewHolder(holder: ZodiacHolder, position: Int) {
        val zodiac = zodiacs[position]
        holder.bind(zodiac)
    }

    override fun getItemCount() = zodiacs.size
}