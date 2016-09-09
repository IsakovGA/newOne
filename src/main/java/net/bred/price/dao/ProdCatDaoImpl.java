package net.bred.price.dao;

import net.bred.price.model.ProdCat;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProdCatDaoImpl implements ProdCatDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<ProdCat> listProdCat () {
        Session session = this.sessionFactory.getCurrentSession();

        Query findProdCat = session.createQuery(
                "select p.id as id, k.name as cat, p.name as name, p.price as price " +
                "from Cat k, Prod p " +
                "where p.cat.id = k.id");
        List <ProdCat> listProdCat = findProdCat.setResultTransformer(Transformers.aliasToBean(ProdCat.class)).list();

        return  listProdCat;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<ProdCat> findProdCat(String catName, String name, Float minPrice, Float maxPrice) {
        Session session = this.sessionFactory.getCurrentSession();

        Query findProdCat = session.createQuery(
                "select p.id as id, k.name as cat, p.name as name, p.price as price " +
                "from Cat k, Prod p " +
                "where p.cat.id = k.id " +
                //"inner join k.id p " +
                "and k.name like '" + catName + "%' and p.name like '%" + name + "%'" +
                "and p.price > " + minPrice + " and p.price < " + maxPrice);
        List <ProdCat> listProdCat = findProdCat.setResultTransformer(Transformers.aliasToBean(ProdCat.class)).list();

        return  listProdCat;
    }
}
