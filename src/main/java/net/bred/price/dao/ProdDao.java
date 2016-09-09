package net.bred.price.dao;


import net.bred.price.model.Prod;
import net.bred.price.model.ProdCat;

import java.util.List;

public interface ProdDao {

    public Prod getProdById(Integer id);

    public List<Prod> listProd();

    public List<Prod> findProd(Integer cat_id, String name);


}
