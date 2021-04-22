const actions = {
	userLogin(context, payload) {
		context.commit('userLogin', payload);
	},
	userLogout(context) {
		context.commit('userLogout');
	},
};

export default actions;
