<template>
	<v-content>
		<v-form>
			<v-row>
				<v-col :cols="12" md="8">
					<v-text-field
						v-model="comment.comment"
						label="댓글을 달아주세요!"
						clearable
						clear-icon="mdi-close"
						prepend-icon="mdi-pen-plus"
						counter
					></v-text-field>
				</v-col>
				<v-col :cols="2" md="2">
					<v-btn @click="addComment">댓글 작성</v-btn>
				</v-col>
			</v-row>
		</v-form>
		<v-list>
			<v-list-item v-for="(item, i) in commentList" :key="i">
				<v-row>
					<v-col :cols="12" md="8">
						<v-list-item-title>
							{{ item.comment }}
						</v-list-item-title>
					</v-col>
					<!-- <v-col>
							<v-btn @click="replyshow = replyShow ? false : true" outlined>{{
						'답글 달기'
					}}</v-btn>
					</v-col> -->
					<!-- <template v-if="replyShow">
					<v-form>
						<v-text-field v-model="replyText"> </v-text-field>
						<v-btn @click="addReply(item)"></v-btn>
					</v-form>
				</template> -->
				</v-row>
			</v-list-item>
		</v-list>
	</v-content>
</template>

<script>
import http from '@/axios/http-commons';
import { mapGetters, mapActions } from 'vuex';

export default {
	props: ['boardid'],
	data() {
		return {
			commentList: [],
			reply: {},
			comment: {
				comment: '',
				uid: this.user.id,
				boardid: this.boardid,
			},
			commentText: '',
			replyText: '',
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		...mapActions(['getCurrentDate']),
		getBoardComment() {
			http
				.get('/commentlist')
				.then(result => {
					this.commentList = result.data.result;

					this.commentList.forEach(element => {
						if (element.commentUserId === this.user.id) {
							// 내가 작성한것에 대해 색상을 바꾼다
							element.backgroundColor = '#FFF3E0';
						}
					});
				})
				.catch(err => {
					console.log(err);
				});
		},
		addComment() {
			this.comment.createdat = this.getCurrentDate();
			this.commentList.push(this.comment);
			this.comment = {};

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
			let itemid = item.id;
			let level = item.level;
			let reply = {};
			reply.level = level + 1;
			reply.appendto = itemid;
			reply.comment = this.replyText;
			reply.boardid = this.boardid;
			reply.uid = this.user.id;
			reply.createdat = this.getBoardComment();
			// reply를 기존에 있던 댓글의 밑에 추가한다
			// this.commentList.push(item);

			http
				.post('/comment', reply)
				.then(result => {
					if (result.data.msg) {
						alert('답글이 성공적으로 등록되었습니다');
					}
				})
				.catch(() => {
					alert('댓글 등록 중 오류가 발생하였습니다');
				});
		},
	},
	mounted() {},
};
</script>

<style></style>
