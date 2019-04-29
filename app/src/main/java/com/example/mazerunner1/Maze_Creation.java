
package com.example.mazerunner1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.*;


public class Maze_Creation extends  AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    private LinearLayout parent;
    private Button b1;
    private Button b2;
    public int inputX;
    public int inputY;
    public int testX = 10;
    public int testY = 10;
    public  ArrayList<String> gridLayout = new ArrayList<>();


    //ToDo Generate dynamic based on the input from the user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createSpinner();
        createDynamicButtons(testX, testY);
        createDynamicButtons(testX, testY);
    }

    public void GetXandY(int x, int y) {
        inputX = x;
        inputY = y;
    }


    public ArrayList<String> createDynamicButtons(int x,int y) {
        for (int i = 0; i < x; i++) {
            b1 = new Button(this);
            gridLayout.add((String)b1.getText());
            b1.setId(i + 1);
            for (int b = 0; b < y; b++) {
                b2 = new Button(this);
                gridLayout.add((String)b2.getText());
                b2.setId(b + 1);

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
        String text = parent.getItemIdAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        b1.setText(text);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public String toString() {
       return "";
    }


//}
}



