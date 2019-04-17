package com.example.mazerunner1;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
}
