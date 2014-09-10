package com.example.sectionedlistview;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView listview;
	Adapter adapter;
	Context context;
	String[] listview_menu_items={"Start","Search Profiles","Favourites","Messages","Visits","Events","Blogs","My Profile","Edit Profile","Edit Profile Photo","My Events","User Guide","Log Out","Terms of services","Prices"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listView1);
		context=this;
		adapter=new Adapter(this);
		adapter.addSeparatorItem("Go to..");
		for (int i = 0; i <= 14; i++) {

			if (i==6) {
				adapter.addSeparatorItem("Profile");
			}
			if (i==11) {
				adapter.addSeparatorItem("Support");
			}
			if (i==13) {
				adapter.addSeparatorItem("Subscription");
			}
			adapter.addItem(listview_menu_items[i]);
		}
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				onMenuItemClick(parent, view, position, id);
				listview.smoothScrollToPosition(0);
			}
		});
	}
	private void onMenuItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		String selectedItem = adapter.mItems.get(position);
		if (selectedItem.compareTo("Start") == 0) 
		{
			Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
		} 
		else if (selectedItem.compareTo("Search Profiles") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Favourites") == 0)
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Messages") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Visits") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Events") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Blogs") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("My Profile") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
		else if (selectedItem.compareTo("Edit Profile") == 0) 
		{
			Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_SHORT).show();
		}
	}
}
