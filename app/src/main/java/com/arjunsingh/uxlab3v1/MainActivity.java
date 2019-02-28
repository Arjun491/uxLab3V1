package com.arjunsingh.uxlab3v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.textViewSample);
        textView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this)

                                    {


                             @Override
                             public void onSwipeRight()
                             {
                                 super.onSwipeRight();
                                 int gravity=textView.getGravity();
                                 int verticalGravity=gravity& Gravity.VERTICAL_GRAVITY_MASK;
                                 textView.setGravity(Gravity.RIGHT | verticalGravity);

                             }  @Override
                             public void onSwipeLeft()
                             {
                                 super.onSwipeLeft();
                                 int gravity=textView.getGravity();
                                 int verticalGravity=gravity& Gravity.VERTICAL_GRAVITY_MASK;
                                 textView.setGravity(Gravity.LEFT|verticalGravity);

                             }  @Override
                             public void onSwipeUp()
                             {
                                 super.onSwipeUp();
                                 int gravity=textView.getGravity();
                                 int verticalGravity=gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                                 textView.setGravity(Gravity.TOP|verticalGravity);

                             }  @Override
                             public void onSwipeDown()
                             {
                                 super.onSwipeDown();
                                 int gravity=textView.getGravity();
                                 int verticalGravity=gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                                 textView.setGravity(Gravity.BOTTOM | verticalGravity);

                             }








                                    } );
    }
}
