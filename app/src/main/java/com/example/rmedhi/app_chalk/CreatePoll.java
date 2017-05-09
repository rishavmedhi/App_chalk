package com.example.rmedhi.app_chalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rmedhi.app_chalk.fetch_api.Option_data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.value;

/**
 * Created by R Medhi on 09-05-2017.
 */

public class CreatePoll extends AppCompatActivity {
    private Context mContext;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.create_poll_rl)
    RelativeLayout mRelativeLayout;

    @BindView(R.id.pollques)
    EditText poll_ques;

    @BindView(R.id.polldesc)
    EditText poll_desc;

    @BindView(R.id.add_option)
    Button add_option_btn;

    private Option_data option;
    ArrayList<Option_data> option_list=new ArrayList<Option_data>();

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

                String poll_question=poll_ques.getText().toString();
                String poll_description=poll_desc.getText().toString();



                Intent myIntent = new Intent(CreatePoll.this, LandingPage.class);
                myIntent.putExtra("key", value); //Optional parameters
                CreatePoll.this.startActivity(myIntent);
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
        ButterKnife.bind(this);
        mContext = getApplicationContext();

        mRecyclerView = (RecyclerView) findViewById(R.id.create_poll_rv);

        mLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        // Initialize a new instance of RecyclerView Adapter instance

        mAdapter = new ViewAdapter(mContext,option_list);
        mAdapter.setHasStableIds(false);

        mRecyclerView.setAdapter(mAdapter);

        add_option_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                    Log.d("hello","hello");
                option_list.add(new Option_data());
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    public class ViewAdapter extends RecyclerView.Adapter<CreatePoll.ViewAdapter.ViewHolder> {
        public List<Option_data> mDataSet;
        private Context mContext;

        public ViewAdapter(Context context,ArrayList<Option_data> list){
            mDataSet = list;
            mContext = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.OptionName)
            EditText option_name;
            @BindView(R.id.rl_option)
            RelativeLayout mRelativeLayout;
            public ViewHolder(View v){
                super(v);
                ButterKnife.bind(this,v);
            }
        }

        @Override
        public CreatePoll.ViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            // Create a new View
            View v = LayoutInflater.from(mContext).inflate(R.layout.option_form,parent,false);
            CreatePoll.ViewAdapter.ViewHolder vh = new CreatePoll.ViewAdapter.ViewHolder(v);
            vh.setIsRecyclable(false);
            return vh;
        }

        public void onBindViewHolder(final CreatePoll.ViewAdapter.ViewHolder holder, final int position) {
        }

        public int getItemCount(){
            return mDataSet.size();
        }
    }
}
