package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateForSave(Burger burger) {
        validateCommon(burger);
    }

    public static void validateForUpdate(Burger burger) {
        if (burger.getId() == null) {
            throw new BurgerException("Id zorunlu", HttpStatus.BAD_REQUEST);
        }
        validateCommon(burger);
    }

    private static void validateCommon(Burger burger) {
        if (burger.getName() == null || burger.getName().isBlank()) {
            throw new BurgerException("Burger ismi zorunlu", HttpStatus.BAD_REQUEST);
        }
        if (burger.getPrice() == null || burger.getPrice() < 0) {
            throw new BurgerException("Burger fiyati sifirdan kucuk olamaz", HttpStatus.BAD_REQUEST);
        }
        if (burger.getBreadType() == null) {
            throw new BurgerException("Ekmek tipi zorunlu", HttpStatus.BAD_REQUEST);
        }
        if (burger.getContents() == null || burger.getContents().isBlank()) {
            throw new BurgerException("Icindekiler alanı zorunlu", HttpStatus.BAD_REQUEST);
        }
    }
}

