package services;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import beans.order.OrderDetail;

import java.util.List;

public class OrderDetailService {
    private static OrderDetailService orderDetailService;

    public static OrderDetailService getInstance() {
        if (orderDetailService == null) {
            orderDetailService = new OrderDetailService();
        }
        return orderDetailService;
    }

    public void insertOrderDetail(String ord_id, String prod_id, String prod_name, String prod_color,
                                  String prod_size, int quantity, double price) {
        new OrderDetailDAO().insertOrderDetail(ord_id, prod_id, prod_name, prod_color, prod_size, quantity, price);
    }

    //4.2.	Service gọi đến lớp OrderDetailDAO lấy dữ liệutương ứng.
    public List<OrderDetail> getListDetailsFromOrdId(String id) {
        //4.4.	DAO trả dữ liệu tương ứng cho Service.
        return new OrderDetailDAO().getListDetailsFromOrdId(id);
    }

    public void removeOrder(String ord_id) {
        new OrderDAO().removeOrder(ord_id);
    }

    public void hardRemoveOrder(String id) {
        new OrderDAO().hardRemoveOrder(id);
    }

    public void rollbackOrder(String id) {
        new OrderDAO().rollbackOrder(id);
    }
}

