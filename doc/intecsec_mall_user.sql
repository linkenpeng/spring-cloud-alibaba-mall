/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : intecsec_mall

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/01/2023 11:09:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `age` int DEFAULT '0',
  `salt` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `nick_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '头像',
  `role` smallint NOT NULL DEFAULT '1',
  `version` int unsigned DEFAULT '0',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES (15, 'abc123', '$2a$10$NVuWH9S3OQy8Y5vwKs0b8OlTU7H6o6GfbSVX7Al.DHuC8Aqnw6GsW', 0, '$2a$10$NVuWH9S3OQy8Y5vwKs0b8O', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 2, 1, '2022-12-16 22:11:30', '2022-12-31 17:44:43', 0);
INSERT INTO `mall_user` VALUES (17, 'peter', '$2a$10$60jZqn9c4lRiYjG1FXtp8OdnNubWjoE6W3GF8MH5Zegh1f6KMwQC2', 0, '$2a$10$60jZqn9c4lRiYjG1FXtp8O', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, 1, '2022-12-17 09:02:38', '2022-12-31 17:44:44', 0);
INSERT INTO `mall_user` VALUES (18, 'linken', '$2a$10$PE7K6nwEWSw0NE/57aL1DOgUEenCdM.uEF4sY/tmqO8uFFr4GbfRO', 0, '$2a$10$PE7K6nwEWSw0NE/57aL1DO', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, 1, '2022-12-31 10:01:35', '2022-12-31 17:44:46', 0);
INSERT INTO `mall_user` VALUES (19, 'admin', '$2a$10$OGc2MpPPbgHlnAqn30/2xuexAvWB6t.H3oGA/GNtXkz0eXj4eMRLu', 0, '$2a$10$OGc2MpPPbgHlnAqn30/2xu', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 2, 1, '2022-12-31 10:03:00', '2022-12-31 17:44:47', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_user_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_consignee`;
CREATE TABLE `mall_user_consignee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_user_consignee
-- ----------------------------
BEGIN;
INSERT INTO `mall_user_consignee` VALUES (1, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
