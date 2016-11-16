package com.example.sky019_tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpaget;
    private TabLayout tabLayout;
    String[] titles = {
            "美女",
            "数码",
            "本地",
            "数码",
            "深圳"
    };

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //1 初始化shuju
        initData();
        //2 设置适配器
        viewpaget.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
            // 4. 设置标题
            @Override
            public CharSequence getPageTitle(int position) {return titles[position];
            }
        });
        //3 联动
        tabLayout.setupWithViewPager(viewpaget);
        //4 设置标签
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            tabLayout.getTabAt(i).setText("第" + i + "页");
//        }
    }
    private void initData() {
        fragments = new Fragment[titles.length];
        //循环遍历标题创建新的Fragment填充数组
        for (int i = 0; i < titles.length; i++) {
            ContentFragment contentFragment = new ContentFragment();
            fragments[i] = contentFragment;
            Bundle bundle = new Bundle();
            bundle.putString("key", titles[i]);
            fragments[i].setArguments(bundle);
        }
    }

    private void initView() {
        viewpaget = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }
}
