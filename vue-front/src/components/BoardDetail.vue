<template>
	<v-content>
		<template v-if="board.writerid == user.id">
			<v-btn>게시글 수정</v-btn>
		</template>
		<v-card>
			<v-card-title
				>{{ board.title }}
				<v-spacer></v-spacer>
				<v-divider vertical></v-divider>
				{{ board.writer }}
			</v-card-title>
			<viewer :value="board.content"></viewer>
		</v-card>
		<!-- 여기서부터 코멘트 -->
		<Comment :boardid="board.id" />
	</v-content>
</template>

<script>
import Comment from '@/components/Comment';

import { Viewer } from '@toast-ui/vue-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import 'codemirror/lib/codemirror.css';

import http from '@/axios/http-commons';
import { mapGetters } from 'vuex';

export default {
	props: ['id'],
	components: {
		Comment,
		viewer: Viewer,
	},
	computed: {
		...mapGetters(['user']),
	},
	data() {
		return {
			board: {
				id: 1,
				title: '123',
				content: '내용 content 1234\n 헤헤헤헿',
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
