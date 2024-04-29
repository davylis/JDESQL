function deleteStudent(){
	var id = document.getElementById("id");
	console.log("hello")
	
	var requestParameters = "?id=" + id.value;
	var urlBase = "http://localhost:8080/WebAppExercises/deleteStudent";
	var url = urlBase + requestParameters;
	
	var xhr = new XMLHttpRequest();
	
	//configuring the request
	xhr.onload = function() {
		if (xhr.status == 200) {
			//request is successful
			var response = JSON.parse(xhr.responseText);
			if (response.errorcode === 0) {
				alert("Student data deleted!");
			} else if (response.errorcode === 1) {
				alert("Student data not deleted. Unknown student id!");
			} else {
				alert("The database is temporarily unavailable. Please try again later.");
			}
		} else {
			// Request failed
			alert("Post request failed: " + xhr.statusText);
		}
	}
	xhr.open("POST", url)
	xhr.send()
}