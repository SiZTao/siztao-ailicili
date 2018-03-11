$(function (){
    var colModel = [
        {field:'state',width:'2%',checkbox:true},
        {title:'序号',width:'2%',align:'center',formatter:idFormatter},
        {field:'id',title:'ID',visible:false},
        {field:'name',title:'名称',width:'8%',align:'center',halign:'center'},
        {field:'code',title:'代码',width:'10%',align:'center',halign:'center'},
        {field:'title',title:'标题',width:'10%',align:'center',halign:'center'},
        {field:'descrption',title:'描述',width:'8%',visible:false},
        {field:'status',title:'状态',width:'5%',align:'center',halign:'center',formatter:statusFormatter},
        {field:'updatetime',title:'修改时间',width:'10%',align:'center',halign:'center'},
        {field:'updateuser',title:'修改人',width:'8%',align:'center',halign:'center'},
        {field: 'action', title: '操作',width:'8%', halign: 'center',width:'8%', align: 'center', formatter: actionFormatter, events: 'actionEvents', clickToSelect: false}
    ];
    var dataTables = $("#Table");
    var listUrl="/manage/application/list";
    dataTables.bootstrapTable({
        url:listUrl,                         //请求地址
        height: 560,              //高度
        striped: true,                       //是否显示行间隔色
        search: false,                        //是否显示快速搜索,客户端实现
        searchOnEnterKey: false,              //设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
        showRefresh: true,                   //是否显示 刷新按钮
        locale: 'zh-CN',
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        showColumns: true,                   //是否显示所有的列
        minimumCountColumns: 2,              //最少允许的列数
        showPaginationSwitch: true,
        clickToSelect: true,                 //设置true 将在点击行时，自动选择rediobox 和 checkbox
        singleSelect: false, 	                //是否启用单选	//是否启用点击选中行
        // detailView: true,                    //是否显示父子表
        //detailFormatter: 'detailFormatter',
        pagination: true,
        pageNumber:1,                        //初始化加载第一页，默认第一页
        pageSize: 10,                        //每页的记录行数（*）
        pageList: [25,50,100,'All'],         //可供选择的每页的行数（*）
        paginationLoop: false,               //分页循环
        mobileResponsive:true,               //移动端
        cardView: false,                     //卡片视图
        queryParamsType:'',
        queryParams: queryParams(),
        classes: 'table table-hover  table-striped table-condensed table-bordered',
        sidePagination: 'server',
        silentSort: true,
        smartDisplay: false,
        idField: 'id',
        sortOrder: 'asc',
        escape: true,
        toolbar: '#toolbar',
        columns:colModel
    }).on('all.bs.table', function(e, name, args) {
        $('[data-toggle="tooltip"]').tooltip();
        $('[data-toggle="popover"]').popover();
    });
    dataTables.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table fa.event.check', function () {
        var ids = 	selectedids(dataTables);
        $(".btn-disabled").toggleClass("disabled",!ids.length);
    });
    //序号格式化
    function idFormatter(value, row, index) {
        return  index+1;
    }
    //背景图
    function bgFormatter(value,row,index) {
        var _html='<img width="125px" height="25px" src="/static/img/photo2.png">'
        return  _html;
    }
    //状态格式化
    function statusFormatter(value, row, index) {
        return value==1?'<span class="label label-danger">禁用</span>':'<span class="label label-success">正常</span>';
    }
    //按钮事件
    function actionFormatter(value, row, index) {
        return [
            '<a href="javascript:;" class="btn btn-xs btn-primary btn-dragsort like" title="Like" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-arrows"></i></a>',
            '<a href="javascript:;" class="btn btn-xs btn-success btn-dragsort edit ml10" title="Edit" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-pencil"></i></a>',
            '<a href="javascript:;" class="btn btn-xs btn-danger btn-dragsort remove ml10" title="Remove" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-trash"></i></a>'
        ].join('');
    }
    function queryParams() {

    }   // 获取选中的条目ID集合
    function selectedids(table) {
        var options = table.bootstrapTable('getSelections');
        if (options.templateView) {
            return $.map($("input[data-id][name='checkbox']:checked"), function (dom) {
                return $(dom).data("id");
            });
        } else {
            return $.map(table.bootstrapTable('getSelections'), function (row) {
                return row[options.pk];
            });
        }
    }
    window.actionEvents = {
        'click .like': function(e, value, row, index) {
            alert('You click like icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .edit': function(e, value, row, index) {
            let url="/manage/application/editView?appId="+row.id;
            $.ajax({
                type : "GET",
                url :url,
                contentType : "application/json",
                dataType : 'json',
                success : function(result) {
                    if(result.code==200){
                        vm.application = result.app;
                        vm.addAction();
                    }else {
                        toastr.error(result.msg);
                    }
                }
            });
        },
        'click .remove': function(e, value, row, index) {
            //删除单条数据
            let url="/manage/application/delete?appId="+row.id;
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type : "post",
                    url :url,
                    contentType : "application/json",
                    skin: 'layui-layer-molv',//皮肤
                    dataType : 'json',
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
    $("#refresh").on('click',function () {
        dataTables.bootstrapTable('refresh');
    });
    function refreshTable() {
        dataTables.bootstrapTable('refresh');
    }
    dataTables.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table fa.event.check', function () {
        var ids = 	dataTables.bootstrapTable('getSelections');
        console.log(ids)
        $(".btn-disabled").toggleClass("disabled",!ids.length);
    });
});

let vm = new Vue({
    el:'#Dept',
    data:{
        queryShow:true,
        application:{},
        showForm:true,
        queryParams:{
            name:''
        },
        ruleValidate: {
            name: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ]
        },
    },
    methods:{
        saveOrUpdate:function (event) {
            //  this.validform(JSON.stringify(vm.application));
            console.log(JSON.stringify(vm.application));
            var url="/manage/application/saveOrUpdate";
            $.ajax({
                type : "post",
                url :url,
                contentType : "application/json",
                dataType : 'json',
                data : JSON.stringify(vm.application),
                success : function(result) {
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
        addAction:function () {
            layer.open({
                type: 1,
                title: '编辑应用信息', //不显示标题
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
            var rows =  $("#Table").bootstrapTable('getSelections');
            if(rows.length!=1){
                confirm('请选择一条记录？', function () {
                    layer.closeAll();
                    location.reload();
                });
            }else {
                let url="/manage/application/editView?appId="+rows[0].id;
                $.ajax({
                    type : "GET",
                    url :url,
                    contentType : "application/json",
                    dataType : 'json',
                    success : function(result) {
                        if(result.code==200){
                            vm.application = result.app;
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

                });
            }
        },
        reload:function (event) {

        },
        validform:function () {

        }
    }
});



