package com.staker.flags;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.umeng.analytics.MobclickAgent;

import java.text.SimpleDateFormat;

public class Dates extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.date);
        java.util.Date d = new java.util.Date( );
        SimpleDateFormat sdf = new SimpleDateFormat ("dd");
        String date=sdf.format(d);
        //获取日期
        if(date.equals("01")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date1on);
        }
        if(date.equals("02")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date2on);
        }
        if(date.equals("03")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date3on);
        }
        if(date.equals("04")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date4on);
        }
        if(date.equals("05")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date5on);
        }
        if(date.equals("06")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date6on);
        }
        if(date.equals("07")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date7on);
        }
        if(date.equals("08")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date8on);
        }
        if(date.equals("09")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date9on);
        }
        if(date.equals("10")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date10on);
        }
        if(date.equals("11")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date11on);
        }
        if(date.equals("12")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date12on);
        }
        if(date.equals("13")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date13on);
        }
        if(date.equals("14")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date14on);
        }
        if(date.equals("15")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date15on);
        }
        if(date.equals("16")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date16on);
        }
        if(date.equals("17")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date17on);
        }
        if(date.equals("18")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date18on);
        }
        if(date.equals("19")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date19on);
        }
        if(date.equals("20")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date20on);
        }
        if(date.equals("21")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date21on);
        }
        if(date.equals("22")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date22on);
        }
        if(date.equals("23")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date23on);
        }
        if(date.equals("24")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date24on);
        }
        if(date.equals("25")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date25on);
        }
        if(date.equals("26")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date26on);
        }
        if(date.equals("27")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date27on);
        }
        if(date.equals("28")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date28on);
        }
        if(date.equals("29")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date29on);
        }
        if(date.equals("30")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date30on);
        }
        if(date.equals("31")){
            LinearLayout dateicon = (LinearLayout)findViewById(R.id.dateicon);
            dateicon.setBackgroundResource(R.drawable.date31on);
        }
        //日期图标显示
    }
    public void dateadd(View v){
        Intent intent = new Intent(Dates.this,Dateadd.class);
        startActivity(intent);
        finish();
        //添加任务
    }
    public void totask(View v){
        Intent intent = new Intent(Dates.this,MainActivity.class);
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
        //友盟统计
    }
}
