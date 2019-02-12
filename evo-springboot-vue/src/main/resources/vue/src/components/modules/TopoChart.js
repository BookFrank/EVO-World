import pic0 from '@/assets/img/clouds/cloud-province.png'
import pic1 from '@/assets/img/clouds/cloud-city.png'
import pic2 from '@/assets/img/clouds/cloud-county.png'
import pic3 from '@/assets/img/clouds/error-tip.png'
import pic4 from '@/assets/img/clouds/link-cut.png'

const imgMap = {
  '0': pic0,
  '1': pic1,
  '2': pic2,
  'error-tip': pic3,
  'link-cut': pic4
};

const tpOption = {
  container: '#tpContainer',
  data: 'clouds-tp.json',
  width: window.innerWidth || document.documentElement.clientWidth,
  height: window.innerHeight || document.documentElement.innerHeight
};

// 默认配置
const _defaultOption = {
  width: 300,
  height: 300
  // data: '',
  // container: ''
};

class TopoChart {

  constructor(container, option) {
    // 合并配置
    option = Object.assign(_defaultOption, option);

    this.container = container;

    // this.width = option.width;
    this.width = window.innerWidth || document.documentElement.clientWidth;
    // this.height = option.height;
    this.height = window.innerHeight || document.documentElement.innerHeight;
    // 数据url或对象,必填
    this.data = option;
    // 创建画布
    this.svg = d3.select(container).append("svg").attr("width", this.width).attr("height", this.height).style("pointer-events", "all");
    this.graph = this.svg.append("g").attr("class", "graph");
  }


  init(){
    this._g_lines = this.graph.selectAll("line.line")
      .data(this.data.lines)
      .enter()
      .append("g")
      .attr("class", "line");

    this._g_nodes = this.graph.selectAll("g.node")
      .data(this.data.nodes)
      .enter()
      .append("g")
      .attr("class", "node");

    this._g_lines.append("line")
      .style('stroke', function (d) {
        if (d.status == 0) {
          return '#f76e5d';
        } else {
          return '#93c62d';
        }
      }).style("stroke-width", 2);

    this._g_nodes.append("image")
      .style("width", function (d) {
        var width = 40;
        switch (d.type) {
          case '0':
            width = 1.5 * width;
            break;
          case '1':
            width = 1.2 * width;
            break;
          default:
            break;
        }
        return width;
      }).style("height", function (d) {
        var height = 40;
        switch (d.type) {
          case '0':
            height = 1.5 * height;
            break;
          case '1':
            height = 1.2 * height;
            break;
          default:
            break;
        }
        return height;
      }).attr("xlink:href", function (d) {
        return imgMap[d.type];
      });

    this._g_nodes.append("text")
      .text(function (d) {
        return d.name;
      })
      .style('font-size', '12')
      .style('fill', '#333');

    this._g_nodes.each(function (d, i) {
      var selection = d3.select(this);
      if (d.status == '0') {
        selection.append("g").attr("class", "error-tip")
          .append("image").attr("xlink:href", function (d) {
          return imgMap['error-tip'];
        });
      }
    });

    this._g_lines.each(function (d, i) {
      var _this = d3.select(this);
      if (d.netspeed && d.status != 0) {
        _this.append("text")
          .text(d.netspeed)
          .style('fill', 'rgb(255,198,22)')
          .style('font-size', '11');

        _this.append("rect")
          .attr("fill", function (d) {
            return '#555';
          })
          .attr("width", function (d) {
            return 2;
          })
          .attr("height", function (d) {
            return 2;
          })
          .append("animate");

        _this.select("rect").append("animate");
      } else {
        _this.append("image")
          .attr("xlink:href", function () {
            return imgMap['link-cut'];
          });
      }
    });
  }

  // 初始化节点数据
  initNodes() {
    // svg中创建node元素
    console.log(this.data.nodes);
    this._g_nodes = this.graph.selectAll("g.node")
      .data(this.data.nodes)
      .enter()
      .append("g")
      .attr("class", "node");

    // node增加图片头像
    this._g_nodes.append("image")
      .style("width", function (d) {
        var width = 40;
        switch (d.type) {
          case '0':
            width = 1.5 * width;
            break;
          case '1':
            width = 1.2 * width;
            break;
          default:
            break;
        }
        return width;
      })
      .style("height", function (d) {
        var height = 40;
        switch (d.type) {
          case '0':
            height = 1.5 * height;
            break;
          case '1':
            height = 1.2 * height;
            break;
          default:
            break;
        }
        return height;
      })
      .attr("xlink:href", function (d) {
        return imgMap[d.type];
      });

    // node 增加文字说明
    this._g_nodes.append("text")
      .text(function (d) {
        return d.name;
      })
      .style('font-size', '12')
      .style('fill', '#333');

    this._g_nodes.each(function (d, i) {
      var selection = d3.select(this);
      if (d.status == '0') {
        selection.append("g").attr("class", "error-tip")
          .append("image").attr("xlink:href", function (d) {
          return imgMap['error-tip'];
        });
      }
    });
  }

  initLines() {
    this._g_lines = this.graph.selectAll("line.line")
      .data(this.data.lines)
      .enter()
      .append("g")
      .attr("class", "line");

    this._g_lines.append("line")
      .style('stroke', function (d) {
        if (d.status == 0) {
          return '#f76e5d';
        } else {
          return '#93c62d';
        }
      })
      .style("stroke-width", 2);

    this._g_lines.each(function (d, i) {
      var _this = d3.select(this);
      if (d.netspeed && d.status != 0) {
        _this.append("text")
          .text(d.netspeed)
          .style('fill', 'rgb(255,198,22)')
          .style('font-size', '11');

        _this.append("rect")
          .attr("fill", function (d) {
            return '#555';
          })
          .attr("width", function (d) {
            return 2;
          })
          .attr("height", function (d) {
            return 2;
          })
          .append("animate");

        _this.select("rect").append("animate");
      } else {
        _this.append("image")
          .attr("xlink:href", function () {
            return imgMap['link-cut'];
          });
      }
    });
  }

  ticked() {
    this._g_lines.select("line").attr("x1", function (d) {
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

    this._g_lines.select("image").attr("x", function (d) {
      var x1 = d.source.x,
        x2 = d.target.x,
        x = x1 - (x1 - x2) / 2;

      //线段二分之一处
      return x - 8;
    }).attr("y", function (d) {
      var y1 = d.source.y,
        y2 = d.target.y,
        y = y1 - (y1 - y2) / 2;

      //线段二分之一处
      return y - 15;
    });

    this._g_lines.select("text")
      .attr('x', function (d) {
        var x1 = d.source.x,
          x2 = d.target.x,
          halfX = x1 - (x1 - x2) / 2,
          x3 = x1 - (x1 - halfX) / 2;

        //线段3分之-处
        return x3;
        //return d.source.x-(d.source.x-d.target.x)/2;
      })
      .attr('y', function (d) {
        var y1 = d.source.y,
          y2 = d.target.y,
          halfY = y1 - (y1 - y2) / 2,
          y3 = y1 - (y1 - halfY) / 2;

        //使文本与线段之间有一定间隙
        y3 = y3 - 5;

        return y3;
        //return y1-(y1-y2)/2;
      })
      .attr("transform", function (d) {
        var x1 = d.source.x,
          x2 = d.target.x,
          y1 = d.source.y,
          y2 = d.target.y,
          x = x1 - (x1 - x2) / 2,
          y = y1 - (y1 - y2) / 2,
          rightAngleSide1 = Math.abs(y2 - y1),
          rightAngleSide2 = Math.abs(x2 - x1),
          _asin = 0,
          _rotateAngle = 0,
          x3 = x1 - (x1 - x) / 2,
          y3 = y1 - (y1 - y) / 2;

        if (x1 < x2) {
          _asin = (y2 - y1) / Math.sqrt(Math.pow(rightAngleSide1, 2) + Math.pow(rightAngleSide2, 2));
          _rotateAngle = Math.asin(_asin) * 180 / Math.PI;
        } else {
          _asin = (y1 - y2) / Math.sqrt(Math.pow(rightAngleSide1, 2) + Math.pow(rightAngleSide2, 2));
          _rotateAngle = Math.asin(_asin) * 180 / Math.PI;
          _rotateAngle = _rotateAngle < 0 ? (180 + _rotateAngle) : -(180 - _rotateAngle);
        }


        return 'rotate(' + (_rotateAngle) + ',' + x3 + ' ' + y3 + ')';//以线段的三分之一出为旋转焦点
        //return 'rotate('+(_rotateAngle)+','+x+' '+y+')';//以线段的二分之一处为旋转焦点
      });

    this._g_lines.select("rect")
      .attr('x', function (d) {
        return d.source.x - 1;
      })
      .attr('y', function (d) {
        return d.source.y - 1;
      })
      .selectAll('animate').each(function (d, i) {
      if (i == 0) {
        d3.select(this)
          .attr("attributeName", function (d) {
            return 'x';
          })
          .attr("from", function (d) {
            return d.source.x - 1;
          })
          .attr("to", function (d) {
            return d.target.x;
          });
      } else {
        d3.select(this)
          .attr("attributeName", function (d) {
            return 'y';
          })
          .attr("from", function (d) {
            return d.source.y - 1;
          })
          .attr("to", function (d) {
            return d.target.y;
          });
      }

      d3.select(this).attr("attributeType", "XML")
        .attr("dur", function (d) {
          return '1.5s';
        })
        .attr("repeatCount", "indefinite");

    });

    this._g_nodes.attr("transform", function (d) {
      console.log(d3.select(this).select("image"));
      var image = d3.select(this).select("image")[0][0],
        halfWidth = parseFloat(image.style.width) / 2,
        halfHeight = parseFloat(image.style.height) / 2;

      return 'translate(' + (d.x - halfWidth) + ',' + (d.y - halfHeight) + ')';
    });

    this._g_nodes.select("text").attr('dy', function (d) {
      var image = this.previousSibling,
        height = parseFloat(image.style.height),
        fontSize = parseFloat(this.style.fontSize);

      return height + 1.5 * fontSize;
    });

    this._g_nodes.select(".error-tip").attr("transform", function (d) {

      var image = this.parentNode.firstChild,
        width = parseFloat(image.style.width);

      return 'translate(' + 0.8 * width + ',0)';
    });
  }

  //创建一个缩放行为
  getZoomBehavior(g){
    return d3.behavior.zoom().scaleExtent([1,10]).on("zoom",zoomEvtFn);

    function zoomEvtFn(){
      g.attr("transform","translate("+d3.event.translate+")scale(" + d3.event.scale + ")");
    }
  }

  //创建一个拖拽行为
  getDragBehavior(force){
    return d3.behavior.drag()
      .origin(function(d) {
        return d;
      })
      .on("dragstart", dragstart)
      .on("drag", dragging)
      .on("dragend", dragend);

    function dragstart(d) {
      d3.event.sourceEvent.stopPropagation();
      d3.select(this).classed("dragging", true);
      force.start();
    }

    function dragging(d) {
      d.x = d3.event.x;
      d.y = d3.event.y;
    }

    function dragend(d) {
      d3.select(this).classed("dragging", false);
    }
  }

  createInfoTip(node){
    var html = '<div class="node-info"><ul>';
    html += '<li><span class="info-title">网络情况:</span><span class="info-content">正常</span></li>';
    html += '</ul></div>';

    return html;
  }

  //直线方程求x值
  x_linearEquation(x1,y1,x2,y2,y){
    var a = y2-y1,
      b = x1-x2,
      c = x2*y1 - x1*y2;

    return -(c+b*y)/a;
  }

  //直线方程求y值
  y_linearEquation(x1,y1,x2,y2,x){
    var a = y2-y1,
      b = x1-x2,
      c = x2*y1 - x1*y2;

    return -(c+a*y)/b;
  }





  render() {
    // this.initLines();
    // this.initNodes();

    this.init();

    // // 新建一个力导向图
    // var forceSimulation = d3.forceSimulation()
    //   .force("link", d3.forceLink())
    //   .force("charge", d3.forceManyBody())
    //   .force("center", d3.forceCenter());
    // //生成节点数据
    //
    // //这个函数很重要，后面给出具体实现和说明
    // forceSimulation.nodes(this.data.nodes)
    //   .on("tick", this.ticked());
    // //生成边数据
    // forceSimulation.force("link")
    //   .links(this.data.lines)
    //   .distance(function (d) {//每一边的长度
    //     return d.value * 100;
    //   });
    // //设置图形的中心位置
    // forceSimulation.force("center")
    //   .x(this.width / 2)
    //   .y(this.height / 2);

    var force = d3.layout.force()
      .nodes(this.data.nodes)
      .links(this.data.lines)
      .size([this.width, this.height])
      .linkDistance(function (d) {
        var distance = 90;
        distance += distance * Math.random() * 0.5;
        return distance;
      })
      .charge(-700)
      .start();

    //添加缩放行为
    this.svg.call(this.getZoomBehavior(this.graph));

    //添加拖拽行为
    this._g_nodes.call(this.getDragBehavior(force));

    force.on("tick", this.ticked());

    this._g_nodes.on('mouseenter',function(d){
      d3.select(this).style("cursor","pointer");

      d3.select(this.container).append(this.createInfoTip(d));
      // $(".node-info").css({
      //   left:d3.event.x+20,
      //   top:d3.event.y+20
      // }).show();
    });

    this._g_nodes.on('mouseleave',function(){
      // $(".node-info").remove();
    });


    this._g_nodes.on('dblclick.zoom',function(){
      window.location.href = './index2.html';
    });
  }
}

export default {
  TopoChart
}
