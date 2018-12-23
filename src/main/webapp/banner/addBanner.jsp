<%@page pageEncoding="UTF-8" contentType="text/html; utf--8" isELIgnored="false" %>
<script type="text/javascript">
    $("#sunmitAddBannber").linkbutton({
        iconCls: "icon-save",
        onClick: function () {
            $('#ff').form("submit", {
                url: "${pageContext.request.contextPath}/banner/addBanner",
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                    return $("#ff").form("validate");
                },
                success: function () {
                    $("#addBannerDialog").dialog("close");
                    $("#bannerDatagrid").edatagrid("reload");
                }
            });
        }
    });


</script>
<form id="ff" method="post" enctype="multipart/form-data">
    <div>
        <label for="title">标题:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
    </div>
    <div>
        <label for="imgPath">图片路径:</label>
        <input type="file" name="imgFile"/>
    </div>
    <div>
        <label for="status">状态:</label>
        <input class="easyui-validatebox" type="text" name="status" data-options="required:true"/>
    </div>
    <div>
        <label for="publishDate">上传时间:</label>
        <input class="easyui-datebox" type="text" name="publishDate" data-options="required:true,editable:false"/>
    </div>
    <div>
        <label for="description ">描述:</label>
        <input class="easyui-validatebox" type="text" name="description" data-options="required:true"/>
    </div>
    <div>
        <a id="sunmitAddBannber">提交</a>
    </div>
</form>