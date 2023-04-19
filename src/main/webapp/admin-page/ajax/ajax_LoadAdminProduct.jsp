<%@ page import="vn.edu.hcmuaf.fit.beans.product.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Product> next6Product = (List<Product>) request.getAttribute("next6Product");%>
<%for (Product p : next6Product) {%>
<li class="item">
  <div class="item-row">
    <div class="item-col fixed item-col-img xs">
      <a href="">
        <div class="item-img xs rounded">
          <img src="<%=p.getMain_img_link()%>" width=30px height=30px>
        </div>
      </a>
    </div>
    <div class="item-col item-col-title no-overflow">
      <div>
        <h4 class="item-title no-wrap"> <%=p.getProd_name()%></h4>
      </div>
    </div>
    <div class="item-col item-col-sales">
      <div class="item-heading"></div>
      <div> <%=p.getView_count()%> </div>
    </div>
    <div class="item-col item-col-stats">
      <div class="item-heading">Tồn kho</div>
      <div class="no-overflow">
        <div class="item-stats" data-type="bar"> <%=p.getQuantity()%></div>
      </div>
    </div>
    <div class="item-col item-col-date">
      <div class="item-heading">Ngày thêm</div>
      <div> <%=p.getReleased_date()%> </div>
    </div>
  </div>
</li>
<%}%>
