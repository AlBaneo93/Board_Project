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
		<comment #comment="{comments}">
			<v-card>
				<v-container>
					<v-form fluid>
						<v-row justify="center" align="center">
							<v-col cols="10">
								<v-text-field prepend-icon="mdi-plus" v-model="commentValue" />
							</v-col>
							<v-col cols="2">
								<v-btn @click="addComment(comments)">댓글 등록</v-btn>
							</v-col>
						</v-row>
					</v-form>
				</v-container>
				<v-list flat>
					<v-subheader>
						<h3>댓글</h3>
					</v-subheader>
					<v-list-group value="true" v-for="(comment, i) in comments" :key="i">
						<template #activator>
							<v-list-item two-line :ripple="false" value="true">
								<v-list-item-content>
									<v-list-item-title>{{ comment.comment }}</v-list-item-title>
									<template v-if="comment.replyIsShow">
										<v-btn
											@click="
												comment.replyIsShow = comment.replyIsShow ? false : true
											"
											>닫기
										</v-btn>
									</template>
									<template v-else>
										<v-btn
											@click="
												comment.replyIsShow = comment.replyIsShow ? false : true
											"
											>답글 달기
										</v-btn>
									</template>
									<!-- 댓글을 달 폼을 나오게 할 변수 추가 -->
									<v-list-item-subtitle v-if="comment.replyIsShow">
										<v-row>
											<v-form>
												<v-col>
													<v-text-field v-model="replyValue" />
												</v-col>
												<v-col>
													<v-btn @click="addReply(comment)">등록</v-btn>
												</v-col>
											</v-form>
										</v-row>
									</v-list-item-subtitle>
								</v-list-item-content>
							</v-list-item>
						</template>
						<!-- 여기에 대댓글 -->
						<template v-if="comment.next">
							<v-list-group
								sub-group
								two-line
								no-action
								value="true"
								v-for="(reply, i) in comment.next"
								:key="i"
							>
								<template #activator>
									<v-list-item :ripple="false">
										<v-list-item-content>
											<v-row>
												<v-col cols="8">
													<v-list-item-title>
														{{ reply.comment }}
													</v-list-item-title>
												</v-col>
												<!-- 내가 작성한 것일때만 수정/삭제가 가능하게 -->
												<v-list-item-action v-if="reply.uid === user.id">
													<v-col cols="4">
														<v-row>
															<v-col cols="6">
																<v-btn icon @click="updateReply(reply)">
																	<v-icon>mdi-pencil</v-icon>
																	수정
																</v-btn>
															</v-col>
															<v-col cols="6">
																<v-btn
																	icon
																	@click="deleteReply(reply, comment.next)"
																>
																	<v-icon>mdi-delete</v-icon>
																	삭제
																</v-btn>
															</v-col>
														</v-row>
													</v-col>
												</v-list-item-action>
											</v-row>
										</v-list-item-content>
									</v-list-item>
								</template>
							</v-list-group>
						</template>
					</v-list-group>
				</v-list>
			</v-card>
		</comment>
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

import util from '@/util/index';

export default {
	props: ['id'],
	components: {
		comment: Comment,
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
			commentValue: '',
			replyValue: '',
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
		addComment(list) {
			if (!util.authCheck()) {
				return;
			}
			let comment = {
				id: 0,
				uid: this.user.id,
				comment: this.commentValue,
				boardid: this.id,
				name: this.user.name,
				createdat: util.getCurrentDate(),
				next: [],
			};

			this.commentValue = '';
			list.push(comment);
			http
				.post('/comment', comment)
				.then(result => {
					console.log(result);
				})
				.catch(err => {
					console.log(err);
				});
		},
		addReply(item) {
			if (!util.authCheck()) {
				return;
			}

			let reply = {
				id: 0,
				uid: this.user.id,
				comment: this.replyValue,
				boardid: this.id,
				name: this.user.name,
				createdat: util.getCurrentDate(),
			};
			this.replyValue = '';
			item.next.push(reply);
			// http
			// 	.post('/comment', reply)
			// 	.then(result => {
			// 		// if (result.data.msg) {
			// 		// 	alert('답글이 성공적으로 등록되었습니다');
			// 		// }
			// 		console.log(result);
			// 	})
			// 	.catch(err => {
			// 		// alert('댓글 등록 중 오류가 발생하였습니다');
			// 		console.log(err);
			// 	});
		},
		updateReply(comment) {
			http
				.put('/comment', comment)
				.then(result => {
					console.log(result);
				})
				.catch(err => {
					console.log(err);
				});
		},
		deleteReply(comment, list) {
			let delIdx;
			for (let idx in list) {
				console.log(idx, list[idx]);
				if (idx === comment.id) {
					delIdx = idx;
					break;
				}
			}
			list.splice(delIdx, 1);

			http
				.delete('/comment', comment)
				.then(result => {
					console.log(result);
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
};
</script>

<style></style>
