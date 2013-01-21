Ext.onReady(function() {
	Ext.regModel('Role', {
				fields : [{
							type : 'int',
							name : 'roleId'
						}, {
							type : 'string',
							name : 'roleName'
						}]
			});
	var RoleModel = Ext.create('Ext.data.Store', {
				model : 'Role',
				proxy : {
					type : 'ajax',
					url : 'UserRoleAction!showRole',
					reader : {
						type : 'json',
						model : Role,
						root : 'items'
					}
				}
			});
	var Role = new Ext.form.ComboBox({
		id : 'roleCombo',
		labelWidth : 40,
		// width : 195,
		editable : false,
		queryMode : 'remote',
		name : 'roleId',
		hiddenName : 'Value',
		listConfig : {
			maxHeight : 100,
			loadMask : false
		},
		fieldLabel : '角色',
		triggerAction : 'all',
		store : RoleModel,
		displayField : 'roleName',
		valueField : 'roleId',
		forceSelection : true
			// value: 10
		});

	Role.on('boxready', function(Role, width, height) {
				Ext.apply(RoleModel.proxy.extraParams, {
							username : username
						});
				RoleModel.load();
				// 将roleId写入session
				$.ajax({
							type : "POST",
							url : "UserRoleAction!writeRoleIdToSession",
							data : "roleId=" + roleid,
							async : false,
							success : function(data) {

							}
						});
			});

	Role.on('change', function(Role, newValue, oldValue) {
		roleid = newValue;
		// 将roleId写入session
		$.ajax({
					type : "POST",
					url : "UserRoleAction!writeRoleIdToSession",
					data : "roleId=" + roleid,
					async : false,
					success : function(data) {
						Ext.getCmp('menuTree').getStore().load({ params: { id: "root"} });
					}
				});
	});

	Ext.regModel('Menu', {
				fields : ['id', 'text', 'leaf', 'url', 'expanded']
			});

	var menuStore = Ext.create('Ext.data.TreeStore', {
				model : 'Menu',
				proxy : {
					type : 'ajax',
					url : 'TreeAction!treeData',
					reader : {
						type : 'json',
						model : Menu,
						root : 'items'
					}
				},
				nodeParam : "id"
				
			});
			
	/*Ext.regModel('Menu', {
				fields : ['id', 'text']
			});
	var menuStore = Ext.create('Ext.data.TreeStore', {
				model : 'Menu',
				proxy : {
					type : 'memory',
					data : [{
								text : '入学管理',
								leaf : false,
								expanded : true,
								children : [{
											text : '导入学生录取信息',
											leaf : true,
											url : './rxgl/drxslq.html'
										}, {
											text : '学生信息查看',
											leaf : true,
											url : './rxgl/ckxs.html'
										}]
							}, {
								text : '基础信息维护',
								id : 'jcxxwh',
								leaf : false,
								expanded : false,
								children : [{
											text : '学院信息维护',
											leaf : true,
											url : './jcxx/xy.html'
										}, {
											text : '学生类别信息维护',
											leaf : true,
											url : './jcxx/xslb.html'
										}, {
											text : '专业信息维护',
											leaf : true,
											url : './jcxx/ejxk.html'
										}]
							}, {
								text : '学科管理',
								leaf : false,
								expanded : false,
								children : [{
											text : '导入老师信息',
											leaf : true,
											url : './jcxx/drlsxx.html'
										}]

							}]
				},
				listeners : {
					expand : function(node) {
						// 切换页面内容
						// changePage(node.get('url'),
						// node.get('text'));
					}
				}
			});*/
		
	// 切换内容页面
	function changePage(url, title) {
		Ext.getDom('contentIframe').src = url;
		Ext.getCmp('mainContent').setTitle(title);
	};

	// 创建菜单树
	var menuTree = Ext.create('Ext.tree.Panel', {
				border : false,
				store : menuStore,
				id : 'menuTree',
				height : '100%',
				hrefTarget : 'mainContent',
				rootVisible : false,
				/*rootVisible : true, //显示根节点  
			    root: {  
			        id: 'root',  
			        text: '根节点',  
			        expanded: false,  
			        leaf: false  
			    },  */
				viewConfig : {  
        			loadingText : "加载数据..."  
    			},
				tbar : [
				// 角色下拉框
				Role],
				listeners : {
					itemclick : function(view, rec, item, index, e) {
						if (rec.get('url') != null && rec.get('url') != "")
							changePage(rec.get('url'), rec.get('text'));
					}
				}
			});

	Ext.create('Ext.container.Viewport', {
				layout : 'border',
				items : [{
							conlapsible : true,
							html : '<br><center><h1>研究生教务管理系统</h1></center>',
							region : 'north',
							height : 100
						}, {
							title : '功能菜单',
							width : 200,
							items : menuTree,
							split : true,
							region : 'west'
						}, {
							layout : 'fit',
							contentEl : 'contentIframe',
							id : 'mainContent',
							region : 'center'
						}]
			});

	Ext.getCmp('roleCombo').getStore().reload();
	Ext.getCmp('roleCombo').setValue(roleid);
});
