package com.example.chapter3.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private List<Friend> mFriendList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View friendView;
        ImageView friendImage;
        TextView friendName;

        public ViewHolder(View view){
            super(view);
            friendView=view;
            friendImage=(ImageView) view.findViewById(R.id.friend_image);
            friendName=(TextView) view.findViewById(R.id.friend_name);
        }
    }

    public FriendAdapter(List<Friend> friendList){
        mFriendList=friendList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.freind_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.friendView.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                Friend friend=mFriendList.get(position);
                Toast.makeText(v.getContext(),"You clicked "+friend.getName(),Toast.LENGTH_SHORT).show();
            }
        }));
        holder.friendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Friend friend=mFriendList.get(position);
                Toast.makeText(view.getContext(),"You clicked image "+friend.getName(),Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Friend friend=mFriendList.get(position);
        holder.friendImage.setImageResource(friend.getImageId());
        holder.friendName.setText(friend.getName());
    }

    @Override
    public int getItemCount(){
        return mFriendList.size();
    }
}
