package com.jikexueyuan.animatorfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //使用的fragment布局
        setContentView(R.layout.fragment);

        //在FrameLayout布局中添加FragmentMain这个碎片
        getFragmentManager().beginTransaction().add(R.id.fragment,new FragmentMain()).commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }


    }
}
