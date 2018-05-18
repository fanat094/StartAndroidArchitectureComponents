package com.yamschikov.dima.startandroidarchitecturecomponents;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.socks.library.KLog;
import com.yamschikov.dima.startandroidarchitecturecomponents.users.Users;
import com.yamschikov.dima.startandroidarchitecturecomponents.users.UsersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //@BindView(R.id.mTextView) TextView mTextView;
    @BindView(R.id.progressBar) ProgressBar mprogressBar;

    UsersAdapter nAdapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


       /* RetrofitRepository.getIntData().observe(this, new Observer<StoreInfo>() {
            @Override
            public void onChanged(@Nullable StoreInfo storeInfo) {
                mTextView.setText(""+storeInfo.getStore());

                mprogressBar.setVisibility(View.GONE);
                KLog.e("mprogressBarGone", ""+mprogressBar.getProgress());
            }
        });*/

       RetrofitRepository.getIntData().observe(this, new Observer<List<Users>>() {
           @Override
           public void onChanged(@Nullable List<Users> users) {
               /*mTextView.setText(""+users.get(0).getTitle());
               mTextView.setVisibility(View.GONE);*/

               mprogressBar.setVisibility(View.GONE);

               nAdapter = new UsersAdapter(users);
               RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
               recyclerView.setItemAnimator(new DefaultItemAnimator());
               recyclerView.setLayoutManager(mLayoutManager);
               recyclerView.setItemAnimator(new DefaultItemAnimator());
               recyclerView.setAdapter(nAdapter);
           }
       });

        //RetrofitRepository.getStoreInfo();
        RetrofitRepository.getUsersInfo();
        mprogressBar.setVisibility(View.VISIBLE);
        KLog.e("mprogressBarVISIBLE", ""+mprogressBar.getProgress());
    }
}