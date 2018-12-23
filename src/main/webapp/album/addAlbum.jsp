<%@page pageEncoding="UTF-8" contentType="text/html; utf--8" isELIgnored="false" %>
<script type="text/javascript">
    $("#saaBtn").linkbutton({
        iconCls: "icon-save",
        onClick: function () {
            $('#albumForm').form("submit", {
                url: "${pageContext.request.contextPath}/album/addAlbum",
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                    return $("#albumForm").form("validate");
                },
                success: function () {
                    $("#addAlbumDialog").dialog("close");
                    $("#album").treegrid("reload");
                }
            });
        }
    });


</script>
<form id="albumForm" method="post" enctype="multipart/form-data">
    <div>
        <label for="title">专辑名称:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
    </div>
    <div>
        <label for="count">集数:</label>
        <input class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
    </div>
    <div>
        <label for="coverImg">图片路径:</label>
        <input type="file" name="multipartFile"/>
    </div>
    <div>
        <label for="score">评分:</label>
        <input class="easyui-validatebox" type="text" name="score" data-options="required:true"/>
    </div>
    <div>
        <label for="author">作者:</label>
        <input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
    </div>
    <div>
        <label for="broadcast ">播音:</label>
        <input class="easyui-validatebox" type="text" name="broadcast" data-options="required:true"/>
    </div>
    <div>
        <label for="brief">专辑简介:</label>
        <input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
    </div>
    <div>
        <label for="publishDate">发布时间:</label>
        <input class="easyui-datebox" type="text" name="publishDate" data-options="required:true,editable:false"/>
    </div>
    <div>
        <a id="saaBtn">提交</a>
    </div>
    <div>
        <input type="reset" name="button" value="重置"/>
    </div>
</form>