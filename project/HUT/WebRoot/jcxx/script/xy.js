Ext.onReady(function() {
	
	Ext.regModel('Xy',{
		fiields: [ 'dm', 'xymc']
	});
	
	xyForm = new Ext.form.Panel({
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
			blankText: '学院代码不能为空',
			id: 'dm',
			name: 'dm',
			fieldLabel: '学院代码'
		},{
			xtype: 'textfield',
			allowBlank: false,
			blankText: '学院名称不能为空',
			id: 'xymc',
			name: 'xymc',
			fieldLabel: '学院名称'
		}],
		buttons: [{
			text: '提交',
			handler: function() {
				if(xyForm.isAdd) {
					xyForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'XyAction!addXy',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '新增学院成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '新增学院失败');
						}
					});
				} else {
					xyForm.form.submit({
						clientValidation: true,
						waitMsg: '正在提交数据请稍后',
						waitTitle: '提示',
						url: 'XyAction!modifyXy',
						method: 'POST',
						success: function(form, action) {
							win.hide();
							Ext.Msg.alert('提示', '修改学院成功');
						},
						failure: function(form, action) {
							Ext.Msg.alert('提示', '修改学院失败');
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
		items: xyForm
	});
	
	// 显示添加学院窗口
	function showAddXy(){
		xyForm.form.reset();
		Ext.getCmp('dm').setReadOnly(false);
		xyForm.isAdd = true;
		win.setTitle('新增学院信息');
		win.show();
	}
	
	// 显示修改学院窗口
	function showModifyXy() {
		var rows = showXy.getSelectionModel().getSelection();
		if(rows.length == 0) {
			Ext.MessageBox.alert("提示","请选择需要修改的学院信息");
			return ;
		} else if(rows.length > 1){
			Ext.MessageBox.alert("提示","每次只能修改一条学院信息");
		} else if(rows.length == 1) {
			xyForm.form.reset();
			xyForm.isAdd = false;
			win.setTitle('修改学院信息');
			win.show();
			Ext.getCmp('dm').setValue(rows[0].get('dm'));
			Ext.getCmp('dm').setReadOnly(true);
			Ext.getCmp('xymc').setValue(rows[0].get('xymc'));
		}
	}
	
	// 显示删除学院对话框
	function showDeleteXys() {
		var rows = showXy.getSelectionModel().getSelection();
		if(rows.length == 0) {
			return ;
		}
		Ext.MessageBox.confirm("提示","您确定要删除所选学院吗?", function(btnId) {
			if(btnId == 'yes') {
				var xydms = new Array();
				for(var i=0; i<rows.length; i++) {
					xydms.push(rows[i].get('dm'));
				}
				Ext.Ajax.request({
					url: 'XyAction!deleteXys',
					params: {"xydms":xydms},
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
		fields : [ 'dm', 'xymc'],
		pageSize : itemsPerPage,
		proxy : {
			type : 'ajax',
			url : 'XyAction!showAllByPage',
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

	showXy = Ext.create('Ext.grid.Panel', {
		id: 'showXy',
		store : store,
		tbar : [ {
			text : "新增",
			handler : showAddXy
		}, {
			text : "修改",
			handler : showModifyXy
		}, {
			text : "删除",
			handler : showDeleteXys
		} ],
		selModel : selectModel,
		columns : [ {
			header : "学院代码",
			dataIndex : 'dm',
			menuDisabled : true,
			resizable : true
		}, {
			header : "学院名称",
			dataIndex : 'xymc',
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