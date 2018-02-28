package com.example.administrator.ricocalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String displaynum="";
    private String numbefore="";
    private int flag=0;
    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(TextView)findViewById(R.id.display);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                    if(displaynum!=""){
                        displaynum+="0";
                        display.setText(displaynum);
                    }
                    else if(displaynum==""){
                        displaynum="0";
                        display.setText(displaynum);
                    }
                break;
            case R.id.btn_1:

                    displaynum+="1";
                    display.setText(displaynum);

                break;
            case R.id.btn_2:
                displaynum+="2";
                display.setText(displaynum);
                break;
            case R.id.btn_3:
                displaynum+="3";
                display.setText(displaynum);
                break;
            case R.id.btn_4:
                displaynum+="4";
                display.setText(displaynum);
                break;
            case R.id.btn_5:
                displaynum+="5";
                display.setText(displaynum);
                break;
            case R.id.btn_6:
                displaynum+="6";
                display.setText(displaynum);
                break;
            case R.id.btn_7:
                displaynum+="7";
                display.setText(displaynum);
                break;
            case R.id.btn_8:
                displaynum+="8";
                display.setText(displaynum);
                break;
            case R.id.btn_9:
                displaynum+="9";
                display.setText(displaynum);
                break;
            //小数点
            case R.id.btn_dot:
                if(displaynum!=""&&(appearNumber(displaynum.toString(),".")<1)){
                    displaynum+=".";
                    display.setText(displaynum);
                }
                else if(displaynum==""){
                    displaynum="0.";
                    display.setText(displaynum);
                }
                break;
            //正负号
            case R.id.btn_pm:
                if(appearNumber(displaynum.toString(),"-")<1){
                    StringBuilder sb=new StringBuilder(displaynum);
                    sb.insert(0,"-");
                    displaynum=sb.toString();
                    display.setText(displaynum);
                }
                else{

                    display.setText(displaynum=displaynum.substring(1,displaynum.length()));
                }


                break;
            //归位
            case R.id.btn_c:
                numbefore="";
                displaynum="";
                display.setText("0");
                break;
            //加法
            case R.id.btn_add:
                    equal(flag);
                    flag=1;
                    numbefore=displaynum;
                    displaynum="";
                    display.setText("0");


                break;
            //减法
            case R.id.btn_minus:
                equal(flag);
                flag=2;
                numbefore=displaynum;
                displaynum="";
                display.setText("0");
                break;
            //乘法
            case R.id.btn_multiply:
                equal(flag);
                flag=3;
                numbefore=displaynum;
                displaynum="";
                display.setText("0");
                break;
            //除法
            case R.id.btn_divide:
                equal(flag);
                flag=4;
                numbefore=displaynum;
                displaynum="";
                display.setText("0");
                break;
            //取余
            case R.id.btn_remaining:
                equal(flag);
                flag=5;
                numbefore=displaynum;
                displaynum="";
                display.setText("0");
                break;
            case R.id.btn_equal:
                equal(flag);
                break;



        }
    }
    public int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    public void equal(int flag){
        double n1;
        double n2;
        double eq;
        String eqs;
        switch (flag){
            case 0:
                break;
            case 1:
                n1=Double.parseDouble(numbefore);
                n2=Double.parseDouble(displaynum);
                eq=n1+n2;
                eqs=Double.toString(eq);
                displaynum=eqs;
                display.setText(displaynum);
                this.flag=0;
                break;
            case 2:
                n1=Double.parseDouble(numbefore);
                n2=Double.parseDouble(displaynum);
                eq=n1-n2;
                eqs=Double.toString(eq);
                displaynum=eqs;
                display.setText(displaynum);
                this.flag=0;
                break;
            case 3:
                n1=Double.parseDouble(numbefore);
                n2=Double.parseDouble(displaynum);
                eq=n1*n2;
                eqs=Double.toString(eq);
                displaynum=eqs;
                display.setText(displaynum);
                this.flag=0;
                break;
            case 4:
                n1=Double.parseDouble(numbefore);
                n2=Double.parseDouble(displaynum);
                eq=n1/n2;
                eqs=Double.toString(eq);
                displaynum=eqs;
                display.setText(displaynum);
                this.flag=0;
                break;
            case 5:
                n1=Double.parseDouble(numbefore);
                n2=Double.parseDouble(displaynum);
                eq=n1%n2;
                eqs=Double.toString(eq);
                displaynum=eqs;
                display.setText(displaynum);
                this.flag=0;
                break;

        }


    }


}
