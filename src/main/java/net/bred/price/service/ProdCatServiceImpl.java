package net.bred.price.service;

import net.bred.price.dao.ProdCatDao;
import net.bred.price.model.ProdCat;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class ProdCatServiceImpl implements ProdCatService {

    private ProdCatDao prodCatDao;

    public void setProdCatDao (ProdCatDao prodCatDao) {
        this.prodCatDao = prodCatDao;
    }

    @Override
    @Transactional
    public List<ProdCat> findProdCat (String catName, String name, Float minPrice, Float maxPrice) {
        return this.prodCatDao.findProdCat(catName,name,minPrice,maxPrice);
    }

    @Override
    @Transactional
    public List<ProdCat> listProdCat () {
        return this.prodCatDao.listProdCat();
    }
}
