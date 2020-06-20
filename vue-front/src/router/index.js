import Vue from 'vue';
import VueRouter from 'vue-router';

import Home from '@/components/Main';
import Board from '@/components/Board';
import BoardDetail from '@/components/BoardDetail';
import Profile from '@/components/Profile';
import Editor from '@/components/Editor';

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
    path: '/board/:id',
    component: BoardDetail,
    props: true,
  },
  {
    name: 'Profile',
    path: '/profile',
    component: Profile,
  },
  {
    name: 'Editor',
    path: '/editor',
    comments: Editor,
  },
];

const router = new VueRouter({
  mode: 'history',
  // base: process.env.BASE,
  routes,
});

export default router;
