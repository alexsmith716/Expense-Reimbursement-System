let logoutButton = document.getElementById('logout');

export function logout(e) {
	console.log('logout +++++++++');
	e.preventDefault();

	fetch('http://localhost:7000/logout',
		{
			'method': 'POST',
			'credentials': 'include'
		})
		.then((response) => {
			if(response.status === 200){
				window.location.href = '/index.html';
			}
		})
		.catch((error) => {
			console.error('logout: ', error);
		});
};

logoutButton.addEventListener('click', logout);
