<template>
	<v-container>
		<h1>게시글 작성</h1>
		<v-layout>
			<v-flex>
				<editor
					v-model="input"
					:previewStyle="'vertical'"
					:mode="'wysiwyg'"
					:height="'500px'"
				/>
			</v-flex>
			<v-flex>
				<viewer :value="input" :height="'500px'" />
			</v-flex>
			<v-card>
				<v-card-actions>
					<v-btn @click="$router.go(-1)">돌아가기</v-btn>
					<v-btn @click="addBoard">게시글 등록</v-btn>
				</v-card-actions>
			</v-card>
		</v-layout>
	</v-container>
</template>

<script>
import { Editor, Viewer } from '@toast-ui/vue-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import 'codemirror/lib/codemirror.css';

import http from '@/axios/http-commons';
import { mapGetters, mapActions } from 'vuex';

export default {
	components: {
		editor: Editor,
		viewer: Viewer,
	},
	data() {
		return {
			input: '',
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		...mapActions(['getCurrentDate']),
		addBoard() {
			let dto = {
				id: 0,
				title: this.title,
				content: this.input,
				uid: this.user.id,
				writer: this.user.name,
				createdat: this.getCurrentDate(),
			};
			http
				.post('/board', dto)
				.then(result => {
					if (result.data.msg) {
						alert('게시글이 정상적으로 등록되었습니다.');
						this.input = '';
						this.$router.replace('/board');
						return;
					}
					alert('게시글 등록중 오류가 발생하였습니다.');
				})
				.catch(() => {
					alert('게시글 등록중 오류가 발생하였습니다.');
				});
		},
	},
};
</script>

<style></style>
