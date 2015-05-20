package com.example.thedivineflame.basiccalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    double currentNumber;
    double oldNumber;
    int dotCount;
    boolean dotTrue;
    String catchNumber;
    String operator;
    String operation;
    String numberOutput;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button dot;
    Button plus;
    Button minus;
    Button times;
    Button divide;
    Button equal;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentNumber = 0;
        numberOutput = "";
        catchNumber = "";
        dotCount = 1;
        operation = "";
        dotTrue = false;
        output = (TextView) findViewById(R.id.output);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);
        zero = (Button) findViewById(R.id.button0);
        dot = (Button) findViewById(R.id.buttonDot);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        times = (Button) findViewById(R.id.buttonX);
        divide = (Button) findViewById(R.id.buttonDivide);
        equal = (Button) findViewById(R.id.buttonEqual);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal("0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDot(".");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("add");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("subtract");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("divide");
            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("multiply");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeObservation();
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
    public void addToTotal(String number) {

            numberOutput = numberOutput + number;
            output.setText(numberOutput);

    }
    public void addDot(String dot) {
        if(dotTrue = false)
        {
            numberOutput = numberOutput + dot;
            output.setText(numberOutput);
            dotTrue = true;
        }
    }
    public void setOperation(String Operators)
    {
        if(numberOutput != ""){
            operator = Operators;
            oldNumber = Double.parseDouble(numberOutput);
            currentNumber = 0;
            dotCount = 0;
            dotTrue = false;
            numberOutput ="";
        }
        else{
            operator = Operators;
        }
        }


    public void completeObservation() {
        if(numberOutput == ""){
            numberOutput = catchNumber;
        }
        if(numberOutput != ""){
            catchNumber = numberOutput;
        }
        if ( operator == "add"){
            currentNumber = oldNumber + Double.parseDouble(numberOutput);
        }
        else if ( operator == "subtract") {
            currentNumber = oldNumber - Double.parseDouble(numberOutput);
        }
        else if ( operator == "multiply") {
            currentNumber = oldNumber * Double.parseDouble(numberOutput);

        }
        else if ( operator == "divide") {
            currentNumber = oldNumber / Double.parseDouble(numberOutput);
        }
        output.setText(String.valueOf(currentNumber));
        oldNumber = currentNumber;
        currentNumber = 0;
        dotCount= 0;
        dotTrue = false;
        numberOutput ="";
    }
}
