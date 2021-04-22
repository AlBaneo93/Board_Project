<template>
	<v-content>
		<!-- <v-card v-for="(item, i) in images" :key="i" flat>
			<template v-if="i % 2 == 0">
				<transition name="fade">
					<v-img :src="item"></v-img>
				</transition>
			</template>
			<template v-else>
				<transition name="fade">
					<v-img :src="item"> </v-img>
				</transition>
			</template>
		</v-card> -->
		<div>
			<v-btn @click="show1 = show1 ? false : true">show1</v-btn>
			<v-btn @click="show2 = show2 ? false : true">show2</v-btn>
		</div>
		<transition name="fade" appear>
			<v-row v-if="show1">
				<v-col cols="6">
					<v-card min-height="300">
						<v-card-text>
							<h1>About US</h1>
						</v-card-text>
					</v-card>
				</v-col>
				<v-col cols="6">
					<v-card min-height="300"
						><v-img :src="require('@/assets/images/kakaofriends_1.png')"></v-img
					></v-card>
				</v-col>
			</v-row>
		</transition>

		<transition name="slide-fade" appear>
			<v-row v-if="show2">
				<v-col cols="7">
					<v-card min-height="300"
						><v-img :src="require('@/assets/images/kakaofriends_2.png')"></v-img
					></v-card>
				</v-col>
				<v-col cols="5">
					<v-card min-height="300">
						<v-card-text>
							<h1>We make value</h1>
						</v-card-text>
					</v-card>
				</v-col>
			</v-row>
		</transition>
	</v-content>
</template>

<script>
export default {
	data() {
		return {
			images: [
				require('@/assets/images/kakaofriends_1.png'),
				require('@/assets/images/kakaofriends_2.png'),
				require('@/assets/images/kakaofriends_1.png'),
				require('@/assets/images/kakaofriends_2.png'),
			],
			show1: false,
			show2: false,
			show3: false,
		};
	},
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
	transition: opacity 0.5s;
}
.fade-enter,
.fade-leave-to {
	opacity: 0;
}
.slide-fade-enter-active {
	transition: all 0.3s ease;
}
.slide-fade-leave-active {
	transition: all 0.8s cubic-bezier(1, 0.5, 0.8, 1);
}
.slide-fade-enter,
.slide-fade-leave-to {
	transform: translateX(10px);
	opacity: 0;
}
</style>
