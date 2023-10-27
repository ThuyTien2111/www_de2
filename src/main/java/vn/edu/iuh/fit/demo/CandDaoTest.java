package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.CandidateDao;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Experience;

import java.time.LocalDate;

public class CandDaoTest {
    public static void main(String[] args) {
        CandidateDao candidateDao=new CandidateDao();
        for (int i=0; i<=3; i++){
            System.out.println(candidateDao.add(new Candidate(10+i, "tien" +i, "tien"+i+"@gmail", "038849542"+i),
                    new Experience(18+i, "Company b"+i, LocalDate.now(), LocalDate.now(), i, "desc b"+i)));
        }
    }
}
