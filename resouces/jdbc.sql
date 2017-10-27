/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-10-27 14:25:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fc_history
-- ----------------------------
DROP TABLE IF EXISTS `fc_history`;
CREATE TABLE `fc_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `platform_id` int(5) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `invest_amount` decimal(10,2) DEFAULT NULL COMMENT '投资金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券',
  `annualized_return` decimal(10,4) DEFAULT NULL COMMENT '年化收益率',
  `invest_time` bigint(10) DEFAULT NULL COMMENT '计息时间',
  `increase_rates` decimal(10,4) DEFAULT NULL COMMENT '加息率',
  `increase_time` bigint(10) DEFAULT NULL COMMENT '加息天数',
  `payment_time` bigint(10) DEFAULT NULL COMMENT '起息/到账总时间',
  `invest_income` decimal(10,2) DEFAULT NULL COMMENT '投资收益',
  `increase_income` decimal(10,2) DEFAULT NULL COMMENT '加息收益',
  `actual_invest_amount` decimal(10,2) DEFAULT NULL COMMENT '实际投资金额',
  `actual_invest_income` decimal(10,2) DEFAULT NULL COMMENT '实际收益',
  `actual_annualized_return` decimal(10,4) DEFAULT NULL COMMENT '实际年化收益率',
  PRIMARY KEY (`id`),
  KEY `user` (`user_id`) USING BTREE,
  KEY `平台id` (`platform_id`),
  CONSTRAINT `用户id` FOREIGN KEY (`user_id`) REFERENCES `fc_user` (`id`),
  CONSTRAINT `平台id` FOREIGN KEY (`platform_id`) REFERENCES `fc_platform` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fc_history
-- ----------------------------
INSERT INTO `fc_history` VALUES ('12', '1', '1', null, '10000.00', '28.00', '0.1000', '15', '0.0000', '0', '0', '41.10', '0.00', '9972.00', '69.10', '0.1686');
INSERT INTO `fc_history` VALUES ('13', '1', '1', null, '10000.00', '28.00', '0.1000', '15', '0.0000', '0', '0', '41.10', '0.00', '9972.00', '69.10', '0.1686');
INSERT INTO `fc_history` VALUES ('94', '0', null, null, '0.00', '0.00', '0.0000', null, '0.0000', null, null, '0.00', '0.00', '0.00', '0.00', '0.0000');

-- ----------------------------
-- Table structure for fc_platform
-- ----------------------------
DROP TABLE IF EXISTS `fc_platform`;
CREATE TABLE `fc_platform` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `platformName` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fc_platform
-- ----------------------------
INSERT INTO `fc_platform` VALUES ('1', '洋钱罐');
INSERT INTO `fc_platform` VALUES ('3', '友金所');
INSERT INTO `fc_platform` VALUES ('4', '口袋理财');
INSERT INTO `fc_platform` VALUES ('5', '随手记');

-- ----------------------------
-- Table structure for fc_user
-- ----------------------------
DROP TABLE IF EXISTS `fc_user`;
CREATE TABLE `fc_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nickName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fc_user
-- ----------------------------
INSERT INTO `fc_user` VALUES ('0', '13556004822', '123', null);
INSERT INTO `fc_user` VALUES ('1', '13556004824', '123', null);
