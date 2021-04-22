<template>
	<v-content height="100%">
		<!-- 얘를 이용해서 페이지 이동효과를 줄 수 있나보다 -->
		<transition>
			<router-view />
		</transition>
	</v-content>
</template>

<script>
export default {};
</script>

<style></style>
