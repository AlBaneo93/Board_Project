<template>
  <v-container>
    <v-form fluid>
      <v-row justify="center" align="center">
        <v-col cols="10">
          <v-text-field prepend-icon="mdi-plus" v-model="commentValue"/>
        </v-col>
        <v-col cols="2">
          <v-btn @click="addComment(comments)">댓글 등록</v-btn>
        </v-col>
      </v-row>
    </v-form>
  </v-container>
</template>

<script>
  export default {};
</script>

<style></style>
