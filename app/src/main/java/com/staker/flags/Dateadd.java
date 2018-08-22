package com.staker.flags;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dateadd extends Activity {
    private String color;
    private AlertDialog.Builder dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dateadd);
    }
    public void bluejb(View v){
        color="bluejb";
        Toast.makeText(Dateadd.this,"已选择蓝色渐变",Toast.LENGTH_SHORT).show();
    }
    public void orangejb(View v){
        color="orangejb";
        Toast.makeText(Dateadd.this,"已选择橙色渐变",Toast.LENGTH_SHORT).show();
    }
    public void tealjb(View v){
        color="tealjb";
        Toast.makeText(Dateadd.this,"已选择绿色渐变",Toast.LENGTH_SHORT).show();
    }
    public void pinkjb(View v){
        color="pinkjb";
        Toast.makeText(Dateadd.this,"已选择粉色渐变",Toast.LENGTH_SHORT).show();
    }
    public void greyjb(View v){
        color="greyjb";
        Toast.makeText(Dateadd.this,"已选择灰色渐变",Toast.LENGTH_SHORT).show();
        //颜色选择
    }
    public void datecolor(View v){
        dialog = new AlertDialog.Builder(Dateadd.this);
        final View dv = LayoutInflater.from(Dateadd.this).inflate(R.layout.jbscolor,null);
        dialog.setView(dv);
        dialog.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent(Dateadd.this,Dates.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        return false;
        //监听返回键，返回上一个布局
    }
}
