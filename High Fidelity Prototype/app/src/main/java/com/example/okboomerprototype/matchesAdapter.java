package com.example.okboomerprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class matchesAdapter extends RecyclerView.Adapter  {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();

    public void setItems(ArrayList<String> name, ArrayList<Integer> img){
        names = name;
        images = img;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            return matchesAdapter.matchesViewHolder.inflate(parent);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof matchesAdapter.matchesViewHolder){
            ((matchesAdapter.matchesViewHolder)holder).bind(names.get(position), images.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class matchesViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView userPic;

        public static matchesAdapter.matchesViewHolder inflate(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_list, parent, false);
            return new matchesAdapter.matchesViewHolder(view);
        }

        public matchesViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.matchName);
            userPic = (ImageView) itemView.findViewById(R.id.matchUserImg);
        }
        public void bind(String textName, int pic){
            name.setText(textName);
            userPic.setImageResource(pic);
        }

    }
}
