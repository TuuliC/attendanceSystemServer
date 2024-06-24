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

 Date: 24/06/2024 23:52:44
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
  `status` int NOT NULL DEFAULT 0 COMMENT '0为未签到，1为正在签到',
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_id`(`course_id` ASC) USING BTREE,
  INDEX `cls_id`(`class_id` ASC) USING BTREE,
  CONSTRAINT `cls_id` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_cc
-- ----------------------------
INSERT INTO `tb_cc` VALUES (5, 1, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (6, 1, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (7, 1, 7, 0, 0);
INSERT INTO `tb_cc` VALUES (8, 1, 8, 0, 0);
INSERT INTO `tb_cc` VALUES (9, 2, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (10, 2, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (11, 3, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (12, 3, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (13, 3, 7, 0, 0);
INSERT INTO `tb_cc` VALUES (14, 3, 8, 0, 0);
INSERT INTO `tb_cc` VALUES (17, 4, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (18, 4, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (19, 5, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (20, 5, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (21, 5, 7, 0, 0);
INSERT INTO `tb_cc` VALUES (22, 5, 8, 0, 0);
INSERT INTO `tb_cc` VALUES (23, 5, 9, 0, 0);
INSERT INTO `tb_cc` VALUES (24, 5, 10, 0, 0);
INSERT INTO `tb_cc` VALUES (25, 5, 13, 0, 0);
INSERT INTO `tb_cc` VALUES (26, 5, 14, 0, 0);
INSERT INTO `tb_cc` VALUES (27, 6, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (28, 6, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (29, 6, 9, 0, 0);
INSERT INTO `tb_cc` VALUES (30, 6, 10, 0, 0);
INSERT INTO `tb_cc` VALUES (31, 6, 11, 0, 0);
INSERT INTO `tb_cc` VALUES (32, 6, 12, 0, 0);
INSERT INTO `tb_cc` VALUES (33, 6, 13, 0, 0);
INSERT INTO `tb_cc` VALUES (34, 6, 14, 0, 0);
INSERT INTO `tb_cc` VALUES (35, 7, 1, 0, 0);
INSERT INTO `tb_cc` VALUES (36, 7, 4, 0, 0);
INSERT INTO `tb_cc` VALUES (37, 7, 7, 0, 0);
INSERT INTO `tb_cc` VALUES (38, 7, 8, 0, 0);
INSERT INTO `tb_cc` VALUES (39, 7, 9, 0, 0);
INSERT INTO `tb_cc` VALUES (40, 7, 10, 0, 0);
INSERT INTO `tb_cc` VALUES (41, 7, 11, 0, 0);
INSERT INTO `tb_cc` VALUES (42, 7, 12, 0, 0);
INSERT INTO `tb_cc` VALUES (43, 7, 13, 0, 0);
INSERT INTO `tb_cc` VALUES (44, 7, 14, 0, 0);
INSERT INTO `tb_cc` VALUES (45, 7, 15, 0, 0);
INSERT INTO `tb_cc` VALUES (46, 7, 16, 0, 0);
INSERT INTO `tb_cc` VALUES (47, 8, 13, 0, 0);
INSERT INTO `tb_cc` VALUES (48, 8, 14, 0, 0);
INSERT INTO `tb_cc` VALUES (49, 8, 15, 0, 0);
INSERT INTO `tb_cc` VALUES (50, 8, 16, 0, 0);
INSERT INTO `tb_cc` VALUES (51, 9, 15, 0, 0);
INSERT INTO `tb_cc` VALUES (52, 9, 16, 0, 0);
INSERT INTO `tb_cc` VALUES (53, 10, 21, 0, 0);
INSERT INTO `tb_cc` VALUES (54, 10, 22, 0, 0);
INSERT INTO `tb_cc` VALUES (55, 10, 23, 0, 0);
INSERT INTO `tb_cc` VALUES (56, 10, 24, 0, 0);
INSERT INTO `tb_cc` VALUES (57, 11, 17, 0, 0);
INSERT INTO `tb_cc` VALUES (58, 11, 18, 0, 0);
INSERT INTO `tb_cc` VALUES (59, 21, 19, 0, 0);
INSERT INTO `tb_cc` VALUES (60, 21, 20, 0, 0);
INSERT INTO `tb_cc` VALUES (61, 22, 19, 0, 0);
INSERT INTO `tb_cc` VALUES (62, 22, 20, 0, 0);
INSERT INTO `tb_cc` VALUES (63, 23, 19, 0, 0);
INSERT INTO `tb_cc` VALUES (64, 23, 20, 0, 0);
INSERT INTO `tb_cc` VALUES (65, 24, 19, 0, 0);
INSERT INTO `tb_cc` VALUES (66, 24, 20, 0, 0);
INSERT INTO `tb_cc` VALUES (67, 25, 21, 0, 0);
INSERT INTO `tb_cc` VALUES (68, 25, 22, 0, 0);
INSERT INTO `tb_cc` VALUES (69, 25, 23, 0, 0);
INSERT INTO `tb_cc` VALUES (70, 25, 24, 0, 0);
INSERT INTO `tb_cc` VALUES (71, 26, 21, 0, 0);
INSERT INTO `tb_cc` VALUES (72, 26, 22, 0, 0);
INSERT INTO `tb_cc` VALUES (73, 26, 23, 0, 0);
INSERT INTO `tb_cc` VALUES (74, 26, 24, 0, 0);
INSERT INTO `tb_cc` VALUES (75, 27, 21, 0, 0);
INSERT INTO `tb_cc` VALUES (76, 27, 22, 0, 0);
INSERT INTO `tb_cc` VALUES (77, 27, 23, 0, 0);
INSERT INTO `tb_cc` VALUES (78, 27, 24, 0, 0);
INSERT INTO `tb_cc` VALUES (79, 28, 21, 0, 0);
INSERT INTO `tb_cc` VALUES (80, 28, 22, 0, 0);
INSERT INTO `tb_cc` VALUES (81, 28, 23, 0, 0);
INSERT INTO `tb_cc` VALUES (82, 28, 24, 0, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

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
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'absent/attended/其它为未签到',
  `time` datetime NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stu_id`(`stu_id` ASC) USING BTREE,
  INDEX `cour_id`(`course_id` ASC) USING BTREE,
  CONSTRAINT `cour_id` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_id` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 150 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_record
-- ----------------------------
INSERT INTO `tb_record` VALUES (130, 2, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (131, 3, 1, 'attended', '2024-06-24 14:19:51', 0);
INSERT INTO `tb_record` VALUES (132, 4, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (133, 5, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (134, 6, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (135, 7, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (136, 8, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (137, 9, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (138, 10, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (139, 11, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (140, 12, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (141, 13, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (142, 14, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (143, 15, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (144, 16, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (145, 17, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (146, 18, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (147, 19, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (148, 20, 1, 'absent', '2024-06-24 14:19:57', 0);
INSERT INTO `tb_record` VALUES (149, 21, 1, 'absent', '2024-06-24 14:19:57', 0);

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `stu_num` int NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `class_id` int NULL DEFAULT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `class_id`(`class_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 292 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (2, 2, 101, '李四', '男', 1, 0);
INSERT INTO `tb_student` VALUES (3, 3, 102, '王五', '男', 1, 0);
INSERT INTO `tb_student` VALUES (4, 4, 103, '赵六', '女', 1, 0);
INSERT INTO `tb_student` VALUES (5, 5, 104, '孙七', '男', 1, 0);
INSERT INTO `tb_student` VALUES (6, 6, 105, '周八', '女', 1, 0);
INSERT INTO `tb_student` VALUES (7, 7, 106, '吴九', '男', 1, 0);
INSERT INTO `tb_student` VALUES (8, 8, 107, '郑十', '女', 1, 0);
INSERT INTO `tb_student` VALUES (9, 9, 108, '王二', '男', 1, 0);
INSERT INTO `tb_student` VALUES (10, 10, 109, '冯三', '女', 1, 0);
INSERT INTO `tb_student` VALUES (11, 11, 110, '陈四', '男', 1, 0);
INSERT INTO `tb_student` VALUES (12, 12, 111, '褚五', '女', 1, 0);
INSERT INTO `tb_student` VALUES (13, 13, 112, '卫六', '男', 1, 0);
INSERT INTO `tb_student` VALUES (14, 14, 113, '蒋七', '女', 1, 0);
INSERT INTO `tb_student` VALUES (15, 15, 114, '沈八', '男', 1, 0);
INSERT INTO `tb_student` VALUES (16, 16, 115, '韩九', '女', 1, 0);
INSERT INTO `tb_student` VALUES (17, 17, 116, '杨十', '男', 1, 0);
INSERT INTO `tb_student` VALUES (18, 18, 117, '朱二', '女', 1, 0);
INSERT INTO `tb_student` VALUES (19, 19, 118, '秦三', '男', 1, 0);
INSERT INTO `tb_student` VALUES (20, 20, 119, '尤四', '女', 1, 0);
INSERT INTO `tb_student` VALUES (21, 21, 120, '许五', '男', 1, 0);
INSERT INTO `tb_student` VALUES (22, 22, 121, '何六', '女', 4, 0);
INSERT INTO `tb_student` VALUES (23, 23, 122, '吕七', '男', 4, 0);
INSERT INTO `tb_student` VALUES (24, 24, 123, '施八', '女', 4, 0);
INSERT INTO `tb_student` VALUES (25, 25, 124, '张九', '男', 4, 0);
INSERT INTO `tb_student` VALUES (26, 26, 125, '孔十', '女', 4, 0);
INSERT INTO `tb_student` VALUES (27, 27, 126, '曹二', '男', 4, 0);
INSERT INTO `tb_student` VALUES (28, 28, 127, '严三', '女', 4, 0);
INSERT INTO `tb_student` VALUES (29, 29, 128, '华四', '男', 4, 0);
INSERT INTO `tb_student` VALUES (30, 30, 129, '金五', '女', 4, 0);
INSERT INTO `tb_student` VALUES (31, 31, 130, '魏六', '男', 4, 0);
INSERT INTO `tb_student` VALUES (32, 32, 131, '陶七', '女', 4, 0);
INSERT INTO `tb_student` VALUES (33, 33, 132, '姜八', '男', 4, 0);
INSERT INTO `tb_student` VALUES (34, 34, 133, '戚九', '女', 4, 0);
INSERT INTO `tb_student` VALUES (35, 35, 134, '谢十', '男', 4, 0);
INSERT INTO `tb_student` VALUES (36, 36, 135, '邹二', '女', 4, 0);
INSERT INTO `tb_student` VALUES (37, 37, 136, '喻三', '男', 4, 0);
INSERT INTO `tb_student` VALUES (38, 38, 137, '柏四', '女', 4, 0);
INSERT INTO `tb_student` VALUES (39, 39, 138, '水五', '男', 4, 0);
INSERT INTO `tb_student` VALUES (40, 40, 139, '窦六', '女', 4, 0);
INSERT INTO `tb_student` VALUES (41, 41, 140, '章七', '男', 4, 0);
INSERT INTO `tb_student` VALUES (42, 42, 141, '云八', '女', 7, 0);
INSERT INTO `tb_student` VALUES (43, 43, 142, '苏九', '男', 7, 0);
INSERT INTO `tb_student` VALUES (44, 44, 143, '潘十', '女', 7, 0);
INSERT INTO `tb_student` VALUES (45, 45, 144, '葛二', '男', 7, 0);
INSERT INTO `tb_student` VALUES (46, 46, 145, '奚三', '女', 7, 0);
INSERT INTO `tb_student` VALUES (47, 47, 146, '范四', '男', 7, 0);
INSERT INTO `tb_student` VALUES (48, 48, 147, '彭五', '女', 7, 0);
INSERT INTO `tb_student` VALUES (49, 49, 148, '郎六', '男', 7, 0);
INSERT INTO `tb_student` VALUES (50, 50, 149, '鲁七', '女', 7, 0);
INSERT INTO `tb_student` VALUES (51, 51, 150, '韦八', '男', 7, 0);
INSERT INTO `tb_student` VALUES (52, 52, 151, '昌九', '女', 7, 0);
INSERT INTO `tb_student` VALUES (53, 53, 152, '马十', '男', 7, 0);
INSERT INTO `tb_student` VALUES (54, 54, 153, '苗二', '女', 7, 0);
INSERT INTO `tb_student` VALUES (55, 55, 154, '花三', '男', 7, 0);
INSERT INTO `tb_student` VALUES (56, 56, 155, '方四', '女', 7, 0);
INSERT INTO `tb_student` VALUES (57, 57, 156, '俞五', '男', 7, 0);
INSERT INTO `tb_student` VALUES (58, 58, 157, '任六', '女', 7, 0);
INSERT INTO `tb_student` VALUES (59, 59, 158, '袁七', '男', 7, 0);
INSERT INTO `tb_student` VALUES (60, 60, 159, '柳八', '女', 7, 0);
INSERT INTO `tb_student` VALUES (61, 61, 160, '酆九', '男', 7, 0);
INSERT INTO `tb_student` VALUES (62, 62, 161, '鲍十', '女', 8, 0);
INSERT INTO `tb_student` VALUES (63, 63, 162, '史二', '男', 8, 0);
INSERT INTO `tb_student` VALUES (64, 64, 163, '唐三', '女', 8, 0);
INSERT INTO `tb_student` VALUES (65, 65, 164, '费四', '男', 8, 0);
INSERT INTO `tb_student` VALUES (66, 66, 165, '廉五', '女', 8, 0);
INSERT INTO `tb_student` VALUES (67, 67, 166, '岑六', '男', 8, 0);
INSERT INTO `tb_student` VALUES (68, 68, 167, '薛七', '女', 8, 0);
INSERT INTO `tb_student` VALUES (69, 69, 168, '雷八', '男', 8, 0);
INSERT INTO `tb_student` VALUES (70, 70, 169, '贺九', '女', 8, 0);
INSERT INTO `tb_student` VALUES (71, 71, 170, '倪十', '男', 8, 0);
INSERT INTO `tb_student` VALUES (72, 72, 171, '汤二', '女', 8, 0);
INSERT INTO `tb_student` VALUES (73, 73, 172, '滕三', '男', 8, 0);
INSERT INTO `tb_student` VALUES (74, 74, 173, '殷四', '女', 8, 0);
INSERT INTO `tb_student` VALUES (75, 75, 174, '罗五', '男', 8, 0);
INSERT INTO `tb_student` VALUES (76, 76, 175, '毕六', '女', 8, 0);
INSERT INTO `tb_student` VALUES (77, 77, 176, '郝七', '男', 8, 0);
INSERT INTO `tb_student` VALUES (78, 78, 177, '邬八', '女', 8, 0);
INSERT INTO `tb_student` VALUES (79, 79, 178, '安九', '男', 8, 0);
INSERT INTO `tb_student` VALUES (80, 80, 179, '常十', '女', 8, 0);
INSERT INTO `tb_student` VALUES (81, 81, 180, '乐二', '男', 8, 0);
INSERT INTO `tb_student` VALUES (82, 82, 181, '于三', '女', 9, 0);
INSERT INTO `tb_student` VALUES (83, 83, 182, '时四', '男', 9, 0);
INSERT INTO `tb_student` VALUES (84, 84, 183, '傅五', '女', 9, 0);
INSERT INTO `tb_student` VALUES (85, 85, 184, '皮六', '男', 9, 0);
INSERT INTO `tb_student` VALUES (86, 86, 185, '卞七', '女', 9, 0);
INSERT INTO `tb_student` VALUES (87, 87, 186, '齐八', '男', 9, 0);
INSERT INTO `tb_student` VALUES (88, 88, 187, '康九', '女', 9, 0);
INSERT INTO `tb_student` VALUES (89, 89, 188, '伍十', '男', 9, 0);
INSERT INTO `tb_student` VALUES (90, 90, 189, '余二', '女', 9, 0);
INSERT INTO `tb_student` VALUES (91, 91, 190, '元三', '男', 9, 0);
INSERT INTO `tb_student` VALUES (92, 92, 191, '卜四', '女', 9, 0);
INSERT INTO `tb_student` VALUES (93, 93, 192, '顾五', '男', 9, 0);
INSERT INTO `tb_student` VALUES (94, 94, 193, '孟六', '女', 9, 0);
INSERT INTO `tb_student` VALUES (95, 95, 194, '平七', '男', 9, 0);
INSERT INTO `tb_student` VALUES (96, 96, 195, '黄八', '女', 9, 0);
INSERT INTO `tb_student` VALUES (97, 97, 196, '和九', '男', 9, 0);
INSERT INTO `tb_student` VALUES (98, 98, 197, '穆十', '女', 9, 0);
INSERT INTO `tb_student` VALUES (99, 99, 198, '萧二', '男', 9, 0);
INSERT INTO `tb_student` VALUES (100, 100, 199, '尹三', '女', 9, 0);
INSERT INTO `tb_student` VALUES (101, 101, 200, '姚四', '男', 9, 0);
INSERT INTO `tb_student` VALUES (102, 102, 201, '邵五', '女', 10, 0);
INSERT INTO `tb_student` VALUES (103, 103, 202, '湛六', '男', 10, 0);
INSERT INTO `tb_student` VALUES (104, 104, 203, '汪七', '女', 10, 0);
INSERT INTO `tb_student` VALUES (105, 105, 204, '祁八', '男', 10, 0);
INSERT INTO `tb_student` VALUES (106, 106, 205, '毛九', '女', 10, 0);
INSERT INTO `tb_student` VALUES (107, 107, 206, '禹十', '男', 10, 0);
INSERT INTO `tb_student` VALUES (108, 108, 207, '狄二', '女', 10, 0);
INSERT INTO `tb_student` VALUES (109, 109, 208, '米三', '男', 10, 0);
INSERT INTO `tb_student` VALUES (110, 110, 209, '贝四', '女', 10, 0);
INSERT INTO `tb_student` VALUES (111, 111, 210, '明五', '男', 10, 0);
INSERT INTO `tb_student` VALUES (112, 112, 211, '臧六', '女', 10, 0);
INSERT INTO `tb_student` VALUES (113, 113, 212, '计七', '男', 10, 0);
INSERT INTO `tb_student` VALUES (114, 114, 213, '伏八', '女', 10, 0);
INSERT INTO `tb_student` VALUES (115, 115, 214, '成九', '男', 10, 0);
INSERT INTO `tb_student` VALUES (116, 116, 215, '戴十', '女', 10, 0);
INSERT INTO `tb_student` VALUES (117, 117, 216, '谈二', '男', 10, 0);
INSERT INTO `tb_student` VALUES (118, 118, 217, '宋三', '女', 10, 0);
INSERT INTO `tb_student` VALUES (119, 119, 218, '茅四', '男', 10, 0);
INSERT INTO `tb_student` VALUES (120, 120, 219, '庞五', '女', 10, 0);
INSERT INTO `tb_student` VALUES (121, 121, 220, '熊六', '男', 10, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 202 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'root', 'root', '1', 0);
INSERT INTO `tb_user` VALUES (2, '101', '101', '2', 0);
INSERT INTO `tb_user` VALUES (3, '102', '102', '2', 0);
INSERT INTO `tb_user` VALUES (4, '103', '103', '2', 0);
INSERT INTO `tb_user` VALUES (5, '104', '104', '2', 0);
INSERT INTO `tb_user` VALUES (6, '105', '105', '2', 0);
INSERT INTO `tb_user` VALUES (7, '106', '106', '2', 0);
INSERT INTO `tb_user` VALUES (8, '107', '107', '2', 0);
INSERT INTO `tb_user` VALUES (9, '108', '108', '2', 0);
INSERT INTO `tb_user` VALUES (10, '109', '109', '2', 0);
INSERT INTO `tb_user` VALUES (11, '110', '110', '2', 0);
INSERT INTO `tb_user` VALUES (12, '111', '111', '2', 0);
INSERT INTO `tb_user` VALUES (13, '112', '112', '2', 0);
INSERT INTO `tb_user` VALUES (14, '113', '113', '2', 0);
INSERT INTO `tb_user` VALUES (15, '114', '114', '2', 0);
INSERT INTO `tb_user` VALUES (16, '115', '115', '2', 0);
INSERT INTO `tb_user` VALUES (17, '116', '116', '2', 0);
INSERT INTO `tb_user` VALUES (18, '117', '117', '2', 0);
INSERT INTO `tb_user` VALUES (19, '118', '118', '2', 0);
INSERT INTO `tb_user` VALUES (20, '119', '119', '2', 0);
INSERT INTO `tb_user` VALUES (21, '120', '120', '2', 0);
INSERT INTO `tb_user` VALUES (22, '121', '121', '2', 0);
INSERT INTO `tb_user` VALUES (23, '122', '122', '2', 0);
INSERT INTO `tb_user` VALUES (24, '123', '123', '2', 0);
INSERT INTO `tb_user` VALUES (25, '124', '124', '2', 0);
INSERT INTO `tb_user` VALUES (26, '125', '125', '2', 0);
INSERT INTO `tb_user` VALUES (27, '126', '126', '2', 0);
INSERT INTO `tb_user` VALUES (28, '127', '127', '2', 0);
INSERT INTO `tb_user` VALUES (29, '128', '128', '2', 0);
INSERT INTO `tb_user` VALUES (30, '129', '129', '2', 0);
INSERT INTO `tb_user` VALUES (31, '130', '130', '2', 0);
INSERT INTO `tb_user` VALUES (32, '131', '131', '2', 0);
INSERT INTO `tb_user` VALUES (33, '132', '132', '2', 0);
INSERT INTO `tb_user` VALUES (34, '133', '133', '2', 0);
INSERT INTO `tb_user` VALUES (35, '134', '134', '2', 0);
INSERT INTO `tb_user` VALUES (36, '135', '135', '2', 0);
INSERT INTO `tb_user` VALUES (37, '136', '136', '2', 0);
INSERT INTO `tb_user` VALUES (38, '137', '137', '2', 0);
INSERT INTO `tb_user` VALUES (39, '138', '138', '2', 0);
INSERT INTO `tb_user` VALUES (40, '139', '139', '2', 0);
INSERT INTO `tb_user` VALUES (41, '140', '140', '2', 0);
INSERT INTO `tb_user` VALUES (42, '141', '141', '2', 0);
INSERT INTO `tb_user` VALUES (43, '142', '142', '2', 0);
INSERT INTO `tb_user` VALUES (44, '143', '143', '2', 0);
INSERT INTO `tb_user` VALUES (45, '144', '144', '2', 0);
INSERT INTO `tb_user` VALUES (46, '145', '145', '2', 0);
INSERT INTO `tb_user` VALUES (47, '146', '146', '2', 0);
INSERT INTO `tb_user` VALUES (48, '147', '147', '2', 0);
INSERT INTO `tb_user` VALUES (49, '148', '148', '2', 0);
INSERT INTO `tb_user` VALUES (50, '149', '149', '2', 0);
INSERT INTO `tb_user` VALUES (51, '150', '150', '2', 0);
INSERT INTO `tb_user` VALUES (52, '151', '151', '2', 0);
INSERT INTO `tb_user` VALUES (53, '152', '152', '2', 0);
INSERT INTO `tb_user` VALUES (54, '153', '153', '2', 0);
INSERT INTO `tb_user` VALUES (55, '154', '154', '2', 0);
INSERT INTO `tb_user` VALUES (56, '155', '155', '2', 0);
INSERT INTO `tb_user` VALUES (57, '156', '156', '2', 0);
INSERT INTO `tb_user` VALUES (58, '157', '157', '2', 0);
INSERT INTO `tb_user` VALUES (59, '158', '158', '2', 0);
INSERT INTO `tb_user` VALUES (60, '159', '159', '2', 0);
INSERT INTO `tb_user` VALUES (61, '160', '160', '2', 0);
INSERT INTO `tb_user` VALUES (62, '161', '161', '2', 0);
INSERT INTO `tb_user` VALUES (63, '162', '162', '2', 0);
INSERT INTO `tb_user` VALUES (64, '163', '163', '2', 0);
INSERT INTO `tb_user` VALUES (65, '164', '164', '2', 0);
INSERT INTO `tb_user` VALUES (66, '165', '165', '2', 0);
INSERT INTO `tb_user` VALUES (67, '166', '166', '2', 0);
INSERT INTO `tb_user` VALUES (68, '167', '167', '2', 0);
INSERT INTO `tb_user` VALUES (69, '168', '168', '2', 0);
INSERT INTO `tb_user` VALUES (70, '169', '169', '2', 0);
INSERT INTO `tb_user` VALUES (71, '170', '170', '2', 0);
INSERT INTO `tb_user` VALUES (72, '171', '171', '2', 0);
INSERT INTO `tb_user` VALUES (73, '172', '172', '2', 0);
INSERT INTO `tb_user` VALUES (74, '173', '173', '2', 0);
INSERT INTO `tb_user` VALUES (75, '174', '174', '2', 0);
INSERT INTO `tb_user` VALUES (76, '175', '175', '2', 0);
INSERT INTO `tb_user` VALUES (77, '176', '176', '2', 0);
INSERT INTO `tb_user` VALUES (78, '177', '177', '2', 0);
INSERT INTO `tb_user` VALUES (79, '178', '178', '2', 0);
INSERT INTO `tb_user` VALUES (80, '179', '179', '2', 0);
INSERT INTO `tb_user` VALUES (81, '180', '180', '2', 0);
INSERT INTO `tb_user` VALUES (82, '181', '181', '2', 0);
INSERT INTO `tb_user` VALUES (83, '182', '182', '2', 0);
INSERT INTO `tb_user` VALUES (84, '183', '183', '2', 0);
INSERT INTO `tb_user` VALUES (85, '184', '184', '2', 0);
INSERT INTO `tb_user` VALUES (86, '185', '185', '2', 0);
INSERT INTO `tb_user` VALUES (87, '186', '186', '2', 0);
INSERT INTO `tb_user` VALUES (88, '187', '187', '2', 0);
INSERT INTO `tb_user` VALUES (89, '188', '188', '2', 0);
INSERT INTO `tb_user` VALUES (90, '189', '189', '2', 0);
INSERT INTO `tb_user` VALUES (91, '190', '190', '2', 0);
INSERT INTO `tb_user` VALUES (92, '191', '191', '2', 0);
INSERT INTO `tb_user` VALUES (93, '192', '192', '2', 0);
INSERT INTO `tb_user` VALUES (94, '193', '193', '2', 0);
INSERT INTO `tb_user` VALUES (95, '194', '194', '2', 0);
INSERT INTO `tb_user` VALUES (96, '195', '195', '2', 0);
INSERT INTO `tb_user` VALUES (97, '196', '196', '2', 0);
INSERT INTO `tb_user` VALUES (98, '197', '197', '2', 0);
INSERT INTO `tb_user` VALUES (99, '198', '198', '2', 0);
INSERT INTO `tb_user` VALUES (100, '199', '199', '2', 0);
INSERT INTO `tb_user` VALUES (101, '200', '200', '2', 0);
INSERT INTO `tb_user` VALUES (102, '201', '201', '2', 0);
INSERT INTO `tb_user` VALUES (103, '202', '202', '2', 0);
INSERT INTO `tb_user` VALUES (104, '203', '203', '2', 0);
INSERT INTO `tb_user` VALUES (105, '204', '204', '2', 0);
INSERT INTO `tb_user` VALUES (106, '205', '205', '2', 0);
INSERT INTO `tb_user` VALUES (107, '206', '206', '2', 0);
INSERT INTO `tb_user` VALUES (108, '207', '207', '2', 0);
INSERT INTO `tb_user` VALUES (109, '208', '208', '2', 0);
INSERT INTO `tb_user` VALUES (110, '209', '209', '2', 0);
INSERT INTO `tb_user` VALUES (111, '210', '210', '2', 0);
INSERT INTO `tb_user` VALUES (112, '211', '211', '2', 0);
INSERT INTO `tb_user` VALUES (113, '212', '212', '2', 0);
INSERT INTO `tb_user` VALUES (114, '213', '213', '2', 0);
INSERT INTO `tb_user` VALUES (115, '214', '214', '2', 0);
INSERT INTO `tb_user` VALUES (116, '215', '215', '2', 0);
INSERT INTO `tb_user` VALUES (117, '216', '216', '2', 0);
INSERT INTO `tb_user` VALUES (118, '217', '217', '2', 0);
INSERT INTO `tb_user` VALUES (119, '218', '218', '2', 0);
INSERT INTO `tb_user` VALUES (120, '219', '219', '2', 0);
INSERT INTO `tb_user` VALUES (121, '220', '220', '2', 0);
INSERT INTO `tb_user` VALUES (122, '221', '221', '2', 0);
INSERT INTO `tb_user` VALUES (123, '222', '222', '2', 0);
INSERT INTO `tb_user` VALUES (124, '223', '223', '2', 0);
INSERT INTO `tb_user` VALUES (125, '224', '224', '2', 0);
INSERT INTO `tb_user` VALUES (126, '225', '225', '2', 0);
INSERT INTO `tb_user` VALUES (127, '226', '226', '2', 0);
INSERT INTO `tb_user` VALUES (128, '227', '227', '2', 0);
INSERT INTO `tb_user` VALUES (129, '228', '228', '2', 0);
INSERT INTO `tb_user` VALUES (130, '229', '229', '2', 0);
INSERT INTO `tb_user` VALUES (131, '230', '230', '2', 0);
INSERT INTO `tb_user` VALUES (132, '231', '231', '2', 0);
INSERT INTO `tb_user` VALUES (133, '232', '232', '2', 0);
INSERT INTO `tb_user` VALUES (134, '233', '233', '2', 0);
INSERT INTO `tb_user` VALUES (135, '234', '234', '2', 0);
INSERT INTO `tb_user` VALUES (136, '235', '235', '2', 0);
INSERT INTO `tb_user` VALUES (137, '236', '236', '2', 0);
INSERT INTO `tb_user` VALUES (138, '237', '237', '2', 0);
INSERT INTO `tb_user` VALUES (139, '238', '238', '2', 0);
INSERT INTO `tb_user` VALUES (140, '239', '239', '2', 0);
INSERT INTO `tb_user` VALUES (141, '240', '240', '2', 0);
INSERT INTO `tb_user` VALUES (142, '241', '241', '2', 0);
INSERT INTO `tb_user` VALUES (143, '242', '242', '2', 0);
INSERT INTO `tb_user` VALUES (144, '243', '243', '2', 0);
INSERT INTO `tb_user` VALUES (145, '244', '244', '2', 0);
INSERT INTO `tb_user` VALUES (146, '245', '245', '2', 0);
INSERT INTO `tb_user` VALUES (147, '246', '246', '2', 0);
INSERT INTO `tb_user` VALUES (148, '247', '247', '2', 0);
INSERT INTO `tb_user` VALUES (149, '248', '248', '2', 0);
INSERT INTO `tb_user` VALUES (150, '249', '249', '2', 0);
INSERT INTO `tb_user` VALUES (151, '250', '250', '2', 0);
INSERT INTO `tb_user` VALUES (152, '251', '251', '2', 0);
INSERT INTO `tb_user` VALUES (153, '252', '252', '2', 0);
INSERT INTO `tb_user` VALUES (154, '253', '253', '2', 0);
INSERT INTO `tb_user` VALUES (155, '254', '254', '2', 0);
INSERT INTO `tb_user` VALUES (156, '255', '255', '2', 0);
INSERT INTO `tb_user` VALUES (157, '256', '256', '2', 0);
INSERT INTO `tb_user` VALUES (158, '257', '257', '2', 0);
INSERT INTO `tb_user` VALUES (159, '258', '258', '2', 0);
INSERT INTO `tb_user` VALUES (160, '259', '259', '2', 0);
INSERT INTO `tb_user` VALUES (161, '260', '260', '2', 0);
INSERT INTO `tb_user` VALUES (162, '261', '261', '2', 0);
INSERT INTO `tb_user` VALUES (163, '262', '262', '2', 0);
INSERT INTO `tb_user` VALUES (164, '263', '263', '2', 0);
INSERT INTO `tb_user` VALUES (165, '264', '264', '2', 0);
INSERT INTO `tb_user` VALUES (166, '265', '265', '2', 0);
INSERT INTO `tb_user` VALUES (167, '266', '266', '2', 0);
INSERT INTO `tb_user` VALUES (168, '267', '267', '2', 0);
INSERT INTO `tb_user` VALUES (169, '268', '268', '2', 0);
INSERT INTO `tb_user` VALUES (170, '269', '269', '2', 0);
INSERT INTO `tb_user` VALUES (171, '270', '270', '2', 0);
INSERT INTO `tb_user` VALUES (172, '271', '271', '2', 0);
INSERT INTO `tb_user` VALUES (173, '272', '272', '2', 0);
INSERT INTO `tb_user` VALUES (174, '273', '273', '2', 0);
INSERT INTO `tb_user` VALUES (175, '274', '274', '2', 0);
INSERT INTO `tb_user` VALUES (176, '275', '275', '2', 0);
INSERT INTO `tb_user` VALUES (177, '276', '276', '2', 0);
INSERT INTO `tb_user` VALUES (178, '277', '277', '2', 0);
INSERT INTO `tb_user` VALUES (179, '278', '278', '2', 0);
INSERT INTO `tb_user` VALUES (180, '279', '279', '2', 0);
INSERT INTO `tb_user` VALUES (181, '280', '280', '2', 0);
INSERT INTO `tb_user` VALUES (182, '281', '281', '2', 0);
INSERT INTO `tb_user` VALUES (183, '282', '282', '2', 0);
INSERT INTO `tb_user` VALUES (184, '283', '283', '2', 0);
INSERT INTO `tb_user` VALUES (185, '284', '284', '2', 0);
INSERT INTO `tb_user` VALUES (186, '285', '285', '2', 0);
INSERT INTO `tb_user` VALUES (187, '286', '286', '2', 0);
INSERT INTO `tb_user` VALUES (188, '287', '287', '2', 0);
INSERT INTO `tb_user` VALUES (189, '288', '288', '2', 0);
INSERT INTO `tb_user` VALUES (190, '289', '289', '2', 0);
INSERT INTO `tb_user` VALUES (191, '290', '290', '2', 0);
INSERT INTO `tb_user` VALUES (192, '291', '291', '2', 0);
INSERT INTO `tb_user` VALUES (193, '292', '292', '2', 0);
INSERT INTO `tb_user` VALUES (194, '293', '293', '2', 0);
INSERT INTO `tb_user` VALUES (195, '294', '294', '2', 0);
INSERT INTO `tb_user` VALUES (196, '295', '295', '2', 0);
INSERT INTO `tb_user` VALUES (197, '296', '296', '2', 0);
INSERT INTO `tb_user` VALUES (198, '297', '297', '2', 0);
INSERT INTO `tb_user` VALUES (199, '298', '298', '2', 0);
INSERT INTO `tb_user` VALUES (200, '299', '299', '2', 0);
INSERT INTO `tb_user` VALUES (201, '300', '300', '2', 0);

-- ----------------------------
-- View structure for record_detail
-- ----------------------------
DROP VIEW IF EXISTS `record_detail`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `record_detail` AS select `tb_student`.`stu_num` AS `stu_num`,`tb_student`.`stu_name` AS `stu_name`,`tb_student`.`gender` AS `gender`,`tb_class`.`cl_name` AS `class_name`,`tb_college`.`col_name` AS `col_name`,`tb_course`.`course_name` AS `course_name`,`tb_record`.`status` AS `status`,`tb_record`.`time` AS `time` from (((((`tb_student` join `tb_class` on((`tb_student`.`class_id` = `tb_class`.`id`))) join `tb_college` on((`tb_class`.`college_id` = `tb_college`.`id`))) join `tb_cc` on((`tb_class`.`id` = `tb_cc`.`class_id`))) join `tb_course` on((`tb_cc`.`course_id` = `tb_course`.`id`))) join `tb_record` on(((`tb_course`.`id` = `tb_record`.`course_id`) and (`tb_student`.`id` = `tb_record`.`stu_id`)))) where ((`tb_student`.`deleted` = 0) and (`tb_class`.`deleted` = 0) and (`tb_college`.`deleted` = 0) and (`tb_cc`.`deleted` = 0) and (`tb_course`.`deleted` = 0) and (`tb_record`.`deleted` = 0));

SET FOREIGN_KEY_CHECKS = 1;
