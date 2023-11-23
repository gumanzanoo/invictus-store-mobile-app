package unipar.invictus.resources.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import unipar.invictus.R;
import unipar.invictus.app.helpers.SessionManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SessionManager sessionManager = new SessionManager(this);

        if (!sessionManager.isLoggedIn()) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        } else {
            abrirHome();
        }
    }

    public void abrirHome() {
        Intent abrirHomeIntent = new Intent(this, HomeActivity.class);
        startActivity(abrirHomeIntent);
    }
}