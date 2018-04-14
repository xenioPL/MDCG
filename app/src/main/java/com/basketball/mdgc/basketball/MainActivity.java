package com.basketball.mdgc.basketball;

import android.graphics.Color;
import android.os.Bundle;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {

    final int BADGE_SIZE = 25;
    final int TITLE_SIZE = 34;
    final float ICON_SIZE_FRACTION = 0.6f;

    final int NUMBER_OF_TABS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), NUMBER_OF_TABS);

        ViewPager navigationTabBarPager = findViewById(R.id.navigation_tab_bar_view_pager_main);
        navigationTabBarPager.setAdapter(adapter);

        //nav tab bar icons; from left to right
        ArrayList<Integer> icons = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_TABS; i++)
            icons.add(android.R.drawable.star_big_on);

        //temporary
        Random random = new Random();

        //nav tab bar colors; from left to right
        ArrayList<Integer> colors = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_TABS; i++)
            colors.add(Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        final NavigationTabBar navigationTabBar = findViewById(R.id.navigation_tab_bar_main);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(0)),
                        colors.get(0)
                ).build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(1)),
                        colors.get(1)
                ).build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(2)),
                        colors.get(2)
                ).build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(3)),
                        colors.get(3)
                ).build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(4)),
                        colors.get(4)
                ).build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(navigationTabBarPager, 2);

        navigationTabBar.setTitleMode(NavigationTabBar.TitleMode.ACTIVE);
        navigationTabBar.setBadgeGravity(NavigationTabBar.BadgeGravity.BOTTOM);
        navigationTabBar.setBadgePosition(NavigationTabBar.BadgePosition.CENTER);
        //navigationTabBar.setTypeface("fonts/custom_font.ttf");
        navigationTabBar.setIsBadged(true);
        navigationTabBar.setIsTitled(false); //show title
        navigationTabBar.setIsTinted(false);
        //navigationTabBar.setIsBadgeUseTypeface(true);
        navigationTabBar.setBadgeBgColor(Color.RED);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);
        navigationTabBar.setIsSwiped(true);
        navigationTabBar.setBgColor(Color.DKGRAY);
        navigationTabBar.setBadgeSize(BADGE_SIZE);
        navigationTabBar.setTitleSize(TITLE_SIZE);
        navigationTabBar.setIconSizeFraction(ICON_SIZE_FRACTION);

    }

    public static class MyAdapter extends FragmentPagerAdapter {
        final int NUMBER_OF_TABS;

        public MyAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            NUMBER_OF_TABS = numberOfTabs;
        }
        @Override
        public int getCount() {
            return NUMBER_OF_TABS;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) return new SearchGameFragment();
            if(position == 1) return new RankingFragment();
            if(position == 2) return new SearchGameFragment();
            if(position == 3) return new SearchGameFragment();
            if(position == 4) return new SearchGameFragment();
            return null;
        }
        @Override
        public Parcelable saveState()
        {
            return null;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
