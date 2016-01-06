package com.XAKUS.Game;

/**
 * Created by xakus on 23.12.2015.
 */
public class Language {
   private static Lang lang ;
  private static   String [][] langMass=new String[][]{{"Please insert coord x and y"}, //ENGLISH
          {"Пожалуйста введите координаты x и y"}, //РУССКИЙ
          {"Zəhmət olmasa coordinatları  x və y daxil edin"}};//AZERBAYCAN

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
