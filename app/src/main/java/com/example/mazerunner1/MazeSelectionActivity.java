package com.example.mazerunner1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MazeSelectionActivity extends AppCompatActivity {
    private static final String TAG = "MazeSelectionActivity";
    private ListView mazes;
    private TextView emptyText;
    private String[] files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze_selection);
        initUI();
        initListItems();
    }

    private void initUI() {
        mazes = findViewById(R.id.mazes);
        emptyText = findViewById(android.R.id.empty);
    }

    private void initListItems() {
        try {
            files = getAssets().list("mazes");
        } catch (IOException e) {
            Utilities.notifyException(this, e);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, files);
        if (adapter.getCount() == 0) mazes.setVisibility(View.GONE);
        mazes.setAdapter(adapter);
        mazes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent toGame = new Intent(MazeSelectionActivity.this, GameActivity.class);
                toGame.putExtra("MAZE_FILE", files[i]);
                startActivity(toGame);
            }
        });
    }

}
