package com.example.rmedhi.app_chalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import butterknife.BindView;

import static android.R.attr.value;

/**
 * Created by R Medhi on 09-05-2017.
 */

public class CreatePoll extends AppCompatActivity {
    
    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mymenu = getMenuInflater();
        mymenu.inflate(R.menu.createpoll_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submit_newpoll:
//                int position = 0;
                // setting blank template
//                cardsList.add(position, new CardList());
//                mAdapter.notifyItemInserted(0);
//                mRecyclerView.scrollToPosition(position);
//                mRecyclerView.setVisibility(View.VISIBLE);
//                welcometext.setVisibility(View.INVISIBLE);
                Intent myIntent = new Intent(CreatePoll.this, LandingPage.class);
                myIntent.putExtra("key", value); //Optional parameters
                CreatePoll.this.startActivity(myIntent);
                CreatePoll.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.

        setContentView(R.layout.createpoll);
    }

}
