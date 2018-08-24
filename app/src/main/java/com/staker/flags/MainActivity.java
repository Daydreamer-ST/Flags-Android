package com.staker.flags;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private List<Map<String, Object>> data;
    private int times;
    private ArrayList al;
    private String[] ids;
    private int idx;
    private int alltimes;
    private int donetimes;
    private SimpleAdapter sa;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        SharedPreferences sp_alltt = getSharedPreferences("task", MODE_PRIVATE);
        alltimes = sp_alltt.getInt("alltimes", 0);
        donetimes = sp_alltt.getInt("donetimes", 0);
        //任务总次�?

        ids= new String[999999];
        idx=0;
        //新建数组+默认下标�?

        SharedPreferences sp_times = getSharedPreferences("task", MODE_PRIVATE);
        times = sp_times.getInt("id", 1);
        final ListView listView = (ListView)findViewById(R.id.tasklist);
        al = new ArrayList<Map<String, Object>>();
        sa = new SimpleAdapter(this, getData(), R.layout.tasklist, new String[]{"color", "title"}, new int[]{R.id.taskcolorlist, R.id.tasktitlelist});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                final String ids2 = ids[position];
                SharedPreferences sp_describe = getSharedPreferences("task"+ids2,MODE_PRIVATE);
                final String describe = sp_describe.getString("describe", "");
                final String title = sp_describe.getString("title", "");
                final String color = sp_describe.getString("color", "");

                final AlertDialog.Builder listdailog = new AlertDialog.Builder(MainActivity.this);
                listdailog.setMessage(describe);
                listdailog.setNeutralButton("完成",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sp_delete = getSharedPreferences("task"+ids2, MODE_PRIVATE);
                        sp_delete.edit().clear().commit();
                        //完成后清空数�?
                        SharedPreferences.Editor editor2 = getSharedPreferences("task", MODE_PRIVATE).edit();
                        editor2.putInt("donetimes",donetimes+1);
                        editor2.commit();
                        donetimes=donetimes+1;
                        //完成任务�?1
                        Toast.makeText(MainActivity.this,"成功完成",Toast.LENGTH_SHORT).show();
                        al.remove(position);
                        sa.notifyDataSetChanged();
                        //删除+刷新列表
                    }
                });
                listdailog.setPositiveButton("修改",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Taskchange.class);
                        intent.putExtra("title",title);
                        intent.putExtra("describe",describe);
                        intent.putExtra("color",color);
                        intent.putExtra("id",ids2);
                        startActivity(intent);
                    }
                });
                listdailog.setNegativeButton("删除",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder dialog_delete = new AlertDialog.Builder(MainActivity.this);
                        dialog_delete.setTitle("确认删除�?);
                        dialog_delete.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sp_delete = getSharedPreferences("task"+ids2, MODE_PRIVATE);
                                sp_delete.edit().clear().commit();
                                //清空数据
                                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                                //Toast
                                al.remove(position);
                                sa.notifyDataSetChanged();
                                //删除+刷新列表
                            }
                        });
                        dialog_delete.setNegativeButton("关闭",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog_delete.show();
                    }
                });
                listdailog.show();
                //ListView点击Dialog
            }
        });
    }
    private List<Map<String, Object>> getData() {
        for (int i = 1; i < times; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            SharedPreferences sp_more = getSharedPreferences("task"+String.valueOf(i), MODE_PRIVATE);
            String title = sp_more.getString("title", "");
            String color = sp_more.getString("color", "");
            if (color.equals("red")) {
                map.put("color", R.drawable.red);
            }
            if (color.equals("blue")) {
                map.put("color", R.drawable.blue);
            }
            if (color.equals("green")) {
                map.put("color", R.drawable.green);
            }
            if (color.equals("yellow")) {
                map.put("color", R.drawable.yellow);
            }
            if (color.equals("grey")) {
                map.put("color", R.drawable.grey);
            }
            if (color.equals("bluegrey")) {
                map.put("color", R.drawable.bluegrey);
            }
            if (color.equals("pink")) {
                map.put("color", R.drawable.pink);
            }
            if (color.equals("brown")) {
                map.put("color", R.drawable.brown);
            }
            map.put("title", title);
            if (title.length() != 0) {
                al.add(map);
                ids[idx] = String.valueOf(i);
                idx = idx + 1;
            }
        }
        return al;
        //简单listview

    }
    public void taskmore(View v) {
        if (alltimes != 0) {
            int percent = (donetimes * 100) / alltimes;
            final AlertDialog.Builder moredialog = new AlertDialog.Builder(MainActivity.this);
            moredialog.setMessage("累计任务数：" + String.valueOf(alltimes) + "\n" + "完成任务数：" + String.valueOf(donetimes) + "\n" + "完成率：" + percent + "%");
            moredialog.setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            moredialog.create().show();
        } else {
        }

    }
    public void taskadd(View v){
        Intent intent = new Intent(MainActivity.this,Taskadd.class);
        startActivity(intent);
        //添加任务
    }
    public void todate(View v){
        Intent intent = new Intent(MainActivity.this,Dates.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        //底部导航栏跳�?
    }
    public void togoal(View v) {
        Intent intent = new Intent(MainActivity.this, Goal.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        //底部导航栏跳�?
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
