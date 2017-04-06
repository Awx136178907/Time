package com.example.awx13.time.demo_one;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.awx13.time.R;
import com.example.awx13.time.demo_one.db.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class DR extends Activity implements OnClickListener {

    @BindView(R.id.dr_text)
    TextView drText;
    @BindView(R.id.qqimage)
    ImageView qqimage;
    @BindView(R.id.wxiamge)
    ImageView wxiamge;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_psw)
    EditText inputPsw;
    @BindView(R.id.main_zhuce)
    TextView mainZhuce;
    @BindView(R.id.main_login)
    TextView mainLogin;
    @BindView(R.id.relativeLayout)
    LinearLayout relativeLayout;
    @BindView(R.id.activity_dr)
    RelativeLayout activityDr;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    protected void onCreate(Bundle savedInstanceState) {
        initBomn();

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dr);

        ButterKnife.bind(this);
    }
    private void initBomn(){
        Bmob.initialize(this, "6b0011e78e2b0ab51d739be7edb59e0d");
        MyUser bmobUser = MyUser.getCurrentUser(MyUser.class);
        if(bmobUser!= null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config)
    }

    public void yanz(final String a, final String b) {
        MyUser bu2 = new MyUser();
        bu2.setUsername(a);
        bu2.setPassword(b);
        Toast.makeText(DR.this, a + "    " + b, Toast.LENGTH_SHORT).show();
        bu2.login(new SaveListener<BmobUser>() {

            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
//                    String account = pref.getString("account", "");
//                    String password = pref.getString("password", "");
                    Toast.makeText(DR.this, "登入成功", Toast.LENGTH_SHORT).show();
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                     /*进入首页*/
                    startActivity(new Intent(DR.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(DR.this, "密码错误", Toast.LENGTH_SHORT).show();
                    Log.d("TAG_", "登入失败：" + e);
                }
            }
        });
    }


    @OnClick({R.id.qqimage, R.id.wxiamge, R.id.main_zhuce, R.id.main_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qqimage:
                Toast.makeText(DR.this, "QQ", Toast.LENGTH_SHORT).show();
                 /*QQ第三方登入*/
                break;
            case R.id.wxiamge:
                Toast.makeText(DR.this, "微信", Toast.LENGTH_SHORT).show();
                /*微信第三方登入*/
                break;
            case R.id.main_zhuce:
                Toast.makeText(DR.this, "注册", Toast.LENGTH_SHORT).show();
                /*进入注册页面*/
                startActivity(new Intent(DR.this, ZC.class));
                break;
            case R.id.main_login:
                yanz(inputName.getText().toString(),inputPsw.getText().toString());Toast.makeText(DR.this, "登入", Toast.LENGTH_SHORT);

                /*发送短信*/
//               startActivity(new Intent(DR.this,MessageText.class));
                break;
        }
    }
}
