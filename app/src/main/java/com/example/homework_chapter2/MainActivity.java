package com.example.homework_chapter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private SearchAdapter mSearchAdapter = new SearchAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(String.valueOf(i));
        }
        mSearchAdapter.notifyItems(items);
        recyclerView.setAdapter(mSearchAdapter);
        editText = findViewById(R.id.editView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                button.setVisibility(s.toString().isEmpty() ? View.GONE : View.VISIBLE);

                List<String> temp = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).contains(s))
                        temp.add(items.get(i));
                }
                mSearchAdapter.notifyItems(temp);

            }
        });


    }
}