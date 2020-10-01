package com.app.covid19_riskassesment.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.covid19_riskassesment.R;
import com.app.covid19_riskassesment.activity.MainActivity;
import com.app.covid19_riskassesment.activity.QuestionsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.Objects;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class ScoreFragment extends Fragment {

    //const

    //var
    private Integer individualScore, familyScore;
    private Boolean testCompleted = false;

    //widgets
    private MaterialButton takeTest_BT;
    private MaterialCardView noScoreCArd_CV,retakeTest_CV, riskLevel_CV;
    private TextView individualScore_TV, familyScore_TV, individualLevel_TV, family_level_TV;
    private CustomGauge individualGauge, familyGauge;

    public ScoreFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void getScore() {

        SharedPreferences sharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences(getString(R.string.shared_preference_id), Context.MODE_PRIVATE);
        testCompleted = sharedPreferences.getBoolean("TestComplete",false);
        if (testCompleted ){
            Log.d("Test Status","COMPLETE");
            individualScore = sharedPreferences.getInt("IndividualScore",0);
            familyScore = sharedPreferences.getInt("FamilyScore",0);

            setScoreText();

            Log.d("Score", String.valueOf(individualScore)+" :: "+ String.valueOf(familyScore));
        }
        else {
            noScoreCArd_CV.setVisibility(View.VISIBLE);
            riskLevel_CV.setVisibility(View.GONE);
        }

    }

    private void setScoreText() {
        individualScore_TV.setText(String.valueOf(individualScore));
        familyScore_TV.setText(String.valueOf(familyScore));

        if (individualScore>= 20){
            individualScore_TV.setTextColor(getResources().getColor(R.color.red));
            individualLevel_TV.setText(R.string.very_high_risk);
            individualGauge.setPointStartColor(getResources().getColor(R.color.red));
            individualGauge.setPointEndColor(getResources().getColor(R.color.red));
            individualGauge.setPointSize(260);
        }
        else if(individualScore >= 10 && individualScore < 19){
            individualScore_TV.setTextColor(getResources().getColor(R.color.orange));
            individualLevel_TV.setText(R.string.high_risk);
            individualGauge.setPointStartColor(getResources().getColor(R.color.orange));
            individualGauge.setPointEndColor(getResources().getColor(R.color.orange));
            individualGauge.setPointSize(180);
        }
        else if (individualScore > 5 && individualScore < 10) {
            individualScore_TV.setTextColor(getResources().getColor(R.color.yellow));
            individualLevel_TV.setText(R.string.moderate_risk);
            individualGauge.setPointStartColor(getResources().getColor(R.color.yellow));
            individualGauge.setPointEndColor(getResources().getColor(R.color.yellow));
            individualGauge.setPointSize(80);
        }
        else if (individualScore <= 5 && individualScore != 0) {
            individualScore_TV.setTextColor(getResources().getColor(R.color.green));
            individualLevel_TV.setText(R.string.low_risk);
            individualGauge.setPointStartColor(getResources().getColor(R.color.green));
            individualGauge.setPointEndColor(getResources().getColor(R.color.green));
            individualGauge.setPointSize(25);
        }
        else if (individualScore == 0){
            individualScore_TV.setTextColor(getResources().getColor(R.color.colorPrimary));
            individualLevel_TV.setText(R.string.safe);
            individualGauge.setPointStartColor(getResources().getColor(R.color.white));
            individualGauge.setPointSize(0);
        }

        if (familyScore>= 25){
            familyScore_TV.setTextColor(getResources().getColor(R.color.red));
            family_level_TV.setText(R.string.very_high_risk);
            familyGauge.setPointStartColor(getResources().getColor(R.color.red));
            familyGauge.setPointEndColor(getResources().getColor(R.color.red));
            familyGauge.setPointSize(265);
        }
        else if(familyScore >= 15 && familyScore < 24){
            familyScore_TV.setTextColor(getResources().getColor(R.color.orange));
            family_level_TV.setText(R.string.high_risk);
            familyGauge.setPointStartColor(getResources().getColor(R.color.orange));
            familyGauge.setPointEndColor(getResources().getColor(R.color.orange));
            familyGauge.setPointSize(180);
        }
        else if (familyScore > 5 && familyScore < 14) {
            familyScore_TV.setTextColor(getResources().getColor(R.color.yellow));
            family_level_TV.setText(R.string.moderate_risk);
            familyGauge.setPointStartColor(getResources().getColor(R.color.yellow));
            familyGauge.setPointEndColor(getResources().getColor(R.color.yellow));
            familyGauge.setPointSize(80);
        }
        else if (familyScore <= 5 && familyScore != 0){
            familyScore_TV.setTextColor(getResources().getColor(R.color.green));
            family_level_TV.setText(R.string.low_risk);
            familyGauge.setPointStartColor(getResources().getColor(R.color.green));
            familyGauge.setPointEndColor(getResources().getColor(R.color.green));
            familyGauge.setPointSize(25);
        }
        else if (familyScore == 0){
            familyScore_TV.setTextColor(getResources().getColor(R.color.colorPrimary));
            family_level_TV.setText(R.string.safe);
            familyGauge.setPointStartColor(getResources().getColor(R.color.white));
            familyGauge.setPointSize(0);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        takeTest_BT = view.findViewById(R.id.takeTest_BT);
        noScoreCArd_CV = view.findViewById(R.id.noScoreCard_CV);
        individualScore_TV = view.findViewById(R.id.individualScore_TV);
        familyScore_TV = view.findViewById(R.id.familyScore_TV);
        individualGauge = view.findViewById(R.id.individualGauge);
        familyGauge = view.findViewById(R.id.familyGauge);
        individualLevel_TV = view.findViewById(R.id.individualRisk_TV);
        family_level_TV = view.findViewById(R.id.familyRisk_TV);
        riskLevel_CV = view.findViewById(R.id.riskLevel_CV);
        retakeTest_CV = view.findViewById(R.id.retakeTest_CV);
        getScore();

        takeTest_BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), QuestionsActivity.class));
            }
        });

        retakeTest_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), QuestionsActivity.class));
            }
        });

        return view;
    }
}