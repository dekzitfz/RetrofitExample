package id.dekz.code.retrofitexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.dekz.code.retrofitexample.OnItemClickListener;
import id.dekz.code.retrofitexample.R;
import id.dekz.code.retrofitexample.model.User;

/**
 * Created by DEKZ on 3/2/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context context;
    private OnItemClickListener onItemClickListener = null;

    public RecyclerViewAdapter(ArrayList<User> users, Context context){
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tvLoginName.setText(users.get(position).getLogin());
        Picasso.with(context).load(users.get(position).getAvatar_url()).into(viewHolder.imgAvatar);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvLoginName;
        private ImageView imgAvatar;
        public ViewHolder(View itemView) {
            super(itemView);
            tvLoginName = (TextView) itemView.findViewById(R.id.tvLoginName);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemCLick(v, getAdapterPosition());
            }

        }
    }

    public void setClickListener(OnItemClickListener onItemClickListener ) {
        this.onItemClickListener = onItemClickListener ;
    }

}
