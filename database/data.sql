-- ----------------------------
-- Records of t_xjzt
-- ----------------------------
INSERT INTO `t_xjzt` VALUES ('1', '一年级');
INSERT INTO `t_xjzt` VALUES ('2', '二年级');
INSERT INTO `t_xjzt` VALUES ('3', '三年级');
INSERT INTO `t_xjzt` VALUES ('4', '毕业');
INSERT INTO `t_xjzt` VALUES ('5', '结业');
INSERT INTO `t_xjzt` VALUES ('6', '肄业');
INSERT INTO `t_xjzt` VALUES ('7', '退学');


-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('111', '698d51a19d8a121ce581499d7b701668', '用户名密码都是111', '911');

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('1', '入学管理');
INSERT INTO `t_module` VALUES ('2', '基础信息维护');
INSERT INTO `t_module` VALUES ('3', '学科管理');
INSERT INTO `t_module` VALUES ('4', '个人信息管理');


-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '学生');
INSERT INTO `t_role` VALUES ('2', '老师');
INSERT INTO `t_role` VALUES ('3', '导师');
INSERT INTO `t_role` VALUES ('4', '院级管理员');
INSERT INTO `t_role` VALUES ('5', '校级管理员');
INSERT INTO `t_role` VALUES ('6', '管理员');


-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('111', '1');
INSERT INTO `t_user_role` VALUES ('111', '2');


-- ----------------------------
-- Records of t_role_module
-- ----------------------------
INSERT INTO `t_role_module` VALUES ('1', '1');
INSERT INTO `t_role_module` VALUES ('1', '4');
INSERT INTO `t_role_module` VALUES ('2', '1');
INSERT INTO `t_role_module` VALUES ('2', '2');
INSERT INTO `t_role_module` VALUES ('2', '3');
INSERT INTO `t_role_module` VALUES ('2', '4');


-- ----------------------------
-- Records of t_function
-- ----------------------------
INSERT INTO `t_function` VALUES ('1', '1', '导入学生录取信息', './rxgl/drxslq.html');
INSERT INTO `t_function` VALUES ('2', '1', '学生信息查看', './rxgl/ckxs.html');
INSERT INTO `t_function` VALUES ('3', '2', '学院信息维护', './jcxx/xy.html');
INSERT INTO `t_function` VALUES ('4', '2', '学生类别信息维护', './jcxx/xslb.html');
INSERT INTO `t_function` VALUES ('5', '2', '专业信息维护', './jcxx/ejxk.html');
INSERT INTO `t_function` VALUES ('6', '3', '导入老师信息', './jcxx/drlsxx.html');
INSERT INTO `t_function` VALUES ('7', '4', '密码修改', './grxx/xgmm.html');
INSERT INTO `t_function` VALUES ('8', '4', '个人信息查看', './grxx/grxxcx.html');
INSERT INTO `t_function` VALUES ('9', '4', '公共课排课', './assets/ggkpk.html');
INSERT INTO `t_function` VALUES ('10', '2', '导入教室信息', './jcxx/drjsxx.html');


-- ----------------------------
-- Records of t_role_function
-- ----------------------------
INSERT INTO `t_role_function` VALUES ('1', '2');
INSERT INTO `t_role_function` VALUES ('1', '8');
INSERT INTO `t_role_function` VALUES ('2', '1');
INSERT INTO `t_role_function` VALUES ('2', '2');
INSERT INTO `t_role_function` VALUES ('2', '3');
INSERT INTO `t_role_function` VALUES ('2', '4');
INSERT INTO `t_role_function` VALUES ('2', '5');
INSERT INTO `t_role_function` VALUES ('2', '6');
INSERT INTO `t_role_function` VALUES ('2', '7');
INSERT INTO `t_role_function` VALUES ('2', '9');
INSERT INTO `t_role_function` VALUES ('2', '10');


-- ----------------------------
-- Records of t_xl
-- ----------------------------
INSERT INTO `t_xl` VALUES ('1', '研究生');
INSERT INTO `t_xl` VALUES ('2', '本科');
INSERT INTO `t_xl` VALUES ('3', '专科');

-- ----------------------------
-- Records of t_pycc
-- ----------------------------
INSERT INTO `t_pycc` VALUES ('1', '博士研究生');
INSERT INTO `t_pycc` VALUES ('2', '硕士研究生');
INSERT INTO `t_pycc` VALUES ('3', '本科');
INSERT INTO `t_pycc` VALUES ('4', '专科');

-- ----------------------------
-- Records of t_xw
-- ----------------------------
INSERT INTO `t_xw` VALUES ('01', '博士');
INSERT INTO `t_xw` VALUES ('02', '硕士');
INSERT INTO `t_xw` VALUES ('02', '学士');

-- ----------------------------
-- Records of t_xx     test
-- ----------------------------
INSERT INTO `t_xx` VALUES ('10002', '中国人民大学');
INSERT INTO `t_xx` VALUES ('10532', '湖南大学');
INSERT INTO `t_xx` VALUES ('10533', '中南大学');

-- ----------------------------
-- Records of t_yzbzzy   test
-- ----------------------- -----
INSERT INTO `t_yzbzzy` VALUES ('001', '信息管理与工程', null, null, null, null, null, null, null, null);
INSERT INTO `t_yzbzzy` VALUES ('002', '桥梁建筑', null, null, null, null, null, null, null, null);
INSERT INTO `t_yzbzzy` VALUES ('003', '桥梁垮塌', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Records of t_zc      test
-- ----------------------------
INSERT INTO `t_zc` VALUES ('0101', '博士生导师');
INSERT INTO `t_zc` VALUES ('0102', '硕士生导师');


-- ----------------------------
-- Records of t_zjlb   test
-- ----------------------------
INSERT INTO `t_zjlb` VALUES ('0011', '材料专家');
INSERT INTO `t_zjlb` VALUES ('0012', '电信专家');
INSERT INTO `t_zjlb` VALUES ('0013', '社会学专家');
INSERT INTO `t_zjlb` VALUES ('0014', '人力资源学专家');
INSERT INTO `t_zjlb` VALUES ('0015', '编程专家');


-- ----------------------------
-- Records of t_ejxk
-- ----------------------------
INSERT INTO `t_ejxk` VALUES ('010105', '伦理学', '0101', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030101 ', '法学理论', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030102 ', '法律史', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030103 ', '宪法学与行政法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030104 ', '刑法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030105 ', '民商法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030106 ', '诉讼法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030107 ', '经济法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030108 ', '环境与资源保护法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030109 ', '国际法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030110 ', '军事法学', '0301', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('030503 ', '马克思主义中国化研究', '0305', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('050211 ', '外国语言学及应用语言学', '0502', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('077501', '计算机系统结构', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('077502', '计算机软件与理论', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('077503', '计算机应用技术', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('077700', '生物医学工程', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080201', '机械制造及其自动化', '0802', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080202 ', '机械电子工程', '0802', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080203 ', '机械设计及理论', '0802', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080204 ', '车辆工程', '0802', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080501 ', '材料物理与化学', '0805', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080502 ', '材料学', '0805', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080503 ', '材料加工工程', '0805', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('0805Z1', '包装工程', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('0805Z2', '冶金材料工程', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080801', '电机与电器', '0808', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080802 ', '电力系统及其自动化', '0808', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080803 ', '高电压与绝缘技术', '0808', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080804', '电力电子与电力传动', '0808', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('080805', '电工理论与新技术', '0808', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('0808Z1', '网络化系统控制', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081101 ', '控制理论与控制工程', '0811', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081201 ', '计算机系统结构', '0812', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081202 ', '计算机软件与理论', '0812', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081203 ', '计算机应用技术', '0812', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081401 ', '岩土工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081402 ', '结构工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081403 ', '市政工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081404 ', '供热、供燃气、通风及空调工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081405 ', '防灾减灾工程及防护工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('081406 ', '桥梁与隧道工程', '0814', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('0814Z1', '绿色包装与低碳管理', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('083100 ', '生物医学工程', '0831', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('085201', '机械工程', '0852', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085204', '材料工程', '0852', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085207', '电气工程', '0854', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085211', '计算机技术', '0855', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085236', '工业工程', '0856', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085239', '项目管理', '0857', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('085240', '物流工程', '0858', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('0872J1', '人居环境设计学', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('120100 ', '管理科学与工程', '1201', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('1201Z1', '区域生态系统管理', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('120201 ', '会计学', '1202', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('120202 ', '企业管理', '1202', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('120203 ', '旅游管理', '1202', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('120204 ', '技术经济及管理', '1202', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('125100', '工商管理', '1251', '', '', '', 'zx');
INSERT INTO `t_ejxk` VALUES ('130300 ', '戏剧与影视学', '1303', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('130400 ', '美术学', '1304', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('1304L1', '美术学', '', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('130500 ', '设计学', '1305', '', '', '', 'xs');
INSERT INTO `t_ejxk` VALUES ('135108', '艺术设计', '1351', '', '', '', 'zx');

-- ----------------------------
-- Records of t_mz
-- ----------------------------
INSERT INTO `t_mz` VALUES ('01', '汉族');
INSERT INTO `t_mz` VALUES ('02', '蒙古族');
INSERT INTO `t_mz` VALUES ('03', '回族');
INSERT INTO `t_mz` VALUES ('04', '藏族');
INSERT INTO `t_mz` VALUES ('05', '维吾尔族');
INSERT INTO `t_mz` VALUES ('06', '苗族');
INSERT INTO `t_mz` VALUES ('07', '彝族');
INSERT INTO `t_mz` VALUES ('08', '壮族');
INSERT INTO `t_mz` VALUES ('09', '布依族');
INSERT INTO `t_mz` VALUES ('10', '朝鲜族');
INSERT INTO `t_mz` VALUES ('11', '满族');
INSERT INTO `t_mz` VALUES ('12', '侗族');
INSERT INTO `t_mz` VALUES ('13', '瑶族');
INSERT INTO `t_mz` VALUES ('14', '白族');
INSERT INTO `t_mz` VALUES ('15', '土家族');
INSERT INTO `t_mz` VALUES ('16', '哈尼族');
INSERT INTO `t_mz` VALUES ('17', '哈萨克族');
INSERT INTO `t_mz` VALUES ('18', '傣族');
INSERT INTO `t_mz` VALUES ('19', '黎族');
INSERT INTO `t_mz` VALUES ('20', '傈僳族');
INSERT INTO `t_mz` VALUES ('21', '佤族');
INSERT INTO `t_mz` VALUES ('22', '畲族');
INSERT INTO `t_mz` VALUES ('23', '高山族');
INSERT INTO `t_mz` VALUES ('24', '拉祜族');
INSERT INTO `t_mz` VALUES ('25', '水族');
INSERT INTO `t_mz` VALUES ('26', '东乡族');
INSERT INTO `t_mz` VALUES ('27', '纳西族');
INSERT INTO `t_mz` VALUES ('28', '景颇族');
INSERT INTO `t_mz` VALUES ('29', '柯尔克孜族');
INSERT INTO `t_mz` VALUES ('30', '土族');
INSERT INTO `t_mz` VALUES ('31', '达斡尔族');
INSERT INTO `t_mz` VALUES ('32', '仫佬族');
INSERT INTO `t_mz` VALUES ('33', '羌族');
INSERT INTO `t_mz` VALUES ('34', '布朗族');
INSERT INTO `t_mz` VALUES ('35', '撒拉族');
INSERT INTO `t_mz` VALUES ('36', '毛南族');
INSERT INTO `t_mz` VALUES ('37', '仡佬族');
INSERT INTO `t_mz` VALUES ('38', '锡伯族');
INSERT INTO `t_mz` VALUES ('39', '阿昌族');
INSERT INTO `t_mz` VALUES ('40', '普米族');
INSERT INTO `t_mz` VALUES ('41', '塔吉克族');
INSERT INTO `t_mz` VALUES ('42', '怒族');
INSERT INTO `t_mz` VALUES ('43', '乌孜别克族');
INSERT INTO `t_mz` VALUES ('44', '俄罗斯族');
INSERT INTO `t_mz` VALUES ('45', '鄂温克族');
INSERT INTO `t_mz` VALUES ('46', '德昂族');
INSERT INTO `t_mz` VALUES ('47', '保安族');
INSERT INTO `t_mz` VALUES ('48', '裕固族');
INSERT INTO `t_mz` VALUES ('49', '京族');
INSERT INTO `t_mz` VALUES ('50', '塔塔尔族');
INSERT INTO `t_mz` VALUES ('51', '独龙族');
INSERT INTO `t_mz` VALUES ('52', '鄂伦春族');
INSERT INTO `t_mz` VALUES ('53', '赫哲族');
INSERT INTO `t_mz` VALUES ('54', '门巴族');
INSERT INTO `t_mz` VALUES ('55', '珞巴族');
INSERT INTO `t_mz` VALUES ('56', '基诺族');
INSERT INTO `t_mz` VALUES ('97', '其它');
INSERT INTO `t_mz` VALUES ('98', '外国血统中国籍人士');

-- ----------------------------
-- Records of t_xy
-- ----------------------------
INSERT INTO `t_xy` VALUES ('001', '文学与新闻传播学院');
INSERT INTO `t_xy` VALUES ('002', '思想政治理论课教学科研部');
INSERT INTO `t_xy` VALUES ('003', '外国语学院');
INSERT INTO `t_xy` VALUES ('004', '包装设计艺术学院');
INSERT INTO `t_xy` VALUES ('005', '机械工程学院');
INSERT INTO `t_xy` VALUES ('006', '包装与材料工程学院');
INSERT INTO `t_xy` VALUES ('007', '电气与信息工程学院');
INSERT INTO `t_xy` VALUES ('008', '计算机与通信学院');
INSERT INTO `t_xy` VALUES ('009', '土木工程学院');
INSERT INTO `t_xy` VALUES ('010', '财经学院');
INSERT INTO `t_xy` VALUES ('011', '商学院');
INSERT INTO `t_xy` VALUES ('012', '法学院');
INSERT INTO `t_xy` VALUES ('013', '理学院');
INSERT INTO `t_xy` VALUES ('014', '冶金工程学院');
INSERT INTO `t_xy` VALUES ('015', '建筑与城乡规划学院');


-- ----------------------------
-- Records of t_zzmm
-- ----------------------------
INSERT INTO `t_zzmm` VALUES ('01', '中共党员');
INSERT INTO `t_zzmm` VALUES ('02', '中共预备党员');
INSERT INTO `t_zzmm` VALUES ('03', '共青团员');
INSERT INTO `t_zzmm` VALUES ('04', '民革会员');
INSERT INTO `t_zzmm` VALUES ('05', '民盟盟员');
INSERT INTO `t_zzmm` VALUES ('06', '民建会员');
INSERT INTO `t_zzmm` VALUES ('07', '民进会员');
INSERT INTO `t_zzmm` VALUES ('08', '农工党党员');
INSERT INTO `t_zzmm` VALUES ('09', '致公党党员');
INSERT INTO `t_zzmm` VALUES ('10', '九三学社社员');
INSERT INTO `t_zzmm` VALUES ('11', '台盟盟员');
INSERT INTO `t_zzmm` VALUES ('12', '无党派民主人士');
INSERT INTO `t_zzmm` VALUES ('13', '群众');


-- ----------------------------
-- Records of t_zjlx
-- ----------------------------
INSERT INTO `t_zjlx` VALUES ('01', '内地身份证');
INSERT INTO `t_zjlx` VALUES ('02', '军人证件');
INSERT INTO `t_zjlx` VALUES ('03', '港澳台身份证');
INSERT INTO `t_zjlx` VALUES ('04', '华侨身份证');

-- ----------------------------
-- Records of t_xslb
-- ----------------------------
INSERT INTO `t_xslb` VALUES ('1', '全日制硕士研究生', 'M');
INSERT INTO `t_xslb` VALUES ('2', '非全日制硕士研究生', 'P');
INSERT INTO `t_xslb` VALUES ('3', '全日制博士研究生', 'D');
INSERT INTO `t_xslb` VALUES ('4', '进修生', 'J');


-- ----------------------------
-- Records of t_xyzy
-- ----------------------------
INSERT INTO `t_xyzy` VALUES ('49', '008', '085211');
INSERT INTO `t_xyzy` VALUES ('50', '011', '085236');
INSERT INTO `t_xyzy` VALUES ('51', '010', '085239');
INSERT INTO `t_xyzy` VALUES ('52', '010', '085240');
INSERT INTO `t_xyzy` VALUES ('53', '010', '0872J1');
INSERT INTO `t_xyzy` VALUES ('54', '010', '120100 ');
INSERT INTO `t_xyzy` VALUES ('55', '010', '1201Z1');
INSERT INTO `t_xyzy` VALUES ('56', '010', '120201 ');
INSERT INTO `t_xyzy` VALUES ('57', '011', '120201 ');
INSERT INTO `t_xyzy` VALUES ('58', '011', '120202 ');
INSERT INTO `t_xyzy` VALUES ('59', '011', '120203 ');
INSERT INTO `t_xyzy` VALUES ('60', '011', '120204 ');
INSERT INTO `t_xyzy` VALUES ('61', '011', '125100');
INSERT INTO `t_xyzy` VALUES ('62', '001', '130300 ');
INSERT INTO `t_xyzy` VALUES ('63', '004', '130400 ');
INSERT INTO `t_xyzy` VALUES ('64', '004', '1304L1');
INSERT INTO `t_xyzy` VALUES ('65', '004', '130500 ');
INSERT INTO `t_xyzy` VALUES ('66', '004', '135108');
INSERT INTO `t_xyzy` VALUES ('67', '001', '010105');
INSERT INTO `t_xyzy` VALUES ('68', '012', '030101 ');
INSERT INTO `t_xyzy` VALUES ('69', '012', '030102 ');
INSERT INTO `t_xyzy` VALUES ('70', '012', '030103 ');
INSERT INTO `t_xyzy` VALUES ('71', '012', '030104 ');
INSERT INTO `t_xyzy` VALUES ('72', '012', '030105 ');
INSERT INTO `t_xyzy` VALUES ('73', '012', '030106 ');
INSERT INTO `t_xyzy` VALUES ('74', '012', '030107 ');
INSERT INTO `t_xyzy` VALUES ('75', '012', '030108 ');
INSERT INTO `t_xyzy` VALUES ('76', '012', '030109 ');
INSERT INTO `t_xyzy` VALUES ('77', '012', '030110 ');
INSERT INTO `t_xyzy` VALUES ('78', '002', '030503 ');
INSERT INTO `t_xyzy` VALUES ('79', '003', '050211 ');
INSERT INTO `t_xyzy` VALUES ('80', '008', '077501');
INSERT INTO `t_xyzy` VALUES ('81', '008', '077502');
INSERT INTO `t_xyzy` VALUES ('82', '008', '077503');
INSERT INTO `t_xyzy` VALUES ('83', '006', '077700');
INSERT INTO `t_xyzy` VALUES ('84', '005', '080201');
INSERT INTO `t_xyzy` VALUES ('85', '005', '080202 ');
INSERT INTO `t_xyzy` VALUES ('86', '005', '080203 ');
INSERT INTO `t_xyzy` VALUES ('87', '005', '080204 ');
INSERT INTO `t_xyzy` VALUES ('88', '006', '080501 ');
INSERT INTO `t_xyzy` VALUES ('89', '006', '080502 ');
INSERT INTO `t_xyzy` VALUES ('90', '006', '080503 ');
INSERT INTO `t_xyzy` VALUES ('91', '006', '0805Z1');
INSERT INTO `t_xyzy` VALUES ('92', '014', '0805Z2');
INSERT INTO `t_xyzy` VALUES ('93', '007', '080801');
INSERT INTO `t_xyzy` VALUES ('94', '007', '080802 ');
INSERT INTO `t_xyzy` VALUES ('95', '007', '080803 ');
INSERT INTO `t_xyzy` VALUES ('96', '007', '080804');
INSERT INTO `t_xyzy` VALUES ('97', '007', '080805');
INSERT INTO `t_xyzy` VALUES ('98', '013', '0808Z1');
INSERT INTO `t_xyzy` VALUES ('99', '007', '081101 ');
INSERT INTO `t_xyzy` VALUES ('100', '008', '081201 ');
INSERT INTO `t_xyzy` VALUES ('101', '008', '081202 ');
INSERT INTO `t_xyzy` VALUES ('102', '008', '081203 ');
INSERT INTO `t_xyzy` VALUES ('103', '009', '081401 ');
INSERT INTO `t_xyzy` VALUES ('104', '009', '081402 ');
INSERT INTO `t_xyzy` VALUES ('105', '009', '081403 ');
INSERT INTO `t_xyzy` VALUES ('106', '009', '081404 ');
INSERT INTO `t_xyzy` VALUES ('107', '009', '081405 ');
INSERT INTO `t_xyzy` VALUES ('108', '009', '081406 ');
INSERT INTO `t_xyzy` VALUES ('109', '015', '0814Z1');
INSERT INTO `t_xyzy` VALUES ('110', '006', '083100 ');
INSERT INTO `t_xyzy` VALUES ('111', '005', '085201');
INSERT INTO `t_xyzy` VALUES ('112', '006', '085204');
INSERT INTO `t_xyzy` VALUES ('113', '007', '085207');

