
function fetchMangerReimbursements() {
	console.log('fetchMangerReimbursements +++++++++');

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
		//	.then((data) => {
		//		if (data) {
		//			return fetch(`http://localhost:7000/reimbursements`,{'method': 'GET','credentials': 'include'});
		//		}
		//	})
		//	.then((res) => {
		//		return res.json();
		//	})
		//	.then((data) => {
		//		buildReimbursementsTable(data)
		//	})
		.catch((error) => {
			console.error("fetchMangerReimbursements: ", error);
		});
};


window.addEventListener('load', fetchMangerReimbursements);