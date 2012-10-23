package main.loadingfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ViewAnimator;

public abstract class LoadingFragment extends Fragment{
    
    private              ViewAnimator mViewAnimator = null;
    private static final int	      LOADING 	    = 0;
    private static final int 	      SHOW 	    = 1;
    
    public abstract View onCreateMainView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    public abstract int  setInAnimation  (									 );
    public abstract int  setOutAnimation (								         );
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	View view = inflater.inflate(R.layout.loading_fragment_layout, null);
	
	mViewAnimator = (ViewAnimator) view.findViewById(R.id.animator);
	mViewAnimator.setInAnimation(AnimationUtils.loadAnimation(getActivity(), setInAnimation()));
	mViewAnimator.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), setOutAnimation()));
	
	FrameLayout mainViewContainer = (FrameLayout) view.findViewById(R.id.container);
	mainViewContainer.addView(onCreateMainView(inflater, container, savedInstanceState));
	
	return view;
    }
    
    public void showContent(){
	mViewAnimator.setDisplayedChild(SHOW);
    }
    public void showLoading(){
	mViewAnimator.setDisplayedChild(LOADING);
    }
}