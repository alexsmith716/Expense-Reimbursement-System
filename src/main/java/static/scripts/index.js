let loginButton = document.getElementById('login');
let emailInput = document.getElementById('email');
let passwordInput = document.getElementById('password');

// JSESSIONID

const login = (e) => {
	console.log('login +++++++++');
	e.preventDefault();

	const loginInfo = {
		'email': emailInput.value,
		'password': passwordInput.value
	};

	fetch('http://localhost:7000/login',
		{
			'method': 'POST',
			'credentials': 'include',
			'headers': {'Content-Type': 'application/json'},
			'body': JSON.stringify(loginInfo)
		})
		.then((response) => {
			if(response.status === 200) {
				return response.json();
			} else {
				displayFailedLogin();
			}
		})
		.then((data) => {
			if (data) {
				if(data.role === 1) {
					window.location.href = '/manager.html'
				} else {
					window.location.href = '/employee.html'
				};
			}
		})
		.catch((error) => {
			console.error('login: ', error);
		});
};

function identifyValidUserSession() {
	console.log('identifyValidUserSession +++++++++');

	fetch('http://localhost:7000/checksession',
		{
			'method': 'GET',
			'credentials': 'include'
		})
		.then((res) => {
			if(res.status === 200) {
				return res.json();
			}
		})
		.then((data) => {
			if (data) {
				if(data.role === 1) {
					window.location.href = '/manager.html'
				} else{
					window.location.href = '/employee.html'
				};
			}
		})
		.catch((error) => {
			console.error('identifyValidUserSession: ', error);
		});
};

function displayFailedLogin() {
	console.log('displayInvalidLogin +++++++++');
	const elmnt = document.getElementById('failedLogin');
	elmnt !== null ? elmnt.remove() : null;
	let loginForm = document.getElementById('login_form');
	let p = document.createElement('p');
	p.style.cssText = 'color: #DC143C; padding-top: 10px; font-size: 20px;';
	p.innerHTML = 'Login Failed';
	p.setAttribute('id', 'failedLogin');
	loginForm.appendChild(p);
}

loginButton.addEventListener('click', login);
window.addEventListener('load', identifyValidUserSession);
