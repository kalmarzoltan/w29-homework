package com.foldik.soter.jquery.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@RestController
public class LottoController {

    private List lottoNumbers;

    @RequestMapping("/lotto")
    public String listLottoNumbers() {
        Random rnd = new Random();
        int random;
        int i, j;
        int[] lottoArray = new int[5];
        boolean isPresent;
        for (i = 0; i < 5; ) {
            isPresent = false;
            random = rnd.nextInt(90) + 1;

            for (j = 0; j < lottoArray.length; j++) {
                if (lottoArray[j] == random) {
                    isPresent = true;
                }
            }
            if (isPresent == false) {
                lottoArray[i] = random;
                i++;
            }
        }
        return "The lottoNumbers are: " + Arrays.toString(lottoArray);
    }
}


