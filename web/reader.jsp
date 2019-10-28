<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="page">
    <div class="page">
        <!-- Main Navbar-->
        <jsp:include page="header_template.jsp" flush="true"></jsp:include>
        <div class="page-content d-flex align-items-stretch">
            <!-- Side Navbar -->
            <jsp:include page="reader_side.jsp" flush="true"></jsp:include>
            <div class="content-inner">
                <header class="page-header">
                    <div class="container-fluid">
                        <h2 class="no-margin-bottom">Home</h2>
                    </div>
                </header>

                <!-- Page Header-->
                <section class="dashboard-counts no-padding-bottom">
                    <div class="container-fluid">
                        <div class="row bg-white has-shadow">
                            <div class="col-xl-3 col-sm-6">
                                <img src="img/logo.png" height="90%" width="90%">
                            </div>
                            <!-- Item -->
                            <div class="col-xl-2 col-sm-6">
                                <div class="item d-flex align-items-center">
                                    <div class="icon bg-violet"><i class="icon-user"></i></div>
                                    <div class="title"><span>New<br>Readers</span>
                                        <div class="progress">
                                            <div role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25"
                                                 aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-violet"></div>
                                        </div>
                                    </div>
                                    <div class="number"><strong>25</strong></div>
                                </div>
                            </div>
                            <!-- Item -->
                            <div class="col-xl-3 col-sm-6">
                                <div class="item d-flex align-items-center">
                                    <div class="icon bg-red"><i class="icon-padnote"></i></div>
                                    <div class="title"><span>Borrow<br>Businesses</span>
                                        <div class="progress">
                                            <div role="progressbar" style="width: 13%; height: 4px;" aria-valuenow="13"
                                                 aria-valuemin="0" aria-valuemax="100" class="progress-bar bg-red"></div>
                                        </div>
                                    </div>
                                    <div class="number"><strong>13</strong></div>
                                </div>
                            </div>
                            <!-- Item -->
                            <div class="col-xl-2 col-sm-6">
                                <div class="item d-flex align-items-center">
                                    <div class="icon bg-green"><i class="icon-bill"></i></div>
                                    <div class="title"><span>Borrowed<br>Books</span>
                                        <div class="progress">
                                            <div role="progressbar" style="width: 41%; height: 4px;" aria-valuenow="410"
                                                 aria-valuemin="0" aria-valuemax="1000" class="progress-bar bg-green"></div>
                                        </div>
                                    </div>
                                    <div class="number"><strong>410</strong></div>
                                </div>
                            </div>
                            <!-- Item -->
                            <div class="col-xl-3 col-sm-5">
                                <div class="item d-flex align-items-center">
                                    <div class="icon bg-orange"><i class="icon-check"></i></div>
                                    <div class="title"><span>Open<br>Cases</span>
                                        <div class="progress">
                                            <div role="progressbar" style="width: 50%; height: 4px;" aria-valuenow="50"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 class="progress-bar bg-orange"></div>
                                        </div>
                                    </div>
                                    <div class="number"><strong>50</strong></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Dashboard Header Section    -->
                <section class="dashboard-header">
                    <div class="container-fluid">
                        <div class="row">
                            <!-- Statistics -->
                            <div class="statistics col-lg-3 col-12">
                                <div class="statistic d-flex align-items-center bg-white has-shadow">
                                    <div class="icon bg-red"><i class="fa fa-tasks"></i></div>
                                    <div class="text"><strong>234</strong><br>
                                        <small>Applications</small>
                                    </div>
                                </div>
                                <div class="statistic d-flex align-items-center bg-white has-shadow">
                                    <div class="icon bg-green"><i class="fa fa-calendar-o"></i></div>
                                    <div class="text"><strong>152</strong><br>
                                        <small>Interviews</small>
                                    </div>
                                </div>
                                <div class="statistic d-flex align-items-center bg-white has-shadow">
                                    <div class="icon bg-orange"><i class="fa fa-paper-plane-o"></i></div>
                                    <div class="text"><strong>147</strong><br>
                                        <small>Forwards</small>
                                    </div>
                                </div>
                            </div>
                            <!-- Line Chart            -->
                            <div class="chart col-lg-6 col-12">
                                <div class="line-chart bg-white d-flex align-items-center justify-content-center has-shadow">
                                    <canvas id="lineCahrt"></canvas>
                                </div>
                            </div>
                            <div class="chart col-lg-3 col-12">
                                <!-- Bar Chart   -->
                                <div class="bar-chart has-shadow bg-white">
                                    <div class="title"><strong class="text-violet">95%</strong><br>
                                        <small>Current Server
                                            Uptime
                                        </small>
                                    </div>
                                    <canvas id="barChartHome"></canvas>
                                </div>
                                <!-- Numbers-->
                                <div class="statistic d-flex align-items-center bg-white has-shadow">
                                    <div class="icon bg-green"><i class="fa fa-line-chart"></i></div>
                                    <div class="text"><strong>99.9%</strong><br>
                                        <small>Success Rate</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Projects Section-->
                <section class="projects no-padding-top">
                    <div class="container-fluid">
                        <!-- Project-->
                        <div class="project">
                            <div class="row bg-white has-shadow">
                                <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                                    <div class="project-title d-flex align-items-center">
                                        <div class="image has-shadow"><img src="img/project-1.jpg" alt="..."
                                                                           class="img-fluid"></div>
                                        <div class="text">
                                            <h3 class="h4">Project Title</h3>
                                            <small>Lorem Ipsum Dolor</small>
                                        </div>
                                    </div>
                                    <div class="project-date"><span class="hidden-sm-down">Today at 4:24 AM</span></div>
                                </div>
                                <div class="right-col col-lg-6 d-flex align-items-center">
                                    <div class="time"><i class="fa fa-clock-o"></i>12:00 PM</div>
                                    <div class="comments"><i class="fa fa-comment-o"></i>20</div>
                                    <div class="project-progress">
                                        <div class="progress">
                                            <div role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 class="progress-bar bg-red"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Project-->
                        <div class="project">
                            <div class="row bg-white has-shadow">
                                <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                                    <div class="project-title d-flex align-items-center">
                                        <div class="image has-shadow"><img src="img/project-2.jpg" alt="..."
                                                                           class="img-fluid"></div>
                                        <div class="text">
                                            <h3 class="h4">Project Title</h3>
                                            <small>Lorem Ipsum Dolor</small>
                                        </div>
                                    </div>
                                    <div class="project-date"><span class="hidden-sm-down">Today at 4:24 AM</span></div>
                                </div>
                                <div class="right-col col-lg-6 d-flex align-items-center">
                                    <div class="time"><i class="fa fa-clock-o"></i>12:00 PM</div>
                                    <div class="comments"><i class="fa fa-comment-o"></i>20</div>
                                    <div class="project-progress">
                                        <div class="progress">
                                            <div role="progressbar" style="width: 60%; height: 6px;" aria-valuenow="25"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 class="progress-bar bg-green"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Project-->
                        <div class="project">
                            <div class="row bg-white has-shadow">
                                <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                                    <div class="project-title d-flex align-items-center">
                                        <div class="image has-shadow"><img src="img/project-3.jpg" alt="..."
                                                                           class="img-fluid"></div>
                                        <div class="text">
                                            <h3 class="h4">Project Title</h3>
                                            <small>Lorem Ipsum Dolor</small>
                                        </div>
                                    </div>
                                    <div class="project-date"><span class="hidden-sm-down">Today at 4:24 AM</span></div>
                                </div>
                                <div class="right-col col-lg-6 d-flex align-items-center">
                                    <div class="time"><i class="fa fa-clock-o"></i>12:00 PM</div>
                                    <div class="comments"><i class="fa fa-comment-o"></i>20</div>
                                    <div class="project-progress">
                                        <div class="progress">
                                            <div role="progressbar" style="width: 50%; height: 6px;" aria-valuenow="25"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 class="progress-bar bg-violet"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Project-->
                        <div class="project">
                            <div class="row bg-white has-shadow">
                                <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">
                                    <div class="project-title d-flex align-items-center">
                                        <div class="image has-shadow"><img src="img/project-4.jpg" alt="..."
                                                                           class="img-fluid"></div>
                                        <div class="text">
                                            <h3 class="h4">Project Title</h3>
                                            <small>Lorem Ipsum Dolor</small>
                                        </div>
                                    </div>
                                    <div class="project-date"><span class="hidden-sm-down">Today at 4:24 AM</span></div>
                                </div>
                                <div class="right-col col-lg-6 d-flex align-items-center">
                                    <div class="time"><i class="fa fa-clock-o"></i>12:00 PM</div>
                                    <div class="comments"><i class="fa fa-comment-o"></i>20</div>
                                    <div class="project-progress">
                                        <div class="progress">
                                            <div role="progressbar" style="width: 50%; height: 6px;" aria-valuenow="25"
                                                 aria-valuemin="0" aria-valuemax="100"
                                                 class="progress-bar bg-orange"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Client Section-->
                <section class="client no-padding-top">
                    <div class="container-fluid">
                        <div class="row">
                            <!-- Work Amount  -->
                            <div class="col-lg-4">
                                <div class="work-amount card">
                                    <div class="card-close">
                                        <div class="dropdown">
                                            <button type="button" id="closeCard1" data-toggle="dropdown"
                                                    aria-haspopup="true" aria-expanded="false" class="dropdown-toggle">
                                                <i
                                                        class="fa fa-ellipsis-v"></i></button>
                                            <div aria-labelledby="closeCard1"
                                                 class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                         class="dropdown-item remove">
                                                <i class="fa fa-times"></i>Close</a><a href="#"
                                                                                       class="dropdown-item edit">
                                                <i class="fa fa-gear"></i>Edit</a></div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <h3>Work Hours</h3><small>Lorem ipsum dolor sit amet.</small>
                                        <div class="chart text-center">
                                            <div class="text"><strong>90</strong><br><span>Hours</span></div>
                                            <canvas id="pieChart"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tlinks">Collect from <a href="http://www.cssmoban.com/" title="网站模板">网站模板</a>
                            </div>
                            <!-- Client Profile -->
                            <div class="col-lg-4">
                                <div class="client card">
                                    <div class="card-close">
                                        <div class="dropdown">
                                            <button type="button" id="closeCard2" data-toggle="dropdown"
                                                    aria-haspopup="true" aria-expanded="false" class="dropdown-toggle">
                                                <i
                                                        class="fa fa-ellipsis-v"></i></button>
                                            <div aria-labelledby="closeCard2"
                                                 class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                         class="dropdown-item remove">
                                                <i class="fa fa-times"></i>Close</a><a href="#"
                                                                                       class="dropdown-item edit">
                                                <i class="fa fa-gear"></i>Edit</a></div>
                                        </div>
                                    </div>
                                    <div class="card-body text-center">
                                        <div class="client-avatar"><img src="img/avatar-2.jpg" alt="..."
                                                                        class="img-fluid rounded-circle">
                                            <div class="status bg-green"></div>
                                        </div>
                                        <div class="client-title">
                                            <h3>Jason Doe</h3><span>Web Developer</span><a href="#">Follow</a>
                                        </div>
                                        <div class="client-info">
                                            <div class="row">
                                                <div class="col-4"><strong>20</strong><br><small>Photos</small></div>
                                                <div class="col-4"><strong>54</strong><br><small>Videos</small></div>
                                                <div class="col-4"><strong>235</strong><br><small>Tasks</small></div>
                                            </div>
                                        </div>
                                        <div class="client-social d-flex justify-content-between"><a href="#"
                                                                                                     target="_blank"><i
                                                class="fa fa-facebook"></i></a><a href="#" target="_blank"><i
                                                class="fa fa-twitter"></i></a><a href="#" target="_blank"><i
                                                class="fa fa-google-plus"></i></a><a href="#" target="_blank"><i
                                                class="fa fa-instagram"></i></a><a href="#" target="_blank"><i
                                                class="fa fa-linkedin"></i></a></div>
                                    </div>
                                </div>
                            </div>
                            <!-- Total Overdue             -->
                            <div class="col-lg-4">
                                <div class="overdue card">
                                    <div class="card-close">
                                        <div class="dropdown">
                                            <button type="button" id="closeCard3" data-toggle="dropdown"
                                                    aria-haspopup="true" aria-expanded="false" class="dropdown-toggle">
                                                <i
                                                        class="fa fa-ellipsis-v"></i></button>
                                            <div aria-labelledby="closeCard3"
                                                 class="dropdown-menu dropdown-menu-right has-shadow"><a href="#"
                                                                                                         class="dropdown-item remove">
                                                <i class="fa fa-times"></i>Close</a><a href="#"
                                                                                       class="dropdown-item edit">
                                                <i class="fa fa-gear"></i>Edit</a></div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <h3>Total Overdue</h3><small>Lorem ipsum dolor sit amet.</small>
                                        <div class="number text-center">$20,000</div>
                                        <div class="chart">
                                            <canvas id="lineChart1"></canvas>
                                        </div>
                                    </div>
                                    <div class="number"><strong>210</strong></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <!-- search -->
                <form class="input-group col-md-12" style="margin-top: 40px; position: relative" action="ReaderSearchServlet"
                      name="search" method="post">
                <span class="input-group-btn">
                    <select  name="signal" class="btn btn-info btn-search">
                        <option>Name</option>
                        <option>ID</option>
                        <option>Author</option>
                    </select>
                </span>
                    <input type="text" class="form-control" name="message"
                           placeholder="Please enter the content you are searching for">
                    <a href="ReaderSearch.do">
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-info btn-search">Search</button>
                    </span>
                    </a>
                </form>

                <!-- notice -->
                <div style="margin-top: 40px;">
                    <h1>这里是Notice。</h1>
                </div>
                <!-- Page Footer-->
                <jsp:include page="footer.jsp" flush="true"></jsp:include>
            </div>
        </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="js/charts-home.js"></script>
    <!-- Main File-->
    <script src="js/front.js"></script>
</div>
</body>
</html>