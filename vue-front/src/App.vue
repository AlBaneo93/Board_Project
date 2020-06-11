<template>
	<v-app>
		<Board />
	</v-app>
</template>

<script>
import Board from './components/Board';

export default {
	name: 'App',

	components: {
		Board,
	},
};
</script>
