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

 Date: 17/03/2021 18:59:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wechat_user
-- ----------------------------
DROP TABLE IF EXISTS `wechat_user`;
CREATE TABLE `wechat_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sessionId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wechat_user
-- ----------------------------
INSERT INTO `wechat_user` VALUES (46, 'oGYFS5RLcztTGtIGeFSpDGjJTnwY', '512oVoeJ9KBqgObi5RY3Le3zE+EFA4QdBG6Ohzo4nynUloYBtr99RDB9yyqd5dxG', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/5BClhOicLQjlYpghfnFd7xIRCqtJzbtgX47yIhOYsTDtpytSic2up7t3icdbs455L7RibkgcxpS3al7RdUVjPO6wsg/132', 'China', 'Zhejiang', 'Wenzhou', 'zh_CN', 1615704293);

SET FOREIGN_KEY_CHECKS = 1;
