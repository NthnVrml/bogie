package app.codelab.dev.bogie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nicolas on 27/06/2017.
 */

public class BogieAdapter extends RecyclerView.Adapter<BogieAdapter.MyViewHolder> {
    private List<Bogie> mBogies;

    public BogieAdapter(final List<Bogie> bogies) {
        mBogies = bogies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bogie_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Bogie bogie = mBogies.get(position);
        holder.name.setText(bogie.getName());
    }

    @Override
    public int getItemCount() {
        return mBogies.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.bogie_item_name);
        }
    }
}
