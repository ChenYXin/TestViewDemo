package com.donkor.testview.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * TestView 显示丰富的文本
 */
public class SecondTestViewDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_testviewdemo);

        TextView textView1= (TextView) findViewById(R.id.textView1);
        TextView textView2= (TextView) findViewById(R.id.textView2);

        String html="<font color='red'>这是红色的一栏</font><br><br>";
        //<p>表示段落符
        html+="<font color='#0000ff'><i><big>这是蓝色的一行</big></i></font><p>";
        html+="<a href='http://blog.csdn.net/donkor_'>donkor_的博客</a><br>";
        CharSequence charsequence= Html.fromHtml(html);
        textView1.setText(charsequence);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        String text="tel:1008611\r\n";
        text+="email:donkor@yeah.net\r\n";
        text+="url:http://blog.csdn.net/donkor_";
        textView2.setText(text);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
