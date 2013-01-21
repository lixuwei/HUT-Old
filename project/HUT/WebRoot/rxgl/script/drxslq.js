Ext.onReady(function() {
	
	Ext.regModel('Role',{fields:[
		{type:'string',name:'mc'},
		{type:'string',name:'bz'},
		{type:'string',name:'dm'}
	]});
	var RoleModel = Ext.create('Ext.data.Store',{
			model:'Role',
			proxy: {
				type: 'ajax',
				url: 'XslbAction!showAll',
				reader: {
					type: 'json',
					model: Role,
					root: 'items'
				}
			}
		});
	var combo = new Ext.form.ComboBox({
		id:'myCombo',
		labelWidth: 50,
		width:250,
		editable:false,
		queryMode:'remote',
		name:'xslx',
		hiddenName:'Value',
		listConfig:{
			maxHeight:100,
			loadMask:false	
	    },
		fieldLabel:'请选择',
		triggerAction:'all',
		store:RoleModel,
		displayField:'mc',
		valueField:'dm',
		forceSelection:true,
		emptyText: '请选择...'
	});
	
	Ext.QuickTips.init();
	var uploadForm = Ext.create('Ext.form.Panel', {
		//title: '导入学生录取信息',
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
		},combo,{
			xtype: 'textfield',
			labelWidth: 50,
			labelSeparator:':',
			fieldLabel: '年份',
			allowBlank: false,
			blankText: '示例:2012!',
			name: 'year'
		}],
		buttons: [{
			text: '上传文件',
			handler: function() {
				var form = uploadForm.getForm();
				if (form.isValid()) {
					form.submit({
						url: 'XslqAction!uploadXslq.action',
						waitMsg: '正在上传文件',
						success: function(fp,o) {
							Ext.Msg.alert('提示信息','插入成功'+o.result.successCount+'条!更新'+o.result.updateCount+'条!');
						},
						failure: function(fp,o) {
							Ext.Msg.alert('提示信息','插入成功'+o.result.successCount+'条!更新'+o.result.updateCount+'条!');
						}
					});
				}
			}
		},{
			text: '学号编制',
			handler: function() {
				Ext.MessageBox.wait("详细信息内容", "标题", {
       				 interval: 100       //进度条加载速度
   				 });
   				 
   				 $.get("XslqAction!addToOtherTable.action", function(data){
   				 	Ext.MessageBox.hide();
	       			Ext.Msg.alert('提示信息', '成功'+data.successCount+'个,失败'+data.failCount+'个!');
   				 });
   		}
		}]
	});
	
	var itemsPerPage = 15;  // set the number of items you want per page
	
	var store=Ext.create('Ext.data.JsonStore', {
    fields:[/*{name:'id',type:'int'},*/ 'ksbh', 'zjlx','zjhm','xm','csrq','mzm','xbm','hfm','xyjrm','zzmmm','hkszdm',
    'hkszdxxdz','lqdwdm','lqdwmc','lqyxsm','lqzydm','lqzymc','bydwm','bydwmc','byzydm','byzymc','byny','xlzsbh',
    'xxxsdm','xwm','xwzsbh','kslydm','ksfsdm','daszdw','daszdwdz','daszdwyzbm','lqlbm','zzllm','zzllmc','wgymc',
    'ywk1m','ywk1mc','ywk2m','ywk2mc','zzllcj','wgycj','ywk1cj','ywk2cj','zf','fscj','js1mc','js1cj','js2mc',
    'js2cj','dxwpdwszdm','blzgnx','pg','zxjh','xszgzc','zcxh','szssm','bz','fscjqz','nf','flag','xslxdm'],
    pageSize:itemsPerPage,
    proxy: {
        type: 'ajax',
        url:'XslqAction!showAllByPage',
        reader: {
            type: 'json',
            root: 'items',
            totalProperty: 'results'
        }
        
    }
	});
	
	store.load({params:{start:0,limit:itemsPerPage}});  
	
	/*var selectModel = Ext.create('Ext.selection.CheckboxModel');*/
	
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
	    /*selModel:selectModel,*/
	    columns: [
	        /*{header: "序号",dataIndex:'id',menuDisabled:true,resizable:true},*/
	        {header: "考生编号",dataIndex:'ksbh',menuDisabled:true,resizable:true},
	        {header: "证件类型",dataIndex:'zjlx',menuDisabled:true,resizable:true},
	        {header: "证件号码",dataIndex:'zjhm',menuDisabled:true,resizable:true},
	        {header: "姓名",dataIndex:'xm',menuDisabled:true,resizable:true},
	        {header: "出生日期",dataIndex:'csrq',menuDisabled:true,resizable:true},
	        {header: "民族码",dataIndex:'mzm',menuDisabled:true,resizable:true},
	        {header: "性别(1:男 0:女)",dataIndex:'xbm',menuDisabled:true,resizable:true},
	        {header: "婚否(1:已婚 0:未婚)",dataIndex:'hfm',menuDisabled:true,resizable:true},
	        {header: "现役军人码",dataIndex:'xyjrm',menuDisabled:true,resizable:true},
	        {header: "政治面貌代码",dataIndex:'zzmmm',menuDisabled:true,resizable:true},
	        {header: "户口所在地邮政编码",dataIndex:'hkszdm',menuDisabled:true,resizable:true},
	        {header: "户口所在地详细地址",dataIndex:'hkszdxxdz',menuDisabled:true,resizable:true},
	        {header: "录取单位代码",dataIndex:'lqdwdm',menuDisabled:true,resizable:true},
	        {header: "录取单位名称",dataIndex:'lqdwmc',menuDisabled:true,resizable:true},
	        {header: "录取院系所码",dataIndex:'lqyxsm',menuDisabled:true,resizable:true},
	        {header: "录取专业代码",dataIndex:'lqzydm',menuDisabled:true,resizable:true},
	        {header: "录取专业名称",dataIndex:'lqzymc',menuDisabled:true,resizable:true},
	        {header: "毕业单位码",dataIndex:'bydwm',menuDisabled:true,resizable:true},
	        {header: "毕业单位名称",dataIndex:'bydwmc',menuDisabled:true,resizable:true},
	        {header: "毕业专业代码",dataIndex:'byzydm',menuDisabled:true,resizable:true},
	        {header: "毕业专业名称",dataIndex:'byzymc',menuDisabled:true,resizable:true},
	        {header: "毕业年月",dataIndex:'byny',menuDisabled:true,resizable:true},
	        {header: "学历代码",dataIndex:'xlm',menuDisabled:true,resizable:true},
	        {header: "学历证书编号",dataIndex:'xlzsbh',menuDisabled:true,resizable:true},
	        {header: "学习形式代码",dataIndex:'xxxsdm',menuDisabled:true,resizable:true},
	        {header: "学位代码",dataIndex:'xwm',menuDisabled:true,resizable:true},
	        {header: "学位证书编号",dataIndex:'xwzsbh',menuDisabled:true,resizable:true},
	        {header: "考生来源代码",dataIndex:'kslydm',menuDisabled:true,resizable:true},
	        {header: "考试方式代码",dataIndex:'ksfsdm',menuDisabled:true,resizable:true},
	        {header: "档案所在单位",dataIndex:'daszdw',menuDisabled:true,resizable:true},
	        {header: "档案所在单位地址",dataIndex:'daszdwdz',menuDisabled:true,resizable:true},
	        {header: "档案所在单位邮政编码",dataIndex:'daszdwyzbm',menuDisabled:true,resizable:true},
	        {header: "录取类别码",dataIndex:'lqlbm',menuDisabled:true,resizable:true},
	        {header: "政治理论码",dataIndex:'zzllm',menuDisabled:true,resizable:true},
	        {header: "政治理论名称",dataIndex:'zzllmc',menuDisabled:true,resizable:true},
	        {header: "外国语码",dataIndex:'wgym',menuDisabled:true,resizable:true},
	        {header: "外国语名称",dataIndex:'wgymc',menuDisabled:true,resizable:true},
	        {header: "业务课一代码",dataIndex:'ywk1m',menuDisabled:true,resizable:true},
	        {header: "业务课一名称",dataIndex:'ywk1mc',menuDisabled:true,resizable:true},
	        {header: "业务课二代码",dataIndex:'ywk2m',menuDisabled:true,resizable:true},
	        {header: "业务课二名称",dataIndex:'ywk2mc',menuDisabled:true,resizable:true},
	        {header: "政治理论成绩",dataIndex:'zzllcj',menuDisabled:true,resizable:true},
	        {header: "外国语成绩",dataIndex:'wgycj',menuDisabled:true,resizable:true},
	        {header: "业务课一成绩",dataIndex:'ywk1cj',menuDisabled:true,resizable:true},
	        {header: "业务课二成绩",dataIndex:'ywk2cj',menuDisabled:true,resizable:true},
	        {header: "总分",dataIndex:'zf',menuDisabled:true,resizable:true},
	        {header: "复试成绩",dataIndex:'fscj',menuDisabled:true,resizable:true},
	        {header: "加试科目一名称",dataIndex:'js1mc',menuDisabled:true,resizable:true},
	        {header: "加试科目一成绩",dataIndex:'js1cj',menuDisabled:true,resizable:true},
	        {header: "加试科目二名称",dataIndex:'js2mc',menuDisabled:true,resizable:true},
	        {header: "加试科目二成绩",dataIndex:'js2cj',menuDisabled:true,resizable:true},
	        {header: "定向委培单位",dataIndex:'dxwpdw',menuDisabled:true,resizable:true},
	        {header: "定向委培单位所在代码",dataIndex:'dxwpdwszdm',menuDisabled:true,resizable:true},
	        {header: "保留资格年限",dataIndex:'blzgnx',menuDisabled:true,resizable:true},
	        {header: "破格",dataIndex:'pg',menuDisabled:true,resizable:true},
	        {header: "专项计划",dataIndex:'zxjh',menuDisabled:true,resizable:true},
	        {header: "享受资格政策",dataIndex:'xszgzc',menuDisabled:true,resizable:true},
	        {header: "注册学号",dataIndex:'zcxh',menuDisabled:true,resizable:true},
	        {header: "所在省市码",dataIndex:'szssm',menuDisabled:true,resizable:true},
	        {header: "备注",dataIndex:'bz',menuDisabled:true,resizable:true},
	        {header: "复试成绩权重",dataIndex:'fscjqz',menuDisabled:true,resizable:true},
	        {header: "年份",dataIndex:'nf',menuDisabled:true,resizable:true},
			{header: "是否编制学号",dataIndex:'flag',menuDisabled:true,resizable:true},
			{header: "学生类型",dataIndex:'xslxdm',menuDisabled:true,resizable:true}	         
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