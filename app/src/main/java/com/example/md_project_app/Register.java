package com.example.md_project_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private TextView sign_in_link;
    private FirebaseAuth auth;
    private Button sign_up;
    private EditText FullName;
    private EditText Email;
    private EditText Pwd;
    private EditText C_Pwd;

       @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_register);
       auth = FirebaseAuth.getInstance();
        sign_up = findViewById(R.id.sign_up);
        FullName =findViewById(R.id.FullName);
        Email=findViewById(R.id.Email);
        Pwd=findViewById(R.id.Pwd);
        C_Pwd=findViewById(R.id.C_Pwd);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = FullName.getText().toString().trim();
                String mail = Email.getText().toString().trim();
                String pass = Pwd.getText().toString().trim();
                String c_pass = C_Pwd.getText().toString().trim();

                if (user.isEmpty()){
                    FullName.setError("Username cannot be Empty!");
                }
                if (mail.isEmpty()){
                    Email.setError("Email cannot be Empty!");
                }
                if (pass.isEmpty()){
                    Pwd.setError("Password cannot be Empty!");
                }
                if (c_pass.isEmpty()){
                    C_Pwd.setError("C-Password cannot be Empty!");
                }

                else {
                    auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Register.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this,Login.class));

                            }else{
                                Toast.makeText(Register.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

           sign_in_link = findViewById(R.id.sign_in_link);
           sign_in_link.setOnClickListener(v -> {
               startActivity(new Intent(Register.this, Login.class));
           });
    }
}