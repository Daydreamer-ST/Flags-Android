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
        //任务总次数

        ids= new String[999999];
        idx=0;
        //新建数组+默认下标为0

        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String date = sdf.format(d);
        //获取日期
        if (date.equals("01")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date1);
        }
        if (date.equals("02")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date2);
        }
        if (date.equals("03")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date3);
        }
        if (date.equals("04")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date4);
        }
        if (date.equals("05")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date5);
        }
        if (date.equals("06")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date6);
        }
        if (date.equals("07")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date7);
        }
        if (date.equals("08")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date8);
        }
        if (date.equals("09")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date9);
        }
        if (date.equals("10")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date10);
        }
        if (date.equals("11")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date11);
        }
        if (date.equals("12")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date12);
        }
        if (date.equals("13")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date13);
        }
        if (date.equals("14")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date14);
        }
        if (date.equals("15")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date15);
        }
        if (date.equals("16")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date16);
        }
        if (date.equals("17")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date17);
        }
        if (date.equals("18")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date18);
        }
        if (date.equals("19")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date19);
        }
        if (date.equals("20")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date20);
        }
        if (date.equals("21")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date21);
        }
        if (date.equals("22")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date22);
        }
        if (date.equals("23")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date23);
        }
        if (date.equals("24")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date24);
        }
        if (date.equals("25")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date25);
        }
        if (date.equals("26")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date26);
        }
        if (date.equals("27")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date27);
        }
        if (date.equals("28")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date28);
        }
        if (date.equals("29")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date29);
        }
        if (date.equals("30")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date30);
        }
        if (date.equals("31")) {
            LinearLayout dateicon = (LinearLayout) findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date31);
        }
        //日期图标显示*/

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
                        //完成后清空数据
                        SharedPreferences.Editor editor2 = getSharedPreferences("task", MODE_PRIVATE).edit();
                        editor2.putInt("donetimes",donetimes+1);
                        editor2.commit();
                        donetimes=donetimes+1;
                        //完成任务数+1
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
                        dialog_delete.setTitle("确认删除？");
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
        //底部导航栏跳转
    }
    public void togoal(View v) {
        Intent intent = new Intent(MainActivity.this, Goal.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        finish();
        //底部导航栏跳转
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
