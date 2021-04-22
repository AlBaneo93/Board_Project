const getters = {
	user(state) {
		return {
			email: state.user.email,
			name: state.user.name,
			access: state.user.access,
			refresh: state.user.refresh,
		};
	},
	islogin(state) {
		return state.islogin;
	},
};

export default getters;
