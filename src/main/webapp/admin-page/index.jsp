<%@ page import="beans.AdminUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> Trang Quản Lý </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Place favicon.ico in the root directory -->
    <link rel="stylesheet" href="./css/vendor.css">
    <script>
        var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
        var themeName = themeSettings.themeName || '';
        if (themeName) {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
        } else {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
        }
    </script>
</head>

<body>
<%

    //----------------------Kiểm tra thử đăng nhập hay chưa--------------------//
    if (request.getSession().getAttribute("userAdmin") == null) {
        // Sendredirect tới login
        response.sendRedirect("login.jsp");

    } else {
        AdminUser admin = (AdminUser) request.getSession().getAttribute("userAdmin");
%>
<div class="main-wrapper">
    <div class="app" id="app">
        <jsp:include page="Layout/_LayoutAdminHeader.jsp"></jsp:include>
        <jsp:include page="Layout/_LayoutAdminSideBar.jsp"></jsp:include>
        <article class="content dashboard-page">
            <section class="section">
                <div class="row sameheight-container">
                    <div class="col col-12 col-sm-12 col-md-6 col-xl-5 stats-col">
                        <div class="card sameheight-item stats" data-exclude="xs">
                            <div class="card-block">
                                <div class="title-block">
                                    <h4 class="title"> Số liệu thống kê </h4>
                                </div>
                                <div class="row row-sm stats-container">
                                    <div class="col-12 col-sm-6 stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-rocket"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value">20
                                            </div>
                                            <div class="name"> Sản phẩm hoạt động</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 75%;"></div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6 stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-shopping-cart"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value">5630</div>
                                            <div class="name"> Lượt xem sản phẩm</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 25%;"></div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6  stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-line-chart"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value"> $80.560</div>
                                            <div class="name"> Doanh thu tháng này</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 60%;"></div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6  stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-users"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value">30
                                            </div>
                                            <div class="name"> Tài khoản người dùng</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 34%;"></div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6  stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-list-alt"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value"> 20</div>
                                            <div class="name"> Bài báo tin tức</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 49%;"></div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6 stat-col">
                                        <div class="stat-icon">
                                            <i class="fa fa-dollar"></i>
                                        </div>
                                        <div class="stat">
                                            <div class="value"> $780.064</div>
                                            <div class="name"> Tổng doanh thu</div>
                                        </div>
                                        <div class="progress stat-progress">
                                            <div class="progress-bar" style="width: 15%;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col col-12 col-sm-12 col-md-6 col-xl-7 history-col">
                        <div class="card sameheight-item" data-exclude="xs" id="dashboard-history">
                            <div class="card-header card-header-sm bordered">
                                <div class="header-block">
                                    <h3 class="title">Lịch sử ghé thăm</h3>
                                </div>
                            </div>
                            <div class="card-block">
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active fade show" id="visits">
                                        <p class="title-description"> Trung bình số người dùng ghé thăm trang web trong
                                            vòng 30 ngày </p>
                                        <div id="dashboard-visits-chart"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </article>
    </div>
</div>
<!-- Reference block for JS -->
<div class="ref" id="ref">
    <div class="color-primary"></div>
    <div class="chart">
        <div class="color-primary"></div>
        <div class="color-secondary"></div>
    </div>
</div>
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
    ga('create', 'UA-80463319-4', 'auto');
    ga('send', 'pageview');
</script>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/vendor.js"></script>
<script src="js/app.js"></script>
</body>

</html>
<%}%>