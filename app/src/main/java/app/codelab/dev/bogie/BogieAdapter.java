package app.codelab.dev.bogie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
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

class BogieAdapter extends RecyclerView.Adapter<BogieAdapter.MyViewHolder> {
    private Context mContext;
    private List<Bogie> mBogies;

    BogieAdapter(final Context context) {
        mContext = context;
        setupBogiesList();
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
        holder.item.setBackgroundResource(bogie.getImageBackGround());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(mContext, ResultsActivity.class);
                intent.putExtra("category", bogie.getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBogies.size();
    }

    private void setupBogiesList() {
        mBogies = new ArrayList<>();
        mBogies.add(new Bogie(Boogies.DPF));
        mBogies.add(new Bogie(Boogies.EXTERNALISATION));
        mBogies.add(new Bogie(Boogies.MOET));
        mBogies.add(new Bogie(Boogies.SMQ));
        mBogies.add(new Bogie(Boogies.SECURITE));
        mBogies.add(new Bogie(Boogies.ENV));
        mBogies.add(new Bogie(Boogies.IP_MED));
    }

    public void removeItem(int position) {
        mBogies.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mBogies.size());
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private final View item;
        TextView name;
        ImageView image;

        MyViewHolder(final View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.bogie_item_name);
            image = (ImageView) view.findViewById(R.id.bogie_item_image);
            item = view.findViewById(R.id.item_bogie);
        }
    }
}
