package com.example.recyclerviewwcreation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwcreation.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderNew> {

    Context context;
    String[] listData;
    public RecyclerViewAdapter(Context context, String[] listdata){
        this.context = context;
        this.listData = listdata;
    }

    @NonNull
    @Override
    public ViewHolderNew onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolderNew viewHolderNew = new ViewHolderNew(v);

        return viewHolderNew;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNew holder, int position) {
        TextView textView = holder.textView;
        textView.setText(listData[position]);
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    class ViewHolderNew extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolderNew(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
