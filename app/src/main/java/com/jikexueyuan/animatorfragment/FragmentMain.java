package com.jikexueyuan.animatorfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 默认显示的fragment
 */
public class FragmentMain extends Fragment implements View.OnClickListener {

    //主布局
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //解析布局 fragment_main
        root = inflater.inflate(R.layout.fragment_main, container, false);

        //查找按钮 设置监听
        root.findViewById(R.id.btnShowAnotherFragment).setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnShowAnotherFragment:
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(
                                R.animator.flip_enter,//第二个fragment进入要执行动画
                                R.animator.flip_exit, //第一个fragmenttui退出动画
                                R.animator.flip_pop_enter,//第一个fragment进入动画
                                R.animator.flip_pop_exit //第二个fragment退出动画
                        )
                        .replace(R.id.fragment,new AnotherFragment())
                        .commit();
                break;
        }
    }
}
