<template>
	<v-card>
		<v-card-title>{{ board.title }}</v-card-title>
		<v-card-content>{{ board.content }}</v-card-content>
	</v-card>
</template>

<script>
export default {
	props: {
		board: Object,
	},
};
</script>

<style></style>
