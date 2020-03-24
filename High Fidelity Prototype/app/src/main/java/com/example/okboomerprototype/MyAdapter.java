package com.example.okboomerprototype;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> lastMsgs = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();

    public void setItems(ArrayList<String> name, ArrayList<String> msgs, ArrayList<String> time, ArrayList<Integer> img){
        names = name;
        lastMsgs = msgs;
        times = time;
        images = img;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            return ContactViewHolder.inflate(parent);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ContactViewHolder){
            ((ContactViewHolder)holder).bind(names.get(position), lastMsgs.get(position), times.get(position), images.get(position));
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

    static class ContactViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView lastTime;
        private TextView lastMsg;
        private ImageView userPic;

        public static ContactViewHolder inflate(ViewGroup parent){
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list, parent, false);
           return new ContactViewHolder(view);
        }

        public ContactViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.chatName);
            lastTime = (TextView) itemView.findViewById(R.id.chatTime);
            lastMsg = (TextView) itemView.findViewById(R.id.chatLast);
            userPic = (ImageView) itemView.findViewById(R.id.chatUserImg);
        }
        public void bind(String textName, String time, String msg, int pic){
            name.setText(textName);
            lastTime.setText(time);
            lastMsg.setText(msg);
            userPic.setImageResource(pic);
        }

    }

}