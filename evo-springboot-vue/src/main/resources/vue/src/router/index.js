import Vue from 'vue'
import Router from 'vue-router'

import Topology from '@/pages/TcpTopology'
import TopologyV4 from '@/pages/TopologyV4'
import HelloWorld from '@/pages/HelloWorld'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      redirect: {
        name: 'TopologyV4'
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
    },
    {
      path: '/v4',
      name: 'TopologyV4',
      component: TopologyV4
    }
  ]
})
