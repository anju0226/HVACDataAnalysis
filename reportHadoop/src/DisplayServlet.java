import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by anju on 7/8/16.
 */
public class DisplayServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          converter converter = new converter();
        try {

            List<Repo> rep = converter.convert();
            if(true){

                RequestDispatcher  req = request.getRequestDispatcher("/report.jsp");
                request.setAttribute("report",rep);
                req.forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
