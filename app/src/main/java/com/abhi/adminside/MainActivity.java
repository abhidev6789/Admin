package com.abhi.adminside;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.abhi.adminside.auth.LoginActivity;
import com.abhi.adminside.ebook.UploadPdfActivity;
import com.abhi.adminside.image.UploadImage;
import com.abhi.adminside.notice.DeleteNoticeActivity;
import com.abhi.adminside.notice.UploadNotice;
import com.abhi.adminside.slapp.teacher.Uploadfaculty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView uploadNotice, uploadImage, addEbook, faculty, news, student,  delete, logout;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Admin Dashboard");

        sharedPreferences = this.getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin", "false").equals("false")){
            openLogin();

        }

        uploadNotice = findViewById(R.id.uploadNotice);
        uploadImage = findViewById(R.id.uploadImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        delete = findViewById(R.id.delete);
        logout = findViewById(R.id.logout);


        uploadNotice.setOnClickListener(this);
        uploadImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        logout.setOnClickListener(this);
        delete.setOnClickListener(this);
        faculty.setOnClickListener(this);
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){

            case  R.id.uploadNotice:
                intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;

            case  R.id.uploadImage:
                intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;

            case  R.id.addEbook:
                intent = new Intent(MainActivity.this, UploadPdfActivity.class);
                startActivity(intent);
                break;

            case  R.id.faculty:
              intent = new Intent(MainActivity.this, Uploadfaculty.class);
              startActivity(intent);
               break;


            case  R.id.delete:
                intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:
                editor.putString("isLogin","false");
                editor.commit();
                openLogin();
                break;
        }
    }
}