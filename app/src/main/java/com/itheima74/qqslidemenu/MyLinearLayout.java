package com.itheima74.qqslidemenu;

import com.itheima74.qqslidemenu.SlideMenu.DragState;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 当slideMenu打开的时候，拦截并消费掉触摸事件
 * 
 * @author Administrator
 * 
 */
public class MyLinearLayout extends LinearLayout {
	public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLinearLayout(Context context) {
		super(context);
	}
	private SlideMenu slideMenu;
	public void setSlideMenu(SlideMenu slideMenu){
		this.slideMenu = slideMenu;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.d("@@@", "before onInterceptTouchEvent");
		Log.d("@@@", "SideMenu = " + slideMenu + " , state = " + slideMenu.getCurrentState());
		if(slideMenu != null && slideMenu.getCurrentState() == DragState.Open){
			Log.d("@@@", "onInterceptTouchEvent");
			//如果slideMenu打开则应该拦截并消费掉事件
			return true;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d("@@@", "before onTouchEvent");
		if(slideMenu != null && slideMenu.getCurrentState() == DragState.Open){
			if(event.getAction() == MotionEvent.ACTION_UP){
				//抬起则应该关闭slideMenu
				slideMenu.close();
			}

			Log.d("@@@", "onTouchEvent");
			//如果slideMenu打开则应该拦截并消费掉事件
			return true;
		}
		return super.onTouchEvent(event);
	}
}
