package com.example.awx13.time.demo_one.db;

import cn.bmob.v3.BmobUser;

/**
 * Created by Awx13 on 2016/12/7.
 */

public class MyUser extends BmobUser {

    private String nickname;
    private String signature;
    private String Head;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }
}

