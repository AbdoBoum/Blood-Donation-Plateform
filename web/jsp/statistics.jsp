<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 28/01/2019
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="Header.jsp" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        .content-header-title{
            text-transform: uppercase;
            font-weight: 500;
            margin-top: 100px;
            margin-bottom: 20px;
            letter-spacing: 1px;
            color: #1B2942;
        }
        .icon-large{
            font-size: 3em;
        }
        .text-stat{
            font-family: Roboto, sans-serif;
        }
    </style>
</head>
<body>
<!--- Navbar -->
<%@ include file="Navbar.jsp" %>

<c:if test="${empty sessionScope.centre}">
    <c:redirect url="login"></c:redirect>
</c:if>

<!--- Contenue -->
<main>
    <div class="container">
        <h3 class="content-header-title">Current statistics</h3>
        <div class="row">
            <div class="col-xl-3 col-lg-6 col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa fa-bullhorn icon-large float-left" style="color: #008080;">
                                </i>
                            </div>
                            <div class="media-body text-right">
                                <h3 class="text-stat">${totalRequests}</h3>
                                <span class="text-stat">Requests</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa fa-calendar icon-large float-left" style="color: #800080;">
                                </i>
                            </div>
                            <div class="media-body text-right">
                                <h3 class="text-stat">${totalEvents}</h3>
                                <span class="text-stat">Events</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa fa-users icon-large float-left" style="color: #FA8072;">
                                </i>
                            </div>
                            <div class="media-body text-right">
                                <h3 class="text-stat">${totalDonors}</h3>
                                <span class="text-stat">Donors</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-6 col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="fa fa-pencil-square-o icon-large float-left" style="color: #000080;">
                                </i>
                            </div>
                            <div class="media-body text-right">
                                <h3 class="text-stat">${totalBlogs}</h3>
                                <span class="text-stat">Blogs</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-5">
                <div class="card">
                    <div class="card-header text-center" style="font-size: 24px">Current State</div>
                    <div class="card-body">
                        <div id="container1" style="margin: 0 auto"></div>
                    </div>
                </div>
        </div>
    </div>
</main>

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script>


    // Create the chart
    Highcharts.chart('container1', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Current state of inventory'
        },
        subtitle: {
            text: '${sessionScope.centre.nameCentre}'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: 'Total quantity in inventory in L'
            }

        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}L'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> L<br/>'
        },

        "series": [
            {
                "name": "Browsers",
                "colorByPoint": true,
                "data": [
                    {
                        "name": "${stockList.get(0).nameGrp}",
                        "y": ${stockList.get(0).quantity},
                        "drilldown": "${stockList.get(0).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(1).nameGrp}",
                        "y": ${stockList.get(1).quantity},
                        "drilldown": "${stockList.get(1).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(2).nameGrp}",
                        "y": ${stockList.get(2).quantity},
                        "drilldown": "${stockList.get(2).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(3).nameGrp}",
                        "y": ${stockList.get(3).quantity},
                        "drilldown": "${stockList.get(3).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(4).nameGrp}",
                        "y": ${stockList.get(4).quantity},
                        "drilldown": "${stockList.get(4).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(5).nameGrp}",
                        "y": ${stockList.get(5).quantity},
                        "drilldown": "${stockList.get(5).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(6).nameGrp}",
                        "y": ${stockList.get(6).quantity},
                        "drilldown": "${stockList.get(6).nameGrp}"
                    },
                    {
                        "name": "${stockList.get(7).nameGrp}",
                        "y": ${stockList.get(7).quantity},
                        "drilldown": "${stockList.get(7).nameGrp}"
                    }
                ]
            }
        ],
        "drilldown": {
            "series": [
                {
                    "name": "Chrome",
                    "id": "Chrome",
                    "data": [
                        [
                            "v65.0",
                            0.1
                        ],
                        [
                            "v64.0",
                            1.3
                        ],
                        [
                            "v63.0",
                            53.02
                        ],
                        [
                            "v62.0",
                            1.4
                        ],
                        [
                            "v61.0",
                            0.88
                        ],
                        [
                            "v60.0",
                            0.56
                        ],
                        [
                            "v59.0",
                            0.45
                        ],
                        [
                            "v58.0",
                            0.49
                        ],
                        [
                            "v57.0",
                            0.32
                        ],
                        [
                            "v56.0",
                            0.29
                        ],
                        [
                            "v55.0",
                            0.79
                        ],
                        [
                            "v54.0",
                            0.18
                        ],
                        [
                            "v51.0",
                            0.13
                        ],
                        [
                            "v49.0",
                            2.16
                        ],
                        [
                            "v48.0",
                            0.13
                        ],
                        [
                            "v47.0",
                            0.11
                        ],
                        [
                            "v43.0",
                            0.17
                        ],
                        [
                            "v29.0",
                            0.26
                        ]
                    ]
                },
                {
                    "name": "Firefox",
                    "id": "Firefox",
                    "data": [
                        [
                            "v58.0",
                            1.02
                        ],
                        [
                            "v57.0",
                            7.36
                        ],
                        [
                            "v56.0",
                            0.35
                        ],
                        [
                            "v55.0",
                            0.11
                        ],
                        [
                            "v54.0",
                            0.1
                        ],
                        [
                            "v52.0",
                            0.95
                        ],
                        [
                            "v51.0",
                            0.15
                        ],
                        [
                            "v50.0",
                            0.1
                        ],
                        [
                            "v48.0",
                            0.31
                        ],
                        [
                            "v47.0",
                            0.12
                        ]
                    ]
                },
                {
                    "name": "Internet Explorer",
                    "id": "Internet Explorer",
                    "data": [
                        [
                            "v11.0",
                            6.2
                        ],
                        [
                            "v10.0",
                            0.29
                        ],
                        [
                            "v9.0",
                            0.27
                        ],
                        [
                            "v8.0",
                            0.47
                        ]
                    ]
                },
                {
                    "name": "Safari",
                    "id": "Safari",
                    "data": [
                        [
                            "v11.0",
                            3.39
                        ],
                        [
                            "v10.1",
                            0.96
                        ],
                        [
                            "v10.0",
                            0.36
                        ],
                        [
                            "v9.1",
                            0.54
                        ],
                        [
                            "v9.0",
                            0.13
                        ],
                        [
                            "v5.1",
                            0.2
                        ]
                    ]
                },
                {
                    "name": "Edge",
                    "id": "Edge",
                    "data": [
                        [
                            "v16",
                            2.6
                        ],
                        [
                            "v15",
                            0.92
                        ],
                        [
                            "v14",
                            0.4
                        ],
                        [
                            "v13",
                            0.1
                        ]
                    ]
                },
                {
                    "name": "Opera",
                    "id": "Opera",
                    "data": [
                        [
                            "v50.0",
                            0.96
                        ],
                        [
                            "v49.0",
                            0.82
                        ],
                        [
                            "v12.1",
                            0.14
                        ]
                    ]
                }
            ]
        }
    });

</script>
</body>
</html>
