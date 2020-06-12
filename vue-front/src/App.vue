<template>
	<v-app>
		<Header />
		<Body />
		<Footer />
	</v-app>
</template>

<script>
import Header from './views/Header';
import Footer from './views/Footer';
import Body from './views/Body';

export default {
	name: 'App',

	components: {
		Header,
		Footer,
		Body,
	},
};
</script>
