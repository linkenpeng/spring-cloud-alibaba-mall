/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : intecsec_mall_common

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 12/03/2023 23:48:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint unsigned NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `dict_code` varchar(100) NOT NULL,
  `has_children` tinyint NOT NULL DEFAULT '0',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45052 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (1, 0, '北京市', '1', '1', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (2, 0, '天津市', '1', '2', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (3, 0, '河北省', '1', '3', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (4, 0, '山西省', '1', '4', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (5, 0, '内蒙古自治区', '1', '5', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (6, 0, '辽宁省', '1', '6', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (7, 0, '吉林省', '1', '7', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (8, 0, '黑龙江省', '1', '8', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (9, 0, '上海市', '1', '9', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (10, 0, '江苏省', '1', '10', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (11, 0, '浙江省', '1', '11', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (12, 0, '安徽省', '1', '12', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (13, 0, '福建省', '1', '13', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (14, 0, '江西省', '1', '14', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (15, 0, '山东省', '1', '15', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (16, 0, '河南省', '1', '16', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (17, 0, '湖北省', '1', '17', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (18, 0, '湖南省', '1', '18', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (19, 0, '广东省', '1', '19', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (20, 0, '广西壮族自治区', '1', '20', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (21, 0, '海南省', '1', '21', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (22, 0, '重庆市', '1', '22', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (23, 0, '四川省', '1', '23', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (24, 0, '贵州省', '1', '24', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (25, 0, '云南省', '1', '25', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (26, 0, '西藏自治区', '1', '26', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (27, 0, '陕西省', '1', '27', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (28, 0, '甘肃省', '1', '28', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (29, 0, '青海省', '1', '29', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (30, 0, '宁夏回族自治区', '1', '30', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (31, 0, '新疆维吾尔自治区', '1', '31', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (32, 0, '台湾省', '1', '32', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (33, 0, '香港特别行政区', '1', '33', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (34, 0, '澳门特别行政区', '1', '34', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (35, 0, '海外', '1', '35', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (36, 0, '其他', '1', '36', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (37, 1, '东城区', '2', '37', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (38, 1, '西城区', '2', '38', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (39, 1, '崇文区', '2', '39', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (40, 1, '宣武区', '2', '40', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (41, 1, '朝阳区', '2', '41', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (42, 1, '丰台区', '2', '42', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (43, 1, '石景山区', '2', '43', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (44, 1, '海淀区', '2', '44', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (45, 1, '门头沟区', '2', '45', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (46, 1, '房山区', '2', '46', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (47, 1, '通州区', '2', '47', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (48, 1, '顺义区', '2', '48', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (49, 1, '昌平区', '2', '49', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (50, 1, '大兴区', '2', '50', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:48', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (51, 1, '怀柔区', '2', '51', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (52, 1, '平谷区', '2', '52', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (53, 1, '密云县', '2', '53', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (54, 1, '延庆县', '2', '54', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (55, 2, '和平区', '2', '55', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (56, 2, '河东区', '2', '56', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (57, 2, '河西区', '2', '57', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (58, 2, '南开区', '2', '58', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (59, 2, '河北区', '2', '59', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (60, 2, '红桥区', '2', '60', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (61, 2, '塘沽区', '2', '61', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (62, 2, '汉沽区', '2', '62', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (63, 2, '大港区', '2', '63', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (64, 2, '东丽区', '2', '64', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (65, 2, '西青区', '2', '65', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (66, 2, '津南区', '2', '66', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (67, 2, '北辰区', '2', '67', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (68, 2, '武清区', '2', '68', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (69, 2, '宝坻区', '2', '69', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (70, 2, '宁河县', '2', '70', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (71, 2, '静海县', '2', '71', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (72, 2, '蓟县', '2', '72', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (73, 3, '石家庄市', '2', '73', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (74, 3, '唐山市', '2', '74', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (75, 3, '秦皇岛市', '2', '75', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (76, 3, '邯郸市', '2', '76', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (77, 3, '邢台市', '2', '77', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (78, 3, '保定市', '2', '78', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (79, 3, '张家口市', '2', '79', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (80, 3, '承德市', '2', '80', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (81, 3, '衡水市', '2', '81', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (82, 3, '廊坊市', '2', '82', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (83, 3, '沧州市', '2', '83', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (84, 4, '太原市', '2', '84', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (85, 4, '大同市', '2', '85', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (86, 4, '阳泉市', '2', '86', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (87, 4, '长治市', '2', '87', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (88, 4, '晋城市', '2', '88', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (89, 4, '朔州市', '2', '89', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (90, 4, '晋中市', '2', '90', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (91, 4, '运城市', '2', '91', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (92, 4, '忻州市', '2', '92', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (93, 4, '临汾市', '2', '93', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (94, 4, '吕梁市', '2', '94', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (95, 5, '呼和浩特市', '2', '95', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (96, 5, '包头市', '2', '96', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (97, 5, '乌海市', '2', '97', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (98, 5, '赤峰市', '2', '98', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (99, 5, '通辽市', '2', '99', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);
INSERT INTO `intecsec_mall_common`.`dict` (`id`, `parent_id`, `name`, `value`, `dict_code`, `has_children`, `gmt_created`, `gmt_updated`, `delete_mark`) VALUES (100, 5, '鄂尔多斯市', '2', '100', 1, '2023-03-05 21:00:04', '2023-03-11 18:59:49', 0);