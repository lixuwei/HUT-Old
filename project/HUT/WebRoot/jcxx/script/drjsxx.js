Ext.onReady(function(){
	
	Ext.QuickTips.init();
	var uploadForm = Ext.create('Ext.form.Panel',{
		bodyStyle:'padding:5 5 5 5',
		frame:true,
		width:500,
		renderTo:'upload2',
		defaults:{
			labelSeparator: ':',
			labelWidth: 100,
			width: 350,
			allowBlank: false,
			labelAlign: 'left',
			msgTarget: 'side'
		},
		items:[{
			xtype: 'filefield',
			name: 'upload',
			fieldLabel: '上传',
			buttonText: '请选择...',
			blankText: '请选择文件!'
		}],
		buttons:[{
			text: '上传',
			handler: function() {
				var form = uploadForm.getForm();
				if (form.isValid()) {
					form.submit({
						url: 'JsxxAction!insertData2Jsxx.action',
						success: function(fp,o) {
							Ext.Msg.alert('提示信息','插入成功'+o.result.successCount+'条!更新'+o.result.updateCount+'条!');
						},
						failure: function(fp,o) {
							Ext.Msg.alert('提示信息','插入成功'+o.result.successCount+'条!更新'+o.result.updateCount+'条!');
						}
					});
				}
			}
		}]
	});
	
	
	
	var itemsPerPage = 10;  // set the number of items you want per page
	

	
	var store=Ext.create('Ext.data.JsonStore', {
    fields:[/*'id',*/ 'jsmc','jswz','lx','rnskrs','rnksrs','ssbm','flag','bz'],
    pageSize:itemsPerPage,
    proxy: {
        type: 'ajax',
        url:'JsxxAction!showAllByPage',
        reader: {
            type: 'json',
            root: 'items',
            totalProperty: 'results'
        }
        
    }
	});
	

	store.load({params:{start:0,limit:itemsPerPage}});  
	  
	var selectModel= Ext.create('Ext.selection.CheckboxModel');

		
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
				
			}}
			],
		    selModel:selectModel,
		    columns: [
		        {header: "序号",dataIndex:'id',menuDisabled:true,resizable:true},
		        {header: "教室名称",dataIndex:'jsmc',menuDisabled:true,resizable:true},
		        {header: "教室位置",dataIndex:'jswz',menuDisabled:true,resizable:true},
		        {header: "教师类型",dataIndex:'lx',menuDisabled:true,resizable:true},
		        {header: "容纳上课人数",dataIndex:'rnskrs',menuDisabled:true,resizable:true},
		        {header: "容纳考试人数",dataIndex:'rnksrs',menuDisabled:true,resizable:true},
		        {header: "教室所属部门",dataIndex:'ssbm',menuDisabled:true,resizable:true},
		        {header: "教室所属部门的类型",dataIndex:'flag',menuDisabled:true,resizable:true},
		        {header: "备注",dataIndex:'bz',menuDisabled:true,resizable:true}
		    ],
		    multiSelect: true,
		    renderTo: 'show2',
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