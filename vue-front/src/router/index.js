import Vue from 'vue';
import VueRouter from 'vue-router';

import Util from '@/util/index';

import Home from '@/components/Main';
import Board from '@/components/Board';
import BoardDetail from '@/components/BoardDetail';
import Profile from '@/components/Profile';
import Editor from '@/components/Editor';

Vue.use(VueRouter);

function authCheck(to, from, next) {
	if (!Util.authCheck()) {
		// 로그인 안되어있을때 에러메시지 띄우며 이동
		alert('로그인을 먼저 해주세요');
		next('/');
		return;
	}
	next();
}

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
		beforeEnter: authCheck,
	},
	{
		name: 'BoardDetail',
		path: '/board/:id',
		component: BoardDetail,
		props: true,
		beforeEnter: authCheck,
	},
	{
		name: 'Profile',
		path: '/profile',
		component: Profile,
		beforeEnter: authCheck,
	},
	{
		name: 'Editor',
		path: '/editor',
		component: Editor,
		beforeEnter: authCheck,
	},
];

const router = new VueRouter({
	mode: 'history',
	// base: process.env.BASE,
	routes,
});

// 페이지의 제목을 바꾼다
router.beforeEach((to, from, next) => {
	document.title = 'Practice Board';
	next();
});

export default router;
