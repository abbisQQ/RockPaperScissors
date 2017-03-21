package com.abbisqq.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView enemy,friend;
    Random randomNum;
    ImageButton rock,paper,scissors;
    int friendSelection,foeSelection;
    TextView foeScore,friendScore,announcement;
    int scoreF=0;
    int scoreE=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend =  (ImageView)findViewById(R.id.enemy);
        enemy = (ImageView)findViewById(R.id.friend);
        randomNum =  new Random(2);
        rock =(ImageButton)findViewById(R.id.rock);
        paper =(ImageButton)findViewById(R.id.paper);
        scissors =(ImageButton)findViewById(R.id.scissors);
        announcement = (TextView)findViewById(R.id.announce);
        foeScore = (TextView)findViewById(R.id.foeScore);
        friendScore = (TextView)findViewById(R.id.friendScore);



        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int enemySelection = randomNum.nextInt(3);

                switch (enemySelection){
                    case 0:
                        Glide.with(v.getContext()).load(R.drawable.rock).animate(R.anim.basic_animation).into(enemy);
                        foeSelection=0;
                        break;
                    case 1:
                        Glide.with(v.getContext()).load(R.drawable.paper).animate(R.anim.basic_animation).into(enemy);
                        foeSelection=1;
                        break;
                    case 2:
                        Glide.with(v.getContext()).load(R.drawable.scissors).animate(R.anim.basic_animation).into(enemy);
                        foeSelection=2;
                        break;
                }

                    scoreCounting();
            }
        });

        Glide.with(this).load(R.drawable.questionmark).animate(R.anim.basic_animation).into(enemy);
        Glide.with(this).load(R.drawable.questionmark).animate(R.anim.basic_animation).into(friend);


    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        announcement.setText("");
        if(id==rock.getId()){
            Glide.with(this).load(R.drawable.rock).animate(R.anim.basic_animation).into(friend);
            friendSelection = 0;
        }else if(id==paper.getId()){
            Glide.with(this).load(R.drawable.paper).animate(R.anim.basic_animation).into(friend);
            friendSelection=1;
        }else if(id==scissors.getId()){
            Glide.with(this).load(R.drawable.scissors).animate(R.anim.basic_animation).into(friend);
            friendSelection=2;
        }
    }




    public void scoreCounting(){


        switch (friendSelection){
            case 0:
                switch (foeSelection){
                    case 0:
                        announcement.setText(R.string.tie);
                        break;
                    case 1:
                        announcement.setText(R.string.loose);
                        scoreE++;
                        foeScore.setText(String.valueOf(scoreE));
                        break;
                    case 2:
                        announcement.setText(R.string.win);
                        scoreF++;
                        friendScore.setText(String.valueOf(scoreF));
                        break;
                }
                break;
            case 1:
                switch (foeSelection){
                    case 1:
                        announcement.setText(R.string.tie);
                        break;
                    case 2:
                        announcement.setText(R.string.loose);
                        scoreE++;
                        foeScore.setText(String.valueOf(scoreE));
                        break;
                    case 0:
                        announcement.setText(R.string.win);
                        scoreF++;
                        friendScore.setText(String.valueOf(scoreF));
                        break;
                }
                break;
            case 2:
                switch (foeSelection){
                    case 2:
                        announcement.setText(R.string.tie);
                        break;
                    case 0:
                        announcement.setText(R.string.loose);
                        scoreE++;
                        foeScore.setText(String.valueOf(scoreE));
                        break;
                    case 1:
                        announcement.setText(R.string.win);
                        scoreF++;
                        friendScore.setText(String.valueOf(scoreF));
                        break;
                }
                break;
        }

    }



}
