package wlm.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wlm.tyhkj.R;

public class ZqzyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ZqzyBean> list = new ArrayList<>();
    public RemoveItem removeItem;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (list.get(i).isComment() == true) {
            return new MainViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_zqzy_main, viewGroup, false));
        } else {
            return new AuxiliaryHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_zqzy_sc, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (list.get(i).isComment() == true) {
            ((MainViewHolder) viewHolder).nameone.setText(list.get(i).getName());
            ((MainViewHolder) viewHolder).txtone.setText(list.get(i).getTxt());
        } else {
            ZqzyBean z = list.get(i);
            ((AuxiliaryHolder) viewHolder).nametwo.setText(list.get(i).getName());

            ((AuxiliaryHolder) viewHolder).txttwo.setText(list.get(i).getTxt());
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeItem.Del(i);

            }
        });


    }

    public void del(RemoveItem removeItem) {
        this.removeItem = removeItem;
    }

    public void setData(List<ZqzyBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    public void delData(List<ZqzyBean> list){
        this.list.clear();
        notifyDataSetChanged();
        setData(list);
    }



    //    他的返回值直接影响RecyclerView.ViewHolder里面的int值
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //评论
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView nameone, txtone;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            txtone = (itemView).findViewById(R.id.txtone);
            nameone = (itemView).findViewById(R.id.nameone);
        }
    }

    //回复
    public class AuxiliaryHolder extends RecyclerView.ViewHolder {
        private TextView txttwo, nametwo;

        public AuxiliaryHolder(@NonNull View itemView) {
            super(itemView);
            txttwo = (itemView).findViewById(R.id.txttwo);
            nametwo = (itemView).findViewById(R.id.nametwo);
        }
    }

    public interface RemoveItem {
        void Del(int i);
    }
}
