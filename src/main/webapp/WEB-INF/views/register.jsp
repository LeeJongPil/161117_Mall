<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>

.fileDrop {
	width: 100%;
	height: 300px;
	border: 3px dotted blue;
}

img {
	width: 50px;
}
</style>






	<form action="registerAction" method="post"
		enctype="multipart/form-data">
		<p>상품이름<input type="text" name='pname'></p>
		<p>제조사<input type="text" name='pmaker'></p>
		<p>이미지<input type="hidden" name='pimage' id = 'uphoto'></p>
		<p><button>추가</button></p>
	</form>

	<div class="fileDrop">Drop Here</div>

	<div class="uploadedList"></div>


	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		crossorigin="anonymous"></script>


	<script>
	$(document).ready(function() {

		var uploadedList = $(".uploadedList");
		
		
		$(".fileDrop").on("dragenter dragover", function() {
			event.preventDefault(); // 이렇게 막으면 이동은 없어진다.
		});

		
		$(".fileDrop").on("drop",function(event) {
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;

			var file = files[0];

			var formData = new FormData();
			
			formData.append("file", file);

			console.log(formData);

			console.log(files);
			console.log(file);

			$.ajax({
				url : "uploadFile",
				data : formData,
				dataType : 'text',
				type : "post",
				contentType : false,
				processData : false,
				success : function(data) {
					console.log(data);
					uploadedList.html("<img src=showselect?name="+ data + ">");
					$("#uphoto").val(data);
				}
			});
	
		});

	});
	</script>



</body>
</html>