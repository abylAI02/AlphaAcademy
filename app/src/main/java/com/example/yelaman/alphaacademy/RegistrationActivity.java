package com.example.yelaman.alphaacademy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText mNameField;
    private EditText mSurnameField;
    private EditText mLoginField;
    private EditText mPasswordField;

    private Button mRegisterButton;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String stringEmail = mLoginField.getText().toString().trim();
            String stringPassword = mPasswordField.getText().toString().trim();
            String stringName = mNameField.getText().toString().trim();
            String stringSurname = mSurnameField.getText().toString().trim();
            mRegisterButton.setEnabled(!stringEmail.isEmpty() && !stringPassword.isEmpty() && !stringName.isEmpty() && !stringSurname.isEmpty());
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        setTitle("Sign Up");

        mLoginField = findViewById(R.id.login_field);
        mPasswordField = findViewById(R.id.password_field);
        mNameField = findViewById(R.id.first_name_field);
        mSurnameField = findViewById(R.id.family_name_field);

        mRegisterButton = findViewById(R.id.register_button);

        mRegisterButton.setEnabled(false);

        mLoginField.addTextChangedListener(mTextWatcher);
        mPasswordField.addTextChangedListener(mTextWatcher);
        mNameField.addTextChangedListener(mTextWatcher);
        mSurnameField.addTextChangedListener(mTextWatcher);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {

                }
            }
        };

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(mLoginField.getText().toString(), mPasswordField.getText().toString());
            }
        });
    }



    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {

                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}