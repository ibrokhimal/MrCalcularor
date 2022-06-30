package com.ibrokhimal.mrcalcularor.UI;

import com.ibrokhimal.mrcalcularor.MODEL.Calculator;
import com.ibrokhimal.mrcalcularor.MODEL.Operator;

public class CalculatorPresenter {

    private CalculatorView view;
    private Calculator calculator;
    private boolean checkOnDotBool = false;

    private double argOne;
    private Double argTwo;

    private Operator selectedOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void OnDigitPressed(int digit) {
        int checkOnDot = Integer.parseInt(view.toString());

        if (argTwo == null) {

            if (Math.abs(checkOnDot) > 1 && checkOnDotBool) {
                argOne = argOne * 10 + digit;
            } else {
                argOne = argOne / 10 + digit;
            }

            view.showResult(String.valueOf(argOne));

        } else {

            if (Math.abs(checkOnDot) > 1 && checkOnDotBool) {
                argTwo = argTwo * 10 + digit;
            } else {
                argTwo = argTwo / 10 + digit;
            }

            view.showResult(String.valueOf(argTwo));

        }
    }

    public void onOperatorPressed(Operator operator) {
        if (selectedOperator != null) {
            onEqualsPressed();
        }

        argTwo = 0.0;

        selectedOperator = operator;
    }

    public void onDotPressed() {
        checkOnDotBool = true;
    }

    public void onEqualsPressed() {
        argOne = calculator.perform(argOne, argTwo, selectedOperator);
        view.showResult(String.valueOf(argOne));
    }

    public void onClearPressed() {
        if (argTwo == null) {
            String[] arg = new String[view.toString().length()];
            arg[1] = " ";
            argOne = argOne / 10; //нужно продолжыть тут;
        }
    }

    public void onClearAllPressed() {
        argOne = 0.0;
        argTwo = null;
        selectedOperator = null;
        view.showResult(String.valueOf(argOne));
    }

    public void onPercentPressed() {
    }
}
