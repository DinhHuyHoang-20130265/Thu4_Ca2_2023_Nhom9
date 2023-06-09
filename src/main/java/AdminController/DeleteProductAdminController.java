package AdminController;

import beans.Product;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProductAdminController", value = "/DeleteProductAdminController")
public class DeleteProductAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    /*
       Xóa sản phẩm trong admin - Le Minh Nhat 20130350
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int page = Integer.parseInt(request.getParameter("page"));
        String orderby = request.getParameter("orderby");
        String search = request.getParameter("search");
        ProductService.getInstance().RemoveProduct(id);
        List<Product> products = ProductService.getInstance().loadProductWithConditionContainsStatus(page, 6, orderby, "all", null, null, null, search);
        request.setAttribute("product", products);
        request.getRequestDispatcher("/admin-page/ajax/ajax_LoadProductListAdminProduct.jsp").forward(request, response);
    }
}
