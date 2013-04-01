package com.example.controlmyfood.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.controlmyfood.R;

public class MyGridView extends GridView {
	 
    private Bitmap background;
 
    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.item_background);
    }
    
    @Override
    protected void dispatchDraw(Canvas canvas) {
        final int count = getChildCount();
        final int top = count > 0 ? getChildAt(0).getTop() : 0;
        final int backgroundWidth = background.getWidth();
        final int backgroundHeight = background.getHeight();
        final int width = getWidth();
        final int height = getHeight();
        final Bitmap background = this.background;

        for (int x = 0; x < width; x += backgroundWidth) {
            for (int y = top; y < height; y += backgroundHeight) {
                canvas.drawBitmap(background, x, y, null);
            }

            //This draws the top pixels of the shelf above the current one

            Rect source = new Rect(0, backgroundHeight - top, backgroundWidth, backgroundHeight);
            Rect dest = new Rect(x, 0, x + backgroundWidth, top );              

            canvas.drawBitmap(background, source, dest, null);            
        }       
     
        super.dispatchDraw(canvas);
    }
 
}