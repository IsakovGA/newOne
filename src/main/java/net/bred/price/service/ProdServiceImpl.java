package net.bred.price.service;


import net.bred.price.dao.ProdDao;
import net.bred.price.model.Prod;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProdServiceImpl implements ProdService{

    private ProdDao prodDao;

    public void setProdDao(ProdDao prodDao) {
        this.prodDao = prodDao;
    }

    @Override
    @Transactional
    public Prod getProdByID(Integer id) {
        return this.prodDao.getProdById(id);
    }

    @Override
    @Transactional
    public List<Prod> listProd() {
        return this.prodDao.listProd();
    }

    @Override
    @Transactional
    public List<Prod> findProd(Integer cat_id, String name) {
        return this.prodDao.findProd(cat_id, name);
    }

}
