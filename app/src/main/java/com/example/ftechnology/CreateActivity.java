package com.example.ftechnology;

import android.os.Bundle;

import com.example.ftechnology.models.TechnologyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateActivity extends BaseActivity {

    FloatingActionButton fab_create_save, fab_create_clear, fab_create_back;
    ImageView iv_created_img;
    TextView tv_create_clic_img;
    EditText et_create_type, et_create_example, et_create_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();

        fab_create_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });

        fab_create_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        fab_create_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type, description, example;
                boolean active;

                type = et_create_type.getText().toString();
                description = et_create_description.getText().toString();
                example = et_create_example.getText().toString();

                if(type.isEmpty() || description.isEmpty() || example.isEmpty()){
                    makeSimpleAlertDialog("Info","Please fill all fields");
                }else{
                    model = new TechnologyModel();
                    model.setActive(true);
                    model.setDescription(description);
                    model.setExample(example);
                    model.setType(type);

                    save(model);

                }
            }
        });
    }

    private void save(TechnologyModel model) {
        if (collectionReference != null){
            collectionReference.add(model)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if(task.isSuccessful()){
                                if (task.getResult() != null){
                                    makeSimpleAlertDialog("Succes", "technology saved");
                                       clear();
                                }else {
                                    makeSimpleAlertDialog("Warning", "technology not save");
                                }

                            }else {
                                makeSimpleAlertDialog("Error", task.getException().getMessage());
                            }
                        }
                    });
        }else{
            makeSimpleAlertDialog("Error","Not database connection");
        }
    }

    protected void  init(){
        fab_create_save = findViewById(R.id.fab_create_save);
        fab_create_clear = findViewById(R.id.fab_create_clear);
        fab_create_back = findViewById(R.id.fab_create_back);
        iv_created_img = findViewById(R.id.iv_created_img);
        tv_create_clic_img = findViewById(R.id.tv_create_clic_img);
        et_create_type = findViewById(R.id.et_create_type);
        et_create_example = findViewById(R.id.et_create_example);
        et_create_description = findViewById(R.id.et_create_description);
    }

    private void clear(){
        et_create_description.setText("");
        et_create_example.setText("");
        et_create_type.setText("");

        et_create_type.requestFocus();

        iv_created_img.setImageResource(R.drawable.ic_polymer_black_18dp);
    }
}