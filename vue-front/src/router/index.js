import Vue from 'vue';
import VueRouter from 'vue-router';

import Home from '../components/Main';
import Board from '../components/Board';
import BoardDetail from '../components/BoardDetail.vue';

Vue.use(VueRouter);

const routes = [
	{
		name: 'Home',
		path: '/',
		component: Home,
	},
	{
		name: 'Board',
		path: '/board',
		component: Board,
	},
	{
		name: 'BoardDetail',
		path: '/boarddetail/:id',
		component: BoardDetail,
		props: true,
	},
];

const router = new VueRouter({
	mode: 'history',
	// base: process.env.NODE_ENV,
	routes,
});

export default router;
