<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huitianrui
  Date: 2017/5/28
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选座</title>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/static/css/jquery.seat-charts.css">
    <link rel="stylesheet" type="text/css" href="/static/css/seat-style.css">

</head>
<body>

<p>${cinema.cinemaName}</p>
<p>${movie.movieName}</p>
<p>${cutting.startDate}</p>
<p>${cutting.startTime} ${cutting.length}分钟</p>
<p>${cutting.hallNumber}号厅</p>

<div class="wrapper">
    <div class="container">
        <div id="seat-map">
            <div class="front-indicator">大银幕</div>

        </div>
        <div id="legend"></div>
        <div class="booking-details">
            <h2>选座详情</h2>

            <h3> 已选座位 (<span id="counter">0</span>):</h3>
            <ul id="selected-seats"></ul>

            总价: <b>￥<span id="total">0</span></b>

            <button id="checkout" class="checkout-button">确认订单 &raquo;</button>

        </div>
    </div>
</div>

<script src="/static/scripts/jquery-3.1.1.min.js"></script>
<script src="/static/scripts/jquery.seat-charts.js"></script>

<!-- 选座插件脚本 -->
<script>
    var firstSeatLabel = 1;

    $(document).ready(function() {
        var $cart = $('#selected-seats'),
            $counter = $('#counter'),
            $total = $('#total'),
            sc = $('#seat-map').seatCharts({
                map: [
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                    'eeeee__eeeee',
                ],
                seats: {
                    e: {
                        price   : ${movie.price},
                        classes : 'normal-class', //your custom CSS class
                    }

                },
                naming : {
                    top : false,
                    getLabel : function (character, row, column) {
                        return firstSeatLabel++;
                    },
                },
                legend : {
                    node : $('#legend'),
                    items : [
                        [ 'e', 'available',   '可选择'],
                        [ 'e', 'unavailable', '已预订'],
                        [ 'e', 'selected', '已选择']
                    ]
                },
                click: function () {
                    if (this.status() == 'available') {
                        //let's create a new <li> which we'll add to the cart items
                        $('<li>'+' 座位 # '+this.settings.label+': <b>￥'+this.data().price+'</b> <a href="#" class="cancel-cart-item">[取消]</a></li>')
                            .attr('id', 'cart-item-'+this.settings.id)
                            .data('seatId', this.settings.id)
                            .appendTo($cart);

                        /*
                         * Lets update the counter and total
                         *
                         * .find function will not find the current seat, because it will change its stauts only after return
                         * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
                         */
                        $counter.text(sc.find('selected').length+1);
                        $total.text(recalculateTotal(sc)+this.data().price);

                        return 'selected';
                    } else if (this.status() == 'selected') {
                        //update the counter
                        $counter.text(sc.find('selected').length-1);
                        //and total
                        $total.text(recalculateTotal(sc)-this.data().price);

                        //remove the item from our cart
                        $('#cart-item-'+this.settings.id).remove();

                        //seat has been vacated
                        return 'available';
                    } else if (this.status() == 'unavailable') {
                        //seat has been already booked
                        return 'unavailable';
                    } else {
                        return this.style();
                    }
                }
            });

        //this will handle "[cancel]" link clicks
        $('#selected-seats').on('click', '.cancel-cart-item', function () {
            //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
            sc.get($(this).parents('li:first').data('seatId')).click();
        });

        var bought_rows = new Array();
        var bought_cols = new Array();
        // 遍历该场次所对应的已售出座位集合
        <c:forEach items="${cutting.boughtSeats}" var="seat">
            bought_rows.push(${seat.row});
            bought_cols.push(${seat.col});
        </c:forEach>
        var row_col = new Array();
        for (var i = 0; i < bought_rows.length; i++) {
            row_col.push(bought_rows[i].toString() + '_' + bought_cols[i].toString());
        }

        // 将本场次已经售出的座位状态设置为unavailable
        sc.get(row_col).status('unavailable');

    });

    function recalculateTotal(sc) {
        var total = 0;

        //basically find every selected seat and sum its price
        sc.find('selected').each(function () {
            total += this.data().price;
        });

        return total;
    }

</script>

<script>
    $(document).ready(function() {
        $("#checkout").click(function() {
            var selected_rows = new Array();
            var selected_cols = new Array();
            var $selected_seats = $(".selected");
            if ($selected_seats.length > 0) {
                $selected_seats.each(function() {
                    var $id_text = $(this).attr("id");
                    if (typeof($id_text) != "undefined") {
                        var row_col = $id_text.split('_');
                        selected_rows.push(row_col[0]);
                        selected_cols.push(row_col[1]);
                    }
                });
                var url = "http://localhost:8080/cuttings/" + ${cutting.movieCuttingId} + "/order?"
                    + "rows=" + selected_rows + "&cols=" + selected_cols + "&tickets=" + $("#counter").text();
                window.location.href = url;
            }
            else {
                alert("尚未选择座位！");
            }

        });
    });

</script>

</body>
</html>
