/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.JTextField;

/**
 *
 * @author dattran
 */
public class MainController {

    private BigDecimal memory;
    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private JTextField screenContent;
    private Operator opt;
    private boolean isProcessing;

    public enum Operator {
        ADD, SUB, MUL, DIV, NONE
    }

    public MainController(JTextField screenContent) {
        this.screenContent = screenContent;
        memory = new BigDecimal("0");
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        opt = Operator.NONE;
        isProcessing = false;
    }

    public void pressClear() {
        clearScreen();
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        opt = Operator.NONE;
        isProcessing = false;
    }

    public void pressNumber(int num) {
        if (isProcessing || isERROR() || getScreenContent().compareTo("0") == 0) {
            setScreenContent(num + "");
            isProcessing = false;
        } else {
            setScreenContent(getScreenContent() + num);
        }
    }

    public void pressDot() {
        if (isProcessing) {
            setScreenContent("0.");
            isProcessing = false;
        }

        if (!getScreenContent().contains(".")) {
            setScreenContent(getScreenContent() + ".");
        }
    }

    public void pressNegate() {
        if (isERROR()) {
            setScreenContent("-0");
        } else {
            setScreenContent(getValueFromScreen().negate() + "");
        }
        isProcessing = false;
    }

    public void calculate() {
        if (!isProcessing) {
            secondNumber = getValueFromScreen();
            switch (opt) {
                case ADD:
                    firstNumber = firstNumber.add(secondNumber, MathContext.DECIMAL32);
                    break;
                case SUB:
                    firstNumber = firstNumber.subtract(secondNumber, MathContext.DECIMAL32);
                    break;
                case MUL:
                    firstNumber = firstNumber.multiply(secondNumber, MathContext.DECIMAL32);
                    break;
                case DIV:
                    try {
                    firstNumber = firstNumber.divide(secondNumber, MathContext.DECIMAL32);
                } catch (Exception e) {
                    setScreenContent("ERROR");
                    isProcessing = false;
                }
                break;
                default:
                    firstNumber = getValueFromScreen();
            }
            setScreenContent(firstNumber + "");
            isProcessing = true;
        }
    }

    public void pressEqual() {
        if (!isERROR()) {
            calculate();
            opt = Operator.NONE;
        }
    }

    public void pressSqrt() {
        if (!isERROR()) {
            try {
                double value = getValueFromScreen().doubleValue();
                String valueString = Math.sqrt(value) + "";
                setScreenContent(new BigDecimal(valueString, MathContext.DECIMAL32).stripTrailingZeros() + "");
            } catch (Exception e) {
                printErrorMsg();
                System.out.println(e);
            }
        } else {
            setScreenContent("0");
        }
        isProcessing = true;
    }

    public void pressPercent() {
        if (!isERROR()) {
            try {
                BigDecimal bd100 = new BigDecimal("100");
                setScreenContent(getValueFromScreen().divide(bd100, MathContext.DECIMAL32) + "");
            } catch (Exception e) {
                printErrorMsg();
                System.out.println(e);
            }
        }
        isProcessing = true;
    }

    public void pressFrac() {
        if (!isERROR()) {
            try {
                BigDecimal bd1 = new BigDecimal("1");
                setScreenContent(bd1.divide(getValueFromScreen(), MathContext.DECIMAL32) + "");
            } catch (Exception e) {
                printErrorMsg();
                System.out.println(e);
            }
        }
        isProcessing = true;
    }

    public void pressMC() {
        memory = BigDecimal.valueOf(0);
    }

    public void pressMR() {
        setScreenContent(memory + "");
        isProcessing = true;
    }

    public void pressMAdd() {
        if (!isERROR()) {
            memory = memory.add(getValueFromScreen(), MathContext.DECIMAL32);
        }
        isProcessing = true;
    }

    public void pressMSub() {
        if (!isERROR()) {
            memory = memory.subtract(getValueFromScreen(), MathContext.DECIMAL32);
        }
        isProcessing = true;
    }

    private boolean isERROR() {
        return getScreenContent().equalsIgnoreCase("ERROR");
    }

    private BigDecimal getValueFromScreen() {
        try {
            return new BigDecimal(getScreenContent());
        } catch (Exception e) {
            return firstNumber;
        }
    }

    private void clearScreen() {
        setScreenContent("0");
    }

    private void setOperator(Operator opt) {
        this.opt = opt;
    }

    public String getScreenContent() {
        return screenContent.getText();
    }

    public void setScreenContent(String screenContent) {
        this.screenContent.setText(screenContent);
    }

    private void printErrorMsg() {
        this.setScreenContent("ERROR");
    }

    public Operator getOpt() {
        return opt;
    }

    public void setOpt(Operator opt) {
        this.opt = opt;
    }

}
