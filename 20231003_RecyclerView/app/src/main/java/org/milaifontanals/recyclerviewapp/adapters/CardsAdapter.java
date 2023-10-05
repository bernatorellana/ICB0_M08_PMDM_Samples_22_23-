package org.milaifontanals.recyclerviewapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.recyclerviewapp.Card;
import org.milaifontanals.recyclerviewapp.R;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder>{

    private List<Card> mCards;

    public CardsAdapter(List<Card> cards){
        mCards = cards;
    }

    @NonNull
    @Override
    public CardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsAdapter.ViewHolder rowHolder, int position) {
        Card cartaActual = mCards.get(position);
        rowHolder.txvName.setText(cartaActual.getName());
        rowHolder.imvPhoto.setImageResource(cartaActual.getDrawable());
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    /**
     * EL ViewHolder és un índex que apunta a cadascun dels elements de la fila
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvName;
        ImageView imvPhoto;
        public ViewHolder(@NonNull View row) {
            super(row);
            txvName = row.findViewById(R.id.txvName);
            imvPhoto = row.findViewById(R.id.imvPhoto);
        }
    }
}
