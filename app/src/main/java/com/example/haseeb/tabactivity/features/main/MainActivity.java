package com.example.haseeb.tabactivity.features.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haseeb.tabactivity.features.userProfile.UserProfileActivity;
import com.example.haseeb.tabactivity.R;

public class MainActivity extends AppCompatActivity implements ManiMVP.view {
    ManiMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.activity_main_edittxt_SearcName);
        presenter = new MainActivityPresenter(this);


        Button btn = findViewById(R.id.activity_main_btnSearch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PresentUserName(editText.getText().toString());


            }
        });

    }
    @Override
    public void SearchUserInGitHubByName(String name) {
        Toast.makeText(getApplicationContext(), "name" + name, Toast.LENGTH_SHORT).show();
        //presenter.PresentUserName();
        Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
        intent.putExtra("username", name);
        startActivity(intent);

    }




}