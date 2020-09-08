package com.base.kyrgyzsfishs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class NewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.logo_activity);

    }

    public void onclickstart(View view) {
        Intent is=new Intent(NewActivity.this,MainActivity.class);
        startActivity(is);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    }

