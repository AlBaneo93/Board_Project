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
				'@/assets/carousel/img1.png',
				'@/assets/carousel/img2.png',
				'@/assets/carousel/img3.png',
			],
		};
	},
};
</script>

<style></style>
