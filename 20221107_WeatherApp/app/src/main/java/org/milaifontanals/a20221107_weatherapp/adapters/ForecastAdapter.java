package org.milaifontanals.a20221107_weatherapp.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.a20221107_weatherapp.R;
import org.milaifontanals.a20221107_weatherapp.model.DailyWeather;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder<DailyWeather>> {
    @NonNull
    @Override
    public ViewHolder<DailyWeather> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<DailyWeather> holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder<T> extends RecyclerView.ViewHolder {
        TextView txvMin;
        TextView txvMax;
        TextView txvDesc;
        TextView txvDate;
        ImageView imgIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvMin = itemView.findViewById(R.id.txvMin);
            txvMax = itemView.findViewById(R.id.txvMax);
            txvDesc = itemView.findViewById(R.id.txvDesc);
            txvDate = itemView.findViewById(R.id.txvDate);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }
}
