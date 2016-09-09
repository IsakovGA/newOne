package net.bred.price.dao;

import net.bred.price.model.Prod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdDaoImpl implements ProdDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Prod getProdById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Prod prod = (Prod) session.load(Prod.class,id);
        return prod;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Prod> listProd() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Prod> listProd = session.createQuery("from Prod").list();
        return listProd;
    }

    @Override
    public List<Prod> findProd(Integer cat_id, String name) {
        Session session = this.sessionFactory.getCurrentSession();
        //String cat = new Integer(cat_id).toString();
        List<Prod> findProd = session.createQuery("from Prod p where p.catId = '" + cat_id.toString() + "' and p.name like '%" + name + "%'").list();
        return  findProd;
    }

}
