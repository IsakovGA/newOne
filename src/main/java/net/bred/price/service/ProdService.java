package net.bred.price.service;


import net.bred.price.model.Prod;

import java.util.List;

public interface ProdService {

    public Prod getProdByID (Integer id);

    public List<Prod> listProd ();

    public List<Prod> findProd (Integer cat_id, String name);

}
