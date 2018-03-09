$(function (){
   var colModel = [
       {field:'state',checkbox:true},
       {title:'序号',width:'2%',align:'center',formatter:idFormatter},
       {field:'id',title:'ID',visible:false},
       {field:'name',title:'名称',width:'8%',align:'center',halign:'center'},
       {field:'code',title:'代码',width:'10%',align:'center',halign:'center'},
       {field:'href',title:'链接',width:'8%',align:'center',halign:'center'},
       {field:'theme',title:'主题',width:'8%',align:'center',halign:'center'},
       {field:'bgimg',title:'背景图',width:'8%',align:'center',halign:'center',formatter:bgFormatter},
       {field:'title',title:'标题',width:'10%',align:'center',halign:'center'},
       {field:'descrption',title:'描述',width:'8%',visible:false},
       {field:'keyword',title:'关键字',width:'8%',align:'center',halign:'center'},
       {field:'status',title:'状态',width:'8%',align:'center',halign:'center',formatter:statusFormatter},
       {field:'createtime',title:'创建时间',width:'10%',visible:false},
       {field:'createuser',title:'创建人',width:'8%',visible:false},
       {field:'updatetime',title:'修改时间',width:'10%',align:'center',halign:'center'},
       {field:'updateuser',title:'修改人',width:'8%',align:'center',halign:'center'},
       {field: 'action', title: '操作', halign: 'center', align: 'center', formatter: actionFormatter, events: 'actionEvents', clickToSelect: false}
   ];

   var dataTables = $("#Table");
   var listUrl="/manage/application/list";
   dataTables.bootstrapTable({
       url:listUrl,                         //请求地址
       height: window.height,              //高度
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
       singleSelect: false, 	            //是否启用单选	//是否启用点击选中行
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
        var options = table.bootstrapTable('getOptions');
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
            alert('You click edit icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        },
        'click .remove': function(e, value, row, index) {
            alert('You click remove icon, row: ' + JSON.stringify(row));
            console.log(value, row, index);
        }
    }
});
function addView() {
    openWindow({
        type: 2,
        title: '添加应用',
        shadeClose: true,
        shade: 0.8,
        skin: 'layui-layer-molv', //样式类名
        maxmin: true, //开启最大化最小化按钮
        area: ['893px', '600px'],
        content: '/manage/application/addView'
    });

}
var application = new Vue({
   el:'#Application',
   data:{

   },
    methods:{
        
    }
});