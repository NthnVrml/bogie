package app.codelab.dev.bogie;

import android.support.annotation.DrawableRes;

/**
 * Created by Nicolas on 27/06/2017.
 */

public enum Boogies {
    DPF("DPF", R.drawable.logo_bogie_dpf, R.drawable.trianglify_framboise_selector),
    EXTERNALISATION("EXTERNALISATION", R.drawable.logo_bogie_externalisation, R.drawable.trianglify_bleu_canard),
    SMQ("SMQ",R.drawable.logo_bogie_smq, R.drawable.trianglify_bleu_canard),
    MOET("MOET", R.drawable.logo_bogie_moet, R.drawable.trianglify_bleu_canard),
    SECURITE("SECURITE",R.drawable.bogie_square, R.drawable.trianglify_bleu_canard),
    ENV("ENVIRONEMENT",R.drawable.bogie_square, R.drawable.trianglify_bleu_canard);


    private String title;
    private @DrawableRes int imageResource;
    private @DrawableRes int imageBackground;

    Boogies(String title, int imageResource, int imageBackground) {
        this.title = title;
        this.imageResource = imageResource;
        this.imageBackground = imageBackground;
    }


    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getImageBackground() {
        return imageBackground;
    }
}
