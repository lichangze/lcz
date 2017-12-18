function showTime(){
            var lab = document.getElementById("time");   //这是获取显示时间的label
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth()+1;      //月从0开始计数，所以要加1
            var day = date.getDate();                //date.getDay()是获得星期几，getDate()才是日期
            var hour = date.getHours();
            if(hour < 10)
                hour = "0"+hour;
            var min = date.getMinutes();
            if(min < 10)
                min = "0"+min;
            var sec = date.getSeconds();
            if(sec < 10)
                sec = "0"+sec;
            lab.innerHTML = year+"-"+month+"-"+day+" "+hour+":"+min;
            setTimeout('showTime()',1000);                                  //页面自动调用函数，每隔1000ms调用showTime()函数
}