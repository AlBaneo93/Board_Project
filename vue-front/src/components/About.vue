<template>
	<v-content>
		<!-- <transition> -->
		<v-card>
			<v-img
				v-for="i in images"
				:key="i"
				height="600"
				width="800"
				:src="images[i]"
			/>
		</v-card>
		<!-- </transition> -->
		<!-- <transition> -->
		<!-- <v-img height="600" width="800" :src="@/assets/images/kakaofriends_2.png" /> -->
		<!-- </transition> -->
		<!-- <transition> -->
		<!-- <v-img height="600" width="800" :src="@/assets/images/kakaofriends_3.png" /> -->
		<!-- </transition> -->
	</v-content>
</template>

<script>
export default {
	data() {
		return {
			images: [
				'@/assets/images/kakaofriends_1.png',
				'@/assets/images/kakaofriends_2.png',
				'@/assets/images/kakaofriends_3.png',
			],
		};
	},
};
</script>

<style></style>
