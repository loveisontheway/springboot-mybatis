/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-12-25 15:42:07
*/

CREATE DATABASE IF NOT EXISTS `uip` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `uip`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for md_administrative_region
-- ----------------------------
DROP TABLE IF EXISTS `md_administrative_region`;
CREATE TABLE `md_administrative_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` bigint(12) NOT NULL COMMENT '行政区划编码',
  `area_name` varchar(128) NOT NULL COMMENT '行政区划名称',
  `category` int(3) DEFAULT NULL COMMENT '城乡分类代码',
  `change_reason` varchar(300) DEFAULT NULL COMMENT '行政区域变更原因',
  `city_id` bigint(12) DEFAULT NULL COMMENT '市（地区、自治州、盟）代码',
  `city_name` varchar(128) DEFAULT NULL COMMENT '市（地区、自治州、盟）名称',
  `county_id` bigint(12) DEFAULT NULL COMMENT '县（市辖区、县级市、旗）代码',
  `county_name` varchar(128) DEFAULT NULL COMMENT '县（市辖区、县级市、旗）名称',
  `create_id` varchar(32) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `full_name` varchar(256) NOT NULL COMMENT '行政区划全称',
  `grade` int(1) NOT NULL COMMENT '等级（省1、市2、县3、镇4、村5）',
  `latitude` double(20,12) NOT NULL COMMENT '纬度',
  `longitude` double(20,12) NOT NULL COMMENT '经度',
  `modify_id` varchar(32) DEFAULT NULL COMMENT '修改者id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `native_code` varchar(200) DEFAULT NULL COMMENT '行政区划原代码',
  `native_name` varchar(200) DEFAULT NULL COMMENT '行政区划原名称',
  `other_code` varchar(100) DEFAULT NULL COMMENT '第三方行政区划编码',
  `parent_code` bigint(12) DEFAULT NULL COMMENT '父级行政区划编码',
  `province_id` bigint(12) NOT NULL COMMENT '省（自治区、直辖市、特别行政区）代码',
  `province_name` varchar(128) NOT NULL COMMENT '省（自治区、直辖市、特别行政区）名称',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `row_version` varchar(30) DEFAULT NULL COMMENT '行版本，记录数据版本号',
  `sort_order` int(5) DEFAULT NULL COMMENT '排序方式',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '状态值（0启用、1停用）',
  `town_id` bigint(12) DEFAULT NULL COMMENT '乡、镇（街道办事处）代码',
  `town_name` varchar(128) DEFAULT NULL COMMENT '乡、镇（街道办事处）名称',
  `village_id` bigint(12) DEFAULT NULL COMMENT '村（居民委员会、村民委员会）代码',
  `village_name` varchar(128) DEFAULT NULL COMMENT '村（居民委员会、村民委员会）名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='行政区划代码表';

-- ----------------------------
-- Records of md_administrative_region
-- ----------------------------
INSERT INTO `md_administrative_region` VALUES ('1', '330000000000', '浙江省', null, null, null, null, null, null, '1', '2017-12-25 15:04:51', '浙江省', '1', '120.168620000000', '30.294125000000', null, null, null, null, null, null, '330000000000', '浙江省', null, null, '0', '0', null, null, null, null);
INSERT INTO `md_administrative_region` VALUES ('2', '330100000000', '杭州市', null, null, '330100000000', '杭州市', null, '', '1', '2017-12-25 15:04:51', '浙江省杭州市', '2', '120.168620000000', '30.294125000000', null, null, null, null, null, '330000000000', '330000000000', '浙江省', null, null, '0', '0', null, null, null, null);
INSERT INTO `md_administrative_region` VALUES ('3', '330102000000', '上城区', null, null, '330100000000', '杭州市', '330102000000', '上城区', '1', '2017-12-25 15:04:51', '浙江省杭州市上城区', '3', '120.164646000000', '30.245018000000', null, null, null, null, null, '330100000000', '330000000000', '浙江省', null, null, '0', '0', null, null, null, null);
INSERT INTO `md_administrative_region` VALUES ('4', '330102001000', '清波街道', null, null, '330100000000', '杭州市', '330102000000', '上城区', '1', '2017-12-25 15:04:51', '浙江省杭州市上城区清波街道', '4', '120.158158200000', '30.241213860000', null, null, null, null, null, '330102000000', '330000000000', '浙江省', null, null, '0', '0', '330102001000', '清波街道', null, null);
INSERT INTO `md_administrative_region` VALUES ('5', '330102001051', '清波门社区', '111', null, '330100000000', '杭州市', '330102000000', '上城区', '1', '2017-12-25 15:04:51', '浙江省杭州市上城区清波街道清波门社区', '5', '120.165271000000', '30.243223000000', null, null, null, null, null, '330102001000', '330000000000', '浙江省', null, null, '0', '0', '330102001000', '清波街道', '330102001051', '清波门社区');
