package com.arjunsingh.uxlab3v1;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Dimension;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.textViewSample); // change text view //
        Button  myTextButton =(Button)findViewById(R.id.btnChangeText); // to change place text to the bottom //
        Button myImageButton=(Button)findViewById(R.id.btnChangeScale); // button for change scale //
        final ImageView myImage = (ImageView)findViewById(R.id.imageViewSample); // image view for 2 images //
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
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(myImage.getScaleType()==ImageView.ScaleType.FIT_CENTER)
                {
                    myImage.setScaleType(ImageView.ScaleType.FIT_XY);


                }
                else
                {
                    myImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        });
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myImage.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.puppy).getConstantState()))
                {
                    myImage.setImageResource(R.drawable.darkbg2);
                }
                else
                {
                    myImage.setImageResource(R.drawable.puppy);
                }
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (textView.getText().toString().equals("new line goes here \n Second line \n Third line \n fourth line "))
                {
                    textView.setText("change text after the long click \n  line 2");

                }
                else
                {
                    textView.setText("new line goes here \n Second line \n Third line \n fourth line ");
                }
                return true;
            }
        });
        myTextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                ViewGroup.LayoutParams layoutParams=textView.getLayoutParams();
                layoutParams.height=400;
                layoutParams.width=400;
                textView.setLayoutParams(layoutParams);
                textView.setText("\"new line goes here \\n Second line \\n Third line \\n fourth line \"");
                textView.setPadding(8,8,8,8);
                Drawable img=getDrawable(R.drawable.puppy);
                img.setBounds(0,0,100,100);
                textView.setCompoundDrawables(img,null,null,null);
                textView.setBackgroundColor(Color.parseColor("#007800"));
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(Dimension.SP,18);
                textView.setMaxLines(3);
                Toast.makeText(MainActivity.this,textView.getText(),Toast.LENGTH_SHORT).show();
                textView.setVisibility(View.VISIBLE);
            }
        });
    }
}
