package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BurgerController {

    private final BurgerDao burgerDao;

    @GetMapping("/burger")
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/burger/{id}")
    public Burger findById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping("/burger")
    public Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping("/burger")
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/burger/{id}")
    public Burger remove(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/burger/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/burger/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/burger/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }
}

