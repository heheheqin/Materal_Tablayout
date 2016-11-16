package com.example.sky019_tablayout;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：Will on 2016/11/3 14:36
 * Mail：heheheqin.will@gmail.com
 */

public class ContentFragment extends ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取参数构建数组
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(key +i);
        }
        //初始化adapter
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        //设置adapter
        setListAdapter(stringArrayAdapter);
    }
}
