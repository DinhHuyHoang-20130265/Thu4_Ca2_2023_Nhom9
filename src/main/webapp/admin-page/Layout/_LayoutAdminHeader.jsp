<%@ page import="beans.AdminUser" %>
<%@ page import="services.UserInformationService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header">
    <div class="header-block header-block-collapse d-lg-none d-xl-none">
        <button class="collapse-btn" id="sidebar-collapse-btn">
            <i class="fa fa-bars"></i>
        </button>
    </div>
    <div class="header-block header-block-search">
        <form role="search">
            <div class="input-container">
                <div class="underline"></div>
            </div>
        </form>
    </div>
    <div class="header-block header-block-nav">
        <ul class="nav-profile">
            <%
                AdminUser admin = (AdminUser) request.getSession().getAttribute("userAdmin");
            %>
            <li class="profile dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                   aria-haspopup="true" aria-expanded="false">
                    <div class="img"
                         style="background-image: url('<%=UserInformationService.getInstance().getUserInfo(admin.getId()).getAvatar_link() == null ? "http://localhost:8080/CuoiKiWeb_war/admin-page/assets/faces/8.jpg" : UserInformationService.getInstance().getUserInfo(admin.getId()).getAvatar_link()%>')">
                    </div>
                    <span class="name"> <%=admin.getUsername()%> </span>
                </a>
                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                    <a class="dropdown-item" href="/Thu4_Ca2_2023_Nhom9/LogoutAdminController">
                        <i class="fa fa-power-off icon"></i> Đăng xuất </a>
                    <a class="dropdown-item" href="profile.jsp">
                        <i class="fa fa-user icon"></i> Thông tin tài khoản </a>
                </div>
            </li>
        </ul>
    </div>
</header>
