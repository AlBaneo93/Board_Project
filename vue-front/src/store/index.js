import Vue from 'vue';
import Vuex from 'vuex';
import VuexPersistence from 'vuex-persistedstate';

Vue.use(Vuex);

const store = new Vuex.Store({
	plugins: [
		VuexPersistence({
			storage: window.sessionStorage,
		}),
	],
	state: {
		islogin: false,
		user: {
			email: '',
			name: '',
			img: '',
			accesstoken: '',
			refreshtoken: '',
		},
	},
	mutations: {
		userLogin(state, payload) {
			state.islogin = true;
			state.user.email = payload.email;
			state.user.name = payload.name;
			state.user.img = payload.img;
			state.user.accesstoken = payload.accesstoken;
			state.user.refreshtoken = payload.refreshtoken;
		},
		userLogout(state) {
			state.islogin = false;
			state.user = {};
		},
	},
	actions: {
		userLogin(context, payload) {
			context.commit('userLogin', payload);
		},
		userLogout(context) {
			return context.commit('userLogout');
		},
	},
	getters: {
		user(state) {
			return {
				islogin: state.islogin,
				email: state.user.email,
				name: state.user.name,
				access: state.user.access,
				refresh: state.user.refresh,
			};
		},
	},
});

export default store;
