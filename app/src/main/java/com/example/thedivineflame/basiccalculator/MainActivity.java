package com.example.thedivineflame.basiccalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    double currentNumber;
    double oldNumber;
    int dotCount;
    boolean dotTrue;
    String Operator;
    String operation;
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
        times = (Button) findViewById(R.id.buttonMinus);
        divide = (Button) findViewById(R.id.buttonDivide);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToTotal(0);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotTrue =true;
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
    public void addToTotal(int number) {
        if (dotTrue == false) {
            if (currentNumber == 0) {
                currentNumber = number;
            } else {
                currentNumber = currentNumber * 10;
                currentNumber = currentNumber + number;
            }
            String newOutput = Double.toString(currentNumber);
            if( currentNumber <999999999){
                output.setText(newOutput.substring(0,(newOutput.length()-2)));
            }
            else {
                output.setText(newOutput);
            }

        }
        else {
            dotCount ++;
            currentNumber = currentNumber * Math.pow(10, dotCount-1);
            currentNumber += number;
            currentNumber = currentNumber / Math.pow(10, dotCount-1);

            output.setText(Double.toString((currentNumber)));


        }
        ;
    }
    public void setOperation(String Operators)
    {
        Operator = Operators;
        oldNumber = currentNumber;
        currentNumber = 0;
    }
    public void completeObservation() {
        if ( Operator == "add"){
            currentNumber = oldNumber + currentNumber;
        }
        else if ( Operator == "subtract") {
            currentNumber = oldNumber - currentNumber;
        }
        else if ( Operator == "multiply") {
            currentNumber = oldNumber * currentNumber;
        }
        else if ( Operator == "divide") {
            currentNumber = oldNumber / currentNumber;
        }
        output.setText(Double.toString(currentNumber));
    }
}
