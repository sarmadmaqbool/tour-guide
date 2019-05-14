package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.gigitbaltistanfragment.sarkado.BaltotoKachura;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.Broak_Peak;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.DeasoiPlains;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.GhasherBrum1;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.GhasherBrum2;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.GhondoChaqchanShyok;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.KhapluShangrillaMasherbrum;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.SnowBuddhistShigarfort;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.UperkacColddes;
import com.sajjadafridi58.gigitbaltistanfragment.sarkado.k2Region;
import com.sajjadafridi58.kpkfragment.swat.Swat1;
import com.sajjadafridi58.kpkfragment.swat.Swat2;
import com.sajjadafridi58.kpkfragment.swat.Swat3;
import com.sajjadafridi58.kpkfragment.swat.Swat4;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForSwat extends FragmentStatePagerAdapter {
    public PagerAdapterForSwat(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Swat1();
                break;
            case 1:
                fragment =new Swat2();
                break;
            case 2:
                fragment =new Swat3();
                break;
            case 3:
                fragment =new Swat4();
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
