function main() {
	fetch("http://localhost:8080/WebAppExercises/students")
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		.then(studentList => printStudents(studentList))
		.catch(errorText => console.error("Fetch failed: " + errorText));
}
function printStudents(studentList) {
	let tbody = document.getElementById("studentList");
	let html = "";
	for (let student of studentList) {
		html += "<tr>";
		html += "<td>" + student.id + "</td>";
		html += "<td>" + student.firstname + "</td>";
		html += "<td>" + student.lastname + "</td>";
		html += "<td>" + student.streetAddress + "</td>";
		html += "<td>" + student.postCode + "</td>";
		html += "<td>" + student.postOffice + "</td>";
		html += "</tr>";
		console.log(student.lastname);
	}
	console.log(html);
	tbody.innerHTML = html;
}

main();