package com.sncf.android.internal.codelab2017.app4;

import android.support.annotation.DrawableRes;

import app.codelab.dev.bogie.R;

/**
 * Created by Nicolas on 27/06/2017.
 */

public enum Boogies {
    DPF("DPF", R.drawable.logo_bogie_dpf, R.drawable.trianglify_gris_selector),
    EXTERNALISATION("EXTERNALISATION", R.drawable.logo_bogie_externalisation, R.drawable.trianglify_bleu_primaire_selector),
    SMQ("SMQ",R.drawable.logo_bogie_smq, R.drawable.trianglify_violet_selector),
    MOET("MOET", R.drawable.logo_bogie_moet, R.drawable.trianglify_orange_selector),
    SECURITE("SECURITE",R.drawable.logo_securite, R.drawable.trianglify_rouge_assistance_selector),
    ENV("ENVIRONNEMENT",R.drawable.logo_environnement, R.drawable.trianglify_vert_pomme_selector),
    IP_MED("IP MED",R.drawable.iep_mediteranee, R.drawable.trianglify_bleu_primaire_selector);


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
