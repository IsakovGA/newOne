package net.bred.price.service;

import net.bred.price.model.ProdCat;

import java.util.List;


public interface ProdCatService {

    public List<ProdCat> listProdCat ();

    public List<ProdCat> findProdCat (String catName, String name, Float minPrice, Float maxPrice);
}
