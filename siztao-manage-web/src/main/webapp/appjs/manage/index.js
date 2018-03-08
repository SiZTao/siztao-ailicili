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
//页面组件

//系统组件
var appItem = Vue.extend({
    name:'app-item',
    props:{item :{}},
    template:[
        '<li role="presentation" >',
        '<a href="#" value=item.name class="system" v-on:click="vm.changeSystem(item.id,item.name)" >',
        '<i class="fa fa-dashboard"></i>',
        '<span id="_text">{{item.name}}</span><span class="pull-right-container"></span>',
        '</a>',
        '</li>'
    ].join('')
});

//导航菜单
var menuItem = Vue.extend({
    name:'menu-item',
    props:{item:{}},
    template:[
        '<li class="treeview">',
        '<a v-if="item.type === 0" href="#">',
        '<i v-if="item.icons != null" :class="item.icons"></i>',
        '<span>{{item.name}} </span>',
        '<span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>',
        '</a>',
        '<ul v-if="item.type === 0" class="treeview-menu">',
        '<menu-item :item="item" v-for="item in item.list"></menu-item>',
        '</ul>',
        '<a v-if="item.type === 1" v-on:click="openTab(item.id,item.name,item.href)"><i :class="item.icons"></i>{{item.name}}</a>',
        '</li>'
    ].join('')
});
Vue.component('appItem',appItem);
Vue.component('menuItem',menuItem);

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
              //      $('.sidebar-menu').sidebarMenu({data: result});
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
            $.ajax({
                type: "GET",
                url:"/manage/permission/user",
                dataType: "json",
                success: function(data){
                    vm.menuList = data.menuList;
                    console.log(vm.menuList);
                }
            });
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
            var skins =["skin-red","skin-blue","skin-purple","skin-green","skin-white","skin-yellow","skin-yellow-light","skin-purple-light"];
            var skin =skins[Math.floor(Math.random()*8)]+"  hold-transition sidebar-mini fixed";
            $("body").attr("class",skin);
            vm.appName = appName;
            $.ajax({
                type: "GET",
                url:"manage/permission/user",
                dataType: "json",
                data:{'appId':appId},
                success: function(data){
                    vm.menuList = data.menuList;
                    console.log(vm.menuList);
                }
            });
        },
        getApplication:function () {
            //获取应用数据
        }
    },
    created:function () {
        this.appInit();
        this.getAppList();
        this.getMenuList();
    }
});
function openTab(menuId,menuName,url) {
    addTabs({id: menuId, title: menuName, close: true, url: url, urlType: "relative"});
}
jQuery(".system").on("click",function(){
    var skin = $(this).attr("value")+" hold-transition sidebar-mini fixed";
    $("body").attr("class",skin);
});