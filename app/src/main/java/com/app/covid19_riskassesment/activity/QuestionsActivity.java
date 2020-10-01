package com.app.covid19_riskassesment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.covid19_riskassesment.model.QuestionModel;
import com.app.covid19_riskassesment.R;
import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    //const

    //var
    private ArrayList<QuestionModel> individualQuestions, familyQuestionss;
    private Integer individualScore = 0 , familyScore = 0;
    private int index =0;

    //widgets
    private TextView question_TV, questionNo_TV;
    private NumberProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        question_TV = findViewById(R.id.testQuestion_TV);
        progressBar = findViewById(R.id.number_progress_bar);
        questionNo_TV = findViewById(R.id.testQuestionNo_TV);

        individualQuestions = new ArrayList<>();
        familyQuestionss = new ArrayList<>();
        initializeQuestions();

    }

    private void initializeQuestions() {
        individualQuestions.add(new QuestionModel("Has anyone in the family returned from abroad? ",5));
        individualQuestions.add(new QuestionModel("Has anyone travelled out of state? ",4));
        individualQuestions.add(new QuestionModel("Has anyone travelled out of their district? ",3));
        individualQuestions.add(new QuestionModel("Has anyone travelled out of town? ",3));
        individualQuestions.add(new QuestionModel("Has anyone been in close contact(less than a metre) with the person who answers yes to one of the above questions?  ",5));
        individualQuestions.add(new QuestionModel("If your answer to anyone of the above is ‘YES’, there is no harm in getting TESTED voluntarily or undertaking HOME " +
                "QUARANTINE in a separate well-ventilated room, especially if there is someone who is vulnerable under the same roof?(someone with Diabetes, Heart ailment, Asthma, " +
                "Smoker, Treated for cancer etc) ",5));

        individualQuestions.add(new QuestionModel("Has anyone in the family suffered from FEVER with COUGH lasting for 1 to 2 weeks? ",10));
        individualQuestions.add(new QuestionModel("Is there anyone in the neighbourhood (along the same street) that has visited you (who could answer YES to the above questions)?  ",5));
        individualQuestions.add(new QuestionModel("Your maid has been known to be visiting multiple households, visiting every day? ",5));
        individualQuestions.add(new QuestionModel("Do you have contact with anyone frequently visiting you as the maid would? ",5));
        individualQuestions.add(new QuestionModel("Is there anyone who has attended huge congregations (say more than 50 or so, be it Theatres, Malls, Weddings, " +
                "Closed door meetings) in the last 3 months in your household? ",25));

        checkIndex();

    }

    public void updateQuestion(){
        if (index <=10){
            String question = individualQuestions.get(index).getQuestion();

            question_TV.setText(question);

            progressBar.setProgress(index*10);
            questionNo_TV.setText("Question "+String.valueOf(index+1)+" :" );
        }
    }

    public void answerYes(View view) {

        if (index <=10){
            Integer score = individualQuestions.get(index).getScore();
            if (index<=5){
                individualScore += score;
                index++;
                checkIndex();
                Log.d("Individual core", String.valueOf(individualScore));
            }else {
                familyScore += score;
                index++;
                checkIndex();
                Log.d("Family Score", String.valueOf(familyScore));
            }
        }else {

        }
    }

    public void answerNo(View view) {
        index++;
        checkIndex();
    }

    public void checkIndex(){
        if (index<=10){
            updateQuestion();
        }else {
            saveScore();
            startActivity(new Intent(QuestionsActivity.this,MainActivity.class));
            finish();
        }
    }

    private void saveScore() {

        SharedPreferences.Editor spEditor = getSharedPreferences(getString(R.string.shared_preference_id),MODE_PRIVATE).edit();
        spEditor.putBoolean("TestComplete",true);
        spEditor.putInt("IndividualScore",individualScore);
        spEditor.putInt("FamilyScore",familyScore);
        spEditor.apply();
    }
}