/**
 * Created by xiao on 2017/3/15.
 */

var itemStyle_center = {
    normal: {
        color: 'blue'
    },
    emphasis: {}
};

var itemStyle_prefix = {
    normal: {
        color: 'green'
    },
    emphasis: {}
};

var itemStyle_postfix = {
    normal: {
        color: 'green'
    },
    emphasis: {}
};

var itemStyle_parent = {
    normal: {
        color: 'brown'
    },
    emphasis: {}
};

var itemStyle_kid = {
    normal: {
        color: 'yellow'
    },
    emphasis: {}
};

var edge_label_affix = {
    normal: {
        show: true,
        textStyle: {
            fontWeight: 'bold'
        },
        formatter: '前后'
    },
    emphasis: {
        show: true,
        textStyle: {
            fontWeight: 'bolder'
        },
        formatter: '前后'
    }
};

var edge_label_subordination = {
    normal: {
        show: true,
        textStyle: {
            fontWeight: 'bold'
        },
        formatter: '父子'
    },
    emphasis: {
        show: true,
        textStyle: {
            fontWeight: 'bolder'
        },
        formatter: '父子'
    }
};

var tooltip_global = {
    trigger: 'item',
    triggerOn: 'click',
    enterable: true,
    position: 'right',
    hideDelay: 50,
    formatter: function (params, ticket, callback) {
        var contextPath = "";
        var content = '<div>'
            + 'name:&nbsp;' + params.data.name + '<br/>';
        content += 'description:<br/>'
            + '<p>&nbsp;&nbsp;' + params.data.value.description + '</p>';
        content +=
            '<a href="'
            + contextPath + '/knowledge-point/show?kp_id='
            + params.data.value.id + '">' + '查看详情</a></div>';
        return content;
    }
};

var lineStyle_affix = {
    normal: {
        opacity: 0.6,
        width: 3,
        type: 'solid'
    },
    emphasis: {
        opacity: 1,
        width: 6,
        type: 'solid'
    },
};

var lineStyle_subordination = {
    normal: {
        opacity: 0.6,
        width: 3,
        type: 'dashed'
    }
};

function node_forEach(myChart, node) {
    switch (node.type) {
        case "center":
            node.symbol = "rect";
            node.symbolSize = 50;
            node.itemStyle = itemStyle_center;
            node.x = myChart.getWidth() / 2;
            node.y = myChart.getHeight() / 2;
            break;
        case "prefix":
            node.itemStyle = itemStyle_prefix;
            break;
        case "postfix":
            node.itemStyle = itemStyle_postfix;
            break;
        case "parent":
            node.itemStyle = itemStyle_parent;
            break;
        case "kid":
            node.itemStyle = itemStyle_kid;
            break;
    }
};

function edge_forEach(edge) {
    if (edge.type == "affix") {
        edge.label = edge_label_affix;
        edge.lineStyle = lineStyle_affix;
    } else if (edge.type == "subordination") {
        edge.label = edge_label_subordination;
        edge.lineStyle = lineStyle_subordination;
    }
};

function kp_echarts(myChart, subnet) {

    if (subnet == null) {
        return;
    }

    subnet.nodes.forEach(function (node) {
        node_forEach(myChart, node);
    });

    subnet.edges.forEach(function (edge) {
        edge_forEach(edge);
    });

    option = {
        title: {
            text: subnet.name,
            subtext: 'Default layout',
            top: 'bottom',
            left: 'right'
        },
        tooltip: tooltip_global,

        series: [{
            type: 'graph',
            layout: 'force',
            animation: true,
            roam: true,
            draggable: true,
            focusNodeAdjacency: true,

            symbol: 'circle',
            symbolSize: 50,
            itemStyle: {
                normal: {},
                emphasis: {}
            },

            edgeSymbol: ['circle', 'arrow'],
            edgeSymbolSize: [4, 10],

            lineStyle: {
                normal: {
                    opacity: 0.6,
                    width: 3
                },
                emphasis: {
                    opacity: 1,
                    width: 6
                },
            },

            label: {
                normal: {
                    position: 'inside',
                    show: true
                },
                emphasis: {
                    position: 'inside',
                    show: true
                }
            },

            force: {
                edgeLength: [50, 120],
                repulsion: 120,
                gravity: 0,
                layoutAnimation: true
            },

            nodes: subnet.nodes,
            edges: subnet.edges
        }]
    };

    myChart.setOption(option);

};
