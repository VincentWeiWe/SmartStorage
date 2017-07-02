/**
 * @ClassName: MainActivity 
 * @Description: TODO 
 * @author 
 * @date 2017年7月2日 上午11:22:49 
 */

package android_serialport_api.demo;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android_serialport_api.demo.R;


public class MainActivity extends SerialPortActivity {					
	private TextView textshidu; 
	private TextView textwendu;
	private TextView textyanwu;
	private TextView textguangzhao;
	private ProgressBar ProgressBarshidu;
	private ProgressBar ProgressBarwendu;
	private ProgressBar ProgressBaryanwu;
	private RatingBar RatingBarguangzhao;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect view with name
        getWindow().setBackgroundDrawableResource(R.drawable.bg_shidu);//set the main background
        
        textshidu=(TextView)findViewById(R.id.textshidu);
        ProgressBarshidu=(ProgressBar)findViewById(R.id.progress_horizontal_shidu);
        textwendu=(TextView)findViewById(R.id.textwendu);
        ProgressBarwendu=(ProgressBar)findViewById(R.id.progress_horizontal_wendu);
        textyanwu=(TextView)findViewById(R.id.textyanwu);
        ProgressBaryanwu=(ProgressBar)findViewById(R.id.progress_horizontal_yanwu);
        textguangzhao=(TextView)findViewById(R.id.textguangzhao);
        
        RatingBarguangzhao=(RatingBar)findViewById(R.id.progress_horizontal_guangzhao);

    }
 



    
    /* (non-Javadoc)
     * @see android_serialport_api.demo.SerialPortActivity#onDataReceived(java.lang.String)
     */
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
						&& message.charAt(message.length()-1)=='#')
				{
					System.out.println("the format of data is true");
					sub = message.substring(3, message.length()-1);//select the part of data
					d = Integer.parseInt(sub);
					//Humidity
					if(message.charAt(1)=='0')
					{
						System.out.println("shidu = "+ sub + "%RH");
						textshidu.setText("湿度： "+sub + "%RH");
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
					if(message.charAt(1)=='1')
					{
						System.out.println("wendu = "+ sub +" °C");
						textwendu.setText("温度： "+sub + " °C");
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
					if(message.charAt(1)=='3')
					{
						System.out.println("yanwu = "+ sub);
						textyanwu.setText("烟雾： "+sub + "PM");
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
					if(message.charAt(1)=='2')
					{
						if(sub.equals("1")){
							System.out.println("have light");
							textguangzhao.setText("光照： YES");
							RatingBarguangzhao.setRating(3);
							
						}
						if(sub.equals("0")){
							System.out.println("no light");
							textguangzhao.setText("光照： NO");
							RatingBarguangzhao.setRating(0);
						}
						//*******ø…¿©’π**********
					}
					
				}
				else{
					//if the format of data is not true(I don't know what to do )
				}
				
			}
			
		});
		
    }
    
}







