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
				></v-text-field>
				<v-text-field
					v-model="user.password"
					:counter="20"
					required
					label="password"
				></v-text-field>
				<v-checkbox color="success" label="do you agree" required></v-checkbox>

				<v-card-actions>
					<v-btn outlined warn @click="$emit('closesignin')">go back</v-btn>
					<v-btn outlined @click="signin">sign in</v-btn>
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
			user: {},
		};
	},
	methods: {
		...mapActions(['userLogin']),
		signin() {
			http
				.post('/member', this.user)
				.then(result => {
					console.log(result);
					this.userLogin(result.data.result);
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
};
</script>

<style></style>
