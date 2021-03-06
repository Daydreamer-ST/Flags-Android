package com.staker.flags;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

public class Taskchange extends Activity {
    private String color;
    private String id;
    private AlertDialog.Builder dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.taskchange);
        Intent intent = getIntent();//获取传来的intent对象
        String title = intent.getStringExtra("title");
        String describe = intent.getStringExtra("describe");
        color = intent.getStringExtra("color");
        id = intent.getStringExtra("id");
        EditText ed_title = (EditText) findViewById(R.id.taskchangetitle);
        EditText ed_describe = (EditText) findViewById(R.id.taskchangedescribe);
        ed_title.setText(title);
        ed_describe.setText(describe);
    }
    public void taskchange(View v) {
        EditText ed_title = (EditText) findViewById(R.id.taskchangetitle);
        EditText ed_describe = (EditText) findViewById(R.id.taskchangedescribe);
        String title = ed_title.getText().toString();
        String describe = ed_describe.getText().toString();
        if (title.equals("")) {
            Toast.makeText(Taskchange.this, "任务名称为空", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences.Editor editor = getSharedPreferences("task"+id, MODE_PRIVATE).edit();
            editor.putString("title", title);
            editor.putString("describe", describe);
            editor.putString("color", color);
            editor.commit();
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.taskdone);
            fab.setEnabled(false);
            Toast.makeText(Taskchange.this, "成功", Toast.LENGTH_SHORT).show();
            //设置FAB暂时不可按+成功提示
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.taskdone);
                    fab.setEnabled(true);
                }
            },3000);
            //3秒后恢复FAB可按
            //防触碰
        }
    }
    public void taskchangecolor(View v){
        dialog = new AlertDialog.Builder(Taskchange.this);
        final View dv = LayoutInflater.from(Taskchange.this).inflate(R.layout.dialogcolor,null);
        dialog.setView(dv);
        dialog.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Taskchange.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    public void red(View v){
        color="red";
        Toast.makeText(Taskchange.this,"已选择红色",Toast.LENGTH_SHORT).show();
    }
    public void blue(View v){
        color="blue";
        Toast.makeText(Taskchange.this,"已选择蓝色",Toast.LENGTH_SHORT).show();
    }
    public void yellow(View v){
        color="yellow";
        Toast.makeText(Taskchange.this,"已选择黄色",Toast.LENGTH_SHORT).show();
    }
    public void green(View v){
        color="green";
        Toast.makeText(Taskchange.this,"已选择绿色",Toast.LENGTH_SHORT).show();
    }
    public void grey(View v){
        color="grey";
        Toast.makeText(Taskchange.this,"已选择灰色",Toast.LENGTH_SHORT).show();
    }
    public void bluegrey(View v){
        color="bluegrey";
        Toast.makeText(Taskchange.this,"已选择蓝灰色",Toast.LENGTH_SHORT).show();
    }
    public void pink(View v){
        color="pink";
        Toast.makeText(Taskchange.this,"已选择粉色",Toast.LENGTH_SHORT).show();
    }
    public void brown(View v){
        color="brown";
        Toast.makeText(Taskchange.this,"已选择棕色",Toast.LENGTH_SHORT).show();
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
