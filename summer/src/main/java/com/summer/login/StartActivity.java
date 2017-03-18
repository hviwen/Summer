package com.summer.login;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.summer.MainActivity;
import com.summer.R;
import com.summer.constant.SP_Constant;
import com.summer.utils.SharedPreferencesUtil;

/**
 * Created by bestotem on 2017/3/16.
 */

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "StartActivity";
    Context context = StartActivity.this;
    SharedPreferencesUtil sp;
    private TextView tv_title;
    private TextView tv_content;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();
        startAnim();
    }

    private void initView() {
        sp = new SharedPreferencesUtil(context, SP_Constant.SP_NAME);
        tv_title = (TextView) findViewById(R.id.tv_start);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    private void startAnim() {

        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(900);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();

                tv_title.setText(R.string.summer);
                tv_content.setText(R.string.hello_world);
                tv_title.setAlpha(alpha);
                tv_content.setAlpha(alpha);
                Log.e(TAG, "--- show iv_alpha title--- " + alpha);
            }
        });
        animator.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StartApp();

            }
        }, 1200);


    }

    private void StartApp() {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
