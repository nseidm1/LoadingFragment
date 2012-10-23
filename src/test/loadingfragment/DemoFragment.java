package test.loadingfragment;

import main.loadingfragment.LoadingFragment;
import main.loadingfragment.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class DemoFragment extends LoadingFragment implements OnClickListener{
    
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private WebView mWebView = null;
    private Button  mReload  = null;
    private boolean mLoading = false;
    public static DemoFragment newInstance(){
	return new DemoFragment();
    }
    @Override
    public View onCreateMainView(LayoutInflater inflater, 
	    			 ViewGroup      container, 
	    			 Bundle 	savedInstanceState){
	View view = inflater.inflate(R.layout.demo_fragment, null);
	mWebView  = (WebView) view.findViewById(R.id.web_view);
	mReload   = (Button) view.findViewById(R.id.reload);
	mReload.setOnClickListener(this);
	return view;
    }
    @Override
    public void onActivityCreated(Bundle bundle){
	super.onActivityCreated(bundle);
	mWebView.loadUrl("http://m.google.com");
	mLoading = true;
	mWebView.setWebViewClient(new WebViewClient(){
	    @Override
	    public void onPageFinished(WebView view, String url){
		super.onPageFinished(view, url);
		mHandler.postDelayed(new Runnable(){
		    @Override
		    public void run(){
			mLoading = false;
			DemoFragment.this.showContent();
		    }
		}, 500);
	    }
	});
    }
    @Override
    public int setInAnimation(){
	return R.anim.fade_in;
    }
    @Override
    public int setOutAnimation(){
	return R.anim.fade_out;
    }
    @Override
    public void onClick(View v){
	int id = v.getId();
	if (id == R.id.reload){
	    if (!mLoading){
		mLoading = true;
		showLoading();
		mHandler.postDelayed(new Runnable(){
		    @Override
		    public void run(){
			mWebView.loadUrl("http://m.google.com");
		    }
		}, 500);
	    }
	}
    }
}