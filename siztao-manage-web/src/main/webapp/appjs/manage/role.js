$(function() {
	// bootstrap table初始化
	var table = $("#menuTable");
	$("#menuTable").bootstrapTable({
		url: '../../statics/json/data1.json',
		height: window.height,
		method:'get',			//请求方法
		toolbar: '#toolbar',	//工具栏
		striped: true,			//是否显示行间隔色  	
		search: true,		 	//是否显示表格搜索，此搜索是客户端搜索，不会进服务端，
		searchOnEnterKey: true,
		showRefresh: true,		//是否显示刷新按钮  
		locale: 'zh-CN',
		showToggle: true,		//是否显示详细视图和列表视图的切换按钮  
		showColumns: true,		//是否显示所有的列 
//	    showExport: true,
//      exportDataType: "all",
//      exportTypes: ['json', 'xml', 'csv', 'txt', 'doc', 'excel'],
		minimumCountColumns: 2,	//最少允许的列数  
		showPaginationSwitch: true,
		clickToSelect: true, 	//是否启用点击选中
        singleSelect: false, 	//是否启用单选	//是否启用点击选中行
		detailView: true,		//是否显示父子表
		detailFormatter: 'detailFormatter',
		pageSize: 10,
        pageList: [10, 25, 50, 'All'],
		pagination: true,			//是否显示分页（*）  
		paginationLoop: false,
		classes: 'table table-hover  table-striped table-condensed table-bordered',
		cardView: false, //卡片视图
		//sidePagination: 'server',
		//silentSort: false,
		smartDisplay: false,
		pk: 'id',
		sortName: 'id',
		sortOrder: 'desc',
		escape: true,
		searchOnEnterKey: true,
		idField: 'systemId',
		maintainSelected: true,
		mobileResponsive: true, //是否自适应移动端
		columns: [{
				field: 'state',
				checkbox: true,
			},
			{
				field: 'id',
				title: '编号',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'username',
				title: '账号',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'password',
				title: '密码',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'name',
				title: '姓名',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'sex',
				title: '性别',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'age',
				title: '年龄',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'phone',
				title: '手机',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'email',
				title: '邮箱',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'address',
				title: '地址',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'remark',
				title: '备注',
				sortable: true,
				halign: 'center'
			},
			{
				field: 'action',
				title: '操作',
				halign: 'center',
				align: 'center',
				formatter: 'actionFormatter',
				events: 'actionEvents',
				clickToSelect: false
			}
		]
	}).on('all.bs.table', function(e, name, args) {
		$('[data-toggle="tooltip"]').tooltip();
		$('[data-toggle="popover"]').popover();
	});
	$(".btn-refresh").on("click",function(){
		$("#menuTable").bootstrapTable('refresh');
	});
	table.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table fa.event.check', function () {
		var ids = 	selectedids(table);
		$(".btn-disabled").toggleClass("disabled",!ids.length);
    });
});
 // 获取选中的条目ID集合
function    selectedids(table) {
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
 function detailFormatter(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

function actionFormatter(value, row, index) {
    return [
        '<a href="javascript:;" class="btn btn-xs btn-primary btn-dragsort like" title="Like" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-arrows"></i></a>',
        '<a href="javascript:;" class="btn btn-xs btn-success btn-dragsort edit ml10" title="Edit" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-pencil"></i></a>',
        '<a href="javascript:;" class="btn btn-xs btn-danger btn-dragsort remove ml10" title="Remove" data-table-id="table" data-field-index="13" data-row-index="0" data-button-index="0"><i class="fa fa-trash"></i></a>'
    ].join('');
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
};

//菜单树
var menu_ztree;
var menu_setting ={
	data:{
		simpleData:{
			enable:true,
			idKey:"menuId",
			pIdKey:"parentId",
			rootPId:-1
		},
		key:{
			url:"nourl"
		}
	},
	check:{
		enable:true,
		nocheckInherit:true
	}
};
//部门结构树
var dept_ztree;
var dept_setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    }
};


//数据树
var data_ztree;
var data_setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url: "nourl"
        }
    },
    check: {
        enable: true,
        nocheckInherit: true,
        chkboxType: {"Y": "", "N": ""}
    }
};
	
var roleApp = new Vue({
	el: '#roleApp',
	data: {
		isShow: false,
		roleForm:false,
		q: {
            roleName: null
        },
	    role: {deptId: '', deptName: ''},
        ruleValidate: {
            roleName: [
                {required: true, message: '角色名称不能为空', trigger: 'blur'}
            ]
        }
	},
	methods: {
		toggle: function() {
			this.isShow = !this.isShow;
		},
		ok:function(){
			toastr.info("保存角色");
		},
		cancel:function(){
			return;
		},
		reset:function(){
			
		},
		query:function(){
			
		},
		add:function(){
			
		},
		update:function(){
			
		},
		del:function(event){
			
		},
		getRole:function(roleId){
			
		},
		saveOrUpdate:function(event){
			
		},
		getMenuTree:function(event){
			
		},
		deptTree:function(){
			//选择机构
		    openWindow({
            title: "选择部门",
            area: ['300px', '450px'],
            content: jQuery("#deptLayer"),
            btn: ['确定', '取消'],
            btn1: function (index) {
                var node = dept_ztree.getSelectedNodes();
                //选择上级部门
                vm.role.deptId = node[0].deptId;
                vm.role.deptName = node[0].name;
                layer.close(index);
            }
            });
		},
		reload:function(event){
			
		},
		handleSubmit:function(name){
			handleSubmitValidate(this,name,function(){
				vm.saveOrUpdate()
			});
		},
		handleReset:function(name){
			handleResetForm(this,name);
		}
		
	}
});

