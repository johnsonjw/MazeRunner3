package com.example.mazerunner1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MazeSelectionActivity extends AppCompatActivity {
    private GameSettings gameSettings;
    private ListView mazes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maze_selection);
        initGameSettings();
        initUI();
    }

    private void initUI() {
        mazes = findViewById(R.id.mazes);
    }

    private void initGameSettings() {
        gameSettings = new GameSettings(0.5, 0.4, 0, 70);
    }

    private void initListItems() {
        File mazeFolder = getFilesDir();
        File[] mazeFiles = mazeFolder.listFiles();
        String[] mazeFileNames = new String[mazeFiles.length];
        for (int i = 0; i < mazeFileNames.length; i++) {
            mazeFileNames[i] = mazeFiles[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mazeFileNames);
    }

}
