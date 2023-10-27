package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ExperienceDao;

public class ExpDaoTest {
    public static void main(String[] args) {
        ExperienceDao experienceDao=new ExperienceDao();
        experienceDao.getCandByRole(1).forEach(c->System.out.println(c.toString()));
    }
}
