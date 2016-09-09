package net.bred.price.service;


import net.bred.price.dao.CatDao;
import net.bred.price.model.Cat;
import org.springframework.transaction.annotation.Transactional;

public class CatServiceImpl implements CatService{

    private CatDao catDao;

    public void setCatDao(CatDao catDao) {
        this.catDao = catDao;
    }

    @Override
    @Transactional
    public Cat getCatById(Integer id) {
        return this.catDao.getCatById(id);
    }

    @Override
    @Transactional
    public Cat getCatByName(String name) {
        return this.catDao.getCatByName(name);
    }
}
