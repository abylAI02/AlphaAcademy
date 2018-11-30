package com.example.yelaman.alphaacademy;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class TestFragment extends Fragment {

    Random rd = new Random();

    private static int rnd;
    private static int[] previous = new int[4];
    private static int money_counter = 0;

    private Button[] buttons = new Button[4];
    private TextView question;
    private TextView money;


    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, 0),
            new Question(R.string.question_oceans, 0),
            new Question(R.string.question_mideast, 0),
            new Question(R.string.question_africa, 0),
            new Question(R.string.question_americas, 0),
            new Question(R.string.question_asia, 0),
    };
    private int mCurrentIndex = 0;


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Test");

        money = view.findViewById(R.id.money);

        //String name = intent.getStringExtra("nickname");
        //nick.setText(name);

        question = view.findViewById(R.id.question);

        buttons[0] = view.findViewById(R.id.answer);
        buttons[1] = view.findViewById(R.id.answer1);
        buttons[2] = view.findViewById(R.id.answer2);
        buttons[3] = view.findViewById(R.id.answer3);

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(0);

            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(1);
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(2);

            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerQuestion(3);

            }
        });

        updateQuestion();

    }


    public void updateQuestion() {

        if (mCurrentIndex == 0) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_australia);
            mQuestionBank[0].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_australia1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_australia2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_australia3);
        }

        else if (mCurrentIndex == 1) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_oceans);
            mQuestionBank[1].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_oceans1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_oceans2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_oceans3);
        }

        else if (mCurrentIndex == 2) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_mideast);
            mQuestionBank[2].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_mideast1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_mideast2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_mideast3);
        }

        else if (mCurrentIndex == 3) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_africa);
            mQuestionBank[3].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_africa1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_africa2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_africa3);
        }

        else if (mCurrentIndex == 4) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_americas);
            mQuestionBank[4].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_americas1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_americas2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_americas3);
        }

        else if (mCurrentIndex == 5) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_asia);
            mQuestionBank[5].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_asia1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_asia2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_asia3);
        }

        for (int i = 0; i < previous.length; i++) {
            previous[i] = 0;
        }

        int mQuestion = mQuestionBank[mCurrentIndex].getTextResId();
        question.setText(mQuestion);

    }

    public void answerQuestion(int rightAnswer) {

        int answerIsRight = mQuestionBank[mCurrentIndex].getAnswerId();

        int messageResId = 0;

        if (rightAnswer == answerIsRight) {
            messageResId = R.string.correct;
            money_counter+=1;
            money.setText("" + money_counter);
        }

        else {
            messageResId = R.string.incorrect;
            //final Intent intent1 = new Intent(getContext(), ScoreActivity.class);
            //startActivity(intent1);
        }

        Toast.makeText(getContext(), messageResId, Toast.LENGTH_LONG).show();

        if (mCurrentIndex == 5) {
            mCurrentIndex = 0;
            updateQuestion();
        }
        else {
            mCurrentIndex++;
            updateQuestion();
        }
    }
}
