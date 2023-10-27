package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

public class ExperienceDao {
    private EntityManager manager;

    public ExperienceDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<Candidate> getCandByRole(int role){
        List<Candidate> list=new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT DISTINCT candidate.can_id, candidate.name, candidate.email, candidate.phone \n" +
                    "FROM candidate\n" +
                    "INNER JOIN experience ON candidate.can_id=experience.can_id\n" +
                    "WHERE experience.role=?";
            Query query=manager.createNativeQuery(sql, Candidate.class);
            query.setParameter(1,role);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
}
