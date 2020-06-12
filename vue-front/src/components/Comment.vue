<template>
	<v-content>
		<v-form>
			<v-text-field
				v-model="comment.comment"
				label="댓글을 달아주세요!"
				clearable
				clear-icon="mdi-close"
				prepend-icon="mdi-pen-plus"
				counter
			></v-text-field>
			<v-btn @click="addComment">댓글 작성</v-btn>
		</v-form>
		<v-list>
			<v-list-item v-for="(item, i) in commentList" :key="i">
				<v-list-item-title>
					{{ item.comment }}
					<!-- <v-btn @click="replyshow = replyShow ? false : true" outlined>{{
						'답글 달기'
					}}</v-btn> -->
				</v-list-item-title>
				<!-- <template v-if="replyShow">
					<v-form>
						<v-text-field v-model="replyText"> </v-text-field>
						<v-btn @click="addReply(item)"></v-btn>
					</v-form>
				</template> -->
			</v-list-item>
		</v-list>
	</v-content>
</template>

<script>
import http from '../axios/http-commons';
import { mapGetters } from 'vuex';

export default {
	props: ['boardid'],
	data() {
		return {
			commentList: [],
			reply: {},
			comment: {
				comment: '',
			},
			commentText: '',
			replyText: '',
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
							element.backgroundColor = '#FFF3E0';
						}
					});
				})
				.catch(err => {
					console.log(err);
				});
		},
		addComment() {
			this.commentList.push(this.comment);
			this.comment = {};
			// this.commentText = '';
			// this.comment.uid = this.user.id;
			// this.comment.boardid = this.boardid;
			// this.comment.level = 0;

			// http
			// 	.post('/comment', this.comment)
			// 	.then(result => {
			// 		this.commentList.push(result.data.result);
			// 	})
			// 	.catch(err => {
			// 		console.log(err);
			// 	});
		},
		addReply(item) {
			this.commentList.push(item);
		},
	},
	mounted() {},
};
</script>

<style></style>
