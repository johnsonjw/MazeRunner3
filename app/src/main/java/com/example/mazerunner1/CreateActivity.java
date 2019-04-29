package com.example.mazerunner1;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CreateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public StringConverter convert = new StringConverter();
    private LinearLayout parent;
    private Button b1;
    private Button b2;
    public int inputX;
    public int inputY;
    public int testX = 10;
    public int testY = 10;
    public ArrayList<String> gridLayout = new ArrayList<>();

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
        Toolbar toolbar = findViewById(R.id.createToolbar);
        setSupportActionBar(toolbar);
        createSpinner();
        createDynamicButtons(testX, testY);
        createDynamicButtons(testX, testY);
    }

    public void GetXandY(int x, int y) {
        inputX = x;
        inputY = y;
    }


    public ArrayList<String> createDynamicButtons(int x,int y) {
        Button[][] gridview = new Button[10][10];
        for (int i = 0; i < x; i++) {
            for (int b = 0; b < y; b++) {


            }
        }
        return gridLayout;
    }

    public void createSpinner() {
        Spinner spinner = findViewById(R.id.userSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mapIcons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // String text = parent.getItemIdAtPosition(position).toString();
        //  Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        // b1.setText(text);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public char[][] preset(){
        char[][] easy = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int b = 0; b < 10; b++) {
                if(easy[i].equals(0) || easy[i].equals(10)){
                    easy[i][b] = '#';
                }
                else{
                    easy[i][b] ='-';
                }
            }
        }
        easy[1][9] ='p';
        easy[8][5] ='g';
        return easy;
    }


    public String toString() {
        return convert.charArrayToString(preset());
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
