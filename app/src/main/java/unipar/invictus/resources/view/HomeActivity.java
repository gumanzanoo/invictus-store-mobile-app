package unipar.invictus.resources.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import unipar.invictus.R;
import unipar.invictus.app.helpers.Activity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(view -> Activity.run(this, MenuActivity.class));
    }
}
