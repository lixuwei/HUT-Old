Ext.onReady(function() {

	// 学期
	Ext.regModel('xueqi', {
		fields : [ {
			type : 'string',
			name : 'dm'
		}, {
			type : 'string',
			name : 'mc'
		} ]
	});
	var XueqiModel = Ext.create('Ext.data.Store', {
		model : 'xueqi',
		data : [ {
			dm : '1',
			mc : '上学期'
		}, {
			dm : '2',
			mc : '下学期'
		}]
	});
	var Xueqi = new Ext.form.ComboBox({
		id : 'xueqiCombo',
		fieldLabel: '学期',
		labelWidth: 50,
		width : 150,
		editable : false,
		queryMode : 'local',
		name : 'xueqi',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		triggerAction : 'all',
		store : XueqiModel,
		displayField : 'mc',
		valueField : 'dm',
		forceSelection : true
	});

	var itemsPerPage = 20; // set the number of items you want per page
	var store = Ext.create('Ext.data.JsonStore', {
		fields : [ 'xh', 'xm', 'ejxk', 'xy', 'kcmc', 'kclb', 'xf', 'cj', 'ch', 'bz'],
		pageSize : itemsPerPage,
		proxy : {
			type : 'ajax',
			url : 'KccjAction!showXsCj',
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
			id: 'year',
			xtype: 'textfield',
			fieldLabel: '年份',
        	name: 'year'
		}, Xueqi, '|',{
			text : "查询",
			handler : function() {
				Ext.apply(store.proxy.extraParams, {
					year: Ext.getCmp('year').value,
					xueqi: Xueqi.value
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
			header : "专业",
			dataIndex : 'ejxk',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学院",
			dataIndex : 'xy',
			menuDisabled : true,
			resizable : true
		}, {
			header : "课程名称",
			dataIndex : 'kcmc',
			menuDisabled : true,
			resizable : true
		}, {
			header : "课程类别",
			dataIndex : 'kclb',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学分",
			dataIndex : 'xf',
			menuDisabled : true,
			resizable : true
		}, {
			header : "成绩",
			dataIndex : 'cj',
			menuDisabled : true,
			resizable : true
		}, {
			header : "备注",
			dataIndex : 'bz',
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