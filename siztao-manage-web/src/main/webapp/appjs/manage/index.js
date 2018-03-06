$(function(){
    $(".system").on("click",function(e){
        var skin = $(this).attr("value")+" hold-transition sidebar-mini fixed";
        $("body").attr("class",skin);
    });
    App.setbasePath("/");
    App.setGlobalImgPath("static/img/");
    addTabs({
        id: '10008',
        title: '欢迎页',
        close: false,
        url: 'welcome',
        urlType: "relative"
    });
    App.fixIframeCotent();
});

var vm =new Vue({
    el:'#mainApp',
    data:{
       menuList:{},
       password:'',
       newPassword:'',
       user:{},
       appList:[],
       appName:'权限管理平台'
    },
    methods:{
        appInit:function (event) {
            //初始化
            $.ajax({
                type: "GET",
                url: "/static/json/menus.json",
                dataType: "json",
                success: function(result){
                    console.log(result);
                    $('.sidebar-menu').sidebarMenu({data: result});
                }
            });
        },
        getAppList:function () {
            //获取应用数据
            $.ajax({
                type: "GET",
                url:"/manage/user/applist",
                dataType: "json",
                success: function(data){
                    vm.appList = data.appList;
                    console.log(vm.appList);
                }
            });
        },
        getMenuList:function (event) {
            //获取菜单数据
        },
        getUser:function () {
            // //获取用户
            // Ajax.request({
            //    url:'manage/user/info',
            //    async:true,
            //    successCallback:function (data) {
            //        vm.user = data.user;
            //    }
            // });
        },
        updatePassword:function () {
            //修改用户密码
        },
        logout:function () {
            //退出
        },
        changeSystem:function (appId,appName) {

        },
        getApplication:function () {
            //获取应用数据
        }
    },
    created:function () {
        this.appInit();
        this.getAppList();
    }
});