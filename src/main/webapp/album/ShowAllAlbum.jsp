<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var album;
    var toolbar = [{
        iconCls: 'icon-search',
        text: "专辑详情",
        handler: function () {
            //获取选中行
            album = $("#album").treegrid("getSelected");
            if (album != null) {
                console.log(album.children);
                console.log(album);
                if (typeof (album.id) == typeof ("")) {
                    alert("请选择专辑节点");
                } else {
                    //初始化查看专辑对话框
                    $('#searchAlbumDialog').dialog({
                        width: 400,
                        height: 300,
                        closed: false,
                        cache: false,
                        href: '${pageContext.request.contextPath}/album/showAlbum.jsp?coverImg=' + album.coverImg,
                        modal: true
                    });
                }

            } else {
                alert("请先选中行");
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            $("#addAlbumDialog").dialog("open");
        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
            alert('添加音频')
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            alert("音频下载");

        }
    }]
    $(function () {
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAllAlbumByPage',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'duration', title: '时长', width: 80},
                {field: 'size', title: '大小', width: 80},
                {field: "url", title: "链接地址", width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            animate: true,
            lines: true,
            pagination: true,
            pageSize: 2,
            pageList: [1, 2, 3, 5, 8, 10, 15, 20]
        });

        //初始化添加Album对话框
        $('#addAlbumDialog').dialog({
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/album/addAlbum.jsp',
            modal: true
        });

    })

</script>

<table id="album"></table>
<div id="addAlbumDialog">添加专辑对话框</div>
<div id="searchAlbumDialog">查看专辑</div>