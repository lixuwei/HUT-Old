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
		labelWidth: 80,
		width : 250,
		editable : false,
		queryMode : 'remote',
		name : 'xydm',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		allowBlank: false,
		blankText: '学院不能为空',
		fieldLabel : '学院',
		triggerAction : 'all',
		store : XyModel,
		displayField : 'xymc',
		valueField : 'dm',
		forceSelection : true
	});
	
	Ext.regModel('Zy',{
		fiields: [ 'ejxkdm', 'ejxkmc', 'yjxkdm', 'yjxkmc', 'mldm', 'mlmc']
	});
	
	ejxkForm = new Ext.form.Panel({
		fieldDefaults: {
			labelSeparator: ':',
			labelWidth: 80,
			msgTarget: 'side',
			width: 250
		},
		bodyPadding: 5,
		frame: true,
		items: [{
			xtype: 'textfield',
			allowBlank: false,
			blankText: '专业代码不能为空',
			id: 'ejxkdm',
			name: 'ejxkdm',
			fieldLabel: '专业代码'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '专业名称不能为空',
			id: 'ejxkmc',
			name: 'ejxkmc',
			fieldLabel: '专业名称'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '一级学科代码不能为空',
			id: 'yjxkdm',
			name: 'yjxkdm',
			fieldLabel: '一级学科代码'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '一级学科名称不能为空',
			id: 'yjxkmc',
			name: 'yjxkmc',
			fieldLabel: '一级学科名称'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '门类代码不能为空',
			id: 'mldm',
			name: 'mldm',
			fieldLabel: '门类代码'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '门类名称不能为空',
			id: 'mlmc',
			name: 'mlmc',
			fieldLabel: '门类名称'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '学位类型不能为空',
			id: 'xwlx',
			name: 'xwlx',
			fieldLabel: '学位类型名称'
		},{
			xtype: 'hiddenfield',
	        name: 'id',
	        id: "id"
		}, Xy],
		buttons: [{
			text: '提交',
			handler: function() {
				if(ejxkForm.isAdd) {
					ejxkForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'EjxkAction!addEjxk',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '新增专业成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '新增专业失败');
						}
					});
				} else {
					ejxkForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'EjxkAction!modifyEjxk',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '修改专业成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '修改专业失败');
						}
					});
				}
			}
		},{
			text: '关闭',
			handler: function() {
				win.hide();
			}
		}]
	});
	
	// 弹出框
	var win = new Ext.window.Window({
		layout: 'fit',
		width: 300,
		closeAction: 'hide',
		height: 300,
		resizable: false,
		shadow: true,
		modal: true,
		closeable: true,
		items: ejxkForm
	});
	
	// 显示添加窗口
	function showAdd(){
		ejxkForm.form.reset();
		// Ext.getCmp('dm').setReadOnly(false);
		// Ext.getCmp('ejxkdm').setDisabled(true);
		ejxkForm.isAdd = true;
		win.setTitle('新增专业');
		win.show();
	}
	
	// 显示修改窗口
	function showModify() {
		Xy.getStore().reload();
		var rows = showEjxkAndXy.getSelectionModel().getSelection();
		if(rows.length == 0) {
			Ext.MessageBox.alert("提示","请选择需要修改的专业");
			return ;
		} else if(rows.length > 1){
			Ext.MessageBox.alert("提示","每次只能修改一条专业");
		} else if(rows.length == 1) {
			ejxkForm.form.reset();
			ejxkForm.isAdd = false;
			win.setTitle('修改专业信息');
			win.show();
			Ext.getCmp('ejxkdm').setValue(rows[0].get('ejxkdm'));
			Ext.getCmp('ejxkmc').setValue(rows[0].get('ejxkmc'));
			Ext.getCmp('yjxkdm').setValue(rows[0].get('yjxkdm'));
			Ext.getCmp('yjxkmc').setValue(rows[0].get('yjxkmc'));
			Ext.getCmp('mldm').setValue(rows[0].get('mldm'));
			Ext.getCmp('mlmc').setValue(rows[0].get('mlmc'));
			Ext.getCmp('id').setValue(rows[0].get('id'));
			Ext.getCmp('xwlx').setValue(rows[0].get('xwlx'));
			Ext.getCmp('xyCombo').setValue(rows[0].get('xydm'));
		}
	}
	
	// 显示删除对话框
	function showDelete() {
		var rows = showEjxkAndXy.getSelectionModel().getSelection();
		if(rows.length == 0) {
			return ;
		}
		Ext.MessageBox.confirm("提示","您确定要删除所选专业吗?", function(btnId) {
			if(btnId == 'yes') {
				var ids = new Array();
				for(var i=0; i<rows.length; i++) {
					ids.push(rows[i].get('id'));
				}
				Ext.Ajax.request({
					url: 'EjckAction!deleteEjcks',
					params: {"ids":ids},
					method: 'post',
					success: function() {
						Ext.MessageBox.alert("提示","删除成功!");
					}
				});
			}
		});
	}
	
	var itemsPerPage = 20; // set the number of items you want per page
	var store = Ext.create('Ext.data.JsonStore', {
		fields : [ 'ejxkdm', 'ejxkmc', 'yjxkdm', 'yjxkmc', 'mldm', 'mlmc', 'xwlx', 'xydm', 'xymc', 'id'],
		pageSize : itemsPerPage,
		proxy : {
			type : 'ajax',
			url : 'EjxkAction!showAllByPage',
			reader : {
				type : 'json',
				root : 'ejxkAndXyItems',
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

	showEjxkAndXy = Ext.create('Ext.grid.Panel', {
		id: 'showEjxkAndXy',
		store : store,
		tbar : [ {
			text : "新增",
			handler : showAdd
		}, {
			text : "修改",
			handler : showModify
		}, {
			text : "删除",
			handler : showDelete
		} ],
		selModel : selectModel,
		columns : [ {
			header : "二级学科代码",
			dataIndex : 'ejxkdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "二级学科名称",
			dataIndex : 'ejxkmc',
			menuDisabled : true,
			resizable : true
		}, {
			header : "一级学科代码",
			dataIndex : 'yjxkdm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "一级学科名称",
			dataIndex : 'yjxkmc',
			menuDisabled : true,
			resizable : true
		}, {
			header : "门类代码",
			dataIndex : 'mldm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "门类名称",
			dataIndex : 'mlmc',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学位类型",
			dataIndex : 'xwlx',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学院代码",
			dataIndex : 'xydm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学院名称",
			dataIndex : 'xymc',
			menuDisabled : true,
			resizable : true
		}/*,{
			header : "id",
			dataIndex : 'id',
			menuDisabled : true,
			resizable : true
		}*/ ],
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