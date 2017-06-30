package ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android_serialport_api.demo.R;
import base.BaseFragment;

public class StorageInfoFragment extends BaseFragment{

	private TextView textshidu;
	private TextView textwendu;
	private TextView textyanwu;
	private ProgressBar ProgressBarshidu;
	private ProgressBar ProgressBarwendu;
	private ProgressBar ProgressBaryanwu;
	@Override
	public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_storage_info, null);
		textshidu = (TextView)view.findViewById(R.id.textshidu);
        textwendu=(TextView)view.findViewById(R.id.textwendu);
        textyanwu=(TextView)view.findViewById(R.id.textyanwu);
        ProgressBarshidu=(ProgressBar)view.findViewById(R.id.progress_horizontal_shidu);
        ProgressBarwendu=(ProgressBar)view.findViewById(R.id.progress_horizontal_wendu);
        ProgressBaryanwu=(ProgressBar)view.findViewById(R.id.progress_horizontal_yanwu);
		return view;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	
			default:
				break;
		}
	}

}
