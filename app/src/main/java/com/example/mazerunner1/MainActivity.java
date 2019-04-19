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

    private void initUIComponents() {
        final View dimensionsView = getLayoutInflater().inflate(R.layout.dialog_dimensions, null);
        final AlertDialog dimensionsDialog = buildDialog(R.layout.dialog_dimensions);

        final View tutorialView = getLayoutInflater().inflate(R.layout.dialog_tutorial, null);
        final AlertDialog tutorialDialog = buildDialog(R.layout.dialog_tutorial);

        final Button play = findViewById(R.id.play);
        final Button create = findViewById(R.id.confirmDimensions);
        final Button tutorial = findViewById(R.id.tutorial);
        final Button confirmDimensions = dimensionsView.findViewById(R.id.confirmDimensions);
        final Button exitTutorial = tutorialView.findViewById(R.id.exitTutorial);
        final EditText width = dimensionsView.findViewById(R.id.width);
        final EditText height = dimensionsView.findViewById(R.id.height);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Start custom maze selection activity.
                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimensionsDialog.show();
            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialDialog.show();
            }
        });

        exitTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialDialog.dismiss();
            }
        });

        confirmDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: confirmDimensions clicked.");
                Intent createIntent = new Intent(MainActivity.this, CreateActivity.class);
                createIntent.putExtra("WIDTH", width.getText());
                createIntent.putExtra("HEIGHT", height.getText());
                startActivity(createIntent);
            }
        });
    }

    private AlertDialog buildDialog(int resource) {
        View mView = getLayoutInflater().inflate(resource, null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setView(mView);
        return mBuilder.create();
    }
}
