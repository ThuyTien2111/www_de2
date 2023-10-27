package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.dao.CandidateDao;
import vn.edu.iuh.fit.dao.ExperienceDao;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Experience;

import java.io.IOException;
import java.util.List;

public class CandModel {
    private final ExperienceDao experienceDao=new ExperienceDao();
    private final CandidateDao candidateDao=new CandidateDao();

    public void sendReqCandByRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int role= Integer.parseInt(request.getParameter("role"));
        response.sendRedirect("candControl?action=findCanByRole&role="+role);
    }
    public void getCandByRole(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int role= Integer.parseInt(request.getParameter("role"));
        List<Candidate> candidates=experienceDao.getCandByRole(role);
        request.setAttribute("candidates", candidates);
        request.getRequestDispatcher("candidate-by-role.jsp").forward(request, response);
    }
    public void getDetailOfCandidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long candID= Long.parseLong(request.getParameter("canID"));
        List<Experience> experiences=candidateDao.getDetailOfCandidate(candID);
        request.setAttribute("candID", candID);
        request.setAttribute("experiences", experiences);
        request.getRequestDispatcher("candidate-detail.jsp").forward(request, response);
    }
}
