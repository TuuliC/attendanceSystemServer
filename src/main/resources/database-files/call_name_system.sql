/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : call_name_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 21/04/2024 12:10:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cc
-- ----------------------------
DROP TABLE IF EXISTS `tb_cc`;
CREATE TABLE `tb_cc`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `class_id` int NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id` ASC) USING BTREE,
  INDEX `cls_id`(`class_id` ASC) USING BTREE,
  CONSTRAINT `cls_id` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cc
-- ----------------------------
INSERT INTO `tb_cc` VALUES (5, 1, 1, 0);
INSERT INTO `tb_cc` VALUES (6, 1, 4, 0);
INSERT INTO `tb_cc` VALUES (7, 1, 7, 0);
INSERT INTO `tb_cc` VALUES (8, 1, 8, 0);
INSERT INTO `tb_cc` VALUES (9, 2, 1, 0);
INSERT INTO `tb_cc` VALUES (10, 2, 4, 0);
INSERT INTO `tb_cc` VALUES (11, 3, 1, 0);
INSERT INTO `tb_cc` VALUES (12, 3, 4, 0);
INSERT INTO `tb_cc` VALUES (13, 3, 7, 0);
INSERT INTO `tb_cc` VALUES (14, 3, 8, 0);
INSERT INTO `tb_cc` VALUES (17, 4, 1, 0);
INSERT INTO `tb_cc` VALUES (18, 4, 4, 0);
INSERT INTO `tb_cc` VALUES (19, 5, 1, 0);
INSERT INTO `tb_cc` VALUES (20, 5, 4, 0);
INSERT INTO `tb_cc` VALUES (21, 5, 7, 0);
INSERT INTO `tb_cc` VALUES (22, 5, 8, 0);
INSERT INTO `tb_cc` VALUES (23, 5, 9, 0);
INSERT INTO `tb_cc` VALUES (24, 5, 10, 0);
INSERT INTO `tb_cc` VALUES (25, 5, 13, 0);
INSERT INTO `tb_cc` VALUES (26, 5, 14, 0);
INSERT INTO `tb_cc` VALUES (27, 6, 1, 0);
INSERT INTO `tb_cc` VALUES (28, 6, 4, 0);
INSERT INTO `tb_cc` VALUES (29, 6, 9, 0);
INSERT INTO `tb_cc` VALUES (30, 6, 10, 0);
INSERT INTO `tb_cc` VALUES (31, 6, 11, 0);
INSERT INTO `tb_cc` VALUES (32, 6, 12, 0);
INSERT INTO `tb_cc` VALUES (33, 6, 13, 0);
INSERT INTO `tb_cc` VALUES (34, 6, 14, 0);
INSERT INTO `tb_cc` VALUES (35, 7, 1, 0);
INSERT INTO `tb_cc` VALUES (36, 7, 4, 0);
INSERT INTO `tb_cc` VALUES (37, 7, 7, 0);
INSERT INTO `tb_cc` VALUES (38, 7, 8, 0);
INSERT INTO `tb_cc` VALUES (39, 7, 9, 0);
INSERT INTO `tb_cc` VALUES (40, 7, 10, 0);
INSERT INTO `tb_cc` VALUES (41, 7, 11, 0);
INSERT INTO `tb_cc` VALUES (42, 7, 12, 0);
INSERT INTO `tb_cc` VALUES (43, 7, 13, 0);
INSERT INTO `tb_cc` VALUES (44, 7, 14, 0);
INSERT INTO `tb_cc` VALUES (45, 7, 15, 0);
INSERT INTO `tb_cc` VALUES (46, 7, 16, 0);
INSERT INTO `tb_cc` VALUES (47, 8, 13, 0);
INSERT INTO `tb_cc` VALUES (48, 8, 14, 0);
INSERT INTO `tb_cc` VALUES (49, 8, 15, 0);
INSERT INTO `tb_cc` VALUES (50, 8, 16, 0);
INSERT INTO `tb_cc` VALUES (51, 9, 15, 0);
INSERT INTO `tb_cc` VALUES (52, 9, 16, 0);
INSERT INTO `tb_cc` VALUES (53, 10, 21, 0);
INSERT INTO `tb_cc` VALUES (54, 10, 22, 0);
INSERT INTO `tb_cc` VALUES (55, 10, 23, 0);
INSERT INTO `tb_cc` VALUES (56, 10, 24, 0);
INSERT INTO `tb_cc` VALUES (57, 11, 17, 0);
INSERT INTO `tb_cc` VALUES (58, 11, 18, 0);
INSERT INTO `tb_cc` VALUES (59, 21, 19, 0);
INSERT INTO `tb_cc` VALUES (60, 21, 20, 0);
INSERT INTO `tb_cc` VALUES (61, 22, 19, 0);
INSERT INTO `tb_cc` VALUES (62, 22, 20, 0);
INSERT INTO `tb_cc` VALUES (63, 23, 19, 0);
INSERT INTO `tb_cc` VALUES (64, 23, 20, 0);
INSERT INTO `tb_cc` VALUES (65, 24, 19, 0);
INSERT INTO `tb_cc` VALUES (66, 24, 20, 0);
INSERT INTO `tb_cc` VALUES (67, 25, 21, 0);
INSERT INTO `tb_cc` VALUES (68, 25, 22, 0);
INSERT INTO `tb_cc` VALUES (69, 25, 23, 0);
INSERT INTO `tb_cc` VALUES (70, 25, 24, 0);
INSERT INTO `tb_cc` VALUES (71, 26, 21, 0);
INSERT INTO `tb_cc` VALUES (72, 26, 22, 0);
INSERT INTO `tb_cc` VALUES (73, 26, 23, 0);
INSERT INTO `tb_cc` VALUES (74, 26, 24, 0);
INSERT INTO `tb_cc` VALUES (75, 27, 21, 0);
INSERT INTO `tb_cc` VALUES (76, 27, 22, 0);
INSERT INTO `tb_cc` VALUES (77, 27, 23, 0);
INSERT INTO `tb_cc` VALUES (78, 27, 24, 0);
INSERT INTO `tb_cc` VALUES (79, 28, 21, 0);
INSERT INTO `tb_cc` VALUES (80, 28, 22, 0);
INSERT INTO `tb_cc` VALUES (81, 28, 23, 0);
INSERT INTO `tb_cc` VALUES (82, 28, 24, 0);

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `cl_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `college_id` int NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `college_id`(`college_id` ASC) USING BTREE,
  CONSTRAINT `college_id` FOREIGN KEY (`college_id`) REFERENCES `tb_college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES (1, '计算机21-1', 1, 0);
INSERT INTO `tb_class` VALUES (4, '计算机21-2', 1, 0);
INSERT INTO `tb_class` VALUES (7, '网络21-1', 1, 0);
INSERT INTO `tb_class` VALUES (8, '网络21-2', 1, 0);
INSERT INTO `tb_class` VALUES (9, '数学21-1', 2, 0);
INSERT INTO `tb_class` VALUES (10, '数学21-2', 2, 0);
INSERT INTO `tb_class` VALUES (11, '物理21-1', 2, 0);
INSERT INTO `tb_class` VALUES (12, '物理21-2', 2, 0);
INSERT INTO `tb_class` VALUES (13, '自动化21-1', 3, 0);
INSERT INTO `tb_class` VALUES (14, '自动化21-2', 3, 0);
INSERT INTO `tb_class` VALUES (15, '智能科学与技术21-1', 3, 0);
INSERT INTO `tb_class` VALUES (16, '智能科学与技术21-2', 3, 0);
INSERT INTO `tb_class` VALUES (17, '法学21-1', 4, 0);
INSERT INTO `tb_class` VALUES (18, '法学21-2', 4, 0);
INSERT INTO `tb_class` VALUES (19, '汉语言文学21-1', 4, 0);
INSERT INTO `tb_class` VALUES (20, '汉语言文学21-2', 4, 0);
INSERT INTO `tb_class` VALUES (21, '石油工程21-1', 5, 0);
INSERT INTO `tb_class` VALUES (22, '石油工程', 5, 0);
INSERT INTO `tb_class` VALUES (23, '海洋油气工程21-1', 5, 0);
INSERT INTO `tb_class` VALUES (24, '海洋油气工程21-2', 5, 0);
INSERT INTO `tb_class` VALUES (25, 'testClass2', 4, 1);

-- ----------------------------
-- Table structure for tb_college
-- ----------------------------
DROP TABLE IF EXISTS `tb_college`;
CREATE TABLE `tb_college`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `col_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_college
-- ----------------------------
INSERT INTO `tb_college` VALUES (1, '计算机学院', 0);
INSERT INTO `tb_college` VALUES (2, '理学院', 0);
INSERT INTO `tb_college` VALUES (3, '自动化学院', 0);
INSERT INTO `tb_college` VALUES (4, '文法学院', 0);
INSERT INTO `tb_college` VALUES (5, '石油工程学院', 0);
INSERT INTO `tb_college` VALUES (6, 'testCollege2', 1);
INSERT INTO `tb_college` VALUES (7, '11', 1);

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, '数据结构', 0);
INSERT INTO `tb_course` VALUES (2, '数据库原理', 0);
INSERT INTO `tb_course` VALUES (3, '计算机网络', 0);
INSERT INTO `tb_course` VALUES (4, '算法设计与分析', 0);
INSERT INTO `tb_course` VALUES (5, '离散数学', 0);
INSERT INTO `tb_course` VALUES (6, '微积分', 0);
INSERT INTO `tb_course` VALUES (7, '线性代数', 0);
INSERT INTO `tb_course` VALUES (8, '电路原理', 0);
INSERT INTO `tb_course` VALUES (9, '材料科学与工程', 0);
INSERT INTO `tb_course` VALUES (10, '石油勘探与开发', 0);
INSERT INTO `tb_course` VALUES (11, '法律基础', 0);
INSERT INTO `tb_course` VALUES (21, '中国古代文学', 0);
INSERT INTO `tb_course` VALUES (22, '现代汉语', 0);
INSERT INTO `tb_course` VALUES (23, '中国现当代文学', 0);
INSERT INTO `tb_course` VALUES (24, '汉字学', 0);
INSERT INTO `tb_course` VALUES (25, '石油地质学', 0);
INSERT INTO `tb_course` VALUES (26, '石油工程原理', 0);
INSERT INTO `tb_course` VALUES (27, '油气田开发与管理', 0);
INSERT INTO `tb_course` VALUES (28, '海洋油气勘探与开发', 0);

-- ----------------------------
-- Table structure for tb_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_id` int NOT NULL,
  `course_id` int NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` datetime NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stu_id`(`stu_id` ASC) USING BTREE,
  INDEX `cour_id`(`course_id` ASC) USING BTREE,
  CONSTRAINT `cour_id` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_id` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_record
-- ----------------------------
INSERT INTO `tb_record` VALUES (22, 127, 1, 'absent', '2023-06-09 16:24:49', 0);
INSERT INTO `tb_record` VALUES (23, 122, 2, 'attended', '2023-06-20 19:49:36', 0);
INSERT INTO `tb_record` VALUES (24, 63, 2, 'attended', '2023-06-20 19:52:32', 0);
INSERT INTO `tb_record` VALUES (25, 39, 1, 'attended', '2023-06-20 19:59:48', 0);
INSERT INTO `tb_record` VALUES (26, 40, 1, 'attended', '2023-06-20 20:00:03', 0);
INSERT INTO `tb_record` VALUES (27, 41, 1, 'attended', '2023-06-20 20:00:03', 0);
INSERT INTO `tb_record` VALUES (28, 42, 1, 'attended', '2023-06-20 20:00:03', 0);

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_num` int NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class_id` int NULL DEFAULT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_id`(`class_id` ASC) USING BTREE,
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 291 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (39, 100000001, '<script>alert(1)</script>', '男', 1, 0);
INSERT INTO `tb_student` VALUES (40, 100000002, '李四', '女', 1, 0);
INSERT INTO `tb_student` VALUES (41, 100000003, '王五', '男', 1, 0);
INSERT INTO `tb_student` VALUES (42, 100000004, '赵六', '女', 1, 0);
INSERT INTO `tb_student` VALUES (43, 100000005, '刘七', '男', 1, 0);
INSERT INTO `tb_student` VALUES (44, 100000006, '陈八', '女', 1, 0);
INSERT INTO `tb_student` VALUES (45, 100000007, '张九', '男', 1, 0);
INSERT INTO `tb_student` VALUES (46, 100000008, '李十', '女', 1, 0);
INSERT INTO `tb_student` VALUES (47, 100000009, '王鑫', '男', 1, 0);
INSERT INTO `tb_student` VALUES (48, 100000010, '赵琳', '女', 1, 0);
INSERT INTO `tb_student` VALUES (49, 100000011, '刘涛', '男', 1, 0);
INSERT INTO `tb_student` VALUES (50, 100000012, '陈秀', '女', 1, 0);
INSERT INTO `tb_student` VALUES (51, 100000013, '张辉', '男', 1, 0);
INSERT INTO `tb_student` VALUES (52, 100000014, '李明', '女', 1, 0);
INSERT INTO `tb_student` VALUES (53, 100000015, '王华', '男', 1, 0);
INSERT INTO `tb_student` VALUES (54, 100000016, '赵燕', '女', 1, 0);
INSERT INTO `tb_student` VALUES (55, 100000017, '刘宇', '男', 1, 0);
INSERT INTO `tb_student` VALUES (56, 100000018, '陈婷', '女', 1, 0);
INSERT INTO `tb_student` VALUES (57, 100000019, '张伟', '男', 1, 0);
INSERT INTO `tb_student` VALUES (58, 100000020, '李丽', '女', 1, 0);
INSERT INTO `tb_student` VALUES (59, 100000021, '王飞', '男', 1, 0);
INSERT INTO `tb_student` VALUES (60, 100000022, '赵军', '女', 1, 0);
INSERT INTO `tb_student` VALUES (61, 100000023, '刘霞', '男', 1, 0);
INSERT INTO `tb_student` VALUES (62, 100000024, '陈杰', '女', 1, 0);
INSERT INTO `tb_student` VALUES (63, 100000025, '张艳', '男', 1, 0);
INSERT INTO `tb_student` VALUES (64, 100000026, '李辉', '女', 1, 0);
INSERT INTO `tb_student` VALUES (65, 100000027, '王明', '男', 1, 0);
INSERT INTO `tb_student` VALUES (66, 100000028, '赵华', '女', 1, 0);
INSERT INTO `tb_student` VALUES (67, 100000029, '刘宏', '男', 1, 0);
INSERT INTO `tb_student` VALUES (68, 100000030, '陈娟', '女', 1, 0);
INSERT INTO `tb_student` VALUES (99, 101000001, '张三', '男', 1, 0);
INSERT INTO `tb_student` VALUES (100, 101000002, '李四', '男', 4, 0);
INSERT INTO `tb_student` VALUES (101, 101000003, '王五', '男', 4, 0);
INSERT INTO `tb_student` VALUES (102, 101000004, '赵六', '女', 4, 0);
INSERT INTO `tb_student` VALUES (103, 101000005, '刘七', '男', 4, 1);
INSERT INTO `tb_student` VALUES (104, 101000006, '陈八', '女', 4, 0);
INSERT INTO `tb_student` VALUES (105, 101000007, '张九', '男', 4, 0);
INSERT INTO `tb_student` VALUES (106, 101000008, '李十', '女', 4, 0);
INSERT INTO `tb_student` VALUES (107, 101000009, '王鑫', '男', 4, 0);
INSERT INTO `tb_student` VALUES (108, 101000010, '赵琳', '女', 4, 0);
INSERT INTO `tb_student` VALUES (109, 101000011, '刘涛', '男', 4, 0);
INSERT INTO `tb_student` VALUES (110, 101000012, '陈秀', '女', 4, 0);
INSERT INTO `tb_student` VALUES (111, 101000013, '张辉', '男', 4, 0);
INSERT INTO `tb_student` VALUES (112, 101000014, '李明', '女', 4, 0);
INSERT INTO `tb_student` VALUES (113, 101000015, '王华', '男', 4, 0);
INSERT INTO `tb_student` VALUES (114, 101000016, '赵燕', '女', 4, 0);
INSERT INTO `tb_student` VALUES (115, 101000017, '刘宇', '男', 4, 0);
INSERT INTO `tb_student` VALUES (116, 101000018, '陈婷', '女', 4, 0);
INSERT INTO `tb_student` VALUES (117, 101000019, '张伟', '男', 9, 0);
INSERT INTO `tb_student` VALUES (118, 101000020, '李丽', '女', 4, 0);
INSERT INTO `tb_student` VALUES (119, 101000021, '王飞', '男', 4, 0);
INSERT INTO `tb_student` VALUES (120, 101000022, '赵军', '女', 4, 0);
INSERT INTO `tb_student` VALUES (121, 101000023, '刘霞', '男', 4, 0);
INSERT INTO `tb_student` VALUES (122, 101000024, '陈杰', '女', 4, 0);
INSERT INTO `tb_student` VALUES (123, 101000025, '张艳', '男', 4, 0);
INSERT INTO `tb_student` VALUES (124, 101000026, '李辉', '女', 4, 0);
INSERT INTO `tb_student` VALUES (125, 101000027, '王明', '男', 4, 0);
INSERT INTO `tb_student` VALUES (126, 101000028, '赵华', '女', 4, 0);
INSERT INTO `tb_student` VALUES (127, 101000029, '刘宏', '男', 4, 0);
INSERT INTO `tb_student` VALUES (128, 101000030, '陈娟', '女', 4, 0);
INSERT INTO `tb_student` VALUES (129, 103000001, '张三', '男', 7, 0);
INSERT INTO `tb_student` VALUES (130, 103000002, '李四', '女', 7, 0);
INSERT INTO `tb_student` VALUES (131, 103000003, '王五', '男', 7, 0);
INSERT INTO `tb_student` VALUES (132, 103000004, '赵六', '女', 7, 0);
INSERT INTO `tb_student` VALUES (133, 103000005, '刘七', '男', 7, 0);
INSERT INTO `tb_student` VALUES (134, 103000006, '陈八', '女', 7, 0);
INSERT INTO `tb_student` VALUES (135, 103000007, '张九', '男', 7, 0);
INSERT INTO `tb_student` VALUES (136, 103000008, '王二', '女', 7, 0);
INSERT INTO `tb_student` VALUES (137, 103000009, '李十', '男', 7, 0);
INSERT INTO `tb_student` VALUES (138, 103000010, '赵一', '女', 7, 0);
INSERT INTO `tb_student` VALUES (139, 103000011, '钱六', '男', 7, 0);
INSERT INTO `tb_student` VALUES (140, 103000012, '孙七', '女', 7, 0);
INSERT INTO `tb_student` VALUES (141, 103000013, '李八', '男', 7, 0);
INSERT INTO `tb_student` VALUES (142, 103000014, '周九', '女', 7, 0);
INSERT INTO `tb_student` VALUES (143, 103000015, '吴十', '男', 7, 0);
INSERT INTO `tb_student` VALUES (144, 103000016, '郑一', '女', 7, 0);
INSERT INTO `tb_student` VALUES (145, 103000017, '王六', '男', 7, 0);
INSERT INTO `tb_student` VALUES (146, 103000018, '赵七', '女', 7, 0);
INSERT INTO `tb_student` VALUES (147, 103000019, '钱八', '男', 7, 0);
INSERT INTO `tb_student` VALUES (148, 103000020, '孙九', '女', 7, 0);
INSERT INTO `tb_student` VALUES (149, 103000021, '李十', '男', 7, 0);
INSERT INTO `tb_student` VALUES (150, 103000022, '周一', '女', 7, 0);
INSERT INTO `tb_student` VALUES (151, 103000023, '吴六', '男', 7, 0);
INSERT INTO `tb_student` VALUES (152, 103000024, '郑七', '女', 7, 0);
INSERT INTO `tb_student` VALUES (153, 103000025, '王八', '男', 7, 0);
INSERT INTO `tb_student` VALUES (154, 103000026, '赵九', '女', 7, 0);
INSERT INTO `tb_student` VALUES (155, 103000027, '钱十', '男', 7, 0);
INSERT INTO `tb_student` VALUES (156, 103000028, '孙一', '女', 7, 0);
INSERT INTO `tb_student` VALUES (157, 103000029, '李六', '男', 7, 0);
INSERT INTO `tb_student` VALUES (158, 103000030, '周七', '女', 7, 0);
INSERT INTO `tb_student` VALUES (159, 104000001, '张三', '男', 8, 0);
INSERT INTO `tb_student` VALUES (160, 104000002, '李四', '女', 8, 0);
INSERT INTO `tb_student` VALUES (161, 104000003, '王五', '男', 8, 0);
INSERT INTO `tb_student` VALUES (162, 104000004, '赵六', '女', 8, 0);
INSERT INTO `tb_student` VALUES (163, 104000005, '刘七', '男', 8, 0);
INSERT INTO `tb_student` VALUES (164, 104000006, '陈八', '女', 8, 0);
INSERT INTO `tb_student` VALUES (165, 104000007, '张九', '男', 8, 0);
INSERT INTO `tb_student` VALUES (166, 104000008, '王二', '女', 8, 0);
INSERT INTO `tb_student` VALUES (167, 104000009, '李十', '男', 8, 0);
INSERT INTO `tb_student` VALUES (168, 104000010, '赵一', '女', 8, 0);
INSERT INTO `tb_student` VALUES (169, 104000011, '钱六', '男', 8, 0);
INSERT INTO `tb_student` VALUES (170, 104000012, '孙七', '女', 8, 0);
INSERT INTO `tb_student` VALUES (171, 104000013, '李八', '男', 8, 0);
INSERT INTO `tb_student` VALUES (172, 104000014, '周九', '女', 8, 0);
INSERT INTO `tb_student` VALUES (173, 104000015, '吴十', '男', 8, 0);
INSERT INTO `tb_student` VALUES (174, 104000016, '郑一', '女', 8, 0);
INSERT INTO `tb_student` VALUES (175, 104000017, '王六', '男', 8, 0);
INSERT INTO `tb_student` VALUES (176, 104000018, '赵七', '女', 8, 0);
INSERT INTO `tb_student` VALUES (177, 104000019, '钱八', '男', 8, 0);
INSERT INTO `tb_student` VALUES (178, 104000020, '孙九', '女', 8, 0);
INSERT INTO `tb_student` VALUES (179, 104000021, '李十', '男', 8, 0);
INSERT INTO `tb_student` VALUES (180, 104000022, '周一', '女', 8, 0);
INSERT INTO `tb_student` VALUES (181, 104000023, '吴六', '男', 8, 0);
INSERT INTO `tb_student` VALUES (182, 104000024, '郑七', '女', 8, 0);
INSERT INTO `tb_student` VALUES (183, 104000025, '王八', '男', 8, 0);
INSERT INTO `tb_student` VALUES (184, 104000026, '赵九', '女', 8, 0);
INSERT INTO `tb_student` VALUES (185, 104000027, '钱十', '男', 8, 0);
INSERT INTO `tb_student` VALUES (186, 104000028, '孙一', '女', 8, 0);
INSERT INTO `tb_student` VALUES (187, 104000029, '李六', '男', 8, 0);
INSERT INTO `tb_student` VALUES (188, 104000030, '周七', '女', 8, 0);
INSERT INTO `tb_student` VALUES (189, 110000001, '张三', '男', 9, 0);
INSERT INTO `tb_student` VALUES (190, 110000002, '李四', '女', 9, 0);
INSERT INTO `tb_student` VALUES (191, 110000003, '王五', '男', 9, 0);
INSERT INTO `tb_student` VALUES (192, 110000004, '赵六', '女', 9, 0);
INSERT INTO `tb_student` VALUES (193, 110000005, '刘七', '男', 9, 0);
INSERT INTO `tb_student` VALUES (194, 110000006, '陈八', '女', 9, 0);
INSERT INTO `tb_student` VALUES (195, 110000007, '张九', '男', 9, 0);
INSERT INTO `tb_student` VALUES (196, 110000008, '王二', '女', 9, 0);
INSERT INTO `tb_student` VALUES (197, 110000009, '李十', '男', 9, 0);
INSERT INTO `tb_student` VALUES (198, 110000010, '赵一', '女', 9, 0);
INSERT INTO `tb_student` VALUES (199, 110000011, '钱六', '男', 9, 0);
INSERT INTO `tb_student` VALUES (200, 110000012, '孙七', '女', 9, 0);
INSERT INTO `tb_student` VALUES (201, 110000013, '李八', '男', 9, 0);
INSERT INTO `tb_student` VALUES (202, 110000014, '周九', '女', 9, 0);
INSERT INTO `tb_student` VALUES (203, 110000015, '吴十', '男', 9, 0);
INSERT INTO `tb_student` VALUES (204, 110000016, '郑一', '女', 9, 0);
INSERT INTO `tb_student` VALUES (205, 110000017, '王六', '男', 9, 0);
INSERT INTO `tb_student` VALUES (206, 110000018, '赵七', '女', 9, 0);
INSERT INTO `tb_student` VALUES (207, 110000019, '钱八', '男', 9, 0);
INSERT INTO `tb_student` VALUES (208, 110000020, '孙九', '女', 9, 0);
INSERT INTO `tb_student` VALUES (209, 110000021, '张三', '男', 10, 0);
INSERT INTO `tb_student` VALUES (210, 110000022, '李四', '女', 10, 0);
INSERT INTO `tb_student` VALUES (211, 110000023, '王五', '男', 10, 0);
INSERT INTO `tb_student` VALUES (212, 110000024, '赵六', '女', 10, 0);
INSERT INTO `tb_student` VALUES (213, 110000025, '刘七', '男', 10, 0);
INSERT INTO `tb_student` VALUES (214, 110000026, '陈八', '女', 10, 0);
INSERT INTO `tb_student` VALUES (215, 110000027, '张九', '男', 10, 0);
INSERT INTO `tb_student` VALUES (216, 110000028, '王二', '女', 10, 0);
INSERT INTO `tb_student` VALUES (217, 110000029, '李十', '男', 10, 0);
INSERT INTO `tb_student` VALUES (218, 110000030, '赵一', '女', 10, 0);
INSERT INTO `tb_student` VALUES (219, 110000031, '钱六', '男', 10, 0);
INSERT INTO `tb_student` VALUES (220, 110000032, '孙七', '女', 10, 0);
INSERT INTO `tb_student` VALUES (221, 110000033, '李八', '男', 10, 0);
INSERT INTO `tb_student` VALUES (222, 110000034, '周九', '女', 10, 0);
INSERT INTO `tb_student` VALUES (223, 110000035, '吴十', '男', 10, 0);
INSERT INTO `tb_student` VALUES (224, 110000036, '郑一', '女', 10, 0);
INSERT INTO `tb_student` VALUES (225, 110000037, '王六', '男', 10, 0);
INSERT INTO `tb_student` VALUES (226, 110000038, '赵七', '女', 10, 0);
INSERT INTO `tb_student` VALUES (227, 110000039, '钱八', '男', 10, 0);
INSERT INTO `tb_student` VALUES (228, 110000040, '孙九', '女', 10, 0);
INSERT INTO `tb_student` VALUES (229, 112000001, '张三', '男', 11, 0);
INSERT INTO `tb_student` VALUES (230, 112000002, '李四', '女', 11, 0);
INSERT INTO `tb_student` VALUES (231, 112000003, '王五', '男', 11, 0);
INSERT INTO `tb_student` VALUES (232, 112000004, '赵六', '女', 11, 0);
INSERT INTO `tb_student` VALUES (233, 112000005, '刘七', '男', 11, 0);
INSERT INTO `tb_student` VALUES (234, 112000006, '陈八', '女', 11, 0);
INSERT INTO `tb_student` VALUES (235, 112000007, '张九', '男', 11, 0);
INSERT INTO `tb_student` VALUES (236, 112000008, '王二', '女', 11, 0);
INSERT INTO `tb_student` VALUES (237, 112000009, '李十', '男', 11, 0);
INSERT INTO `tb_student` VALUES (238, 112000010, '赵一', '女', 11, 0);
INSERT INTO `tb_student` VALUES (239, 112000011, '钱六', '男', 11, 0);
INSERT INTO `tb_student` VALUES (240, 112000012, '孙七', '女', 11, 0);
INSERT INTO `tb_student` VALUES (241, 112000013, '李八', '男', 11, 0);
INSERT INTO `tb_student` VALUES (242, 112000014, '周九', '女', 11, 0);
INSERT INTO `tb_student` VALUES (243, 112000015, '吴十', '男', 11, 0);
INSERT INTO `tb_student` VALUES (244, 112000016, '郑一', '女', 11, 0);
INSERT INTO `tb_student` VALUES (245, 112000017, '王六', '男', 11, 0);
INSERT INTO `tb_student` VALUES (246, 112000018, '赵七', '女', 11, 0);
INSERT INTO `tb_student` VALUES (247, 112000019, '钱八', '男', 11, 0);
INSERT INTO `tb_student` VALUES (248, 112000020, '孙九', '女', 11, 0);
INSERT INTO `tb_student` VALUES (249, 112000021, '张三', '男', 11, 0);
INSERT INTO `tb_student` VALUES (250, 112000022, '李四', '女', 11, 0);
INSERT INTO `tb_student` VALUES (251, 112000023, '王五', '男', 11, 0);
INSERT INTO `tb_student` VALUES (252, 112000024, '赵六', '女', 11, 0);
INSERT INTO `tb_student` VALUES (253, 112000025, '刘七', '男', 11, 0);
INSERT INTO `tb_student` VALUES (254, 112000026, '陈八', '女', 11, 0);
INSERT INTO `tb_student` VALUES (255, 112000027, '张九', '男', 11, 0);
INSERT INTO `tb_student` VALUES (256, 112000028, '王二', '女', 11, 0);
INSERT INTO `tb_student` VALUES (257, 112000029, '李十', '男', 11, 0);
INSERT INTO `tb_student` VALUES (258, 112000030, '赵一', '女', 11, 0);
INSERT INTO `tb_student` VALUES (259, 113000001, '张三', '男', 12, 0);
INSERT INTO `tb_student` VALUES (260, 113000002, '李四', '女', 12, 0);
INSERT INTO `tb_student` VALUES (261, 113000003, '王五', '男', 12, 0);
INSERT INTO `tb_student` VALUES (262, 113000004, '赵六', '女', 12, 0);
INSERT INTO `tb_student` VALUES (263, 113000005, '刘七', '男', 12, 0);
INSERT INTO `tb_student` VALUES (264, 113000006, '陈八', '女', 12, 0);
INSERT INTO `tb_student` VALUES (265, 113000007, '张九', '男', 12, 0);
INSERT INTO `tb_student` VALUES (266, 113000008, '王二', '女', 12, 0);
INSERT INTO `tb_student` VALUES (267, 113000009, '李十', '男', 12, 0);
INSERT INTO `tb_student` VALUES (268, 113000010, '赵一', '女', 12, 0);
INSERT INTO `tb_student` VALUES (269, 113000011, '钱六', '男', 12, 0);
INSERT INTO `tb_student` VALUES (270, 113000012, '孙七', '女', 12, 0);
INSERT INTO `tb_student` VALUES (271, 113000013, '李八', '男', 12, 0);
INSERT INTO `tb_student` VALUES (272, 113000014, '周九', '女', 12, 0);
INSERT INTO `tb_student` VALUES (273, 113000015, '吴十', '男', 12, 0);
INSERT INTO `tb_student` VALUES (274, 113000016, '郑一', '女', 12, 0);
INSERT INTO `tb_student` VALUES (275, 113000017, '王六', '男', 12, 0);
INSERT INTO `tb_student` VALUES (276, 113000018, '赵七', '女', 12, 0);
INSERT INTO `tb_student` VALUES (277, 113000019, '钱八', '男', 12, 0);
INSERT INTO `tb_student` VALUES (278, 113000020, '孙九', '女', 12, 0);
INSERT INTO `tb_student` VALUES (279, 113000021, '张三', '男', 12, 0);
INSERT INTO `tb_student` VALUES (280, 113000022, '李四', '女', 12, 0);
INSERT INTO `tb_student` VALUES (281, 113000023, '王五', '男', 12, 0);
INSERT INTO `tb_student` VALUES (282, 113000024, '赵六', '女', 12, 0);
INSERT INTO `tb_student` VALUES (283, 113000025, '刘七', '男', 12, 0);
INSERT INTO `tb_student` VALUES (284, 113000026, '陈八', '女', 12, 0);
INSERT INTO `tb_student` VALUES (285, 113000027, '张九', '男', 12, 0);
INSERT INTO `tb_student` VALUES (286, 113000028, '王二', '女', 12, 0);
INSERT INTO `tb_student` VALUES (287, 113000029, '李十', '男', 12, 0);
INSERT INTO `tb_student` VALUES (288, 113000030, '赵一', '女', 12, 0);
INSERT INTO `tb_student` VALUES (289, 101, 'test', '男', 1, 0);
INSERT INTO `tb_student` VALUES (290, 1, '11', '男', 1, 0);
INSERT INTO `tb_student` VALUES (291, 1002, 'test', '男', 1, 0);

-- ----------------------------
-- View structure for record_detail
-- ----------------------------
DROP VIEW IF EXISTS `record_detail`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `record_detail` AS select `tb_student`.`stu_num` AS `stu_num`,`tb_student`.`stu_name` AS `stu_name`,`tb_student`.`gender` AS `gender`,`tb_class`.`cl_name` AS `class_name`,`tb_college`.`col_name` AS `col_name`,`tb_course`.`course_name` AS `course_name`,`tb_record`.`status` AS `status`,`tb_record`.`time` AS `time` from (((((`tb_student` join `tb_class` on((`tb_student`.`class_id` = `tb_class`.`id`))) join `tb_college` on((`tb_class`.`college_id` = `tb_college`.`id`))) join `tb_cc` on((`tb_class`.`id` = `tb_cc`.`class_id`))) join `tb_course` on((`tb_cc`.`course_id` = `tb_course`.`id`))) join `tb_record` on(((`tb_course`.`id` = `tb_record`.`course_id`) and (`tb_student`.`id` = `tb_record`.`stu_id`)))) where ((`tb_student`.`deleted` = 0) and (`tb_class`.`deleted` = 0) and (`tb_college`.`deleted` = 0) and (`tb_cc`.`deleted` = 0) and (`tb_course`.`deleted` = 0) and (`tb_record`.`deleted` = 0));

SET FOREIGN_KEY_CHECKS = 1;
