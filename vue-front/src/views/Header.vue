<template>
	<v-container fluid dense class="indigo lighten-1 white--text text-center">
		<!-- height="50%" -->
		<v-row justify="center" align="center" fluid dense>
			<v-col cols="2">
				<router-link to="/">HOME</router-link>
			</v-col>
			<v-spacer></v-spacer>
			<v-col cols="1">
				<router-link to="/board">Board</router-link>
			</v-col>
			<v-col cols="1">
				<router-link to="/about">About</router-link>
			</v-col>
			<template v-if="islogin">
				<v-col cols="1">
					<router-link to="/profile">{{ user.name }}</router-link>
				</v-col>
				<v-col>
					<v-btn @click="signOut" color="red" outlined>Sign Out</v-btn>
				</v-col>
			</template>
			<template v-else>
				<v-col cols="1">
					<a @click="openDialog(1)" style="text-decoration:none; color:white;"
						>SignIn</a
					>
				</v-col>
				<v-col cols="1">
					<a @click="openDialog(2)" style="text-decoration:none; color:white;">
						SignUp
					</a>
				</v-col>
			</template>
		</v-row>
		<SignIn :setDialog="setSignIn" @closesignin="closeDialog(1)" />
		<SignUp :setDialog="setSignUp" @closesignup="closeDialog(2)" />
		<Notice :setDialog="setNotice" @closeNotice="closeDialog(3)" />
	</v-container>
</template>

<script>
import SignIn from '@/components/SignIn';
import SignUp from '@/components/SignUp';
import Notice from '@/components/Notice_dialog';

import { mapGetters, mapActions } from 'vuex';

export default {
	components: {
		SignIn,
		SignUp,
		Notice,
	},
	data() {
		return {
			setSignIn: {
				isShow: false,
				width: 500,
				height: 500,
				hide_overlay: true,
				overlay_color: 'white',
				overlay_opacity: '90%',
			},
			setSignUp: {
				isShow: false,
				width: 500,
				height: 500,
				hide_overlay: true,
				overlay_color: 'white',
				overlay_opacity: '90%',
			},
			setNotice: {
				isShow: true,
				width: 500,
				height: 500,
				hide_overlay: true,
				overlay_color: 'white',
				overlay_opacity: '90%',
			},
		};
	},
	computed: {
		...mapGetters(['user', 'islogin']),
	},
	methods: {
		...mapActions(['userLogout']),
		closeDialog(val) {
			if (val === 1) {
				this.setSignIn.isShow = false;
			} else if (val === 2) {
				this.setSignUp.isShow = false;
			} else if (val == 3) {
				this.setNotice.isShow = false;
			}
		},
		openDialog(val) {
			if (val === 1) {
				this.setSignIn.isShow = true;
			} else if (val === 2) {
				this.setSignUp.isShow = true;
			} else if (val == 3) {
				this.setNotice.isShow = true;
			}
		},
		signOut() {
			this.userLogout();
			if (window.location.pathname !== '/') this.$router.replace('/');
		},
	},
};
</script>

<style scoped>
a:link {
	color: white;
	text-decoration: none;
}
a:visited {
	color: white;
}
</style>
