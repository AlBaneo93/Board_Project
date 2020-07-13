<template>
	<v-content>
		<v-carousel hide-delimiters cycle>
			<v-carousel-item v-for="(item, i) in images" :key="i" :src="item">
			</v-carousel-item>
		</v-carousel>
	</v-content>
</template>

<script>
export default {
	data() {
		return {
			images: [
				require('@/assets/carousel/img1.png'),
				require('@/assets/carousel/img2.png'),
				require('@/assets/carousel/img3.png'),
			],
		};
	},
};
</script>

<style></style>
