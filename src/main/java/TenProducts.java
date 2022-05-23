import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TenProducts", urlPatterns = "/cat")
public class TenProducts extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(TenProducts.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(i);
            product.setTitle("product "+i);
            product.setCost(i*100.0);
            resp.getWriter().printf("<h1>" + product.getId()+" || "+ product.getTitle() + " || "+ product.getCost() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }


}
