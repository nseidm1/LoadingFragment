package main.loadingfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewAnimator;

public abstract class LoadingFragment extends Fragment{
    
    private              ViewAnimator mViewAnimator        = null;
    private              ImageView    mProgressBackground = null;
    private static final int	      LOADING 	           = 0;
    private static final int 	      SHOW 	           = 1;
    
    
    public abstract View onCreateMainView           (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public abstract void configureAnimator          (ViewAnimator   viewAnimator                                            );
    public abstract void configureProgressBackground(ImageView      progressBackground                                    );
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	View view = inflater.inflate(R.layout.loading_fragment_layout, null);
	mProgressBackground = (ImageView) view.findViewById(R.id.loading_fragment_progress_bar_background);
	configureProgressBackground(mProgressBackground);
	
	mViewAnimator = (ViewAnimator) view.findViewById(R.id.loading_fragment_animator_controller);
	configureAnimator(mViewAnimator);
	
	FrameLayout mainViewContainer = (FrameLayout) view.findViewById(R.id.loading_fragment_content_container);
	mainViewContainer.addView(onCreateMainView(inflater, container, savedInstanceState));
	
	return view;
    }

    public void showContent(){
	callCheck();
	mViewAnimator.setDisplayedChild(SHOW);
    }
    public void showLoading(){
	callCheck();
	mViewAnimator.setDisplayedChild(LOADING);
    }
    
    private void callCheck(){
	if (mViewAnimator == null)
	    throw new NullPointerException("Call this after onCreateMainView");
    }
}