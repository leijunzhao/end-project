<%@page pageEncoding="UTF-8" contentType="text/html; utf--8" isELIgnored="false" %>
<script type="text/javascript">
    $("#showAlbumForm").form("load", "${pageContext.request.contextPath}/album/queryOneAlbum?id=" + album.id);

</script>
<form id="showAlbumForm" method="post" enctype="multipart/form-data">
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
        <img src="${pageContext.request.contextPath}/upload/${param.coverImg}">
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

</form>