package com.donkor.testview.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/**
 * TestView 实现跑马灯效果
 */
public class FourthTestViewDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_testviewdemo);

        TextView textView= (TextView) findViewById(R.id.textView);

        String html = "Android<a href='http://blog.csdn.net/donkor_'>donkor的博客</a> donkor的博客";
        CharSequence charSequence = Html.fromHtml(html);
        textView.setText(charSequence);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        Animation ani = new TranslateAnimation(310f, -400f, 0.0f, 0.0f);
        ani.setDuration(10000);
        ani.setRepeatCount(500);
        ani.setRepeatMode(1);
        textView .startAnimation(ani);
    }
}
