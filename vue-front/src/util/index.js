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

function stringToDateform(time) {
	time += '';
	let year = time.substr(0, 4);
	let month = time.substr(4, 2);
	let day = time.substr(6, 2);
	let hour = time.substr(8, 2);
	let minute = time.substr(10, 2);
	return year + '.' + month + '.' + day + ' ' + hour + ':' + minute;
}

function authCheck() {
	return JSON.parse(window.sessionStorage.getItem('vuex')).islogin;
}

const data = {
	getCurrentDate,
	authCheck,
	stringToDateform,
};

export default data;
