package app.codelab.dev.bogie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 27/06/2017.
 */

public class BogieAdapter extends RecyclerView.Adapter<BogieAdapter.MyViewHolder> {
    private List<Bogie> mBogies;

    public BogieAdapter() {
        mBogies = new ArrayList<>();
        mBogies.add(new Bogie(Boogies.DPF));
        mBogies.add(new Bogie(Boogies.EXTERNALISATION));
        mBogies.add(new Bogie(Boogies.MOET));
        mBogies.add(new Bogie(Boogies.SMQ));
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
        holder.image.setImageResource(bogie.getImage());
    }

    @Override
    public int getItemCount() {
        return mBogies.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.bogie_item_name);
            image = view.findViewById(R.id.bogie_item_image);
        }
    }
}
