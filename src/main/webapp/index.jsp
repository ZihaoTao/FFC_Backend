<%@ page language="java"  contentType="text/html; charset=UTF-8" %>

<html>
<body>

springmvc file upload
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc file upload" />
</form>


rich text file upload
<form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="rich text file upload" />
</form>

</body>
</html>
