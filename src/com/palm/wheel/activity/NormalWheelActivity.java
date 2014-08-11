package com.palm.wheel.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.palm.wheel.R;
import com.palm.wheel.adapter.AbstractWheelTextAdapter;
import com.palm.wheel.view.OnWheelChangedListener;
import com.palm.wheel.view.OnWheelScrollListener;
import com.palm.wheel.view.WheelView;

/**
 * 普通wheel使用
 * 
 * @author weixiang.qin
 * 
 */
public class NormalWheelActivity extends Activity {
	private WheelView wheelView;
	private TextView selectItemTv;
	private boolean scrolling = false;
	private ArrayList<String> datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wheel_normal);
		wheelView = (WheelView) findViewById(R.id.wheel_view);
		selectItemTv = (TextView) findViewById(R.id.select_item_tv);
		datasource = new ArrayList<String>();
		datasource.add("1期");
		datasource.add("2期");
		datasource.add("3期");
		datasource.add("4期");
		datasource.add("5期");
		datasource.add("6期");
		datasource.add("7期");
		datasource.add("8期");
		datasource.add("9期");
		datasource.add("10期");
		wheelView.setViewAdapter(new WheelViewAdapter(this, datasource));
		wheelView.setCurrentItem(2);// 当前item,在setViewAdapter之后设置
		wheelView.setVisibleItems(5);// 显示几个item
		wheelView.setCyclic(true);// 是否循环
		wheelView.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!scrolling) {
					showCurrentItem();
				}
			}
		});
		wheelView.addScrollingListener(new OnWheelScrollListener() {
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}

			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				showCurrentItem();
			}
		});
	}

	private void showCurrentItem() {
		int item = wheelView.getCurrentItem();
		selectItemTv.setText(String.valueOf(item));
	}

	class WheelViewAdapter extends AbstractWheelTextAdapter {
		private ArrayList<String> datasource;

		protected WheelViewAdapter(Context context, ArrayList<String> datasource) {
			super(context);
			this.datasource = datasource;
		}

		@Override
		public int getItemsCount() {
			return datasource.size();
		}

		@Override
		protected CharSequence getItemText(int index) {
			return datasource.get(index);
		}

	}
}
