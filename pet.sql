/*
Navicat MySQL Data Transfer

Source Server         : ysw
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : pet

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2021-03-13 13:40:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `vid` bigint(16) NOT NULL AUTO_INCREMENT,
  `vtitle` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vdetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vphoto` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vtime` datetime DEFAULT NULL,
  `uid` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '猫狗交友活动', '这是一场猫和狗的交流活动，大家来一起参加吧，地点在下沙高教园区，东方公园内', 'qwasaf.png', '2021-12-01 20:22:51', '345678');
INSERT INTO `activity` VALUES ('2', '哈士奇选美比赛', '西伯利亚雪橇犬是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。哈士奇名字是源自其独特的嘶哑叫声 [1]  。哈士奇性格多变，有的极端胆小，也有的极端暴力，进入人类社会和家庭的哈士奇，都已经没有了这种极端的性格，比较温顺，是一种流行于全球的宠物犬。因为哈士奇的这些特性，所以我们决定具办一场线下哈士奇选美比赛。活动举办地：上海', 'aca.png', '2020-08-14 20:20:12', 'ysw111');
INSERT INTO `activity` VALUES ('3', '猫咪越野障碍赛', '来一场惊心动魄的猫咪越野障碍赛。无论多高的难度，相信不会难倒你的猫咪的。活动举办地：杭州', 'acb.png', '2020-08-14 13:06:21', '123456');
INSERT INTO `activity` VALUES ('4', '带着宠物去旅行', '在落日的余晖下，我们和狗狗一起漫游在乡间的小路上，一起奔跑在金色的麦田中，一起围成个圈和宠物们玩游戏。 来吧，本活动在杭州郊区举行，只限10个人。', 'acc.png', '2020-08-23 13:11:27', '234567');

-- ----------------------------
-- Table structure for `chat`
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `chid` bigint(20) NOT NULL AUTO_INCREMENT,
  `chpub` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `chrec` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `chtime` datetime DEFAULT NULL,
  `chdetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `chstate` int(2) DEFAULT '0',
  PRIMARY KEY (`chid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('1', 'ysw111', '234567', '2020-05-12 15:31:23', 'hellow', '0');
INSERT INTO `chat` VALUES ('2', 'ysw222', 'ysw111', '2020-05-12 15:33:22', '你好', '1');
INSERT INTO `chat` VALUES ('3', 'ysw111', 'ysw222', '2020-05-12 15:34:23', '有猫卖吗？', '1');
INSERT INTO `chat` VALUES ('4', 'ysw111', '123456', '2020-05-12 17:51:12', 'hellow', '0');
INSERT INTO `chat` VALUES ('5', 'ysw111', '234567', '2020-05-22 22:31:23', 'hellow2', '0');
INSERT INTO `chat` VALUES ('6', '123456', '234567', '2020-05-23 15:31:21', 'hejkk', '0');
INSERT INTO `chat` VALUES ('7', '234567', 'ysw111', '2020-05-23 17:31:22', 'hellow3', '1');
INSERT INTO `chat` VALUES ('8', 'ysw111', '234567', '2020-05-23 18:31:21', 'hellow4', '0');
INSERT INTO `chat` VALUES ('9', '234567', 'ysw111', '2020-05-23 19:31:21', 'hellow5', '1');
INSERT INTO `chat` VALUES ('11', 'ysw111', 'ysw222', '2020-05-25 22:48:22', '不开心啊', '1');
INSERT INTO `chat` VALUES ('12', 'ysw222', 'ysw111', '2020-05-25 22:48:49', '怎么了吗', '1');
INSERT INTO `chat` VALUES ('13', 'ysw222', 'ysw111', '2020-05-25 22:50:41', '有抑郁症？', '1');
INSERT INTO `chat` VALUES ('14', 'ysw111', 'ysw222', '2020-05-25 22:51:03', '你怎么undefined啊？', '1');
INSERT INTO `chat` VALUES ('15', 'ysw222', 'ysw111', '2020-05-25 22:51:39', '发发呆', '1');
INSERT INTO `chat` VALUES ('16', 'ysw111', 'ysw222', '2020-05-25 22:51:58', '阿道夫', '1');
INSERT INTO `chat` VALUES ('17', 'ysw111', 'ysw222', '2020-05-25 22:59:24', '难顶', '1');
INSERT INTO `chat` VALUES ('18', 'ysw222', 'ysw111', '2020-05-25 23:03:54', '你好', '1');
INSERT INTO `chat` VALUES ('19', 'ysw111', 'ysw222', '2020-05-25 23:04:26', '不好', '1');
INSERT INTO `chat` VALUES ('20', 'ysw222', 'ysw111', '2020-05-25 23:04:41', '唏嘘嘘嘘', '1');
INSERT INTO `chat` VALUES ('21', 'ysw111', '123456', '2020-05-25 23:22:57', '你好', '0');
INSERT INTO `chat` VALUES ('22', 'ysw111', '234567', '2020-05-25 23:23:11', 'hellow6', '0');
INSERT INTO `chat` VALUES ('23', 'ysw111', '134567', '2020-05-25 23:31:35', '你好', '1');
INSERT INTO `chat` VALUES ('24', 'ysw111', '123456', '2020-05-25 23:31:52', '不回我？', '0');
INSERT INTO `chat` VALUES ('25', 'ysw111', '234567', '2020-05-25 23:32:05', 'hellow7', '0');
INSERT INTO `chat` VALUES ('26', '134567', 'ysw111', '2020-05-25 23:33:23', '你好啊，我是文逍', '1');
INSERT INTO `chat` VALUES ('27', '134567', 'ysw111', '2020-05-25 23:34:14', '年后再见', '1');
INSERT INTO `chat` VALUES ('28', 'ysw111', '134567', '2020-05-25 23:34:33', '年前见', '1');
INSERT INTO `chat` VALUES ('29', '134567', 'ysw222', '2020-05-25 23:35:09', '章红，你怎么不叫章宏呢？\n', '0');
INSERT INTO `chat` VALUES ('30', 'ysw111', '134567', '2020-05-25 23:36:35', '不见不见', '1');
INSERT INTO `chat` VALUES ('31', 'ysw111', 'ysw111', '2020-05-26 00:12:15', '啊啊', '1');
INSERT INTO `chat` VALUES ('32', 'ysw111', 'ysw111', '2020-05-26 00:12:19', '啊啊', '1');
INSERT INTO `chat` VALUES ('33', 'ysw111', 'ysw222', '2020-05-26 00:12:36', '啊啊', '0');
INSERT INTO `chat` VALUES ('34', 'ysw111', '234567', '2020-05-26 00:30:54', 'hellow8', '0');
INSERT INTO `chat` VALUES ('35', 'ysw111', 'ysw222', '2020-05-26 01:06:23', 'a', '0');
INSERT INTO `chat` VALUES ('36', 'ysw111', '234567', '2020-05-27 09:56:48', '啊啊', '0');

-- ----------------------------
-- Table structure for `deal`
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `did` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dpublisher` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dpet` bigint(20) NOT NULL,
  `dstate` int(1) DEFAULT NULL,
  `ddetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dprice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of deal
-- ----------------------------
INSERT INTO `deal` VALUES ('1', 'ysw111', '1', '1', null, '1200.00');
INSERT INTO `deal` VALUES ('2', 'ysw111', '12', '1', null, '4000.00');
INSERT INTO `deal` VALUES ('3', '345678', '5', '1', null, '3000.00');
INSERT INTO `deal` VALUES ('4', '234567', '4', '1', null, '2000.00');
INSERT INTO `deal` VALUES ('5', '123456', '8', '1', null, '3000.00');
INSERT INTO `deal` VALUES ('9', 'ysw111', '6', '1', null, '2300.00');

-- ----------------------------
-- Table structure for `essay`
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `eid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `eeid` bigint(20) DEFAULT NULL COMMENT '上一层的eid',
  `etitle` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `edetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `elike` int(10) DEFAULT '0',
  `eimg` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES ('1', '123456', null, '狗狗和猫猫谁更爱主人一点?', '关于猫狗宠物的辩论从未休止，如今又有了新主题：狗和猫，到底谁更爱主人？ 科学研究说话了，狗派和猫派到底谁赢？\r\n养狗和养猫的主人长年争执不休，彼此争论「狗狗更爱主人」、「不要看猫咪傲娇，其实它们更爱主人」。大家来讨论一下狗狗和猫猫谁更爱主人', '1', 'essay1.png');
INSERT INTO `essay` VALUES ('2', 'ysw111', null, '我的狗狗四五天不吃饭只喝水、没有精神、鼻子干、天气冷还是喜欢', '我的狗狗四五天不吃饭只喝水、没有精神、鼻子干、天气冷还是喜欢睡在阴凉甚至有水的地方、目光呆滞，后面第四五天有点发抖，眼角有点眼屎、眼睛有红色血丝，已经打过三次针，但还不见好转，求有经验的养狗达人看看要喂什么药', '1', '12112.png');
INSERT INTO `essay` VALUES ('3', '234567', null, '狗子细小住院期间我应该问医生什么样的问题？', '养的狗子是条串串，狗子住院一天265，我应该问宠物医院医生什么样的问题？新手养狗，狗子十个月了，虽然是串串但是从满月开始养，体内体外都驱过虫，就是没打疫苗，狗子被邻居家的狗传染了细小，住院4天了，昨天下午和今天早上拉稀了，带点血', '0', 'xixiaogou.png');
INSERT INTO `essay` VALUES ('5', '345678', '1', null, '我觉得是狗更爱自己的主人', '0', null);
INSERT INTO `essay` VALUES ('9', '234567', '1', null, '肯定是猫更爱自己的主人啊，你们要相信我啊', '0', null);
INSERT INTO `essay` VALUES ('11', '234567', '1', null, '根据调查显示，猫更爱自己的主人', '0', null);
INSERT INTO `essay` VALUES ('13', '234567', '1', null, '楼上的那位，你把调查证据贴出来好吧。反正我听到的证据是狗更爱自己的主人', '0', null);
INSERT INTO `essay` VALUES ('18', '234567', '1', null, '楼上争吵的好凶啊，大家冷静冷静。', null, null);
INSERT INTO `essay` VALUES ('20', '234567', '2', null, '现在好了么？我家狗子也是差不多 喝水很多好瘦', '0', null);
INSERT INTO `essay` VALUES ('25', 'ysw111', null, '请问一下这是什么狗狗，一月份路边捡的，挺可怜的，现在5月了', '请问一下这是什么狗狗，一月份路边捡的，挺可怜的，现在5月了', '0', '7a01fc042a0047f28f09b6c894e3a603.png');
INSERT INTO `essay` VALUES ('26', 'ysw111', null, '我家泰迪两岁半第一次发情配种 记录过程', '2020年2月26日 发情期开始 ~2020年3月6日 去灰色公泰迪家配第一次 都是微小型犬 我家Dei萌是灰黑色 毛量很多 很蓬松 所以看起来大点 ~', '0', 'd4ac022198ba46739966cc237c4fce28.png');
INSERT INTO `essay` VALUES ('28', 'ysw111', null, '这是金毛还是拉布拉多？', '朋友托我养几天这两条狗，这狗是他几年前捡到的，所以他也不清楚这是什么狗，求懂的人。', '0', '992795da649c48c68710036a4bdc58c4.png');
INSERT INTO `essay` VALUES ('29', 'ysw111', null, '狗狗脖子痛有点抬不起来', '前几天一抱他就叫，现在知道他是脖子痛了，去医院检查了骨头这些都没问题，吃饭这个都很正常。就是现在头有点抬不起来了，走路也不太想走了就喜欢趴着，怎么办啊有哪位大神指导这是什么原因吗。', '0', '82c3fac184fd499bb4e2365cb2b024f0.png');
INSERT INTO `essay` VALUES ('31', 'ysw111', null, '大家能否帮我看看一下这是什么狗或者是什么串', '去医院检查了，说骨头这些都没事，医生怎么按他都不叫，一回家我在他脖子上动一下就叫，自己睡觉的时候动下也叫，一点精神也没有，怎么办啊', '0', '4d3c236bf2784d9682e22ac1e0a196e9.png');
INSERT INTO `essay` VALUES ('32', 'ysw111', null, '捡了条狗狗能活吗？', '不知道多大了？没牙，不怎么会走路，买的宠物羊奶它不喝！', '0', '300a2acb2fa046b0a8487d38b4911979.png');
INSERT INTO `essay` VALUES ('38', 'ysw222', '1', null, '我觉得狗狗更好', '0', null);
INSERT INTO `essay` VALUES ('39', 'ysw111', null, '想问一下 我的狗子我一摸他他就想用嘴咬我', '想问一下 我的狗子我一摸他他就想用嘴咬我 我知道他和我玩 咬的也不疼 但是偶尔也会划一道红 打也没用 反而会用力咬 我就想正常的摸摸它 真难 怎么办', '0', '637dc66054354b298a009444b3fca467.png');
INSERT INTO `essay` VALUES ('40', 'ysw111', '1', null, 'sss', '0', null);

-- ----------------------------
-- Table structure for `mission`
-- ----------------------------
DROP TABLE IF EXISTS `mission`;
CREATE TABLE `mission` (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `mpublisher` varchar(160) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mreceiver` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mtitle` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mdetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mstate` bigint(20) DEFAULT NULL,
  `mdeadline` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of mission
-- ----------------------------
INSERT INTO `mission` VALUES ('2', '345678', '', '帮我带狗狗去看下病', '我有事情没办法带狗狗去看病，所以希望有个人能带它去宠物医院看病。 狗狗的情况是什么也不吃，很虚弱。', '1', '2020-07-10 21:15:13');
INSERT INTO `mission` VALUES ('3', '345678', '', '带我家小猪出去逛一下', '猪是那种迷你猪，很可爱的，也不会乱跑，把它抱在怀里就行了', '1', '2020-06-26 09:40:21');
INSERT INTO `mission` VALUES ('4', '123456', null, '帮我把狗狗带去打疫苗', '医院在杭州市江干区的中医院，医院去打疫苗的狗狗比较多，可能得多等一会，具体情况可以电话联系', '1', '2020-06-28 09:48:51');
INSERT INTO `mission` VALUES ('5', 'ysw111', null, '帮我买包狗粮', '得要xxx牌子的狗粮，得去实体店买，网上有些是假的，我不放心。', '0', '2020-07-25 16:00:54');
INSERT INTO `mission` VALUES ('16', '345678', '123456', null, null, '3', null);
INSERT INTO `mission` VALUES ('21', '345678', '234567', null, null, '3', null);
INSERT INTO `mission` VALUES ('24', '345678', '123456', null, null, '2', null);
INSERT INTO `mission` VALUES ('31', '123456', 'ysw111', null, null, '4', null);
INSERT INTO `mission` VALUES ('32', '123456', null, '能帮我带宠物去看病吗', '看病的地点在下沙宠物医院', '0', '2020-08-27 00:00:00');
INSERT INTO `mission` VALUES ('33', '123456', null, '帮我照顾下宠物', '我家的地址在xx市xx县xx街道xx小区xx号。宠物是一只小田鼠。', '0', '2020-08-09 00:00:00');
INSERT INTO `mission` VALUES ('34', '123456', null, '过几天带我的宠物打个疫苗', '宠物医院没开门，新买的狗子我能不能自个儿给打疫苗，所以过几天需要个人带我的宠物去打个疫苗。狗狗还是很乖的，它叫小白，稍微熟悉一下就会跟着你了。我家的地址：杭州下沙xx小区xx幢xx单元xx号。 宠物医院：杭州下沙宠物医院。谢谢了，报酬好说，只要能打好疫苗', '1', '2020-07-20 00:00:00');
INSERT INTO `mission` VALUES ('35', 'ysw222', null, '照顾宠物', '帮我照顾一下宠物，很乖的，地址：西湖区xx小区xx号', '0', '2020-06-11 00:00:00');
INSERT INTO `mission` VALUES ('36', 'ysw222', null, '帮我照顾下猫', '猫很乖就是最近不怎么吃饭，要细心照顾。过两天我出差，需要个人帮忙带下猫', '0', '2020-06-10 00:00:00');
INSERT INTO `mission` VALUES ('37', 'ysw222', null, '帮我照顾下狗狗', '狗狗很乖的，但得好好照顾。', '0', '2020-06-19 00:00:00');
INSERT INTO `mission` VALUES ('39', '123456', 'ysw222', null, null, '4', null);
INSERT INTO `mission` VALUES ('40', '123456', 'ysw111', null, null, '34', null);
INSERT INTO `mission` VALUES ('41', '345678', 'ysw111', null, null, '3', null);
INSERT INTO `mission` VALUES ('42', '345678', 'ysw111', null, null, '3', null);
INSERT INTO `mission` VALUES ('43', '345678', 'ysw111', null, null, '3', null);
INSERT INTO `mission` VALUES ('44', '345678', 'ysw111', null, null, '3', null);

-- ----------------------------
-- Table structure for `pair`
-- ----------------------------
DROP TABLE IF EXISTS `pair`;
CREATE TABLE `pair` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ppublisher` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `preceiver` varchar(160) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ppet` bigint(20) DEFAULT NULL,
  `pstate` int(1) DEFAULT NULL,
  `pdetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of pair
-- ----------------------------
INSERT INTO `pair` VALUES ('1', 'ysw111', null, '2', '1', '母藏獒，想要找一条公的配对。价格好说，主要血脉要纯');
INSERT INTO `pair` VALUES ('2', 'ysw111', null, '1', '1', '纯种公哈士奇，配对一次需要支付100元钱');
INSERT INTO `pair` VALUES ('7', 'ysw111', null, '6', '1', '求一只公布偶猫配对，价格好商量');
INSERT INTO `pair` VALUES ('10', '234567', 'ysw111', '4', '1', null);
INSERT INTO `pair` VALUES ('11', 'ysw111', '123456', '2', '1', null);
INSERT INTO `pair` VALUES ('12', 'ysw111', '234567', '2', '1', null);
INSERT INTO `pair` VALUES ('18', '234567', 'ysw111', '4', '1', null);
INSERT INTO `pair` VALUES ('26', 'ysw222', null, '16', '1', '求一只公秋田犬');
INSERT INTO `pair` VALUES ('27', 'ysw222', null, '14', '1', '求一只公吉娃娃');
INSERT INTO `pair` VALUES ('28', 'ysw222', null, '13', '1', '求一只母杜宾犬');
INSERT INTO `pair` VALUES ('29', '123456', null, '19', '1', '有没有健康的公杜宾犬');
INSERT INTO `pair` VALUES ('30', '123456', null, '18', '1', '求一只博美犬');
INSERT INTO `pair` VALUES ('31', '123456', null, '17', '1', '求一只蝴蝶犬');
INSERT INTO `pair` VALUES ('32', '123456', null, '8', '1', '求一只公松狮');
INSERT INTO `pair` VALUES ('33', '123456', null, '3', '1', '求一只公贵宾犬');
INSERT INTO `pair` VALUES ('34', 'ysw222', null, '25', '1', '求一只异国短尾猫');
INSERT INTO `pair` VALUES ('35', 'ysw222', null, '24', '1', '求一只公孟买猫');
INSERT INTO `pair` VALUES ('36', '234567', null, '26', '1', '求一只俄罗斯蓝猫，价格好说，宠物得身体健康，无遗传病');
INSERT INTO `pair` VALUES ('37', '234567', null, '21', '1', '求一只英国短尾猫，价格好说，最好无遗传病');
INSERT INTO `pair` VALUES ('38', '234567', null, '20', '1', '求一只苏格兰折耳猫，最好无遗传病，年龄别太大，毛色得好看点，不想要那种杂色的猫，血不纯。价格可以出到400，或者如果有猫出生的话，送你一只。');
INSERT INTO `pair` VALUES ('39', 'ysw222', null, '27', '1', '求一只母哈士奇');
INSERT INTO `pair` VALUES ('40', 'ysw111', null, '15', '1', 'fffa');
INSERT INTO `pair` VALUES ('41', 'ysw222', 'ysw111', '27', '1', null);
INSERT INTO `pair` VALUES ('42', 'ysw111', null, '6', '1', '求一只公布偶猫配对，价格好商量');
INSERT INTO `pair` VALUES ('43', 'ysw111', null, '6', '1', '求一只公布偶猫配对，价格好商量');

-- ----------------------------
-- Table structure for `pet`
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pbirthday` date DEFAULT NULL,
  `phealth` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pbreed` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pdetail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pphoto` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES ('1', 'ysw111', '小哈', '2019-05-01', '健康', '哈士奇', '哈士奇是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。哈士奇名字是源自其独特的嘶哑叫声 [1] 。哈士奇性格多变，有的极端胆小，也有的极端暴力，进入人类社会和家庭的哈士奇，都已经没有了这种极端的性格，比较温顺，是一种流行于全球的宠物犬。哈士奇、金毛犬与拉布拉多并列为三大无攻击性犬类 [2] ，被世界各地人们广泛饲养，并在全球范围内有大量该犬种的赛事。', 'dog1.jpg');
INSERT INTO `pet` VALUES ('2', 'ysw111', '小藏', '2018-01-03', '健康', '藏獒', '这是一只公藏獒', 'zangao1.png');
INSERT INTO `pet` VALUES ('3', '123456', '小贵', '2019-05-07', '健康', '贵宾犬', '贵宾犬（Poodle），也称“贵妇犬”，又称“卷毛狗”，在德语中，Pudel是“水花飞溅”的意思，是犬亚科犬属的一种动物。贵宾犬的来源就像它为了拖出猎禽所涉过的水一样浑浊不清。', 'dog3.jpg');
INSERT INTO `pet` VALUES ('4', '234567', '小松', '2019-05-05', '生病了', '松狮', '松狮犬是一种非常时髦的宠物和守护犬，原产中国，有2000多年的历史。据说唐朝时它最受皇帝宠爱，也最为繁盛。过去，曾有一个中国皇帝拥有10万猎人和2500头松狮犬的说法', 'dog4.jpg');
INSERT INTO `pet` VALUES ('5', '345678', '小边', '2019-05-06', '健康', '边牧', '边境牧羊犬（Border Collie），原产于苏格兰边境，为柯利牧羊犬的一种，具有强烈的牧羊本能，天性聪颖、善于察言观色，能准确明白主人的指示，可借由眼神的注视而驱动羊群移动或旋转，被当成牧羊犬已有多年的历史，在世界犬种智商排行第一名。', 'dog5.jpg');
INSERT INTO `pet` VALUES ('6', 'ysw111', '小布偶', '2019-05-04', '健康', '布偶猫', '布偶猫是猫中较大、较重的一种。它的头呈V形，眼大而圆，被毛丰厚，四肢粗大，尾长，身体柔软，多为三色或双色猫 [1]  。布偶猫抱起来像软绵绵的布偶，而且对人非常友善。它性格大胆，不知道什么叫恐惧，而且对疼痛的忍耐性相当强，常被误认为缺乏疼痛感，因此很能容忍孩子的玩弄，是非常理想的家庭宠物', 'cat1.jpg');
INSERT INTO `pet` VALUES ('7', 'ysw111', '小暹', '2019-05-03', '健康', '暹罗猫', '暹（xiān）罗猫是世界著名的短毛猫，也是短毛猫的代表品种。种族原产于暹罗（今泰国），故名暹罗猫。在200多年前，这种珍贵的猫仅在泰国的皇宫和大寺院中饲养，是足不出户的贵族。暹罗猫能够较好适应主人当地的气候，且性格刚烈好动，机智灵活，好奇心特强，善解人意。', 'cat2.jpg');
INSERT INTO `pet` VALUES ('8', '123456', '大松', '2019-05-02', '健康', '松狮', '就一只普通的松狮', 'dog4.jpg');
INSERT INTO `pet` VALUES ('12', 'ysw111', '柴柴', '2019-02-11', '健康', '柴犬', '柴犬是体型中等并且又最古老的犬。柴犬能够应付陡峭的丘陵和山脉的斜坡，拥有灵敏的感', 'b6d23ddb7664452ba3cce2a7c8022d8a.jpg');
INSERT INTO `pet` VALUES ('13', 'ysw222', '杜宾', '2018-05-16', '健康', '杜宾犬', '这是杜宾犬', 'c740b2a82bf144e8955b4c72def622d3.png');
INSERT INTO `pet` VALUES ('14', 'ysw222', '小吉', '2019-11-01', '健康', '吉娃娃', '这是一只吉娃娃', 'dog6.jpg');
INSERT INTO `pet` VALUES ('15', 'ysw111', '德牧', '2018-02-08', '健康', '德国牧羊犬', '这是一只德国牧羊犬', 'dog7.jpg');
INSERT INTO `pet` VALUES ('16', 'ysw222', '秋田', '2019-03-14', '健康', '秋田犬', '这是一只秋田犬', 'dog8.jpg');
INSERT INTO `pet` VALUES ('17', '123456', '小蝴蝶', '2019-06-21', '健康', '蝴蝶犬', '这是一只蝴蝶犬', 'dog9.jpg');
INSERT INTO `pet` VALUES ('18', '123456', '小博', '2017-07-14', '健康', '博美犬', '这是博美犬', 'dog10.jpg');
INSERT INTO `pet` VALUES ('19', '123456', '小杜', '2017-07-15', '健康', '杜宾犬', '这是一只杜宾犬', 'dog11.jpg');
INSERT INTO `pet` VALUES ('20', '234567', '小折耳', '2018-06-28', '健康', '苏格兰折耳猫', '这是一只苏格兰折耳猫', 'cat3.jpg');
INSERT INTO `pet` VALUES ('21', '234567', '小小', '2019-01-22', '健康', '英国短尾猫', '这是一只英国短尾猫', 'cat4.jpg');
INSERT INTO `pet` VALUES ('22', '345678', '大白', '2019-02-06', '健康', '波斯猫', '这是一只波斯猫', 'cat5.jpg');
INSERT INTO `pet` VALUES ('23', '345678', '跳跳', '2019-02-11', '健康', '英国短尾猫', '这是一只英国短尾猫', 'cat6.jpg');
INSERT INTO `pet` VALUES ('24', 'ysw222', '小黑', '2019-03-22', '健康', '孟买猫', '这是一只孟买猫', 'cat7.jpg');
INSERT INTO `pet` VALUES ('25', 'ysw222', '呆儿', '2018-02-22', '健康', '异国短尾猫', '这是一只异国短尾猫', 'cat8.jpg');
INSERT INTO `pet` VALUES ('26', '234567', '小蓝', '2019-03-19', '健康', '俄罗斯蓝猫', '这是一只俄罗斯蓝猫', 'cat9.jpg');
INSERT INTO `pet` VALUES ('27', 'ysw222', '哈哈', '2018-03-14', '健康', '哈士奇', '这是一条公哈士奇', '3af8ef66fc72421e8b990b3ab583dd8e.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(160) COLLATE utf8mb4_unicode_ci NOT NULL,
  `uname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `upassword` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `usex` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT '保密',
  `uphoto` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uphone` bigint(16) DEFAULT NULL,
  `uintegral` bigint(20) DEFAULT '0' COMMENT '积分',
  `ucredit` bigint(20) DEFAULT '0' COMMENT '荣誉',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', '李雷', '111111', '男', '4_min.jpg', '13277877277', '0', '0');
INSERT INTO `user` VALUES ('134567', '文逍', '111111', '保密', null, null, '0', '0');
INSERT INTO `user` VALUES ('234567', '红洪', '111111', '男', '3_min.jpg', '13988981311', '0', '0');
INSERT INTO `user` VALUES ('3', 'ysw', 'yaaa', '保密', null, null, '0', '0');
INSERT INTO `user` VALUES ('345678', '铁妞', '111111', '女', '2_min.jpg', '15990882131', '0', '0');
INSERT INTO `user` VALUES ('456789', '章天', '111111', '保密', null, null, '0', '0');
INSERT INTO `user` VALUES ('ysw111', '余盛伟', '111111', '保密', '043d330df06741f78de7d0cfc337aa5c.jpg', '13854547474', '0', '0');
INSERT INTO `user` VALUES ('ysw222', '章红', '111111', '保密', null, null, '0', '0');
