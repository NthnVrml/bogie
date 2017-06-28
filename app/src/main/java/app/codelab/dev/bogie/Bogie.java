package app.codelab.dev.bogie;

import android.support.annotation.DrawableRes;

/**
 * Created by Nicolas on 27/06/2017.
 */

public class Bogie {
    private String name;
    private @DrawableRes int image;
    private @DrawableRes int imageBackGround;

    public Bogie(final Boogies boogies) {
        this.name = boogies.getTitle();
        this.image = boogies.getImageResource();
        this.imageBackGround = boogies.getImageBackground();
    }

    public String getName() {
        return name;
    }

    public @DrawableRes int getImage() {
        return image;
    }

    public int getImageBackGround() {
        return imageBackGround;
    }
}
