package main.loadingfragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewAnimator;

public abstract class LoadingFragment extends Fragment{
    
    private              ViewAnimator mViewAnimator          = null;
    private              ImageView    mProgressBarBackground = null;
    private static final int	      LOADING 	             = 0;
    private static final int 	      SHOW 	             = 1;
    
    
    public abstract View onCreateMainView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public abstract int  setInAnimation  (									 );
    public abstract int  setOutAnimation (								         );
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	View view = inflater.inflate(R.layout.loading_fragment_layout, null);
	mProgressBarBackground = (ImageView) view.findViewById(R.id.loading_fragment_progress_bar_background);
	
	mViewAnimator = (ViewAnimator) view.findViewById(R.id.loading_fragment_animator_controller);
	mViewAnimator.setInAnimation(AnimationUtils.loadAnimation(getActivity(), setInAnimation()));
	mViewAnimator.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), setOutAnimation()));
	
	FrameLayout mainViewContainer = (FrameLayout) view.findViewById(R.id.loading_fragment_content_container);
	mainViewContainer.addView(onCreateMainView(inflater, container, savedInstanceState));
	
	return view;
    }
    
    public void setProgressBackgroundImageBitmap(Bitmap image){
	callCheck();
	mProgressBarBackground.setImageBitmap(image);
    }
    
    public void setProgressBackgroundImageDrawable(Drawable drawable){
	callCheck();
	mProgressBarBackground.setImageDrawable(drawable);
    }
    
    public void setProgressBackgroundScaleType(ScaleType scaleType){
	callCheck();
	mProgressBarBackground.setScaleType(scaleType);
    }
    
    public void setProgressBackgroundAlpha(float alpha){
	callCheck();
	mProgressBarBackground.setAlpha(alpha);
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
	if (mProgressBarBackground == null)
	    throw new NullPointerException("Call this after onCreateMainView");
    }
}