<template>
	<v-content>
		<!-- <v-form>
      <v-row>
        <v-col :cols="10" md="8">
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
    </v-form> -->
		<slot name="comment" :comments="commentList"></slot>
	</v-content>
</template>

<script>
import http from '@/axios/http-commons';
import { mapGetters } from 'vuex';

export default {
	props: ['boardid'],
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
					let commentData = result.data.result;
					// 리스트는 배열로 넘어온다
					// 같은레벨의 같은 appendid를 가지는 얘들끼리 묶어서 배열로 만들어놓고
					// 해당 아이디를 가진 얘를 키로 만들어서 관리
					// 아이디는 중복이 안될꺼니까
					commentData.forEach(comment => {
						if (comment.uid === this.user.id) {
							// 내가 작성한것에 대해 색상을 바꾼다
							comment.backgroundColor = '#FFF3E0';
						}
						comment.replyIsShow = false;
						comment.next = [];
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
