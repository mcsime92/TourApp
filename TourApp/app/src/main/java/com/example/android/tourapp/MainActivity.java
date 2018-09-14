package com.example.android.tourapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawer;
    ActionBarDrawerToggle actionBarDrawerToggle;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);

        mDrawer.addDrawerListener(actionBarDrawerToggle);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        String title = "";
        Class fragmentClass;

        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = EatFragment.class;
                title = getString(com.example.android.tourapp.R.string.catg_drawer1);
                getSupportActionBar().setTitle(title);
                break;
            case R.id.nav_second_fragment:
                fragmentClass = DrinkFragment.class;
                title = getString(com.example.android.tourapp.R.string.catg_drawer2);
                getSupportActionBar().setTitle(title);
                break;
            case R.id.nav_third_fragment:
                fragmentClass = DanceFragment.class;
                title = getString(R.string.catg_drawer3);
                getSupportActionBar().setTitle(title);
                break;
            case R.id.nav_fourth_fragment:
                fragmentClass = OhReallyFragment.class;
                title = getString(R.string.catg_drawer4);
                getSupportActionBar().setTitle(title);
                break;

            default:
                fragmentClass = MainActivity.class;
                title = getString(R.string.catg_drawer_default);
                getSupportActionBar().setTitle(title);
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);

        // Close the navigation drawer
        mDrawer.closeDrawers();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
