function addStudent() {
	console.log("addStudent()");
	//get input values
	var id = document.getElementById("id").value;
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	//if address is with spaces for example, this function will encode special characters in a string before appending it to the query string
	var streetaddress = encodeURIComponent(document.getElementById("streetaddress").value);
	var postcode = document.getElementById("postcode").value;
	var postoffice = document.getElementById("postoffice").value;

	//create a query string
	var requestParameters = "?id=" + id +
		"&firstname=" + firstname +
		"&lastname=" + lastname +
		"&streetaddress=" + streetaddress +
		"&postcode=" + postcode +
		"&postoffice=" + postoffice;
	const url_base = "http://localhost:8080/WebAppExercises/addStudent"
	const url = url_base + requestParameters

	//create a new XMLHttpRequest object
	var xhr = new XMLHttpRequest();

	//configuring the request
	xhr.onload = function() {
		if (xhr.status == 200) {
			//request is successful
			var response = JSON.parse(xhr.responseText);
			if (response.errorcode === 0) {
				alert("Student data added!");
			} else if (response.errorcode === 1) {
				alert("Cannot add the student. The id is already in use!");
			} else {
				alert("The database is temporarily unavailable. Please try again later.");
			}
		} else {
			// Request failed
			alert("Post request failed: " + xhr.statusText);
		}
	}
	// Set up a function to handle network errors
	xhr.onerror = function() {
		alert("Post request failed: " + xhr.statusText);
	};
	xhr.open('POST', url);
	console.log("open()");

	// Send the request
	xhr.send();
}


