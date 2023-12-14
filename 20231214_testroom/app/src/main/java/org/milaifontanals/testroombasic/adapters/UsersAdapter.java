package org.milaifontanals.testroombasic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.testroombasic.R;
import org.milaifontanals.testroombasic.model.User;
import org.w3c.dom.Text;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private List<User> mUsuaris;
    private Context mContext;
    public UsersAdapter(List<User> usuaris, Context c){
        mUsuaris = usuaris;
        mContext = c;
    }

    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.ViewHolder holder, int position) {
        User u = mUsuaris.get(position);
        holder.txvFirstName.setText(u.firstName);
        holder.txvLastName.setText(u.lastName);
        holder.txvId.setText(u.uid+"");
    }

    @Override
    public int getItemCount() {
        return mUsuaris.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvId;
        TextView txvFirstName;
        TextView txvLastName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvId = itemView.findViewById(R.id.txvId);
            txvFirstName = itemView.findViewById(R.id.txvFirstName);
            txvLastName = itemView.findViewById(R.id.txvLastName);

        }
    }
}
