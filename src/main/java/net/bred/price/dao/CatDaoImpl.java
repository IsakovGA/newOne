package net.bred.price.dao;


import net.bred.price.model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CatDaoImpl implements CatDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cat getCatById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cat cat = (Cat) session.load(Cat.class,id);
        return cat;
    }

    @Override
    public Cat getCatByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Cat cat = (Cat) session.load(Cat.class,name);
        return cat;
    }
}
