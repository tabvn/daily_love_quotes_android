package com.tabvn.dailylovequotes;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            Fragment selectedFragment = null;


            switch (item.getItemId()) {
                case R.id.navigation_home:

                    setTitle(R.string.app_name);
                    selectedFragment = new GridFragment();

                    ((GridFragment) selectedFragment).filter = new Filter("category", "new");

                    break;

                case R.id.navigation_favorites:

                    setTitle(R.string.my_favorites);
                    selectedFragment = new GridFragment();

                    break;

                case R.id.navigation_more:

                    setTitle(R.string.more);
                    selectedFragment = new GridFragment();

                    break;
            }



            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameContainer, selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
