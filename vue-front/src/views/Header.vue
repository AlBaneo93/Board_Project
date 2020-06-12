<template>
	<v-system-bar fluid height="50%">
		<router-link to="/">HOME</router-link>
		<v-spacer></v-spacer>
		<router-link to="/board">Board</router-link>

		<v-btn @click="open(1)">
			SignIn
		</v-btn>
		<v-btn @click="open(2)">
			SignUp
		</v-btn>

		<SignIn :setDialog="setSignIn" @closesignin="close(1)" />
		<SignUp :setDialog="setSignUp" @closesignup="close(2)" />
	</v-system-bar>
</template>

<script>
import SignIn from '@/components/SignIn';
import SignUp from '@/components/SignUp';

export default {
	components: {
		SignIn,
		SignUp,
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
		};
	},
	methods: {
		close(val) {
			if (val === 1) {
				this.setSignIn.isShow = false;
			} else if (val === 2) {
				this.setSignUp.isShow = false;
			}
		},
		open(val) {
			if (val === 1) {
				this.setSignIn.isShow = true;
			} else if (val === 2) {
				this.setSignUp.isShow = true;
			}
		},
	},
};
</script>

<style></style>
