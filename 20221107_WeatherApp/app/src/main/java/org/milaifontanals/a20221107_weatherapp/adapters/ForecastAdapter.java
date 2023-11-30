package org.milaifontanals.a20221107_weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.milaifontanals.a20221107_weatherapp.R;
import org.milaifontanals.a20221107_weatherapp.model.DailyWeather;

import java.text.SimpleDateFormat;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder<DailyWeather>> {

    private List<DailyWeather> forecast;
    private Context c;
    public ForecastAdapter(List<DailyWeather> forecast, Context c) {
        this.c = c;
        this.forecast = forecast;
    }

    @NonNull
    @Override
    public ViewHolder<DailyWeather> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<DailyWeather> holder, int position) {
        DailyWeather day = forecast.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        holder.txvDate.setText(sdf.format(day.getDate()));
        holder.txvMax.setText(day.getTempMax()+"");
        holder.txvMin.setText(day.getTempMin()+"");
        holder.txvDesc.setText(day.getWeatherDescription());
        ImageLoader.getInstance().displayImage(day.getWeatherImage(),holder.imgIcon);

    }

    @Override
    public int getItemCount() {
        return forecast.size();
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
