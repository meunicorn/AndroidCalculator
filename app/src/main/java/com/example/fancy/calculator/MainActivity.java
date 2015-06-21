package com.example.fancy.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

import com.gc.materialdesign.views.ButtonFlat;


public class MainActivity extends Activity {
    private TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化btn
        //数字按钮,小数点
        ButtonFlat btn0 = (ButtonFlat) findViewById(R.id.btn_zero);
        ButtonFlat btn1 = (ButtonFlat) findViewById(R.id.btn_one);
        ButtonFlat btn2 = (ButtonFlat) findViewById(R.id.btn_two);
        ButtonFlat btn3 = (ButtonFlat) findViewById(R.id.btn_three);
        ButtonFlat btn4 = (ButtonFlat) findViewById(R.id.btn_four);
        ButtonFlat btn5 = (ButtonFlat) findViewById(R.id.btn_five);
        ButtonFlat btn6 = (ButtonFlat) findViewById(R.id.btn_six);
        ButtonFlat btn7 = (ButtonFlat) findViewById(R.id.btn_seven);
        ButtonFlat btn8 = (ButtonFlat) findViewById(R.id.btn_eighit);
        ButtonFlat btn9 = (ButtonFlat) findViewById(R.id.btn_nine);
        ButtonFlat btnDot = (ButtonFlat) findViewById(R.id.btn_dot);
        //加减乘除按钮
        ButtonFlat btnJia = (ButtonFlat) findViewById(R.id.btn_jia);
        ButtonFlat btnJian = (ButtonFlat) findViewById(R.id.btn_jian);
        ButtonFlat btnCheng = (ButtonFlat) findViewById(R.id.btn_cheng);
        ButtonFlat btnChu = (ButtonFlat) findViewById(R.id.btn_chu);
        //删除，等于 按钮
        Button btnDel = (Button) findViewById(R.id.btn_del);
        ButtonFlat btnEqual = (ButtonFlat) findViewById(R.id.btn_equal);
        //实例化输出窗口
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        //添加按钮点击事件。点击后在textview显示
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textposition("9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView2.length() != 0 && !textView3.getText().toString().contains(".")) {
                    textView3.setText(textView3.getText() + ".");
                } else if (!textView1.getText().toString().contains(".")) {
                    textView1.setText(textView1.getText() + ".");
                }
            }
        });
        btnJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("+");
            }
        });
        btnJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("-");
            }
        });
        btnCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("×");
            }
        });
        btnChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("÷");
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView3.length() != 0) {
                    textView3.setText(textView3.getText().subSequence(0, textView3.getText().length() - 1));
                } else if (textView2.length() != 0) {
                    textView2.setText(textView2.getText().subSequence(0, textView2.getText().length() - 1));
                } else if (textView1.length() != 0) {
                    textView1.setText(textView1.getText().subSequence(0, textView1.getText().length() - 1));
                } else {
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    textView1.setText(calculate() + "");
                    textView3.setText("");
                    textView2.setText("");
                } catch (Exception e) {
                }
            }
        });
        //以下为长按输出框清除事件
        textView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView1.setText("");
                return false;
            }
        });
        textView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView2.setText("");
                return false;
            }
        });
        textView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView3.setText("");
                return false;
            }
        });
        btnDel.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                View myView = findViewById(R.id.clearall);
                clearAnimation(myView);
                textView1.setText("");
                textView2.setText("");
                textView3.setText("");
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public double calculate() {
        double numA, numB, answer = 0;
        numA = Double.parseDouble(textView1.getText().toString());
        numB = Double.parseDouble(textView3.getText().toString());
        switch (textView2.getText().toString()) {
            case "+":
                answer = numA + numB;
                break;
            case "-":
                answer = numA - numB;
                break;
            case "×":
                answer = numA * numB;
                break;
            case "÷":
                answer = numA / numB;
                break;
        }
        return answer;
    }

    public void textposition(String num) {
        if (textView2.length() != 0) {
            textView3.setText(textView3.getText() + num);
        } else
            textView1.setText(textView1.getText() + num);
    }

    public void clearAnimation(View myView) {
        // get the center for the clipping circle
        //int cx = (myView.getLeft() + myView.getRight()) / 2;
        //int cy = (myView.getTop() + myView.getBottom()) / 2;
        int cx = myView.getRight();
        int cy = myView.getBottom();
        // get the final radius for the clipping circle
        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

        SupportAnimator animator =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(300);
        animator.start();
    }

}
