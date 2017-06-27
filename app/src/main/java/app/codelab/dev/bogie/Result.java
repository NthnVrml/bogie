package app.codelab.dev.bogie;

/**
 * Created by Nicolas on 27/06/2017.
 */

class Result {
    private String mLink, mDescription;

    public Result(final String link, final String description) {
        mLink = link;
        mDescription = description;
    }

    public String getLink() {
        return mLink;
    }

    public String getDescription() {
        return mDescription;
    }
}
