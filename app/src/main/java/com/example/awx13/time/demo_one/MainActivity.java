package com.example.awx13.time.demo_one;

/**
 * Created by Awx13 on 2016/12/6.
 */


import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.awx13.time.R;
import com.example.awx13.time.demo_one.ui.fragment.fourth.FragmentFour;
import com.example.awx13.time.demo_one.ui.fragment.first.FragmentOne;
import com.example.awx13.time.demo_one.ui.fragment.third.FragmentThree;
import com.example.awx13.time.demo_one.ui.fragment.second.FragmentTwo;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

public class MainActivity extends FragmentActivity {
/*    private DrawerLayout drawerLayout;
    private RelativeLayout leftLayout;
    private RelativeLayout rightLayout;
    private List<ContentModel> list;
    private ContentAdapter adapter;*/
    private TabView tabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabView =(TabView)findViewById(R.id.tabView);
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.drawable.nursingcareplan2,R.drawable.nursingcareplan2,"此刻",  FragmentOne.newInstance("此刻"));
        TabViewChild tabViewChild02=new TabViewChild(R.drawable.paw_code,R.drawable.paw_code,"镌刻",  FragmentTwo.newInstance("镌刻"));
        TabViewChild tabViewChild03=new TabViewChild(R.drawable.paw_left,R.drawable.paw_left,"时光",  FragmentThree.newInstance("时光"));
        TabViewChild tabViewChild04=new TabViewChild(R.drawable.personal_selected,R.drawable.personal_selected,"我的",  FragmentFour.newInstance("我的"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());


        /*初始化左中右三个布局*/

/*
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        leftLayout=(RelativeLayout) findViewById(R.id.left);
        rightLayout=(RelativeLayout) findViewById(R.id.right);
*/

/*初始化lisview控件*/

/*
        ListView listView=(ListView) leftLayout.findViewById(R.id.left_listview);
*/
//      initData();
/*      adapter=new ContentAdapter(this, list);
        list=new ArrayList<ContentModel>();
        list.add(new ContentModel(R.drawable.doctoradvice2, "此刻"));
        list.add(new ContentModel(R.drawable.infusion_selected, "时光"));
        list.add(new ContentModel(R.drawable.mypatient_selected, "收藏"));
        list.add(new ContentModel(R.drawable.nursingcareplan2, "我的"));
        listView.setAdapter(adapter);*/
    }
 /*   @Override

    public void onBackPressed() {
        long mExitTime = System.currentTimeMillis();
        if(System.currentTimeMillis() - mExitTime < 800) {
            ScrollingActivity.this.finish();   //关闭本活动页面
        }
        else{
            Toast.makeText(getApplicationContext(),"再按返回键退出！", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();   //这里赋值最关键，别忘记
        }
    }*/


}