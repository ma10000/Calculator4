package helloworld.se.cs.bistu.edu.cn.calculator4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import bsh.EvalError;
import bsh.Interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import bsh.EvalError;
import bsh.Interpreter;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 数字
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    /**
     * 运算符
     */
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    /**
     * 其他
     */
    private Button dot_btn;
    private Button percent_btn;
    private Button delete_btn;
    private Button ac_btn;
    private Button bin_btn;
    private Button oct_btn;
    private Button hex_btn;
    private Button yingcun_btn;
    private Button cun;
    private Button cos_btn;
    private Button sin_btn;
    private Button mihanshu;
    private Button x2;
    private Button zuokuo;
    private Button youkuo;
    /**
     * 结果
     */
    private EditText mResultText;
    /**
     * 已经输入的字符
     */
    private String existedText = "";
    /**
     * 是否计算过
     */
    private boolean isCounted = false;
    /**
     * 以负号开头，且运算符不是是减号
     * 例如：-21×2
     */
    private boolean startWithOperator = false;
    /**
     * 以负号开头，且运算符是减号
     * 例如：-21-2
     */
    private boolean startWithSubtract = false;
    /**
     * 不以负号开头，且包含运算符
     * 例如：21-2
     */
    private boolean noStartWithOperator = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        /**
         * 数字
         */
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);
        /**
         * 运算符
         */
        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        /**
         * 其他
         */
        dot_btn = (Button) findViewById(R.id.dot_btn);
        percent_btn = (Button) findViewById(R.id.percent_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        bin_btn = (Button) findViewById(R.id.bin_btn);
        oct_btn = (Button) findViewById(R.id.oct_btn);
        hex_btn = (Button) findViewById(R.id.hex_btn);
        yingcun_btn = (Button) findViewById(R.id.yingcun);
        cun = (Button) findViewById(R.id.cun);
        cos_btn = (Button) findViewById(R.id.cos_btn);
        sin_btn = (Button) findViewById(R.id.sin_btn);
        mihanshu = (Button) findViewById(R.id.mihanshu);
        x2 = (Button) findViewById(R.id.x2);
        zuokuo = (Button) findViewById(R.id.zuokuo);
        youkuo = (Button) findViewById(R.id.youkuo);
        /**
         * 结果
         */
        mResultText = (EditText) findViewById(R.id.result_text);
        /**
         * 已经输入的字符
         */
        existedText = mResultText.getText().toString();

    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);

        dot_btn.setOnClickListener(this);
        percent_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
        bin_btn.setOnClickListener(this);
        oct_btn.setOnClickListener(this);
        hex_btn.setOnClickListener(this);
        yingcun_btn.setOnClickListener(this);
        cun.setOnClickListener(this);
        cos_btn.setOnClickListener(this);
        sin_btn.setOnClickListener(this);
        mihanshu.setOnClickListener(this);
        x2.setOnClickListener(this);
        zuokuo.setOnClickListener(this);
        youkuo.setOnClickListener(this);
    }

    /**
     * 点击事件
     * @param v  点击的控件
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            /**
             * 数字
             */
            case R.id.num_zero:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "0";
                break;
            case R.id.num_one:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "1";
                break;
            case R.id.num_two:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "2";
                break;
            case R.id.num_three:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "3";
                break;
            case R.id.num_four:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "4";
                break;
            case R.id.num_five:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "5";
                break;
            case R.id.num_six:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "6";
                break;
            case R.id.num_seven:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "7";
                break;
            case R.id.num_eight:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "8";
                break;
            case R.id.num_nine:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "9";
                break;
            case R.id.x2:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "√X";
                break;
            case R.id.zuokuo:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "(";
                break;
            case R.id.youkuo:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += ")";
                break;
            case R.id.cos_btn:
                /*float s=0;
                if(existedText.contains("÷")){
                    String shu=existedText.substring(existedText.indexOf("÷")+1);
                    s=(float)Math.cos(Math.PI/Double.valueOf(shu));
                }else{
                    s=(float)Math.cos(Math.PI/Double.valueOf(existedText));
                }
                existedText=Float.toString(s);*/
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "cos";
                break;
            case R.id.sin_btn:
                if (existedText.equals("0")){
                    existedText = "";
                }
                existedText += "sin";
                break;
            case R.id.mihanshu:
                existedText += "^";
                break;
            case R.id.plus_btn:
                existedText += "+";
                break;
            case R.id.subtract_btn:
                existedText += "-";
                break;
            case R.id.multiply_btn:
                existedText += "*";
                break;
            case R.id.divide_btn:
                existedText += "÷";
                break;
            case R.id.equal_btn:
                double c=0;
                String ex = existedText;
                ex = ex.replaceAll("÷", "/");
                if(ex.contains("cos")){
                    String shu=ex.substring(3);
                    c=Math.cos(Double.valueOf(shu));
                }else if(ex.contains("sin")){
                    String shu=ex.substring(3);
                    c=Math.sin(Double.valueOf(shu));
                }else if(ex.contains("√X")){
                    String shu=ex.substring(2);
                    c=Math.sqrt(Double.valueOf(shu));
                }else if(ex.contains("^")){
                    String shu1=ex.substring(0,ex.indexOf("^"));
                    String shu2=ex.substring(ex.indexOf("^")+1);
                    c=Math.pow(Double.valueOf(shu1),Double.valueOf(shu2));
//                    existedText=shu2;
                }
                else if(ex.contains(")")){
                    c=Double.valueOf(getRs(ex));
                }else{
                    c=Result(ex);
                }

                existedText=String.valueOf(c);
                /*existedText = getResult();
                isCounted = true;*/
                break;
            /**
             * 其他
             */
            case R.id.dot_btn:
                existedText += ".";
                break;
            case R.id.percent_btn:

                if (existedText.equals("error")){

                }  else {
                        if (existedText.equals("0")) {
                            return;
                        } else {
                            double temp = Double.parseDouble(existedText);
                            temp = temp / 100;
                            existedText = String.valueOf(temp);
                        }
                    }

                break;
            case R.id.delete_btn:
                /**
                 * 字符串长度大于 0 时才截取字符串
                 * 如果长度为 1，则直接把字符串设置为 0
                 */
                if (existedText.equals("error")){
                    existedText = "0";
                } else if (existedText.length() > 0){
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0,existedText.length()-1);
                    }
                }
                break;
            case R.id.bin_btn:
                String tem=existedText;
                int i = Integer.parseInt(tem);
                String b=Integer.toBinaryString(i);
                existedText=b;
                break;
            case R.id.oct_btn:
                String te=existedText;
                int iw = Integer.parseInt(te);
                String bw=Integer.toOctalString(iw);
                existedText=bw;
                break;
            case R.id.hex_btn:
                String t=existedText;
                int w = Integer.parseInt(t);
                String bww=Integer.toHexString(w);
                existedText=bww;
                break;
            case R.id.yingcun:
                double d=Double.parseDouble(existedText);
                double m=d/2.541;
                String tr=Double.toString(m);
                existedText=tr;
                break;
            case R.id.ac_btn:
                existedText = "0";
                break;
        }
        /**
         * 设置显示
         */
        mResultText.setText(existedText);
    }


    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    private static double cos(String o){
        double c=0;
        String s=o.substring(6,o.length()-2);
        int d=Integer.valueOf(s);
        if(o.contains("/")){
            c=Math.cos(Math.PI/d);
        }else{
            c=Math.cos(Math.PI*d);
        }
        return c;
    }
    private static double Result(String str) {
        ArrayList<String> ops = getOps(str);
        ArrayList<Double> num = getNum(str);
        // 先乘除再加减
        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i).contains("*") || ops.get(i).contains("/")) {
                String op = ops.remove(i);
                if (op.equals("*")) {
                    // 从数字集合取对应和后面一位数字
                    double d1 = num.remove(i);
                    double d2 = num.remove(i);

                    double number = d1*d2;
                    //再加上
                    num.add(i,number);
                }
                if (op.equals("/")) {
                    double d1 = num.remove(i);
                    double d2 = num.remove(i);
                    double number = d1/d2;
                    num.add(i, number);
                }
                i--;    //刚刚移掉两个,却又刚加上一个新数,所以i要--,因为i++,所以才能取到,如果不加那么虽然貌似正常,但是如果如8*3/3,*/连在一起就报错了;因为连着的两个if;
            }
        }
        //到+-,按顺序的所以就用while()了
        while (ops.size() != 0) {
            String op = ops.remove(0);
            double d1 = num.remove(0);
            double d2 = num.remove(0);

            if (op.equals("+")) {
                double number = d1+d2;
                //再加入
                num.add(0, number);
            }
            if (op.equals("-")) {
                double number = d1-d2;
                num.add(0, number);
            }
        }
        return num.get(0);
    }

    /**
     * 获取符号 1.首位 和 * /后面 的-变成@,其他的-不用
     */
    private static ArrayList getNum(String str) {
        // -变成@
        str = change(str);
        ArrayList<Double> list = new ArrayList();

        String[] split = str.split("[\\+\\-\\*/]");
        for (int i = 0; i < split.length; i++) { // @3,5,@4,9,@3
            String s = split[i];
            // 再把@变成-
            if (s.contains("@")) {
                s = '-' + s.substring(1);
            }
            list.add(Double.parseDouble(s));
        }

        return list;
    }

    private static String change(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // @3+5*-4-9/-3
            if (i == 0 && chars[i] == '-') {
                str = '@' + str.substring(i + 1);
            }
            // @3+5*@4-9/@3
            if (chars[i] == '*' && chars[i + 1] == '-' || chars[i] == '/' && chars[i + 1] == '-') {
                str = str.substring(0, i + 1) + '@' + str.substring(i + 2);
            }
        }
        return str;
    }

    // 获取符号
    private static ArrayList getOps(String str) {
        ArrayList<String> list = new ArrayList();
        // @变-
        str = change(str);
        // @3+5*@4-9/@3
        String[] split = str.split("[0-9\\.@]");// 表示0-9包括小数和@
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("+") || split[i].contains("-") || split[i].contains("*") || split[i].contains("/")) {
                list.add(split[i]);
            }
        }
        return list;
    }

    private static String getRs(String exp){
        Interpreter bsh = new Interpreter();
        Number result = null;
        try {
            exp = filterExp(exp);
            result = (Number)bsh.eval(exp);
        } catch (EvalError e) {
            e.printStackTrace();
            return "算数公式错误";
        }
        exp = result.doubleValue()+"";
        if(exp.endsWith(".0"))
            exp = exp.substring(0, exp.indexOf(".0"));
        return exp;
    }

    private static String filterExp(String exp) {
        String num[] = exp.split("");
        String temp = null;
        int begin=0,end=0;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];
            if(temp.matches("[+-/()*]")){
                if(temp.equals(".")) continue;
                end = i - 1;
                temp = exp.substring(begin, end);
                if(temp.trim().length() > 0 && temp.indexOf(".")<0)
                    num[i-1] = num[i-1]+".0";
                begin = end + 1;
            }
        }
        return Arrays.toString(num).replaceAll("[\\[\\], ]", "");
    }


}
