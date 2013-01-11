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
						url: 'DaoShiAction!insertData.action',
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
    fields:[/*{name:'id',type:'int'},*/ 'lsbh', 'xm','zyxkyjxkm','zyxkejxkm','zyxkzdbs','zybszps','zyxkzdss','zysszps','dexkyjxkm','dexkejxkm','dexkzdbs',
    'debszps','dexkzdss','desszps','yjfx','zgxl','zgxlsj','zgxw','zgxwsj','zyjszw','dslb','scrsdsj','scrbdsj','zjlbdm','zydm','wymc','wyslcd','jzbsds','jzdwmc'],
    pageSize:itemsPerPage,
    proxy: {
        type: 'ajax',
        url:'DaoShiAction!showAllDS.action',
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
			
			}},{
			text:"查询" ,
			handler: function() {
				
			}}
			],
		    selModel:selectModel,
		    columns: [
		        /*{header: "序号",dataIndex:'id',menuDisabled:true,resizable:true},*/
		        {header: "导师编号",dataIndex:'lsbh',menuDisabled:true,resizable:true},
		        {header: "姓名",dataIndex:'xm',menuDisabled:true,resizable:true},
		        {header: "主研学科一级学科码",dataIndex:'zyxkyjxkm',menuDisabled:true,resizable:true},
		        {header: "主研学科二级学科码",dataIndex:'zyxkejxkm',menuDisabled:true,resizable:true},
		        {header: "主研学科在读博士人数",dataIndex:'zyxkzdbs',menuDisabled:true,resizable:true},
		        {header: "主研学科博士招聘数",dataIndex:'zybszps',menuDisabled:true,resizable:true},
		        {header: "主研学科在读硕士人数",dataIndex:'zyxkzdss',menuDisabled:true,resizable:true},
		        {header: "主研学科硕士招聘数",dataIndex:'zysszps',menuDisabled:true,resizable:true},
		        {header: "第二学科一级学科码",dataIndex:'dexkyjxkm',menuDisabled:true,resizable:true},
		        {header: "第二学科二级学科码",dataIndex:'dexkejxkm',menuDisabled:true,resizable:true},
		        {header: "第二学科在读博士人数",dataIndex:'dexkzdbs',menuDisabled:true,resizable:true},
		        {header: "第二学科博士招聘数",dataIndex:'debszps',menuDisabled:true,resizable:true},
		        {header: "第二学科在读硕士人数",dataIndex:'dexkzdss',menuDisabled:true,resizable:true},
		        {header: "第二学科硕士招聘数",dataIndex:'desszps',menuDisabled:true,resizable:true},
		        {header: "研究方向",dataIndex:'yjfx',menuDisabled:true,resizable:true},
		        {header: "最高学历",dataIndex:'zgxl',menuDisabled:true,resizable:true},
		        {header: "获得最高学历时间",dataIndex:'zgxlsj',menuDisabled:true,resizable:true},
		        {header: "最高学位",dataIndex:'zgxw',menuDisabled:true,resizable:true},
		        {header: "获得最高学位时间",dataIndex:'zgxwsj',menuDisabled:true,resizable:true},
		        {header: "专业技术职务",dataIndex:'zyjszw',menuDisabled:true,resizable:true},
		        {header: "导师类别",dataIndex:'dslb',menuDisabled:true,resizable:true},
		        {header: "首次任硕导时间",dataIndex:'scrsdsj',menuDisabled:true,resizable:true},
		        {header: "首次任博导时间",dataIndex:'scrbdsj',menuDisabled:true,resizable:true},
		        {header: "专家类别",dataIndex:'zjlbdm',menuDisabled:true,resizable:true},     
		    	{header: "专业",dataIndex:'zydm',menuDisabled:true,resizable:true},
		        {header: "外国语名称",dataIndex:'wymc',menuDisabled:true,resizable:true},
		        {header: "外语熟练程度",dataIndex:'wyslcd',menuDisabled:true,resizable:true},
		        {header: "是否在外单位担任兼职博士指导教师",dataIndex:'jzbsds',menuDisabled:true,resizable:true},
		        {header: "兼职单位名称",dataIndex:'jzdwmc',menuDisabled:true,resizable:true}     
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