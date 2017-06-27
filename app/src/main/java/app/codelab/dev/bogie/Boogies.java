package app.codelab.dev.bogie;

import android.support.annotation.DrawableRes;

/**
 * Created by Nicolas on 27/06/2017.
 */

public enum Boogies {
    DPF("DPF", R.drawable.logo_bogie_dpf),
    EXTERNALISATION("EXTERNALISATION", R.drawable.logo_bogie_externalisation),
    SMQ("SMQ",R.drawable.logo_bogie_smq),
    MOET("MOET", R.drawable.logo_bogie_moet);


    private String title;
    private @DrawableRes int imageResource;

    Boogies(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
