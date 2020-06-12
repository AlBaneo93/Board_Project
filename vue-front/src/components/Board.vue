<template>
	<v-container>
		<v-card>
			<v-subheader>
				<v-card-title>
					{{ '제목, 작성자' }}
				</v-card-title>
			</v-subheader>
			<v-card-item v-for="(board, i) in boardList" :key="i">
				<v-card-title
					@click="goBoardDetail(board.id)"
					@mouseover="overEvent"
					@mouseout="outEvent"
				>
					{{ board.title }}
					<v-spacer></v-spacer>
					<v-divider vertical></v-divider>
					{{ board.writer }}
				</v-card-title>
			</v-card-item>
		</v-card>
	</v-container>
</template>

<script>
import http from '@/axios/http-commons';
import { mapGetters } from 'vuex';
export default {
	data() {
		return {
			boardList: [
				{
					id: 1,
					title: '123',
					content: '내용',
					writer: '1',
				},
				{
					id: 2,
					title: '234',
					writer: '2',
				},
				{
					id: 3,
					title: '345',
					writer: '3',
				},
			],
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
		goBoardDetail(id) {
			this.$router.push('/boarddetail/' + id);
		},
		overEvent(event) {
			// 색 변경
			// console.log(event);
			let target = event.target;
			target.style.backgroundColor = '#ECEFF1';
		},
		outEvent(event) {
			// 색 원복
			// console.log(event);
			let target = event.target;
			target.style.backgroundColor = 'white';
		},
	},
	mounted() {
		this.getBoardList();
	},
};
</script>

<style></style>
