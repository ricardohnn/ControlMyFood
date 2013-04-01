package com.example.controlmyfood.activities;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.controlmyfood.R;
import com.example.controlmyfood.adapters.GridItemAdapter;
import com.example.controlmyfood.controller.FoodController;
import com.example.controlmyfood.vo.FoodBean;

public class PantryFragment extends Fragment {

	private Context context;
	private GridView gridView;
	private List<FoodBean> foods;
	private FoodController foodController;
	private GridItemAdapter gridAdapter;
	private BroadcastReceiver broadcastReceiver;
	private View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO EXISTIA ALGO QUE DEVIA SER FEITO PARA USAR O GETACTIVITY()
		context = getActivity();

		broadcastReceiver = new FragmentReceiver1();
		getActivity().registerReceiver(broadcastReceiver,
				new IntentFilter("fragmentupdater"));
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.grid_activity, container, false);

		foodController = new FoodController();
		foods = foodController.loadAllFoods(context, "pantry");

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		gridView = (GridView) view.findViewById(R.id.gridView);
		gridAdapter = new GridItemAdapter(context, foods);
		gridView.setAdapter(gridAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Intent intent = new Intent(context, InsertFoodActivity.class);
				FoodBean foodItem = (FoodBean) foods.get(position);
				intent.putExtra("showFood", foodItem);
				startActivity(intent);

				Log.d("ControlMyFood", "I ve got the " + foodItem.getFoodName()
						+ " id " + foodItem.getId().toString());

			}
		});
	}

	public Void changeContentsInGrid() {
		foods = foodController.loadAllFoods(context, "pantry");
		gridView.invalidateViews();
		gridAdapter.notifyDataSetChanged();
		gridView.setAdapter(gridAdapter);
		return null;
	}

	public class FragmentReceiver1 extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d("ControlMyFood", "Got Broadcast");
			changeContentsInGrid();
		}
	}

	@Override
	public void onDestroy() {
		getActivity().unregisterReceiver(broadcastReceiver);
		super.onDestroy();
	}

}
