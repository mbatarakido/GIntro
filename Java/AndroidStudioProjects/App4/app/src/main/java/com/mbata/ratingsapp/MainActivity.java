package com.mbata.ratingsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    int fiveStarReview = 0;
    int fourStarReview = 0;
    int threeStarReview = 0;
    int twoStarReview = 0;
    int oneStarReview = 0;

    boolean clicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView five = findViewById(R.id.txtFiveStar);
        final TextView four = findViewById(R.id.txtFourStar);
        final TextView three = findViewById(R.id.txtThreeStar);
        final TextView two = findViewById(R.id.txtTwoStar);
        final TextView one = findViewById(R.id.txtOneStar);

        RatingBar rtbFive = findViewById(R.id.rtbFiveStar);
        RatingBar rtbFour = findViewById(R.id.rtbFourStar);
        RatingBar rtbThree = findViewById(R.id.rtbThreeStar);
        RatingBar rtbTwo = findViewById(R.id.rtbTwoStar);
        RatingBar rtbOne = findViewById(R.id.rtbOneStar);

        final Button btnResult = findViewById(R.id.btnResult);

        rtbFive.setIsIndicator(true);
        rtbFour.setIsIndicator(true);
        rtbThree.setIsIndicator(true);
        rtbTwo.setIsIndicator(true);
        //rtbOne.setIsIndicator(true); OR...
        makeRatingBarIndicator(rtbOne);

        final int[] studentReview = {5, 3, 4, 2, 4, 5, 1, 3, 2, 5, 5, 3, 2, 3};

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked){
                    for(int index = 0; index < studentReview.length; index++){
                        if(studentReview[index] == 5){
                            ++fiveStarReview;
                        }
                        if(studentReview[index] == 4){
                            ++fourStarReview;
                        }
                        if(studentReview[index] == 3){
                            ++threeStarReview;
                        }
                        if(studentReview[index] == 2){
                            ++twoStarReview;
                        }
                        if(studentReview[index] == 1){
                            ++oneStarReview;
                        }
                    }
                    clicked = false;

                    five.setText(fiveStarReview + "");
                    four.setText(fourStarReview + "");
                    three.setText(threeStarReview + "");
                    two.setText(twoStarReview + "");
                    one.setText(oneStarReview + "");

                    //btnResult.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "Button Already Clicked", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void makeRatingBarIndicator(RatingBar ratingBar){
        ratingBar.setIsIndicator(true);
    }
    public void randomNumbers(){
        SecureRandom random = new SecureRandom();

        int randomNum = 1 + random.nextInt(6); //generates random num btn 1-6;
    }
}