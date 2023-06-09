package services;

import DAO.OrderDAO;
import beans.order.Order;

import java.util.List;

public class OrderService {
    private static OrderService orderService;

    public static OrderService getInstance() {
        if (orderService == null) {
            orderService = new OrderService();
        }
        return orderService;
    }

    public void insertOrder(String ord_id, int pay_ment, double total, String address, String receive_name, String email, String phone_number, String note, String customer_id) {
        new OrderDAO().insertOrder(ord_id, pay_ment, total, address, receive_name, email, phone_number, note, customer_id);
    }

    public List<Order> getOrderListByUserId(String id) {
        return new OrderDAO().getOrderListByUserId(id);
    }

    public Order getOrderById(String id) {
        return new OrderDAO().getOrderById(id);
    }

    // 2.2.	Service gọi đến lớp OrderDAO lấy dữ liệu tương ứng.
    // 2.6.3.	Service gọi đến OrderDAO lấy dữ liệu tương ứng.
    public List<Order> getOrderListCondition(String page, String order_by, String search) {
        // 2.4.	DAO trả danh sách tương ứng cho OrderService.
        // 2.6.5.	DAO trả danh sách tương ứng cho service.
        return new OrderDAO().getOrderListCondition(page, order_by, search);
    }
    //7.	Service gọi đến OrderDAO thực hiện cập nhật.
    public void UpdatePaymentStatus(String id) {
        new OrderDAO().UpdatePaymentStatus(id);
    }

    //7.	Service gọi đến OrderDAO thực hiện cập nhật.
    public void UpdateOrderStatus(String id) {
        new OrderDAO().UpdateOrderStatus(id);
    }
    //7.	Service gọi đến OrderDAO thực hiện cập nhật.
    public void UpdateDeliveryStatus(String id, String status) {
        new OrderDAO().UpdateDeliveryStatus(id, status);
    }

    public static void main(String[] args) {
        String id = new OrderDAO().generateIdOrder();
        OrderService.getInstance().insertOrder(id, 1, 31288.0, "HCM city", "Hiep sss Chai", "dskakd@gmail.com", "21388821812", "Dong hang can than", "user1");
    }

    public List<Order> getDeletedOrderListCondition(String page, String order, String search) {
        return new OrderDAO().getDeletedOrderListCondition(page, order, search);
    }
}
