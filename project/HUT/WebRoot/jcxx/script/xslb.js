Ext.onReady(function() {
	
	Ext.regModel('Xslb',{
		fiields: [ 'dm', 'mc', 'bz']
	});
	
	xslbForm = new Ext.form.Panel({
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
			blankText: '学生类别代码不能为空',
			id: 'dm',
			name: 'dm',
			fieldLabel: '学生类别名称'
		}, {
			xtype: 'textfield',
			allowBlank: false,
			blankText: '学生类别名称不能为空',
			id: 'mc',
			name: 'mc',
			fieldLabel: '学生类别名称'
		},{
		xtype: 'textfield',
		allowBlank: false,
		blankText: '学生类别标志不能为空',
		id: 'bz',
		name: 'bz',
		fieldLabel: '学生类别标志'
		}],
		buttons: [{
			text: '提交',
			handler: function() {
				if(xslbForm.isAdd) {
					xslbForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'XslbAction!addXslb',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '新增学生类型成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '新增学生类型失败');
						}
					});
				} else {
					xslbForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'XslbAction!modifyXslb',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '修改学生类型成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '修改学生类型失败');
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
		height: 150,
		resizable: false,
		shadow: true,
		modal: true,
		closeable: true,
		items: xslbForm
	});
	
	// 显示添加窗口
	function showAdd(){
		xslbForm.form.reset();
		// Ext.getCmp('dm').setReadOnly(false);
		Ext.getCmp('dm').setDisabled(true);
		xslbForm.isAdd = true;
		win.setTitle('新增学生类别');
		win.show();
	}
	
	// 显示修改窗口
	function showModify() {
		var rows = showXslb.getSelectionModel().getSelection();
		if(rows.length == 0) {
			Ext.MessageBox.alert("提示","请选择需要修改的学生类别");
			return ;
		} else if(rows.length > 1){
			Ext.MessageBox.alert("提示","每次只能修改一条学生类别信息");
		} else if(rows.length == 1) {
			xslbForm.form.reset();
			xslbForm.isAdd = false;
			win.setTitle('修改学生类别信息');
			win.show();
			Ext.getCmp('dm').setValue(rows[0].get('dm'));
			Ext.getCmp('dm').setReadOnly(true);
			Ext.getCmp('mc').setValue(rows[0].get('mc'));
			Ext.getCmp('bz').setValue(rows[0].get('bz'));
		}
	}
	
	// 显示删除对话框
	function showDelete() {
		var rows = showXslb.getSelectionModel().getSelection();
		if(rows.length == 0) {
			return ;
		}
		Ext.MessageBox.confirm("提示","您确定要删除所选学生类别吗?", function(btnId) {
			if(btnId == 'yes') {
				var xslbdms = new Array();
				for(var i=0; i<rows.length; i++) {
					xslbdms.push(rows[i].get('dm'));
				}
				Ext.Ajax.request({
					url: 'XslbAction!deleteXslbs',
					params: {"xslbdms":xslbdms},
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
		fields : [ 'dm', 'mc', 'bz'],
		pageSize : itemsPerPage,
		proxy : {
			type : 'ajax',
			url : 'XslbAction!showAllByPage',
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

	showXslb = Ext.create('Ext.grid.Panel', {
		id: 'showxslb',
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
			header : "学生类型代码",
			dataIndex : 'dm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学生类型名称",
			dataIndex : 'mc',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学生类型标志",
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