import Vue from 'vue'
import Router from 'vue-router'

import Topology from '@/components/TcpTopology'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: {
        name: 'Topology'
      },
    },
    {
      path: '/hi',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/top',
      name: 'Topology',
      component: Topology
    }
  ]
})
