package com.staker.flags;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

public class Goaladd extends Activity {
    private String color;
    private int times;
    private String goal_times;
    private int alltimes;
    private AlertDialog.Builder dialog;
    private AlertDialog.Builder dialogs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goaladd);

        goal_times="";
        //默认次数：空（让用户输入）
        color="blue";
        //默认颜色：蓝色
        SharedPreferences sp_times = getSharedPreferences("goal", MODE_PRIVATE);
        times = sp_times.getInt("id", 1);
        //获取id
    }
    public void goaladddone(View v){
        EditText ed_title=(EditText)findViewById(R.id.goaladdtitle);
        EditText ed_describe=(EditText)findViewById(R.id.goaladddescribe);
        String title=ed_title.getText().toString();
        String describe=ed_describe.getText().toString();
        if(title.equals("")||goal_times.equals("")||Integer.parseInt(goal_times)<=0) {
            Toast.makeText(Goaladd.this, "目标名称/次数为空（或不符合规定）", Toast.LENGTH_LONG).show();
        }else{
            SharedPreferences.Editor editor = getSharedPreferences("goal"+String.valueOf(times), MODE_PRIVATE).edit();
            editor.putString("title",title);
            editor.putString("describe",describe);
            editor.putString("times",goal_times);
            editor.putString("donetimes","0");
            editor.putString("color",color);
            editor.commit();
            SharedPreferences.Editor editor2 = getSharedPreferences("goal", MODE_PRIVATE).edit();
            editor2.putInt("id",times+1);
            editor2.commit();
            times=times+1;
            //任务id
            editor2.putInt("alltimes",alltimes+1);
            editor2.commit();
            alltimes=alltimes+1;
            //任务总次数
            FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.goaldone);
            fab.setEnabled(false);
            Toast.makeText(Goaladd.this, "成功", Toast.LENGTH_SHORT).show();
            //设置FAB暂时不可按+成功提示
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.goaldone);
                    fab.setEnabled(true);
                }
            },3000);
            //3秒后恢复FAB可按
            //防触碰
        }
    }
    public void red(View v){
        color="red";
        Toast.makeText(Goaladd.this,"已选择红色",Toast.LENGTH_SHORT).show();
    }
    public void blue(View v){
        color="blue";
        Toast.makeText(Goaladd.this,"已选择蓝色",Toast.LENGTH_SHORT).show();
    }
    public void yellow(View v){
        color="yellow";
        Toast.makeText(Goaladd.this,"已选择黄色",Toast.LENGTH_SHORT).show();
    }
    public void green(View v){
        color="green";
        Toast.makeText(Goaladd.this,"已选择绿色",Toast.LENGTH_SHORT).show();
    }
    public void grey(View v){
        color="grey";
        Toast.makeText(Goaladd.this,"已选择灰色",Toast.LENGTH_SHORT).show();
    }
    public void bluegrey(View v){
        color="bluegrey";
        Toast.makeText(Goaladd.this,"已选择蓝灰色",Toast.LENGTH_SHORT).show();
    }
    public void pink(View v){
        color="pink";
        Toast.makeText(Goaladd.this,"已选择粉色",Toast.LENGTH_SHORT).show();
    }
    public void brown(View v){
        color="brown";
        Toast.makeText(Goaladd.this,"已选择棕色",Toast.LENGTH_SHORT).show();

    }
    public void goaltimes(View v){
        dialogs = new AlertDialog.Builder(Goaladd.this);
        final View dvs = LayoutInflater.from(Goaladd.this).inflate(R.layout.ed,null);
        dialogs.setView(dvs);
        dialogs.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText ed=(EditText)dvs.findViewById(R.id.ed);
                goal_times=ed.getText().toString();
            }
        });
        dialogs.show();
    }
    public void goalcolor(View v){
        dialog = new AlertDialog.Builder(Goaladd.this);
        View dv = LayoutInflater.from(Goaladd.this).inflate(R.layout.dialogcolor,null);
        dialog.setView(dv);
        dialog.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dialog.show();
    }
    public void totaskadd(View v){
        Intent intent = new Intent(Goaladd.this,Taskadd.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        //跳转
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
