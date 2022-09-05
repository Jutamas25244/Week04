package com.example.week04;

import org.springframework.web.bind.annotation.*;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change getChang(@PathVariable("money") int money) {
        int b1000 = 0, b500 = 0, b100 = 0, b20 = 0, b10 = 0, b5 = 0, remainder = 0;
        b1000 = Math.floorDiv(money, 1000);
        remainder = money % 1000;
        b500 = Math.floorDiv(remainder, 500);
        remainder = remainder % 500;
        b100 = Math.floorDiv(remainder, 100);
        remainder = remainder % 100;
        b20 = Math.floorDiv(remainder, 20);
        remainder = remainder % 20;
        b10 = Math.floorDiv(remainder, 10);
        remainder = remainder % 10;
        b5 = Math.floorDiv(remainder, 5);
        remainder = remainder % 5;

        return new Change(b1000, b500, b100, b20, b10, b5, remainder);
    }
}
