package com.jparanhos.primeiraapp;
import android.renderscript.ScriptGroup;
import android.view.View;

import java.util.Random;


public class functions {


    public static String countMe (String valor) {

        Integer count = Integer.parseInt(valor);
        count++;



        return Integer.toString(count);

    }


    public static int setRound(int count)
    {

        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }

        return  randomNumber;

    }


}
