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
    private static matchesViewHolder.OnUserListener matchUL;
    public void setItems(ArrayList<String> name, ArrayList<Integer> img, matchesViewHolder.OnUserListener onUserL){
        names = name;
        images = img;
        matchUL = onUserL;
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

    static class matchesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private ImageView userPic;
        OnUserListener onuser;

        public static matchesAdapter.matchesViewHolder inflate(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_list, parent, false);
            return new matchesAdapter.matchesViewHolder(view, matchUL);
        }

        public matchesViewHolder(View itemView, OnUserListener onUser){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.matchName);
            userPic = (ImageView) itemView.findViewById(R.id.matchUserImg);
            this.onuser = onUser;
            itemView.setOnClickListener(this);
        }
        public void bind(String textName, int pic){
            name.setText(textName);
            userPic.setImageResource(pic);
        }

        @Override
        public void onClick(View v) {
            onuser.matchesOnUserClick(getAdapterPosition());
        }
        public interface OnUserListener{
            void matchesOnUserClick(int position);
        }
    }
}
