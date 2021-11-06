package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStr();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStr1();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                需要把这两行代码注释去掉即可
                #target_compile_options(native-lib PUBLIC -fsanitize=address -fno-omit-frame-pointer)
                #set_target_properties(native-lib PROPERTIES LINK_FLAGS -fsanitize=address)
                 */
                ProveCrash();
            }
        });
    }

    public static native String getStr1();

    public static native void getStr();

    public static native void ProveCrash();
}
