package guest;
 
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
 
@WebServlet("/GuestServlet")
public class GuestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a database connection:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle a new guest (if any):
            String name = request.getParameter("name");
            if (name != null) {
                em.getTransaction().begin();
                em.persist(new Guest(name));
                em.getTransaction().commit();
            }
 
            // Display the list of guests:
            List<Guest> guestList = em.createQuery(
                "SELECT g FROM Guest g", Guest.class).getResultList();
            request.setAttribute("guests", guestList);
            request.getRequestDispatcher("/guest.jsp")
                .forward(request, response);
 
        } finally {
            // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}