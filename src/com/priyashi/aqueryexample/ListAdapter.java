package com.priyashi.aqueryexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.androidquery.AQuery;

public class ListAdapter extends BaseAdapter{
	LayoutInflater inflater;
	Activity activity;
	String url1="http://farm6.static.flickr.com/5035/5802797131_a729dac808_s.jpg";
	String url2="http://www.queness.com/resources/images/png/apple_ex.png";
	String url3="http://img4.wikia.nocookie.net/__cb20110302225528/rift/images/7/7f/AWESOME_FACE!!!.png";
	public ListAdapter(Activity activity) {
		inflater = LayoutInflater.from(activity.getApplicationContext());
	  

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup container) {
		
		 View rootView = inflater.inflate( R.layout.list_item, container, false);
         
	        ImageView image = (ImageView) rootView.findViewById(R.id.imageView1);
	     
	        //Thease Two Line is sufficient my dear to implement lazyLoading.##########ic_launcher is placeholder image in below line
	        AQuery aq = new AQuery(rootView);
	        String url="";
	        if(arg0%3==0)
	        {
	        	url=url3;
	        }
	        else if (arg0%2==0) {
				url=url2;
			}
	        else{
	        	url=url1;
	        }
	        aq.id(image).image(url, true, true, 0, R.drawable.ic_launcher);
	        
	        //If u want to show progress bar untill your image does not load f rom server then add ProgressBar in your list_item layout and write this line ..............so simple
	      //  aq.id(image).progress(R.id.progress).image(url, true, true, 0, R.drawable.ic_launcher);
	     
	        
	     //   ################################# THESE two permission is required in Manifiest file
	       /* <uses-permission android:name="android.permission.INTERNET"/>
	        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>*/

	        return rootView;
	}

}
