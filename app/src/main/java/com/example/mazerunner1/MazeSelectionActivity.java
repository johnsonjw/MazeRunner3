package com.example.mazerunner1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MazeSelectionActivity extends AppCompatActivity {
    private ListView mazes;
    private File[] mazeFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze_selection);
        initUI();
        initListItems();
    }

    private void initUI() {
        mazes = findViewById(R.id.mazes);
    }

    private void initListItems() {
        File mazeFolder = getFilesDir();
        mazeFiles = mazeFolder.listFiles();
        String[] mazeFileNames = new String[mazeFiles.length];
        for (int i = 0; i < mazeFileNames.length; i++) {
            mazeFileNames[i] = mazeFiles[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mazeFileNames);
        mazes.setAdapter(adapter);

        mazes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent toGame = new Intent(MazeSelectionActivity.this, GameActivity.class);
                toGame.putExtra("MAZE_FILE", mazeFiles[i]);
            }
        });
    }

}
