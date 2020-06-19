import Vue from 'vue';
import Vuex from 'vuex';
import VuexPersistence from 'vuex-persistedstate';

import state from './moduels/state';
import getters from './moduels/getters';
import actions from './moduels/actions';
import mutations from './moduels/mutations';

Vue.use(Vuex);

// vuex의 모듈을 분리하여 사용하는 방법
const store = new Vuex.Store({
	plugins: [
		VuexPersistence({
			storage: window.sessionStorage,
		}),
	],
	state,
	getters,
	actions,
	mutations,
});

export default store;
