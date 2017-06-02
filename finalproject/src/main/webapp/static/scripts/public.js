/**
 * Created by apple on 17/6/2.
 */
$(document).ready(function () {
    $("#user_index").attr("href", "/user/index?username=" + '${username}');
    $("#search_btn").click(function () {
        var search_text = $("#search_text").val();
        window.location.href = "/search?vague_name=" + search_text;
    });

    $("#search_text").keydown(function (e) {
        if (e.keyCode == 13) {
            var search_text = $(this).val();
            window.location.href = "/search?vague_name=" + search_text;
        }
    });



});