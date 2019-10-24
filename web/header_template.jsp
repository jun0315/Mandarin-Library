<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/23
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header">
    <nav class="navbar">
        <!-- Search Box-->
        <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
                <!-- Navbar Header-->
                <div class="navbar-header">
                    <!-- Navbar Brand --><a href="index.jsp" class="navbar-brand d-none d-sm-inline-block">
                    <div class="brand-text d-none d-lg-inline-block">
                        <span>Mandarin-</span><strong>Library</strong><span style="margin-left: 10px;">Automation</span>
                    </div>
                    <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div>
                </a>
                    <!-- Toggle Button--><a id="toggle-btn" href="#"
                                            class="menu-btn active"><span></span><span></span><span></span></a>
                </div>
                <!-- Navbar Menu -->
                <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                    <!-- Logout    -->
                    <li class="nav-item">
                        <a href="logout" class="nav-link logout">
                            <span class="d-none d-sm-inline" style="font-size: larger">Logout</span>
                            <i class="fa fa-sign-out"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
