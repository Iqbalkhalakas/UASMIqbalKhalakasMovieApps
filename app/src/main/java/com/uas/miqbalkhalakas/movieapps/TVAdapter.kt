package com.uas.miqbalkhalakas.movieapps

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uas.miqbalkhalakas.movieapps.databinding.TvItemBinding

class TVAdapter(
    private val tvs: List<Television>
) : RecyclerView.Adapter<TVAdapter.TVViewHolder>() {

    class TVViewHolder(private val binding: TvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTV(tv: Television) {
            binding.tvTitle.text = tv.title
            binding.tvOverview.text = tv.overview
            Glide.with(binding.root).load(IMAGE_BASE + tv.poster).into(binding.tvPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val binding = TvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVViewHolder(binding)
    }

    override fun getItemCount(): Int = tvs.size

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tv = tvs[position]
        holder.bindTV(tv)

        holder.itemView.setOnClickListener {
            moveToTvSDetail(tv, it)
        }
    }

    private fun moveToTvSDetail(tv: Television, it: View) {
        val detailTvsIntent = Intent(it.context, DetailTVActivity::class.java)
        detailTvsIntent.putExtra(DetailTVActivity.EXTRA_TVS, tv)
        it.context.startActivity(detailTvsIntent)
    }
}