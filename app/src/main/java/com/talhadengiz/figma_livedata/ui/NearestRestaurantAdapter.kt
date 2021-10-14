package com.talhadengiz.figma_livedata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.talhadengiz.figma_livedata.data.NearestRestaurant
import com.talhadengiz.figma_livedata.databinding.ItemNearestRestaurantBinding

class NearestRestaurantAdapter(private val nearestRestaurantList: MutableList<NearestRestaurant>) :
    RecyclerView.Adapter<NearestRestaurantAdapter.NearestRestaurantVH>() {

    class NearestRestaurantVH(private val binding: ItemNearestRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NearestRestaurant) {
            binding.ivRestaurantLogo.setImageResource(item.restaurantLogo)
            binding.tvRestaurantName.text = item.restaurantName
            binding.tvDistanceTime.text = item.restaurantDistanceTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearestRestaurantVH {
        val binding = ItemNearestRestaurantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NearestRestaurantVH(binding)
    }

    override fun onBindViewHolder(holder: NearestRestaurantVH, position: Int) {
        holder.bind(nearestRestaurantList[position])
    }

    override fun getItemCount(): Int = nearestRestaurantList.size
}