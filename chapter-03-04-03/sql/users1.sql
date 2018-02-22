/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : users1

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-10-30 09:17:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID' ,
`username`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
`state`  tinyint(4) NULL DEFAULT NULL COMMENT '状态' ,
`isdel`  bit(1) NULL DEFAULT NULL COMMENT '是否删除' ,
`remark`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注' ,
`add_time`  datetime NULL DEFAULT NULL COMMENT '添加时间' ,
`money`  decimal(10,2) NULL DEFAULT NULL COMMENT '金额' ,
`left_money`  float NULL DEFAULT NULL COMMENT '剩下的钱' ,
`flag`  int(11) NULL DEFAULT 1 ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户表'
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', '王五', '0', '', '批量修改备注', '2017-02-21 10:37:44', '101.10', '22.1', '1'), ('2', '张三', '0', '', '批量修改备注', '2017-02-21 10:40:11', '100.50', '22.1', '1'), ('3', '张三', '1', '', '备注', '2017-02-21 10:40:11', '100.50', '22.1', '1'), ('4', '张三', '0', '', '批量修改备注', '2017-02-21 10:40:11', '100.50', '22.1', '1'), ('5', '张三', '0', '', '批量修改备注', '2017-02-21 10:40:11', '100.50', '22.1', '1'), ('6', '张三', '0', '', '批量修改备注', '2017-02-21 10:40:11', '100.50', '22.1', '1');
COMMIT;

-- ----------------------------
-- Auto increment value for `t_user`
-- ----------------------------
ALTER TABLE `t_user` AUTO_INCREMENT=7;
