package com.example.awx13.time.demo_one.ui.fragment.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awx13.time.R;

/**
 * 作者：yaochangliang on 2016/8/14 08:18
 * 邮箱：yaochangliang159@sina.com
 */
public class FragmentOne extends Fragment {
    TextView textView;

    public static FragmentOne newInstance(String text){
        FragmentOne fragmentCommon=new FragmentOne();
        Bundle bundle=new Bundle();
        bundle.putString("text",text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        textView= (TextView) view.findViewById(R.id.textView1);
        textView.setText(getArguments().getString("text"));
        return view;
    }
}
