package skinsenor.android.com.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.msg_tv);
        if (getIntent() != null && getIntent().getData() != null && getIntent().getData().getQueryParameter("type") != null) {
            textView.setText(getIntent().getData().getQueryParameter("type"));
        }
    }
}
