package com.XAKUS;

import com.XAKUS.Display.Display;
import com.XAKUS.Game.Game;
import com.XAKUS.Game.Language;
import com.XAKUS.Sea.Sea;
import com.XAKUS.Sea.SeaResolution;
import com.XAKUS.Ship.Ships;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
         Sea.createSea(SeaResolution.R_10X10);
        Language.setLang(Language.Lang.RUSSIAN);
        Display.writeText(Language.GetLanguage(0));
        Display.writeText(Language.GetLanguage(1));

        boolean start=true;
        while (start){


            Display.writeTextAndDisplay(Language.GetLanguage(2));
            int x=Integer.parseInt(sc.next())-1;
            int y=Integer.parseInt(sc.next())-1;
            Game.atack(x,y,Sea.compMatrix, Ships.getCompShips());

        }
    }
}
