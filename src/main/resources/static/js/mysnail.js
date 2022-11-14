$(document).ready(function () {
	$('#btn-save').click(function () {
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		$.ajax({
			type: 'post',   //post 방식으로 전송
			url: '/mysnail/new',   //데이터를 주고받을 파일 주소
			data: JSON.stringify(data),   //위의 변수에 담긴 데이터를 전송해준다.
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function (data) {   //파일 주고받기가 성공했을 경우. data 변수 안에 값을 담아온다.
				alert("글쓰기가 완료되었습니다.");
				//console.log(resp);
				location.href = "/picture";  //현재 화면 위 id="message" 영역 안에 data안에 담긴 html 코드를 넣어준다. 
			}
		});
	});
});
$(document).ready(function () {
	axios.get('/mysnail/all', {
	})
		.then(function (response) {
			let tb = $("<tbody/>");
			console.log(response)
			for (var i in response.data) {
				console.log(response.data)

				let $id = response.data[i].id
				let $title = response.data[i].title
				let $createdDate = response.data[i].createdDate

				var row = $("<tr/>").append(
					'<td><a href=' + $id + '>' + $id + '</a></td>' +
					'<td>' + $title + '</td>' +
					'<td>' + $createdDate + '</td>'
				)
				tb.append(row);
			}
			$(".thead").after(tb);
		})
		.catch(function (error) {
			console.log(error);
		})
		.finally(function () {
			// always executed
		});
})