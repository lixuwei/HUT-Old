Ext.onReady(function() {
	Ext.QuickTips.init();
	var passwordForm = Ext.create('Ext.form.Panel', {
		bodyStyle: 'padding: 5 5 5 5',
		frame: true,
		width: 500,
		id: 'passwordForm',
		renderTo: 'show',
		defaults: {
			labelSeparator: ':',
			labelWidth: 100,
			width: 350,
			labelAlign: 'center',
			msgTarget: 'side'
		},
		items: [{
			id: 'oldPassword',
			xtype:'textfield',
			name:'oldPassword',
			fieldLabel:'原密码',
			inputType:'password',
			allowBlank: false,
			blankText: '原密码不能为空'
		}, {
			id: 'newPassword',
			xtype:'textfield',
			inputType:'password',
			name:'newPassword',
			fieldLabel:'新密码',
			allowBlank: false,
			blankText: '新密码不能为空'
		}, {
			id: 'confirmPassword',
			xtype:'textfield',
			name:'confirmPassword',
			inputType:'password',
			fieldLabel:'确认密码',
			allowBlank: false,
			blankText: '确认密码不能为空'
		}],
		buttons: [{
			text: '确认',
			handler: function() {
				var form = passwordForm.getForm();
				if (form.isValid()) {
					if(Ext.getCmp("newPassword").getValue() != Ext.getCmp("confirmPassword").getValue()){
						Ext.Msg.alert("提示", "两次输入的密码不一致！");
						return ;
					}
					Ext.getCmp("oldPassword").setValue(CryptoJS.MD5(Ext.getCmp("oldPassword").getValue()));
					Ext.getCmp("newPassword").setValue(CryptoJS.MD5(Ext.getCmp("newPassword").getValue()));
					Ext.getCmp("confirmPassword").setValue(CryptoJS.MD5(Ext.getCmp("confirmPassword").getValue()));
					form.submit({
						url: 'UserAction!modifyPassword',
						waitMsg: '请稍后',
						success: function(fp,o) {
							passwordForm.form.reset();
							Ext.Msg.alert('提示信息','修改密码成功,请重新登录！', function(btn, text) {
								if(btn == "ok") {
									top.location.href = "../login.html";
								}
							});
						},
						failure: function(fp,o) {
							Ext.Msg.alert('提示信息','原密码错误！');
							passwordForm.form.reset();
						}
					});
				}
				
			}
		
		}, {
			text: '重置',
			handler: function() {
				passwordForm.form.reset();
			}
		}]
	});
	
});