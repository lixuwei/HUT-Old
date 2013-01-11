Ext.onReady(function() {
			var form = Ext.create('Ext.form.Panel', {
						title : '个人信息查询',
						bodyPadding : 5,
						frame : true,
						width : 800,
						layout : {
							type : 'table',
							columns : 2
						},
						defaults : {
							frame : true,
							width : 300,
							height : 20,
							margin : '5 100 0 0'
						},
						defaultType : 'displayfield',
						items : [{
									id : 'xh',
									name : 'xh',
									fieldLabel : '学号'
								}, {
									xtype : 'component',
									id : 'zplj',
									width : 130,
									height : 130,
									name : 'zplj',
//									fieldLabel : '照片路径',
									autoEl : {
										tag : 'img',
										src : ''
									},
									rowspan : 6
								}, {
									id : 'xm',
									name : 'xm',
									fieldLabel : '姓名'
								}, {
									id : 'xmpy',
									name : 'xmpy',
									fieldLabel : '姓名拼音'
								}, {
									id : 'cym',
									name : 'cym',
									fieldLabel : '曾用名'
								}, {
									id : 'zjlx',
									name : 'zjlx',
									fieldLabel : '证件类型'
								}, {
									id : 'xb',
									name : 'xb',
									fieldLabel : '性别'
								}, {
									id : 'zjhm',
									name : 'zjhm',
									fieldLabel : '证件号码'
								}, {
									id : 'mz',
									name : 'mz',
									fieldLabel : '民族'
								}, {
									id : 'jg',
									name : 'jg',
									fieldLabel : '籍贯'
								}, {
									id : 'csrq',
									name : 'csrq',
									fieldLabel : '出生日期'
								}, {
									id : 'hf',
									name : 'hf',
									fieldLabel : '婚否'
								}, {
									id : 'zzmm',
									name : 'zzmm',
									fieldLabel : '政治面貌'
								}, {
									id : 'xxfs',
									name : 'xxfs',
									fieldLabel : '学习方式'
								}, {
									id : 'xslb',
									name : 'xslb',
									fieldLabel : '学生类别'
								}, {
									id : 'xy',
									name : 'xy',
									fieldLabel : '学院'
								}, {
									id : 'x',
									name : 'x',
									fieldLabel : '系'
								}, {
									id : 'pycc',
									name : 'pycc',
									fieldLabel : '培养层次'
								}, {
									id : 'xkml',
									name : 'xkml',
									fieldLabel : '学科门类'
								}, {
									id : 'yjxk',
									name : 'yjxk',
									fieldLabel : '一级学科'
								}, {
									id : 'ejxk',
									name : 'ejxk',
									fieldLabel : '二级学科'
								}, {
									id : 'ds1',
									name : 'ds1',
									fieldLabel : '第一导师'
								}, {
									id : 'ds2',
									name : 'ds2',
									fieldLabel : '第二导师'
								}, {
									id : 'hdxlfs',
									name : 'hdxlfs',
									fieldLabel : '获得学历方式代'
								}, {
									id : 'xfzqk',
									name : 'xfzqk',
									fieldLabel : '学分制情况'
								}, {
									id : 'xz1',
									name : 'xz1',
									fieldLabel : '学制1'
								}, {
									id : 'xz2',
									name : 'xz2',
									fieldLabel : '学制2'
								}, {
									id : 'rxny',
									name : 'rxny',
									fieldLabel : '入学年月'
								}, {
									id : 'nj',
									name : 'nj',
									fieldLabel : '年级'
								}, {
									id : 'rxxq',
									name : 'rxxq',
									fieldLabel : '入学学期'
								}, {
									id : 'yjxksq',
									name : 'yjxksq',
									fieldLabel : '是否一级学科授权'
								}, {
									id : 'bjdm',
									name : 'bjdm',
									fieldLabel : '班号'
								}, {
									id : 'xjzt',
									name : 'xjzt',
									fieldLabel : '学籍状态'
								}, {
									id : 'xjydqk',
									name : 'xjyd',
									fieldLabel : '学籍异动情况'
								}, {
									id : 'ksdm',
									name : 'ksdm',
									fieldLabel : '考生编号'
								}, {
									id : 'zcqk',
									name : 'zcqk',
									fieldLabel : '注册情况'
								}, {
									id : 'zcrq',
									name : 'zcrq',
									fieldLabel : '注册日期'
								}, {
									id : 'yhkh',
									name : 'yhkh',
									fieldLabel : '银行卡号'
								}, {
									id : 'jhsh',
									name : 'jhsh',
									fieldLabel : '培养计划审核'
								}, {
									id : 'jsxysm',
									name : 'jsxysm',
									fieldLabel : '结束学业说明',
									colspan : 2
								}, {
									id : 'stzk',
									name : 'stzk',
									fieldLabel : '身体状况',
									colspan : 2
								}, {
									id : 'bz',
									name : 'bz',
									fieldLabel : '备注',
									colspan : 2
								}],
						renderTo : 'show'
					});

			form.getForm().load({
						//waitMsg : '正在加载数据',
						//waitTitle : '提示',
						url : 'XsAction!findXsgrxxByXh',
						success : function(form, action) {
//							Ext.Msg.alert('提示', '加载成功');
						},
						failure: function(form, action) {
					        Ext.Msg.alert('提示', '加载失败');
					    }
					});

		});
