
package com.example.mazerunner1;
import android.os.Bundle;
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


public class Maze_Creation extends  AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    private LinearLayout parent;
    private Button b1;
    private Button b2;
    public int inputX;
    public int inputY;
    public int testX = 10;
    public int testY = 10;
  //  public String[] buttonName = ["b1","b2","b3","b4","b5","b6","b7","b8","b9","b10"]
    public String[] Maze;


    //ToDo Generate dynamic based on the input from the user
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createSpinner();

        createDynamicButtons(testX, testY);
    }

    public void GetXandY(int x, int y) {
        inputX = x;
        inputY = y;
    }


    public void createDynamicButtons(int x,int y) {
        for (int i = 0; i < x; i++) {
            for (int b = 0; b < y; b++) {
               //b1 = new Button();
                // b2 = new Button(create.this);
                b1.setId(i + 1);
                b2.setId(b + 1);
                b1.setText("");
            }
        }
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
        //String text = parent.getItemIdAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


/* public String toString() {
        String out = "";
        for (int x = 0; x < mazeGrid[0].length; x++) {
            for (int y = 0; y < mazeGrid[1].length; y++) {
                mazeGrid[x][y] = '#';

            }
            if ()
        }
        return  out;
    }*/


//}
}



