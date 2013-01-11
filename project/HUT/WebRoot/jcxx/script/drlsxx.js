Ext.onReady(function() {
	

	Ext.QuickTips.init();
	var uploadForm = Ext.create('Ext.form.Panel', {
		bodyStyle: 'padding: 5 5 5 5',
		frame: true,
		width: 500,
		renderTo: 'upload2',
		defaults: {
			labelSeparator: ':',
			labelWidth: 100,
			width: 350,
			allowBlank: false,
			labelAlign: 'left',
			msgTarget: 'side'
		},
		items: [{
			xtype: 'filefield',
			name: 'upload',
			fieldLabel: '上传',
			buttonText: '请选择...',
			blankText: '请选择文件!'
		}],
		buttons: [{
			text: '上传',
			handler: function() {
				var form = uploadForm.getForm();
				if (form.isValid()) {
					form.submit({
						url: 'TeacherAction!insertData.action',
						/*waitMsg: '正在上传文件',*/
						
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
    fields:[/*{name:'id',type:'int'},*/ 'lsbh', 'xm','zgh','zplj','xb','mzdm','csrq','zzmmdm','xydm','xdm','lxdh',
    'email','byxxdm','byzydm','xldm','xwdm','zcdm','zw','xkfx','sfzh','jszgzh','zjjszgzh','jxzlpj','jsjj'],
    pageSize:itemsPerPage,
    proxy: {
        type: 'ajax',
        url:'TeacherAction!showAllLS.action',
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
		        /*{header: "序号",dataIndex:'id',menuDisabled:true,resizable:true},*/
		        {header: "老师编号",dataIndex:'lsbh',menuDisabled:true,resizable:true},
		        {header: "姓名",dataIndex:'xm',menuDisabled:true,resizable:true},
		        {header: "职工号",dataIndex:'zgh',menuDisabled:true,resizable:true},
		        {header: "照片路径",dataIndex:'zplj',menuDisabled:true,resizable:true},
		        {header: "性别",dataIndex:'xb',menuDisabled:true,resizable:true},
		        {header: "民族",dataIndex:'mzdm',menuDisabled:true,resizable:true},
		        {header: "出生日期",dataIndex:'csrq',menuDisabled:true,resizable:true},
		        {header: "政治面貌",dataIndex:'zzmmdm',menuDisabled:true,resizable:true},
		        {header: "学院",dataIndex:'xydm',menuDisabled:true,resizable:true},
		        {header: "所在的系",dataIndex:'xdm',menuDisabled:true,resizable:true},
		        {header: "联系方式",dataIndex:'lxdh',menuDisabled:true,resizable:true},
		        {header: "Email",dataIndex:'email',menuDisabled:true,resizable:true},
		        {header: "毕业学校",dataIndex:'byxxdm',menuDisabled:true,resizable:true},
		        {header: "毕业专业",dataIndex:'byzydm',menuDisabled:true,resizable:true},
		        {header: "学历",dataIndex:'xldm',menuDisabled:true,resizable:true},
		        {header: "学位",dataIndex:'xwdm',menuDisabled:true,resizable:true},
		        {header: "职称",dataIndex:'zcdm',menuDisabled:true,resizable:true},
		        {header: "职务",dataIndex:'zw',menuDisabled:true,resizable:true},
		        {header: "学科方向",dataIndex:'xkfx',menuDisabled:true,resizable:true},
		        {header: "身份证号",dataIndex:'sfzh',menuDisabled:true,resizable:true},
		        {header: "教师资格证",dataIndex:'jszgzh',menuDisabled:true,resizable:true},
		        {header: "主讲教师资格证号",dataIndex:'zjjszgzh',menuDisabled:true,resizable:true},
		        {header: "教学质量评估",dataIndex:'jxzlpj',menuDisabled:true,resizable:true},
		        {header: "教师简历",dataIndex:'jsjj',menuDisabled:true,resizable:true}     
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