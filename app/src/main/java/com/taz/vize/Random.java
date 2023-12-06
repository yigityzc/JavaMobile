package com.taz.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;



public class Random extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        java.util.Random=new java.util.Random();


        Button createBtn = findViewById(R.id.BtnCreate);
        EditText textCount = findViewById(R.id.countText);
        EditText textMax = findViewById(R.id.maxText);
        EditText textMin = findViewById(R.id.minText);
        LinearLayout layoutMain=findViewById(R.id.mainLayout);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout scrollLinearLayout=new LinearLayout(this);
        scrollView.addView(scrollLinearLayout);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countText=textCount.getText().toString();
                int count = Integer.parseInt(countText);
                String maxText=textMax.getText().toString();
                int max = Integer.parseInt(maxText);
                String minText=textMin.getText().toString();
                int min = Integer.parseInt(minText);
                Random rnd = new Random();
                for(int i; i<count ;i++){
                    LinearLayout sutun1 = new LinearLayout(Random.this);
                    LinearLayout satir1 = new LinearLayout(Random.this);
                    LinearLayout satir2 = new LinearLayout(Random.this);
                    sutun1.setOrientation(LinearLayout.HORIZONTAL);
                    satir1.setOrientation(LinearLayout.HORIZONTAL);
                    satir2.setOrientation(LinearLayout.HORIZONTAL);
                    TextView textView=new TextView(Random.this);
                    TextView textView1 = new TextView(Random.this);

                    ProgressBar progressBar = new ProgressBar(Random.this,null, android.R.attr.progressBarStyleHorizontal);
                    TextView textView3 = new TextView(Random.this);

                    int randomValue = rnd.nextInt(max-min+1)+min;
                    int randomValue2 = rnd.nextInt(max-min+1)+min;
                    int maxValue;
                    int minValue;

                    if(randomValue>randomValue2){
                        maxValue=randomValue;
                        minValue=randomValue2;
                    } else if (randomValue<randomValue2) {
                        maxValue =randomValue2;
                        minValue=randomValue;
                    }
                    else {
                        maxValue=randomValue2;
                        minValue=randomValue;
                    }
                    int randomNumber = rnd.nextInt(maxValue-minValue+)+minValue;
                    double percent =(double)((randomNumber-minValue)*100)/(maxValue-minValue);
                    int maxProgress=100;
                    int progressValue=(int) ((percent/100.0)*maxProgress);
                    textView.setText((Integer.toString(randomNumber)+ + Integer.toString(percent);
                    satir1.addView(textView1);
                    }
        });

    }
}