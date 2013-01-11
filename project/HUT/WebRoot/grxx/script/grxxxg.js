Ext.onReady(function() {
    var form = Ext.create('Ext.form.Panel', {
        title: 'Simple Form',
        bodyPadding: 5,
        frame: true,
        width: 800,
        //draggable：true,
        // Fields will be arranged vertically, stretched to full width
        layout: 'anchor',
        defaults: {
            anchor: '100%'
        },

        // The fields
        defaultType: 'textfield',
        items: [{
            xtype: 'container',
            id:'leftcontainer',
            anchor: '100%',
            layout: 'hbox',
            items:[
               {
                xtype: 'container',
                flex: 1,
                layout: 'anchor',
                defaults:{
                	xtype:'textfield',
                	anchor:'95%'
                	},
                items: [
                    ///********************左侧栏
                    {
		                fieldLabel: '学号',
		                id:'xuehao',
		                allowBlank: false,
		                name: 'xh',
		                value: 'Don'
                	},{
                        //xtype:'textfield',
                        fieldLabel: '姓名',
                        id:'xingming',
                        allowBlank: false,
                        name: 'xm',
                        value: 'Griffin'
                    }, {
                    //xtype:'textfield',
	                    fieldLabel: '姓名拼音',
	                    id:'xingmingpinyin',
	                    name: 'xmpy',
	                    value:''
                	},{
                        //xtype:'textfield',
                        fieldLabel: '曾用名',
                        id:'cengyongming',
                        allowBlank: false,
                        name: 'cym',
                        //vtype:'email',
                        value:''
                    },{
                        //xtype:'textfield',
                        fieldLabel: '照片路径',
                        id:'zhaopianlujing',
                        allowBlank: false,
                        name: 'zplj',
                        //vtype:'email',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '证件类型',
                        id:'zhengjianleixing',
                        name: 'zjlx',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '证件号码',
                        id:'zhengjianhaoma',
                        name: 'zjhm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '联系电话',
                        id:'lianxidianhua',
                        name: 'lxdh',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '籍贯',
                        id:'jiguan',
                        name: 'jg',
                        value:''
                    }, {
                        xtype:'combobox',//*********************需要create一个
                        fieldLabel: '婚否',
                        id:'hunfou',
                        name: 'hfm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学习方式',
                        id:'xuexifangshi',
                        name: 'xxfs',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学院代码',
                        id:'xueyuandaima',
                        name: 'xydm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '培养层次',
                        id:'peiyangcengci',
                        name: 'pyccdm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '一级学科',
                        id:'yijixueke',
                        name: 'yijixueke',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '获得学历方式',
                        id:'huodeixuelifangshi',
                        name: 'hdxlfsdm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学制1',
                        id:'xuezhi1',
                        name: 'xz1',
                        value:''
                    }, {
                        xtype:'datefield',
                        format : 'Y/m/d',//日期格式化字符串  
                        fieldLabel: '入学年月',
                        id:'ruxuenianyue',
                        name: 'rxny',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '入学学期',
                        id:'ruxuexueqi',
                        name: 'rxxq',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '班号(学籍)',
                        id:'banhao',
                        name: 'bjdm',
                        value:''
                    }, {
                       // xtype:'textfield',
                        fieldLabel: '学籍异动情况',
                        id:'xuejiyidongqingkuang',
                        name: 'xjyd',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '注册情况',
                        id:'zhuceqingkuang',
                        name: 'zcqk',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '银行卡号',
                        id:'yinhangkahao',
                        name: 'yhkh',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '培养计划审核',
                        id:'zhuceqingkuang',
                        name: 'jhsh',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '结束学业情况说明',
                        id:'jieshuxueyeqingkuangshuoming',
                        name: 'jsxysm',
                        value:''
                    }]
            },
            
            //**************************右侧栏
            {
                xtype: 'container',
                id:'rightcontainer',
                flex: 1,
                layout: 'anchor',
                defaults:{
                	xtype:'textfield',
                	anchor:'95%'
                	},
                items: [
				{  
                      
                    xtype : 'box',  
                    id : 'Image',  
                    fieldLabel : "预览图片",  
                    autoEl : {  
                        width : 50,  
                        height : 130,  
                        tag : 'img',  
                        // type : 'image',  
                        src : '../demoImage/g.jpg',  
                        complete : 'off',  
                        id : 'imageBrowse'  
                    }  
  
                },
				{
                        //xtype:'textfield',
                        fieldLabel: '性别码',
                        id:'xingbie',
                        name: 'zjlx',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '民族',
                        id:'minzu',
                        name: 'mzm',
                        value:''
                    }, {
                        xtype:'datefield',
                        format : 'Y/m/d',//日期格式化字符串
                        fieldLabel: '出生日期',
                        id:'chishengriqi',
                        name: 'csrq',
                        value:''
                    }, {
                        //xtype:'datefield',
                        fieldLabel: '身体状况',
                        id:'shentizhuangkuang',
                        name: 'stzk',
                        value:''
                    }, {
                        xtype:'combobox',//*********************需要create一个
                        fieldLabel: '政治面貌',
                        id:'zhengzhimianmao',
                        name: 'zzmmm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学生类别',
                        id:'xueshengleibie',
                        name: 'xslb',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '系代码',
                        id:'xidaima',
                        name: 'xdm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学科门类',
                        id:'xuekemenlei',
                        name: 'xuekemenlei',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '二级学科',
                        id:'erjixueke',
                        name: 'ejxkdm',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学分制情况',
                        id:'xuefenzhiqingkuang',
                        name: 'xfzqk',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学制2',
                        id:'xuezhi2',
                        name: 'xz2',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '年级',
                        id:'nianji',
                        name: 'nj',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '是否一级学科授权',
                        id:'shifouyijixuekeshouquan',
                        name: 'yjxksq',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '学生学籍状态',
                        id:'xueshengxuejizhuangtai',
                        name: 'xjzt',
                        value:''
                    }, {
                        //xtype:'textfield',
                        fieldLabel: '考生编号',
                        id:'kaoshibianhao',
                        name: 'ksdm',
                        value:''
                    }, {
                    	xtype:'datefield',
                    	format : 'Y/m/d',//日期格式化字符串
                        fieldLabel: '注册日期',
                        id:'zhuceriqi',
                        name: 'zcrq',
                        value:''
                    }]
            	}
            
            ]
        }, {
            //xtype: 'htmleditor',
            name: 'bz',
            fieldLabel: '备注',
            id:'beizhu',
            height: 100,
            anchor: '100%'
        }],
        
        buttons: [{
            text: 'Save',
            handler: function() {
                this.up('form').getForm().isValid();
            }
        },{
            text: 'Reset',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }],
        
        renderTo: 'show'
    });

});
