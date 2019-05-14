package com.sajjadafridi58.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.sajjadafridi58.adapters.PagerAdapterForAstoro;
import com.sajjadafridi58.adapters.PagerAdapterForBwp;
import com.sajjadafridi58.navigationappca.R;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class BahawalpurActivity extends ActionBarActivity {

    ActionBar actionBar;
    ViewPager pager;
    FragmentActivity fragmentActivity;
    private android.support.v4.view.PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bwp_slider);// change
        actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP |
                ActionBar.DISPLAY_SHOW_TITLE |
                ActionBar.DISPLAY_SHOW_CUSTOM |
                ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setTitle("Bahawalpur City");
        pager = (ViewPager) super.findViewById(R.id.view_pager); // change
        initialisePaging();
    }


    private void initialisePaging() {
// change
        adapter = new PagerAdapterForBwp(getSupportFragmentManager());
        pager.setAdapter(this.adapter);

    }
    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.action_settings);
        item.setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }
}
