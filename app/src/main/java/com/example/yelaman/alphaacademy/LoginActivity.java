package com.example.yelaman.alphaacademy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText mLoginField;
    private EditText mPasswordField;

    private Button mLoginButton;
    private Button mRegisterButton;




    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String stringEmail = mLoginField.getText().toString().trim();
            String stringPassword = mPasswordField.getText().toString().trim();

            stringEmail = stringEmail.replaceAll("\\s+", "");
            stringPassword = stringPassword.replaceAll("\\s+", "");

            mLoginButton.setEnabled(!stringEmail.isEmpty() && !stringPassword.isEmpty());
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            InputFilter filter = new InputFilter() {
                public CharSequence filter(CharSequence source, int start, int end,
                                           Spanned dest, int dstart, int dend) {
                    for (int i = start; i < end; i++) {
                        if (Character.isWhitespace(source.charAt(i))) {
                            return "";
                        }
                    }
                    return null;
                }

            };
            mLoginField.setFilters(new InputFilter[] { filter });
            mPasswordField.setFilters(new InputFilter[] { filter });
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Sign In");

        mAuth = FirebaseAuth.getInstance();

        mLoginField = findViewById(R.id.login_field);
        mPasswordField = findViewById(R.id.password_field);
        mLoginButton = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.register_button);


        mLoginButton.setEnabled(false);
        mLoginField.addTextChangedListener(mTextWatcher);
        mPasswordField.addTextChangedListener(mTextWatcher);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            LayoutInflater inflator = LayoutInflater.from(this);
            View v = inflator.inflate(R.layout.titleview, null);

            ((TextView) v.findViewById(R.id.title)).setText(this.getTitle());
            ((TextView) v.findViewById(R.id.title)).setTextSize(20);


            this.getSupportActionBar().setCustomView(v);
        }


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {

                }
            }
        };

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(mLoginField.getText().toString(), mPasswordField.getText().toString());
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
    }

    public void setActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            setActivity();
                            Log.d(TAG, "signInWithEmail:success");
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }
}
