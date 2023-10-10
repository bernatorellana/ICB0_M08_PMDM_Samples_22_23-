package org.milaifontanals.recyclerviewapp.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.recyclerviewapp.Card;
import org.milaifontanals.recyclerviewapp.R;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder>{

    private List<Card> mCards;
    private Context mContext;

    private int idxElementSeleccionat = -1;


    public CardsAdapter(Context c, List<Card> cards){
        mContext = c;
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
        rowHolder.txvDesc.setText(cartaActual.getDesc());
        rowHolder.txvCost.setText(""+cartaActual.getElixirCost());
        rowHolder.imvPhoto.setImageResource(cartaActual.getDrawable());


        rowHolder.itemView.setOnClickListener(view -> {
            int posicioAnterior = this.idxElementSeleccionat;
            this.idxElementSeleccionat = rowHolder.getAdapterPosition();
            this.notifyItemChanged(idxElementSeleccionat);
            this.notifyItemChanged(posicioAnterior);
        });

        int color;
        switch (cartaActual.getRarity()){
            case EPIC: color =  mContext.getColor(R.color.RARITY_EPIC);break;
            case COMMON: color = mContext.getColor(R.color.RARITY_COMMON);break;
            case RARE: color = mContext.getColor(R.color.RARITY_RARE);break;
            default:color = mContext.getColor(R.color.RARITY_COMMON);
        }
        int Colors;
        rowHolder.clyRow.setBackground(
            new GradientDrawable(
                    GradientDrawable.Orientation.BOTTOM_TOP,
                    new int[]{
                        Color.parseColor("#ffffff"), // color inici
                            color,
                            color // color fi
                    }
        ));
        if(position== idxElementSeleccionat) {
            rowHolder.clyRow.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#ffff00")));
        } else {
            rowHolder.clyRow.setBackgroundTintList(null);
        }
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    public void deleteSelected() {
        if(this.idxElementSeleccionat !=-1){
            mCards.remove(idxElementSeleccionat);

            notifyItemRemoved(idxElementSeleccionat);
            if(idxElementSeleccionat >=mCards.size() || mCards.size()==0) {
                idxElementSeleccionat = -1;
            } else {
                notifyItemChanged(idxElementSeleccionat);
            }
        }
    }

    public void move(int offset) {
        if(idxElementSeleccionat !=-1) {
            int nouIndex = idxElementSeleccionat + offset;
            if (nouIndex >= 0 && nouIndex < mCards.size()) {
                Card c = mCards.remove(idxElementSeleccionat);
                mCards.add(nouIndex, c);
                notifyItemRemoved(idxElementSeleccionat);
                notifyItemInserted(nouIndex);
                idxElementSeleccionat = nouIndex;
                notifyItemChanged(idxElementSeleccionat);
            }
        }
    }

    /**
     * EL ViewHolder és un índex que apunta a cadascun dels elements de la fila
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvName;
        TextView txvDesc;
        TextView txvCost;
        ImageView imvPhoto;
        ConstraintLayout clyRow;
        public ViewHolder(@NonNull View row) {
            super(row);
            txvName = row.findViewById(R.id.txvName);
            txvDesc = row.findViewById(R.id.txvDesc);
            txvCost = row.findViewById(R.id.txvCost);
            imvPhoto = row.findViewById(R.id.imvPhoto);
            clyRow = row.findViewById(R.id.clyRow);
        }
    }
}
