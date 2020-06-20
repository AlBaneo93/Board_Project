<template>
	<v-dialog
		v-model="setDialog.isShow"
		:width="setDialog.width"
		:height="setDialog.height"
		@click:outside="$emit('closesignin')"
		:overlay-color="setDialog.overlay_color"
		:overlay-opacity="setDialog.overlay_opacity"
	>
		<!-- :hide-overlay="setDialog.hide_overlay" -->
		<v-card>
			<v-toolbar boarflat dark color="primary">Sign In</v-toolbar>
			<v-form
				@keydown.enter.capture="signin"
				@keydown.esc.capture="$emit('closesignin')"
			>
				<v-text-field
					v-model="user.email"
					:counter="20"
					required
					label="e-mail"
					autofocus
				></v-text-field>
				<v-text-field
					v-model="user.password"
					:counter="20"
					required
					label="password"
				></v-text-field>

				<v-card-actions>
					<v-btn outlined color="red" @click="$emit('closesignin')"
						>go back
					</v-btn>
					<v-btn outlined color="success" @click="signin">sign in</v-btn>
				</v-card-actions>
			</v-form>
		</v-card>
	</v-dialog>
</template>

<script>
import http from '@/axios/http-commons';
import { mapActions } from 'vuex';

export default {
	props: {
		setDialog: Object,
	},
	data() {
		return {
			user: {
				id: 0,
			},
		};
	},
	methods: {
		...mapActions(['userLogin']),
		signin() {
			http
				.post('/signin', this.user)
				.then(result => {
					this.user = {};
					if (result.data.msg) {
						this.userLogin(result.data.result);
						alert('로그인 성공!');
						this.$emit('closesignin');
						return;
					}
					alert('로그인 실패\n아이디와 패스워드를 다시한번 확인해주세요');
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
};
</script>

<style></style>
