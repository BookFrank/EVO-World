<template>
  <div id="tpContainer" style="overflow: hidden">
  </div>
</template>

<script>
  import pageHeader from '@/components/PageHeader.vue'
  import TopoGraph from '../components/modules/TopoGraph'
  import TopoCharts from '../components/modules/TopoCharts'
  import TopoChart from '../components/modules/TopoChart'

  let __options = {
    "nodes": [{
      "clientIp": "30.30.78.24",
      "name": "数据源-bus_changsha",
      "nodeType": "datasource",
      "port": 58830,
      "startTime": "1970-01-19 06:37:02",
      "status": 1
    }, {
      "gatewayIp": "100.81.210.225",
      "name": "网关-100.81.210.225",
      "nodeType": "gateway",
      "status": 1
    }, {
      "ip": "100.81.210.225",
      "name": "转发器-100.81.210.225:40987",
      "nodeType": "transfer",
      "port": 40987,
      "startTime": "1970-01-19 06:09:49",
      "status": 1
    }, {
      "name": "TDS服务器-11.239.164.192",
      "nodeType": "server",
      "port": 8003,
      "status": 1,
      "tdsIp": "11.239.164.192"
    }, {
      "ip": "100.81.210.225",
      "name": "转发器-100.81.210.225:46593",
      "nodeType": "transfer",
      "port": 46593,
      "startTime": "1970-01-19 06:35:30",
      "status": 1
    }, {"name": "TDS服务器-11.239.164.192", "nodeType": "server", "port": 8003, "status": 1, "tdsIp": "11.239.164.192"}],
    "lines": [{"active": "true", "name": "QPM", "source": 0, "status": 1, "target": 1, "value": 4}, {
      "active": "true",
      "name": "推送QPM",
      "source": 1,
      "status": 1,
      "target": 2,
      "value": 0
    }, {"active": "true", "name": "推送QPM", "source": 2, "status": 1, "target": 3, "value": 0}, {
      "active": "true",
      "name": "推送QPM",
      "source": 1,
      "status": 1,
      "target": 4,
      "value": 4
    }, {"active": "true", "name": "推送QPM", "source": 4, "status": 1, "target": 5, "value": 4}]
  };

  var nodes = [
    {name: "湖南邵阳"}, {name: "山东莱州"}, {name: "广东阳江"},
    {name: "山东枣庄"}, {name: "泽"}, {name: "恒"},
    {name: "鑫"}, {name: "明山"}, {name: "班长"}
  ];

  //边集
  var edges = [
    {source: 0, target: 4, relation: "籍贯", value: 1.3},
    {source: 4, target: 5, relation: "舍友", value: 1},
    {source: 4, target: 6, relation: "舍友", value: 1},
    {source: 4, target: 7, relation: "舍友", value: 1},
    {source: 1, target: 6, relation: "籍贯", value: 2},
    {source: 2, target: 5, relation: "籍贯", value: 0.9},
    {source: 3, target: 7, relation: "籍贯", value: 1},
    {source: 5, target: 6, relation: "同学", value: 1.6},
    {source: 6, target: 7, relation: "朋友", value: 0.7},
    {source: 6, target: 8, relation: "职责", value: 2}
  ];

  var __data = {
    nodes: nodes,
    lines: edges
  };

  export default {
    name: 'TcpTopology',
    components: {pageHeader, TopoGraph, TopoChart, TopoCharts},
    data() {
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


      // var tpoption = {
      //   container:'#tpContainer',
      //   data:__options,
      //   width:window.innerWidth || document.documentElement.clientWidth,
      //   height:window.innerHeight || document.documentElement.innerHeight
      // };
      // const topo = new TopoChart.TopoChart();
      // topo.initi(tpoption);

      // const topo = new TopoCharts.TopoChart(tpoption);
      // topo.init();

      // console.log(__options);
      // TopoChart.render("#tpContainer" ,__options);

      if (this.timer) {
        cleanInterval(this.timer);
      } else {
        this.timer = setInterval(() => {
          console.log("haha");
        }, 1000);
      }
    },
    destoryed: function () {
      cleanInterval(this.timer);
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
    color: #fff;
    font-size: 12px;
  }
</style>
