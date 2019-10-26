package com.example.dani_.desaparecidos;

import android.text.InputFilter;
import android.text.Spanned;


public class FiltroNumeros implements InputFilter {

    private int max;

    public FiltroNumeros( int max) {

        this.max = max;
    }



    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(max, input))
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }

    private boolean isInRange(int a, int b) {
        return b < a;
    }
}