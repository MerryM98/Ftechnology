package com.example.ftechnology;

import android.os.Bundle;

import com.example.ftechnology.adapters.technologyAdapter;
import com.example.ftechnology.models.TechnologyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends BaseActivity {

    private FloatingActionButton fab_list;
    private ListView lv_list_technology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();

        fab_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreate();
            }
        });

        lv_list_technology.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                model = (TechnologyModel) modelArrayList.get(position);
                  goToDetail(model);
            }
        });

    }

    protected  void  init(){
        fab_list = findViewById(R.id.fab_list);
        lv_list_technology = findViewById(R.id.lv_list_technology);
    }

    protected void getTechnology(){
        if(collectionReference != null){
            collectionReference.get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                if(task.getResult() != null){
                                    modelArrayList = new ArrayList<>();
                                    for(QueryDocumentSnapshot snapshot : task.getResult()){
                                        model = snapshot.toObject(TechnologyModel.class);
                                        modelArrayList.add(model);
                                    }
                                    if(modelArrayList.size() > 0){
                                        paintTechnology(modelArrayList);
                                    }else{
                                        makeSimpleAlertDialog("Warnig", "Techology not");
                                    }

                                }else {
                                    makeSimpleAlertDialog("Warnig", "Techology not");
                                }

                            }else {
                                makeSimpleAlertDialog("Error", task.getException().getMessage());
                            }
                        }
                    });
        }else {
            makeSimpleToast("Database error",1);

        }
    }

    protected void paintTechnology(ArrayList<TechnologyModel> modelArrayList){
        adapter = new technologyAdapter(this, modelArrayList);
        lv_list_technology.setAdapter((ListAdapter) adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getTechnology();
    }
}