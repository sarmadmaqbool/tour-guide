package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage1;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage2;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage3;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage4;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForMansehra extends FragmentStatePagerAdapter {
    public PagerAdapterForMansehra(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MansPage1();
                break;
            case 1:
                fragment = new MansPage2();
                break;
            case 2:
                fragment = new MansPage3();
                break;
            case 3:
                fragment = new MansPage4();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 4;
    }
}
