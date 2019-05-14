package com.sajjadafridi58.navigationappca;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.sajjadafridi58.explorer.*;
public class MainActivity extends AppCompatActivity {

	private String[] mOptionMenu;
	private DrawerLayout mDrawerLayout;
	private RelativeLayout mDrawerRelativeLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
	private CharSequence mTitleSection;
	private CharSequence mTitleApp;
	private Fragment mFragment = null;
    public ActionBar actionBar;
    TextView tv;
    EditText ed;

    public void exitDialog()
    {new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Closing Applications")
            .setMessage("Are you sure you want to close Application?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            })
            .setNegativeButton("No", null)
            .show();

    }


    @Override
    public void onBackPressed() {
        exitDialog();

        boolean doubleBackToExitPressedOnce = false;

            /*if (doubleBackToExitPressedOnce) {
                super.Pressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);*/

    }

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();


        ed= (EditText) findViewById(R.id.usertext);
        // Create a TextView programmatically.
        tv = new TextView(getApplicationContext());
        mTitleApp="Main Menu";
        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        // Center align the ActionBar title
        tv.setGravity(Gravity.LEFT);
        tv.setPadding(5, 5, 5, 5);
        // Set the serif font for TextView text
        // This will change ActionBar title text font
        tv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        // Set the ActionBar title font size
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        tv.setText(mTitleApp);
        // Finally, set the newly created TextView as ActionBar custom view
        actionBar.setCustomView(tv);

        getSupportActionBar().setDisplayOptions(
                getSupportActionBar().DISPLAY_SHOW_CUSTOM |
                        getSupportActionBar().DISPLAY_HOME_AS_UP |
                        getSupportActionBar().DISPLAY_SHOW_TITLE |
                        getSupportActionBar().DISPLAY_SHOW_HOME|
                        getSupportActionBar().DISPLAY_USE_LOGO);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5B6FC8")));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_lst);

		mOptionMenu = new String[] { getString(R.string.first_fragment),
				getString(R.string.second_fragment),
				getString(R.string.third_fragment),getString(R.string.forth_fragment) };
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
		mDrawerList = (ListView) findViewById(R.id.list_view_drawer);
        navDrawerItems = new ArrayList<NavDrawerItem>();

        navDrawerItems.add(new NavDrawerItem(mOptionMenu[0], R.drawable.write));
        //for hearing
        navDrawerItems.add(new NavDrawerItem(mOptionMenu[1], R.drawable.speak));
        //for handwriting
        navDrawerItems.add(new NavDrawerItem(mOptionMenu[2], R.drawable.map));
        //fro google Map
        navDrawerItems.add(new NavDrawerItem(mOptionMenu[3], R.drawable.explore));
        // Recycle the typed array
        /*mDrawerList.setAdapter(new ArrayAdapter<String>(actionBar
                .getThemedContext(), android.R.layout.simple_list_item_1,
                mOptionMenu));*/

        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);


        //for the first time
		initContentWithFirstFragment();
        mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        mFragment = new WriteTranslatorClass();
                        break;
                    case 1:
                        mFragment = new SpeakTranslatorClass();
                        break;
                    case 2:
                        mFragment = new GoogleActivity();
                        break;
                    case 3:
                        mFragment = new ExplorerMainActivity();
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, mFragment).commit();

                mDrawerList.setItemChecked(position, true);

                mTitleSection = mOptionMenu[position];
                setActionBarTitle(mTitleSection);
                mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
            }
        });
		mDrawerList.setItemChecked(0, true);
		mTitleSection = getString(R.string.first_fragment);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				setActionBarTitle(mTitleSection);
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}

			public void onDrawerOpened(View drawerView) {
                drawerView.requestFocus();
                getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                );
                View view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                setActionBarTitle(mTitleApp);

				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT)
					.show();
			;
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

    @Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public void initContentWithFirstFragment(){
		mTitleSection =getString(R.string.first_fragment);
        setActionBarTitle(mTitleSection);
		mFragment= new WriteTranslatorClass();
		FragmentManager fragmentManager = getSupportFragmentManager();

		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, mFragment).commit();
	}
    public void setActionBarTitle(CharSequence title){
        mTitleSection = title;
        tv.setText(mTitleSection);
        actionBar.setCustomView(tv);
    }
}