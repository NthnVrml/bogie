package app.codelab.dev.bogie;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        final TextView name = holder.name;
        final String link = result.getLink();
        final String clickableName = "<b>text3:</b>  Text with a " +
                String.format("<a href=\"%s\">link</a> ", link);


        name.setText(fromHtml(clickableName));
        name.setMovementMethod(LinkMovementMethod.getInstance());

        name.setText(result.getName());
        holder.description.setText(result.getDescription());
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html){
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
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
