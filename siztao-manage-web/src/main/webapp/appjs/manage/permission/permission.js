$(function () {
    $(".select2").select2();
    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    var dataTables = $('#treeGrid');
    $(function() {
        var colModel= [
            {field: 'ck',width:'2%', checkbox: true},
            {field:'id',title:'ID',visible:false},
            {field: 'name', title: '权限名称',width:'8%',align:'center',halign:'center'},
            {field: 'parentid', title: '所属上级',visible:false,width:'8%',align:'center',halign:'center'},
            {field: 'code', title: '编码',width:'8%',align:'center',halign:'center'},
            {field: 'permission', title: '权限值',width:'8%',align: 'center',halign:'center'},
            {field: 'href', title: '链接',width:'8%',align:'center',halign:'center'},
            {field: 'type', title: '类型',width:'5%',align:'center',halign:'center',formatter:typeFormatter},
            {field: 'icons', title: '图标',width:'5%',align:'center',halign:'center'},
            {field: 'status', title: '状态', width:'5%',align: 'center',halign:'center',formatter:statusFormatter},
            {field: 'updatetime', title: '更新时间',width:'10%',align:'center',halign:'center'},
            {field: 'updateuser', title: '更新人',width:'10%',align:'center',halign:'center'},
            {field: 'action', title: '操作',width:'8%', halign: 'center',width:'8%', align: 'center', formatter: actionFormatter, events: 'actionEvents', clickToSelect: false}
        ];
        dataTables.bootstrapTable({
            url: '/manage/permission/list',
            height: 560,
            striped: true,
            sidePagination: 'server',
            idField: 'id',
            search: true,
            searchOnEnterKey: true,
            showRefresh: true,
            singleSelect  : true,           // 单选checkbox
            showToggle: true,
            showColumns: true,
            clickToSelect: true,
            minimumCountColumns: 2,
            showPaginationSwitch: true,
            toolbar: '#toolbar',
            classes: 'table table-hover  table-striped table-condensed table-bordered',
            columns: colModel,
            treeShowField: 'name',
            parentIdField: 'parentid',
            onLoadSuccess: function(data) {
                // jquery.treegrid.js
                dataTables.treegrid({
                    initialState: 'collapsed',
                    treeColumn: 1,
                    expanderExpandedClass: 'glyphicon glyphicon-minus',
                    expanderCollapsedClass: 'glyphicon glyphicon-plus',
                    onChange: function() {
                        dataTables.bootstrapTable('resetWidth');
                    }
                });
            }
            // bootstrap-table-treetreegrid.js 插件配置
        });
    });

    // 格式化类型
    function typeFormatter(value, row, index) {
        if (value === 0) {
            return '菜单';
        }
        if (value === 1) {
            return '功能';
        }
        if (value === 2) {
            return '按钮';
        }
        return '-';
    }
    //按钮事件
    function actionFormatter(value, row, index) {
        return [
            '<a href="javascript:;" class="btn btn-xs btn-primary btn-dragsort like" title="Like" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-arrows"></i></a>',
            '<a href="javascript:;" class="btn btn-xs btn-success btn-dragsort edit ml10" title="Edit" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-pencil"></i></a>',
            '<a href="javascript:;" class="btn btn-xs btn-danger btn-dragsort remove ml10" title="Remove" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-trash"></i></a>'
        ].join('');
    }
    // 获取选中的条目ID集合
    window.actionEvents = {
        'click .like': function(e, value, row, index) {
            alert(JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .edit': function(e, value, row, index) {
            let url="/manage/permission/editView?permissionId="+row.id;
            $.ajax({
                type : "GET",
                url :url,
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                success : function(result) {
                    if(result.code==200){
                        vm.permission = result.permission;
                        vm.addAction();
                    }else {
                        toastr.error(result.msg);
                    }
                }
            });
        },
        'click .remove': function(e, value, row, index) {
            //删除单条数据
            let url="/manage/permission/delete?permissionId="+row.id;
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type : "POST",
                    url :url,
                    dataType: 'json',
                    contentType:'application/json;charset=UTF-8',
                    skin: 'layui-layer-molv',//皮肤
                    success : function(result) {
                        if(result.code==200){
                            alert('操作成功', function (index) {
                                refreshTable();
                            });
                        }else {
                            toastr.error(result.msg);
                        }
                    }
                });
            });
        }
    }
    // 格式化状态
    function statusFormatter(value, row, index) {
        if (value === "0") {
            return '<span class="label label-success">正常</span>';
        } else {
            return '<span class="label label-default">锁定</span>';
        }
    }
    dataTables.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table fa.event.check', function () {
        var ids = 	dataTables.bootstrapTable('getSelections');
        console.log(ids)
        $(".btn-disabled").toggleClass("disabled",!ids.length);
    });
});

let vm = new Vue({
    el:'#Permission',
    data:{
        permission:{},
        title:null,
        appList:[],
        permissionTree:[],
        appId:1,
         setting : {
            data: {
                simpleData: {
                    enable: true
                }
            }
        }
    },
    methods:{
        selectIcon:function () {
            openWindow({
                type: 2,
                title: '选取图标',
                area: ['1030px', '500px'],
                content: ['icon.html'],
                btn: false
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
        getMenu:function (permissionId) {
            //加载菜单树
        },
        getPermissionList(appid){
            vm.appId = appid;
            console.log(vm.appId);
        },
        getPerTree:function(){
            //权限树菜单
            let setting = {
                data: {
                    check:{
                        enable:true
                    },
                    view: {
                        showLine: true,//显示节点之间的连线。
                        selectedMulti: false  //允许同时选中多个节点。
                    },
                    simpleData: {
                        enable: true,
                        idKey: "id",//节点数据中保存唯一标识的属性名称
                        pIdKey: "pId",//节点数据中保存其父节点唯一标识的属性名称
                        rootPId: "" //用于修正根节点父节点数据 默认值：null
                    }
                }
            };
            let url ="/manage/permission/tree";
            $.ajax({
                type : "get",
                url :url,
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                success:function (result) {
                    vm.permissionTree = result;
                    console.log(vm.permissionTree);
                    $.fn.zTree.init($("#treeDemo"), vm.setting,   vm.permissionTree );
                }
            });
        },
        saveOrUpdate:function (event){
            let url ="/manage/permission/saveOrUpdate";
            $.ajax({
                type:"post",
                url:url,
                dataType: 'json',
                contentType:'application/json;charset=UTF-8',
                data:JSON.stringify(vm.permission),
                success:function (result) {
                    if(result.code==200){
                        toastr.success(result.msg);
                        setTimeout("layer.closeAll()","1000");
                        location.reload();
                    }else {
                        toastr.error(result.msg);
                    }
                }
            });
        },
        menuTree:function () {
            vm.getPerTree();
            layer.open({
                type: 1,
                title: '选择菜单', //不显示标题
                skin: 'layui-layer-molv',//皮肤
                area: ['300px', '450px'],
                shadeClose: true, //开启遮罩关闭
                shade: 0.5,
                content: $('#menuLayer'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                btn: ['保存', '取消'],
                anim: 2,
                top: true, //窗口弹出是否在iframe上层
                btnAlign: 'c',
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.permission.parentid = node[0].id;
                    vm.permission.name = node[0].name;
                    layer.close(index);
                }
            });
        },
        addAction:function () {
            var rows =  $("#treeGrid").bootstrapTable('getSelections');
            var parentid = 0;
            if(rows.length!=0){
                parentid = rows[0].id;
            }
            vm.getAppList();
            layer.open({
                type: 1,
                title: '编辑权限信息', //不显示标题
                skin: 'layui-layer-molv',//皮肤
                area: ['893px', '600px'],
                shadeClose: true, //开启遮罩关闭
                shade: 0.5,
                content: $('#add-form'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                btn: ['保存', '重置'],
                anim: 2,
                top: true, //窗口弹出是否在iframe上层
                btnAlign: 'c',
                btn1:function () {
                    //保存数据
                    vm.saveOrUpdate();
                },
                btn2:function () {
                },
                end: function () {
                    location.reload();
                }
            });
        },
        editAction:function () {
            var rows =  $("#treeGrid").bootstrapTable('getSelections');
            if(rows.length!=1){
                confirm('请选择一条记录？', function () {
                    layer.closeAll();
                    location.reload();
                });
            }else {
                let url="/manage/permission/editView?permissionId="+rows[0].id;
                $.ajax({
                    type : "GET",
                    url :url,
                    dataType: 'json',
                    contentType:'application/json;charset=UTF-8',
                    success : function(result) {
                        if(result.code==200){
                            vm.permission = result.permission;
                            console.log("edit:"+vm.permission);
                            vm.addAction();
                        }else {
                            toastr.error(result.msg);
                        }
                    }
                });
            }
        },
        delAction:function (event) {
            var rows =  $("#Table").bootstrapTable('getSelections');
            console.log(rows);
            if(rows.length==0){
                confirm('至少选择一条记录？', function () {

                });
            }else {
                confirm('确认要删除所选记录么？', function () {
                    let url="/manage/permission/delete";
                    let params="";
                    $.ajax({
                        type : "GET",
                        url :url,
                        dataType: 'json',
                        contentType:'application/json;charset=UTF-8',
                        success : function(result) {
                            if(result.code==200){
                                vm.permission = result.permission;
                                console.log("edit:"+vm.permission);
                                vm.addAction();
                            }else {
                                toastr.error(result.msg);
                            }
                        }
                    });
                });
            }
        },
        reload:function (event) {
            
        },
        query:function () {
            
        }
    },
    created:function () {
        this.getAppList();
    },
    updated:function (event) {
        console.log(vm.permission);
    }

});