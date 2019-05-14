package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;
import com.sajjadafridi58.kpkfragment.shangla.Shangla;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForShangla extends FragmentStatePagerAdapter {
    public PagerAdapterForShangla(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Shangla();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 1;
    }
}
