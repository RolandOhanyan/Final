package com.example.afinal;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Display the user's name
        TextView textView = findViewById(R.id.name);
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            String userName = user.getDisplayName();
            textView.setText("Welcome, " + userName);
        } else {
            // Handle the case where the user is not signed in
        }

        // Set up the logout button
        Button signOutButton = findViewById(R.id.logout_button);
        signOutButton.setOnClickListener(view -> signOutAndStartSignInActivity());
    }

    private void signOutAndStartSignInActivity() {
        // Firebase sign out
        mAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this, task -> {
            // Optional: Update UI or show a message to the user
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
