package com.palm.wheel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.palm.wheel.R;
import com.palm.wheel.adapter.NumericWheelAdapter;
import com.palm.wheel.view.WheelView;

/**
 * 数字wheel使用
 * 
 * @author weixiang.qin
 * 
 */
public class NumericWheelActivity extends Activity implements OnClickListener {
	private WheelView wheelView;
	private Button selectItemBtn;
	private TextView selectItemTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wheel_numeric);
		wheelView = (WheelView) findViewById(R.id.wheel_view);
		selectItemBtn = (Button) findViewById(R.id.select_item_btn);
		selectItemTv = (TextView) findViewById(R.id.select_item_tv);
		// 01-59
		/* wheel_view.setViewAdapter(new NumericWheelAdapter(this, 0, 59, "%02d")); */
		// 1-99
		wheelView.setViewAdapter(new NumericWheelAdapter(this, 1, 99));
		wheelView.setCurrentItem(0);
		wheelView.setVisibleItems(5);
		wheelView.setCyclic(true);
		selectItemBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int item = wheelView.getCurrentItem();
		selectItemTv.setText(String.valueOf(item));
	}
}
