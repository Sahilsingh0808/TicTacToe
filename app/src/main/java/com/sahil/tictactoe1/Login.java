package com.sahil.tictactoe1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.sahil.tictactoe1.R;

public class Login extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    ToggleButton ai;
    TextView Textview5;
    Button button,ok,button4,button6,button7;
    Boolean ai1=false;
    TextView textView4,textView2;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View decorView=getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            );}
        dialog=new Dialog(this);
        button4=(Button)findViewById(R.id.button4);
        button6=(Button)findViewById(R.id.button6);

        button7=(Button)findViewById(R.id.button7);
        textView4=(TextView)findViewById(R.id.textView4);
        textView2=(TextView)findViewById(R.id.textView2);
        button=(Button)findViewById(R.id.button2) ;
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        ai=(ToggleButton)findViewById(R.id.toggleButton);
        Textview5=(TextView)findViewById(R.id.textView5);
        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ai.isChecked()==true) {
                   editText2.setVisibility(View.INVISIBLE);
                   editText2.setText("Computer");
                   Textview5.setVisibility(View.VISIBLE);
                ai.setBackgroundResource(R.drawable.button_default2);
                    ai1=true;
                }
                else
                {
                    editText2.setVisibility(View.VISIBLE);
                    Textview5.setVisibility(View.INVISIBLE);
                    editText2.setText("");
                    ai.setBackgroundResource(R.drawable.custom_button1);

                    ai1=false;
                }

            }
        });

    }

    public void play(View view) {



        if(editText.getText().toString().isEmpty()&&editText2.getText().toString().isEmpty()){
            editText2.setError("Please enter player 2's name");
            editText.setError("Please enter player 1's name");}

        else if(editText.getText().toString().isEmpty()&&editText2.getText().toString().isEmpty()==false)
            editText.setError("Please enter player 1's name");

        else if(editText2.getText().toString().isEmpty()&&editText.getText().toString().isEmpty()==false)
            editText2.setError("Please enter player 2's name");

        else {
            final Intent intent = new Intent(this, MainActivity.class);
            if (ai1 == true) {
                ai.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
                editText2.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                Textview5.setVisibility(View.INVISIBLE);

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String arr[] = {editText.getText().toString(), "Computer", "easy"};
                        intent.putExtra("name", arr);
                        startActivity(intent);
                        finish();
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String arr[] = {editText.getText().toString(), "Computer", "mediocre"};
                        intent.putExtra("name", arr);
                        startActivity(intent);
                        finish();
                    }
                });
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String arr[] = {editText.getText().toString(), "Computer", "impossible"};
                        intent.putExtra("name", arr);
                        startActivity(intent);
                        finish();
                    }
                });

            } else {



                String arr[] = {editText.getText().toString(), editText2.getText().toString(), "nonai"};
                intent.putExtra("name", arr);
                startActivity(intent);
                finish();

            }
        }
    }

    public void anon(View view) {
        final Intent intent=new Intent(this,MainActivity.class);
        String arr[];
        if(ai1==true) {
            ai.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);
            editText2.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.VISIBLE);
            button6.setVisibility(View.VISIBLE);
            button7.setVisibility(View.VISIBLE);
            Textview5.setVisibility(View.INVISIBLE);

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {"Your", "Computer","easy"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {"Your", "Computer","mediocre"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {"Your", "Computer","impossible"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });

        }
       else{
        arr= new String[]{"Player 1", "Player 2","nonai"};
        intent.putExtra("name",arr);
        startActivity(intent);
        finish();}
    }

    public void computer(View view) {
        if(ai1==true) {

          ai.setVisibility(View.INVISIBLE);
          textView4.setVisibility(View.INVISIBLE);
          editText.setVisibility(View.INVISIBLE);
          editText2.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.VISIBLE);
            button6.setVisibility(View.VISIBLE);
            button7.setVisibility(View.VISIBLE);
            Textview5.setVisibility(View.INVISIBLE);
            final Intent intent=new Intent(this,MainActivity.class);

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {editText.getText().toString(), "Computer","easy"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {editText.getText().toString(), "Computer","mediocre"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String arr[] = {editText.getText().toString(), "Computer","impossible"};
                    intent.putExtra("name", arr);
                    startActivity(intent);
                    finish();
                }
            });
        }
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
}
