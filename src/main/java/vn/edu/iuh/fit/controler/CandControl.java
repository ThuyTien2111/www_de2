package vn.edu.iuh.fit.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.CandModel;

import java.io.IOException;

@WebServlet("/candControl")
public class CandControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject =req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("findCanByRole")){
                CandModel candModel=new CandModel();
                candModel.sendReqCandByRole(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject =req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("findCanByRole")){
                CandModel candModel=new CandModel();
                candModel.getCandByRole(req, resp);
            }else if(action.equals("view")){
                CandModel candModel=new CandModel();
                candModel.getDetailOfCandidate(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }    }
}
