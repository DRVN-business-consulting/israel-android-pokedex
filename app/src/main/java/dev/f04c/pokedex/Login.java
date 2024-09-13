package dev.f04c.pokedex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    // Hardcoded username and password
    private static final String HARDCODED_USERNAME = "1";
    private static final String HARDCODED_PASSWORD = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login); // Set the content view to the login layout

        // Get references to the EditText and Button
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Set an OnClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateLogin(username, password)) {
                    Intent intent = new Intent(Login.this, PokemonList.class);
                    startActivity(intent);
                    finish(); // Close the Login activity
                } else {
                    // Show invalid login message
                    Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate the entered username and password
    private boolean validateLogin(String username, String password) {
        return HARDCODED_USERNAME.equals(username) && HARDCODED_PASSWORD.equals(password);
    }
}
