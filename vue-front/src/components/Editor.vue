<template>
	<v-container fluid>
		<h1>게시글 작성</h1>
		<v-layout wrap row>
			<v-text-field
				v-model="title"
				solo
				rounded
				outlined
				counter
				flat
				persistent-hint
				placeholder="제목을 입력해 주세요"
			></v-text-field>
			<v-flex>
				<editor
					v-if="input != null"
					ref="boardeditor"
					:previewStyle="'tab'"
					:height="'500px'"
					:minHeight="'400px'"
					:initialValue="'# Hello, ' + user.name"
					:initialEditType="'wysiwyg'"
					:hideModeSwitch="true"
				/>
			</v-flex>
			<v-flex xs12>
				<v-card-actions>
					<v-btn @click="$router.go(-1)">돌아가기</v-btn>
					<v-btn @click="addBoard">게시글 등록</v-btn>
					<v-btn @click="showDialog">미리보기</v-btn>
				</v-card-actions>
			</v-flex>
		</v-layout>
		<viewer :setDialog="setDialog" :value="input" :closeviewer="closeDialog" />
	</v-container>
</template>

<script>
import { Editor } from '@toast-ui/vue-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import 'codemirror/lib/codemirror.css';

import Viewer from '@/components/Viewer';

import http from '@/axios/http-commons';
import util from '@/util/index';
import { mapGetters } from 'vuex';

export default {
	components: {
		editor: Editor,
		viewer: Viewer,
	},
	data() {
		return {
			input: '',
			title: '',
			setDialog: {
				isShow: false,
				width: 900,
				height: 600,
				hide_overlay: true,
				overlay_color: 'white',
			},
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		showDialog() {
			alert('추후 업데이트로 제공 예정입니다');
			// this.input = this.$refs.boardeditor.invoke('getMarkdown');
			// this.setDialog.isShow = true;
		},
		closeDialog() {
			this.setDialog.isShow = false;
		},
		addBoard() {
			let dto = {
				id: 0,
				title: this.title,
				content: this.$refs.boardeditor.invoke('getMarkdown'),
				uid: this.user.id,
				name: this.user.name,
				createdat: util.getCurrentDate(),
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
