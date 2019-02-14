<template>
  <!--<page-header></page-header>-->
  <div id="tpContainer" style="overflow: hidden">
  </div>
  <!--<svg width="800" height="800"></svg>-->
</template>

<script>
  import pageHeader from '@/components/PageHeader.vue'
  import TopoGraph from './modules/TopoGraph'
  import TopoCharts from './modules/TopoCharts'
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

  var nodes = [
    {name:"湖南邵阳"},{name:"山东莱州"},{name:"广东阳江"},
    {name:"山东枣庄"},{name:"泽"},{name:"恒"},
    {name:"鑫"},{name:"明山"},{name:"班长"}
  ];

  //边集
  var edges = [
    {source:0,target:4,relation:"籍贯",value:1.3},
    {source:4,target:5,relation:"舍友",value:1},
    {source:4,target:6,relation:"舍友",value:1},
    {source:4,target:7,relation:"舍友",value:1},
    {source:1,target:6,relation:"籍贯",value:2},
    {source:2,target:5,relation:"籍贯",value:0.9},
    {source:3,target:7,relation:"籍贯",value:1},
    {source:5,target:6,relation:"同学",value:1.6},
    {source:6,target:7,relation:"朋友",value:0.7},
    {source:6,target:8,relation:"职责",value:2}
  ];

  var __data = {
    nodes: nodes,
    lines: edges
  };

  export default {
    name: 'TcpTopology',
    components: {pageHeader, TopoGraph, TopoChart, TopoCharts},
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
      // 可用
      // const topo = new TopoGraph.TopoGraph("#tpContainer" ,__data);
      // topo.render();



      var tpoption = {
        container:'#tpContainer',
        data:__options,
        width:window.innerWidth || document.documentElement.clientWidth,
        height:window.innerHeight || document.documentElement.innerHeight
      };
      // const topo = new TopoChart.TopoChart();
      // topo.initi(tpoption);

      const topo = new TopoCharts.TopoChart(tpoption);
      topo.init();

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
