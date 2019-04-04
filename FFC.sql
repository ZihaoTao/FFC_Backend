/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 192.168.0.21:3306
 Source Schema         : FFC

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 16/01/2019 20:48:36
*/


-- ----------------------------
-- Table structure for FFC_product
-- ----------------------------
DROP TABLE IF EXISTS `FFC_event`;
CREATE TABLE `FFC_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'product id',
  `category_id` int(11) NOT NULL COMMENT 'catagory id, PRIMARY KEY in FFC_category',
  `name` varchar(100) NOT NULL COMMENT 'product name',
  `subtitle` varchar(200) DEFAULT NULL COMMENT 'subtitle',
  `main_image` varchar(500) DEFAULT NULL COMMENT 'main image',
  `sub_images` text COMMENT 'subimage',
  `detail` text COMMENT 'detail',
  `time` datetime DEFAULT NULL COMMENT 'time',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FFC_product
-- ----------------------------
BEGIN;
INSERT INTO `FFC_event` VALUES (1, 1, 'UNEA4 x Future of Fashion. Now.', '- Event Overview', '803696d1-c48e-47fb-9a83-298ec4e11ae7.jpg', '', '<p>\"We at Rachel Allan support Elephantasia because we want to help bring awareness to the many issues surrounding and effecting elephants, such as being poached for their ivory tusks or losing large amounts of their habitats due to human expansion.\"</p>', '2019-04-13 21:45:40', '2017-04-13 21:45:40', '2017-04-13 21:45:41');
