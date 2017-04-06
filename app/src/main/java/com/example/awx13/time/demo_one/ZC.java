package com.example.awx13.time.demo_one;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.awx13.time.R;
import com.example.awx13.time.demo_one.db.MyUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Awx13 on 2016/11/15.
 */

public class ZC extends Activity implements View.OnClickListener {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.zc_zh)
    EditText zcZh;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.zc_psw)
    EditText zcPsw;
    @BindView(R.id.linearLayout)
    RelativeLayout linearLayout;
    @BindView(R.id.zc_btn_zc)
    TextView zcBtnZc;
    @BindView(R.id.zc_btn_bc)
    TextView zcBtnBc;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_zc);
        ButterKnife.bind(this);
    }



    public void zhuc(String a, String b) {
        if (checkEmaile(a) || isChinaPhoneLegal(a)) {
            BmobUser bu = new BmobUser();
            bu.setUsername(a);
            bu.setPassword(b);
            bu.setEmail(a);
            //注意：不能用save方法进行注册
            bu.signUp(new SaveListener<MyUser>() {
                @Override
                public void done(MyUser s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(ZC.this, "注册成功:" + s.toString(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ZC.this, "注册失败:邮箱已被注册", Toast.LENGTH_SHORT).show();
                        Log.d("TAG_", "注册失败：" + e);
                    }
                }
            });
        } else {
            Toast.makeText(ZC.this, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 正则表达式校验邮箱
     *
     * @param emaile 待匹配的邮箱
     * @return 匹配成功返回true 否则返回false;
     */
    private static boolean checkEmaile(String emaile) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(emaile);
        //进行正则匹配
        return m.matches();
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    @OnClick({R.id.zc_btn_zc, R.id.zc_btn_bc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zc_btn_zc:
                if (zcZh.getText().toString().equals("")){Toast.makeText(ZC.this, "请输入邮箱", Toast.LENGTH_SHORT).show();zcZh.requestFocus();}
                else if(zcPsw.getText().equals("")){Toast.makeText(ZC.this, "请输入密码", Toast.LENGTH_SHORT).show();zcPsw.requestFocus();}
                else{zhuc(zcZh.getText().toString(), zcPsw.getText().toString());}
                break;
            case R.id.zc_btn_bc:
                Toast.makeText(ZC.this, "返回", Toast.LENGTH_SHORT).show();
                /*进入注册页面*/
                finish();
                break;
        }
    }
}
