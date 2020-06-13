const actions = {
	userLogin(context, payload) {
		context.commit.userLogin('userLogin', payload);
	},
	userLogout(context) {
		return context.commit.userLogout('userLogout');
	},
	getCurrentDate() {
		let date = new Date();
		let year = date.getFullYear();
		let month = date.getMonth() + 1;
		month = month < 10 ? '0' + month : month;
		let day = date.getDate();
		day = day < 10 ? '0' + day : day;
		return year + '' + month + '' + day;
	},
};

export default actions;
