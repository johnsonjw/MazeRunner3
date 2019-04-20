package com.example.mazerunner1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DimensionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimensions);
        initUI();
    }

    private void initUI() {
        final Button confirmDimensions = findViewById(R.id.confirmDimensions);
        final EditText height = findViewById(R.id.height);
        final EditText width = findViewById(R.id.width);

        confirmDimensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createIntent = new Intent(DimensionsActivity.this, CreateActivity.class);
                createIntent.putExtra("WIDTH", width.getText());
                createIntent.putExtra("HEIGHT", height.getText());
                startActivity(createIntent);
            }
        });
    }
}
