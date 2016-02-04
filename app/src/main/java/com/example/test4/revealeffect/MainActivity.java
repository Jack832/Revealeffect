package com.example.test4.revealeffect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt1;
    ImageView img1;
    ToggleButton toggleButton;
    //circular menu
    LinearLayout linear;
    private boolean hidden=true;
    ImageView imagone,imgtwo,imagthree,imagefour;
   //message
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt1=(TextView)findViewById(R.id.title);
        img1=(ImageView)findViewById(R.id.image);
        toggleButton=(ToggleButton)findViewById(R.id.toggleBtn);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //reveal
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hide(txt1);
                    hide(img1);
                } else {
                    show(txt1);
                    show(img1);
                }
            }
        });
         initView();
        b1=(Button)findViewById(R.id.Message);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Txt.class);
                startActivity(i);
            }
        });
//        TextView text= new TextView(this);
//        Uri sms=Uri.parse("content://sms//inbox/5554");
//        Cursor cur=getContentResolver().query(sms,null,null,null,null);
//        String smsread=" ";
//        while(cur.moveToNext()){
//            smsread+=":from"+cur.getString(2)+" :"+cur.getString(11)+"\n";
//        }
//        text.setText(smsread);
//        setContentView(text);
    }

    private void initView() {
        linear=(LinearLayout)findViewById(R.id.Reveal_item);
        linear.setVisibility(View.GONE);
        imagone=(ImageView)findViewById(R.id.image1);
        imgtwo=(ImageView)findViewById(R.id.image2);
        imagthree=(ImageView)findViewById(R.id.image3);
        imagefour=(ImageView)findViewById(R.id.image4);
        imagone.setOnClickListener(this);
        imgtwo.setOnClickListener(this);
        imagthree.setOnClickListener(this);
        imagefour.setOnClickListener(this);


    }

    private void show(final View view) {
        int cx = (view.getRight() + view.getLeft()) / 2;
        int cy = (view.getTop() + view.getRight()) / 2;
        int radius = view.getWidth();
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, radius, 0);
        anim.setDuration(1000);


        anim.addListener(new AnimatorListenerAdapter() {
            @Override
           public void onAnimationEnd(Animator animation) {

               super.onAnimationEnd(animation);
               view.setVisibility(view.INVISIBLE);
            }
        });
       // view.setVisibility(view.INVISIBLE);
        anim.start();
    }

    //finding center point
    private void hide(final View view) {
        int cx=(view.getLeft()+view.getRight())/2;
        int cy=(view.getTop()+view.getBottom())/2;
        //radius for circle
        int finalradius=Math.max(view.getWidth(), view.getHeight());
        //radius start with zero
         Animator anim= ViewAnimationUtils.createCircularReveal(view,cx,cy,0,finalradius);
        anim.setDuration(1000);
        view.setVisibility(view.VISIBLE);

        anim.start();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_clip){
            int cx=(linear.getLeft()+linear.getRight())/2;
            int cy=(linear.getTop()+linear.getBottom())/2;
            int radius=linear.getWidth();
            int radius1=Math.max(linear.getWidth(),linear.getHeight());

            if(hidden){
                Animator anim3=ViewAnimationUtils.createCircularReveal(linear,cx,cy,0,radius);
                anim3.setDuration(1000);
                linear.setVisibility(View.VISIBLE);
                anim3.start();
                hidden = false;

            }
            else{
                Animator anim4=ViewAnimationUtils.createCircularReveal(linear,cx,cy,radius1,0);
                anim4.setDuration(1000);
                linear.setVisibility(View.INVISIBLE);
                anim4.start();
                hidden=true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Hiderevalview();
        Toast.makeText(MainActivity.this,"clicked its working",Toast.LENGTH_SHORT).show();
    }

    private void Hiderevalview() {
        if(linear.getVisibility()==View.VISIBLE){
            linear.setVisibility(View.GONE);
            hidden=true;
        }
    }
}
