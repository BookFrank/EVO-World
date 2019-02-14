class TopoGraph {

  constructor(container, option) {
    // 合并配置
    // option = Object.assign(_defaultOption, option);

    this.container = container;

    // this.width = option.width;
    this.width = window.innerWidth || document.documentElement.clientWidth;
    // this.height = option.height;
    this.height = window.innerHeight || document.documentElement.innerHeight;
    // 数据url或对象,必填
    this.data = option;
    this.nodes = option.nodes;
    this.lines = option.lines;
  }

  render() {
    var margin = {top: 60, bottom: 60, left: 60, right: 60};
    var svg = d3.select("svg");
    var width = svg.attr("width");
    var height = svg.attr("height");
    var g = svg.append("g").attr("transform", "translate(" + margin.top + "," + margin.left + ")");

    //准备数据 节点集
    var nodes = this.nodes;
    var edges = this.lines;

    //设置一个color的颜色比例尺，为了让不同的扇形呈现不同的颜色
    var colorScale = d3.scaleOrdinal()
      .domain(d3.range(nodes.length))
      .range(d3.schemeCategory10);

    // 新建一个力导向图
    var forceSimulation = d3.forceSimulation()
      .force("link", d3.forceLink())
      .force("charge", d3.forceManyBody())
      .force("center", d3.forceCenter());
    //生成节点数据
    // tick 这个函数很重要，后面给出具体实现和说明
    forceSimulation.nodes(nodes)
      .on("tick", ticked);
    //生成边数据
    forceSimulation.force("link")
      .links(edges)
      .distance(function (d) {//每一边的长度
        return d.value * 100;
      })
    //设置图形的中心位置
    forceSimulation.force("center")
      .x(width / 2)
      .y(height / 2);
    //在浏览器的控制台输出
    console.log(nodes);
    console.log(edges);

    //绘制边
    var links = g.append("g")
      .selectAll("line")
      .data(edges)
      .enter()
      .append("line")
      .attr("stroke", function (d, i) {
        return colorScale(i);
      })
      .attr("stroke-width", 1);

    var linksText = g.append("g")
      .selectAll("text")
      .data(edges)
      .enter()
      .append("text")
      .text(function (d) {
        return d.relation;
      })

    var gs = g.selectAll(".circleText")
      .data(nodes)
      .enter()
      .append("g")
      .attr("transform", function (d, i) {
        var cirX = d.x;
        var cirY = d.y;
        return "translate(" + cirX + "," + cirY + ")";
      })
      .call(d3.drag()
        .on("start", started)
        .on("drag", dragged)
        .on("end", ended)
      );

    //绘制节点
    gs.append("circle")
      .attr("r", 10)
      .attr("fill", function (d, i) {
        return colorScale(i);
      })
    //文字
    gs.append("text")
      .attr("x", -10)
      .attr("y", -20)
      .attr("dy", 10)
      .text(function (d) {
        return d.name;
      })

    function ticked() {
      links
        .attr("x1", function (d) {
          return d.source.x;
        })
        .attr("y1", function (d) {
          return d.source.y;
        })
        .attr("x2", function (d) {
          return d.target.x;
        })
        .attr("y2", function (d) {
          return d.target.y;
        });

      linksText
        .attr("x", function (d) {
          return (d.source.x + d.target.x) / 2;
        })
        .attr("y", function (d) {
          return (d.source.y + d.target.y) / 2;
        });

      gs
        .attr("transform", function (d) {
          return "translate(" + d.x + "," + d.y + ")";
        });
    }

    function started(d) {
      if (!d3.event.active) {
        forceSimulation.alphaTarget(0.8).restart();// 设置衰减系数，对节点位置移动过程的模拟，数值越高移动越快，数值范围[0，1]
      }
      d.fx = d.x;
      d.fy = d.y;
    }

    function dragged(d) {
      d.fx = d3.event.x;
      d.fy = d3.event.y;
    }

    function ended(d) {
      if (!d3.event.active) {
        forceSimulation.alphaTarget(0);
      }
      d.fx = null;
      d.fy = null;
    }
  }
}

export default {
  TopoGraph
}

