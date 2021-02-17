package com.sahil.tictactoe1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sahil.tictactoe1.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int ans = 0;
    int game[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int winpos[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    boolean draw=false,gameOver=false;
    TextView textView;
    Button button,ok,button3;
    String name1 = "", name2 = "",diff="";
    Dialog dialog;
    String[] name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView=getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            );}
        textView = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);
        button3=(Button)findViewById(R.id.button3);
        button.setTranslationX(-1000);
        button3.setTranslationX(1000);
        Intent intent = getIntent();
        dialog=new Dialog(this);
        name = intent.getExtras().getStringArray("name");
        name1 = name[0];
        name2 = name[1];
        diff=name[2];
        if(name1.equals("Your"))
            textView.setText(name1 + " Chance");
        else
        textView.setText(name1 + "'s Chance");
    }
    public void again(View View)
    {

        Intent intent = new Intent(MainActivity.this,Login.class);
        String arr[] = {name1, name2,diff};
        intent.putExtra("name", arr);
        startActivity(intent);
        finish();
    }
    private int findBestMove(int[] game) {

        Random rand = new Random();
        int x = 0;
        int fin = 10;
        if (i == 1) {
            if (game[4] == -1) {
                while (x == 4)
                    x = rand.nextInt(8);
                fin = x;
            } else
                fin = 4;
        } else {
            if(game[2]==-1&&game[3]==-1&&game[1]==1&&game[4]==1&&game[7]==-1&&game[6]==0)
                return 6;
            else if(game[0]==-1&&game[5]==-1&&game[4]==1&&game[1]==1&&game[7]==-1&&game[8]==0)
                return 8;
            else if(game[1]==-1&&game[5]==-1&&game[4]==1&&game[3]==1&&game[6]==-1&&game[2]==0)
                return 2;
            else if(game[5]==-1&&game[7]==-1&&game[8]==0)
                return 8;
            else if (game[0] == 1 && game[1] == 1 && game[2] == 0)
                fin = 2;
            else if (game[0] == 1 && game[2] == 1 && game[1] == 0)
                fin = 1;
            else if (game[0] == 0 && game[2] == 1 && game[1] == 1)
                fin = 0;
            else if (game[3] == 1 && game[4] == 1 && game[5] == 0)
                fin = 5;
            else if (game[3] == 1 && game[5] == 1 && game[4] == 0)
                fin = 4;
            else if (game[3] == 0 && game[5] == 1 && game[4] == 1)
                fin = 3;
            else if (game[6] == 1 && game[7] == 1 && game[8] == 0)
                fin = 8;
            else if (game[6] == 1 && game[8] == 1 && game[7] == 0)
                fin = 7;
            else if (game[6] == 0 && game[8] == 1 && game[7] == 1)
                fin = 6;
            else if (game[0] == 1 && game[3] == 1 && game[6] == 0)
                fin = 6;
            else if (game[0] == 1 && game[6] == 1 && game[3] == 0)
                fin = 3;
            else if (game[0] == 0 && game[6] == 1 && game[3] == 1)
                fin = 0;
            else if (game[1] == 1 && game[4] == 1 && game[7] == 0)
                fin = 7;
            else if (game[1] == 1 && game[7] == 1 && game[4] == 0)
                fin = 4;
            else if (game[1] == 0 && game[4] == 1 && game[7] == 1)
                fin = 1;
            else if (game[2] == 1 && game[5] == 1 && game[8] == 0)
                fin = 8;
            else if (game[2] == 1 && game[8] == 1 && game[5] == 0)
                fin = 5;
            else if (game[2] == 0 && game[5] == 1 && game[8] == 1)
                fin = 2;
            else if (game[0] == 1 && game[4] == 1 && game[8] == 0)
                fin = 8;
            else if (game[0] == 1 && game[8] == 1 && game[4] == 0)
                fin = 4;
            else if (game[0] == 0 && game[8] == 1 && game[4] == 1)
                fin = 0;
            else if (game[2] == 1 && game[4] == 1 && game[6] == 0)
                fin = 6;
            else if (game[2] == 1 && game[6] == 1 && game[4] == 0)
                fin = 4;
            else if (game[2] == 0 && game[6] == 1 && game[4] == 1)
                fin = 2;
            else if (game[0] == -1 && game[1] == -1 && game[2] == 0)
                fin = 2;
            else if (game[0] == -1 && game[2] == -1 && game[1] == 0)
                fin = 1;
            else if (game[0] == 0 && game[2] == -1 && game[1] == -1)
                fin = 0;
            else if (game[3] == -1 && game[4] == -1 && game[5] == 0)
                fin = 5;
            else if (game[3] == -1 && game[5] == -1 && game[4] == 0)
                fin = 4;
            else if (game[3] == 0 && game[5] == -1 && game[4] == -1)
                fin = 3;
            else if (game[6] == -1 && game[7] == -1 && game[8] == 0)
                fin = 8;
            else if (game[6] == -1 && game[8] == -1 && game[7] == 0)
                fin = 7;
            else if (game[6] == 0 && game[8] == -1 && game[7] == -1)
                fin = 6;
            else if (game[0] == -1 && game[3] == -1 && game[6] == 0)
                fin = 6;
            else if (game[0] == -1 && game[6] == -1 && game[3] == 0)
                fin = 3;
            else if (game[0] == 0 && game[6] == -1 && game[3] == -1)
                fin = 0;
            else if (game[1] == -1 && game[4] == -1 && game[7] == 0)
                fin = 7;
            else if (game[1] == -1 && game[7] == -1 && game[4] == 0)
                fin = 4;
            else if (game[1] == 0 && game[4] == -1 && game[7] == -1)
                fin = 1;
            else if (game[2] == -1 && game[5] == -1 && game[8] == 0)
                fin = 8;
            else if (game[2] == -1 && game[8] == -1 && game[5] == 0)
                fin = 5;
            else if (game[2] == 0 && game[5] == -1 && game[8] == -1)
                fin = 2;
            else if (game[0] == -1 && game[4] == -1 && game[8] == 0)
                fin = 8;
            else if (game[0] == -1 && game[8] == -1 && game[4] == 0)
                fin = 4;
            else if (game[0] == 0 && game[8] == -1 && game[4] == -1)
                fin = 0;
            else if (game[2] == -1 && game[4] == -1 && game[6] == 0)
                fin = 6;
            else if (game[2] == -1 && game[6] == -1 && game[4] == 0)
                fin = 4;
            else if (game[2] == 0 && game[6] == -1 && game[4] == -1)
                fin = 2;

            else {

                    

                            if(game[0]==1&&game[1]==0&&game[2]==0)
                                fin=2;
                            else if(game[3]==1&&game[4]==0&&game[5]==0)
                                fin=4;
                            else if(game[6]==1&&game[7]==0&&game[8]==0)
                                fin=7;
                             else if(game[0]==1&&game[3]==0&&game[6]==0)
                                fin=3;
                             else if(game[1]==1&&game[4]==0&&game[7]==0)
                                 fin=4;
                             else if(game[2]==1&&game[5]==0&&game[8]==0)
                                fin=5;
                        else if(game[1]==1&&game[0]==0&&game[2]==0)
                            fin=2;
                        else if(game[4]==1&&game[3]==0&&game[5]==0)
                            fin=3;
                        else if(game[7]==1&&game[6]==0&&game[8]==0)
                            fin=6;
                        else if(game[3]==1&&game[0]==0&&game[6]==0)
                            fin=0;
                        else if(game[4]==1&&game[1]==0&&game[7]==0)
                            fin=1;
                        else if(game[5]==1&&game[2]==0&&game[8]==0)
                            fin=2;
                            else if(game[2]==1&&game[0]==0&&game[1]==0)
                                fin=0;
                            else if(game[5]==1&&game[3]==0&&game[4]==0)
                                fin=4;
                            else if(game[8]==1&&game[6]==0&&game[7]==0)
                                fin=6;
                            else if(game[6]==1&&game[0]==0&&game[3]==0)
                                fin=0;
                            else if(game[7]==1&&game[1]==0&&game[4]==0)
                                fin=1;
                            else if(game[8]==1&&game[2]==0&&game[5]==0)
                                fin=2;
                            else if(game[0]==1&&game[4]==0&&game[8]==0)
                                fin=4;
                            else if(game[4]==1&&game[0]==0&&game[8]==0)
                                fin=0;
                            else if(game[8]==1&&game[0]==0&&game[4]==0)
                                fin=0;
                            else if(game[2]==1&&game[4]==0&&game[6]==0)
                                fin=4;
                            else if(game[4]==1&&game[2]==0&&game[6]==0)
                                fin=2;
                            else if(game[6]==1&&game[2]==0&&game[4]==0)
                                fin=2;


                    
                    if(fin==10)
                        for (int j = 0; j < 9; j++)
                            if (game[j] == 0)
                                fin = j;
            }
        }
        return fin;
    }

    public void dropin(View view) throws InterruptedException {
        imageView1 = (ImageView) findViewById(R.id.r1c1);
        imageView2 = (ImageView) findViewById(R.id.r1c2);
        imageView3 = (ImageView) findViewById(R.id.r1c3);
        imageView4 = (ImageView) findViewById(R.id.r2c1);
        imageView5 = (ImageView) findViewById(R.id.r2c2);
        imageView6 = (ImageView) findViewById(R.id.r2c3);
        imageView7 = (ImageView) findViewById(R.id.r3c1);
        imageView8 = (ImageView) findViewById(R.id.r3c2);
        imageView9 = (ImageView) findViewById(R.id.r3c3);
        textView = (TextView) findViewById(R.id.textView3);


        ImageView counter = (ImageView) view;
        int tag = Integer.parseInt(counter.getTag().toString());
        final String[] x1 = {"Computer's Chance"};
        if (name2.equals("Computer")) {
            counter.setImageResource(R.drawable.cross);
            counter.setClickable(false);
            i++;
            game[tag] = -1;

            finaly(i);
            Log.d("I",String.valueOf(i));
            if(i<9&&gameOver==false){
                textView.setTextColor(Color.parseColor("#0055FF"));
            textView.setText(name2 + "'s Chance");}

            new CountDownTimer(1000,200) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if (i < 9&&gameOver==false)
                        textView.setText(x1[0]);
                    x1[0] = x1[0] + ".";
                    if (game[0] == 0)
                        imageView1.setClickable(false);
                    if (game[1] == 0)
                        imageView2.setClickable(false);
                    if (game[2] == 0)
                        imageView3.setClickable(false);
                    if (game[3] == 0)
                        imageView4.setClickable(false);
                    if (game[4] == 0)
                        imageView5.setClickable(false);
                    if (game[5] == 0)
                        imageView6.setClickable(false);
                    if (game[6] == 0)
                        imageView7.setClickable(false);
                    if (game[7] == 0)
                        imageView8.setClickable(false);
                    if (game[8] == 0)
                        imageView9.setClickable(false);

                }

                @Override
                public void onFinish() {
                    if (gameOver == false) {
                        int x=99;
                        if(diff.equals("impossible"))
                            x = findBestMove(game);
                        else if(diff.equals("mediocre"))
                            x=findBestMoveMed(game);
                        else if(diff.equals("easy"))
                            x=findBestMoveEasy(game);
                        i++;
                        if (game[0] == 0)
                            imageView1.setClickable(true);
                        if (game[1] == 0)
                            imageView2.setClickable(true);
                        if (game[2] == 0)
                            imageView3.setClickable(true);
                        if (game[3] == 0)
                            imageView4.setClickable(true);
                        if (game[4] == 0)
                            imageView5.setClickable(true);
                        if (game[5] == 0)
                            imageView6.setClickable(true);
                        if (game[6] == 0)
                            imageView7.setClickable(true);
                        if (game[7] == 0)
                            imageView8.setClickable(true);
                        if (game[8] == 0)
                            imageView9.setClickable(true);
                        if (x == 0) {
                            imageView1.setImageResource(R.drawable.zero);
                            imageView1.animate().alpha(1f).setDuration(500);
                            imageView1.setClickable(false);
                        } else if (x == 1) {
                            imageView2.setImageResource(R.drawable.zero);
                            imageView2.animate().alpha(1f).setDuration(500);
                            imageView2.setClickable(false);
                        } else if (x == 2) {
                            imageView3.setImageResource(R.drawable.zero);
                            imageView3.animate().alpha(1f).setDuration(500);
                            imageView3.setClickable(false);
                        } else if (x == 3) {
                            imageView4.setImageResource(R.drawable.zero);
                            imageView4.animate().alpha(1f).setDuration(500);
                            imageView4.setClickable(false);
                        } else if (x == 4) {
                            imageView5.setImageResource(R.drawable.zero);
                            imageView5.animate().alpha(1f).setDuration(500);
                            imageView5.setClickable(false);
                        } else if (x == 5) {
                            imageView6.setImageResource(R.drawable.zero);
                            imageView6.animate().alpha(1f).setDuration(500);
                            imageView6.setClickable(false);
                        } else if (x == 6) {
                            imageView7.setImageResource(R.drawable.zero);
                            imageView7.animate().alpha(1f).setDuration(500);
                            imageView7.setClickable(false);
                        } else if (x == 7) {
                            imageView8.setImageResource(R.drawable.zero);
                            imageView8.animate().alpha(1f).setDuration(500);
                            imageView8.setClickable(false);
                        } else if (x == 8) {
                            imageView9.setImageResource(R.drawable.zero);
                            imageView9.animate().alpha(1f).setDuration(500);
                            imageView9.setClickable(false);
                        }

                        if (x < 9)
                            game[x] = 1;

                        textView.setTextColor(Color.parseColor("#FF9800"));
                        if (name1.equals("Your"))
                            textView.setText(name1 + " Chance");
                        else
                            textView.setText(name1 + "'s Chance");

                        finaly(i);
                    }
                }

            }.start();

        }


        else {
            if (i % 2 == 0) {
                counter.setImageResource(R.drawable.cross);

                game[tag] = -1;textView.setTextColor(Color.parseColor("#0055FF"));
                textView.setText(name2 + "'s Chance");

            } else {
                counter.setImageResource(R.drawable.zero);
                game[tag] = 1;textView.setTextColor(Color.parseColor("#FF9800"));

                textView.setText(name1 + "'s Chance");

            }
            counter.animate().alpha(1f).setDuration(500);
            counter.setClickable(false);
            i++;
            finaly(i);
        }

}

    private int findBestMoveEasy(int[] game) {
        Random rand=new Random();
        int i=0;
        while (game[i]!=0)
            i=rand.nextInt(8);
        return i;
    }

    private int findBestMoveMed(int[] game) {
        Random rand = new Random();
        int x = 0;
        int fin = 10;
        if (i == 1) {
            if (game[4] == -1) {
                while (x == 4)
                    x = rand.nextInt(8);
                fin = x;
            } else
                fin = 4;
        } else {

          if (game[0] == 1 && game[1] == 1 && game[2] == 0)
                fin = 2;
            else if (game[0] == 1 && game[2] == 1 && game[1] == 0)
                fin = 1;
            else if (game[0] == 0 && game[2] == 1 && game[1] == 1)
                fin = 0;
            else if (game[3] == 1 && game[4] == 1 && game[5] == 0)
                fin = 5;
            else if (game[3] == 1 && game[5] == 1 && game[4] == 0)
                fin = 4;
            else if (game[3] == 0 && game[5] == 1 && game[4] == 1)
                fin = 3;
            else if (game[6] == 1 && game[7] == 1 && game[8] == 0)
                fin = 8;
            else if (game[6] == 1 && game[8] == 1 && game[7] == 0)
                fin = 7;
            else if (game[6] == 0 && game[8] == 1 && game[7] == 1)
                fin = 6;
            else if (game[0] == 1 && game[3] == 1 && game[6] == 0)
                fin = 6;
            else if (game[0] == 1 && game[6] == 1 && game[3] == 0)
                fin = 3;
            else if (game[0] == 0 && game[6] == 1 && game[3] == 1)
                fin = 0;
            else if (game[1] == 1 && game[4] == 1 && game[7] == 0)
                fin = 7;
            else if (game[1] == 1 && game[7] == 1 && game[4] == 0)
                fin = 4;
            else if (game[1] == 0 && game[4] == 1 && game[7] == 1)
                fin = 1;
            else if (game[2] == 1 && game[5] == 1 && game[8] == 0)
                fin = 8;
            else if (game[2] == 1 && game[8] == 1 && game[5] == 0)
                fin = 5;
            else if (game[2] == 0 && game[5] == 1 && game[8] == 1)
                fin = 2;
            else if (game[0] == 1 && game[4] == 1 && game[8] == 0)
                fin = 8;
            else if (game[0] == 1 && game[8] == 1 && game[4] == 0)
                fin = 4;
            else if (game[0] == 0 && game[8] == 1 && game[4] == 1)
                fin = 0;
            else if (game[2] == 1 && game[4] == 1 && game[6] == 0)
                fin = 6;
            else if (game[2] == 1 && game[6] == 1 && game[4] == 0)
                fin = 4;
            else if (game[2] == 0 && game[6] == 1 && game[4] == 1)
                fin = 2;
            else if (game[0] == -1 && game[1] == -1 && game[2] == 0)
                fin = 2;
            else if (game[0] == -1 && game[2] == -1 && game[1] == 0)
                fin = 1;
            else if (game[0] == 0 && game[2] == -1 && game[1] == -1)
                fin = 0;
            else if (game[3] == -1 && game[4] == -1 && game[5] == 0)
                fin = 5;
            else if (game[3] == -1 && game[5] == -1 && game[4] == 0)
                fin = 4;
            else if (game[3] == 0 && game[5] == -1 && game[4] == -1)
                fin = 3;
            else if (game[6] == -1 && game[7] == -1 && game[8] == 0)
                fin = 8;
            else if (game[6] == -1 && game[8] == -1 && game[7] == 0)
                fin = 7;
            else if (game[6] == 0 && game[8] == -1 && game[7] == -1)
                fin = 6;
            else if (game[0] == -1 && game[3] == -1 && game[6] == 0)
                fin = 6;
            else if (game[0] == -1 && game[6] == -1 && game[3] == 0)
                fin = 3;
            else if (game[0] == 0 && game[6] == -1 && game[3] == -1)
                fin = 0;
            else if (game[1] == -1 && game[4] == -1 && game[7] == 0)
                fin = 7;
            else if (game[1] == -1 && game[7] == -1 && game[4] == 0)
                fin = 4;
            else if (game[1] == 0 && game[4] == -1 && game[7] == -1)
                fin = 1;
            else if (game[2] == -1 && game[5] == -1 && game[8] == 0)
                fin = 8;
            else if (game[2] == -1 && game[8] == -1 && game[5] == 0)
                fin = 5;
            else if (game[2] == 0 && game[5] == -1 && game[8] == -1)
                fin = 2;
            else if (game[0] == -1 && game[4] == -1 && game[8] == 0)
                fin = 8;
            else if (game[0] == -1 && game[8] == -1 && game[4] == 0)
                fin = 4;
            else if (game[0] == 0 && game[8] == -1 && game[4] == -1)
                fin = 0;
            else if (game[2] == -1 && game[4] == -1 && game[6] == 0)
                fin = 6;
            else if (game[2] == -1 && game[6] == -1 && game[4] == 0)
                fin = 4;
            else if (game[2] == 0 && game[6] == -1 && game[4] == -1)
                fin = 2;

            else {



                if(game[0]==1&&game[1]==0&&game[2]==0)
                    fin=2;
                else if(game[3]==1&&game[4]==0&&game[5]==0)
                    fin=4;
                else if(game[6]==1&&game[7]==0&&game[8]==0)
                    fin=7;
                else if(game[0]==1&&game[3]==0&&game[6]==0)
                    fin=3;
                else if(game[1]==1&&game[4]==0&&game[7]==0)
                    fin=4;
                else if(game[2]==1&&game[5]==0&&game[8]==0)
                    fin=5;
                else if(game[1]==1&&game[0]==0&&game[2]==0)
                    fin=2;
                else if(game[4]==1&&game[3]==0&&game[5]==0)
                    fin=3;
                else if(game[7]==1&&game[6]==0&&game[8]==0)
                    fin=6;
                else if(game[3]==1&&game[0]==0&&game[6]==0)
                    fin=0;
                else if(game[4]==1&&game[1]==0&&game[7]==0)
                    fin=1;
                else if(game[5]==1&&game[2]==0&&game[8]==0)
                    fin=2;
                else if(game[2]==1&&game[0]==0&&game[1]==0)
                    fin=0;
                else if(game[5]==1&&game[3]==0&&game[4]==0)
                    fin=4;
                else if(game[8]==1&&game[6]==0&&game[7]==0)
                    fin=6;
                else if(game[6]==1&&game[0]==0&&game[3]==0)
                    fin=0;
                else if(game[7]==1&&game[1]==0&&game[4]==0)
                    fin=1;
                else if(game[8]==1&&game[2]==0&&game[5]==0)
                    fin=2;
                else if(game[0]==1&&game[4]==0&&game[8]==0)
                    fin=4;
                else if(game[4]==1&&game[0]==0&&game[8]==0)
                    fin=0;
                else if(game[8]==1&&game[0]==0&&game[4]==0)
                    fin=0;
                else if(game[2]==1&&game[4]==0&&game[6]==0)
                    fin=4;
                else if(game[4]==1&&game[2]==0&&game[6]==0)
                    fin=2;
                else if(game[6]==1&&game[2]==0&&game[4]==0)
                    fin=2;



                if(fin==10)
                    for (int j = 0; j < 9; j++)
                        if (game[j] == 0)
                            fin = j;
            }
        }
        return fin;

    }

    public void finaly(int j) {
    imageView1 = (ImageView) findViewById(R.id.r1c1);
    imageView2 = (ImageView) findViewById(R.id.r1c2);
    imageView3 = (ImageView) findViewById(R.id.r1c3);
    imageView4 = (ImageView) findViewById(R.id.r2c1);
    imageView5 = (ImageView) findViewById(R.id.r2c2);
    imageView6 = (ImageView) findViewById(R.id.r2c3);
    imageView7 = (ImageView) findViewById(R.id.r3c1);
    imageView8 = (ImageView) findViewById(R.id.r3c2);
    imageView9 = (ImageView) findViewById(R.id.r3c3);
    textView = (TextView) findViewById(R.id.textView3);


    int a = 10, b = 10, c = 10;
    if (((game[0] == 1) && (game[1] == 1) && (game[2] == 1))) {
        ans = 1;
        a = 0;
        b = 1;
        c = 2;
    } else if ((game[3] == 1) && (game[4] == 1) && (game[5] == 1)) {
        ans = 1;
        a = 3;
        b = 4;
        c = 5;
    } else if ((game[6] == 1) && (game[7] == 1) && (game[8] == 1)) {
        ans = 1;
        a = 6;
        b = 7;
        c = 8;
    } else if ((game[0] == 1) && (game[3] == 1) && (game[6] == 1)) {
        ans = 1;
        a = 0;
        b = 3;
        c = 6;
    } else if ((game[1] == 1) && (game[4] == 1) && (game[7] == 1)) {
        ans = 1;
        a = 1;
        b = 4;
        c = 7;
    } else if ((game[2] == 1) && (game[5] == 1) && (game[8] == 1)) {
        ans = 1;
        a = 2;
        b = 5;
        c = 8;
    } else if ((game[0] == 1) && (game[4] == 1) && (game[8] == 1)) {
        ans = 1;
        a = 0;
        b = 4;
        c = 8;
    } else if ((game[2] == 1) && (game[4] == 1) && (game[6] == 1)) {
        ans = 1;
        a = 2;
        b = 4;
        c = 6;
    } else if (((game[0] == -1) && (game[1] == -1) && (game[2] == -1))) {
        ans = -1;
        a = 0;
        b = 1;
        c = 2;
    } else if ((game[3] == -1) && (game[4] == -1) && (game[5] == -1)) {
        ans = -1;
        a = 3;
        b = 4;
        c = 5;
    } else if ((game[6] == -1) && (game[7] == -1) && (game[8] == -1)) {
        ans = -1;
        a = 6;
        b = 7;
        c = 8;
    } else if ((game[0] == -1) && (game[3] == -1) && (game[6] == -1)) {
        ans = -1;
        a = 0;
        b = 3;
        c = 6;
    } else if ((game[1] == -1) && (game[4] == -1) && (game[7] == -1)) {
        ans = -1;
        a = 1;
        b = 4;
        c = 7;
    } else if ((game[2] == -1) && (game[5] == -1) && (game[8] == -1)) {
        ans = -1;
        a = 2;
        b = 5;
        c = 8;
    } else if ((game[0] == -1) && (game[4] == -1) && (game[8] == -1)) {
        ans = -1;
        a = 0;
        b = 4;
        c = 8;
    } else if ((game[2] == -1) && (game[4] == -1) && (game[6] == -1)) {
        ans = -1;
        a = 2;
        b = 4;
        c = 6;
    } else if (j>=9) {draw=true;

        textView.setAlpha(0f);
        textView.animate().alpha(1f).setDuration(2000);
        textView.setText("It's a Draw");
        gameOver=true;
        imageView1.animate().alpha(0.3f).setDuration(800);
        imageView2.animate().alpha(0.3f).setDuration(800);
        imageView3.animate().alpha(0.3f).setDuration(800);
        imageView4.animate().alpha(0.3f).setDuration(800);
        imageView5.animate().alpha(0.3f).setDuration(800);
        imageView6.animate().alpha(0.3f).setDuration(800);
        imageView7.animate().alpha(0.3f).setDuration(800);
        imageView8.animate().alpha(0.3f).setDuration(800);
        imageView9.animate().alpha(0.3f).setDuration(800);

        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                openWinDailog();
            }

            @Override
            public void onFinish() {
                button.animate().translationX(0).setDuration(1000);
                button3.animate().translationX(0).setDuration(1000);
            }
        }.start();

    }


    if (ans == 1 || ans == -1) {
        gameOver=true;
        textView.animate().alpha(1f).setDuration(2000);
        textView.setAlpha(0f);
        if (ans == 1)
            textView.setText(name2 + " won");
        else {
            if(name1.equals("Your"))
                textView.setText("You win");
            else
            textView.setText(name1 + " won");
        }
        imageView1.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        imageView4.setClickable(false);
        imageView5.setClickable(false);
        imageView6.setClickable(false);
        imageView7.setClickable(false);
        imageView8.setClickable(false);
        imageView9.setClickable(false);
        if (a == 0 && b == 1 && c == 2) {
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView5.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);
            imageView7.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView9.animate().alpha(0.3f).setDuration(800);
        } else if (a == 3 && b == 4 && c == 5) {
            imageView1.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView3.animate().alpha(0.3f).setDuration(800);
            imageView7.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView9.animate().alpha(0.3f).setDuration(800);
        } else if (a == 6 && b == 7 && c == 8) {
            imageView1.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView3.animate().alpha(0.3f).setDuration(800);
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView5.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);
        } else if (a == 0 && b == 3 && c == 6) {
            imageView5.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView3.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView9.animate().alpha(0.3f).setDuration(800);
        } else if (a == 1 && b == 4 && c == 7) {
            imageView1.animate().alpha(0.3f).setDuration(800);
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView3.animate().alpha(0.3f).setDuration(800);
            imageView7.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);
            imageView9.animate().alpha(0.3f).setDuration(800);
        } else if (a == 2 && b == 5 && c == 8) {
            imageView1.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView7.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView5.animate().alpha(0.3f).setDuration(800);
        } else if (a == 0 && b == 4 && c == 8) {
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView3.animate().alpha(0.3f).setDuration(800);
            imageView7.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);
        } else if (a == 2 && b == 4 && c == 6) {
            imageView4.animate().alpha(0.3f).setDuration(800);
            imageView2.animate().alpha(0.3f).setDuration(800);
            imageView1.animate().alpha(0.3f).setDuration(800);
            imageView9.animate().alpha(0.3f).setDuration(800);
            imageView8.animate().alpha(0.3f).setDuration(800);
            imageView6.animate().alpha(0.3f).setDuration(800);

        }
      new CountDownTimer(1000,1000)
      {

          @Override
          public void onTick(long millisUntilFinished) {
                openWinDailog();
          }

          @Override
          public void onFinish() {

              button.animate().translationX(0).setDuration(1000);
              button3.animate().translationX(0).setDuration(1000);
          }
      }.start();

    }
}

    public void openWinDailog()
    {
    dialog.setContentView(R.layout.win_layout_dailog);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    ImageView view=dialog.findViewById(R.id.imageView3);


    TextView text=dialog.findViewById(R.id.textView);
    ok=dialog.findViewById(R.id.button5);

    if(name2.equals("Computer")&&ans==1) {
        view.setImageResource(R.drawable.lost);
        text.setText("Try Again");
    }
    else if(name2.equals("Computer")&&ans==-1)
    {
        view.setImageResource(R.drawable.trophy);
        if(diff.equals("easy"))
        text.setText("Beat me at Mediocre");
        else if(diff.equals("mediocre"))
            text.setText("Well played.Try impossible");
        else if(diff.equals("impossible"))
            text.setText("You are a genius");
    }
    else if(!name2.equals("Computer")&&draw==false)
    {
        view.setImageResource(R.drawable.trophy);
        if(ans==1)
            text.setText("Well Played "+name2);
        else if(ans==-1)
            text.setText("Well Played "+name1);
    }
    else
    {
                text.setText("No One Wins");
        view.setImageResource(R.drawable.draw);
    }

    dialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dialog.dismiss();
            }
        });
    }


    public void quit(View view) {
        dialog.setContentView(R.layout.win_layout_dailog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView view1=dialog.findViewById(R.id.imageView3);


        TextView text=dialog.findViewById(R.id.textView);
        ok=dialog.findViewById(R.id.button5);
        ok.setText("Yes Quit!");
        ok.setBackgroundResource(R.drawable.custom_button1);
        text.setText("Sure you want to Quit?");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        view1.setImageResource(R.drawable.quit);
        dialog.show();
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String arr[] = {name1, name2,diff};
        intent.putExtra("name", arr);
        startActivity(intent);
        finish();
    }
}
