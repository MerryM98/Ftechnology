package com.example.ftechnology;

import android.os.Bundle;

import com.example.ftechnology.models.TechnologyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.FirebaseStorage;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ActualizarActivity<object> extends BaseActivity {
    FloatingActionButton fab_Actualizar_back;
    ImageView iv_actualizar_img;
    TextView tv_actualizar_clic_img;
    EditText et_actualizar_type,et_Actualizar_example,et_Actualizar_description;
    Button btnActualizar;

    private  String Detalleid;
    private   FirebaseStorage  mFirebaseStorage;
    private Object HashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);


        et_actualizar_type = findViewById(R.id.et_actualizar_type);
        et_Actualizar_example = findViewById(R.id.et_Actualizar_example);
        et_Actualizar_description = findViewById(R.id.et_Actualizar_description);
        btnActualizar = findViewById(R.id.btnActualizar);

        mFirebaseStorage = FirebaseStorage.getInstance();
        Detalleid = getIntent().getStringExtra("Detalleid");


    }

       private <map> void ActualizarDatos(){

       }

    protected  void init (){
        fab_Actualizar_back= findViewById(R.id.fab_Actualizar_back);
        iv_actualizar_img= findViewById(R.id.iv_actualizar_img);
        tv_actualizar_clic_img= findViewById(R.id.tv_actualizar_clic_img);
        et_actualizar_type= findViewById(R.id.et_actualizar_type);
        et_Actualizar_example= findViewById(R.id.et_Actualizar_example);
        et_Actualizar_description= findViewById(R.id.et_Actualizar_description);
        btnActualizar=findViewById(R.id. btnActualizar);



    }
}