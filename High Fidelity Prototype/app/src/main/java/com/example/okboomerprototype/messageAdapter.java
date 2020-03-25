package com.example.okboomerprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class messageAdapter extends RecyclerView.Adapter  {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    public void setItems(ArrayList<String> name, ArrayList<String> msgs, ArrayList<String> time, ArrayList<Integer> img){
        names = name;
        messages = msgs;
        times = time;
        images = img;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_MESSAGE_SENT){
            return messageAdapter.ContactViewHolder.inflate(parent, R.layout.message_sent);
        }else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            return messageAdapter.ContactViewHolder.inflate(parent, R.layout.message_received);
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof messageAdapter.ContactViewHolder){
            ((messageAdapter.ContactViewHolder)holder).bind(names.get(position), messages.get(position), times.get(position), images.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(names.equals("") || names == null){
            return VIEW_TYPE_MESSAGE_SENT;
        }else{
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView lastTime;
        private TextView lastMsg;
        private ImageView userPic;


        public static messageAdapter.ContactViewHolder inflate(ViewGroup parent, int x){
            View view = LayoutInflater.from(parent.getContext()).inflate(x, parent, false);
            return new messageAdapter.ContactViewHolder(view);
        }

        public ContactViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_message_name);
            lastTime = (TextView) itemView.findViewById(R.id.text_message_time);
            lastMsg = (TextView) itemView.findViewById(R.id.text_message_body);
            userPic = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }
        public void bind(String textName, String time, String msg, int pic){
            name.setText(textName);
            lastTime.setText(time);
            lastMsg.setText(msg);
            userPic.setImageResource(pic);
        }

    }
}

