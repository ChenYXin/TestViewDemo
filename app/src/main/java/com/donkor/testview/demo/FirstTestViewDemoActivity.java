package com.donkor.testview.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * TestView 实现图文混排
 */
public class FirstTestViewDemoActivity extends Activity {

    //使用反射机制来获取资源的id的字段（静态变量）的值
    public int getResourceId(String name) {
        try {
            // 根据资源的id名的变量取得field的对象，使用反射机制来实现
            Field field = R.drawable.class.getField(name);
            // 取得并返回资源的id的字段（静态变量）的值，使用反射机制
            return Integer.parseInt(field.get(null).toString());
        } catch (Exception e) {
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_testviewdemo);

        TextView testView = (TextView) findViewById(R.id.testView);

        String hmtl = "android 标签一<img src='pic1'/><br>android 标签二<img src='pic2'/><br>android 标签三<img src='pic3'/><br>android 标签四<img src='pic4'/><br>android 标签五<img src='pic5'/><br>";
        CharSequence charSequence = Html.fromHtml(hmtl, new Html.ImageGetter() {
            public Drawable getDrawable(String source) {
                // 获得资源系统的信息，比如图片信息//根据名字，获取图片id，再根据id获取当前工程下的drawable文件中的图片
                Drawable drawable = FirstTestViewDemoActivity.this.getResources()
                        .getDrawable(getResourceId(source));
                // 当名字等于pic3的时候，使图片变小
                if (source.equals("pic3")) {
                    // IntrinsicWidth内部固有的宽IntrinsicHeight内部固有的高
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 2,
                            drawable.getIntrinsicHeight() / 2);
                } else {
                    // IntrinsicWidth内部固有的宽IntrinsicHeight内部固有的高
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight());
                }
                return drawable;
            }
        }, null);
        testView.setText(charSequence);
        testView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
