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

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameActivity extends AppCompatActivity {
    final static String TAG = "GameActivity";
    final static double MOVE_SPEED = 0.2;
    MazeGame maze;

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
        initUI();
    }

    private void initUI() {
        TextView mazeView = findViewById(R.id.mazeView);
        Button forward = findViewById(R.id.forward);
        Button back = findViewById(R.id.back);
        Button left = findViewById(R.id.left);
        Button right = findViewById(R.id.right);
        //MazeGame maze = new MazeGame(mazeView.getWidth(), mazeView.getHeight(), null, null);
        //mazeView.setText(maze.getMazeRender());

        forward.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Forward pressed.");
                //maze.moveForward(MOVE_SPEED);
                return true;
            }
        });

        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Backward pressed.");
                //maze.moveBackward(MOVE_SPEED);
                return true;
            }
        });

        left.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Left pressed.");
                //maze.turnLeft(MOVE_SPEED);
                return true;
            }
        });

        right.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(TAG, "onLongClick: Right pressed.");
                //maze.turnRight(MOVE_SPEED);
                return true;
            }
        });
    }

    GLSurfaceView.Renderer mazeRenderer = new GLSurfaceView.Renderer() {
        @Override
        public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

        }

        @Override
        public void onSurfaceChanged(GL10 gl10, int i, int i1) {

        }

        @Override
        public void onDrawFrame(GL10 gl10) {
            
        }
    };
}
