<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="sidebar">
    <div class="sidebar-container">
        <div class="sidebar-header">
            <div class="brand">
                <div class="logo">
                    <span class="l l1"></span>
                    <span class="l l2"></span>
                    <span class="l l3"></span>
                    <span class="l l4"></span>
                    <span class="l l5"></span>
                </div>
                Quản Lý
            </div>
        </div>
        <%String requestString = request.getRequestURL().toString();%>
        <nav class="menu">
            <ul class="sidebar-menu metismenu" id="sidebar-menu">
                <li class="<%=requestString.indexOf("index.jsp") != -1 ? "active" : ""%>">
                    <a href="index.jsp">
                        <i class="fa fa-home"></i> Tổng quan </a>
                </li>
                <li class="<%=(requestString.indexOf("index.jsp") == -1 && requestString.indexOf("charts-morris.jsp") == -1 && requestString.indexOf("static-tables.jsp") == -1) ? "active" : ""%>">
                    <a href="#">
                        <i class="fa fa-th-large"></i> Quản Lý Đối Tượng
                        <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li class="<%=(requestString.indexOf("item") != -1) ? "active open" : "" %>">
                            <a href="#"> Sản phẩm<i class="fa arrow"></i></a>
                            <ul class="sidebar-nav">
                                <li>
                                    <%-- Bước 1.	Admin chọn "Danh sách sản phẩm " ở menu bên trái.--%>
                                    <%-- Bước 2.    Trang web chuyển giao diện đến trang danh sách đơn hàng.--%>
                                    <a href="items-list.jsp"> Danh sách sản phẩm </a>
                                </li>

                                <li>
                                    <a href="item-editor.jsp"> Chỉnh sửa sản phẩm </a>
                                </li>
                            </ul>
                        </li>
                        <li class="<%=(requestString.indexOf("post") != -1) ? "active open" : "" %>">
                            <a href="#"> Bài báo <i class="fa arrow"></i></a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="posts-list.jsp"> Danh sách bài báo </a>
                                </li>
                                <li>
                                    <a href="post-editor.jsp"> Chỉnh sửa bài báo</a>
                                </li>
                            </ul>
                        </li>
                        <li class="<%=(requestString.indexOf("order") != -1) ? "active open" : "" %>">
                            <a href="#"> Đơn hàng <i class="fa arrow"></i></a>
                            <ul class="sidebar-nav">
                                <li>

                                    <a href="orders-list.jsp"> Danh sách đơn hàng </a>

                                </li>
                            </ul>
                        </li>
                        <li class="<%=(requestString.indexOf("user") != -1) ? "active open" : "" %>">
                            <a href="#"> Người dùng <i class="fa arrow"></i></a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="users-list.jsp"> Danh sách người dùng </a>
                                </li>
                                <li>
                                    <a href="user-editor.jsp"> Chỉnh sửa thông tin người dùng</a>
                                </li>
                            </ul>
                        </li>
                        <li class="<%=(requestString.indexOf("promotion") != -1) ? "active open" : "" %>">
                            <a href="#"> Khuyến mãi <i class="fa arrow"></i></a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="promotion-list.jsp"> Danh sách khuyến mãi </a>
                                </li>
                                <li>
                                    <a href="promotion-editor.jsp"> Chỉnh sửa thông tin khuyến mãi </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <footer class="sidebar-footer">
        <ul class="sidebar-menu metismenu" id="customize-menu">
            <li>
                <ul>
                    <li class="customize">
                        <div class="customize-item">
                            <div class="row customize-header">
                                <div class="col-4"></div>
                                <div class="col-4">
                                    <label class="title">Cố dịnh</label>
                                </div>
                                <div class="col-4">
                                    <label class="title">Linh hoạt</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <label class="title">Thanh công cụ:</label>
                                </div>
                                <div class="col-4">
                                    <label>
                                        <input class="radio" type="radio" name="sidebarPosition"
                                               value="sidebar-fixed">
                                        <span></span>
                                    </label>
                                </div>
                                <div class="col-4">
                                    <label>
                                        <input class="radio" type="radio" name="sidebarPosition" value="">
                                        <span></span>
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <label class="title">Tiêu đề:</label>
                                </div>
                                <div class="col-4">
                                    <label>
                                        <input class="radio" type="radio" name="headerPosition"
                                               value="header-fixed">
                                        <span></span>
                                    </label>
                                </div>
                                <div class="col-4">
                                    <label>
                                        <input class="radio" type="radio" name="headerPosition" value="">
                                        <span></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="customize-item">
                            <ul class="customize-colors">
                                <li>
                                    <span class="color-item color-red" data-theme="red"></span>
                                </li>
                                <li>
                                    <span class="color-item color-orange" data-theme="orange"></span>
                                </li>
                                <li>
                                    <span class="color-item color-green active" data-theme=""></span>
                                </li>
                                <li>
                                    <span class="color-item color-seagreen" data-theme="seagreen"></span>
                                </li>
                                <li>
                                    <span class="color-item color-blue" data-theme="blue"></span>
                                </li>
                                <li>
                                    <span class="color-item color-purple" data-theme="purple"></span>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
                <a href="">
                    <i class="fa fa-cog"></i> Sửa đổi giao diện </a>
            </li>
        </ul>
    </footer>
</aside>
<div class="sidebar-overlay" id="sidebar-overlay"></div>
<div class="sidebar-mobile-menu-handle" id="sidebar-mobile-menu-handle"></div>
<div class="mobile-menu-handle"></div>