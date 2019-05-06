package com.example.mazerunner1;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public StringConverter convert = new StringConverter();
    public char[][] maze;
    public TextView mazeCreationWindow;
    public int Xcur,Ycur;
    public Spinner spinster;
    int[] cursCoor = new int[2];


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_exit:
                finish();
                return true;
            case R.id.create_export:
                //TODO: File handling stuff by Avery.
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createSpinner();
        defaultMaze();
        backCursorButton();
        forwardCursorButton();
        saveButton();
    }


    public void createSpinner() {
        spinster = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mapIcons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinster.setAdapter(adapter);
        spinster.setOnItemSelectedListener(this);


    }

    public void defaultMaze() {
        mazeCreationWindow = findViewById(R.id.maze_creation_window);
        basicMaze();
        cursorStart();
        mazeCreationWindow.setText(convert.charArrayToString(maze));


    }

    public int[] cursorPosition() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (maze[x][y] == 'O') {
                    Xcur = x;
                    Ycur = y;
                    updateCursorPosition();
                }
            }
        }
        return cursCoor;
    }

    public void setMaze() {
        maze[Xcur][Ycur] = 'O';
    }

    public void updateCursorPosition() {
        cursCoor[0] = Xcur;
        cursCoor[1] = Ycur;


    }
    public void saveButton(){
        Button savebut = findViewById(R.id.save_button);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTextasFile("Maize"+ Xcur, convert.charArrayToString(maze));
                finish();
            }
        });
    }
    public void backCursorButton() {
        Button backCursor = findViewById(R.id.cursor_back_button);
        backCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursorPosition();
                Xcur -= 1;
                if (Xcur == 0) {
                    Xcur = 1;
                    Ycur -= 1;


                } else {
                    setMaze();
                }
                updateCursorPosition();
            }
        });
    }

    public void forwardCursorButton() {
        Button forwardCursor = findViewById(R.id.cursor_forward_button);
        forwardCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursorPosition();
                Xcur += 1;
                if (Xcur == 10) {
                    Xcur = 1;
                    Ycur += 1;
                } else {
                    setMaze();
                }
                updateCursorPosition();
            }
        });
    }

    public void editMaze(Spinner spinnerText) {
        String charOfSpin;
        charOfSpin = spinnerText.getSelectedItem().toString();
        char c = charOfSpin.charAt(0);
        maze[Xcur][Ycur] = c;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        editMaze(spinster);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void basicMaze() {
        maze = new char[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                maze[x][y] = '-';
                maze[x][0] = '#';
                maze[x][9] = '#';
                maze[0][y] = '#';
                maze[9][y] = '#';
            }
        }


    }

    public void cursorStart() {
        maze[1][1] = 'O';
    }
    public void saveTextasFile(String filename, String content){
        String fileName = filename + ".maize";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Error Saving",Toast.LENGTH_SHORT).show();
        }

    }
}
