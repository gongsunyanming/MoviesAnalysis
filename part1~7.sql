/*
 Navicat Premium Data Transfer

 Source Server         : dr02
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 192.168.79.131:3306
 Source Schema         : db_spark_movie

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 22/08/2024 16:01:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for part1
-- ----------------------------
DROP TABLE IF EXISTS `part1`;
CREATE TABLE `part1`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影上映年份',
  `value` bigint NULL DEFAULT NULL COMMENT '数量'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part2
-- ----------------------------
DROP TABLE IF EXISTS `part2`;
CREATE TABLE `part2`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '演员',
  `value` bigint NULL DEFAULT NULL COMMENT '出现次数'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part3
-- ----------------------------
DROP TABLE IF EXISTS `part3`;
CREATE TABLE `part3`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电源类型',
  `value` bigint NULL DEFAULT NULL COMMENT '出现次数'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part4
-- ----------------------------
DROP TABLE IF EXISTS `part4`;
CREATE TABLE `part4`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影类型',
  `value` float NULL DEFAULT NULL COMMENT '平均得分'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part5
-- ----------------------------
DROP TABLE IF EXISTS `part5`;
CREATE TABLE `part5`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '演员',
  `value` float NULL DEFAULT NULL COMMENT '平均评分'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part6
-- ----------------------------
DROP TABLE IF EXISTS `part6`;
CREATE TABLE `part6`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '年份',
  `value` float NULL DEFAULT NULL COMMENT '平均评分'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for part7
-- ----------------------------
DROP TABLE IF EXISTS `part7`;
CREATE TABLE `part7`  (
  `name` float NULL DEFAULT NULL COMMENT '评分',
  `value` bigint NULL DEFAULT NULL COMMENT '出现次数'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
