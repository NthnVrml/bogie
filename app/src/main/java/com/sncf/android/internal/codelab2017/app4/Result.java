package com.sncf.android.internal.codelab2017.app4;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Nicolas on 27/06/2017.
 */

@IgnoreExtraProperties
class Result {
    private String bogie;
    private String name;
    private String link;
    private String description;

    public Result() {
    }

    public Result(final String plink, final String pdescription) {
        link = plink;
        description = pdescription;
    }

    public Result(String bogie, String name, String link, String description) {
        this.bogie = bogie;
        this.name = name;
        this.link = link;
        this.description = description;
    }

    public String getBogie() {
        return bogie;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }
}
