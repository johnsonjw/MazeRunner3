package com.example.mazerunner1;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mazerunner1.rendering.MazeGame;
import com.example.mazerunner1.rendering.Player;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GameActivity extends AppCompatActivity {
    final static String TAG = "GameActivity";
    private GameSettings gameSettings;
    private MazeGame mazeGame;
    private Player player;
    private Maze maze;
    private TextView mazeView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.game_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.gameToolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initGameComponents();
        initUI();
    }

    private void initGameComponents() {
        gameSettings = new GameSettings(1, 4, 0, 70);
        String mazeFilename =  (String) getIntent().getExtras().get("MAZE_FILE");
        try {
            InputStream inputStream = getAssets().open("mazes/" + mazeFilename);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line).append('\n');
            }
            String mazeData = total.toString();
            MazeConverter mazeConverter = new MazeConverter(gameSettings);
            mazeConverter.parseMaze(mazeData);
            player = mazeConverter.getPlayer();
            maze = mazeConverter.getMaze();
        } catch (Exception e) {
            Log.d(TAG, "initGameComponents: " + e.toString());
            Utilities.notifyException(this, e);
        }
    }

    private void initUI() {
        mazeView = findViewById(R.id.mazeView);
        Button forward = findViewById(R.id.forward);
        Button back = findViewById(R.id.back);
        Button left = findViewById(R.id.left);
        Button right = findViewById(R.id.right);
        mazeGame = new MazeGame(70, 20, maze, player);
        mazeView.setText(mazeGame.getMazeRender());

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mazeGame.moveForward(gameSettings.getMoveSpeed());
                mazeView.setText(mazeGame.getMazeRender());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mazeGame.moveBackward(gameSettings.getMoveSpeed());
                mazeView.setText(mazeGame.getMazeRender());
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mazeGame.turnLeft(gameSettings.getTurnSpeed());
                mazeView.setText(mazeGame.getMazeRender());
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Right pressed.");
                mazeGame.turnRight(gameSettings.getTurnSpeed());
                mazeView.setText(mazeGame.getMazeRender());
            }
        });
    }
}
