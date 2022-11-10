package com.example.md_project_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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

public class Login extends AppCompatActivity {
    TextView sign_up_link,forget_Pwd;
    private FirebaseAuth auth;
    private EditText Email;
    private EditText Pwd;
    private Button signinbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        Email=findViewById(R.id.Email);
        Pwd=findViewById(R.id.Pwd);
        signinbtn=findViewById(R.id.signinbtn);

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String email = Email.getText().toString();
                String pass=Pwd.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, homepage.class));
                                finish();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        Pwd.setError("Password cannot be Empty!");
                    }
                }else if(email.isEmpty()){
                    Email.setError("Email cannot be Empty!");
                }else{
                    Email.setError("Enter valid Emil address");
                }

                }




        });


        sign_up_link = findViewById(R.id.sign_up_link);

        sign_up_link.setOnClickListener(v-> {
            startActivity(new Intent(Login.this, Register.class));
        });

        forget_Pwd = findViewById(R.id.forget_Pwd);

        forget_Pwd.setOnClickListener(v-> {
            startActivity(new Intent(Login.this, F_Pwd.class));
        });

    }
}