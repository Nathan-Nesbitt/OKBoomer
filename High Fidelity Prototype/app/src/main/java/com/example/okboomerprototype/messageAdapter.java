package com.example.okboomerprototype;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class messageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private ArrayList<String> names = new ArrayList<>();
//    private ArrayList<String> messages = new ArrayList<>();
//    private ArrayList<String> times = new ArrayList<>();
//    private ArrayList<Integer> images = new ArrayList<>();
    private ArrayList<Message> msgs;
    private Context context;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

//    public void setItems(ArrayList<String> name, ArrayList<String> msgs, ArrayList<String> time, ArrayList<Integer> img){
//        names = name;
//        messages = msgs;
//        times = time;
//        images = img;
//        notifyDataSetChanged();
//    }
    public messageAdapter(Context context, ArrayList<Message> m){
        this.context = context;
        msgs = m;
        notifyDataSetChanged();
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType == VIEW_TYPE_MESSAGE_SENT){
//            return messageAdapter.ContactViewHolderSent.inflate(parent);
//        }else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
//            return messageAdapter.ContactViewHolderReceived.inflate(parent);
//        }else{
//            return null;
//        }
//    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == VIEW_TYPE_MESSAGE_SENT){
            view = LayoutInflater.from(context).inflate(R.layout.message_sent, parent, false);
            return new ContactViewHolderSent(view);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.message_received, parent, false);
            return new ContactViewHolderSent(view);
        }
}

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof messageAdapter.ContactViewHolderReceived){
            ((messageAdapter.ContactViewHolderReceived)holder).bind(msgs.get(position).getUserName(), msgs.get(position).getTime(), msgs.get(position).getMsg(), msgs.get(position).getImg());
        }else{
            ((messageAdapter.ContactViewHolderSent)holder).bind(msgs.get(position).getMsg(), msgs.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(TextUtils.isEmpty(msgs.get(position).getUserName())){
            return VIEW_TYPE_MESSAGE_SENT;
        }else{
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    static class ContactViewHolderReceived extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView lastTime;
        private TextView lastMsg;
        private ImageView userPic;


//        public static messageAdapter.ContactViewHolderReceived inflate(ViewGroup parent){
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_sent, parent, false);
//            return new messageAdapter.ContactViewHolderReceived(view);
//        }

        public ContactViewHolderReceived(View itemView){
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
    static class ContactViewHolderSent extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView lastTime;
        private TextView lastMsg;
        private ImageView userPic;


//        public static messageAdapter.ContactViewHolderSent inflate(ViewGroup parent){
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_received, parent, false);
//            return new messageAdapter.ContactViewHolderSent(view);
//        }

        public ContactViewHolderSent(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_message_name);
            lastTime = (TextView) itemView.findViewById(R.id.text_message_time);
            lastMsg = (TextView) itemView.findViewById(R.id.text_message_body);
            userPic = (ImageView) itemView.findViewById(R.id.image_message_profile);
        }
        public void bind(String msg, String time){
            
            lastTime.setText(time);
            lastMsg.setText(msg);


        }

    }
}

