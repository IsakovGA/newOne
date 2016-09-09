package net.bred.price.dao;


import net.bred.price.model.Cat;

public interface CatDao {

    public Cat getCatById (Integer id);

    public Cat getCatByName (String name);
}
