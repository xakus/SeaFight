package com.XAKUS.Game;

/**
 * Created by xakus on 23.12.2015.
 */
public class Language {
      private static Lang lang;
      private static String[][] langMass = new String[][]{
              {
                      "Hi",
                      "Привет",
                      "Salam"
              },
              {
                      "Welcome to the game SeaFight",
                      "Добро пожаловать в игру SeaFight",
                      "SeaFight Oyuna xoş gəlmisiniz"
              },
              {
                      "Please insert coord x and y",
                      "Пожалуйста введите координаты x и y",
                      "Zəhmət olmasa x və y coordinatları daxil edin"
              },
              {
                      "You lose",
                      "Ты проиграл",
                      "Sən uduzdun"
              },
              {
                      "You won",
                      "Ты выиграл",
                      "Sən qalib geldiz"
              },
              {
                      "You entered, these coordinates",
                      "Вы вводили эти координаты",
                      "Siz bu koordinatları daxil eləmisiz"
              }
      };

      public static String GetLanguage(int i) {
            return langMass[i][lang.ordinal()];
      }

      public static void setLang(Lang i) {
            lang = i;
      }

      public enum Lang {
            ENGLISH,
            RUSSIAN,
            AZERBAIJAN
      }

}
