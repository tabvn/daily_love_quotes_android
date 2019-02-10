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

    GridFragment gridFragment;
    GridFragment favoriteFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.navigation_home:


                    if (gridFragment == null) {
                        gridFragment = new GridFragment();
                    }
                    gridFragment.filter = new Filter("category", "new");
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameContainer, gridFragment).commit();


                    break;


                case R.id.navigation_favorites:

                    if (favoriteFragment == null) {
                        favoriteFragment = new GridFragment();
                    }
                    favoriteFragment.filter = new Filter("category", "favorites");
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameContainer, favoriteFragment).commit();

                    break;

                case R.id.navigation_more:

                    if (favoriteFragment == null) {
                        favoriteFragment = new GridFragment();
                    }
                    favoriteFragment.filter = new Filter("category", "favorites");
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameContainer, favoriteFragment).commit();

                    break;
            }


            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        gridFragment = new GridFragment();
        gridFragment.filter = new Filter("category", "new");
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameContainer, gridFragment).commit();

    }

}
