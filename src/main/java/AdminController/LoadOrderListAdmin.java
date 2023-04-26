package AdminController;

import beans.order.Order;
import services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadOrderListAdmin", value = "/LoadOrderListAdmin")
public class LoadOrderListAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    /*
    Load more danh sách đơn hàng trong admin - Đinh Huy Hoàng 20130265
    */
    @Override
    // 2.6.2.	Lấy dữ liệu theo yêu cầu từ OrderService.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String search = request.getParameter("search");
        String order = request.getParameter("order");
        // 2.6.6.	Service trả danh sách6 đơn hàng tương ứng cho lớp xử lý.
        List<Order> orderList = OrderService.getInstance().getOrderListCondition(page, order, search);
        request.setAttribute("orders", orderList);
        // 2.6.7.	Lớp xử lý hiển thị danh sách 6 đơn hàng trước đó hoặc tiếp theo lên giao diện.
        request.getRequestDispatcher("/admin-page/ajax/ajax_LoadOrderListAdmin.jsp").forward(request, response);
    }
}
