<template>
  <div>
    <h1>{{ user.name }}님 안녕하세요</h1>
  </div>
</template>

<script>
  import {mapGetters} from 'vuex';

  export default {
    computed: {
      ...mapGetters(['user']),
    },
  };
</script>

<style></style>
