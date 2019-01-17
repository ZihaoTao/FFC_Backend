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

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for FFC_category
-- ----------------------------
DROP TABLE IF EXISTS `FFC_category`;
CREATE TABLE `FFC_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `parent_id` int(11) DEFAULT NULL COMMENT 'root: 0',
  `name` varchar(50) DEFAULT NULL COMMENT 'name',
  `status` tinyint(1) DEFAULT '1' COMMENT '1-ons ale,2-off sale',
  `sort_order` int(4) DEFAULT NULL COMMENT 'null : featured',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100039 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FFC_category
-- ----------------------------
BEGIN;
INSERT INTO `FFC_category` VALUES (100001, 0, 'ACCESSORIES', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100002, 0, 'OUTERWEAR', 1, NULL, '2017-03-25 16:46:21', '2017-03-25 16:46:21');
INSERT INTO `FFC_category` VALUES (100003, 0, 'TOP', 1, NULL, '2017-03-25 16:49:53', '2017-03-25 16:49:53');
INSERT INTO `FFC_category` VALUES (100004, 0, 'BOTTOM', 1, NULL, '2017-03-25 16:50:19', '2017-03-25 16:50:19');
INSERT INTO `FFC_category` VALUES (100005, 0, 'SHOES', 1, NULL, '2017-03-25 16:50:29', '2017-03-25 16:50:29');
INSERT INTO `FFC_category` VALUES (100006, 100001, 'HAT', 1, NULL, '2017-03-25 16:52:15', '2017-03-25 16:52:15');
INSERT INTO `FFC_category` VALUES (100007, 100001, 'CAP', 1, NULL, '2017-03-25 16:52:26', '2017-03-25 16:52:26');
INSERT INTO `FFC_category` VALUES (100008, 100001, 'SUNGLASSES', 1, NULL, '2017-03-25 16:52:39', '2017-03-25 16:52:39');
INSERT INTO `FFC_category` VALUES (100009, 100001, 'TIE', 1, NULL, '2017-03-25 16:52:45', '2017-03-25 16:52:45');
INSERT INTO `FFC_category` VALUES (100010, 100001, 'BOWTIE', 1, NULL, '2017-03-25 16:52:54', '2017-03-25 16:52:54');
INSERT INTO `FFC_category` VALUES (100011, 100001, 'SCARF', 1, NULL, '2017-03-25 16:53:18', '2017-03-25 16:53:18');
INSERT INTO `FFC_category` VALUES (100012, 100001, 'BELT', 1, NULL, '2017-03-25 16:53:27', '2017-03-25 16:53:27');
INSERT INTO `FFC_category` VALUES (100013, 100001, 'SOCKS', 1, NULL, '2017-03-25 16:53:35', '2017-03-25 16:53:35');
INSERT INTO `FFC_category` VALUES (100014, 100002, 'JACKET', 1, NULL, '2017-03-25 16:53:56', '2017-03-25 16:53:56');
INSERT INTO `FFC_category` VALUES (100015, 100002, 'COAT', 1, NULL, '2017-03-25 16:54:07', '2017-03-25 16:54:07');
INSERT INTO `FFC_category` VALUES (100016, 100002, 'TRENCHCOAT', 1, NULL, '2017-03-25 16:54:44', '2017-03-25 16:54:44');
INSERT INTO `FFC_category` VALUES (100017, 100002, 'VEST', 1, NULL, '2017-03-25 16:54:51', '2017-03-25 16:54:51');
INSERT INTO `FFC_category` VALUES (100018, 100002, 'SUIT', 1, NULL, '2017-03-25 16:55:02', '2017-03-25 16:55:02');
INSERT INTO `FFC_category` VALUES (100019, 100002, 'BLAZER', 1, NULL, '2017-03-25 16:55:09', '2017-03-25 16:55:09');
INSERT INTO `FFC_category` VALUES (100020, 100003, 'SWEATER', 1, NULL, '2017-03-25 16:55:18', '2017-03-25 16:55:18');
INSERT INTO `FFC_category` VALUES (100021, 100003, 'SWEATERSHIRT', 1, NULL, '2017-03-25 16:55:30', '2017-03-25 16:55:30');
INSERT INTO `FFC_category` VALUES (100022, 100003, 'CARDIGAN', 1, NULL, '2017-03-25 16:55:37', '2017-03-25 16:55:37');
INSERT INTO `FFC_category` VALUES (100023, 100003, 'TANKTOP', 1, NULL, '2017-03-25 16:55:47', '2017-03-25 16:55:47');
INSERT INTO `FFC_category` VALUES (100024, 100003, 'TSHIRT', 1, NULL, '2017-03-25 16:55:56', '2017-03-25 16:55:56');
INSERT INTO `FFC_category` VALUES (100025, 100003, 'SHIRT', 1, NULL, '2017-03-25 16:56:06', '2017-03-25 16:56:06');
INSERT INTO `FFC_category` VALUES (100026, 100004, 'JEANS', 1, NULL, '2017-03-25 16:56:22', '2017-03-25 16:56:22');
INSERT INTO `FFC_category` VALUES (100027, 100004, 'CARGOPANTS', 1, NULL, '2017-03-25 16:56:30', '2017-03-25 16:56:30');
INSERT INTO `FFC_category` VALUES (100028, 100004, 'DRESSPANTS', 1, NULL, '2017-03-25 16:56:37', '2017-03-25 16:56:37');
INSERT INTO `FFC_category` VALUES (100029, 100004, 'SHORTS', 1, NULL, '2017-03-25 16:56:45', '2017-03-25 16:56:45');
INSERT INTO `FFC_category` VALUES (100030, 100004, 'SWEATPANTS', 1, NULL, '2017-03-25 16:57:05', '2017-03-25 16:57:05');
INSERT INTO `FFC_category` VALUES (100031, 100004, 'SKIRT', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100032, 100005, 'SANDALS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100033, 100005, 'SNEAKERS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100034, 100005, 'FLATS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100035, 100005, 'HEELS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100036, 100005, 'SLIPPERS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100037, 100005, 'BOOTS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
INSERT INTO `FFC_category` VALUES (100038, 100005, 'RAINBOOTS', 1, NULL, '2017-03-25 16:46:00', '2017-03-25 16:46:00');
COMMIT;

-- ----------------------------
-- Table structure for FFC_coupons
-- ----------------------------
DROP TABLE IF EXISTS `FFC_coupons`;
CREATE TABLE `FFC_coupons` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL COMMENT 'user id of the coupon',
  `status` int(6) DEFAULT '0' COMMENT '0-unused, 1-being used, 2-used',
  `discount` varchar(50) DEFAULT NULL COMMENT 'discount',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100032 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FFC_coupons
-- ----------------------------
BEGIN;
INSERT INTO `FFC_coupons` VALUES (1, 1, 0, '10', '2016-11-06 16:56:45', '2017-04-04 19:27:36');
COMMIT;

-- ----------------------------
-- Table structure for FFC_product
-- ----------------------------
DROP TABLE IF EXISTS `FFC_product`;
CREATE TABLE `FFC_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'product id',
  `category_id` int(11) NOT NULL COMMENT 'catagory id, PRIMARY KEY in FFC_category',
  `name` varchar(100) NOT NULL COMMENT 'product name',
  `subtitle` varchar(200) DEFAULT NULL COMMENT 'subtitle',
  `main_image` varchar(500) DEFAULT NULL COMMENT 'main image',
  `sub_images` text COMMENT 'subimage',
  `SKU` varchar(500) DEFAULT NULL COMMENT 'main image',
  `detail` text COMMENT 'detail',
  `color` text COMMENT 'Color',
  `from_where` text COMMENT 'Where From',
  `how_made` text COMMENT 'How Made',
  `size_range` text COMMENT 'Size Range',
  `goal` text COMMENT 'Sustainability Goal',
  `cause` text COMMENT 'Global Cause',
  `price` decimal(20,2) NOT NULL COMMENT 'price, two decimals',
  `stock` int(11) NOT NULL COMMENT 'stock',
  `status` int(6) DEFAULT '1' COMMENT '1-on sale 2-off sale 3-deleted',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FFC_product
-- ----------------------------
BEGIN;
INSERT INTO `FFC_product` VALUES (1, 100018, '-Elephantasia Jumpsuit by Clyde', '*ORIGINAL*', '803696d1-c48e-47fb-9a83-298ec4e11ae7.jpg', '8bbe6dba-3db2-4bf9-88b5-d1c25755525e.png', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>\"We at Rachel Allan support Elephantasia because we want to help bring awareness to the many issues surrounding and effecting elephants, such as being poached for their ivory tusks or losing large amounts of their habitats due to human expansion.\"</p>', 'grey', 'Italy', 'silk', 'XS-XL', 'xxx', 'xxx', 960.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (2, 100018, '-Elephantasia Jumpsuit by Rachel Allan', '*ORIGINAL*', '026db7f5-fc31-42a3-8bd6-47bb37748641.jpg', '00bdb85b-3653-43bf-bc5a-626a9d8703c1.png', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>**This is a custom item, please send us your measurements with your order.\n\"We at Rachel Allan support Elephantasia because we want to help bring awareness to the many issues surrounding and effecting elephants, such as being poached for their ivory tusks or losing large amounts of their habitats due to human expansion.\"</p>', 'white', 'Italy', 'silk', 'XS_XL', 'xxx', 'xxx', 960.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (3, 100018, '-Elephantasia Jumpsuit by Rachel Allan', '*ORIGINAL*', '67a5473c-07cc-418a-9072-1912d4af0185.jpg', '0797b8a2-fabe-4749-88ad-4d98d5863a1c.png', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>**This is a custom ordered item, please send us sizes with your purchase.\n\"We at Rachel Allan support Elephantasia because we want to help bring awareness to the many issues surrounding and effecting elephants, such as being poached for their ivory tusks or losing large amounts of their habitats due to human expansion.\"</p>', 'white', 'Italy', 'silk', 'XS_XL', 'xxx', 'xxx', 960.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (4, 100018, '-Elephantasia Jumpsuit by Shriti Pratap ', NULL, '1f3d1ed7-c0ca-43ac-84b3-369b772bc719.jpg', '6d1b061c-04cd-4c9b-ac1a-d1bfee6938a8.jpg,bbe5b148-85a7-4b0f-98cb-1ff61ce4d047.jpeg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>Shriti began as a fashion and lifestyle brand in 2009. Since its inception the label has worked intensively with artisan prints which has become the essence of the brand. The label maintains the highest standards of quality from fabric procurement to the packaging. Shriti Pratap is committed to the brand philosophy, “keep LEARNING. keep SHARING. keep EVOLVING.” Shriti Pratap integrates social and environmental responsibility through fashion and art in the label’s day to day business objectives and hopes there will be many more brands to actively join her in this journey. Examples include tailoring the pieces for the needs of woman with breast cancer and Elephantasia: Fashion for Conservation.</p>', 'white', 'Italy', 'Sustainable Silk', 'XS_XL', '30% of your purchase supports elephant conservation and is tax-deductible with our not-for-profit partner African Wildlife Foundation.', 'xxx', 320.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (5, 100018, '-Pleated Elephantasia Jumpsuit by Shriti Pratap', NULL, '04be8c7d-7f46-40a2-9894-661c8e7187eb.jpg', 'a8bd6ae8-ed7f-4201-93e4-249fa610d32e.jpeg,5c2b0ba3-e1c1-4cd0-b176-edd6147e2c14.jpg,9df43b7c-ce88-4912-892c-6f374f3aafb4.jpg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>Shriti began as a fashion and lifestyle brand in 2009. Since its inception the label has worked intensively with artisan prints which has become the essence of the brand. The label maintains the highest standards of quality from fabric procurement to the packaging. Shriti Pratap is committed to the brand philosophy, “keep LEARNING. keep SHARING. keep EVOLVING.” Shriti Pratap integrates social and environmental responsibility through fashion and art in the label’s day to day business objectives and hopes there will be many more brands to actively join her in this journey. Examples include tailoring the pieces for the needs of woman with breast cancer and Elephantasia: Fashion for Conservation.</p>', 'white', 'Italy', 'Sustainable Silk', 'XS_XL', 'xxx', 'xxx', 274.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (6, 100018, '-Transformable Elephantasia Dress by Free.Mind', NULL, '97b96581-80aa-405c-aaed-aad4934eb747.jpg', 'e6abf934-d005-4bc0-a3e3-159ab4bd1398.jpg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>This dress features 4 possible looks: basic dress, dress with elephant ears, dress with elephant spirit, dress with elephant ears and spirit. \n\nFree Mind represents multi functional convertible clothes. These are dresses for the future, ambitious and sophisticated. Free Mind focuses on the concept of minds free of stereotypes, a universe free of superstition and restriction. The brand was founded in 2016 and each collection presents several articles with removable pieces, offering up to 9 different permutations per dress, making each a limited edition. </p>', 'white', 'Italy', 'Sustainable Silk', 'XS_XL', 'xxx', 'xxx', 400.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (7, 100015, '-LOVE ME Crew Neck by NO VOICE ', NULL, '13f93a5c-147b-4613-9c3c-cef2ff907782.jpg', '9087dff2-9a72-4ad5-a32f-f18ec3ec5268.jpg,67db4ca9-80ae-473f-a54f-41d57bde1df7.jpg,a4190edb-6db7-4ac7-bceb-0db24bde5192.jpeg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'black', 'Italy', 'Organic Cotton', 'XS_XL', 'xxx', 'xxx', 65.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (8, 100025, 'LOVE ME Gender Neutral Shirt by NO VOICE ', NULL, '828f531f-a4d1-4ff3-8d82-9de8c0bad188.jpeg', 'dcc65ab2-5dd9-4d1e-b2c7-28019bb04d73.jpeg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'white', 'Italy', 'Organic Cotton', 'XS_XL', 'xxx', 'xxx', 60.00, 9991, 2, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (9, 100021, '-Signature NO VOICE Hoodie', NULL, '61ecb4f3-c842-438a-af46-ddaa6012fdea.jpg', 'e0f79a0e-a0f7-4b3b-8541-277a6ca67701.jpg,8ce2d9aa-dae7-457b-86b4-d994adb35289.jpg,b9e2a3d7-f6cd-4e68-bdac-6d9cccd0ade2.jpg,f1f137de-3034-4682-8ebe-bb25f89dc69d.jpg,6024d4fc-9ce8-41fe-8a7b-a7ba2b4960eb.jpg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'black', 'Italy', 'Organic Cotton', 'XS_XL', 'xxx', 'xxx', 65.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (10, 100014, '-NO VOICE Bomber ', NULL, '49028942-e7b4-4e82-b38e-c25dd0d0da3a.jpeg', '29133b0d-e49f-4ce3-9b4e-a5aa53f5b33b.jpg,07cfbd44-4963-4c68-b961-05e79d2b5984.jpeg,0edb2213-2358-4ef8-b14c-db930a649ce7.jpg,47eef96d-b390-407a-8a09-13a195eb94ab.jpg', 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'Black Shell, Pink Lining, Rust Trim', 'Italy', 'Recycled Plastic Bottles', 'XS_XL', 'xxx', 'xxx', 400.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (11, 100018, '-NO VOICE Recycled Dress with Velvet Trim ', NULL, '8127bd01-3a2c-46f5-8814-c440d0034eea.jpeg', NULL, 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'Black and Deep Orange', 'Italy', 'Organic Cotton', 'S, M, L', 'xxx', 'xxx', 120.00, 9991, 1, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
INSERT INTO `FFC_product` VALUES (12, 100018, 'NO VOICE Cap with Elephant Paw', NULL, '830f0349-8e37-4fc4-a8b5-33a2713f8b91.jpeg', NULL, 'a02171e8-2a8d-48e0-927d-ce71274369ac.png', '<p>NO VOICE X Elephantasia is originally designed and produced by artistic and romantic partners Oscar Abbots - international designer for brands like Roberto Cavalli, Josep Font, Adolfo Dominguez and currently Zara - and Riccardo Ceretti - artist and archeologist with an innate passion for fashion. They live between Italy and Spain where they \"seduce all creative fields like music, film, architecture and art to reflect them in the wonderful world of fashion.\"</p>', 'Black', 'Italy', 'Organic Cotton', 'S, M, L', 'xxx', 'xxx', 55.00, 9991, 2, '2017-04-13 21:45:40', '2017-04-13 21:45:41');
COMMIT;

-- ----------------------------
-- Table structure for FFC_user
-- ----------------------------
DROP TABLE IF EXISTS `FFC_user`;
CREATE TABLE `FFC_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT 'username',
  `password` varchar(50) NOT NULL COMMENT 'pwd md5',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT 'security question',
  `answer` varchar(100) DEFAULT NULL COMMENT 'security answer',
  `role` int(4) NOT NULL COMMENT '0-admin,1-user',
  `firstTimeGetCoupon` int(4) NOT NULL COMMENT '0-yes,1-no',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of FFC_user
-- ----------------------------
BEGIN;
INSERT INTO `FFC_user` VALUES (1, 'admin', '427338237BD929443EC5D48E24FD2B1A', 'admin@happymmall.com', '13800138000', 'q', 'a', 1, 1, '2016-11-06 16:56:45', '2017-04-04 19:27:36');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
