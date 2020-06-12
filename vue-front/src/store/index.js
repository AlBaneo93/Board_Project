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
	state: {},
	mutations: {},
	actions: {},
	getters: {
		user(state) {
			return {
				email: state.email,
				name: state.name,
				access: state.access,
				refresh: state.refresh,
			};
		},
	},
});

export default store;
