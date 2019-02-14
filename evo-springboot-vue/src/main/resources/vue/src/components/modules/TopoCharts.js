import pic0 from '@/assets/img/clouds/cloud-province.png'
import pic1 from '@/assets/img/clouds/cloud-city.png'
import pic2 from '@/assets/img/clouds/cloud-county.png'
import pic3 from '@/assets/img/clouds/error-tip.png'
import pic4 from '@/assets/img/clouds/link-cut.png'

const imgMap = {
  'gateway': pic0,
  'datasource': pic1,
  'transfer': pic2,
  'server': pic0,
  'error-tip': pic3,
  'link-cut': pic4
};

class TopoChart {

  constructor(option) {
    // 合并配置
    // option = Object.assign(_defaultOption, option);

    this.container = option.container;
    this.width = option.width;
    this.height = option.height;
    this.data = option.data;
  }

  init() {
    // 相关变量创建
    var _this = this,
      width = _this.width,
      height = _this.height,

      lines = _this.data.lines,
      nodes = _this.data.nodes,

      svg = d3.select(_this.container).append("svg")
        .attr("width", width)
        .attr("height", height)
        .style("pointer-events", "all"),
      graph = svg.append("g").attr("class", "graph"),

      _g_lines = graph.selectAll("line.line")
        .data(lines)
        .enter()
        .append("g")
        .attr("class", "line"),
      _g_nodes = graph.selectAll("g.node")
        .data(nodes)
        .enter()
        .append("g")
        .attr("class", "node");

    // Dom 中添加连接线元素，并根据绑定数据状态设置不同颜色
    _g_lines.append("line")
      .style('stroke', function (d) {
        if (d.status == 0) {
          return '#f76e5d';
        } else {
          return '#93c62d';
        }
      })
      .style("stroke-width", 2);

    // Dom 中node添加图片，并根据绑定类型选择不同图片，并根据节点权重设置图片大小
    _g_nodes.append("image")
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
        return imgMap[d.nodeType];
      });

    // Dom 中node添加文本
    _g_nodes.append("text")
      .text(function (d) {
        return d.name;
      })
      .style('font-size', '12')
      .style('fill', '#333');

    // node 中当连接断开时，可以设置 tooltip
    _g_nodes.each(function (d, i) {
      var selection = d3.select(this);
      if (d.status == '0') {
        selection.append("g").attr("class", "error-tip")
          .append("image").attr("xlink:href", function (d) {
          return imgMap['error-tip'];
        });
      }
    });

    _g_lines.each(function (d, i) {
      var _this = d3.select(this);
      // if (d.netspeed && d.status != 0) {
      if (d.status != 0) {
        _this.append("text")
          .text("QPM:"+d.qpm)
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

    var force = d3.layout.force()
      .nodes(nodes)
      .links(lines)
      .size([width, height])
      .linkDistance(function (d) {
        var distance = 90;
        distance += distance * Math.random() * 0.5;
        return distance;
      })
      .charge(-700)
      .start();

    //添加缩放行为
    svg.call(this.getZoomBehavior(graph));

    //添加拖拽行为
    _g_nodes.call(this.getDragBehavior(force));

    // 鼠标悬停事件
    _g_nodes.on('mouseenter', function (d) {
      d3.select(this).style("cursor", "pointer");

      // TODO
      // d3.select(_this.container).append(createInfoTip(d));
      // d3.select(".node-info").css({
      //   left: d3.event.x + 20,
      //   top: d3.event.y + 20
      // }).show();

      d3.select(".node-info").attr('style' ,{
        left: d3.event.x + 20,
        top: d3.event.y + 20
      });

      /**
       * 创建 node 的 Tooltip
       * @param node
       * @returns {string}
       */
      function createInfoTip(node) {
        var html = '<div class="node-info"><ul>';
        html += '<li><span class="info-title">网络情况:</span><span class="info-content">正常</span></li>';
        html += '</ul></div>';

        return html;
      }
    });

    _g_nodes.on('mouseleave', function () {
      // TODO
      d3.select(".node-info").remove();
    });

    _g_nodes.on('dblclick.zoom', function () {
      window.location.href = './index2.html';
    });

    force.on("tick", function () {

      _g_lines.select("line").attr("x1", function (d) {
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


      _g_lines.select("image").attr("x", function (d) {
        var x1 = d.source.x,
          x2 = d.target.x,
          x = x1 - (x1 - x2) / 2;

        //线段二分之一处
        return x - 8;
      })
        .attr("y", function (d) {
          var y1 = d.source.y,
            y2 = d.target.y,
            y = y1 - (y1 - y2) / 2;

          //线段二分之一处
          return y - 15;
        });

      _g_lines.select("text")
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

      _g_lines.select("rect")
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


      _g_nodes.attr("transform", function (d) {

        var image = d3.select(this).select("image")[0][0],
          halfWidth = parseFloat(image.style.width) / 2,
          halfHeight = parseFloat(image.style.height) / 2;

        return 'translate(' + (d.x - halfWidth) + ',' + (d.y - halfHeight) + ')';

      });

      _g_nodes.select("text").attr('dy', function (d) {
        var image = this.previousSibling,
          height = parseFloat(image.style.height),
          fontSize = parseFloat(this.style.fontSize);

        return height + 1.5 * fontSize;
      });

      _g_nodes.select(".error-tip").attr("transform", function (d) {

        var image = this.parentNode.firstChild,
          width = parseFloat(image.style.width);

        return 'translate(' + 0.8 * width + ',0)';

      });

    });

    force.on("end", function () {

    });
  }

  /**
   * 创建一个缩放行为
   * @param g
   */
  getZoomBehavior(g) {
    return d3.behavior.zoom().scaleExtent([1, 10]).on("zoom", zoomEvtFn);

    function zoomEvtFn() {
      g.attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
    }
  }

  /**
   * 创建一个拖拽行为
   * @param force
   */
  getDragBehavior(force) {

    return d3.behavior.drag()
      .origin(function (d) {
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
}

export default {
  TopoChart
}
