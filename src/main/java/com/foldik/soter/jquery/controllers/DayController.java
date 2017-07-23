package com.foldik.soter.jquery.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DayController {

    private String day;
    private int daynumber;

    @RequestMapping("/day")
    public String checkTheDay() {

        Date d = new Date();
        //System.out.print(d + "\n");
        int daynumber = d.getDay();
        //System.out.println(daynumber);

        switch (daynumber) {
            case 0:

                day = "Vasárnap, pihi";
                break;
            case 1:

                day = "Hétfő, banzai";
                break;
            case 2:

                day = "Kedd";
                break;
            case 3:

                day = "Szerda";
                break;
            case 4:

                day = "Csütörtök";
                break;
            case 5:

                day = "Péntek, heti riport";
                break;
            case 6:

                day = "Szombat, pihi";
                break;
        }
        return (day);


    }
}
