package com.jcmore2.collagesample;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.jcmore2.collage.CollageView;

/**
 * Sample app
 * 
 * @see Juan Carlos Moreno (jcmore2@gmail.com)
 */
@SuppressLint("ResourceAsColor")
public class MainActivity extends Activity {

	RelativeLayout layoutCollage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		CollageView collage = (CollageView) findViewById(R.id.collage);
		layoutCollage = (RelativeLayout) findViewById(R.id.layoutCollage);

		List<Integer> listRes = new ArrayList<Integer>();
		listRes.add(R.drawable.img1);
		listRes.add(R.drawable.img2);
		listRes.add(R.drawable.img3);
		listRes.add(R.drawable.img4);
		collage.setFixedCollage(true);
		collage.createCollageResources(listRes);

		findViewById(R.id.random).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				createNewCollage();
			}
		});

	}

	public void createNewCollage() {

		layoutCollage.removeAllViews();

		CollageView collage = new CollageView(this);
		LayoutParams params = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params.setMargins(10, 10, 10, 10);
		collage.setLayoutParams(params);

		collage.setFixedCollage(false);
		collage.createCollageResources(createFakeList());

		layoutCollage.addView(collage);

	}

	private List<Integer> createFakeList() {

		List<Integer> listRes = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			listRes.add(R.drawable.img1);
			listRes.add(R.drawable.img2);
			listRes.add(R.drawable.img3);
			listRes.add(R.drawable.img4);
		}

		return listRes;
	}
}
