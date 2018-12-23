<%@page pageEncoding="UTF-8" contentType="text/html; utf--8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#albumId").val(line.id);
        console.log(line.id + "--------------");
        $("#addAudioBtn").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $('#addAudioForm').form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/addChapter",
                    onSubmit: function () {
                        // do some check
                        // return false to prevent submit;
                        return $("#addAudioForm").form("validate");
                    },
                    success: function () {
                        $("#addAudioDialog").dialog("close");
                        $("#album").treegrid("reload");
                    }
                });
            }
        });
    })


</script>
<form id="addAudioForm" method="post" enctype="multipart/form-data">
    <div>
        <label for="title">章节名称:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
    </div>
    <div>
        <label for="coverImg">上传音频:</label>
        <input type="file" name="audioFile"/>
    </div>
    <div>
        <label for="publishDate">上传时间:</label>
        <input class="easyui-datebox" type="text" name="uploadDate" data-options="required:true,editable:false"/>
    </div>
    <div>
        <input id="albumId" type="hidden" name="albumId">
    </div>
    <div>
        <a id="addAudioBtn">提交</a>
    </div>
    <div>
        <input type="reset" name="button" value="重置"/>
    </div>

</form>