package com.donkor.testview.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/**
 * TestView 点击文字弹出Activity
 */
public class ThirdTestViewDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_testviewdemo);

        TextView textView1= (TextView) findViewById(R.id.textView1);
        TextView textView2= (TextView) findViewById(R.id.textView2);

        //标签文本
        SpannableString s1=new SpannableString("跳转到第一个Activity");
        SpannableString s2=new SpannableString("跳转到第二个Activity");
        //设置标签点击事件
        s1.setSpan(new ClickableSpan() {
            public void onClick(View arg0) {
                Intent intent=new Intent(ThirdTestViewDemoActivity.this,FristActivity.class);
                startActivity(intent);
            }//最后一个参数表示从头到尾都可以点击执行
        }, 0,s1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        s2.setSpan(new ClickableSpan() {
            public void onClick(View arg0) {
                Intent intent=new Intent(ThirdTestViewDemoActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        }, 0, s2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView1.setText(s1);
        textView2.setText(s2);

        textView1.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
