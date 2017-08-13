/*
Navicat MySQL Data Transfer

Source Server         : Leyao
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : leyao

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-08-13 19:25:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_event_page
-- ----------------------------
DROP TABLE IF EXISTS `t_event_page`;
CREATE TABLE `t_event_page` (
  `h_event_id` bigint(20) unsigned NOT NULL COMMENT '事件banner页信息相关记录序列代理键',
  `s_event_category_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件种类编码',
  `r_event_category_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件种类定义',
  `s_event_type_cd` int(20) NOT NULL DEFAULT '0' COMMENT '事件类型编码',
  `r_event_type_desc` varchar(500) NOT NULL DEFAULT '?' COMMENT '事件类型定义',
  `s_event_title_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件标题url',
  `s_event_content_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件内容url',
  `s_event_sub_content_1_url` varchar(255) NOT NULL DEFAULT '?' COMMENT '事件子内容1相关url',
  `s_event_search_content_txt` text NOT NULL COMMENT '事件搜索内容，存放搜索相关关键字集合',
  `s_event_active_ind` int(20) NOT NULL DEFAULT '0' COMMENT '事件激活状态',
  `create_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' COMMENT '系统创建时间',
  `update_ts` timestamp NULL DEFAULT '1999-12-31 16:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '系统更新时间',
  PRIMARY KEY (`h_event_id`),
  KEY `idx_create_ts` (`create_ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乐谣创建以及更新事件时更新，提供搜索引擎信息入口，将所有事件相关关键词全部存放于字段内s_event_search_content_txt';

-- ----------------------------
-- Records of t_event_page
-- ----------------------------
INSERT INTO `t_event_page` VALUES ('1', '1', 'd1', '1', 'vedio', 'vedio/1.mp4', 'vedio/1.mp4', '?', '1', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
INSERT INTO `t_event_page` VALUES ('2', '1', 'd1', '1', 'vedio', 'vedio/2.mp4', 'vedio/2.mp4', '?', '2', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
INSERT INTO `t_event_page` VALUES ('3', '1', 'd1', '1', 'vedio', 'vedio/3.mp4', 'vedio/3.mp4', '?', '3', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
INSERT INTO `t_event_page` VALUES ('4', '1', 'd1', '2', 'audio', 'audio/1.mp3', 'audio/1.mp3', '?', '4', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
INSERT INTO `t_event_page` VALUES ('5', '1', 'd1', '2', 'audio', 'audio/2.mp3', 'audio/2.mp3', '?', '5', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
INSERT INTO `t_event_page` VALUES ('6', '1', 'd1', '2', 'audio', 'audio/3.mp3', 'audio/3.mp3', '?', '6', '0', '1999-12-31 16:00:00', '1999-12-31 16:00:00');
