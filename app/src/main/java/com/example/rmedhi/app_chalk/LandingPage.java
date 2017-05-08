package com.example.rmedhi.app_chalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rmedhi.app_chalk.api.Poll_service;
import com.example.rmedhi.app_chalk.fetch_api.Fetch_all_polls;
import com.example.rmedhi.app_chalk.fetch_api.Fetch_api;
import com.example.rmedhi.app_chalk.fetch_api.Option_data;
import com.example.rmedhi.app_chalk.fetch_api.Polldata;
import com.example.rmedhi.app_chalk.fetch_api.Topic_data;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.value;

/**
 * Created by R Medhi on 08-05-2017.
 */

public class LandingPage extends AppCompatActivity {

    private Context mContext;

    private RecyclerView mRecyclerView;

    private int g_pos;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Pollcard> cardsList = new ArrayList<>();

    @BindView(R.id.rl)
    RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key"); //if it's a string you stored.

        setContentView(R.layout.landing_page);

        mContext = getApplicationContext();

        mRecyclerView = (RecyclerView) findViewById(R.id.r_view);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        // Initialize a new instance of RecyclerView Adapter instance
        mAdapter = new ViewAdapter(mContext,cardsList);
        mAdapter.setHasStableIds(false);

        mRecyclerView.setAdapter(mAdapter);

        fetch_all_polls_call();

    }

    public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
        public List<Pollcard> mDataSet;
        private Context mContext;

        public ViewAdapter(Context context,List<Pollcard> list){
            mDataSet = list;
            mContext = context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.poll_ques)
            TextView poll_ques;
            @BindView(R.id.poll_desc)
            TextView poll_desc;
            @BindView(R.id.rl_card)
            RelativeLayout mRelativeLayout;
            public ViewHolder(View v){
                super(v);
                ButterKnife.bind(this,v);
            }
        }

        @Override
        public ViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            // Create a new View
            View v = LayoutInflater.from(mContext).inflate(R.layout.polls_card,parent,false);
            ViewAdapter.ViewHolder vh = new ViewAdapter.ViewHolder(v);
            vh.setIsRecyclable(false);
            return vh;
        }

        public void onBindViewHolder(final ViewAdapter.ViewHolder holder, final int position) {
        }

        public int getItemCount(){
            return mDataSet.size();
        }
    }

    public void fetch_all_polls_call()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.77.240.129/rishav/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Poll_service service = retrofit.create(Poll_service.class);

        Call<Fetch_all_polls> fetch_obj = service.api_fetch_all_polls();
        fetch_obj.enqueue(new Callback<Fetch_all_polls>() {
            @Override
            public void onResponse(Call<Fetch_all_polls> call, Response<Fetch_all_polls> response) {
                response.body();
                ArrayList<Polldata> polls=response.body().getPolls();
                ArrayList<Option_data> options=response.body().getOptions();
                ArrayList<Topic_data> topics=response.body().getTopics();
                Log.d("Fetched",response.body().getStatus()+"");
            }

            @Override
            public void onFailure(Call<Fetch_all_polls> call, Throwable t) {

            }
        });
    }
}

