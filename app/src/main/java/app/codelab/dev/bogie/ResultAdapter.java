package app.codelab.dev.bogie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
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


//        SpannableString ss1 = new SpannableString(name);
//        ss1.setSpan(new URLSpan(link),
//                0,
//                ss1.length(),
//                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        nameTextView.setText(ss1);

//        nameTextView.setText(name);
//        setTextViewHTML(nameTextView, link);


        descriptionTextView.setText(description);
        nameTextView.setText(name);
        nameTextView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
//                        mContext.startActivity(intent);
                    }
                }
        );


    }

    protected void setTextViewHTML(TextView text, String html) {
        CharSequence sequence = Html.fromHtml(html);
        SpannableStringBuilder strBuilder = new SpannableStringBuilder(sequence);
        URLSpan[] urls = strBuilder.getSpans(0, sequence.length(), URLSpan.class);
        for (URLSpan span : urls) {
            makeLinkClickable(strBuilder, span);
        }
        text.setText(strBuilder);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void makeLinkClickable(SpannableStringBuilder strBuilder, final URLSpan span) {
        int start = strBuilder.getSpanStart(span);
        int end = strBuilder.getSpanEnd(span);
        int flags = strBuilder.getSpanFlags(span);
        ClickableSpan clickable = new ClickableSpan() {
            public void onClick(View view) {
                // Do something with span.getURL() to handle the link click...
            }
        };
        strBuilder.setSpan(clickable, start, end, flags);
        strBuilder.removeSpan(span);
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
