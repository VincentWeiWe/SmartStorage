package ui;

import android_serialport_api.demo.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MainPagerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import base.BaseActivity;

public class testActivity extends BaseActivity{
	private ViewPager viewPager;
	private TextView tv_tab_info; 
	private TextView tv_tab_setting; 
	private TextView tv_tab_goods; 
	
	private LinearLayout ll_tab_info;
	private LinearLayout ll_tab_setting;
	private LinearLayout ll_tab_goods;
	
	private TextView textshidu;
	private TextView textwendu;
	private TextView textyanwu;
	private ProgressBar ProgressBarshidu;
	private ProgressBar ProgressBarwendu;
	private ProgressBar ProgressBaryanwu;
	
	private View infoView;
	
	private List<Fragment> fragments;
	private MainPagerAdapter adapter;
	@Override
	public void initView() {
		setContentView(R.layout.activity_test);
		
		getWindow().setBackgroundDrawableResource(R.drawable.bg_shidu);//set the main background
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		
		tv_tab_info = (TextView) findViewById(R.id.tv_tab_info);
		tv_tab_setting = (TextView) findViewById(R.id.tv_tab_setting);
		tv_tab_goods = (TextView) findViewById(R.id.tv_tab_goods);
		
		ll_tab_info = (LinearLayout) findViewById(R.id.ll_tab_info);
		ll_tab_setting = (LinearLayout) findViewById(R.id.ll_tab_setting);
		ll_tab_goods = (LinearLayout) findViewById(R.id.ll_tab_goods);
	}

	@Override
	public void initListener() {
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});
		ll_tab_info.setOnClickListener(this);
		ll_tab_setting.setOnClickListener(this);
		ll_tab_goods.setOnClickListener(this);
	}

	@Override
	public void initData() {
		fragments = new ArrayList<Fragment>();

		StorageInfoFragment fragment1 = new StorageInfoFragment();
		StorageGoodsFragment fragment2 = new StorageGoodsFragment();
		StorageSettingFragment fragment3 = new StorageSettingFragment();
		infoView = fragment1.getView();
		textshidu = (TextView)infoView.findViewById(R.id.textshidu);
        textwendu = (TextView)infoView.findViewById(R.id.textwendu);
        textyanwu = (TextView)infoView.findViewById(R.id.textyanwu);
        ProgressBarshidu = (ProgressBar)infoView.findViewById(R.id.progress_horizontal_shidu);
        ProgressBarwendu = (ProgressBar)infoView.findViewById(R.id.progress_horizontal_wendu);
        ProgressBaryanwu = (ProgressBar)infoView.findViewById(R.id.progress_horizontal_yanwu);
        
		fragments.add(fragment1);
		fragments.add(fragment2);
		fragments.add(fragment3);
		adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
		viewPager.setAdapter(adapter);
	}

	@Override
	public void processClick(View v) {
		switch (v.getId()) {
		case R.id.ll_tab_info:
			viewPager.setCurrentItem(0);
			break;
		case R.id.ll_tab_setting:
			viewPager.setCurrentItem(1);
			break;
		case R.id.ll_tab_goods:
			viewPager.setCurrentItem(2);
			break;
		default:
			break;

		}
		
	}

	@Override
	protected void onDataReceived(final String message) {
		runOnUiThread(new Runnable() {
			
			public void run() {
				String sub = null;
				int d = 0;
				System.out.println(message);
				System.out.println(message.length());
				if(message == "" || message == null)
					System.out.println("null");
			    //judge the format of data is true or not
				if( message.length()!= 0 && message.charAt(0)=='$' && message.charAt(2)==','
						&& message.charAt(message.length()-1)=='#') {
					System.out.println("the format of data is true");
					sub = message.substring(3, message.length()-1);//select the part of data
					d = Integer.parseInt(sub);
					//Humidity
					if(message.charAt(1)=='0') {
						System.out.println("shidu = "+ sub + "%RH");
						textshidu.setText(" ʪ�ȣ� "+sub + "%RH");
						if(d>45)//the warning value(you can change it depend on situation)
						{
							Drawable dr=getResources().getDrawable(R.drawable.barcolor);
							ProgressBarshidu.setProgressDrawable(dr);
						}
						else
						{
							Drawable dr=getResources().getDrawable(R.drawable.nocolor);
							ProgressBarshidu.setProgressDrawable(dr);
						}
						//change the bar according to the value of data
						ProgressBarshidu.setProgress((int) d);
					}
					
					//Temperature
					if(message.charAt(1)=='1') {
						System.out.println("wendu = "+ sub +" ��C");
						textwendu.setText(" �¶ȣ� "+sub + " ��C");
						if(d>40)//the warning value(you can change it depend on situation)
						{
							Drawable dr=getResources().getDrawable(R.drawable.barcolor);
							ProgressBarwendu.setProgressDrawable(dr);
						}
						else
						{
							Drawable dr=getResources().getDrawable(R.drawable.nocolor);
							ProgressBarwendu.setProgressDrawable(dr);
						}
						//change the bar according to the value of data
						ProgressBarwendu.setProgress((int) d);
						
					}
					//Smoke
					if(message.charAt(1)=='3') {
						System.out.println("yanwu = "+ sub);
						textyanwu.setText(" ������ "+sub + "PM");
						if(d>30000)//the warning value(you can change it depend on situation)
						{
							Drawable dr=getResources().getDrawable(R.drawable.barcolor);
							ProgressBaryanwu.setProgressDrawable(dr);
						}
						else
						{
							Drawable dr=getResources().getDrawable(R.drawable.nocolor);
							ProgressBaryanwu.setProgressDrawable(dr);
						}
						//change the bar according to the value of data
						ProgressBaryanwu.setProgress((int) d);
					}
					//Light
					if(message.charAt(1)=='2') {

					}
					
				}
				else{
					//if the format of data is not true(I don't know what to do )
				}
				
			}
			
		});
		
    }

}
