package com.talhadengiz.figma_livedata.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.talhadengiz.figma_livedata.R
import com.talhadengiz.figma_livedata.data.model.NearestRestaurant
import com.talhadengiz.figma_livedata.data.model.PopularMenu
import com.talhadengiz.figma_livedata.databinding.ActivityHomeBinding
import com.talhadengiz.figma_livedata.removeStatus
import com.talhadengiz.figma_livedata.showDialog
import com.talhadengiz.figma_livedata.ui.home.adapter.NearestRestaurantAdapter
import com.talhadengiz.figma_livedata.ui.home.adapter.PopularMenuAdapter
import com.talhadengiz.figma_livedata.ui.vm.LiveDataActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hidden status bar
        removeStatus(this)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRestaurantRecyclerView()
        initMenuRecyclerView()
        initClickListener()
        showDialog(
            getString(R.string.selam_dostum),
            getString(R.string.live_data),
            this
        )
    }

    private fun initClickListener() {
        binding.home.cardview.btnBuyNow.setOnClickListener {
            startActivity(Intent(this, LiveDataActivity::class.java))
        }
    }

    private fun initRestaurantRecyclerView() {
        binding.home.rvNearestRestaurant.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.home.rvNearestRestaurant.adapter = NearestRestaurantAdapter(addRestaurant())
    }

    private fun initMenuRecyclerView() {
        binding.home.rvPopularMenu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.home.rvPopularMenu.adapter = PopularMenuAdapter(addMenu())
    }

    private fun addRestaurant(): MutableList<NearestRestaurant> {
        return mutableListOf(
            NearestRestaurant(R.drawable.restaurant_image_1, "Vegan Resto-1", "12 Mins"),
            NearestRestaurant(R.drawable.restaurant_image_2, "Healthy Food-1", "8 Mins"),
            NearestRestaurant(R.drawable.restaurant_image_1, "Vegan Resto-2", "30 Mins"),
            NearestRestaurant(R.drawable.restaurant_image_2, "Healthy Food-1", "3 Mins")
        )
    }

    private fun addMenu(): MutableList<PopularMenu> {
        return mutableListOf(
            PopularMenu(R.drawable.image_menu, "Green Noddle", "Noddle Home", "$15"),
            PopularMenu(R.drawable.image_menu, "Green Noddle", "Noddle Home", "$16"),
            PopularMenu(R.drawable.image_menu, "Green Noddle", "Noddle Home", "$17"),
            PopularMenu(R.drawable.image_menu, "Green Noddle", "Noddle Home", "$18")
        )
    }
}