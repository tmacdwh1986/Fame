const state = () => ({
  data: []
})

const mutations = {
  SET_DATA (state, data) {
    state.data = data
  }
}

const actions = {
  SET_DATA: ({ commit }, data) => {
    commit('SET_DATA', data)
  }
}

export default { namespaced: true, state, mutations, actions }
