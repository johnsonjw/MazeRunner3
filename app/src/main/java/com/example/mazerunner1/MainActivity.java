package com.example.mazerunner1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUIComponents();
    }

    private void initUIComponents() { ;
        final Button play = findViewById(R.id.play);
        final Button create = findViewById(R.id.confirmDimensions);
        final Button tutorial = findViewById(R.id.tutorial);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectionIntent = new Intent(MainActivity.this, MazeSelectionActivity.class);
                startActivity(selectionIntent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dimensionsIntent = new Intent(MainActivity.this, DimensionsActivity.class);
                startActivity(dimensionsIntent);
            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorialIntent = new Intent(MainActivity.this, TutorialActivity.class);
                startActivity(tutorialIntent);
            }
        });
    }
}
