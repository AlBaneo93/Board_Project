<template>
	<v-container>
		<Board />
		<Comment />
	</v-container>
</template>

<script>
import Board from '../components/Board';
import Comment from '../components/Comment';
export default {
	components: {
		Board,
		Comment,
	},
};
</script>

<style></style>
