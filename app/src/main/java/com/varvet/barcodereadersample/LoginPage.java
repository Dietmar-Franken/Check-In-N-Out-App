package com.varvet.barcodereadersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "LoginActivity";
    private EditText emailEdit;
    private EditText passwordEdit;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }

        };

        emailEdit = (EditText) findViewById(R.id.emailInput);
        passwordEdit = (EditText) findViewById(R.id.passwordInput);

        email = emailEdit.getText().toString();
        password = passwordEdit.getText().toString();

        String driver ="org.postgresql.Driver";
//        String url = "jdbc:postgresql://localhost/inout";
//        String user = "postgres";
//        String pwd = "alexle262";
//
//        Connection conn = null;
//        try {
//            Class.forName(driver); //trying to load driver
//        }
//        catch (ClassNotFoundException e) {
//
//            System.err.println("Can't load driver "+ e.getMessage());
//        }
//        try {
//            conn = DriverManager.getConnection(url, user, pwd);
//            System.err.println("Conection OK");
//
//        }
//        catch(Exception e) {
//
//            System.err.println("Connection Attempt failed");
//            System.err.println(e.getMessage());
//        }
//
//        if (conn != null) {
//            try {
//                String sql;
//                sql = "SELECT * FROM USERS;";
//
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery(sql);
//                while (rs.next()) {
//                    //Columens are can be referenced by name.
//                    String relname = rs.getString("relname");
//                }
//                rs.close();
//                st.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    /**
     * Does not login
     * @param v
     */
    public void cancelButtonAction(View v) {
        finish();
    }

    public void login(View v) {

        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(LoginPage.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        } else {

//                            if (mAuth.getCurrentUser().getUid() ) {
//                                startQRScanner();
//                            } would check type of user

                            startQRScanner();

                        }

                        // ...
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;
        email = emailEdit.getText().toString();
        password = passwordEdit.getText().toString();

        if (TextUtils.isEmpty(email)) {
            emailEdit.setError("Required.");
            valid = false;
        } else {
            emailEdit.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            passwordEdit.setError("Required.");
            valid = false;
        } else {
            passwordEdit.setError(null);
        }

        return valid;
    }

    public void startQRScanner() {
        Intent intent = new Intent(this, QRCodeGenerator.class);
        startActivity(intent);
    }
}
