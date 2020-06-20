const mutations = {
  userLogin(state, payload) {
    state.islogin = true;
    state.user.email = payload.email;
    state.user.name = payload.name;
    state.user.img = payload.img;
    state.user.accesstoken = payload.accesstoken;
    state.user.refreshtoken = payload.refreshtoken;
  },
  userLogout(state) {
    state.islogin = false;
    state.user = {};
  },
};

export default mutations;
