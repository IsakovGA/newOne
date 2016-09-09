package net.bred.price.dao;


import net.bred.price.model.Prod;
import net.bred.price.model.ProdCat;

import java.util.List;

public interface ProdCatDao {

    public List<ProdCat> listProdCat ();

    public List<ProdCat> findProdCat(String catName, String name, Float minPrice, Float maxPrice);
}
