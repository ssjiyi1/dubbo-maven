/**
 *  student 相关 dom
 */


(function ($) {

    /** 公共方法 **/
    function getData(json, fn) {
        var obj = eval('(' + json + ')');
        if (obj.code = 2000) {
            fn(eval('(' + obj.data + ')'));
        } else {
            alert(obj.msg);
        }

    };
    function getWebRootPath() {
        var webroot=document.location.href;
        webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
        webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
        webroot=webroot.substring(0,webroot.indexOf('/'));
        var rootpath="/"+webroot;
        return rootpath;
    }



    /**
     *  移动DIV
     * @param id
     */
    function moveDiv(id) {
        var $div = $("#"+id);
        var  rightPx = parseInt($div.css("right"));
        var direction  = $div.attr("direction");
        if(direction === undefined){
            direction = "left";
        }
        if(direction=='left'){
            rightPx += 10;
            if(rightPx >=600){
                $div.attr("direction","right");
            }
        }else if(direction=='right'){
            rightPx -= 10;
            if(rightPx <=10){
                $div.attr("direction","left");
            }
        }



        $div.css("right",rightPx)
    }


    /**
     *  查询所有的学生列表
     */
    function listStudent() {
        $.GetHttp(getWebRootPath()+ "/student/listAll", function (data, status) {
        });
    };


    function getWeather() {
        $.GetHttp(getWebRootPath() +"/weather/get", function (data, status) {
            if (status) {
                getData(data, function (rdata) {
                    var weatherinfo = rdata.result;
                    var city = "成都";
                    var wind = "西南风";
                    var temp = "20℃";
                    var time = "今天";
                    //var city = weatherinfo.citynm;
                    //var wind = weatherinfo.wind;
                    //var temp = weatherinfo.temperature_curr;
                    //var time = weatherinfo.days;
                    var html = "城市:" + city + "&nbsp;风向:" + wind + "&nbsp;温度:" + temp + "&nbsp;更新时间:" + time;
                    $("#weather").html(html);
                    setInterval(moveDiv, 500,'weather');

                })
            }
        });
    };




    function listTableStudent() {
        jQuery("#__student_list").jqGrid({
            url: getWebRootPath()+'/student/page',
            datatype: "json",
            grouping: true,
            jsonReader: {
                root: "data.datas", // json中代表实际模型数据的入口
                page: "data.page",    // json中代表当前页码的数据
                total: "data.pages",    // json中代表页码总数的数据
                records: "data.totals", // json中代表数据行总数的数据
            },

            colNames: ['学生ID', '学生姓名', '学生年龄', '学生性别'],
            colModel: [
                {name: 'id', index: 'id', width: 80, align: "center"},
                {name: 'uname', index: 'uname', width: 80, align: "center"},
                {name: 'age', index: 'age', width: 80, align: "center"},
                {name: 'age', index: 'gender', width: 80, align: "center"}
            ],
            rowNum: 5,
            autowidth: true,
            altRows: true,

            altclass: "someClass",
            rowList: [5, 10, 20, 30],
            pager: '#__student_pager',
            sortname: 'id',
            mtype: "GET",
            scrolling: 'auto',
            sortorder: "desc",
            loadComplete: function () {
                $("#__student_pager_center  span.ui-icon").each(function (i, n) {
                    if (i == 0) {
                        $(n).addClass("fa fa-angle-double-left bigger-140")
                    } else if (i == 1) {
                        $(n).addClass("fa fa-angle-left bigger-140")
                    } else if (i == 2) {
                        $(n).addClass("ace-icon fa fa-angle-right bigger-140")
                    } else if (i == 3) {
                        $(n).addClass("fa fa-angle-double-right bigger-140")
                    }
                });
            },
            caption: "学生列表"
        });
        jQuery("#__student_list").jqGrid('navGrid', '#__student_pager', {
            edit: true, editicon: 'ace-icon fa fa-pencil blue',
            add: true, addicon: 'ace-icon fa fa-plus-circle purple',
            del: true, delicon: 'ace-icon fa fa-trash-o red'
        });
    }

    //  init
    $(function () {
        // 初始化学生列表
        listTableStudent();
        // 初始化天气
        getWeather();

        $('.banner').unslider();

    });


})(jQuery);

