package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication12.R;


public class MainActivity extends AppCompatActivity {
    private String TAG = "zsw111";
    private Button mButton;
    private Button mButton1;
    private Button mButton2;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.bt_btton);
        mButton1 = findViewById(R.id.bt_btton1);
        mButton2 = findViewById(R.id.bt_btton2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = getStr1();
                mButton.setText(str1);
                Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT);
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStr();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProveCrash();
            }
        });
    }

    public static native String getStr1();

    public static native void getStr();

    public static native void ProveCrash();
}
