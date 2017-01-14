package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.customview.pranay.designlibrary.R;

import java.util.List;

import Model.RecyclerModel;

/**
 * Created by Pranay on 14-01-2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Viewholder> {
    private final LayoutInflater inflater;
    Context context;
    List<RecyclerModel> list;
    public RecyclerviewAdapter(Context context, List<RecyclerModel> list) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.advanced_recyclerview_row, parent, false);
        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.img));
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (list!=null)?list.size():0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView image ;
        TextView name;
        public Viewholder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.ivRecyclerview);
            name = (TextView) itemView.findViewById(R.id.tvRecyclerview);
        }
    }
}
