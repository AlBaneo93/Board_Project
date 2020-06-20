<template>
  <v-list>
    <v-list-item v-for="(item, i) in myBoardList" :key="i">
      <!-- 클릭하면 그 글이 작성된 페이지나 작성한 페이지로 이동 -->
      <v-list-item-title @click="goBoardDetail(item)">{{
        item.title
        }}
      </v-list-item-title>
    </v-list-item>
  </v-list>
</template>

<script>
  import http from '@/axios/http-commons';

  export default {
    data() {
      return {
        myBoardList: [],
      };
    },
    methods: {
      getMyBoard() {
        http
        .get('/board/' + this.user.id)
        .then(result => {
          this.myBoardList = result.data.result;
        })
        .catch(() => {
          alert('데이터를 가져오는 중 에러가 발생하였습니다');
        });
      },
      goBoardDetail(item) {
        this.$router.push('/boarddetail/' + item.boardid);
      },
    },
  };
</script>

<style></style>
