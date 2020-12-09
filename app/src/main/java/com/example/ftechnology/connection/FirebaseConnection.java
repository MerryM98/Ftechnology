package com.example.ftechnology.connection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseConnection {
    private static FirebaseAuth mAuth;

    //private static StorageReference mStorageRef;

    private static FirebaseFirestore db;

    private static FirebaseStorage mFirebaseStorage;


    public static FirebaseAuth connectionAuth() {
        return mAuth = FirebaseAuth.getInstance();
    }

    /*
    public static StorageReference connectionStorage(){
        return mStorageRef = FirebaseStorage.getInstance().getReference();
    }*/

    public static FirebaseFirestore connectionFirestore(){
        return  db = FirebaseFirestore.getInstance();
    }

    public static FirebaseStorage connectionStorage(){
        return mFirebaseStorage = FirebaseStorage.getInstance();
    }
}
