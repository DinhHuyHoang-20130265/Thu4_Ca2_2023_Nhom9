package AdminController;

import beans.Product;

import services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadProductListAdminProduct", value = "/LoadProductListAdminProduct")
public class LoadProductListAdminProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    // 2.6.2. Lấy dữ liệu theo yêu cầu từ ProductService
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * Nguyen Chi Thanh - 20130265
         * Load more sản phẩm giao diện quản lý sản phẩm, kết hợp orderby và tìm kiếm
         * */
        String page = request.getParameter("page");
        String orderby = request.getParameter("orderby");
        String search = request.getParameter("search");
        // 2.6.6.	Service trả danh sách 6 sản phẩm tương ứng cho lớp xử lý.
        List<Product> products = ProductService.getInstance().loadProductWithConditionContainsStatus(Integer.parseInt(page), 6, orderby, "all", null, null, null, search);
        request.setAttribute("product", products);
       // 2.6.7. Hiển thị danh sách 6 sản phẩm tiếp theo hoặc trước đó lên giao diện
        request.getRequestDispatcher("/admin-page/ajax/ajax_LoadProductListAdminProduct.jsp").forward(request, response);
    }
}
