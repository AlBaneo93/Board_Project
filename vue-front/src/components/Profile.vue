<template>
	<div>
		<h1>{{ user.name }}님 안녕하세요</h1>
		<v-card>
			<v-img
				:src="'http://localhost:10101/image/profile/' + user.email + '.png'"
				width="300"
				height="300"
			>
				<h1>{{ user.email }}</h1>
			</v-img>
			<v-card-title>
				{{ user.name }}
			</v-card-title>
		</v-card>
		<v-btn @click="updateProfile">프로필 업데이트</v-btn>
	</div>
</template>

<script>
import { mapGetters } from 'vuex';
import http from '@/axios/http-commons';

export default {
	data() {
		return {
			updateUserData: {
				id: 0,
				name: '',
				email: '',
			},
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		updateProfile() {
			http
				.put('/member', this.updateUserData)
				.then(() => {})
				.catch(() => {});
		},
	},
};
</script>

<style></style>
