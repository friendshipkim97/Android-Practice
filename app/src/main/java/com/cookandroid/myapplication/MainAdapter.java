package com.cookandroid.myapplication;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder>{

    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // onCreateViewHolder는 추가버튼을 눌렀을때 실행된다, 다만, 누른횟수가 최대4번이면 지우고 4번까지는 호출되지 않음
        String jung = "정우";
        Log.e(jung,"크리에이트뷰홀더");
        // xml을 객체화함, inflate의 첫번째 파라미터는 만들고 싶은 레이아웃 파일의 id, 2번째 파라미터는 root자리임, 생성될 View의 parent를 명시해준다. 3번째 파라미터는 true로 설정해줄 경우 root의 자식 View로 추가된다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) { // 추가될때 이 메서드가 실행된다.
        String jung = "정우";
        Log.e(jung,"바인드뷰홀더");
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_name.getText().toString(); // getText까지는 Object형태로 리턴한다.
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show(); // Toast.LENGTH_SHORT는 짧은 시간동안 메세지를 띄운다.
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try {
             arrayList.remove(position);
             notifyItemRemoved(position);  // 새로고침하는것
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView)itemView.findViewById(R.id.iv_profile); // Activity파일이 아니기 때문에 itemView.findViewById를 사용
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
