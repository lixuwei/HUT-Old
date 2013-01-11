Ext.onReady(function() {

	// 学院
	Ext.regModel('Xy', {
		fields : [ {
			type : 'string',
			name : 'dm'
		}, {
			type : 'string',
			name : 'xymc'
		} ]
	});
	var XyModel = Ext.create('Ext.data.Store', {
		model : 'Xy',
		proxy : {
			type : 'ajax',
			url : 'XyAction!showAll',
			reader : {
				type : 'json',
				model : Xy,
				root : 'items'
			}
		}
	});
	var Xy = new Ext.form.ComboBox({
		id : 'xyCombo',
		labelWidth : 50,
		width : 250,
		editable : false,
		queryMode : 'remote',
		name : 'xydm',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		fieldLabel : '学院',
		triggerAction : 'all',
		store : XyModel,
		displayField : 'xymc',
		valueField : 'dm',
		forceSelection : true,
		emptyText : '请选择...'
	});

	Xy.on('change', function(Xy, newValue, oldValue) {
		Ext.apply(ZyModel.proxy.extraParams, {
			xydm : newValue
		});
		ZyModel.load();
	});

	// 专业
	Ext.regModel('Zy', {
		fields : [ {
			type : 'string',
			name : 'ejxkdm'
		}, {
			type : 'string',
			name : 'ejxkmc'
		} ]
	});
	var ZyModel = Ext.create('Ext.data.Store', {
		model : 'Zy',
		proxy : {
			type : 'ajax',
			url : 'XyzyAction!findAllByXy',
			reader : {
				type : 'json',
				model : Zy,
				root : 'items'
			}
		}
	});
	var Zy = new Ext.form.ComboBox({
		id : 'zyCombo',
		labelWidth : 50,
		width : 250,
		editable : false,
		queryMode : 'remote',
		name : 'ejxkdm',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		fieldLabel : '专业',
		triggerAction : 'all',
		store : ZyModel,
		displayField : 'ejxkmc',
		valueField : 'ejxkdm',
		forceSelection : true,
		emptyText : '请选择...'
	});

	// 其他条件(年份 学号 姓名 身份证号)
	Ext.regModel('Qt', {
		fields : [ {
			type : 'string',
			name : 'lx'
		}, {
			type : 'string',
			name : 'mc'
		} ]
	});
	var QtModel = Ext.create('Ext.data.Store', {
		model : 'Qt',
		data : [ {
			lx : 'nj',
			mc : '年级'
		}, {
			lx : 'xh',
			mc : '学号'
		}, {
			lx : 'xm',
			mc : '姓名'
		}, {
			lx : 'zjhm',
			mc : '身份证号'
		} ]
	});
	var Qt = new Ext.form.ComboBox({
		id : 'qtCombo',
		width : 100,
		editable : false,
		queryMode : 'local',
		name : 'qttj',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		triggerAction : 'all',
		store : QtModel,
		displayField : 'mc',
		valueField : 'lx',
		forceSelection : true,
		value: 'nj'
	});

	var itemsPerPage = 20; // set the number of items you want per page
	var store = Ext.create('Ext.data.JsonStore', {
		fields : [ 'xh', 'xm', 'xmpy', 'cym', 'zplj', 'zjlx', 'xbm', 'zjhm',
				'mzm', 'jg', 'csrq', 'hfm', 'lxdh', 'zzmmm', 'xxfs', 'xslb',
				'xydm', 'xdm', 'pyccdm', 'ejxkdm', 'hdxlfsdm', 'dsdm1',
				'dsdm2', 'xfzqk', 'xz1', 'xz2', 'rxny', 'nj', 'rxny', 'nj',
				'rxxq', 'yjxksq', 'bjdm', 'xjzt', 'xjyd', 'ksdm', 'zcqk',
				'zcrq', 'yhkh', 'jhsh', 'jsxysm', 'bz', 'stzk' ],
		pageSize : itemsPerPage,
		proxy : {
			type : 'ajax',
			url : 'XsAction!showAllByPage',
			reader : {
				type : 'json',
				root : 'items',
				totalProperty : 'results'
			}

		}
	});

	store.load({
		params : {
			start : 0,
			limit : itemsPerPage
		}
	});

	var selectModel = Ext.create('Ext.selection.CheckboxModel');

	var showXslq = Ext.create('Ext.grid.Panel', {
		store : store,
		tbar : [ {
			text : "新增",
			handler : function() {

			}
		}, {
			text : "修改",
			handler : function() {

			}
		}, {
			text : "删除",
			handler : function() {

			}
		}, '|',Xy, Zy, Qt,{
			id: 'qtValue',
	        xtype: 'textfield',
	        name: 'QtValue'
	    }, '|',{
			text : "查询",
			handler : function() {
				alert(Zy.value);
				Ext.apply(store.proxy.extraParams, {
					xydm : Xy.value,
					ejxkdm: Zy.value,
					qt: Qt.value,
					qtValue: Ext.getCmp('qtValue').value
				});
				store.load();
			}
		},{
			text : "重置",
			handler : function() {
				
			}
		
		} ],
		selModel : selectModel,
		columns : [ {
			header : "学号",
			dataIndex : 'xh',
			menuDisabled : true,
			resizable : true
		}, {
			header : "姓名",
			dataIndex : 'xm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "姓名拼音",
			dataIndex : 'xmpy',
			menuDisabled : true,
			resizable : true
		}, {
			header : "曾用名",
			dataIndex : 'cym',
			menuDisabled : true,
			resizable : true
		}, {
			header : "照片路径",
			dataIndex : 'zplj',
			menuDisabled : true,
			resizable : true
		}, {
			header : "证件类型",
			dataIndex : 'zjlx',
			menuDisabled : true,
			resizable : true
		}, {
			header : "性别码",
			dataIndex : 'xbm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "证件号码",
			dataIndex : 'zjhm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "民族码",
			dataIndex : 'mzm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "籍贯",
			dataIndex : 'jg',
			menuDisabled : true,
			resizable : true
		}, {
			header : "出生日期",
			dataIndex : 'csrq',
			menuDisabled : true,
			resizable : true
		}, {
			header : "婚否",
			dataIndex : 'hfm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "联系电话",
			dataIndex : 'lxdh',
			menuDisabled : true,
			resizable : true
		}, {
			header : "政治面貌代码",
			dataIndex : 'zzmmm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学习方式",
			dataIndex : 'xxfs',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学生类别",
			dataIndex : 'xslb',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学院代码",
			dataIndex : 'xydm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "系代码",
			dataIndex : 'xdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "培养层次代码",
			dataIndex : 'pyccdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "二级学科代码",
			dataIndex : 'ejxkdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "获得学历方式代码",
			dataIndex : 'hdxlfsdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "导师1代码",
			dataIndex : 'dsdm1',
			menuDisabled : true,
			resizable : true
		}, {
			header : "导师2代码",
			dataIndex : 'dsdm2',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学分制情况",
			dataIndex : 'xfzqk',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学制1",
			dataIndex : 'xz1',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学制2",
			dataIndex : 'xz2',
			menuDisabled : true,
			resizable : true
		}, {
			header : "入学年月",
			dataIndex : 'rxny',
			menuDisabled : true,
			resizable : true
		}, {
			header : "年级",
			dataIndex : 'nj',
			menuDisabled : true,
			resizable : true
		}, {
			header : "入学学期",
			dataIndex : 'rxxq',
			menuDisabled : true,
			resizable : true
		}, {
			header : "一级学科授权",
			dataIndex : 'yjxksq',
			menuDisabled : true,
			resizable : true
		}, {
			header : "班级代码",
			dataIndex : 'bjdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学籍状态",
			dataIndex : 'xjzt',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学籍异动情况",
			dataIndex : 'xjyd',
			menuDisabled : true,
			resizable : true
		}, {
			header : "考生编号",
			dataIndex : 'ksdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "注册情况",
			dataIndex : 'zcqk',
			menuDisabled : true,
			resizable : true
		}, {
			header : "注册日期",
			dataIndex : 'zcrq',
			menuDisabled : true,
			resizable : true
		}, {
			header : "银行卡号",
			dataIndex : 'yhkh',
			menuDisabled : true,
			resizable : true
		}, {
			header : "培养计划审核",
			dataIndex : 'jhsh',
			menuDisabled : true,
			resizable : true
		}, {
			header : "结束学业说明",
			dataIndex : 'jsxysm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "备注",
			dataIndex : 'bz',
			menuDisabled : true,
			resizable : true
		}, {
			header : "身体状况",
			dataIndex : 'stzk',
			menuDisabled : true,
			resizable : true
		} ],
		multiSelect : true,
		renderTo : 'show',
		dockedItems : [ {
			xtype : 'pagingtoolbar',
			store : store, // same store GridPanel is using
			dock : 'bottom',
			displayInfo : true,
			displayMsg : '第{0}条到{1}条，共{2}条',
			emptyMsg : '没有记录'
		} ]
	});
});