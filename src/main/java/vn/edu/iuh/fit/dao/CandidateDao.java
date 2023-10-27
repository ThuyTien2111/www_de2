package vn.edu.iuh.fit.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Experience;

import java.util.ArrayList;
import java.util.List;

public class CandidateDao {
    private EntityManager manager;

    public CandidateDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Candidate candidate, Experience experience){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            manager.merge(candidate);
            experience.setCandidate(candidate);
            manager.persist(experience);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
        }
        return false;
    }
    public List<Candidate> getAll(){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            return manager.createQuery("select c from Candidate c", Candidate.class).getResultList();
        }catch (Exception e){
            tr.rollback();
        }
        return null;
    }
    public Candidate getCandByID(long id){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            return manager.find(Candidate.class, id);
        }catch (Exception e){
            tr.rollback();
        }
        return null;
    }
    public List<Experience> getDetailOfCandidate(long candID){
        List<Experience> list=new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT * FROM experience\n" +
                    "WHERE can_id=?";
            Query query=manager.createNativeQuery(sql, Experience.class);
            query.setParameter(1,candID);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    public List<Candidate> getCandidateUseGmail(){
        List<Candidate> list=new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql= "SELECT *\n" +
                    "FROM candidate\n" +
                    "WHERE email LIKE '%gmail%'";
            list= manager.createNativeQuery(sql, Candidate.class).getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
}
