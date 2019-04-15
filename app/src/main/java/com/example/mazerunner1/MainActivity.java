package com.example.mazerunner1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUIComponents();
    }

    private void initUIComponents() {
        View difficultyView = getLayoutInflater().inflate(R.layout.dialog_difficulty, null);
        AlertDialog.Builder difficultyBuilder = new AlertDialog.Builder(MainActivity.this);
        difficultyBuilder.setView(difficultyView);
        final AlertDialog difficultySelection = difficultyBuilder.create();

        View dimensionsView = getLayoutInflater().inflate(R.layout.dialog_dimensions, null);
        AlertDialog.Builder dimensionsBuilder = new AlertDialog.Builder(MainActivity.this);
        dimensionsBuilder.setView(dimensionsView);
        final AlertDialog dimensionsDialog = dimensionsBuilder.create();

        View tutorialView = getLayoutInflater().inflate(R.layout.dialog_tutorial, null);
        AlertDialog.Builder tutorialBuilder = new AlertDialog.Builder(MainActivity.this);
        tutorialBuilder.setView(tutorialView);
        final AlertDialog tutorialDialog = tutorialBuilder.create();

        Button play = findViewById(R.id.play);
        Button create = findViewById(R.id.confirmDimensions);
        Button load = findViewById(R.id.load);
        Button tutorial = findViewById(R.id.tutorial);
        Button confirmDimensions = dimensionsView.findViewById(R.id.confirmDimensions);
        Button confirmDifficulty = difficultyView.findViewById(R.id.confirmDifficulty);
        final RadioButton easy = difficultyView.findViewById(R.id.easy);
        final RadioButton medium = difficultyView.findViewById(R.id.medium);
        final RadioButton hard = difficultyView.findViewById(R.id.hard);
        final RadioButton random = difficultyView.findViewById(R.id.random);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficultySelection.show();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimensionsDialog.show();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialDialog.show();
            }
        });

        confirmDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        confirmDifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
