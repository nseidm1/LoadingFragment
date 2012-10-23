package test.loadingfragment;

import main.loadingfragment.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class DemoActivity extends FragmentActivity{
    
    @Override
    public void onCreate(Bundle bundle){
	super.onCreate(bundle);
	setContentView(R.layout.demo_activity);
	//Add the DemoFragment programatically.
	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	ft.add(R.id.fragment_container, DemoFragment.newInstance(), DemoFragment.class.getName());
	ft.commit();
    }
}
