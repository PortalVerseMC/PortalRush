package com.bloobon.portalrush.portalrush.teams;

import java.util.Locale;

public enum TeamColor {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    ORANGE,
    GRAY,
    WHITE,
    BROWN;

    public String getName(){
        String c = this.toString();
        return c.substring(0, 0) + c.substring(1).toLowerCase(Locale.ENGLISH);
    }
}
