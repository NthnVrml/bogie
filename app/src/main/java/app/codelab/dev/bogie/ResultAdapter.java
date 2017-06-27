package app.codelab.dev.bogie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 27/06/2017.
 */

class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {
    private List<Result> mResults;

    ResultAdapter(final List<Result> results){
        mResults = results;
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
        holder.link.setText(result.getLink());
        holder.description.setText(result.getDescription());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    private void setupResultsList() {
        mResults = new ArrayList<>();
        mResults.add(new Result("https://github.com/NthnVrml/bogie", "description"));
        mResults.add(new Result("lien fekfn", "description effenfo"));
        mResults.add(new Result("lien fefoen", "description efojefpe"));
        mResults.add(new Result("lien pkfnzepfkn", "description ezpfnzegpnze"));
        mResults.add(new Result("lien zefkiabhaiai", "description oeooeoeoe"));
        mResults.add(new Result("lien eoej ", "descriptio neoen n"));
        mResults.add(new Result("lien   eoneon ", "description eobibfzpoeih"));
        mResults.add(new Result("lien fefoen", "description efojefpe"));
        mResults.add(new Result("lien pkfnzepfkn", "description ezpfnzegpnze"));
        mResults.add(new Result("lien zefkiabhaiai", "description oeooeoeoe"));
        mResults.add(new Result("lien eoej ", "descriptio neoen n"));
        mResults.add(new Result("lien   eoneon ", "description eobibfzpoeih"));
        mResults.add(new Result("lien fefoen", "description efojefpe"));
        mResults.add(new Result("lien pkfnzepfkn", "description ezpfnzegpnze"));
        mResults.add(new Result("lien zefkiabhaiai", "description oeooeoeoe"));
        mResults.add(new Result("lien eoej ", "descriptio neoen n"));
        mResults.add(new Result("lien   eoneon ", "description eobibfzpoeih"));
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView link, description;

        MyViewHolder(final View view) {
            super(view);
            link = (TextView) view.findViewById(R.id.result_item_link);
            description = (TextView) view.findViewById(R.id.result_item_description);
        }
    }
}
