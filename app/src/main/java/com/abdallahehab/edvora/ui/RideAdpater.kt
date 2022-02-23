package com.abdallahehab.edvora.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdallahehab.edvora.R
import com.abdallahehab.edvora.data.Ride
import com.abdallahehab.edvora.databinding.RideCardItemBinding


class RideAdapter(val dataList:List<Ride>): RecyclerView.Adapter<RideAdapter.RideViewHolder>() {


    class RideViewHolder(val binding:RideCardItemBinding):RecyclerView.ViewHolder(binding.root){

        val activityContext = binding.root.context

        fun bind(ride: Ride) {
            binding.imgMap.setImageResource(R.drawable.map)
            binding.txtCityName.text = ride.city
            binding.txtStateName.text = ride.state
            binding.txtRideId.text = activityContext.getString(R.string.ride_id_label,ride.id)
            binding.txtOrginStation.text = activityContext.getString(R.string.orginStationLabel,ride.origin_station_code)
            binding.txtStationPath.text = activityContext.getString(R.string.stationPathLabel,ride.station_path)
            binding.txtDistance.text = activityContext.getString(R.string.distanceLabel,0)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val bindin = RideCardItemBinding.inflate(inflator,parent,false)
        return RideViewHolder(bindin)
    }

    override fun onBindViewHolder(holder: RideViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}