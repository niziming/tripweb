/*
Navicat MySQL Data Transfer

Source Server         : localhost@ziming
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : trip_web_db

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-25 14:22:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `lr_id` int(11) NOT NULL AUTO_INCREMENT,
  `lr_name` varchar(100) DEFAULT NULL,
  `lr_date` varchar(100) DEFAULT NULL,
  `lr_content` varchar(100) DEFAULT NULL,
  `lr_for_name` varchar(100) DEFAULT NULL,
  `lr_for_words` varchar(100) DEFAULT NULL,
  `lr_for_reply` varchar(100) DEFAULT NULL,
  `lr_for_article_id` varchar(100) DEFAULT NULL,
  `lr_forumId` varchar(100) DEFAULT NULL,
  `lr_hotel_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for tp_admin
-- ----------------------------
DROP TABLE IF EXISTS `tp_admin`;
CREATE TABLE `tp_admin` (
  `tp_aid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_aname` varchar(100) DEFAULT NULL,
  `tp_aemail` varchar(100) DEFAULT NULL,
  `tp_apwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_admin
-- ----------------------------
INSERT INTO `tp_admin` VALUES ('1', 'root', 'root@root.com', 'root');

-- ----------------------------
-- Table structure for tp_forum
-- ----------------------------
DROP TABLE IF EXISTS `tp_forum`;
CREATE TABLE `tp_forum` (
  `tp_fid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_author_id` varchar(100) DEFAULT NULL,
  `tp_author` varchar(100) DEFAULT NULL,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_sub_title` varchar(100) DEFAULT NULL,
  `tp_issue_time` varchar(100) DEFAULT NULL,
  `tp_tag` varchar(100) DEFAULT NULL,
  `tp_tcontent` text,
  PRIMARY KEY (`tp_fid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_forum
-- ----------------------------

-- ----------------------------
-- Table structure for tp_hotel
-- ----------------------------
DROP TABLE IF EXISTS `tp_hotel`;
CREATE TABLE `tp_hotel` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `local` varchar(100) DEFAULT NULL,
  `house_type` varchar(100) DEFAULT NULL,
  `bed_type` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `people_num` varchar(100) DEFAULT NULL,
  `zip` varchar(100) DEFAULT NULL,
  `house_size` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_hotel
-- ----------------------------

-- ----------------------------
-- Table structure for tp_traffic
-- ----------------------------
DROP TABLE IF EXISTS `tp_traffic`;
CREATE TABLE `tp_traffic` (
  `tp_Tid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_type` varchar(100) DEFAULT NULL,
  `tp_current` varchar(100) DEFAULT NULL,
  `tp_destination` varchar(100) DEFAULT NULL,
  `tp_current_time` varchar(100) DEFAULT NULL,
  `tp_arrive_time` varchar(100) DEFAULT NULL,
  `tp_tprice` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_traffic
-- ----------------------------
INSERT INTO `tp_traffic` VALUES ('1', '火车', '北京市', '绵阳市', '2019-05-18 13:05:20', '2019-05-17 14:50:42', '356.0');

-- ----------------------------
-- Table structure for tp_user
-- ----------------------------
DROP TABLE IF EXISTS `tp_user`;
CREATE TABLE `tp_user` (
  `tp_uid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_uname` varchar(100) DEFAULT NULL,
  `tp_uemail` varchar(100) DEFAULT NULL,
  `tp_upwd` varchar(100) DEFAULT NULL,
  `tp_age` varchar(100) DEFAULT NULL,
  `tp_gender` varchar(100) DEFAULT NULL,
  `tp_upic` varchar(100) DEFAULT NULL,
  `tp_phone` varchar(100) DEFAULT NULL,
  `tp_regdate` timestamp NULL DEFAULT NULL,
  `tp_update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`tp_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_user
-- ----------------------------
INSERT INTO `tp_user` VALUES ('1', 'ziming', 'ziming@163.com', 'ziming', '19', null, null, null, null, null);

-- ----------------------------
-- Table structure for tp_viewpoint
-- ----------------------------
DROP TABLE IF EXISTS `tp_viewpoint`;
CREATE TABLE `tp_viewpoint` (
  `tp_vid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_vname` varchar(100) DEFAULT NULL,
  `tp_vtype` varchar(100) DEFAULT NULL,
  `tp_vpic` varchar(100) DEFAULT NULL,
  `tp_vphone` varchar(100) DEFAULT NULL,
  `tp_level` varchar(100) DEFAULT NULL,
  `tp_price` varchar(100) DEFAULT NULL,
  `tp_location` varchar(100) DEFAULT NULL,
  `tp_zip` varchar(100) DEFAULT NULL,
  `tp_opentime` varchar(100) DEFAULT NULL,
  `tp_creatTime` timestamp NULL DEFAULT NULL,
  `tp_vcontent` text,
  PRIMARY KEY (`tp_vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_viewpoint
-- ----------------------------

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `lw_id` int(11) NOT NULL AUTO_INCREMENT,
  `lw_name` varchar(100) DEFAULT NULL,
  `lw_date` varchar(100) DEFAULT NULL,
  `lw_content` varchar(100) DEFAULT NULL,
  `lw_for_name` varchar(100) DEFAULT NULL,
  `lw_for_article_id` varchar(100) DEFAULT NULL,
  `lw_forumId` varchar(100) DEFAULT NULL,
  `lw_hotel_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of words
-- ----------------------------
