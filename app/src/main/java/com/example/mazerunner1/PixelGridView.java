package com.example.mazerunner1;
//Most of this code comes from https://stackoverflow.com/questions/24842550/2d-array-grid-on-drawing-canvas
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class PixelGridView extends View {

    private int screenWidth;
    private int screenHeight;
    public static final int GAP_WIDTH_DP = 62;
    private float GAP_WIDTH_PIXEL;
    private Paint paint = new Paint();

    public PixelGridView(Context context) {
        super(context);
        init(context);
    }

    public PixelGridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public PixelGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PixelGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public void init(Context context) {

        // set paint color
        paint.setColor(Color.GREEN);

        // get view dimentions
        getScreenDimensions();

    }

    private void getScreenDimensions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        //gap size in pixel
        GAP_WIDTH_PIXEL = convertDpToPixel(GAP_WIDTH_DP, getContext());

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        getScreenDimensions();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw Horizontal line from Y= 0 -> Y+=Gap... till screen width
        float verticalPosition = 0;

        while (verticalPosition <= screenHeight) {

            canvas.drawLine(0, verticalPosition,
                    screenWidth, verticalPosition, paint);

            verticalPosition += GAP_WIDTH_PIXEL;

        }

        // draw Vertical line from X=0 -> X+=Gap... till screen Height 0|||hor+gap|||W
        float horizontalPosition = 0;

        while (horizontalPosition <= screenWidth) {

            canvas.drawLine(horizontalPosition, 0,
                    horizontalPosition, screenHeight, paint);

            horizontalPosition += GAP_WIDTH_PIXEL;

        }

    }
}