package com.ibrokhimal.mrcalcularor.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ibrokhimal.mrcalcularor.MODEL.CalculateImpl;
import com.ibrokhimal.mrcalcularor.MODEL.Operator;
import com.ibrokhimal.mrcalcularor.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.monitor);

        presenter = new CalculatorPresenter(this, new CalculateImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitalClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.key_0).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_1).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitalClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitalClickListener);

        Map<Integer, Operator> operators = new HashMap<>();

        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus, Operator.SUB);
        operators.put(R.id.key_multiply, Operator.MULT);
        operators.put(R.id.key_divide, Operator.DIV);

        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_multiply).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operatorsClickListener);


        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

        findViewById(R.id.key_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onEqualsPressed();
            }
        });

        findViewById(R.id.key_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClearPressed();
            }
        });

        findViewById(R.id.key_clear_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClearAllPressed();
            }
        });

        findViewById(R.id.key_percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPercentPressed();
            }
        });
    }

    @Override
    public void showResult(String result) {
        resultTxt.setText(result);
    }
}