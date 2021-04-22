<template>
	<v-dialog
		v-model="setDialog.isShow"
		:width="setDialog.width"
		:height="setDialog.height"
		@click:outside="$emit('closeNotice')"
		:overlay-color="setDialog.overlay_color"
	>
		<v-card flat>
			<v-card-title color="indigo lighten-1">공지사항입니다</v-card-title>

			<v-card-actions>
				<v-btn color="indigo lighten-1" @click="$emit('closeNotice')"
					>닫기</v-btn
				>
				<!-- 체크박스로 바꾼다 -->
				<v-checkbox
					label="Remember me in a day"
					v-model="isRemember"
					color="indigo lighten-1"
					>Remeber Me</v-checkbox
				>
			</v-card-actions>
		</v-card>
	</v-dialog>
</template>

<script>
export default {
	name: 'NOTICE',
	props: {
		setDialog: Object,
	},
	data() {
		return {
			isRemember: false,
		};
	},
	methods: {
		rememeber() {
			if (this.isRemember) {
				window.localStorage.setItem('remember', 'true');
			} else {
				window.localStorage.removeItem('remember');
			}
		},
	},
};
</script>

<style></style>
