<template>
	<v-content>
		<v-card>
			<v-card-title
				>{{ board.title }}
				<v-spacer></v-spacer>
				<v-divider vertical></v-divider>
				{{ board.writer }}
			</v-card-title>
			<v-card-text>{{ board.content }}</v-card-text>
		</v-card>
		<!-- 여기서부터 코멘트 -->
		<Comment :boardid="board.id" />
	</v-content>
</template>

<script>
import Comment from '../components/Comment';

import http from '../axios/http-commons';

export default {
	props: ['id'],
	name: 'boardDetail',
	components: {
		Comment,
	},
	data() {
		return {
			board: {
				id: 1,
				title: '123',
				content: '내용',
				writer: '1',
			},
		};
	},
	mounted() {
		// this.getBaordDetail();
	},
	methods: {
		getBaordDetail() {
			http.get('/board/' + this.id).then(result => {
				this.board = result.data.result;
			});
		},
	},
};
</script>

<style></style>
