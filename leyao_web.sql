/*
Navicat MySQL Data Transfer

Source Server         : Leyao
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : leyao

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-08-13 19:26:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for leyao_web
-- ----------------------------
DROP TABLE IF EXISTS `leyao_web`;
CREATE TABLE `leyao_web` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_parent_id` int(11) NOT NULL DEFAULT '0',
  `item_type` int(11) NOT NULL DEFAULT '1' COMMENT '1:item; 2:header; 3:footer; 4:audio; 5:vedio',
  `item_name` varchar(50) NOT NULL DEFAULT '?',
  `item_url` varchar(100) NOT NULL DEFAULT '?',
  `item_order` int(11) NOT NULL DEFAULT '-1',
  `item_length` int(11) DEFAULT '-1',
  `item_width` int(11) DEFAULT '-1',
  `is_delete` int(11) NOT NULL DEFAULT '0',
  `create_username` varchar(30) DEFAULT NULL,
  `create_timestamp` datetime DEFAULT NULL,
  `update_username` varchar(30) DEFAULT NULL,
  `update_timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leyao_web
-- ----------------------------
INSERT INTO `leyao_web` VALUES ('1', '0', '3', 'f1', 'footer/f1.jpg', '1', '950', '300', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('2', '0', '2', 'h1', 'header/h1.jpg', '1', '72', '44', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('3', '0', '2', 'h2', 'header/h2.jpg', '1', '72', '44', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('4', '0', '2', 'h3', 'header/h3.jpg', '1', '72', '44', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('6', '0', '1', 'item_list1', 'item_list/item_list1.jpg', '1', '4482', '2800', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('7', '0', '1', 'item_list2', 'item_list/item_list2.jpg', '2', '4482', '2800', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('8', '0', '1', 'item_list3', 'item_list/item_list3.jpg', '3', '4482', '2800', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('9', '0', '1', 'item_list4', 'item_list/item_list4.jpg', '4', '4482', '2800', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('10', '0', '1', 'item_list5', 'item_list/item_list5.jpg', '5', '4482', '2800', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('11', '1', '1', 'item1', 'items/item1.jpg', '1', '950', '1200', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('12', '1', '1', 'item2', 'items/item2.jpg', '1', '950', '1200', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('13', '3', '1', 'item3', 'items/item3.jpg', '0', '950', '1500', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('14', '3', '1', 'item4', 'items/item4.jpg', '1', '950', '1200', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('16', '6', '1', 'item6', 'items/item6.jpg', '1', '950', '1500', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('17', '7', '1', 'item7', 'items/item7.jpg', '1', '950', '1500', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('18', '8', '1', 'item8', 'items/item8.jpg', '1', '950', '1500', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('19', '9', '1', 'item9', 'items/item9.jpg', '1', '950', '1500', '0', null, null, null, null);
INSERT INTO `leyao_web` VALUES ('20', '10', '1', 'item10', 'items/item10.jpg', '1', '950', '1500', '0', null, null, null, null);
