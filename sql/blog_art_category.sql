/*
 Navicat Premium Data Transfer

 Source Server         : worm_db
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : worm_blog

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/04/2022 10:23:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_art_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_art_category`;
CREATE TABLE `blog_art_category`  (
  `art_id` int NOT NULL,
  `cate_id` int NOT NULL,
  PRIMARY KEY (`art_id`, `cate_id`) USING BTREE,
  INDEX `cate_art_id`(`cate_id`) USING BTREE,
  CONSTRAINT `blog_art_category_ibfk_1` FOREIGN KEY (`art_id`) REFERENCES `blog_article` (`art_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blog_art_category_ibfk_2` FOREIGN KEY (`cate_id`) REFERENCES `blog_category` (`cate_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章分类设置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for blog_art_label
-- ----------------------------
DROP TABLE IF EXISTS `blog_art_label`;
CREATE TABLE `blog_art_label`  (
  `art_id` int NOT NULL,
  `label_id` int NOT NULL,
  PRIMARY KEY (`art_id`, `label_id`) USING BTREE,
  INDEX `label_art_id`(`label_id`) USING BTREE,
  CONSTRAINT `blog_art_label_ibfk_1` FOREIGN KEY (`art_id`) REFERENCES `blog_article` (`art_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blog_art_label_ibfk_2` FOREIGN KEY (`label_id`) REFERENCES `blog_label` (`label_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article`  (
  `art_id` int NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `art_title` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `art_summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章概述',
  `art_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章内容',
  `art_views` int UNSIGNED NULL DEFAULT NULL COMMENT '浏览量',
  `art_date` datetime(0) NULL DEFAULT NULL COMMENT '文章日期',
  `art_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章封面',
  PRIMARY KEY (`art_id`) USING BTREE,
  INDEX `art_title`(`art_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `cate_id` int NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `cate_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `cate_description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类描述',
  PRIMARY KEY (`cate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for blog_label
-- ----------------------------
DROP TABLE IF EXISTS `blog_label`;
CREATE TABLE `blog_label`  (
  `label_id` int NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `label_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名字',
  `label_description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签描述',
  `label_date` datetime(0) NULL DEFAULT NULL COMMENT 'label创建日期',
  PRIMARY KEY (`label_id`) USING BTREE,
  INDEX `label_name`(`label_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
