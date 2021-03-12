package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;
    private List<Friend> friendList=new ArrayList<Friend>();
    private View square;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View square=inflater.inflate(R.layout.fragment_placeholder, container, false);
        initFriends();
        RecyclerView recyclerView=square.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        FriendAdapter adapter=new FriendAdapter(friendList);
        recyclerView.setAdapter(adapter);
        return square;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animationView=getView().findViewById(R.id.animation_view);
        final RecyclerView recyclerView=getView().findViewById(R.id.recycler_view);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator=ObjectAnimator.ofFloat(animationView,"alpha",1,0);
                ObjectAnimator animator1=ObjectAnimator.ofFloat(recyclerView,"alpha",0,1);
                animator.setDuration(1000);
                animator1.setDuration(1000);
                animatorSet=new AnimatorSet();
                animatorSet.playTogether(animator,animator1);
                animatorSet.start();
            }
        }, 5000);
    }

    public void initFriends(){
        for(int i=0;i<2;i++){
            Friend ddl=new Friend("ddl",R.drawable.ddl);
            friendList.add(ddl);
            Friend cxs=new Friend("cxs",R.drawable.cxs);
            friendList.add(cxs);
            Friend bingan=new Friend("bingan",R.drawable.bingan);
            friendList.add(bingan);
            Friend jy=new Friend("jy",R.drawable.jy);
            friendList.add(jy);
            Friend pen=new Friend("pen",R.drawable.pen);
            friendList.add(pen);
            Friend songshu=new Friend("songshu",R.drawable.songshu);
            friendList.add(songshu);
            Friend ss=new Friend("ss",R.drawable.ss);
            friendList.add(ss);
            Friend xxz=new Friend("xxz",R.drawable.xxz);
            friendList.add(xxz);
            Friend yx=new Friend("yx",R.drawable.yx);
            friendList.add(yx);
            Friend zjl=new Friend("zjl",R.drawable.zjl);
            friendList.add(zjl);
        }
    }
}
