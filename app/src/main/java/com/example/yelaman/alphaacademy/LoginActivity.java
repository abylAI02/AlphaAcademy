package com.example.yelaman.alphaacademy;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.ProgressBar;
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
    private Button mForgotPasswordButton;

    private ProgressBar progressBar;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String stringEmail = mLoginField.getText().toString().trim();
            String stringPassword = mPasswordField.getText().toString().trim();

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
            mLoginField.setFilters(new InputFilter[]{filter});
            mPasswordField.setFilters(new InputFilter[]{filter});
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            setActivity();
        }

        setTitle("Sign In");

        mAuth = FirebaseAuth.getInstance();

        mLoginField = findViewById(R.id.login_field);
        mPasswordField = findViewById(R.id.password_field);
        mLoginButton = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.register_button);
        mForgotPasswordButton = findViewById(R.id.forget_button);

        progressBar = findViewById(R.id.progressBar);

        mLoginButton.setEnabled(false);
        mLoginField.addTextChangedListener(mTextWatcher);
        mPasswordField.addTextChangedListener(mTextWatcher);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            LayoutInflater inflater = LayoutInflater.from(this);
            View v = inflater.inflate(R.layout.titleview, null);

            ((TextView) v.findViewById(R.id.title)).setText(this.getTitle());
            ((TextView) v.findViewById(R.id.title)).setTextSize(20);


            this.getSupportActionBar().setCustomView(v);
        }


     /*   mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {

                }
            }
        };*/

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
        finish();
    }


    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(mAuth.getCurrentUser().isEmailVerified())
                            {
                                mLoginField.setVisibility(View.INVISIBLE);
                                mRegisterButton.setVisibility(View.INVISIBLE);
                                mPasswordField.setVisibility(View.INVISIBLE);
                                mLoginButton.setVisibility(View.INVISIBLE);
                                mForgotPasswordButton.setVisibility(View.INVISIBLE);

                                progressBar.setVisibility(ProgressBar.VISIBLE);

                                setActivity();
                                Log.d(TAG, "signInWithEmail:success");
                                new CountDownTimer(300, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        mLoginField.setVisibility(View.VISIBLE);
                                        mRegisterButton.setVisibility(View.VISIBLE);
                                        mPasswordField.setVisibility(View.VISIBLE);
                                        mLoginButton.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(ProgressBar.INVISIBLE);
                                    }
                                }.start();
                            }
                            else
                            {
                             Toast.makeText(LoginActivity.this, "Email is not verified" , Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            mLoginField.setVisibility(View.VISIBLE);
                            mRegisterButton.setVisibility(View.VISIBLE);
                            mPasswordField.setVisibility(View.VISIBLE);
                            mLoginButton.setVisibility(View.VISIBLE);
                            mForgotPasswordButton.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                        }
                    }
                });
    }

}
