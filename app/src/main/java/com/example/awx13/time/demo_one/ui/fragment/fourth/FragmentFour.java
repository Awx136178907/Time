package com.example.awx13.time.demo_one.ui.fragment.fourth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.awx13.time.R;
import com.example.awx13.time.demo_one.DR;
import com.example.awx13.time.demo_one.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;

/**
 * 作者：yaochangliang on 2016/8/14 08:18
 * 邮箱：yaochangliang159@sina.com
 */
public class FragmentFour extends Fragment {
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.gr_tx)
    RelativeLayout grTx;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.gr_nc)
    RelativeLayout grNc;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.gr_qm)
    RelativeLayout grQm;
    @BindView(R.id.gr_yx)
    RelativeLayout grYx;
    @BindView(R.id.gr_sc)
    RelativeLayout grSc;
    @BindView(R.id.gr_xg)
    RelativeLayout grXg;
    @BindView(R.id.gr_tc)
    RelativeLayout grTc;
    @BindView(R.id.textView)
    TextView textView;
    Unbinder unbinder;

    public static FragmentFour newInstance(String text) {
        FragmentFour fragmentCommon = new FragmentFour();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("text"));
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.gr_tx, R.id.gr_nc, R.id.gr_qm, R.id.gr_yx, R.id.gr_sc, R.id.gr_xg, R.id.gr_tc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gr_tx:
                break;
            case R.id.gr_nc:
                break;
            case R.id.gr_qm:
                break;
            case R.id.gr_yx:
                break;
            case R.id.gr_sc:
                break;
            case R.id.gr_xg:
                break;
            case R.id.gr_tc: BmobUser.logOut();
                                //清除缓存用户对象
                startActivity(new Intent(getActivity(),DR.class));
        }
    }
}
