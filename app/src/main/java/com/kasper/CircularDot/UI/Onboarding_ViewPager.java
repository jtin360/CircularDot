package com.kasper.CircularDot.UI;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kasper.CircularDot.R;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Kasper on 5/18/17.
 */

public class Onboarding_ViewPager extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{
    private FancyButton getStarted_button;
    private ViewPager viewPager;
    private LinearLayout pager_indicator;
    private TextView signIn;
    private int dotsCount;
    private ImageView[] dots;
    private Onboarding_ViewPager_Adapter mAdapter;

    private int[] mImageResources = {
            R.mipmap.dog,
            R.mipmap.dog2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // To make activity full screen.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_viewpager);

        initalizeLayout();


    }


    public void initalizeLayout() {
        signIn = (TextView) findViewById(R.id.signIn);
        viewPager = (ViewPager) findViewById(R.id.pager_introduction);
        getStarted_button = (FancyButton) findViewById(R.id.getStarted_button);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);
        getStarted_button.setOnClickListener(this);

        signIn.setPaintFlags(signIn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mAdapter = new Onboarding_ViewPager_Adapter(Onboarding_ViewPager.this, mImageResources);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

