package com.example.rahul.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etLink;
    Button loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Main Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etLink=findViewById(R.id.link_et_main);
        loadBtn=findViewById(R.id.btn_load_main);

        etLink.setText("https://internshala.com/");

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=etLink.getText().toString();
                if (TextUtils.isEmpty(link))
                {
                    Toast.makeText(MainActivity.this,"Please enter a link to load!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loadLink(link);
                }
            }
        });

    }

    private void loadLink(String link) {
        Intent intent=new Intent(MainActivity.this,WebPageActivity.class);
        intent.putExtra("url",link);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
