<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '用户注册时间展示'
        },
        tooltip: {},
        legend: {
            data: ['用户注册时间段']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '用户注册时间段',
            type: 'bar',
            data: []
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/user/queryUser?week=3",
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            myChart.setOption({
                xAxis: {
                    data: data.weeks
                },
                yAxis: {},
                series: [{
                    name: '用户注册时间段',
                    type: 'bar',
                    data: data.counts
                }]
            })
        }

    })
</script>
