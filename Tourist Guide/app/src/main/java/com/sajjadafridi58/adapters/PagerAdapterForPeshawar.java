package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;
import com.sajjadafridi58.kpkfragment.peshawar.Peshawar1;
import com.sajjadafridi58.kpkfragment.peshawar.Peshawar2;
import com.sajjadafridi58.kpkfragment.peshawar.Peshawar3;
import com.sajjadafridi58.kpkfragment.peshawar.Peshawar4;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForPeshawar extends FragmentStatePagerAdapter {
    public PagerAdapterForPeshawar(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Peshawar1();
                break;
            case 1:
                fragment = new Peshawar2();
                break;
            case 2:
                fragment = new Peshawar3();
                break;
            case 3:
                fragment = new Peshawar4();
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
