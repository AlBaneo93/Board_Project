<template>
	<v-container>
		<v-card>
			<v-card-item v-for="(board, i) in boardList" :key="i">
				<v-card-title>{{ board.title }}</v-card-title>
			</v-card-item>
		</v-card>
	</v-container>
</template>

<script>
import http from '../axios/http-commons';
import { mapGetters } from 'vuex';
export default {
	data() {
		return {
			boardList: [],
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		getBoardList() {
			http
				.get('/boardlist')
				.then(result => {
					this.boardList = result.data.result;
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
