package com.XAKUS.Game;

/**
 * Created by xakus on 23.12.2015.
 */
public class Language {
   private static Lang lang ;
    private static String[][] langMass = new String[][]{{"Hi", "Welcome to the game SeaFight", "Please insert coord x and y"},
            {"Привет", "Добро пожаловать в игру SeaFight", "Пожалуйста введите координаты x и y"},
            {"Salam", "SeaFight Oyuna xoş gəlmisiniz", "Zəhmət olmasa coordinatları  x və y daxil edin"}};


    public static String GetLanguage(int i){
        return  langMass[lang.ordinal()][i];
    }

    public static void setLang(Lang i){
        lang=i;
    }

    public enum Lang {
        ENGLISH,
        RUSSIAN,
        AZERBAIJAN
    }

}
