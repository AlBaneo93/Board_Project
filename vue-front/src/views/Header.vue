<template>
	<v-system-bar fluid height="50%">
		<v-row>
			<v-col>
				<router-link to="/">HOME</router-link>
			</v-col>
			<v-spacer></v-spacer>
			<v-col :cols="1">
				<router-link to="/board">Board</router-link>
			</v-col>
			<!-- TODO : slot으로 바꿀 수 있다 -->
			<template v-if="user.islogin">
				<v-col :cols="1">
					<router-link to="/profile">{{ user.name }}</router-link>
				</v-col>
			</template>
			<template v-else>
				<v-btn @click="open(1)">
					SignIn
				</v-btn>
				<v-btn @click="open(2)">
					SignUp
				</v-btn>
			</template>
		</v-row>
		<SignIn :setDialog="setSignIn" @closesignin="close(1)" />
		<SignUp :setDialog="setSignUp" @closesignup="close(2)" />
	</v-system-bar>
</template>

<script>
import SignIn from '@/components/SignIn';
import SignUp from '@/components/SignUp';

import { mapGetters } from 'vuex';

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
	computed: {
		...mapGetters(['user']),
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
