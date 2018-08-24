package com.staker.flags;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goal extends Activity {
    private List<Map<String, Object>> data;
    private int times;
    private ArrayList al;
    private String[] ids;
    private int idx;
    private String alltimes;
    private String donetimes;
    private SimpleAdapter sa;
    private Map<String, Object> map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goal);

        ids= new String[999999];
        idx=0;
        //新建数组+默认下标�?

        SharedPreferences sp_times = getSharedPreferences("goal", MODE_PRIVATE);
        times = sp_times.getInt("id", 1);
        final ListView listView = (ListView)findViewById(R.id.goallist);
        al = new ArrayList<Map<String, Object>>();
        sa = new SimpleAdapter(this, getData(), R.layout.goallist, new String[]{"color", "title","times"}, new int[]{R.id.taskcolorlist, R.id.tasktitlelist,R.id.goaltimeslist});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                final String ids2 = ids[position];
                SharedPreferences sp_describe = getSharedPreferences("goal"+ids2,MODE_PRIVATE);
                final String describe = sp_describe.getString("describe", "");
                final String title = sp_describe.getString("title", "");
                final String color = sp_describe.getString("color", "");
                alltimes = sp_describe.getString("times", "");

                final AlertDialog.Builder listdailog = new AlertDialog.Builder(Goal.this);
                listdailog.setMessage(describe);
                listdailog.setNeutralButton("完成",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sp_delete = getSharedPreferences("goal"+ids2, MODE_PRIVATE);
                        //读取�?
                        SharedPreferences.Editor editor = getSharedPreferences("goal"+ids2, MODE_PRIVATE).edit();
                        //修改�?
                        donetimes=sp_delete.getString("donetimes", "0");
                        String alltimes=sp_delete.getString("times", "0");
                        int donetimesint=Integer.parseInt(donetimes);
                        int alltimesint=Integer.parseInt(alltimes);
                        int newdonetimes=donetimesint+1;
                        if(newdonetimes>=alltimesint) {
                            Toast.makeText(Goal.this, "目标完成", Toast.LENGTH_SHORT).show();
                            sp_delete.edit().clear().commit();
                            al.remove(position);
                            sa.notifyDataSetChanged();
                        }else{
                            SharedPreferences sp_describe = getSharedPreferences("goal"+ids2,MODE_PRIVATE);
                            String title = sp_describe.getString("title", "");
                            editor.putString("donetimes",String.valueOf(newdonetimes));
                            editor.commit();
                            Intent intent = new Intent(Goal.this,Goal.class);
                            startActivity(intent);
                            Goal.this.overridePendingTransition(0, 0);
                            finish();
                            /*int precent=newdonetimes*100/alltimesint;
                            String precents=String.valueOf(precent)+"%";
                            Toast.makeText(Goal.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                            map.put("title",title);
                            map.put("times",precents);
                            al.set(0, map);
                            sa.notifyDataSetChanged();
                            //修改+刷新列表*/
                        }
                    }
                });
                listdailog.setPositiveButton("修改",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sp_delete = getSharedPreferences("goal"+ids2, MODE_PRIVATE);
                        donetimes=sp_delete.getString("donetimes", "0");
                        Intent intent = new Intent(Goal.this,Goalchange.class);
                        intent.putExtra("title",title);
                        intent.putExtra("describe",describe);
                        intent.putExtra("color",color);
                        intent.putExtra("id",ids2);
                        intent.putExtra("alltimes",alltimes);
                        intent.putExtra("donetimes",donetimes);
                        startActivity(intent);
                    }
                });
                listdailog.setNegativeButton("删除",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder dialog_delete = new AlertDialog.Builder(Goal.this);
                        dialog_delete.setTitle("确认删除�?);
                        dialog_delete.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SharedPreferences sp_delete = getSharedPreferences("goal"+ids2, MODE_PRIVATE);
                                        sp_delete.edit().clear().commit();
                                        //清空数据
                                        Toast.makeText(Goal.this,"删除成功",Toast.LENGTH_SHORT).show();
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
             map = new HashMap<String, Object>();
            SharedPreferences sp_more = getSharedPreferences("goal" + String.valueOf(i), MODE_PRIVATE);
            String title = sp_more.getString("title", "");
            String color = sp_more.getString("color", "");
            String goaltimes = sp_more.getString("times", "");
            String donetimes = sp_more.getString("times", "");
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
            SharedPreferences sp_read = getSharedPreferences("goal"+String.valueOf(i), MODE_PRIVATE);
            String donetimes2=sp_more.getString("donetimes", "0");
            String alltimes2=sp_read.getString("times", "1");
            int precent=Integer.parseInt(donetimes2)*100/Integer.parseInt(alltimes2);
            map.put("title", title);
            map.put("times",String.valueOf(precent)+"%");
            if (title.length() != 0) {
                al.add(map);
                ids[idx] = String.valueOf(i);
                idx = idx + 1;
            }
        }
        return al;
        //简单listview
    }
    public void goaltotask(View v){
        Intent intent = new Intent(Goal.this,MainActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        //跳转去任�?
    }
    public void goaladd(View v){
        Intent intent = new Intent(Goal.this,Goaladd.class);
        startActivity(intent);
        //添加任务
    }
    public void todate(View v){
        Intent intent = new Intent(Goal.this,Dates.class);
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