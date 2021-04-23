package com.cookandroid.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<User> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // xml을 객체화함, inflate의 첫번째 파라미터는 만들고 싶은 레이아웃 파일의 id, 2번째 파라미터는 root자리임, 생성될 View의 parent를 명시해준다. 3번째 파라미터는 true로 설정해줄 경우 root의 자식 View로 추가된다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycleitem, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // 파이어베이스 데이터를 받아옴
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
        .into(holder.iv_recycleProfile);

        holder.tv_recycleId.setText(arrayList.get(position).getId());
        holder.tv_recyclePw.setText(String.valueOf(arrayList.get(position).getPw()));
        holder.tv_recycleUserName.setText(arrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_recycleProfile;
        TextView tv_recycleId;
        TextView tv_recyclePw;
        TextView tv_recycleUserName;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_recycleProfile = itemView.findViewById(R.id.iv_recycleProfile);
            this.tv_recycleId = itemView.findViewById(R.id.tv_recycleId);
            this.tv_recyclePw = itemView.findViewById(R.id.tv_recyclePw);
            this.tv_recycleUserName = itemView.findViewById(R.id.tv_recycleUserName);
        }
    }
}
