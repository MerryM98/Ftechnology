package com.example.ftechnology;

import android.os.Bundle;

import com.example.ftechnology.models.TechnologyModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DetailActivity extends BaseActivity {

    //private FloatingActionButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();

        model = (TechnologyModel) getIntent().getSerializableExtra("model");

        if(model != null) {
            makeSimpleAlertDialog("success","Model:" + model.getType());
        }else {
            makeSimpleAlertDialog("Error","Empy type");
        }

        /*fab_create_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });*/

    }

    protected void init(){

    }
}