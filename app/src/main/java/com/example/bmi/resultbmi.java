package com.example.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultbmi extends AppCompatActivity {

    android.widget.Button mrecalculate;

    TextView BMIDisplay,Gender,BMICategory;
    Intent intent;
    ImageView Check;
    String BMI;
    float intBmi;


    String height;
    String weight;
    float intHeight,intWeight;
    RelativeLayout backgroundLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultbmi);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();
        BMIDisplay=findViewById(R.id.bmidisplay);
        BMICategory=findViewById(R.id.bmiCategory);
        Gender=findViewById(R.id.gender);
        backgroundLayout=findViewById(R.id.contentlayout);
        Check=findViewById(R.id.imagecheck);
        mrecalculate=findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intHeight=Float.parseFloat(height);
        intWeight=Float.parseFloat(weight);

        intHeight=intHeight/100;
        intBmi=intWeight/(intHeight*intHeight);

        BMI=Float.toString(intBmi);

        if (intBmi<16)
        {
            BMICategory.setText("Serve Thinness");
            backgroundLayout.setBackgroundColor(Color.RED);
            Check.setImageResource(R.drawable.cross);

        }

        else if(intBmi<16.9 && intBmi>16)
        {
            BMICategory.setText("Moderate Thinness");
            backgroundLayout.setBackgroundColor(Color.RED);
            Check.setImageResource(R.drawable.warning);
        }

        else if(intBmi<18.4 && intBmi>17)
        {
            BMICategory.setText("Mild Thinness");
            backgroundLayout.setBackgroundColor(Color.RED);
            Check.setImageResource(R.drawable.warning);
        }

        else if(intBmi<25 && intBmi>18.4 )
        {
            BMICategory.setText("Normal");
            backgroundLayout.setBackgroundColor(Color.YELLOW);
            Check.setImageResource(R.drawable.check);

        }

        else if(intBmi<29.4 && intBmi>25)
        {
            BMICategory.setText("OverWeight");
            backgroundLayout.setBackgroundColor(Color.RED);
            Check.setImageResource(R.drawable.warning);
        }

        else
        {
            BMICategory.setText("Obese Class I");
            backgroundLayout.setBackgroundColor(Color.RED);
            Check.setImageResource(R.drawable.warning);
        }

        Gender.setText(intent.getStringExtra("gender"));
        BMIDisplay.setText(BMI);



        mrecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(resultbmi.this,bmiactivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}