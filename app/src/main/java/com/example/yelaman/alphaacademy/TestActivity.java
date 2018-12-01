package com.example.yelaman.alphaacademy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class TestActivity extends AppCompatActivity {

    private static int rnd;
    private static int[] previous = new int[4];
    private static int money_counter = 0;
    Random rd = new Random();
    private Button[] buttons = new Button[4];
    private TextView question;
    private TextView money;
    private Button restart;


    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_beginner1, 0),
            new Question(R.string.question_beginner2, 0),
            new Question(R.string.question_beginner3, 0),
            new Question(R.string.question_beginner4, 0),
            new Question(R.string.question_beginner5, 0),
            new Question(R.string.question_beginner6, 0),
            new Question(R.string.question_beginner7, 0),
            new Question(R.string.question_beginner8, 0),
            new Question(R.string.question_beginner9, 0),
            new Question(R.string.question_beginner10, 0),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        money = findViewById(R.id.money);
        restart = findViewById(R.id.restart);

        //String name = intent.getStringExtra("nickname");
        //nick.setText(name);

        question = findViewById(R.id.question);

        buttons[0] = findViewById(R.id.answer);
        buttons[1] = findViewById(R.id.answer1);
        buttons[2] = findViewById(R.id.answer2);
        buttons[3] = findViewById(R.id.answer3);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = 0;
                money_counter = 0;
                money.setText("" + money_counter + "/10");
                updateQuestion();
                restart.setVisibility(INVISIBLE);
                buttons[0].setVisibility(VISIBLE);
                buttons[1].setVisibility(VISIBLE);
                buttons[2].setVisibility(VISIBLE);
                buttons[3].setVisibility(VISIBLE);

            }
        });

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

        money_counter = 0;

    }


    public void updateQuestion() {

        if (mCurrentIndex == 0) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner1);
            mQuestionBank[0].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner1_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner1_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner1_3);
        } else if (mCurrentIndex == 1) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner2);
            mQuestionBank[1].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner2_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner2_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner3_3);
        } else if (mCurrentIndex == 2) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner3);
            mQuestionBank[2].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner3_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner3_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner3_3);
        } else if (mCurrentIndex == 3) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner4);
            mQuestionBank[3].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner4_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner4_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner4_3);
        } else if (mCurrentIndex == 4) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner5);
            mQuestionBank[4].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner5_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner5_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner5_3);
        } else if (mCurrentIndex == 5) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner6);
            mQuestionBank[5].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner6_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner6_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner6_3);
        } else if (mCurrentIndex == 6) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner7);
            mQuestionBank[6].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner7_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner7_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner7_3);
        } else if (mCurrentIndex == 7) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner8);
            mQuestionBank[7].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner8_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner8_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner8_3);
        } else if (mCurrentIndex == 8) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner9);
            mQuestionBank[8].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner9_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner9_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner9_3);
        } else if (mCurrentIndex == 9) {
            rnd = rd.nextInt(4);
            previous[0] = rnd;
            buttons[rnd].setText(R.string.r_answer_beginner10);
            mQuestionBank[9].setAnswerId(rnd);
            while (previous[0] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[1] = rnd;
            buttons[rnd].setText(R.string.answer_beginner10_1);
            while (previous[0] == rnd || previous[1] == rnd) {
                rnd = rd.nextInt(4);
            }
            previous[2] = rnd;
            buttons[rnd].setText(R.string.answer_beginner10_2);
            while (previous[0] == rnd || previous[1] == rnd || previous[2] == rnd) {
                rnd = rd.nextInt(4);
            }
            buttons[rnd].setText(R.string.answer_beginner10_3);
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
            money_counter += 1;
            money.setText("" + money_counter + "/10");
        } else {
            messageResId = R.string.incorrect;
            //final Intent intent1 = new View. Intent(getContext(), ScoreActivity.class);
            //startActivity(intent1);
        }

        Toast.makeText(TestActivity.this, messageResId, Toast.LENGTH_SHORT).show();

        if (mCurrentIndex == 9) {
            buttons[0].setVisibility(INVISIBLE);
            buttons[1].setVisibility(INVISIBLE);
            buttons[2].setVisibility(INVISIBLE);
            buttons[3].setVisibility(INVISIBLE);
            restart.setVisibility(VISIBLE);
            question.setText("Do you want pass the test again?\nYour result");
        } else {
            mCurrentIndex++;
            updateQuestion();
        }
    }

    /*@Override
    public void onBackPressed() {
        finish();
    }*/
}
