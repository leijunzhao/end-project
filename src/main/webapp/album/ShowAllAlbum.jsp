<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var album;
    var line;
    var toolbar = [{
        iconCls: 'icon-search',
        text: "专辑详情",
        handler: function () {
            //获取选中行
            album = $("#album").treegrid("getSelected");
            if (album != null) {
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
            line = $("#album").treegrid("getSelected");
            if (line != null) {
                if (typeof (line.id) == typeof ("")) {
                    alert("请选择专辑节点");
                } else {
                    $("#addAudioDialog").dialog("open");
                }
            } else {
                alert("请先选中行");
            }
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            var path = $("#album").treegrid("getSelected");
            location.href = "${pageContext.request.contextPath}/upload/uploadFile?url=" + path.url;

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
                {field: "url", title: "链接地址", width: 80, formatter: linkUrl}
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

        //初始化添加Album专辑对话框
        $('#addAlbumDialog').dialog({
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: '${pageContext.request.contextPath}/album/addAlbum.jsp',
            modal: true
        });
        //初始化添加音频对话框Audio
        $("#addAudioDialog").dialog({
            width: 400,
            height: 300,
            closed: true,
            cache: false,
            href: "${pageContext.request.contextPath}/chapter/addAudio.jsp",
            modal: true
        })
    });

    function linkUrl(value, row, index) {
        if (row.url != null) {
            var path = "${pageContext.request.contextPath}/uploadAudio/" + row.url;
            return "<audio style='height:50px;width:220px' controls='controls' src='" + path + "'/>";
        }
    }

</script>

<table id="album"></table>
<div id="addAlbumDialog">添加专辑对话框</div>
<div id="searchAlbumDialog">查看专辑</div>
<div id="addAudioDialog">添加音频对话框</div>