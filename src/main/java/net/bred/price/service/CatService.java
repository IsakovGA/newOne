package net.bred.price.service;


import net.bred.price.model.Cat;

public interface CatService {

    public Cat getCatById (Integer id);

    public Cat getCatByName (String name);
}
