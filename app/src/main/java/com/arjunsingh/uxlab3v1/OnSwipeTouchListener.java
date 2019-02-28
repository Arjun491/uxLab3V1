package com.arjunsingh.uxlab3v1;

import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.view.*;

import android.widget.Toast;

public class OnSwipeTouchListener implements View.OnTouchListener
{
private final Context context;
private final GestureDetector gestureDetector;
public OnSwipeTouchListener(Context context)
{
    gestureDetector=new GestureDetector(context,new GestureListener());
    this.context=context;

}

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    public void onSwipeRight()
    {
       Toast.makeText(context,"Swiped right!",Toast.LENGTH_SHORT).show();
    } public void onSwipeLeft()
    {
       Toast.makeText(context,"Swiped Left!",Toast.LENGTH_SHORT).show();
    } public void onSwipeUp()
    {
       Toast.makeText(context,"Swiped Up!",Toast.LENGTH_SHORT).show();
    }
    public void onSwipeDown()
    {
       Toast.makeText(context,"Swiped Down!",Toast.LENGTH_SHORT).show();
    }

    private final class  GestureListener extends GestureDetector.SimpleOnGestureListener
{
private static  final int SWIPE_DIST_THRESHOLD=100;
private static  final int SWIPE_VEL_THRESHOLD=100;
public boolean onFling(MotionEvent e1, MotionEvent e2 , float velocityX, float velocityY)
{
    float distX=e2.getX()-e1.getX();
    float distY=e2.getY()-e1.getY();
    if (Math.abs(distX)>Math.abs(distY) && Math.abs(distX)>SWIPE_DIST_THRESHOLD && Math.abs(velocityX)>SWIPE_VEL_THRESHOLD)
    {
        if (distX>0)
        {
            onSwipeRight();
        }
        else
        {
            onSwipeLeft();
        }
        return true;
    }
    else if(Math.abs(distX)<Math.abs(distY)
            && Math.abs(distY)>SWIPE_DIST_THRESHOLD
            && Math.abs(velocityY)>SWIPE_VEL_THRESHOLD)
    {
        if (distY>0)
        {
            onSwipeDown();
        }
        else
        {
            onSwipeUp();
        }
        return true;
    }
    return false;


} // end of fling
    @Override
    public boolean onDown(MotionEvent e)
    {
        return true;
    }

}
}
