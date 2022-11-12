let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			save();
		});
	},

	save: function() {
		//alert('user의 save함수 호출됨');
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			//글쓰기 수행 요청
			type: "POST",
			url: "/api/picturewrite",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"

		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			//console.log(resp);
			location.href = "/";

		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	}
}