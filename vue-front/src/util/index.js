function getCurrentDate() {
	let date = new Date();
	let year = date.getFullYear();
	let month = date.getMonth() + 1;
	month = month < 10 ? '0' + month : month;
	let day = date.getDate();
	day = day < 10 ? '0' + day : day;
	let hour = date.getHours();
	let minute = date.getMinutes();
	return year + '' + month + '' + day + '' + hour + '' + minute;
}

function authCheck() {
	return window.sessionStorage.getItem('islogin');
}

const data = {
	getCurrentDate,
	authCheck,
};

export default data;
