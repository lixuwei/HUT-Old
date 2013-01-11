var $Choose = 1;
Ext.Loader.setConfig({
    enabled: true
});
Ext.Loader.setPath('Ext.ux', 'script');

Ext.require([
    'Ext.ux.CheckColumn'
]);
Ext.onReady(function(){
	var fm = Ext.form;
    var ajaxProxy = new Ext.data.proxy.Ajax({
    		model: 'Class',
    		url:'LessonAction!showLessonByYearAndXueqi?xueqi='+$Choose,
	        reader:{
	        	type:'json',
	        	root:'list'
	        }
    });
    Ext.define('Class', {
	    extend: 'Ext.data.Model',
	    fields: ['kcdm', 'kcmc', 'kclb','xf','xs','kkxq','kkdw','flag','khfs','syzyjfx','state','xueqi','year','bz','zhoukeshi','SingleOrDouble','single','double']
    });

   
    var store = Ext.create('Ext.data.Store', {
    	model: 'Class',
	    proxy:ajaxProxy,
	    autoLoad:true
    });
    var cellEditing = Ext.create('Ext.grid.plugin.CellEditing', {
        clicksToEdit: 1
    });
	var grid = Ext.create('Ext.grid.Panel', {
	    title: '本学期所有公共课',
	    store: store,
	    id:'ListGrid',
	    selModel: {
            selType: 'cellmodel'
        },
	    sortableColumns:false,
	    plugins:[cellEditing],
	    enableColumnHide:false,
	    enableColumnResize:false,
	    columns: [
	        { text: '课程',  dataIndex: 'kcmc',width:200},
	        { text: '总课时', dataIndex: 'xs'},
	        { text: '开课学期', dataIndex: 'xueqi' },
	        { text:'每周课时数',dataIndex:'zhoukeshi',editor:{xtype:"numberfield",minValue:0}},
	        { text:'单周课时数',dataIndex:'single',editor:{xtype:"numberfield",minValue:0}},
	        { text:'双周课时数',dataIndex:'double',editor:{xtype:"numberfield",minValue:0}},
	        { 
		        xtype: 'checkcolumn',
	            header: '是否有单双周',
	            dataIndex: 'SingleOrDouble',
	            width: 100,
	            editor: {
	                xtype: 'checkbox',
	                cls: 'x-grid-checkheader-editor'
	            }
	        }
	    ],
	    height: 200,
	    style:'width:100%;margin:5px',
	    renderTo: 'Grids'
	});
	var win;
	var winform;	
	///创建选择班级的界面
	function doEdit(){
		
		var ListGrid = Ext.getCmp('ListGrid');
	    var selects = ListGrid .getSelectionModel().getSelection();
	    if (typeof (selects) == 'undefined'||(selects.length)==0) {
	        Ext.MessageBox.alert("提示", "请选择一条信息");
	        return;
	    } else if (selects != null && selects.length >= 2) {
	        Ext.MessageBox.alert("提示", "只能选择一条信息进行编辑");
	        return;
	    }  
		var record = selects[0];
		Ext.define('edit', {
		    extend: 'Ext.data.Model',
		    fields: ['classId','className']
        });
		var EditProxy = new Ext.data.proxy.Ajax({
    		model: 'edit',
    		url:'ClassAction!getClasses?flag=1',
	        reader:{
	        	type:'json'
	        }
    	});
    	var EditStore = Ext.create('Ext.data.Store', {
	    	model: 'edit',
		    proxy:EditProxy,
		    autoLoad:true
		});
		Ext.define('classRoom', {
		    extend: 'Ext.data.Model',
		    fields: ['id','jsmc','jswz','lx','rnskrs','rnksrs','ssbm','flag','bz']
        });
		var ClassRoomStore = Ext.create('Ext.data.Store',{
			model:'classRoom',
			proxy:{
				type: 'ajax',
				url:'JsxxAction!getAllJsxxs',
		        reader:{
		        	type:'json'
		        }
			}
		});	
		Ext.define('teacher', {
		    extend: 'Ext.data.Model',
		    fields: ['lsbh','xm']
        });
        var TeacherStore = Ext.create('Ext.data.Store',{
			model:'teacher',
			proxy:{
				type: 'ajax',
				url:'TeacherAction!getAllTeachers',
		        reader:{
		        	type:'json'
		        }
			}
		});	
		Ext.Ajax.request({
			url:'LessonAction!getLessonByLessonName',
			params:{
//			 kcmc:encodeURI(record.data.kcmc)
			kcmc:record.data.kcmc
			},
			success: function(response){
		        var text = JSON.parse(response.responseText);
		        if(text.state=='false'){
		            alert("课程已经锁定！");
		            return;
		        }else{
					winform = Ext.create('Ext.form.Panel', {
			        border: false,
			        fieldDefaults: {
			            labelWidth: 55
			        },
			        defaultType: 'textfield',
			        bodyPadding: 5
				    });
				    for(var i = 0;i<record.data.zhoukeshi/2;i++){
					    winform.add({
					        xtype: 'container',
                            height: 43,
                            layout: {
                                align: 'middle',
                                type: 'hbox'
                            },
                            items: [
                                {
                                    xtype: 'combobox',
							        id:'className'+i,
							        fieldLabel:(i+1)+":",
							        store:EditStore,
							        name:'className'+i,
							        displayField: 'className',
					                valueField: 'classId',
							        name:'value',
							        editable:false,
							        labelWidth: 20,
							        width:190,
							        value:'请选择班级.......'
                                },
                                {
                                    xtype: 'combobox',
                                    flex: 1,
                                    id:'classRoom'+i,
                                    name:'classRoom'+i,
                                    store:ClassRoomStore,
                                    editable:false,
                                    fieldLabel: '选择教室',
                                    displayField: 'jsmc',
					                valueField: 'id',
                                    margins: '5px',                         
                                    labelWidth: 60
                                },
                                {
                                    xtype: 'combobox',
                                    flex: 1,
                                    store:TeacherStore,
                                    fieldLabel: '选择老师',
                                    margins: '5px',
                                    id:'teacher'+i,
                                    name:'teacher'+i,
                                    editable:false,
                                    displayField: 'xm',
					                valueField: 'lsbh',
                                    labelWidth: 60
                                }
                            ]
                      });
				    }
					win = Ext.create('Ext.window.Window',{
							height: 344,
						    width: 600,
						    title: '选择班级(请谨慎选择，提交后将锁定！)',
						    closable : true,
						    items: winform,
						    layout: 'fit',
						    buttons: [{
					            text: '提交',
					            handler: function() {
					            	var info = [];
					            	for(var i = 0;i<record.data.zhoukeshi/2;i++){
					            		var tt = {
					            			i:Ext.getCmp('className'+i).getValue(),
					            			c:Ext.getCmp('classRoom'+i).getValue(),
					            			t:Ext.getCmp('teacher'+i).getValue()
					            		};
					            		info.push(tt);
					            	}
					            	var yy = {
					            	    'all':info
					            	};
							        Ext.Ajax.request({
							        	url:'MidAction!addMid',
							        	method:'post',
							        	params:{
										 kcmc:record.data.kcmc,
										 'information':JSON.stringify(yy)
										}
							        });
							        win.close();
							    }
					        },{
					            text: '离开',
					            handler:function(){
					            	win.close();
					            }
					        }]
					}).show();
		        }
		    }
		});
		
		
	}
	grid.addListener('itemdblclick', doEdit, this);
	Ext.define('Table', {
	    extend: 'Ext.data.Model',
	    fields: ['monday', 'tuesday', 'wednesday','thursday','friday']
    });
	 var ajaxTable = new Ext.data.proxy.Ajax({
    		model: 'Table',
	        reader:{
	        	type:'json',
	        	root:'MyTable'
	        }
    });
    var storeTable = Ext.create('Ext.data.Store', {
    	model: 'Table',
	    proxy:ajaxTable
    });
    var gridTable = Ext.create('Ext.grid.Panel', {
	    title: '课表',
	    store: storeTable,
	    sortableColumns:false,
	    enableColumnHide:false,
	    columns: [
	        { text: '星期一',  dataIndex: 'monday',width:250},
	        { text: '星期二', dataIndex: 'tuesday',width:250},
	        { text: '星期三', dataIndex: 'wednesday',width:250 },
	        { text:'星期四',dataIndex:'thursday',width:250},
	        { text:'星期五',dataIndex:'friday',width:250 }
	       
	    ],
	    height: 400,
	    style:'width:100%;margin:5px'
	});
	
	Ext.create('Ext.Button', {
	    text: '排课',
	    width:100,
	    renderTo: 'Button',
	    handler: function() {
	    	Ext.Ajax.request({
			    url: 'ClassAction!BuildClassTable',
			    success: function(response){
			        var text = response.responseText;
			        var dataArray = $.parseJSON(text);
			        $(".add").remove();
			        for(var i = 0;i<dataArray.length;i++){
			        	if(dataArray[i].one!=""){
			        		$(".1").append("<td class='add'>"+dataArray[i].one+"</td>");
			        	}else{
			        		$(".1").append("<td class='add'>                   </td>");
			        	}
			        	if(dataArray[i].two!=""){
			        		$(".2").append("<td class='add'>"+dataArray[i].two+"</td>");
			        	}else{
			        		$(".2").append("<td class='add'>                   </td>");
			        	}
			        	if(dataArray[i].three!=""){
			        		$(".3").append("<td class='add'>"+dataArray[i].three+"</td>");
			        	}else{
			        		$(".3").append("<td class='add'>                   </td>");
			        	}
			        	if(dataArray[i].four!=""){
			        		$(".4").append("<td class='add'>"+dataArray[i].four+"</td>");
			        	}else{
			        		$(".4").append("<td class='add'>                   </td>");
			        	}
			        }
			    }
			});
	    }
    });
    
    Ext.define('ClassPanel', {
	    extend: 'Ext.data.Model',
	    fields: ['className', 'classNum']
    });
	 var ajaxClassPanel = new Ext.data.proxy.Ajax({
    		model: 'ClassPanel',
    		url:'ClassAction!getClasses',
	        reader:{
	        	type:'json'
	        }
    });
    var storeClassPanel = Ext.create('Ext.data.Store', {
    	model: 'ClassPanel',
    	autoLoad:true,
	    proxy:ajaxClassPanel
    });
    var tempData=new Array();
    var storeClassPanel2 = Ext.create('Ext.data.Store',{
    	fields: ['className', 'classNum'],
    	autoLoad:false,
    	data:tempData
    });
    Ext.create('Ext.Button',{
        text:'合班',
        width:100,
        renderTo:'RightButton',
        handler:function(){
        	if(winS!=null){
        		storeClassPanel.reload();
        	}
        	 var winS = Ext.create('Ext.window.Window',{
							height: 436,
						    width: 428,
						    resizable: false,
						    title: '合班选择',
						    closable : true,
						    layout: {
			                    type: 'border',
			                    padding: 5
			                },
			                items:[
                {
                    xtype: 'container',
                    region: 'center',
                    height: 436,
				    width: 428,
                    layout: {
                        type: 'border'
                    },
                    items: [
                        {
                            xtype: 'container',
                            margins: '5',
                            region: 'west',
                            style: 'background-color:#fff',
                            width: 150,
                            layout: {
                                align: 'stretch',
                                type: 'vbox'
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    flex: 1,
                                    id:'gridpanel',
                                    selModel: {
							            selType: 'rowmodel'
							        },
                                    width: 150,
                                    store:storeClassPanel,
                                    frameHeader: false,
                                    overlapHeader: false,
                                    preventHeader: true,
                                    hideHeaders: false,
                                    sortableColumns: false,
                                    enableColumnHide: false,
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'className',
                                            hideable: false,
                                            defaultWidth: 100,
                                            text: '班级'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'classNum',
                                            defaultWidth: 50,
                                            text: '班级数'
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            region: 'center',
                            layout: {
                                align: 'stretch',
                                type: 'vbox'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    margins: '10px',
                                    style:'margin-top:100px',
                                    text: 'add >>',
                                    handler:function(){
                                    	var gridPanel = Ext.getCmp('gridpanel');
									    var selects = gridPanel .getSelectionModel().getSelection();
									    if (typeof (selects) == 'undefined'||(selects.length)==0) {
									        Ext.MessageBox.alert("提示", "请选择一条信息");
									        return;
									    } else if (selects != null && selects.length >= 2) {
									        Ext.MessageBox.alert("提示", "只能选择一条信息进行添加");
									        return;
									    }
										var record = selects[0];
                                    	tempData.push({className:record.data.className,classNum:record.data.classNum});
                                    	storeClassPanel2.load(tempData);
                                    	storeClassPanel.removeAt(storeClassPanel.indexOf(record));
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margins: '10',
                                    text: '<< remove',
                                    handler:function(){
                                    	var gridPanel = Ext.getCmp('gridpanel2');
									    var selects = gridPanel .getSelectionModel().getSelection();
									    if (typeof (selects) == 'undefined'||(selects.length)==0) {
									        Ext.MessageBox.alert("提示", "请选择一条信息");
									        return;
									    } else if (selects != null && selects.length >= 2) {
									        Ext.MessageBox.alert("提示", "只能选择一条信息进行移除");
									        return;
									    }
										var record = selects[0];
										tempData.splice(storeClassPanel2.indexOf(record),1);
                                    	storeClassPanel.add({className:record.data.className,classNum:record.data.classNum});
                                    	storeClassPanel2.removeAt(storeClassPanel2.indexOf(record));
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            region: 'east',
                            margins: '5',
                            style: 'background-color:#fff',
                            layout: {
                                align: 'stretch',
                                type: 'vbox'
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    flex: 1,
                                    id:'gridpanel2',
                                    store:storeClassPanel2,
                                    selModel: {
							            selType: 'rowmodel'
							        },
                                    frameHeader: false,
                                    overlapHeader: false,
                                    preventHeader: true,
                                    hideHeaders: false,
                                    sortableColumns: false,
                                    enableColumnHide: false,
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'className',
                                            hideable: false,
                                            text: '班级'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'classNum',
                                            text: '班级数'
                                        }
                                    ]
                                }
                            ],
                            width: 150
                        },
                        {
                           xtype: 'container',
                            region: 'south',
                            height: 40,
                            margins: '5',
                            style:'border-color: black',
                            border: 5,
                            layout: {
                                type: 'absolute'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    width:100,
                                    x: 110,
                                    y: 10,
                                    text: '合并',
                                    handler:function(){
                                    	var temp1=[]
                                    	var rowCount = Ext.getCmp('gridpanel2').store.getCount();
										for(var i = 0; i < rowCount; i++) {
										   var record = Ext.getCmp('gridpanel2').getStore().getAt(i);
										   //获取数据中的项
										   var t_className = record.data.className;
										   var t_classNum = record.data.classNum;
										   temp1.push({
//										     className:encodeURI(t_className),
										   	className:t_className,
										     classNum:t_classNum
										   });
										}
										var yyy = {
										  "info":temp1
										}
										Ext.Ajax.request({
								        	url:'ClassAction!MergeClass',
								        	method:'post',
								        	params:{
											 'information':JSON.stringify(yyy)
											}
										});
							            tempData.splice(0,tempData.length);
							            storeClassPanel2.reload();
							            storeClassPanel.reload();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    width:100,
                                    x: 290,
                                    y: 10,
                                    height: 20,
                                    text: '取消',
                                    handler:function(){
                                    	winS.close();
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
			}).show();
        }
    });
	Ext.create('Ext.form.field.ComboBox', {
		editable:false,
	    transform: 'Group',
        name:'Group',
        id:'Group',
	    width: 135,
	    forceSelection: true,
	    listeners:{
	    	select:function(){
	    		$Choose = Ext.getCmp('Group').value;
	    		ajaxProxy.url = 'LessonAction!showLessonByYearAndXueqi?xueqi='+$Choose;
		    	grid.store.reload();
	    	}
	    }
    });
    Ext.create('Ext.Button', {
    text: '显示班级分配',
    renderTo:'table',
    handler: function() {
    	Ext.Ajax.request({
    		url:'MidAction!getAllMid',
    		method:'post',
    		success: function(response){   			 
    			 var text = JSON.parse(response.responseText);
    			 var mid = text.mid;
    			 winform1 = Ext.create('Ext.form.Panel', {
			        border: false,
			        layout:'vbox',
			        fieldDefaults: {
			            labelWidth: 55
			        },
			        bodyPadding: 5
				    });
    			 for(var i = 0;i<mid.length;i++){
				    winform1.add({
				     	xtype: 'label',
                        text: mid[i].lessonName+" : "+mid[i].className
				    });
					
    			 }
    			 Ext.create('Ext.window.Window',{
							height: 344,
						    width: 494,
						    title: '排班信息',
						    closable : true,
						    items: winform1,
						    layout: 'fit'
				 }).show();
    		}
    	});
    }
    });
});