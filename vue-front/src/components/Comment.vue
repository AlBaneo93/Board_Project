<template>
	<v-content>
		<v-list>
			<v-list-item v-for="(item, i) in commentList" :key="i">
				<v-list-title>
					{{ item.title }}
					<v-btn>{{ `Reply` }}</v-btn>
				</v-list-title>
			</v-list-item>
		</v-list>
	</v-content>
</template>

<script>
import http from '../axios/http-commons';
import { mapGetters } from 'vuex';

export default {
	props: ['id'],
	data() {
		return {
			commentList: [],
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		getBoardComment() {
			http
				.get('/commentlist')
				.then(result => {
					this.commentList = result.data.result;

					this.commentList.forEach(element => {
						if (element.commentUserId === this.user.id) {
							// 색 바꾸기
							element.background.color = 'red';
						}
					});
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
	mounted() {},
};
</script>

<style></style>
