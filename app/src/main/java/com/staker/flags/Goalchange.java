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

public class Goalchange extends Activity {
    private AlertDialog.Builder dialog;
    private String color;
    private String id;
    private String times;
    private String done_times;
    private String title;
    private String describe;
    private AlertDialog.Builder dialogs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goalchange);
        Intent intent = getIntent();//获取传来的intent对象
        title = intent.getStringExtra("title");
        describe = intent.getStringExtra("describe");
        color = intent.getStringExtra("color");
        id = intent.getStringExtra("id");
        times = intent.getStringExtra("alltimes");
        done_times = intent.getStringExtra("donetimes");
        EditText ed_title = (EditText) findViewById(R.id.goalchangetitle);
        EditText ed_describe = (EditText) findViewById(R.id.goalchangedescribe);
        ed_title.setText(title);
        ed_describe.setText(describe);
    }
    public void goalchange(View v) {
        EditText ed_title = (EditText) findViewById(R.id.goalchangetitle);
        EditText ed_describe = (EditText) findViewById(R.id.goalchangedescribe);
        title = ed_title.getText().toString();
        describe = ed_describe.getText().toString();
        if (title.equals("")||Integer.parseInt(times)<Integer.parseInt(done_times)) {
            Toast.makeText(Goalchange.this, "目标名称为空(或完成次数>总次数)", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences.Editor editor = getSharedPreferences("goal" + id, MODE_PRIVATE).edit();
            editor.putString("title", title);
            editor.putString("describe", describe);
            editor.putString("color", color);
            editor.putString("times", times);
            editor.commit();
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.goalchangedone);
            fab.setEnabled(false);
            Toast.makeText(Goalchange.this, "成功", Toast.LENGTH_SHORT).show();
            //设置FAB暂时不可按+成功提示
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.goalchangedone);
                    fab.setEnabled(true);
                }
            }, 3000);
            //3秒后恢复FAB可按
            //防触碰
        }
    }
    public void goalchangecolor(View v) {
        dialog = new AlertDialog.Builder(Goalchange.this);
        final View dv = LayoutInflater.from(Goalchange.this).inflate(R.layout.dialogcolor, null);
        dialog.setView(dv);
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Goalchange.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
    public void goalchangetimes(View v){
        dialogs = new AlertDialog.Builder(Goalchange.this);
        final View dvs = LayoutInflater.from(Goalchange.this).inflate(R.layout.ed,null);
        dialogs.setView(dvs);
        dialogs.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText ed=(EditText)dvs.findViewById(R.id.ed);
                String times2=ed.getText().toString();
                if(times2.length()!=0){
                    times=times2;
                }
            }
        });
        dialogs.show();
    }
    public void red(View v) {
        color = "red";
        Toast.makeText(Goalchange.this, "已选择红色", Toast.LENGTH_SHORT).show();
    }

    public void blue(View v) {
        color = "blue";
        Toast.makeText(Goalchange.this, "已选择蓝色", Toast.LENGTH_SHORT).show();
    }

    public void yellow(View v) {
        color = "yellow";
        Toast.makeText(Goalchange.this, "已选择黄色", Toast.LENGTH_SHORT).show();
    }

    public void green(View v) {
        color = "green";
        Toast.makeText(Goalchange.this, "已选择绿色", Toast.LENGTH_SHORT).show();
    }

    public void grey(View v) {
        color = "grey";
        Toast.makeText(Goalchange.this, "已选择灰色", Toast.LENGTH_SHORT).show();
    }

    public void bluegrey(View v) {
        color = "bluegrey";
        Toast.makeText(Goalchange.this, "已选择蓝灰色", Toast.LENGTH_SHORT).show();
    }

    public void pink(View v) {
        color = "pink";
        Toast.makeText(Goalchange.this, "已选择粉色", Toast.LENGTH_SHORT).show();
    }

    public void brown(View v) {
        color = "brown";
        Toast.makeText(Goalchange.this, "已选择棕色", Toast.LENGTH_SHORT).show();

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