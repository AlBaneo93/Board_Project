<template>
	<v-dialog :value="setDialog.isShow">
		<v-card>
			<v-card-title>
				{{}}
			</v-card-title>
		</v-card>
	</v-dialog>
</template>

<script>
import http from '@/axios/http-commons';

export default {
	props: {
		setDialog: Object,
		id: Number,
	},
	data() {
		return {
			anotherUser: {},
		};
	},
	methods: {
		getAnotherUserInfo() {
			http.get('/member/' + this.id).then(result => {
				this.anotherUser = result.data.result;
			});
		},
	},
	mounted() {
		this.getAnotherUserInfo();
	},
};
</script>

<style></style>
