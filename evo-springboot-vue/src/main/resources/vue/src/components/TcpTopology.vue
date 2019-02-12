<template>
  <!--<page-header></page-header>-->
  <div id="tpContainer" style="overflow: hidden">
  </div>
</template>

<script>
  import pageHeader from '@/components/PageHeader.vue'
  // import TopoChart from '@/components/modules/TopoChart'
  import TopoChart from './modules/TopoChart'

  let __options = {
    "nodes": [
      {
        "name": "四川省政务云",
        "type": "0",
        "status":"0",
        "info":{
          "netstatus":"网络不通"
        }
      },{
        "name": "成都市政务云",
        "type": "1",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "双流区政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "武侯区政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "龙泉驿区政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "南充市政务云",
        "type": "1",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "南部县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "蓬安县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "仪陇县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "绵阳市政务云",
        "type": "1",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "三台县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "梓潼县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      },{
        "name": "盐亭县政务云",
        "type": "2",
        "status":"1",
        "info":{
          "netstatus":"网络良好 "
        }
      }
    ],
    "lines": [{
      "source": 0,
      "target": 1,
      "active": true,
      "status":0,
      "netspeed":"1024MB/s"
    }, {
      "source": 0,
      "target": 5,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 0,
      "target": 9,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 1,
      "target": 2,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 1,
      "target": 3,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 1,
      "target": 4,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 5,
      "target": 6,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 5,
      "target": 7,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 5,
      "target": 8,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 9,
      "target": 10,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 9,
      "target": 11,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    },{
      "source": 9,
      "target": 12,
      "active": true,
      "status":1,
      "netspeed":"1024MB/s"
    }]
  };

  export default {
    name: 'TcpTopology',
    components: {pageHeader, TopoChart},
    data () {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    },
    methods: {
      alert: function () {
        alert("Hello World" + this.slogon);
      },
      welcome: function () {
        alert('The wandering earth');
      }
    },
    mounted: function () {
      const topo = new TopoChart.TopoChart("#tpContainer" ,__options);
      // const topo = new TopoChart.TopoChart("#app" ,__options);

      topo.render();
      // console.log(__options);
      // TopoChart.render("#tpContainer" ,__options);
    }
  }
</script>

<style scoped>
  .node-info {
    position: absolute;
    display: none;
    border-radius: 0.5em;
    background: #555;

  }

  .node-info ul {
    margin: 0;
    padding: 0.5em;
    list-style: none;
  }

  .node-info ul li {
    color:#fff;
    font-size: 12px;
  }
</style>
