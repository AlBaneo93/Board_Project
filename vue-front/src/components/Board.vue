<template>
	<v-container>
		<v-row justify="end">
			<v-btn @click="$router.push('/editor')">게시글 작성</v-btn>
		</v-row>
		<!-- TODO : To implement data table  -->
		<!-- <v-card>
			<v-data-table
				:loading="progress"
				:headers="headers"
				:items="boardlist"
				no-data-text="게시글이 존재하지 않습니다"
			>
			</v-data-table>
		</v-card> -->
		<v-card>
			<table width="100%">
				<thead>
					<tr>
						<td style="text-align:center;">
							제목
						</td>
						<td style="width:10%">
							작성자
						</td>
						<td style="width:10%">게시일</td>
					</tr>
				</thead>
				<tbody v-for="(board, i) in boardlist" :key="i">
					<tr
						style="width:100%;"
						@click.capture="goBoardDetail(board.id)"
						@mouseover.capture="overEvent"
						@mouseout.capture="outEvent"
					>
						<td>
							{{ board.title }}

							<v-spacer></v-spacer>
							<v-divider vertical></v-divider>
						</td>
						<td>
							{{ board.writer }}
						</td>
						<td>
							{{ board.createdat }}
						</td>
					</tr>
				</tbody>
			</table>
		</v-card>
	</v-container>
</template>

<script>
import http from '@/axios/http-commons';
import { mapGetters } from 'vuex';
export default {
	data() {
		return {
			progress: true,
			boardlist: [
				{
					id: 1,
					title: '123',
					name: 'name1',
					content: '1번 게시글의 내용',
					writer: '1',
				},
				{
					id: 2,
					title: '234',
					name: 'name2',
					writer: '2',
				},
				{
					id: 3,
					title: '345',
					name: 'name3',
					writer: '3',
				},
			],
			headers: [
				{ text: '제목', vlaue: 'title', align: 'center' },
				{ text: '작성자', vlaue: 'writer', align: 'right' },
				{ text: 'name', vlaue: 'name', align: 'right' },
				{ text: '게시일', vlaue: 'id', align: 'right' },
			],
		};
	},
	computed: {
		...mapGetters(['user']),
	},
	methods: {
		getBoardList() {
			this.progress = true;
			http
				.get('/boardlist')
				.then(result => {
					this.boardList = result.data.result;
				})
				.catch(err => {
					console.log(err);
				});
			this.progress = false;
		},
		goBoardDetail(id) {
			this.$router.push('/board/' + id);
		},
		overEvent(event) {
			// 색 변경
			// console.log(event);
			let targetTR = event.target.parentNode;
			targetTR.style.backgroundColor = '#ECEFF1';
			// targetTR.children.array.forEach(element => {
			// 	element.style.backgroundColor = '#ECEFF1';
			// });
		},
		outEvent(event) {
			// 색 원복
			// console.log(event);
			let targetTR = event.target.parentNode;
			targetTR.style.backgroundColor = 'white';
			// targetTR.children.array.forEach(element => {
			// 	element.style.backgroundColor = 'white';
			// });
		},
	},
	mounted() {
		this.getBoardList();
	},
};
</script>

<style></style>
