const actions = {
	userLogin(context, payload) {
		context.commit.userLogin('userLogin', payload);
	},
	userLogout(context) {
		return context.commit.userLogout('userLogout');
	},
};

export default actions;
