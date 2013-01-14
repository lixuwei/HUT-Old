Ext.onReady(function() {
	
	Ext.QuickTips.init();
	var uploadForm = Ext.create('Ext.form.Panel', {
		bodyStyle: 'padding: 5 5 5 5',
		frame: true,
		width: 400,
		renderTo: 'upload',
		defaults: {
			labelSeparator: ':',
			labelWidth: 100,
			width: 250,
			allowBlank: false,
			labelAlign: 'left',
			msgTarget: 'side'
		},
		items: [{
			xtype: 'filefield',
			name: 'upload',
			fieldLabel: '第一步:上传文件',
			buttonText: '请选择...',
			blankText: '请选择文件!'
		}],
		buttons: [{
			text: '上传文件',
			handler: function() {
				var form = uploadForm.getForm();
				if (form.isValid()) {
					form.submit({
						url: 'LessonAction!uploadLesson',
						waitMsg: '正在上传文件',
						success: function(fp,o) {
							Ext.Msg.alert('提示信息','插入成功'+o.result.successCount+'条!失败'+o.result.failCount+'条!');
						}
					});
				}
			}
		}]
	});
	
	var itemsPerPage = 15;  // set the number of items you want per page
	
	var store=Ext.create('Ext.data.JsonStore', {
    fields:['kcdm', 'kcmc','kclb','xf','xs','kkxq','kkdw','flag','khfs','state','year','bz'],
    pageSize:itemsPerPage,
    proxy: {
        type: 'ajax',
        url:'LessonAction!showAllByPage',
        reader: {
            type: 'json',
            root: 'items',
            totalProperty: 'results'
        }
        
    }
	});
	
	store.load({params:{start:0,limit:itemsPerPage}});  
	
	var selectModel = Ext.create('Ext.selection.CheckboxModel');
	
	var showXslq = Ext.create('Ext.grid.Panel', {
	    store: store,
	    tbar: [{
		text:"新增" ,
		handler: function() {
		
		}},{
		text:"修改" ,
		handler: function() {
		
		}},{
		text:"删除" ,
		handler: function() {
		
		}},{
		text:"查询" ,
		handler: function() {
		
		}}
		],
	    selModel:selectModel,
	    columns: [
	        {header: "课程代码",dataIndex:'kcdm',menuDisabled:true,resizable:true},
	        {header: "课程名称",dataIndex:'kcmc',menuDisabled:true,resizable:true},
	        {header: "课程类别",dataIndex:'kclb',menuDisabled:true,resizable:true},
	        {header: "学分",dataIndex:'xf',menuDisabled:true,resizable:true},
	        {header: "学时",dataIndex:'xs',menuDisabled:true,resizable:true},
	        {header: "开课学期",dataIndex:'kkxq',menuDisabled:true,resizable:true},
	        {header: "开课单位",dataIndex:'kkdw',menuDisabled:true,resizable:true},
	        {header: "标志",dataIndex:'flag',menuDisabled:true,resizable:true},
	        {header: "考核方式",dataIndex:'khfs',menuDisabled:true,resizable:true},
	        {header: "是否锁定",dataIndex:'state',menuDisabled:true,resizable:true},
	        {header: "年份",dataIndex:'year',menuDisabled:true,resizable:true},
	        {header: "备注",dataIndex:'bz',menuDisabled:true,resizable:true}
	    ],
	    multiSelect: true,
	    renderTo: 'show',
        dockedItems: [{
	       xtype: 'pagingtoolbar',
	        store: store,   // same store GridPanel is using
	        dock: 'bottom',
	        displayInfo: true,
	        displayMsg:'第{0}条到{1}条，共{2}条',
            emptyMsg:'没有记录' 
   		 }]
	});
	
});