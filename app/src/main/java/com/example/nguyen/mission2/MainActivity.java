package com.example.nguyen.mission2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.nguyen.mission2.fragments.FragmentFour;
import com.example.nguyen.mission2.fragments.FragmentOne;
import com.example.nguyen.mission2.fragments.FragmentThree;
import com.example.nguyen.mission2.fragments.FragmentTwo;
import com.example.nguyen.mission2.models.MoveTo;
import com.example.nguyen.mission2.network.BackStack;
import com.example.nguyen.mission2.network.IBackPress;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);

        setTabLayout();

        //select tab default
        selectTabDefault();

//        setSizeIcon();

    }

    private void setTabLayout() {
        TabLayout.Tab tabHome = tabLayout.newTab();
        tabHome.setText("Tab 1").setIcon(R.drawable.ic_home_24);

        TabLayout.Tab tabNetWork = tabLayout.newTab();
        tabNetWork.setText("Tab 2").setIcon(R.drawable.ic_globe_24);

        TabLayout.Tab tabBookPhone = tabLayout.newTab();
        tabBookPhone.setText("Tab 3").setIcon(R.drawable.ic_phone_book);

        TabLayout.Tab tabUser = tabLayout.newTab();
        tabUser.setText("Tab 4").setIcon(R.drawable.ic_user_24);

//        tabLayout.getTabAt(0).getIcon().getIntrinsicHeight();

        tabLayout.addTab(tabHome);
        tabLayout.addTab(tabNetWork);
        tabLayout.addTab(tabBookPhone);
        tabLayout.addTab(tabUser);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch (position) {
                    case 0:
                        FragmentOne one = new FragmentOne();
                        loadFragment(one);
                        break;
                    case 1:
                        FragmentTwo two = new FragmentTwo();
                        loadFragment(two);
                        break;
                    case 2:
                        FragmentThree three = new FragmentThree();
                        loadFragment(three);
                        break;
                    case 3:
                        FragmentFour four = new FragmentFour();
                        loadFragment(four);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setSizeIcon() {
        int countTab = tabLayout.getTabCount();

        for(int i = 0; i < countTab ; i ++)
        {
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(35, 35);
//            params.gravity = Gravity.CENTER;
//            tabLayout.getChildAt(i).setLayoutParams(params);
        }
    }

    private void selectTabDefault() {
        loadFragment(new FragmentOne());
    }

    private void loadFragment(Fragment fragment) {
        MoveTo.nextFragment(getSupportFragmentManager(),fragment,R.id.frame_main, BackStack.WITHOUT_BACK_STACK);
    }

    @Override
    public void onBackPressed() {
        tabLayout.setVisibility(View.VISIBLE);

        Fragment current = getSupportFragmentManager().findFragmentById(R.id.frame_main);

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count > 0) {

            if (current instanceof FragmentOne) {
                finish();
            } else if (current instanceof FragmentTwo) {
                finish();
            } else if (current instanceof FragmentThree) {
                finish();
            } else if (current instanceof FragmentFour) {
                finish();
            } else {
                super.onBackPressed();
            }

        } else {
            finish();
        }
    }
}
