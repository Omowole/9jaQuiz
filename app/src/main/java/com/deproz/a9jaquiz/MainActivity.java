package com.deproz.a9jaquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.deproz.a9jaquiz.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button  b2;
    Button  b3;
    Button b4;
    TextView timer;
    TextView q1;
    DatabaseReference reference;
    int total = 1;
    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.but1);
        b2 = (Button) findViewById(R.id.but2);
        b3 = (Button) findViewById(R.id.but3);
        b4 = (Button) findViewById(R.id.but4);
        timer = (TextView) findViewById(R.id.tima);
        q1 = (TextView) findViewById(R.id.quest1);

        updateQuestion();
    }

    private void updateQuestion() {
        if (total > 30) {
            //open next

        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);
                    q1.setText(question.getQuestion());
                    b1.setText(question.getA());
                    b2.setText(question.getB());
                    b3.setText(question.getC());
                    b4.setText(question.getD());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b1.getText().toString().equals(question.getAnswer()))
                            {

                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                            else
                            {
                                //Answer is wrong
                                wrong = wrong + 1;

                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(question.getAnswer()))
                            {

                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                            else
                            {
                                //Answer is wrong
                                wrong++;

                                b2.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(question.getAnswer()))
                            {

                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                            else
                            {
                                //Answer is wrong
                                wrong++;

                                b3.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b4.getText().toString().equals(question.getAnswer()))
                            {

                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);


                            }
                            else
                            {
                                //Answer is wrong
                                wrong++;

                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);

                            }
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



                }
    }
}

