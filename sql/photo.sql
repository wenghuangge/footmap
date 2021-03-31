/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : footmap

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 17/03/2021 18:59:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `longitude` double(20, 10) NULL DEFAULT NULL,
  `latitude` double(20, 10) NULL DEFAULT NULL,
  `image` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` bigint(20) NULL DEFAULT NULL,
  `praiseNum` int(11) NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visible` int(11) NULL DEFAULT NULL,
  `photoTime` bigint(20) NULL DEFAULT NULL,
  `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 434 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES (428, 46, 121.4205600000, 28.6561100000, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOuwSAYlWNAAArPx9nV50949.jpg\"]', 1615772428218, NULL, NULL, '浙江省', '台州市', '浙江省台州市椒江区白云山中路233号', 0, NULL, '台州游', '第一次来台州');
INSERT INTO `photo` VALUES (429, 46, 121.4205600000, 28.6561100000, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu0-AdGJWAACGV6JDMO0442.jpg\",\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu0-AZ6nmAACHC0AI7H0383.jpg\"]', 1615772497207, NULL, NULL, '浙江省', '台州市', '浙江省台州市', 0, NULL, '台州游玩', '第二次来台州');
INSERT INTO `photo` VALUES (430, 46, 122.5076766740, 52.9883183490, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu3mAWb9pAABGd0DCBqM694.jpg\"]', 1615772538962, NULL, NULL, '黑龙江省', '大兴安岭地区', '黑龙江省大兴安岭地区漠河市西林吉镇', 0, NULL, '往北走', '北方');
INSERT INTO `photo` VALUES (431, 46, 109.7661104500, 18.3106108990, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu6mAOz8HAABnbuEzP6s413.jpg\",\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu6mABM8QAAB5NNFsPQ8935.jpg\"]', 1615772585887, NULL, NULL, '海南省', '三亚市', '海南省三亚市海棠区海棠湾镇蜈支洲岛', 0, NULL, '往南走', '南方');
INSERT INTO `photo` VALUES (432, 46, 76.0525808990, 39.4948837990, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu8SAOrOgAAGWkBC9hDc371.jpg\",\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu8SASGw3AAF_K5yd7hM018.jpg\"]', 1615772613669, NULL, NULL, '新疆维吾尔自治区', '喀什地区', '新疆维吾尔自治区喀什地区喀什市天山东路', 0, NULL, '往西走', '西边');
INSERT INTO `photo` VALUES (433, 46, 134.4024594050, 48.3450808090, '[\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu-CANn6TAABsUpcjo5I044.jpg\",\"http://112.126.89.10:8888/group1/M00/00/01/rBGuemBOu-CAEeDYAACGuD1jjRw335.jpg\"]', 1615772641116, NULL, NULL, '黑龙江省', '佳木斯市', '黑龙江省佳木斯市抚远市通江乡', 0, NULL, '往东走', '东边');

SET FOREIGN_KEY_CHECKS = 1;
