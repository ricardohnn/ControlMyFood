package com.example.controlmyfood.activities;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class FridgeFragment extends Fragment {

	private Context context;
	private GridView gridView;
	private List<FoodBean> foods;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TODO EXISTIA ALGO QUE DEVIA SER FEITO PARA USAR O GETACTIVITY()
		context = getActivity();
		FoodController foodController = new FoodController();
		foods = foodController.loadAllFoods(context);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.grid_activity, container, false);

		gridView = (GridView) view.findViewById(R.id.gridView);
		gridView.setAdapter(new GridItemAdapter(context, foods));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
			}
		});
		return view;
	}
}
