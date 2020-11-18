package com.example.calc;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.calc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + ".");
            }
        });
        binding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "0");
            }
        });
        binding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "1");
            }
        });
        binding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "2");
            }
        });
        binding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "3");
            }
        });
        binding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "4");
            }
        });
        binding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "5");
            }
        });
        binding.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "6");
            }
        });
        binding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "7");
            }
        });
        binding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "8");
            }
        });
        binding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.input.setText(binding.input.getText() + "9");
            }
        });

        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.mess.setText(decimalFormat.format(valueOne) + "+");
                binding.input.setText(null);
            }
        });
        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.mess.setText(decimalFormat.format(valueOne) + "-");
                binding.input.setText(null);
            }
        });
        binding.mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.mess.setText(decimalFormat.format(valueOne) + "*");
                binding.input.setText(null);
            }
        });
        binding.div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.mess.setText(decimalFormat.format(valueOne) + "/");
                binding.input.setText(null);
            }
        });

        binding.percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = PERCENT;
                binding.mess.setText(decimalFormat.format(valueOne) + "%");
                binding.input.setText(null);
            }
        });

        binding.ravno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.mess.setText(binding.mess.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                binding.input.setText("");
                binding.mess.setText("");
            }
        });

        binding.clearOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.input.getText().length() > 0) {
                    CharSequence currentText = binding.input.getText();
                    binding.input.setText(currentText.subSequence(0, currentText.length() - 1));
                }
            }
        });
    }

    private void computeCalculation()
    {
        if(!Double.isNaN(valueOne)) {
            if(CURRENT_ACTION != PERCENT)
            {
                valueTwo = Double.parseDouble(binding.input.getText().toString());
                binding.input.setText(null);
                if(CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if(CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if(CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if(CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;
            }
            else
            {
                valueTwo = 100;
                valueOne = this.valueOne / valueTwo;
            }

        }
        else {
            try
            {
                valueOne = Double.parseDouble(binding.input.getText().toString());
            }
            catch (Exception e){}
        }
    }
}