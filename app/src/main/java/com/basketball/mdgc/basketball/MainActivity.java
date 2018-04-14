package com.basketball.mdgc.basketball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager navigationTabBarPager = findViewById(R.id.navigation_tab_bar_view_pager_main);
        navigationTabBarPager.setAdapter(
                new PagerAdapter() {
                    @Override
                    public int getCount() {
                        return 5;
                    }

                    @Override
                    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                        return view.equals(object);
                    }

                    @Override
                    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                        container.removeView((View) object);
                    }

                    @Override
                    public Object instantiateItem(final ViewGroup container, final int position) {
                        final View view = LayoutInflater.from(
                                getBaseContext()).inflate(R.layout.welcome_fragment, null, false);

                        final TextView txtPage = (TextView) view.findViewById(R.id.welcome_text_view);
                        txtPage.setText(String.format("Page #%d", position));

                        container.addView(view);
                        return view;
                    }
                }

        );

        //nav tab bar icons; from left to right
        ArrayList<Integer> icons = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            icons.add(android.R.drawable.star_on);

        //nav tab bar colors; from left to right
        ArrayList<Integer> colors = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            colors.add(Color.argb(0, 200, 50, 30));
        final NavigationTabBar navigationTabBar = findViewById(R.id.navigation_tab_bar_main);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(0)),
                        colors.get(0)
                ).title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(1)),
                        colors.get(1)
                ).title("Cup")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(2)),
                        colors.get(2)
                ).title("Diploma")
                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(3)),
                        colors.get(3)
                ).title("Flag")
                        .badgeTitle("icon")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(icons.get(4)),
                        colors.get(4)
                ).title("Medal")
                        .badgeTitle("777")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(navigationTabBarPager, 2);

        navigationTabBar.setTitleMode(NavigationTabBar.TitleMode.ACTIVE);
        navigationTabBar.setBadgeGravity(NavigationTabBar.BadgeGravity.BOTTOM);
        navigationTabBar.setBadgePosition(NavigationTabBar.BadgePosition.CENTER);
        navigationTabBar.setTypeface("fonts/custom_font.ttf");
        navigationTabBar.setIsBadged(true);
        navigationTabBar.setIsTitled(true);
        navigationTabBar.setIsTinted(true);
        navigationTabBar.setIsBadgeUseTypeface(true);
        navigationTabBar.setBadgeBgColor(Color.RED);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);
        navigationTabBar.setIsSwiped(true);
        navigationTabBar.setBgColor(Color.BLACK);
        navigationTabBar.setBadgeSize(20);
        navigationTabBar.setTitleSize(20);
        navigationTabBar.setIconSizeFraction(0.5f);

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
