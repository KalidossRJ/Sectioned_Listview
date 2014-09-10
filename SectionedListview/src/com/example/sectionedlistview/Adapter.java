package com.example.sectionedlistview;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adapter extends BaseAdapter {
	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
	private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
	public static ArrayList<String> mItems = new ArrayList<String>();
	private LayoutInflater mInflater;
	int[] listview_images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	private TreeSet<Integer> mSeparatorsSet = new TreeSet<Integer>();
	public Adapter(MainActivity profileActivity) 
	{
		// TODO Auto-generated constructor stub
		mInflater = (LayoutInflater)profileActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mItems.clear();
		mSeparatorsSet.clear();

	}

	public void addItem(final String item) {
		mItems.add(item);
		notifyDataSetChanged();
		Log.d("mItems 1 = ", ""+mItems.size());
	}

	public void addSeparatorItem(final String item) {
		mItems.add(item);
		mSeparatorsSet.add(mItems.size() - 1);
		notifyDataSetChanged();
		Log.d("mItems 2 = ", ""+mItems.size());
		Log.d("mItems 3 = ", ""+mSeparatorsSet.size());
	}

	@Override
	public int getItemViewType(int position) {
		return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_MAX_COUNT;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public String getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int type = getItemViewType(position);
		System.out.println("getView " + position + " " + convertView + " type = " + type);
		if (convertView == null) {
			holder = new ViewHolder();
			switch (type) {
			case TYPE_ITEM:
				convertView = mInflater.inflate(R.layout.menuitems_adapter, null);
				holder.adapter_textview = (TextView)convertView.findViewById(R.id.listview_txtview);
				holder.adapter_imageview=(ImageView)convertView.findViewById(R.id.listview_imgview);
				break;
			case TYPE_SEPARATOR:
				convertView = mInflater.inflate(R.layout.menuitem_selectiontext, null);
				holder.adapter_textview = (TextView)convertView.findViewById(R.id.section_tv);
				break;
			}
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		if(type==0){
			holder.adapter_imageview.setBackgroundResource(listview_images[position]);
			holder.adapter_textview.setText(mItems.get(position));
			Log.d("TYPE ITEM", mItems.get(position));
			Log.d("TYPE", String.valueOf(type));
		}else{
			holder.adapter_textview.setText(mItems.get(position));
			Log.d("TYPE_SEPARATOR", mItems.get(position));
			Log.d("TYPE", String.valueOf(type));
		}

		return convertView;
	}
	public static class ViewHolder {
		public TextView adapter_textview;
		public ImageView adapter_imageview;

	}
}