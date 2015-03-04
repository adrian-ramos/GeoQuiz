package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity{

    public static final String EXTRA_ANSWER_IS_TRUE = "tfquiz.ANSWER_IS_TRUE";
    public static final String EXTRA_ANSWER_IS_SHWON = "tfquiz.ANSWER_IS_SHOWN";
    public static final String KEY_ANSWER = "answer";

    boolean mAnswerIsTrue;

    TextView mAnswerTextView;
    Button mShownAnswer;

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_SHWON, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        if (savedInstanceState == null){
            setAnswerShownResult(false);
        } else {
            mAnswerIsTrue = savedInstanceState.getBoolean(KEY_ANSWER);

            if (mAnswerIsTrue){
                mAnswerTextView.setText("True");
            } else {
                mAnswerTextView.setText("False");
            }
            setAnswerShownResult(true);
        }

        mShownAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShownAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText("True");
                } else {
                    mAnswerTextView.setText("False");
                }
                setAnswerShownResult(true);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_ANSWER, mAnswerIsTrue);
    }


}
