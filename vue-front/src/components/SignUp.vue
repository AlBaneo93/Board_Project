<template>
	<v-dialog
		v-model="setDialog.isShow"
		:width="setDialog.width"
		:height="setDialog.height"
		@click:outside="$emit('closesignup')"
		:overlay-color="setDialog.overlay_color"
	>
		<!-- :hide-overlay="setDialog.hide_overlay" -->
		<v-card>
			<v-toolbar flat dark color="primary">Sign Up</v-toolbar>
			<v-form
				@keydown.enter.capture="signup"
				@keydown.esc.capture="$emit('closesignup')"
			>
				<v-text-field
					label="email"
					required
					v-model="user.email"
				></v-text-field>
				<v-text-field
					label="password"
					required
					v-model="user.password"
				></v-text-field>
				<v-text-field
					label="password check"
					required
					v-model="user.password2"
				></v-text-field>
				<v-text-field label="name" required v-model="user.name"></v-text-field>
				<v-file-input label="img" required v-model="user.img"></v-file-input>
				<v-card-actions>
					<v-btn outlined @click="$emit('closesignup')">go back</v-btn>
					<v-btn outlined @click="signup">sign up</v-btn>
				</v-card-actions>
			</v-form>
		</v-card>
	</v-dialog>
</template>

<script>
import http from '../axios/http-commons';

export default {
	props: {
		setDialog: Object,
	},
	data() {
		return {
			user: {},
		};
	},
	methods: {
		signup() {
			http
				.post('/member', this.user)
				.then(result => {
					if (result.data.msg) {
						alert('회원가입이 성공적으로 완료되었습니다');
					}
				})
				.catch(() => {
					alert('회원 가입중 오류가 발생하였습니다.');
				});
		},
	},
};
</script>

<style></style>
