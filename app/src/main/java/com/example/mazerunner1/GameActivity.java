package com.example.mazerunner1;

import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mazerunner1.R;
import com.example.mazerunner1.rendering.MazeGame;
import com.example.mazerunner1.rendering.MazeWindow;
import com.example.mazerunner1.rendering.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameActivity extends AppCompatActivity {
    final static String TAG = "GameActivity";
    private GameSettings gameSettings;
    private MazeConverter mazeConverter;
    private File mazeFile;
    private MazeGame mazeGame;
    private Player player;
    private Maze maze;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.game_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        gameSettings = new GameSettings(0.5, 0.4, 0, 70);
        String mazeFilename =  (String) getIntent().getExtras().get("MAZE_FILE");
        try {
            InputStream inputStream = getAssets().open("mazes/" + mazeFilename);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line).append('\n');
            }
            String mazeData = total.toString();
            Log.d(TAG, "initGameComponents: gameSettings is null? " + (gameSettings == null));
            mazeConverter = new MazeConverter(gameSettings);
            Log.d(TAG, "initGameComponents: " + gameSettings.getFov());
            mazeConverter.parseMaze(mazeData);
            Log.d(TAG, "initGameComponents: Maze parsed.");
            player = mazeConverter.getPlayer();
            Log.d(TAG, "initGameComponents: Player got.");
            maze = mazeConverter.getMaze();
            Log.d(TAG, "initGameComponents: Maze got.");
        } catch (Exception e) {
            Log.d(TAG, "initGameComponents: " + e.toString());
            Utilities.notifyException(this, e);
        }
    }

    private void initUI() {
        Log.d(TAG, "initUI: this.player is null? " + (this.player == null));
        TextView mazeView = findViewById(R.id.mazeView);
        Button forward = findViewById(R.id.forward);
        Button back = findViewById(R.id.back);
        Button left = findViewById(R.id.left);
        Button right = findViewById(R.id.right);
        Log.d(TAG,"initUI: Making MazeGame of size " + mazeView.getWidth() + "x" + mazeView.getHeight() );
        mazeGame = new MazeGame(mazeView.getWidth(), mazeView.getHeight(), maze, player);

        mazeView.setText(mazeGame.getMazeRender());

        forward.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Forward pressed.");
                mazeGame.moveForward(gameSettings.getMoveSpeed());
                return true;
            }
        });

        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Backward pressed.");
                mazeGame.moveBackward(gameSettings.getMoveSpeed());
                return true;
            }
        });

        left.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Left pressed.");
                mazeGame.turnLeft(gameSettings.getTurnSpeed());
                return true;
            }
        });

        right.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Right pressed.");
                mazeGame.turnRight(gameSettings.getTurnSpeed());
                return true;
            }
        });
    }
}
