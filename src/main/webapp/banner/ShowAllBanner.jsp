<%@page contentType="text/html; utf-8" pageEncoding="utf-8" %>

<script type="text/javascript">
    $(function () {
        //初始化添加banner对话框
        $('#addBannerDialog').dialog({
            title: 'My Dialog',
            width: 400,
            height: 200,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/banner/addBanner.jsp',
            modal: true
        });
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#addBannerDialog").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#bannerDatagrid").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#bannerDatagrid").edatagrid("getRowIndex", row);
                    $("#bannerDatagrid").edatagrid("editRow", index);
                } else {
                    alert("请先选中行");
                }
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {

                $("#bannerDatagrid").edatagrid("destroyRow");
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#bannerDatagrid").edatagrid("saveRow");
                $("#bannerDatagrid").edatagrid("reload");
            }
        }];
        $('#bannerDatagrid').edatagrid({
            destroyUrl: "${pageContext.request.contextPath}/banner/deleteBanner",
            updateUrl: "${pageContext.request.contextPath}/banner/updateBanner",
            url: "${pageContext.request.contextPath}/banner/queryAllBanner",
            columns: [[
                {field: 'title', title: '标题', width: 100},
                {field: 'imgPath', title: '图片路径', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {require: true}
                    }
                },
                {field: 'publishDate', title: '上传时间', width: 100},
                {field: 'description', title: '描述', width: 100, align: 'right'}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 3,
            pageList: [1, 3, 5, 7, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            destroyMsg: {
                norecord: {    // 在没有记录选择的时候执行
                    title: 'Warning',
                    msg: '请先选择一行数据'
                },
                confirm: {       // 在选择一行的时候执行
                    title: 'Confirm',
                    msg: '确认删除吗?'
                }
            },
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>上传时间: ' + rowData.publishDate + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })
</script>
<table id="bannerDatagrid"></table>
//添加轮播图对话框
<div id="addBannerDialog">添加轮播图</div>