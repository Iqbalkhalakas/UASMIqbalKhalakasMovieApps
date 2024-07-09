package com.uas.miqbalkhalakas.movieapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uas.miqbalkhalakas.movieapps.databinding.ActivityDetailTvactivityBinding

class DetailTVActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVS = "extra_tvs"
    }

    private lateinit var binding: ActivityDetailTvactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.imgItemPhoto.clipToOutline = true

        val detailTvs = intent.getParcelableExtra<Television>(EXTRA_TVS)

        if (detailTvs != null) {
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailTvs.poster).into(binding.imgItemPhoto)
            binding.tvItemName.text = detailTvs.title
            binding.tvItemDescription.text = detailTvs.overview
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}