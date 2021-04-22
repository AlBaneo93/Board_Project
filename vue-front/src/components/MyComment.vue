<template>
	<!-- 내가 작성한 댓글들만 따로 보여준다 -->
	<v-list>
		<v-list-item v-for="(item, i) in myComments" :key="i">
			<v-list-item-title
				>{{ item.title }}
				<v-spacer></v-spacer>
				{{ item.boardtitle }}
			</v-list-item-title>
		</v-list-item>
	</v-list>
</template>

<script>
import http from '@/axios/http-commons';

export default {
	data() {
		return {
			myComments: [],
		};
	},
	methods: {
		getMyComment() {
			http
				.get('/comment/' + this.user.id)
				.then(result => {
					this.myComment = result.data.result;
				})
				.catch(() => {
					alert('데이터를 가져오는 중 에러가 발생하였습니다');
				});
		},
	},
	mounted() {},
};
</script>

<style></style>
