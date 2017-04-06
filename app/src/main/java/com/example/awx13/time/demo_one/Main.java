package com.example.awx13.time.demo_one;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.awx13.time.demo_one.db.MyUser;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Ym on 2017/4/6.
 */

class Main extends Activity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        initUser();
        super.onCreate(savedInstanceState, persistentState);

    }

    private void initUser(){
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        if(pref.getBoolean("idRemember",true)) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            Log.d("TAG_", "登入失败：" + account+password);

            MyUser bu2 = new MyUser();
            bu2.setUsername(account);
            bu2.setPassword(password);
            bu2.login(new SaveListener<BmobUser>() {

                public void done(BmobUser bmobUser, BmobException e) {
                    if (e == null) {
                        //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                        //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                     /*进入首页*/
                        startActivity(new Intent(Main.this, MainActivity.class));
                        Log.d("TAG_", "登入失败：1");
                        finish();
                    } else {
                        startActivity(new Intent(Main.this, DR.class));
                        Log.d("TAG_", "登入失败：2"  );
                        finish();

                    }
                }
            });
        }else {
            startActivity(new Intent(Main.this, DR.class));
            Log.d("TAG_", "登入失败：3"  );
            finish();}
    }
}
