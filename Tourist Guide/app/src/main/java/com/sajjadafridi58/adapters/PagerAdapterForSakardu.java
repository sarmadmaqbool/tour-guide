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

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForSakardu extends FragmentStatePagerAdapter {
    public PagerAdapterForSakardu(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new k2Region();
                break;
            case 1:
                fragment =new DeasoiPlains();
                break;
            case 2:
                fragment =new BaltotoKachura();
                break;
            case 3:
                fragment =new Broak_Peak();
                break;
            case 4:
                fragment =new GhasherBrum1();
                break;
            case 5:
                fragment =new GhasherBrum2();
                break;
            case 6:
                fragment =new GhondoChaqchanShyok();
                break;
            case 7:
                fragment =new KhapluShangrillaMasherbrum();
                break;

            case 8:
                fragment =new SnowBuddhistShigarfort();
                break;
            case 9:
                fragment =new UperkacColddes();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 10;
    }
}
