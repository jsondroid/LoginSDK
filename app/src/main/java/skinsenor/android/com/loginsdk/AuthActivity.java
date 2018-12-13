package skinsenor.android.com.loginsdk;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wenbaohe on 2018/12/13.
 * <p>
 * 回调认证
 */

public class AuthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null && getIntent().getData() != null && getIntent().getData().getQueryParameter("type") != null) {
            /**获取回传信息通过回调接口（sdk的回调接口）返回信息给app客户端*/
        String msg=getIntent().getData().getQueryParameter("type");
            Log.e("回调------", "" +msg );
            Toast.makeText(this,"登录成功:"+msg,Toast.LENGTH_SHORT).show();
            this.finish();

        }
    }
}
