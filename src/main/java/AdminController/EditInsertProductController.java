package AdminController;

import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "EditInsertProductController", value = "/EditInsertProductController")
public class EditInsertProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /*
       Thêm/sửa product trong admin - Nguyen Chi Thanh 20130403 / Le Minh Nhat 20130350
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String price = request.getParameter("price");
        int status = Integer.parseInt(request.getParameter("status"));
        String[] stringSize = request.getParameterValues("size[]");
        String[] stringColor = request.getParameterValues("color[]");
        String idCate = request.getParameter("idCate");
        String desc = request.getParameter("desc");
        String content = request.getParameter("content");
        String[] imgFile = request.getParameterValues("imgFile[]");
        String oldImg = request.getParameter("oldImg");
        System.out.println(oldImg);
        if (id.length() < 1) {
            ProductService.getInstance().InsertNewProduct(name, price, status, userid, quantity, stringSize, stringColor, idCate, desc, content, imgFile);
            removeOldImg(oldImg, request);

            //7. Gọi đến ProductService để cập nhật sản phẩm tương ứng
        } else {
            ProductService.getInstance().UpdateProduct(id, name, price, status, userid, quantity, stringSize, stringColor, idCate, desc, content, imgFile);
            removeOldImg(oldImg, request);
        }
    }

    private void removeOldImg(String oldImg, HttpServletRequest request) {
        if (oldImg.length() > 0) {
            String[] splited = oldImg.split(",");
            System.out.println(Arrays.toString(splited));
            for (String split : splited) {
                File fileInServer = new File(request.getServletContext().getAttribute("TEMPPRODUCT_DIR") + File.separator + split);
                if (fileInServer.exists())
                    fileInServer.delete();
            }
        }
    }
}
