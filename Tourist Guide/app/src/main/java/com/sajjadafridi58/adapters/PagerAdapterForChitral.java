package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage1;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage2;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage3;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage4;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForChitral extends FragmentStatePagerAdapter {
    public PagerAdapterForChitral(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ChaPage1();
                break;
            case 1:
                fragment = new ChaPage2();
                break;
            case 2:
                fragment =new ChaPage3();
                break;
            case 3:
                fragment =new ChaPage4();
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
