let submitButton = document.getElementById('submit');
let amountInput = document.getElementById('amount');
let dateInput = document.getElementById('date');
let descriptionInput = document.getElementById('description');
let typeInput = document.getElementById('type');

// ============================================

function submit(e) {
	console.log('submit +++++++++');
	e.preventDefault();

	const data = {
		'reimbursementAmount': amountInput.value,
		'reimbursementSubmitted': dateInput.value,
		'reimbursementDescription': descriptionInput.value,
		'reimbursementType': typeInput.value,
	};

	fetch('http://localhost:7000/checksession',
		{
			'credentials': 'include',
			'method': 'GET'
		})
		.then((response) => {
			if (response.status === 401) {
				window.location.href = '/index.html'
			} else if (response.status === 200) {
				return response.json();
			}
		})
		.then((employee) => {
			return fetch(`http://localhost:7000/employees/${employee.eID}/reimbursements`,
				{
					'method': 'POST',
					'credentials': 'include',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(data)
				});
		})
		.then((response) => {
			if (response.status === 200) {
				window.location.href = '/employee.html';
			} 
		})
		.catch((error) => {
			console.error("submit: ", error);
		});
};

function buildReimbursementsTable(reimbursements){
	let tbody = document.querySelector('#reimbursements tbody'); 

	for (const r of reimbursements){

		let tr = document.createElement('tr');

		let reimbursementID = document.createElement('td');
		reimbursementID.innerHTML = r.rID;

		let reimbursementType = document.createElement('td');
		r.type === "1" ? reimbursementType.innerHTML = "LODGING" : null;
		r.type === "2" ? reimbursementType.innerHTML = "FOOD" : null;
		r.type === "3" ? reimbursementType.innerHTML = "TRAVEL" : null;
		r.type === "4" ? reimbursementType.innerHTML = "OTHER" : null;

		let reimbursementSubmitted = document.createElement('td');
		reimbursementSubmitted.innerHTML = r.submitted;

		let reimbursementAmount = document.createElement('td');
		reimbursementAmount.innerHTML = r.amount;

		let reimbursementStatus = document.createElement('td');
		r.status === "1" ? reimbursementStatus.innerHTML = "PENDING" : null;
		r.status === "2" ? reimbursementStatus.innerHTML = "APPROVED" : null;
		r.status === "3" ? reimbursementStatus.innerHTML = "DENIED" : null;

		let reimbursementDescription = document.createElement('td');
		reimbursementDescription.innerHTML = r.description;

		tr.appendChild(reimbursementID);
		tr.appendChild(reimbursementAmount);
		tr.appendChild(reimbursementSubmitted);
		tr.appendChild(reimbursementDescription);
		tr.appendChild(reimbursementStatus);
		tr.appendChild(reimbursementType);

		tbody.appendChild(tr);
	}
}

function fetchEmployeeReimbursements() {
	console.log('fetchEmployeeReimbursements +++++++++');

	fetch('http://localhost:7000/checksession',
		{
			'method': 'GET',
			'credentials': 'include'
		})
		.then((res) => {
			if (res.status === 200) {
				return res.json();
			} else {
				window.location.href = '/index.html';
				return;
			}
		})
		.then((data) => {
			if (data) {
				return fetch(`http://localhost:7000/employees/${data.eID}/reimbursements`,{'method': 'GET','credentials': 'include'});
			}
		})
		.then((res) => {
			return res.json();
		})
		.then((data) => {
			buildReimbursementsTable(data)
		})
		.catch((error) => {
			console.error("fetchEmployeeReimbursements: ", error);
		});
};

window.addEventListener('load', fetchEmployeeReimbursements);
submitButton.addEventListener('click', submit);
