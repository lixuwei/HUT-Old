/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/1/29 13:11:18                           */
/*==============================================================*/


drop table if exists t_cbxszzqk;

drop table if exists t_class;

drop table if exists t_dqjg;

drop table if exists t_dqjgz;

drop table if exists t_dsxx;

drop table if exists t_dsxy;

drop table if exists t_ejxk;

drop table if exists t_function;

drop table if exists t_function_action;

drop table if exists t_hdxlfs;

drop table if exists t_hjqk;

drop table if exists t_jsxx;

drop table if exists t_jxqkb;

drop table if exists t_kccj;

drop table if exists t_ksfs;

drop table if exists t_ksly;

drop table if exists t_kyxm;

drop table if exists t_lesson;

drop table if exists t_lslb;

drop table if exists t_lslxxx;

drop table if exists t_lw;

drop table if exists t_mid;

drop table if exists t_module;

drop table if exists t_mz;

drop table if exists t_pkxx;

drop table if exists t_pycc;

drop table if exists t_pyhj;

drop table if exists t_role;

drop table if exists t_role_function;

drop table if exists t_role_module;

drop table if exists t_shjg;

drop table if exists t_teacher;

drop table if exists t_tjxx;

drop table if exists t_tzs;

drop table if exists t_user;

drop table if exists t_user_role;

drop table if exists t_x;

drop table if exists t_xjzt;

drop table if exists t_xl;

drop table if exists t_xs;

drop table if exists t_xsds;

drop table if exists t_xsjl;

drop table if exists t_xsjt;

drop table if exists t_xslb;

drop table if exists t_xslqb;

drop table if exists t_xslxxx;

drop table if exists t_xsqt;

drop table if exists t_xssjzcsh;

drop table if exists t_xsxjzc;

drop table if exists t_xsxl;

drop table if exists t_xw;

drop table if exists t_xx;

drop table if exists t_xxlwcg;

drop table if exists t_xxxs;

drop table if exists t_xy;

drop table if exists t_xyzy;

drop table if exists t_xzjg;

drop table if exists t_xzjgz;

drop table if exists t_xzqhsx;

drop table if exists t_yjdw;

drop table if exists t_yzbm;

drop table if exists t_yzbzzy;

drop table if exists t_zc;

drop table if exists t_zdgzjl;

drop table if exists t_zjlb;

drop table if exists t_zjlx;

drop table if exists t_zlqk;

drop table if exists t_zscj;

drop table if exists t_zzmm;

drop table if exists zjlx;

/*==============================================================*/
/* Table: t_cbxszzqk                                            */
/*==============================================================*/
create table t_cbxszzqk
(
   xh                   varchar(10) not null comment '序号',
   lsbh                 varchar(20) not null comment '老师编号',
   lb                   varchar(20) comment '类别',
   zzxm                 varchar(10) comment '作者姓名',
   smpx                 varchar(20) comment '署名排序',
   zzmc                 varchar(20) comment '专著(教材)名称',
   cbs                  varchar(20) comment '出版社',
   cbsj                 varchar(10) comment '出版时间',
   primary key (lsbh, xh)
);

alter table t_cbxszzqk comment '出版学术专著教材情况表';

/*==============================================================*/
/* Table: t_class                                               */
/*==============================================================*/
create table t_class
(
   classId              int not null auto_increment comment '班级id',
   className            varchar(100) comment '班级名',
   classNum             int comment '班级人数',
   xueqi                int comment '学期',
   year                 int comment '班级年份',
   primary key (classId)
);

alter table t_class comment '班级表';

/*==============================================================*/
/* Table: t_dqjg                                                */
/*==============================================================*/
create table t_dqjg
(
   dm                   varchar(5) not null comment '党群机构代码',
   mc                   varchar(50) comment '党群机构名称',
   primary key (dm)
);

alter table t_dqjg comment '党群机构表';

/*==============================================================*/
/* Table: t_dqjgz                                               */
/*==============================================================*/
create table t_dqjgz
(
   dm                   varchar(10) not null comment '党群机构子代码',
   pdm                  varchar(5) comment '党群机构父代码',
   mc                   varchar(50) comment '党群机构子名称',
   primary key (dm)
);

alter table t_dqjgz comment '党群机构子表';

/*==============================================================*/
/* Table: t_dsxx                                                */
/*==============================================================*/
create table t_dsxx
(
   lsbh                 varchar(20) not null comment '老师编号',
   zyxkyjxkm            varchar(10) comment '主研学科一级学科码',
   zyxkejxkm            varchar(10) comment '主研学科二级学科码',
   zyxkzdbs             int comment '主研学科在读博士人数',
   zybszps              int comment '主研学科博士招聘数',
   zyxkzdss             int comment '主研学科在读硕士人数',
   zysszps              int comment '主研学科硕士招聘数',
   dexkyjxkm            varchar(10) comment '第二学科一级学科码',
   dexkejxkm            varchar(10) comment '第二学科二级学科码',
   dexkzdbs             int comment '第二学科在读博士人数',
   debszps              int comment '第二学科博士招聘数',
   dexkzdss             int comment '第二学科在读硕士人数',
   desszps              int comment '第二学科硕士招聘数',
   yjfx                 varchar(100) comment '研究方向',
   zgxl                 int comment '最高学历 1.本科 2.研究生 3.其他',
   zgxlsj               varchar(10) comment '获得最高学历时间',
   zgxw                 varchar(5) comment '最高学位 1.博士 2.硕士 3.学士 4.无',
   zgxwsj               varchar(10) comment '获得最高学位时间',
   zyjszw               varchar(5) comment '专业技术职务 1.正高职       2.副高职        3.中级   ',
   dslb                 int comment '导师类别 1.博士生导师   2. 硕士生导师   9. 其他',
   scrsdsj              varchar(10) comment '首次任硕导时间',
   scrbdsj              varchar(10) comment '首次任博导时间',
   zjlbdm               varchar(5) comment '专家类别(选其中最高的一个)',
   zydm                 varchar(10) comment '专业代码',
   wymc                 varchar(20) comment '外国语名称',
   wyslcd               int comment '外语熟练程度 1.精通      2.熟练      3.良好      4.一般',
   jzbsds               int comment '是否在外单位担任兼职博士指导教师 1是 0否',
   jzdwmc               varchar(50) comment '兼职单位名称',
   bgdh                 varchar(20) comment '办公电话',
   csny                 varchar(20) comment '出生年月',
   czdh                 varchar(20) comment '传真电话',
   dwdm                 varchar(10) comment '单位代码',
   xm                   varchar(20) comment '姓名',
   xb                   int comment '性别',
   sfzhm                varchar(20) comment '身份证号码',
   zzmm                 varchar(20) comment '政治面貌',
   szbm                 varchar(20) comment '所在部门',
   xzzw                 varchar(20) comment '行政职务',
   txdz                 varchar(50) comment '通讯地址',
   yzbm                 varchar(20) comment '邮政编码',
   zzdh                 varchar(20) comment '住宅电话',
   yddh                 varchar(20) comment '移动电话',
   dzxx                 varchar(20) comment '电子信箱',
   mz                   varchar(5) comment '民族',
   xnxw                 int comment '在编或外聘',
   primary key (lsbh)
);

alter table t_dsxx comment '导师信息表';

/*==============================================================*/
/* Table: t_dsxy                                                */
/*==============================================================*/
create table t_dsxy
(
   xydm                 varchar(5) not null comment '学院代码',
   lsbh                 varchar(20) not null comment '老师编号',
   dlag                 int comment '标志: 1为主要 次要为0',
   primary key (xydm, lsbh)
);

alter table t_dsxy comment '导师学院关系表';

/*==============================================================*/
/* Table: t_ejxk                                                */
/*==============================================================*/
create table t_ejxk
(
   ejxkdm               varchar(10) not null comment '二级学科代码',
   ejxkmc               varchar(20) comment '二级学科名称',
   yjxkdm               varchar(5) comment '一级学科代码',
   yjxkmc               varchar(20) comment '一级学科名称',
   mldm                 varchar(5) comment '门类代码',
   mlmc                 varchar(10) comment '门类名称',
   xwlx                 varchar(2) comment '学位类型(zx专业型学位  xs学士型学位)',
   primary key (ejxkdm)
);

alter table t_ejxk comment '二级学科(专业)表';

/*==============================================================*/
/* Table: t_function                                            */
/*==============================================================*/
create table t_function
(
   functionId           int not null auto_increment comment '功能id',
   moduleId             int comment '模块id',
   functionName         varchar(45) comment '功能名称',
   url                  varchar(50) comment '链接地址',
   primary key (functionId)
);

alter table t_function comment '功能表';

/*==============================================================*/
/* Table: t_function_action                                     */
/*==============================================================*/
create table t_function_action
(
   action               varchar(50) not null comment '包含的action方法',
   functionId           int not null comment '功能id',
   primary key (functionId, action)
);

alter table t_function_action comment '功能包含的action表';

/*==============================================================*/
/* Table: t_hdxlfs                                              */
/*==============================================================*/
create table t_hdxlfs
(
   dm                   varchar(10) not null comment '获得学历方式代码',
   mc                   varchar(10) comment '获得学历方式名称',
   primary key (dm)
);

alter table t_hdxlfs comment '获得学历方式表';

/*==============================================================*/
/* Table: t_hjqk                                                */
/*==============================================================*/
create table t_hjqk
(
   xh                   int not null comment '序号',
   lsbh                 varchar(20) not null comment '老师编号',
   cgmc                 varchar(20) comment '成果名称',
   jllb                 varchar(20) comment '奖励类别',
   jldj                 int comment '奖励等级',
   hjsj                 varchar(10) comment '获奖时间',
   smmx                 varchar(20) comment '署名排序',
   primary key (lsbh, xh)
);

alter table t_hjqk comment '老师获奖情况表';

/*==============================================================*/
/* Table: t_jsxx                                                */
/*==============================================================*/
create table t_jsxx
(
   id                   int not null auto_increment comment '教室id',
   jsmc                 varchar(20) comment '教室名称',
   jswz                 varchar(20) comment '教室位置 (**校区**楼)',
   lx                   int comment '类型 1为多媒体类型 2普通教室',
   rnskrs               int comment '可容纳上课人数',
   rnksrs               int comment '可容纳考试人数',
   ssbm                 varchar(20) comment '所属部门',
   flag                 int comment '1表示所属部门为行政机构代码 2表示为学院代码',
   bz                   varchar(200) comment '备注',
   primary key (id)
);

alter table t_jsxx comment '教室信息表';

/*==============================================================*/
/* Table: t_jxqkb                                               */
/*==============================================================*/
create table t_jxqkb
(
   xh                   int not null comment '序号',
   lsbh                 varchar(20) not null comment '老师编号',
   kcmc                 varchar(20) comment '课程名称',
   xydm                 int comment '学院代码',
   xdm                  int comment '系代码',
   bjdm                 int comment '班级号',
   xs                   int comment '学时',
   bz                   text comment '备注',
   primary key (xh, lsbh)
);

alter table t_jxqkb comment '教学情况表(不是老师个人教学课表,是记录的老师以前教学的经历)';

/*==============================================================*/
/* Table: t_kccj                                                */
/*==============================================================*/
create table t_kccj
(
   id                   int not null auto_increment comment 'Id ',
   xh                   varchar(20) not null comment '学号',
   kcdm                 int not null comment '课程代码',
   lsbh                 varchar(20) not null comment '老师表的老师编号',
   jsxxId               int comment '教室信息Id',
   zxcj                 double comment '最新成绩(当存在补考或者重修情况的时候,最新考试的分数存这,以前的分数存到zqcj中去)',
   zqcj                 double comment '之前成绩(当存在补考或者重修情况的时候,最新考试的分数zxcj,以前的分数存到这里)',
   pscj                 double comment '平时成绩',
   kscj                 double comment '考试成绩',
   xf                   double comment '获得的学分',
   year                 int comment '年份',
   xueqi                int comment '学期',
   primary key (id)
);

alter table t_kccj comment '学生课程成绩表(附加学生成绩)';

/*==============================================================*/
/* Table: t_ksfs                                                */
/*==============================================================*/
create table t_ksfs
(
   dm                   int not null comment '考试方式代码',
   mc                   varchar(10) comment '考试方式名称',
   primary key (dm)
);

alter table t_ksfs comment '考试方式表';

/*==============================================================*/
/* Table: t_ksly                                                */
/*==============================================================*/
create table t_ksly
(
   dm                   int not null comment '考生来源代码',
   mc                   varchar(10) comment '考生来源名称',
   primary key (dm)
);

alter table t_ksly comment '考生来源表';

/*==============================================================*/
/* Table: t_kyxm                                                */
/*==============================================================*/
create table t_kyxm
(
   xh                   int not null comment '项目序号',
   lsbh                 varchar(20) not null comment '老师编号',
   xmlx                 varchar(10) comment '项目类型',
   xmly                 varchar(20) comment '项目来源',
   xmbh                 int comment '项目(课题)编号',
   xmmc                 varchar(20) comment '项目(课题)名称',
   fzr                  varchar(10) comment '负责人',
   xmjf                 float comment '项目经费（万元）',
   ksny                 varchar(10) comment '开始年月',
   jsny                 varchar(10) comment '结束年月',
   brpm                 int comment '本人排名',
   primary key (xh, lsbh)
);

alter table t_kyxm comment '老师科研项目表';

/*==============================================================*/
/* Table: t_lesson                                              */
/*==============================================================*/
create table t_lesson
(
   kcdm                 int not null comment '课程代码',
   kcmc                 varchar(20) comment '课程名称',
   kclb                 int default 1 comment '1为学位课的公共课 2为学位课的专业课 3为选修课 4为必修环节 5为实践环节 6为补休课',
   xf                   double comment '学分',
   xs                   int comment '学时',
   xueqi                int comment '开课学期',
   kkdw                 varchar(50) comment '开课单位',
   flag                 int comment '开课单位是学院1 是行政机构2',
   khfs                 varchar(10) comment '考核方式 1为考试  2为考核',
   state                int comment '是否已经锁定 锁定为1',
   year                 int comment '年份',
   bz                   text comment '备注',
   primary key (kcdm)
);

alter table t_lesson comment '课程信息表';

/*==============================================================*/
/* Table: t_lslb                                                */
/*==============================================================*/
create table t_lslb
(
   dm                   int not null auto_increment comment '老师类别代码',
   mc                   varchar(10) comment '老师类别名称',
   bz                   varchar(1) comment '标志 (比如校内T 校外F )',
   primary key (dm)
);

alter table t_lslb comment '老师类别表';

/*==============================================================*/
/* Table: t_lslxxx                                              */
/*==============================================================*/
create table t_lslxxx
(
   lsbh                 varchar(20) not null comment '老师编号',
   jtzz                 varchar(50) comment '家庭住址',
   zzdh                 int(20) comment '住宅电话',
   sj                   int(20) comment '手机',
   email                varchar(20) comment '电子邮箱',
   qq                   varchar(20) comment 'QQ号',
   primary key (lsbh)
);

alter table t_lslxxx comment '老师联系信息表';

/*==============================================================*/
/* Table: t_lw                                                  */
/*==============================================================*/
create table t_lw
(
   id                   int not null auto_increment comment '论文id',
   lsbh                 varchar(20) not null comment '老师编号',
   zzxm                 varchar(10) comment '作者姓名',
   smpx                 varchar(20) comment '署名排序',
   lwmc                 varchar(20) comment '论文名称',
   xx                   varchar(30) comment '刊名及年.卷.期.页',
   lwjb                 int comment '论文级别',
   primary key (id)
);

alter table t_lw comment '老师发表论文表';

/*==============================================================*/
/* Table: t_mid                                                 */
/*==============================================================*/
create table t_mid
(
   id                   int not null auto_increment comment 'mid表id',
   className            varchar(50) comment '班级名称',
   lessonName           varchar(50) comment '课程名称',
   classRoom            varchar(50) comment '教室名称',
   teacherName          varchar(50) comment '教师姓名',
   primary key (id)
);

/*==============================================================*/
/* Table: t_module                                              */
/*==============================================================*/
create table t_module
(
   moduleId             int not null auto_increment comment '模块id',
   moduleName           varchar(45) comment '模块名',
   primary key (moduleId)
);

alter table t_module comment '模块表';

/*==============================================================*/
/* Table: t_mz                                                  */
/*==============================================================*/
create table t_mz
(
   dm                   varchar(5) not null comment '民族代号',
   mc                   varchar(10) comment '民族名称',
   primary key (dm)
);

alter table t_mz comment '民族表';

/*==============================================================*/
/* Table: t_pkxx                                                */
/*==============================================================*/
create table t_pkxx
(
   id                   int not null auto_increment comment '排课表Id',
   kcdm                 int comment '课程代码',
   lsbh                 varchar(20) comment '老师编号',
   jsdm                 int comment '教室代码',
   sksj                 varchar(100) comment '上课时间',
   primary key (id)
);

alter table t_pkxx comment '排课信息';

/*==============================================================*/
/* Table: t_pycc                                                */
/*==============================================================*/
create table t_pycc
(
   dm                   varchar(10) not null comment '培养层次代码',
   mc                   varchar(10) comment '培养层次名称',
   primary key (dm)
);

alter table t_pycc comment '培养层次表';

/*==============================================================*/
/* Table: t_pyhj                                                */
/*==============================================================*/
create table t_pyhj
(
   xh                   varchar(20) not null comment '学号',
   pymb                 text comment '培养目标',
   xzyxfyq              text comment '学制与学分要求',
   pyfs                 text comment '培养方式',
   yjfsnr               varchar(50) comment '研究方向内容',
   yjfsxs               varbinary(10) comment '研究方向形式',
   yjfskssj             varchar(10) comment '研究方向开始日期',
   yjfsjssj             varchar(10) comment '研究方向结束时间',
   yjsxzdls             varchar(20) comment '研究方向指导老师',
   yjtmnr               varchar(50) comment '研究题目内容',
   yjtmxs               varchar(10) comment '研究题目形式',
   yjtmkssj             varchar(10) comment '研究题目开始时间',
   yjtmjssj             varchar(10) comment '研究题目结束日期',
   yjtmzdls             varchar(20) comment '研究题目指导老师',
   yjyqnr               varchar(50) comment '研究要求内容',
   yjyqxs               varchar(10) comment '研究要求形式',
   yjyqkssj             varchar(10) comment '研究要求开始日期',
   yjyqjssj             varchar(10) comment '研究要求结束日期',
   yjyqzdls             varchar(20) comment '研究要求指导老师',
   lwjhnr               varchar(50) comment '论文计划内容
            ',
   lwjhxs               varchar(10) comment '论文计划形式',
   lwjhkssj             varchar(10) comment '论文计划开始时间',
   lwjhjssj             varchar(10) comment '论文计划结束日期',
   lwjhzdls             varchar(20) comment '论文计划指导老师',
   pyjhzt               int comment '培养计划审核状态 1为审核通过 0待审 -1未通过',
   wxzsbt               varchar(50) comment '文献综述标题',
   wxzsnr               text comment '文献综述内容',
   wxzssj               varchar(10) comment '文献综述撰写时间',
   wxzszt               int comment '文献综述审核状态 1为审核通过 0待审 -1未通过',
   xshdnr               varchar(50) comment '学术活动内容',
   xshdxs               varchar(10) comment '学术活动形式',
   xshdkssj             varchar(10) comment '学术活动开始时间',
   xshdjssj             varchar(10) comment '学术活动结束时间',
   xshdzdls             varchar(20) comment '学术活动指导老师',
   xshdzt               int comment '学术活动审核状态 1为审核通过 0待审 -1未通过',
   jxsjnr               varchar(50) comment '教学实践内容',
   jxsjxs               varchar(10) comment '教学实践形式',
   jxsjkssj             varchar(10) comment '教学实践开始时间',
   jxsjjssj             varchar(10) comment '教学实践结束日期',
   jxsjzdls             varchar(20) comment '教学实践指导老师',
   jssjzt               int comment '教学实践审核状态 1为审核通过 0待审 -1未通过',
   shsjnr               varchar(50) comment '社会实践内容',
   shsjxs               varchar(10) comment '社会实践形式',
   shsjkssj             varchar(10) comment '社会实践开始日期',
   shsjjssj             varchar(10) comment '社会实践结束时间',
   shsjzdls             varchar(20) comment '社会实践指导老师',
   shsjzt               int comment '社会实践审核状态 1为审核通过 0待审 -1未通过',
   ktbgbt               varchar(50) comment '开题报告标题',
   ktbgnr               text comment '开题报告内容',
   ktbgsj               varchar(10) comment '开题报告撰写时间',
   ktbgzt               int comment '开题报告审核状态 1为审核通过 0待审 -1未通过',
   zqkhgrxj             text comment '中期考核个人小结',
   lwyjjzqkbt           varchar(50) comment '论文研究进展情况标题',
   lwyjjzqknr           text comment '论文研究进展情况内容',
   jcqk                 text comment '在读期间奖惩情况',
   zqkhsj               varchar(10) comment '中期考核撰写时间',
   lwzqjc               int comment '论文中期检查 1通过 0待审 -1未通过',
   dsdf                 float comment '中期考核导师打分',
   zjdf                 float comment '中期考核专家打分',
   grdf                 float comment '中期考核个人打分',
   df                   float comment '中期考核最后得分',
   sm                   int comment '说明 1齐全 0不齐全',
   shjg                 int comment '审核结果 1通过 0待审 -1未通过',
   primary key (xh)
);

alter table t_pyhj comment '培养环节(培养计划 文献综述 学术活动 教学实践 社会实践 开题报告)表';

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   roleId               int not null auto_increment comment '角色id',
   roleName             varchar(45) comment '角色名称',
   primary key (roleId)
);

alter table t_role comment '角色表';

/*==============================================================*/
/* Table: t_role_function                                       */
/*==============================================================*/
create table t_role_function
(
   roleId               int not null comment '角色id',
   functionId           int not null comment '功能id',
   primary key (functionId, roleId)
);

alter table t_role_function comment '角色功能表';

/*==============================================================*/
/* Table: t_role_module                                         */
/*==============================================================*/
create table t_role_module
(
   roleId               int not null comment '角色id',
   moduleId             int not null comment '模块id',
   primary key (roleId, moduleId)
);

alter table t_role_module comment '角色模块表';

/*==============================================================*/
/* Table: t_shjg                                                */
/*==============================================================*/
create table t_shjg
(
   id                   varchar(4) not null comment 'Id',
   mc                   varchar(50) comment '社会机构名称',
   primary key (id)
);

alter table t_shjg comment '社会机构表';

/*==============================================================*/
/* Table: t_teacher                                             */
/*==============================================================*/
create table t_teacher
(
   lsbh                 varchar(20) not null comment '老师编号',
   xm                   varchar(10) comment '老师姓名',
   zgh                  varchar(20) comment '职工号',
   zplj                 varchar(50) comment '照片路径',
   xb                   int comment '性别 格式:1为男 0为女',
   mzdm                 varchar(5) comment '民族代码',
   csrq                 varchar(10) comment '出生日期 格式:19921116',
   zzmmdm               varchar(5) comment '政治面貌代码',
   xydm                 varchar(5) comment '学院代码 党群机构代码 行政机构代码 社会机构代码',
   flag                 int comment '1学院 2党群 3机构 4社会机构',
   xdm                  varchar(10) comment '系/所代码',
   lxdh                 varchar(20) comment '联系电话',
   email                varchar(20) comment '电子邮箱',
   byxxdm               varchar(10) comment '毕业学校代码',
   byzydm               varchar(10) comment '毕业专业',
   xldm                 varchar(10) comment '学历代码',
   xwdm                 varchar(10) comment '学位代码',
   zcdm                 varchar(10) comment '职称代码',
   zydm                 varchar(10) comment '专业代码',
   zw                   varchar(20) comment '职务',
   yjfx                 varchar(20) comment '研究方向',
   sfzh                 varchar(20) comment '身份证号',
   jszgzh               varchar(10) comment '教师资格证号',
   zjjszgzh             varchar(10) comment '主讲教师资格证号',
   jxzlpj               text comment '教学质量评价',
   jsjj                 text comment '教师简介',
   primary key (lsbh)
);

alter table t_teacher comment '老师基本信息表';

/*==============================================================*/
/* Table: t_tjxx                                                */
/*==============================================================*/
create table t_tjxx
(
   ksh                  varchar(20) not null comment '考生号',
   xm                   varchar(10) comment '姓名',
   xb                   int comment '性别',
   byxx                 varchar(20) comment '毕业学校',
   sxzy                 varchar(20) comment '所学专业',
   bysj                 varchar(10) comment '毕业时间',
   zhxl                 varchar(20) comment '最后学历',
   ybkxx                varchar(20) comment '原报考学校',
   ybkzy                varchar(20) comment '原报考专业',
   ybkzydm              int comment '原报考专业代码',
   sqtjzy               varchar(20) comment '申请调剂专业',
   sqtjzydm             int comment '申请调剂专业代码',
   zzllcj               float comment '政治理论成绩',
   wgycj                float comment '外国语成绩',
   ywk1cj               float comment '业务课一成绩',
   ywk2cj               float comment '业务课二成绩',
   zf                   float comment '总分',
   ybkdwdh              varchar(20) comment '原报考单位电话',
   ybkdwdz              varchar(50) comment '原报考单位地址',
   ybkdwcz              varchar(20) comment '原报考单位传真',
   sj                   varchar(20) comment '本人手机',
   dz                   varchar(50) comment '本人地址',
   email                varchar(20) comment '本人Email',
   primary key (ksh)
);

alter table t_tjxx comment '调剂信息表';

/*==============================================================*/
/* Table: t_tzs                                                 */
/*==============================================================*/
create table t_tzs
(
   ksh                  varchar(20) not null comment '考生号',
   xm                   varchar(10) comment '姓名',
   sfzh                 varchar(20) comment '身份证号',
   yjdz                 varchar(50) comment '邮寄地址',
   yjsj                 varchar(10) comment '邮寄时间',
   yjfs                 varchar(10) comment '邮寄方式',
   primary key (ksh)
);

alter table t_tzs comment '招生通知书表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   username             varchar(20) not null comment '学生学号 老师编号 管理员编号',
   password             varchar(50) comment '密码',
   email                varchar(20) comment '电子邮件',
   tel                  varchar(20) comment '电话',
   primary key (username)
);

alter table t_user comment '用户登录表';

/*==============================================================*/
/* Table: t_user_role                                           */
/*==============================================================*/
create table t_user_role
(
   username             varchar(20) not null comment '学生学号 老师编号 管理员编号',
   roleId               int not null comment '角色id',
   primary key (username, roleId)
);

alter table t_user_role comment '用户角色表';

/*==============================================================*/
/* Table: t_x                                                   */
/*==============================================================*/
create table t_x
(
   xdm                  varchar(10) not null comment '系代码',
   xmc                  varchar(20) comment '系名称',
   xydm                 varchar(5) comment '学院代码',
   primary key (xdm)
);

alter table t_x comment '系表';

/*==============================================================*/
/* Table: t_xjzt                                                */
/*==============================================================*/
create table t_xjzt
(
   dm                   int not null comment '学籍状态代码',
   mc                   varchar(10) comment '学籍状态名称',
   primary key (dm)
);

alter table t_xjzt comment '学籍状态表';

/*==============================================================*/
/* Table: t_xl                                                  */
/*==============================================================*/
create table t_xl
(
   dm                   varchar(10) not null comment '学历代码',
   cm                   varchar(20) comment '学历名称',
   primary key (dm)
);

alter table t_xl comment '学历表';

/*==============================================================*/
/* Table: t_xs                                                  */
/*==============================================================*/
create table t_xs
(
   xh                   varchar(20) not null comment '学生学号',
   xm                   varchar(10) comment '学生姓名',
   xmpy                 varchar(50) comment '姓名拼音',
   cym                  varchar(10) comment '曾用名',
   zplj                 varchar(50) comment '照片路径',
   zjlx                 varchar(20) comment '证件类型',
   xbm                  int comment '性别码 格式:1男 2女',
   zjhm                 varchar(20) comment '证件号码',
   mzm                  varchar(5) comment '民族码',
   jg                   varchar(50) comment '籍贯',
   csrq                 varchar(10) comment '出生日期 格式:19921116',
   hfm                  int comment '婚否 1为已婚 0为未婚',
   zzmmm                varchar(5) comment '政治面貌代码',
   xxfs                 int comment '学习方式 1是全日制 0是非全日制',
   xslb                 int comment '学生类别 0是进修生 1是硕士研究生 2博士研究生',
   xydm                 varchar(5) comment '学院代码',
   xdm                  varchar(10) comment '系代码',
   pyccdm               varchar(10) comment '培养层次代码',
   lqlbm                int comment '录取类别码 11-非定向，12-定向，23-委培，24-自筹',
   ejxkdm               varchar(10) comment '二级学科代码',
   hdxlfsdm             varchar(10) comment '获得学历方式代码',
   xfzqk                int comment '学分制情况 1是 0否',
   xz1                  int comment '学制1',
   xz2                  int comment '学制2',
   rxny                 varchar(10) comment '入学年月',
   nj                   int comment '年级',
   rxxq                 int comment '入学学期',
   yjxksq               int comment '一级学科授权 1是 0否',
   bjdm                 int comment '班级代码',
   xjztdm               int comment '学籍状态代码',
   xjydqk               text comment '学籍异动情况',
   ksdm                 varchar(20) comment '考生编号',
   zcqk                 text comment '注册情况',
   zcrq                 varchar(10) comment '注册日期',
   yhkh                 varchar(20) comment '银行卡号',
   jhsh                 varchar(10) comment '培养计划审核',
   jsxysm               varchar(20) comment '结束学业说明',
   stzk                 text comment '身体状况',
   bz                   text comment '备注',
   primary key (xh)
);

alter table t_xs comment '学生基础信息表';

/*==============================================================*/
/* Table: t_xsds                                                */
/*==============================================================*/
create table t_xsds
(
   xh                   varchar(20) not null comment '学生学号',
   lsbh                 varchar(20) not null comment '老师编号',
   flag                 int comment '标志 1为第一导师   2为第二导师',
   primary key (xh, lsbh)
);

alter table t_xsds comment '学生导师关系表';

/*==============================================================*/
/* Table: t_xsjl                                                */
/*==============================================================*/
create table t_xsjl
(
   xh                   varchar(20) not null comment '学生学号',
   qsny                 varchar(10) comment '起始年月',
   jsny                 varchar(10) comment '结束年月',
   xx                   varchar(20) comment '学校或者任职单位',
   zw                   varchar(10) comment '学生或者职务',
   zmr                  varchar(10) comment '证明人姓名',
   primary key (xh)
);

alter table t_xsjl comment '学生简历表  (从高中起写，注明大学所学专业)';

/*==============================================================*/
/* Table: t_xsjt                                                */
/*==============================================================*/
create table t_xsjt
(
   xh                   varchar(20) not null comment '学生学号',
   xm                   varchar(10) comment '姓名',
   gx                   varchar(10) comment '与本人的关系',
   zzmmdm               int comment '政治面貌代码',
   gzdw                 varchar(20) comment '工作单位',
   primary key (xh)
);

alter table t_xsjt comment '家庭成员及主要社会关系表';

/*==============================================================*/
/* Table: t_xslb                                                */
/*==============================================================*/
create table t_xslb
(
   dm                   int not null comment '学生类别代码',
   mc                   varchar(10) comment '学生类别名称',
   bz                   varchar(1) comment '学生类别标志 (M研究生....)',
   primary key (dm)
);

alter table t_xslb comment '学生类别表';

/*==============================================================*/
/* Table: t_xslqb                                               */
/*==============================================================*/
create table t_xslqb
(
   id                   int not null auto_increment comment 'id',
   ksbh                 varchar(20) not null comment '考生编号',
   zjlx                 varchar(20) not null comment '证件类型',
   zjhm                 varchar(20) not null comment '证件号码',
   xm                   varchar(10) not null comment '姓名',
   csrq                 varchar(10) not null comment '出生日期 格式:19921116',
   mzm                  varchar(5) not null comment '民族码',
   xbm                  int not null comment '性别码 1是男 0是女',
   hfm                  int not null comment '婚否码 1是已婚 0是未婚',
   xyjrm                varchar(20) comment '现役军人码',
   zzmmm                varchar(5) not null comment '政治面貌代码',
   hkszdm               int comment '户口所在地邮政编码',
   hkszdxxdz            varchar(100) comment '户口所在地详细地址',
   lqdwdm               int comment '录取单位代码',
   lqdwmc               varchar(20) comment '录取单位名称
            ',
   lqyxsm               varchar(5) comment '录取院系所码',
   lqzydm               varchar(10) comment '录取专业代码',
   lqzymc               varchar(20) comment '录取专业名称',
   bydwm                varchar(10) comment '毕业单位码',
   bydwmc               varchar(50) comment '毕业单位名称',
   byzydm               varchar(10) comment '毕业专业代码',
   byzymc               varchar(20) comment '毕业专业名称',
   byny                 varchar(10) comment '毕业年月 格式:19921116',
   xlm                  varchar(10) comment '学历代码',
   xlzsbh               varchar(20) comment '学历证书编号',
   xxxsdm               int comment '学习形式代码',
   xwm                  varchar(10) comment '学位代码',
   xwzsbh               varchar(20) comment '学位证书编号',
   kslydm               int comment '考生来源代码',
   ksfsdm               int comment '考试方式代码',
   daszdw               varchar(50) comment '档案所在单位',
   daszdwdz             varchar(50) comment '档案所在单位地址',
   daszdwyzbm           int comment '档案所在单位邮政编码',
   lqlbm                int comment '录取类别码 11-非定向，12-定向，23-委培，24-自筹',
   zzllm                int comment '政治理论码 101-政治理论（含法律硕士），111-单独考试政治理论，199-MBA联考综合能力 ',
   zzllmc               varchar(10) comment '政治理论名称',
   wgym                 int comment '外国语码',
   wgymc                varchar(20) comment '外国语名称',
   ywk1m                varchar(5) comment '业务课一代码',
   ywk1mc               varchar(50) comment '业务课一名称',
   ywk2m                varchar(5) comment '业务课二代码',
   ywk2mc               varchar(50) comment '业务课二名称',
   zzllcj               double comment '政治理论成绩',
   wgycj                double comment '外国语成绩',
   ywk1cj               double comment '业务课一成绩',
   ywk2cj               double comment '业务课二成绩',
   zf                   double comment '总分',
   fscj                 double comment '复试成绩',
   js1mc                varchar(10) comment '加试科目一名称',
   js1cj                double comment '加试科目一成绩',
   js2mc                varchar(10) comment '加试科目二名称',
   js2cj                double comment '加试科目二成绩',
   dxwpdw               varchar(20) comment '定向委培单位',
   dxwpdwszdm           varchar(10) comment '定向委培单位所在代码
            ',
   blzgnx               varchar(10) comment '保留资格年限',
   pg                   varchar(1) comment '破格',
   zxjh                 int comment '专项计划',
   xszgzc               int comment '享受资格政策',
   zcxh                 varchar(20) comment '注册学号',
   szssm                int comment '所在省市码',
   bz                   text comment '备注',
   fscjqz               double comment '复试成绩权重',
   nf                   int comment '年份(比如2012届)',
   flag                 int comment '是否编制学号 0未编制 1编制',
   xslbdm               int comment '学生类别代码',
   primary key (id)
);

alter table t_xslqb comment '学生录取信息表';

/*==============================================================*/
/* Index: uc_zjhm                                               */
/*==============================================================*/
create unique index uc_zjhm on t_xslqb
(
   zjhm
);

/*==============================================================*/
/* Table: t_xslxxx                                              */
/*==============================================================*/
create table t_xslxxx
(
   xh                   varchar(20) not null comment '学号',
   jtzz                 varchar(20) comment '家庭住址',
   zzdh                 varchar(20) comment '住宅电话',
   email                varchar(20) comment '电子邮箱',
   qq                   varchar(20) comment 'QQ',
   jhdxxm               varchar(10) comment '结婚对象姓名',
   xjzd                 varchar(20) comment '现居住地',
   zw                   varchar(10) comment '职位',
   primary key (xh)
);

alter table t_xslxxx comment '学生联系信息表';

/*==============================================================*/
/* Table: t_xsqt                                                */
/*==============================================================*/
create table t_xsqt
(
   xh                   varchar(20) not null comment '学生学号',
   hq                   int comment '是否华侨 1是 0不是',
   qjdd                 varchar(20) comment '侨居地点',
   gzsj                 varchar(20) comment '工作单位',
   gzdd                 varchar(20) comment '工作地点
            ',
   gzjb                 int comment '工资级别',
   zzmmdm               int comment '政治面貌代码',
   sj                   varchar(10) comment '入党/入团时间',
   dd                   varchar(20) comment '入党/入团地点',
   wy                   int comment '是否会外语 会为1 不会为0',
   slcd                 int comment '熟练程度 3非常熟练 2熟练 1略熟练',
   other                text comment '何时何地因何原因受过何种奖励或处分',
   primary key (xh)
);

alter table t_xsqt comment '学生奖励或者其他信息表';

/*==============================================================*/
/* Table: t_xssjzcsh                                            */
/*==============================================================*/
create table t_xssjzcsh
(
   xh                   varchar(20) not null comment '学生学号',
   t_x_xh               varchar(20) not null comment '学号',
   zd                   varchar(20) comment '被修改的字段',
   nr                   varchar(20) comment '被修改字段的内容',
   primary key (xh, t_x_xh)
);

alter table t_xssjzcsh comment '学籍注册信息审核表';

/*==============================================================*/
/* Table: t_xsxjzc                                              */
/*==============================================================*/
create table t_xsxjzc
(
   xh                   varchar(20) not null comment '学号',
   zczt                 varchar(20) comment '注册状态',
   ksh                  varchar(20) comment '考生号',
   xm                   varchar(10) comment '姓名',
   xbm                  int comment '性别',
   csrq                 varchar(10) comment '出生日期 格式19921116',
   sfzh                 varchar(20) comment '身份证号',
   zzmmm                varchar(5) comment '政治面貌代码',
   mzm                  varchar(5) comment '民族代码',
   ejxkdm               varchar(10) comment '二级学科代码',
   xydm                 varchar(5) comment '学院代码',
   bh                   int comment '班号',
   cc                   varchar(12) comment '培养层次',
   xxxx                 varchar(10) comment '学习形式',
   xz                   varchar(3) comment '学制',
   rxrq                 varchar(10) comment '入学日期 格式20120901',
   flag                 int comment '审核状态 1审核通过 0待审 -1审核不通过',
   primary key (xh)
);

alter table t_xsxjzc comment '学籍注册信息表';

/*==============================================================*/
/* Table: t_xsxl                                                */
/*==============================================================*/
create table t_xsxl
(
   xh                   varchar(20) not null comment '学号',
   ksh                  varchar(20) comment '考生编号',
   xm                   varchar(10) comment '姓名',
   xbm                  int comment '性别码',
   csrq                 varchar(10) comment '出生年月',
   yxdm                 varchar(5) comment '院系代码',
   ejxkdm               varchar(10) comment '二级学科代码',
   xxxsdm               int comment '学习形式代码',
   pyccdm               varchar(10) comment '培养层次代码',
   xwdm                 varchar(10) comment '学位代码',
   xldm                 varchar(10) comment '学历代码',
   rxrq                 varchar(10) comment '入学日期',
   byrq                 varchar(10) comment '毕业日期',
   xz                   int comment '学制',
   bjyjl                varchar(10) comment '毕业情况',
   zsbh                 varchar(20) comment '证书编号',
   shjg                 varchar(20) comment '审核结果',
   jyjg                 varchar(50) comment '就业机构',
   bz                   text comment '备注',
   xgsj                 varchar(10) comment '修改时间',
   flag                 int comment '状态 0未确认 1确认',
   primary key (xh)
);

alter table t_xsxl comment '学生学历表';

/*==============================================================*/
/* Table: t_xw                                                  */
/*==============================================================*/
create table t_xw
(
   dm                   varchar(10) not null comment '学位代码',
   mc                   varchar(10) comment '学位名称',
   primary key (dm)
);

alter table t_xw comment '学位表';

/*==============================================================*/
/* Table: t_xx                                                  */
/*==============================================================*/
create table t_xx
(
   dm                   varchar(10) not null comment '学校代码',
   mc                   varchar(20) comment '学校名称',
   primary key (dm)
);

alter table t_xx comment '全国学校表';

/*==============================================================*/
/* Table: t_xxlwcg                                              */
/*==============================================================*/
create table t_xxlwcg
(
   id                   int not null auto_increment comment '论文id',
   xh                   varchar(20) comment '学号',
   mc                   varchar(50) comment '论文、著作、成果含专利名 称',
   cgxs                 varchar(50) comment '成果形式',
   fbjhjqk              varchar(10) comment '发表（鉴定或获奖）与级别情况',
   wcsj                 varchar(10) comment '完成时间',
   brpm                 int comment '本人排名',
   primary key (id)
);

alter table t_xxlwcg comment '学生论文成果表';

/*==============================================================*/
/* Table: t_xxxs                                                */
/*==============================================================*/
create table t_xxxs
(
   dm                   int not null,
   mc                   varchar(50),
   primary key (dm)
);

alter table t_xxxs comment '学习形式表';

/*==============================================================*/
/* Table: t_xy                                                  */
/*==============================================================*/
create table t_xy
(
   dm                   varchar(5) not null comment '学院代码',
   xymc                 varchar(20) comment '学院名称',
   primary key (dm)
);

alter table t_xy comment '学院表';

/*==============================================================*/
/* Table: t_xyzy                                                */
/*==============================================================*/
create table t_xyzy
(
   id                   int not null auto_increment,
   xydm                 varchar(5),
   zydm                 varchar(10),
   primary key (id)
);

alter table t_xyzy comment '学院专业关系表';

/*==============================================================*/
/* Table: t_xzjg                                                */
/*==============================================================*/
create table t_xzjg
(
   dm                   varchar(5) not null comment '行政机构代码',
   mc                   varchar(50) comment '行政机构名称',
   primary key (dm)
);

alter table t_xzjg comment '行政机构表';

/*==============================================================*/
/* Table: t_xzjgz                                               */
/*==============================================================*/
create table t_xzjgz
(
   dm                   varchar(10) not null comment '行政机构子代码',
   pdm                  varchar(5) comment '行政机构父代码',
   mc                   varchar(50) comment '行政机构子名称',
   primary key (dm)
);

alter table t_xzjgz comment '行政机构子表';

/*==============================================================*/
/* Table: t_xzqhsx                                              */
/*==============================================================*/
create table t_xzqhsx
(
   dm                   int not null comment '省市代码',
   mc                   varchar(15) comment '省市名称',
   primary key (dm)
);

alter table t_xzqhsx comment '行政区划(省市)表';

/*==============================================================*/
/* Table: t_yjdw                                                */
/*==============================================================*/
create table t_yjdw
(
   dwdm                 varchar(10) not null comment '单位代码',
   dwmc                 varchar(50) comment '单位名称',
   primary key (dwdm)
);

alter table t_yjdw comment '导师信息里面的单位代码的来源';

/*==============================================================*/
/* Table: t_yzbm                                                */
/*==============================================================*/
create table t_yzbm
(
   dm                   int not null comment '代码',
   mc                   varchar(50) comment '地区名称',
   qh                   int comment '区号',
   yzbm                 int comment '邮政编码',
   ssdm                 int comment '省市代码',
   primary key (dm)
);

alter table t_yzbm comment '行政区划(区县)表';

/*==============================================================*/
/* Table: t_yzbzzy                                              */
/*==============================================================*/
create table t_yzbzzy
(
   zydm                 varchar(10) not null comment '专业代码',
   zymc                 varchar(20) comment '专业名称',
   yjxkdm               varchar(5) comment '一级学科代码',
   yjxkmc               varchar(20) comment '一级学科名称',
   mldm                 varchar(3) comment '门类代码',
   mlmc                 varchar(20) comment '门类名称',
   yzydm                varchar(10) comment '说明这个专业代码还有其他专业代码，就是我们看到的，同一个专业名称，有其他代码，如计算机应用技术，有的是08，有的是07',
   xwlx                 varchar(5) comment '学位类型 xs是学术型 zx是专业学位',
   zscc                 varchar(10),
   zyszqy               varchar(10),
   primary key (zydm)
);

alter table t_yzbzzy comment '研招标准专业库';

/*==============================================================*/
/* Table: t_zc                                                  */
/*==============================================================*/
create table t_zc
(
   dm                   varchar(10) not null comment '职称代码',
   mc                   varchar(30) comment '职称名称',
   primary key (dm)
);

alter table t_zc comment '职称表';

/*==============================================================*/
/* Table: t_zdgzjl                                              */
/*==============================================================*/
create table t_zdgzjl
(
   lsbh                 varchar(20) not null comment '老师编号',
   xsxh                 varchar(20) not null comment '学生学号',
   zdsj                 varchar(10) not null comment '指导时间 格式:20121111',
   nr                   text comment '内容',
   flag                 int comment '审核状态 1为审核通过 -1为审核不通过 0为待审',
   primary key (xsxh, lsbh, zdsj)
);

alter table t_zdgzjl comment '指导工作记录表';

/*==============================================================*/
/* Table: t_zjlb                                                */
/*==============================================================*/
create table t_zjlb
(
   dm                   varchar(5) not null comment '专家类别代码',
   mc                   varchar(100) comment '专家类别名称',
   primary key (dm)
);

alter table t_zjlb comment '专家类别表';

/*==============================================================*/
/* Table: t_zjlx                                                */
/*==============================================================*/
create table t_zjlx
(
   dm                   varchar(20) not null comment '证件类型代码',
   mc                   varchar(20) comment '证件类型名称',
   primary key (dm)
);

alter table t_zjlx comment '证件类型表';

/*==============================================================*/
/* Table: t_zlqk                                                */
/*==============================================================*/
create table t_zlqk
(
   id                   int not null auto_increment comment '专利id',
   lsbh                 varchar(20) comment '老师编号',
   zllx                 varchar(10) comment '专利类型',
   mfrxm                varchar(10) comment '发明人姓名',
   smpx                 varchar(20) comment '署名排序',
   zlmc                 varchar(10) comment '专利名称',
   pzh                  int comment '批准号',
   pzsj                 varchar(10) comment '批准时间',
   primary key (id)
);

alter table t_zlqk comment '老师获专利情况';

/*==============================================================*/
/* Table: t_zscj                                                */
/*==============================================================*/
create table t_zscj
(
   ksh                  varchar(20) not null comment '考生号',
   xm                   varchar(10) comment '姓名',
   sfzh                 varchar(20) comment '身份证号',
   bkzydm               varchar(10) comment '报考专业',
   bkxydm               varchar(5) comment '报考学院',
   zzllcj               float comment '政治理论成绩',
   wgycj                float comment '外国语成绩',
   ywk1cj               float comment '业务课一成绩',
   ywk2cj               float comment '业务课二成绩',
   zf                   float comment '总分',
   primary key (ksh)
);

alter table t_zscj comment '招生成绩表';

/*==============================================================*/
/* Table: t_zzmm                                                */
/*==============================================================*/
create table t_zzmm
(
   dm                   varchar(5) not null comment '政治面貌代码',
   mc                   varchar(10) comment '政治面貌名称',
   primary key (dm)
);

alter table t_zzmm comment '政治面貌表';

/*==============================================================*/
/* Table: zjlx                                                  */
/*==============================================================*/
create table zjlx
(
   dm                   int not null comment '证件类型代码',
   mc                   varchar(20) comment '证件类型名称',
   primary key (dm)
);

alter table zjlx comment '证件类型表';

alter table t_cbxszzqk add constraint FK_cbxszzqk_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_dqjgz add constraint FK_dqjgz_pdm_dqjg_dm foreign key (pdm)
      references t_dqjg (dm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_dexkejxkm_yzbzzy_zydm foreign key (dexkejxkm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_dexkyjxkm_yzbzzy_zydm foreign key (dexkyjxkm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_dwdm_yjdw_dwdm foreign key (dwdm)
      references t_yjdw (dwdm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_mz_mz_dm foreign key (mz)
      references t_mz (dm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_zjlbdm_zjlb_dm foreign key (zjlbdm)
      references t_zjlb (dm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_zydm_yzbzzy_zydm foreign key (zydm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_zyxkejxkm_yzbzzy_zydm foreign key (zyxkejxkm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_dsxx add constraint FK_dsxx_zyxkyjxkm_yzbzzy_zydm foreign key (zyxkyjxkm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_dsxy add constraint FK_dsxy_dsh_dsxx_dsh foreign key (lsbh)
      references t_dsxx (lsbh) on delete restrict on update restrict;

alter table t_dsxy add constraint FK_dsxy_xydm_xy_dm foreign key (xydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_function add constraint FK_function_moduleId_module_moduleId foreign key (moduleId)
      references t_module (moduleId) on delete restrict on update restrict;

alter table t_function_action add constraint FK_t_function_action_functionId_function_functionId foreign key (functionId)
      references t_function (functionId) on delete restrict on update restrict;

alter table t_hjqk add constraint FK_hjqk_zgh_teacher_zgh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_jxqkb add constraint FK_jxqk_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_kccj add constraint FK_kc_kcdm_lesson_kcdm foreign key (kcdm)
      references t_lesson (kcdm) on delete restrict on update restrict;

alter table t_kccj add constraint FK_kccj_jxljshdm_jxljsh_dm foreign key (jsxxId)
      references t_jsxx (id) on delete restrict on update restrict;

alter table t_kccj add constraint FK_kccj_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_kccj add constraint FK_kccj_zgh_teacher_zgh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_kyxm add constraint FK_kyxm_zgh_teacher_zgh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_lslxxx add constraint FK_lslxxx_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_lw add constraint FK_lw_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_pyhj add constraint FK_pyhi_lwjhzdls_teacher_zgh foreign key (lwjhzdls)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_pyhj add constraint FK_pyhj_jxsjzdls_teacher_zgh foreign key (jxsjzdls)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_pyhj add constraint FK_pyhj_shsjzdls_teacher_zgh foreign key (shsjzdls)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_pyhj add constraint FK_pyhj_xshdzdls_teacher_zgh foreign key (xshdzdls)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_pyhj add constraint FK_pyhj_yjtmzdls_teacher_zgh foreign key (yjtmzdls)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_role_function add constraint FK_role_function_functionid_function_funcrion_id foreign key (functionId)
      references t_function (functionId) on delete restrict on update restrict;

alter table t_role_function add constraint FK_role_function_roleid_roleid_roleid foreign key (roleId)
      references t_role (roleId) on delete restrict on update restrict;

alter table t_role_module add constraint FK_role_module_moduleId_module_moduleId foreign key (moduleId)
      references t_module (moduleId) on delete restrict on update restrict;

alter table t_role_module add constraint FK_role_module_roleId_role_roleId foreign key (roleId)
      references t_role (roleId) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_byxxdm_xx_dm foreign key (byxxdm)
      references t_xx (dm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_byzydm_yzbzzy_zydm foreign key (byzydm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_mzdm_mz_dm foreign key (mzdm)
      references t_mz (dm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_xdm_x_xdm foreign key (xdm)
      references t_x (xdm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_xldm_xl_dm foreign key (xldm)
      references t_xl (dm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_xwdm_xw_dm foreign key (xwdm)
      references t_xw (dm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_zcdm_zc_dm foreign key (zcdm)
      references t_zc (dm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_zydm_yzbzzy_zydm foreign key (zydm)
      references t_yzbzzy (zydm) on delete restrict on update restrict;

alter table t_teacher add constraint FK_teacher_zzmmdm_zzmm_dm foreign key (zzmmdm)
      references t_zzmm (dm) on delete restrict on update restrict;

alter table t_tjxx add constraint FK_tjxx_ksh_zscj_ksh foreign key (ksh)
      references t_zscj (ksh) on delete restrict on update restrict;

alter table t_tzs add constraint FK_tzs_ksh_zscj_ksh foreign key (ksh)
      references t_zscj (ksh) on delete restrict on update restrict;

alter table t_user_role add constraint FK_user_role_roleid_role_id foreign key (roleId)
      references t_role (roleId) on delete restrict on update restrict;

alter table t_user_role add constraint FK_user_role_username_user_username foreign key (username)
      references t_user (username) on delete restrict on update restrict;

alter table t_x add constraint FK_x_xydm_xy_dm foreign key (xydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_ejxkdm_ejxk_dm foreign key (ejxkdm)
      references t_ejxk (ejxkdm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_hdxlfs_hdxlfs_dm foreign key (hdxlfsdm)
      references t_hdxlfs (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_mzdm_mz_dm foreign key (mzm)
      references t_mz (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_pyccdm_pycc_dm foreign key (pyccdm)
      references t_pycc (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_xdm_x_dm foreign key (xdm)
      references t_x (xdm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_xjztdm_xjzt_dm foreign key (xjztdm)
      references t_xjzt (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_xslbdm_xslb_dm foreign key (xslb)
      references t_xslb (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_xydm_xy_dm foreign key (xydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_zjlxdm_zjlx_dm foreign key (zjlx)
      references t_zjlx (dm) on delete restrict on update restrict;

alter table t_xs add constraint FK_xs_zzmmdm_zzmm_dm foreign key (zzmmm)
      references t_zzmm (dm) on delete restrict on update restrict;

alter table t_xsds add constraint FK_dsxs_lsbh_dsxx_lsbh foreign key (lsbh)
      references t_dsxx (lsbh) on delete restrict on update restrict;

alter table t_xsds add constraint FK_dsxs_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xsjl add constraint FK_xsjl_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xsjt add constraint FK_xsjt_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xslxxx add constraint FK_xslxxx_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xsqt add constraint FK_xsqt_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xssjzcsh add constraint FK_xsxjzcsh_xh_xsxjzc_xh foreign key (xh)
      references t_xsxjzc (xh) on delete restrict on update restrict;

alter table t_xsxjzc add constraint FK_xs_zzmmm_zzmm_dm foreign key (zzmmm)
      references t_zzmm (dm) on delete restrict on update restrict;

alter table t_xsxjzc add constraint FK_xssjzc_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xsxjzc add constraint FK_xssjzc_xydm_xy_dm foreign key (xydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_xsxjzc add constraint FK_xsxjzc_ejxkdm_ejxk_dm foreign key (ejxkdm)
      references t_ejxk (ejxkdm) on delete restrict on update restrict;

alter table t_xsxjzc add constraint FK_xsxjzc_mzdm_mz_dm foreign key (mzm)
      references t_mz (dm) on delete restrict on update restrict;

alter table t_xsxl add constraint FK_xsxl_ejxkdm_ejxk_dm foreign key (ejxkdm)
      references t_ejxk (ejxkdm) on delete restrict on update restrict;

alter table t_xsxl add constraint FK_xsxl_xydm_xy_dm foreign key (yxdm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_xsxl add constraint FK_xsxlb_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xxlwcg add constraint FK_xxlwcg_xh_xs_xh foreign key (xh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_xyzy add constraint FK_xyzy_xydm_ejxk_ejxkdm foreign key (zydm)
      references t_ejxk (ejxkdm) on delete restrict on update restrict;

alter table t_xyzy add constraint FK_xyzy_xydm_xy_dm foreign key (xydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_xzjgz add constraint FK_xzjgz_pdm_xzjg_dm foreign key (pdm)
      references t_xzjg (dm) on delete restrict on update restrict;

alter table t_yzbm add constraint FK_yzbm_ssdm_xzqhsx_dm foreign key (ssdm)
      references t_xzqhsx (dm) on delete restrict on update restrict;

alter table t_zdgzjl add constraint FK_zdgzjl_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_zdgzjl add constraint FK_zdgzjl_xh_xs_xh foreign key (xsxh)
      references t_xs (xh) on delete restrict on update restrict;

alter table t_zlqk add constraint FK_zlqk_lsbh_teacher_lsbh foreign key (lsbh)
      references t_teacher (lsbh) on delete restrict on update restrict;

alter table t_zscj add constraint FK_zscj_bkxydm_xy_dm foreign key (bkxydm)
      references t_xy (dm) on delete restrict on update restrict;

alter table t_zscj add constraint FK_zscj_bkzydm_ejxk_dm foreign key (bkzydm)
      references t_ejxk (ejxkdm) on delete restrict on update restrict;

