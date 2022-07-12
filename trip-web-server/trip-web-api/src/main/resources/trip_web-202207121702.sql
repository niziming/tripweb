-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: trip_web
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_account`
--

DROP TABLE IF EXISTS `base_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账户标识',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='基础账户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `base_scenic_spot`
--

DROP TABLE IF EXISTS `base_scenic_spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base_scenic_spot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '景点信息标题',
  `author` bigint(20) DEFAULT NULL COMMENT '景点发布作者ID',
  `author_name` varchar(32) DEFAULT NULL COMMENT '景点发布作者姓名',
  `type` varchar(32) DEFAULT NULL COMMENT '景点类型',
  `avatar` varchar(64) DEFAULT NULL COMMENT '景点缩略图',
  `phone` varchar(32) DEFAULT NULL COMMENT '景点联系电话',
  `level` varchar(1) DEFAULT NULL COMMENT '景点级别',
  `price` double DEFAULT NULL COMMENT '景点门票',
  `location` varchar(100) DEFAULT NULL COMMENT '景点位置',
  `zip` varchar(100) DEFAULT NULL COMMENT '景点邮政编码',
  `open_range_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '景点开放时间',
  `creatTime` timestamp NULL DEFAULT NULL COMMENT '景点信息发布时间',
  `content` text COMMENT '景点描述内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='基础景点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `base_user`
--

DROP TABLE IF EXISTS `base_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `avatar` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `intro` text COMMENT '简介',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='基础用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bus_comments`
--

DROP TABLE IF EXISTS `bus_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bus_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父评论id',
  `content` text COMMENT '内容',
  `like` int(11) DEFAULT NULL COMMENT '点赞',
  `createTime` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='业务评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rela_comments_entity`
--

DROP TABLE IF EXISTS `rela_comments_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rela_comments_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `entity_id` bigint(20) DEFAULT NULL COMMENT '实体id',
  `comments_id` bigint(20) DEFAULT NULL COMMENT '评论id',
  `type` varchar(64) DEFAULT NULL COMMENT '评论与实体关联类型{景点:SCENIC_SPOT}',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关联评论与实体关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rela_user_account`
--

DROP TABLE IF EXISTS `rela_user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rela_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `account_id` bigint(20) DEFAULT NULL COMMENT '账户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='关联表用户与账户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rela_user_comments`
--

DROP TABLE IF EXISTS `rela_user_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rela_user_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `comments_id` bigint(20) DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='关联用户评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `view_comments_entity_user`
--

DROP TABLE IF EXISTS `view_comments_entity_user`;
/*!50001 DROP VIEW IF EXISTS `view_comments_entity_user`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `view_comments_entity_user` AS SELECT 
 1 AS `name`,
 1 AS `avatar`,
 1 AS `phone`,
 1 AS `intro`,
 1 AS `parent_id`,
 1 AS `content`,
 1 AS `type`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_user_account`
--

DROP TABLE IF EXISTS `view_user_account`;
/*!50001 DROP VIEW IF EXISTS `view_user_account`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `view_user_account` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `avatar`,
 1 AS `phone`,
 1 AS `intro`,
 1 AS `username`,
 1 AS `password`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'trip_web'
--

--
-- Final view structure for view `view_comments_entity_user`
--

/*!50001 DROP VIEW IF EXISTS `view_comments_entity_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_comments_entity_user` AS select `bu`.`name` AS `name`,`bu`.`avatar` AS `avatar`,`bu`.`phone` AS `phone`,`bu`.`intro` AS `intro`,`bc`.`parent_id` AS `parent_id`,`bc`.`content` AS `content`,`rce`.`type` AS `type` from ((((`base_scenic_spot` `bss` join `rela_comments_entity` `rce` on((`bss`.`id` = `rce`.`entity_id`))) join `rela_user_comments` `ruc` on((`rce`.`comments_id` = `ruc`.`comments_id`))) join `bus_comments` `bc` on((`ruc`.`comments_id` = `bc`.`id`))) join `base_user` `bu` on((`ruc`.`user_id` = `bu`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_user_account`
--

/*!50001 DROP VIEW IF EXISTS `view_user_account`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_user_account` AS select `rua`.`id` AS `id`,`bu`.`name` AS `name`,`bu`.`avatar` AS `avatar`,`bu`.`phone` AS `phone`,`bu`.`intro` AS `intro`,`ba`.`username` AS `username`,`ba`.`password` AS `password` from ((`base_user` `bu` join `rela_user_account` `rua` on((`bu`.`id` = `rua`.`user_id`))) join `base_account` `ba` on((`ba`.`id` = `rua`.`account_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-12 17:02:39
