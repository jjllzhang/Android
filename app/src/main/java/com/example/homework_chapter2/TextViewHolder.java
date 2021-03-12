package com.example.homework_chapter2;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textview);
        itemView.setOnClickListener(this);
    }

    public void bind(String text) {
        mTextView.setText("这是第" + text + "行");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), SecondActivity.class);
        intent.putExtra("text", mTextView.getText().toString());
        v.getContext().startActivity(intent);
    }
}
