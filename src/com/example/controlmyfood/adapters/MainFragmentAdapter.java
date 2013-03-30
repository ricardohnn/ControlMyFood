package com.example.controlmyfood.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.controlmyfood.activities.FridgeFragment;

public class MainFragmentAdapter extends FragmentPagerAdapter {
	public MainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new FridgeFragment();
		case 1:
			return new FridgeFragment();
		case 2:
			return new FridgeFragment();

		default:
			return null;
		}
	}
}
