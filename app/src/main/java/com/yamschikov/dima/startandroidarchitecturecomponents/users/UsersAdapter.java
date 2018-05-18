package com.yamschikov.dima.startandroidarchitecturecomponents.users;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yamschikov.dima.startandroidarchitecturecomponents.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    List<Users> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userId_tv) TextView userId;
        @BindView(R.id.id_tv) TextView id;
        @BindView(R.id.title_tv) TextView title;
        @BindView(R.id.body_tv) TextView body;

        public MyViewHolder(View view) {
            super(view);

            ButterKnife.bind(this,view);

        }
    }


    public UsersAdapter(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.usersreating_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Users users = usersList.get(position);

        holder.userId.setText(Integer.toString(users.getUserId()));
        holder.id.setText(Integer.toString(users.getId()));
        holder.title.setText(users.getTitle());
        holder.body.setText(SrringFiftyDots(position, usersList));


    }

    private String SrringFiftyDots (int pos, List<Users> usersList){

        String startStr = "";

        for (int i=0; i<usersList.size(); i++){

            if (usersList.get(pos).getBody().length()>50) {

                startStr = usersList.get(pos).getBody();
                startStr = startStr.substring(0, 51)+"...";
            }
            else {
                startStr = usersList.get(pos).getBody();
                startStr = startStr + "...";
            }
        }
        return startStr;
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}