package AdminController;

import services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateOrderStatus", value = "/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
    Cập nhật trạng thái đặt hàng trong admin - Đinh Huy Hoàng 20130258
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // 6.	Gọi đến lớp OrderSerivce để cập nhật đơn hàng tương ứng.
        OrderService.getInstance().UpdateOrderStatus(id);
    }
}
