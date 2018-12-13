package skinsenor.android.com.loginsdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 通过uri启动另一个App
 * <p>
 * qq登录认证流程 sdk(app)---->qq---->（AuthActivity）sdk，
 * 自己的app(嵌有sdk)--->通过scheme协议将认证数据发送给qq客户端--->再通过scheme协议传值给（AuthActivity）sdk--->再回调到app
 * sdk中有一个AuthActivity，用来接收qq客户端通过scheme协议回传的数据给SDK，然后sdk再回调到app上层
 * <p>
 * <p>
 * (下面配置仿qq客户端)
 * AndroidManifest.xml
 * <activity android:name=".LoginActivity">
 * <intent-filter>
 * <action android:name="android.intent.action.MAIN" />
 * <category android:name="android.intent.category.LAUNCHER" />
 * </intent-filter>
 * <intent-filter>
 * <action android:name="json.login.ACTION" />
 * <!--必须放在同一个filter里面-->
 * <data
 * android:host="android.com.login"
 * android:path="/login"
 * android:scheme="json" /> <!-- json://android.com.login/login?type=110 ,type=110为传参 -->
 * <category android:name="android.intent.category.DEFAULT" /> <!-- 必须要该标签 -->
 * <!-- <category android:name="android.intent.category.BROWSABLE" /> -->
 * <!-- <category android:name="android.intent.category.HOME" /> -->
 * </intent-filter>
 * </activity>
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
    }

    private Uri uri = Uri.parse("json://android.com.login/login?type=110");

    public void useLoginSdk(View view) {
        Intent intent = new Intent("json.login.ACTION");
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
//
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.setData(Uri.parse("tencent1105762899://com.tencent.tauth.AuthActivity"));
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && data.getStringExtra("test") != null) {
            Log.e("返回值----", "" + data.getStringExtra("test"));
        }

    }
}
