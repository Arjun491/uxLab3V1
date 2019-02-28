package com.arjunsingh.uxlab3v1;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.view.*;

import android.widget.Toast;

public class OnSwipeTouchListener implements View.OnTouchListener
{
private final GestureDetector gestureDetector;
private final Context context;

    public OnSwipeTouchListener( Context context) {
    gestureDetector=new GestureDetector(context,new GestureDetector());
    this.context=context;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    public void onSwipeRight()
    {
        Toast.makeText(context,"swiped right",Toast.LENGTH_SHORT).show();
    }
    public void onSwipeLeft()
    {
        Toast.makeText(context,"swiped left ",Toast.LENGTH_SHORT).show();
    }
    public void onSwupeUp()
    {
        Toast.makeText(context,"swiped Up",Toast.LENGTH_SHORT).show();
    }

    public void onSwipeDown()
    {

        Toast.makeText(context,"swiped Down",Toast.LENGTH_SHORT).show();
    }
    public class Gest
}
