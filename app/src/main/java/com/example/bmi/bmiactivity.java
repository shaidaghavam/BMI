package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button CalculateBmi;
    TextView CurrentHeight;
    TextView CurrentAge,CurrentWeight;
    ImageView ImageIncreaseAge,ImageIncrease,ImageDisrease,ImageDisreaseAge;
    SeekBar Seekbar;
    RelativeLayout Male,Female;


    int intWeight=44;
    int intAge=22;
    int  currentProgress;
    String mintProgress="170";
    String typeOfUser="0";
    String weight2="55";
    String age2="22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().hide();

        CalculateBmi=findViewById(R.id.calculatebmi);
        CurrentAge=findViewById(R.id.currentage);
        CurrentWeight=findViewById(R.id.currentweight);
        CurrentHeight=findViewById(R.id.currentSize);
        ImageIncreaseAge=findViewById(R.id.imageincreaseage);
        ImageDisreaseAge=findViewById(R.id.imagediscreaseage);
        ImageIncrease=findViewById(R.id.imageincrease);
        ImageDisrease=findViewById(R.id.imagedisrease);
        Seekbar=findViewById(R.id.seekbar);
        Male=findViewById(R.id.male);
        Female=findViewById(R.id.female);


        Female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemale));
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefo));
                typeOfUser="Male";


            }
        });


        Male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemale));
                Male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefo));
                typeOfUser="Female";



            }
        });

        Seekbar.setMax(300);
        Seekbar.setProgress(170);
        Seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress=progress;
                mintProgress=String.valueOf(currentProgress);
                CurrentHeight.setText(mintProgress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ImageDisreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge=intAge+1;
                age2=String.valueOf(intAge);
                CurrentAge.setText(age2);


            }
        });

        ImageIncreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge=intAge-1;
                age2=String.valueOf(intAge);
                CurrentAge.setText(age2);


            }
        });

        ImageDisrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight=intWeight+1;
                weight2=String.valueOf(intWeight);
                CurrentWeight.setText(weight2);


            }
        });

        ImageIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight=intWeight-1;
                weight2=String.valueOf(intWeight);
                CurrentWeight.setText(weight2);


            }
        });


        CalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeOfUser.equals("0")) {
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mintProgress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(intAge==0 || intAge<0)
                {
                    Toast.makeText(getApplicationContext(),"Age Is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else if(intWeight==0 || intWeight<0)
                {
                    Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(bmiactivity.this,bmiactivity.class);
                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height",mintProgress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);

                }

                Intent intent=new Intent(bmiactivity.this,resultbmi.class);
                startActivity(intent);
            }
        });





    }
}