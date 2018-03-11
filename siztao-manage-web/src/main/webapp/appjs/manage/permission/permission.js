$(function () {
    var $table = $('#treeGrid');
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
        $table.bootstrapTable({
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
                console.log('load');
                // jquery.treegrid.js
                $table.treegrid({
                    initialState: 'collapsed',
                    treeColumn: 1,
                    expanderExpandedClass: 'glyphicon glyphicon-minus',
                    expanderCollapsedClass: 'glyphicon glyphicon-plus',
                    onChange: function() {
                        $table.bootstrapTable('resetWidth');
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
    // 格式化状态
    function statusFormatter(value, row, index) {
        if (value === "0") {
            return '<span class="label label-success">正常</span>';
        } else {
            return '<span class="label label-default">锁定</span>';
        }
    }
});

let vm = new Vue({
    el:'#Permission',
    data:{
        permission:{}
    },
    methods:{
        saveOrUpdate:function (event){
            let url ="/manage/permission/saveOrUpdate";
            $.ajax({
                type:"post",
                url:url,
                contentType:"application/json",
                dataType:"json",
                data:JSON.stringify(vm.permission),
                success:function (result) {

                }
            });
        },
        addAction:function () {
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
        },
        delAction:function (event) {
        },
        reload:function (event) {
            
        }
    }
});