package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txt_level;
    private EditText input;
    private ImageView img_one, img_two, img_three, img_four;
    private Button btn_ok;
    private Question question;
    private ArrayList<Integer> img, img2, img3, img4, img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        createQuestions();
        setData(question);
    }

    private void createQuestions() {
        img = new ArrayList<>();
        img.add(R.drawable.snow1);
        img.add(R.drawable.snow22);
        img.add(R.drawable.snoow3);
        img.add(R.drawable.snow44);
        img2 = new ArrayList<>();
        img2.add(R.drawable.soccer22);
        img2.add(R.drawable.soccer33);
        img2.add(R.drawable.soccer44);
        img2.add(R.drawable.soccerr);
        img3 = new ArrayList<>();
        img3.add(R.drawable.car1);
        img3.add(R.drawable.car3);
        img3.add(R.drawable.car4);
        img3.add(R.drawable.car2);
        img4 = new ArrayList<>();
        img4.add(R.drawable.build2);
        img4.add(R.drawable.build4);
        img4.add(R.drawable.build3);
        img4.add(R.drawable.build1);
        img5 = new ArrayList<>();
        img5.add(R.drawable.tree4);
        img5.add(R.drawable.tree2);
        img5.add(R.drawable.tree1);
        img5.add(R.drawable.tree3);
        question = new Question(1, img, "winter");
    }


    private void initViews() {
        txt_level = findViewById(R.id.txt_level);
        input = findViewById(R.id.edit_input);
        img_one = findViewById(R.id.img_first);
        img_two = findViewById(R.id.img_second);
        img_three = findViewById(R.id.img_third);
        img_four = findViewById(R.id.img_fourth);
        btn_ok = findViewById(R.id.btn_ok);
    }

    private void setData(Question question) {
        txt_level.setText("Level " + question.getLevel());
        img_one.setImageDrawable(getResources().getDrawable(question.getImg().get(0)));
        img_two.setImageDrawable(getResources().getDrawable(question.getImg().get(1)));
        img_three.setImageDrawable(getResources().getDrawable(question.getImg().get(2)));
        img_four.setImageDrawable(getResources().getDrawable(question.getImg().get(3)));
    }

    public void onClick(View view) {
        if (input.getText().toString().equals(question.getAnswer())) {
            input.setText("");
            if (question.getLevel() != 5) {
                Toast.makeText(this, "You passed level " + question.getLevel(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "You WIN", Toast.LENGTH_LONG).show();
            }
            switch (question.getLevel()) {
                case 1:
                    question = new Question(2, img2, "soccer");
                    break;
                case 2:
                    question = new Question(3, img3, "car");
                    break;
                case 3:
                    question = new Question(4, img4, "building");
                    break;
                case 4:
                    question = new Question(5, img5, "tree");
                    break;
                case 5:
                    question = new Question(1, img, "winter");
                    break;
            }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setData(question);
                }
            }, 1000);
        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_LONG).show();
        }
    }
}
