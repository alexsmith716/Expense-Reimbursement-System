let checkUserStatusButton = document.getElementById('checkUserStatusButton');
let helloButton = document.getElementById('helloButton');

export function checkValidUserSession() {
	fetch('http://localhost:7000/checksession',
		{
			'method': 'GET',
			'credentials': 'include'
		})
		.then((res) => {
			console.log("checkValidUserSession: ", res);
		})
		.catch((error) => {
			console.error("checkValidUserSession: ", error);
		});
};

export function hello() {
	console.log("hello++++++++++++++");
}

helloButton.addEventListener('click', hello);
checkUserStatusButton.addEventListener('click', checkValidUserSession);
