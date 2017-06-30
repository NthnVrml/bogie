package com.sncf.android.internal.codelab2017.app4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Nicolas on 27/06/2017.
 */

class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {
    private Context mContext;
    private List<Result> mResults;

    ResultAdapter(final Context context, final List<Result> results) {
        mResults = results;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Result result = mResults.get(position);
        final TextView nameTextView = holder.name;
        final TextView descriptionTextView = holder.description;


        final String name = result.getName();
        final String link = result.getLink();
        final String description = result.getDescription();


        SpannableString content = new SpannableString(name);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        nameTextView.setText(content);

        nameTextView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                        mContext.startActivity(intent);
                    }
                }
        );

        descriptionTextView.setText(description);

        holder.description.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(mContext); //alert for confirm to delete
                    builder.setMessage("Voulez vous partager ce lien ? ");    //set message

                    builder.setPositiveButton("Partager", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT, "Voici un document qui peut t'être utile!\n" + link);
                            sendIntent.setType("text/plain");
                            mContext.startActivity(sendIntent);
                        }
                    }).setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        MyViewHolder(final View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.result_item_name);
            description = (TextView) view.findViewById(R.id.result_item_description);
        }
    }
}
