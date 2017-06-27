package app.codelab.dev.bogie;

import android.support.annotation.DrawableRes;

/**
 * Created by Nicolas on 27/06/2017.
 */

public class Bogie {
    private String name;
    private @DrawableRes int image;

    public Bogie(final Boogies boogies) {
        this.name = boogies.getTitle();
        this.image = boogies.getImageResource();
    }

    public String getName() {
        return name;
    }

    public @DrawableRes int getImage() {
        return image;
    }
}
