-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springboot14js1
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springboot14js1`
--

/*!40000 DROP DATABASE IF EXISTS `springboot14js1`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springboot14js1` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot14js1`;

--
-- Table structure for table `bumen`
--

DROP TABLE IF EXISTS `bumen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bumen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bumen` varchar(200) NOT NULL COMMENT '部门',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bumen` (`bumen`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bumen`
--

LOCK TABLES `bumen` WRITE;
/*!40000 ALTER TABLE `bumen` DISABLE KEYS */;
INSERT INTO `bumen` VALUES (21,'2030-02-26 08:06:38','人事部'),(22,'2030-02-26 08:06:38','财务部'),(23,'2030-02-26 08:06:38','行政部'),(24,'2030-02-26 08:06:38','后勤部'),(25,'2030-02-26 08:06:38','技术部');
/*!40000 ALTER TABLE `bumen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bumenlingdao`
--

DROP TABLE IF EXISTS `bumenlingdao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bumenlingdao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lingdaozhanghao` varchar(200) NOT NULL COMMENT '领导账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `lingdaoxingming` varchar(200) NOT NULL COMMENT '领导姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `zhaopian` varchar(200) DEFAULT NULL COMMENT '照片',
  `bumen` varchar(200) NOT NULL COMMENT '部门',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lingdaozhanghao` (`lingdaozhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='部门领导';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bumenlingdao`
--

LOCK TABLES `bumenlingdao` WRITE;
/*!40000 ALTER TABLE `bumenlingdao` DISABLE KEYS */;
INSERT INTO `bumenlingdao` VALUES (41,'2030-02-26 08:06:38','领导账号1','123456','领导姓名1','女','upload/bumenlingdao_zhaopian1.jpg','人事部','13823888881'),(42,'2030-02-26 08:06:38','领导账号2','123456','领导姓名2','男','upload/bumenlingdao_zhaopian2.jpg','部门2','13823888882'),(43,'2030-02-26 08:06:38','领导账号3','123456','领导姓名3','男','upload/bumenlingdao_zhaopian3.jpg','部门3','13823888883'),(44,'2030-02-26 08:06:38','领导账号4','123456','领导姓名4','男','upload/bumenlingdao_zhaopian4.jpg','部门4','13823888884'),(45,'2030-02-26 08:06:38','领导账号5','123456','领导姓名5','男','upload/bumenlingdao_zhaopian5.jpg','部门5','13823888885'),(46,'2030-02-26 08:06:38','领导账号6','123456','领导姓名6','男','upload/bumenlingdao_zhaopian6.jpg','部门6','13823888886');
/*!40000 ALTER TABLE `bumenlingdao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoxinxi`
--

DROP TABLE IF EXISTS `gonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonggaobiaoti` varchar(200) NOT NULL COMMENT '公告标题',
  `gonggaoleixing` varchar(200) NOT NULL COMMENT '公告类型',
  `gonggaotupian` varchar(200) DEFAULT NULL COMMENT '公告图片',
  `gonggaoneirong` longtext COMMENT '公告内容',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864216075 DEFAULT CHARSET=utf8 COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoxinxi`
--

LOCK TABLES `gonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `gonggaoxinxi` DISABLE KEYS */;
INSERT INTO `gonggaoxinxi` VALUES (11,'2030-02-26 08:06:38','公告标题1','通知','upload/gonggaoxinxi_gonggaotupian1.jpg','公告内容1','2030-02-26'),(12,'2030-02-26 08:06:38','公告标题2','公告','upload/gonggaoxinxi_gonggaotupian2.jpg','公告内容2','2030-02-26'),(13,'2030-02-26 08:06:38','公告标题3','其它','upload/gonggaoxinxi_gonggaotupian3.jpg','公告内容3','2030-02-26'),(14,'2030-02-26 08:06:38','公告标题4','资讯','upload/gonggaoxinxi_gonggaotupian4.jpg','公告内容4','2030-02-26'),(15,'2030-02-26 08:06:38','公告标题5','公告','upload/gonggaoxinxi_gonggaotupian5.jpg','公告内容5','2030-02-26'),(16,'2030-02-26 08:06:38','公告标题6','资讯','upload/gonggaoxinxi_gonggaotupian6.jpg','公告内容6','2030-02-26'),(1645864216074,'2030-02-26 08:30:15','AA','通知','upload/1645864212703.jpg','AA','2030-02-26');
/*!40000 ALTER TABLE `gonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongzuojilu`
--

DROP TABLE IF EXISTS `gongzuojilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gongzuojilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renwumingcheng` varchar(200) DEFAULT NULL COMMENT '任务名称',
  `gongzuofujian` varchar(200) DEFAULT NULL COMMENT '工作附件',
  `tijiaoneirong` longtext COMMENT '提交内容',
  `tijiaoriqi` date DEFAULT NULL COMMENT '提交日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864187005 DEFAULT CHARSET=utf8 COMMENT='工作记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongzuojilu`
--

LOCK TABLES `gongzuojilu` WRITE;
/*!40000 ALTER TABLE `gongzuojilu` DISABLE KEYS */;
INSERT INTO `gongzuojilu` VALUES (161,'2030-02-26 08:06:38','任务名称1','','提交内容1','2030-02-26','员工工号1','员工姓名1','部门1','职位1','领导账号1','领导姓名1',1,1,'是',''),(162,'2030-02-26 08:06:38','任务名称2','','提交内容2','2030-02-26','员工工号2','员工姓名2','部门2','职位2','领导账号2','领导姓名2',2,2,'是',''),(163,'2030-02-26 08:06:38','任务名称3','','提交内容3','2030-02-26','员工工号3','员工姓名3','部门3','职位3','领导账号3','领导姓名3',3,3,'是',''),(164,'2030-02-26 08:06:38','任务名称4','','提交内容4','2030-02-26','员工工号4','员工姓名4','部门4','职位4','领导账号4','领导姓名4',4,4,'是',''),(165,'2030-02-26 08:06:38','任务名称5','','提交内容5','2030-02-26','员工工号5','员工姓名5','部门5','职位5','领导账号5','领导姓名5',5,5,'是',''),(166,'2030-02-26 08:06:38','任务名称6','','提交内容6','2030-02-26','员工工号6','员工姓名6','部门6','职位6','领导账号6','领导姓名6',6,6,'是',''),(1645864187004,'2030-02-26 08:29:46','AA','upload/1645864178970.zip','这里提交工作记录给领导','2030-02-26','员工工号1','员工姓名1','人事部','技术员','领导账号1','领导姓名1',51,1645863849678,'否','');
/*!40000 ALTER TABLE `gongzuojilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongzuojinsheng`
--

DROP TABLE IF EXISTS `gongzuojinsheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gongzuojinsheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `jinshengzhiwei` varchar(200) NOT NULL COMMENT '晋升职位',
  `jinshengriqi` date DEFAULT NULL COMMENT '晋升日期',
  `jinshengneirong` longtext COMMENT '晋升内容',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645863871621 DEFAULT CHARSET=utf8 COMMENT='工作晋升';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongzuojinsheng`
--

LOCK TABLES `gongzuojinsheng` WRITE;
/*!40000 ALTER TABLE `gongzuojinsheng` DISABLE KEYS */;
INSERT INTO `gongzuojinsheng` VALUES (91,'2030-02-26 08:06:38','员工工号1','员工姓名1','部门1','职位1','13823888881','晋升职位1','2030-02-26','晋升内容1','领导账号1','领导姓名1'),(92,'2030-02-26 08:06:38','员工工号2','员工姓名2','部门2','职位2','13823888882','晋升职位2','2030-02-26','晋升内容2','领导账号2','领导姓名2'),(93,'2030-02-26 08:06:38','员工工号3','员工姓名3','部门3','职位3','13823888883','晋升职位3','2030-02-26','晋升内容3','领导账号3','领导姓名3'),(94,'2030-02-26 08:06:38','员工工号4','员工姓名4','部门4','职位4','13823888884','晋升职位4','2030-02-26','晋升内容4','领导账号4','领导姓名4'),(95,'2030-02-26 08:06:38','员工工号5','员工姓名5','部门5','职位5','13823888885','晋升职位5','2030-02-26','晋升内容5','领导账号5','领导姓名5'),(96,'2030-02-26 08:06:38','员工工号6','员工姓名6','部门6','职位6','13823888886','晋升职位6','2030-02-26','晋升内容6','领导账号6','领导姓名6'),(1645863871620,'2030-02-26 08:24:30','员工工号1','员工姓名1','人事部','专员','13823888881','技术员','2030-02-26','111','领导账号1','领导姓名1');
/*!40000 ALTER TABLE `gongzuojinsheng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongzuorenwu`
--

DROP TABLE IF EXISTS `gongzuorenwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gongzuorenwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `renwumingcheng` varchar(200) NOT NULL COMMENT '任务名称',
  `renwuyaoqiu` varchar(200) DEFAULT NULL COMMENT '任务要求',
  `renwufujian` varchar(200) DEFAULT NULL COMMENT '任务附件',
  `renwuneirong` longtext COMMENT '任务内容',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645863849679 DEFAULT CHARSET=utf8 COMMENT='工作任务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongzuorenwu`
--

LOCK TABLES `gongzuorenwu` WRITE;
/*!40000 ALTER TABLE `gongzuorenwu` DISABLE KEYS */;
INSERT INTO `gongzuorenwu` VALUES (151,'2030-02-26 08:06:38','任务名称1','任务要求1','','任务内容1','2030-02-26','员工工号1','员工姓名1','部门1','职位1','领导账号1','领导姓名1'),(152,'2030-02-26 08:06:38','任务名称2','任务要求2','','任务内容2','2030-02-26','员工工号2','员工姓名2','部门2','职位2','领导账号2','领导姓名2'),(153,'2030-02-26 08:06:38','任务名称3','任务要求3','','任务内容3','2030-02-26','员工工号3','员工姓名3','部门3','职位3','领导账号3','领导姓名3'),(154,'2030-02-26 08:06:38','任务名称4','任务要求4','','任务内容4','2030-02-26','员工工号4','员工姓名4','部门4','职位4','领导账号4','领导姓名4'),(155,'2030-02-26 08:06:38','任务名称5','任务要求5','','任务内容5','2030-02-26','员工工号5','员工姓名5','部门5','职位5','领导账号5','领导姓名5'),(156,'2030-02-26 08:06:38','任务名称6','任务要求6','','任务内容6','2030-02-26','员工工号6','员工姓名6','部门6','职位6','领导账号6','领导姓名6'),(1645863849678,'2030-02-26 08:24:09','AA','AA','upload/1645863841284.zip','附件支持上传文档 文本  表格等文件','2030-02-26','员工工号1','员工姓名1','人事部','专员','领导账号1','领导姓名1');
/*!40000 ALTER TABLE `gongzuorenwu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hetongxinxi`
--

DROP TABLE IF EXISTS `hetongxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hetongxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hetongbianhao` varchar(200) DEFAULT NULL COMMENT '合同编号',
  `hetongmingcheng` varchar(200) DEFAULT NULL COMMENT '合同名称',
  `hetongleixing` varchar(200) NOT NULL COMMENT '合同类型',
  `hetongwenjian` varchar(200) DEFAULT NULL COMMENT '合同文件',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `riqi` date DEFAULT NULL COMMENT '日期',
  `hetongxinxi` varchar(200) DEFAULT NULL COMMENT '合同信息',
  `hetongshuoming` longtext COMMENT '合同说明',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hetongbianhao` (`hetongbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864350975 DEFAULT CHARSET=utf8 COMMENT='合同信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hetongxinxi`
--

LOCK TABLES `hetongxinxi` WRITE;
/*!40000 ALTER TABLE `hetongxinxi` DISABLE KEYS */;
INSERT INTO `hetongxinxi` VALUES (81,'2030-02-26 08:06:38','1111111111','合同名称1','初签','','员工工号1','员工姓名1','部门1','职位1','2030-02-26','合同信息1','合同说明1','领导账号1','领导姓名1'),(82,'2030-02-26 08:06:38','2222222222','合同名称2','初签','','员工工号2','员工姓名2','部门2','职位2','2030-02-26','合同信息2','合同说明2','领导账号2','领导姓名2'),(83,'2030-02-26 08:06:38','3333333333','合同名称3','初签','','员工工号3','员工姓名3','部门3','职位3','2030-02-26','合同信息3','合同说明3','领导账号3','领导姓名3'),(84,'2030-02-26 08:06:38','4444444444','合同名称4','初签','','员工工号4','员工姓名4','部门4','职位4','2030-02-26','合同信息4','合同说明4','领导账号4','领导姓名4'),(85,'2030-02-26 08:06:38','5555555555','合同名称5','初签','','员工工号5','员工姓名5','部门5','职位5','2030-02-26','合同信息5','合同说明5','领导账号5','领导姓名5'),(86,'2030-02-26 08:06:38','6666666666','合同名称6','初签','','员工工号6','员工姓名6','部门6','职位6','2030-02-26','合同信息6','合同说明6','领导账号6','领导姓名6'),(1645864350974,'2030-02-26 08:32:30','1645864354746','AAA','续签','upload/1645864346771.zip','员工工号1','员工姓名1','人事部','技术员','2030-02-26','11','111','领导账号1','领导姓名1');
/*!40000 ALTER TABLE `hetongxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lingdaogongzi`
--

DROP TABLE IF EXISTS `lingdaogongzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lingdaogongzi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongzimingcheng` varchar(200) NOT NULL COMMENT '工资名称',
  `gongziyuefen` varchar(200) NOT NULL COMMENT '工资月份',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `dixin` int(11) NOT NULL COMMENT '底薪',
  `jiangjin` int(11) NOT NULL COMMENT '奖金',
  `jixiao` int(11) NOT NULL COMMENT '绩效',
  `gangweibutie` int(11) NOT NULL COMMENT '岗位补贴',
  `quanqinjiang` int(11) NOT NULL COMMENT '全勤奖',
  `jiabanfei` int(11) NOT NULL COMMENT '加班费',
  `koujixiao` int(11) NOT NULL COMMENT '扣绩效',
  `qitakoukuan` int(11) NOT NULL COMMENT '其它扣款',
  `kouwuxianyijin` int(11) NOT NULL COMMENT '扣五险一金',
  `shifagongzi` varchar(200) DEFAULT NULL COMMENT '实发工资',
  `gongzibeizhu` varchar(200) DEFAULT NULL COMMENT '工资备注',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864277294 DEFAULT CHARSET=utf8 COMMENT='领导工资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lingdaogongzi`
--

LOCK TABLES `lingdaogongzi` WRITE;
/*!40000 ALTER TABLE `lingdaogongzi` DISABLE KEYS */;
INSERT INTO `lingdaogongzi` VALUES (61,'2030-02-26 08:06:38','工资名称1','一月','领导账号1','领导姓名1','性别1','部门1',1,1,1,1,1,1,1,1,1,'实发工资1','工资备注1','2030-02-26'),(62,'2030-02-26 08:06:38','工资名称2','一月','领导账号2','领导姓名2','性别2','部门2',2,2,2,2,2,2,2,2,2,'实发工资2','工资备注2','2030-02-26'),(63,'2030-02-26 08:06:38','工资名称3','一月','领导账号3','领导姓名3','性别3','部门3',3,3,3,3,3,3,3,3,3,'实发工资3','工资备注3','2030-02-26'),(64,'2030-02-26 08:06:38','工资名称4','一月','领导账号4','领导姓名4','性别4','部门4',4,4,4,4,4,4,4,4,4,'实发工资4','工资备注4','2030-02-26'),(65,'2030-02-26 08:06:38','工资名称5','一月','领导账号5','领导姓名5','性别5','部门5',5,5,5,5,5,5,5,5,5,'实发工资5','工资备注5','2030-02-26'),(66,'2030-02-26 08:06:38','工资名称6','一月','领导账号6','领导姓名6','性别6','部门6',6,6,6,6,6,6,6,6,6,'实发工资6','工资备注6','2030-02-26'),(1645864277293,'2030-02-26 08:31:17','AA','二月','领导账号1','领导姓名1','女','人事部',2300,1500,1500,800,1000,0,0,0,1000,'6100','','2030-02-26');
/*!40000 ALTER TABLE `lingdaogongzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lingdaojixiaokaohe`
--

DROP TABLE IF EXISTS `lingdaojixiaokaohe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lingdaojixiaokaohe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kaohemingcheng` varchar(200) DEFAULT NULL COMMENT '考核名称',
  `kaohefanwei` varchar(200) DEFAULT NULL COMMENT '考核范围',
  `kaohezhouqi` varchar(200) DEFAULT NULL COMMENT '考核周期',
  `kaoheyuefen` varchar(200) NOT NULL COMMENT '考核月份',
  `kaohedafen` int(11) NOT NULL COMMENT '考核打分',
  `kaohepingji` varchar(200) NOT NULL COMMENT '考核评级',
  `kaohepingjia` varchar(200) DEFAULT NULL COMMENT '考核评价',
  `kaoheneirong` longtext NOT NULL COMMENT '考核内容',
  `kaoheriqi` date DEFAULT NULL COMMENT '考核日期',
  `kaohebeizhu` varchar(200) DEFAULT NULL COMMENT '考核备注',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8 COMMENT='领导绩效考核';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lingdaojixiaokaohe`
--

LOCK TABLES `lingdaojixiaokaohe` WRITE;
/*!40000 ALTER TABLE `lingdaojixiaokaohe` DISABLE KEYS */;
INSERT INTO `lingdaojixiaokaohe` VALUES (141,'2030-02-26 08:06:38','考核名称1','考核范围1','考核周期1','一月',1,'优','考核评价1','考核内容1','2030-02-26','考核备注1','领导账号1','领导姓名1','部门1'),(142,'2030-02-26 08:06:38','考核名称2','考核范围2','考核周期2','一月',2,'良','考核评价2','考核内容2','2030-02-26','考核备注2','领导账号2','领导姓名2','部门2'),(143,'2030-02-26 08:06:38','考核名称3','考核范围3','考核周期3','一月',3,'中','考核评价3','考核内容3','2030-02-26','考核备注3','领导账号3','领导姓名3','部门3'),(144,'2030-02-26 08:06:38','考核名称4','考核范围4','考核周期4','一月',4,'优','考核评价4','考核内容4','2030-02-26','考核备注4','领导账号4','领导姓名4','部门4'),(145,'2030-02-26 08:06:38','考核名称5','考核范围5','考核周期5','一月',5,'差','考核评价5','考核内容5','2030-02-26','考核备注5','领导账号5','领导姓名5','部门5'),(146,'2030-02-26 08:06:38','考核名称6','考核范围6','考核周期6','一月',6,'优','考核评价6','考核内容6','2030-02-26','考核备注6','领导账号6','领导姓名6','部门6');
/*!40000 ALTER TABLE `lingdaojixiaokaohe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2030-02-26 08:06:38','[{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi","parentMenuName":"公告信息管理"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"部门","menuJump":"列表","tableName":"bumen","parentMenuName":"部门管理"},{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除"],"menu":"职位","menuJump":"列表","tableName":"zhiwei","parentMenuName":"部门管理"}],"menu":"部门管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","修改","删除"],"menu":"部门领导","menuJump":"列表","tableName":"bumenlingdao","parentMenuName":"部门领导管理"}],"menu":"部门领导管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["人事调动","查看","修改","删除","报表"],"menu":"员工","menuJump":"列表","tableName":"yuangong","parentMenuName":"员工管理"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除","打印"],"menu":"绩效季度考核表模板","menuJump":"列表","tableName":"hetongxinxi","parentMenuName":"绩效季度考核表模板管理"}],"menu":"绩效季度考核表模板管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","报表"],"menu":"员工绩效考核","menuJump":"列表","tableName":"yuangongjixiaokaohe","parentMenuName":"员工绩效考核管理"}],"menu":"员工绩效考核管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除","报表"],"menu":"领导绩效考核","menuJump":"列表","tableName":"lingdaojixiaokaohe","parentMenuName":"领导绩效考核管理"}],"menu":"领导绩效考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"工作任务","menuJump":"列表","tableName":"gongzuorenwu","parentMenuName":"工作任务管理"}],"menu":"工作任务管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","修改","删除"],"menu":"工作记录","menuJump":"列表","tableName":"gongzuojilu","parentMenuName":"工作记录管理"}],"menu":"工作记录管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","编辑名称","编辑父级","删除"],"menu":"菜单列表","tableName":"menu","parentMenuName":"系统管理"}],"menu":"系统管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["新增","查看","修改","报表","晋升","绩效考核","发布工作"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"工作晋升","menuJump":"列表","tableName":"gongzuojinsheng"}],"menu":"工作晋升管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看"],"menu":"人事调动","menuJump":"列表","tableName":"renshidiaodong"}],"menu":"人事调动管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","审核","报表","打印","导出"],"menu":"员工考勤","menuJump":"列表","tableName":"yuangongkaoqin"}],"menu":"员工考勤管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","审核","报表","打印","导出"],"menu":"员工事务","menuJump":"列表","tableName":"yuangongshiwu"}],"menu":"员工事务管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","报表"],"menu":"员工绩效考核","menuJump":"列表","tableName":"yuangongjixiaokaohe"}],"menu":"员工绩效考核管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","报表"],"menu":"领导绩效考核","menuJump":"列表","tableName":"lingdaojixiaokaohe"}],"menu":"领导绩效考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"工作任务","menuJump":"列表","tableName":"gongzuorenwu"}],"menu":"工作任务管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"工作记录","menuJump":"列表","tableName":"gongzuojilu"}],"menu":"工作记录管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"部门领导","tableName":"bumenlingdao"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","打印"],"menu":"合同信息","menuJump":"列表","tableName":"hetongxinxi"}],"menu":"合同信息管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"员工绩效考核","menuJump":"列表","tableName":"yuangongjixiaokaohe"}],"menu":"员工绩效考核管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","提交工作"],"menu":"工作任务","menuJump":"列表","tableName":"gongzuorenwu"}],"menu":"工作任务管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"工作记录","menuJump":"列表","tableName":"gongzuojilu"}],"menu":"工作记录管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"员工","tableName":"yuangong"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renshidiaodong`
--

DROP TABLE IF EXISTS `renshidiaodong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `renshidiaodong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `bumen` varchar(200) NOT NULL COMMENT '部门',
  `zhiwei` varchar(200) NOT NULL COMMENT '职位',
  `renzhiriqi` date DEFAULT NULL COMMENT '任职日期',
  `diaodongshuoming` longtext COMMENT '调动说明',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864390999 DEFAULT CHARSET=utf8 COMMENT='人事调动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renshidiaodong`
--

LOCK TABLES `renshidiaodong` WRITE;
/*!40000 ALTER TABLE `renshidiaodong` DISABLE KEYS */;
INSERT INTO `renshidiaodong` VALUES (101,'2030-02-26 08:06:38','员工工号1','员工姓名1','upload/renshidiaodong_touxiang1.jpg','男','13823888881','部门1','职位1','2030-02-26','调动说明1','领导账号1','领导姓名1'),(102,'2030-02-26 08:06:38','员工工号2','员工姓名2','upload/renshidiaodong_touxiang2.jpg','男','13823888882','部门2','职位2','2030-02-26','调动说明2','领导账号2','领导姓名2'),(103,'2030-02-26 08:06:38','员工工号3','员工姓名3','upload/renshidiaodong_touxiang3.jpg','男','13823888883','部门3','职位3','2030-02-26','调动说明3','领导账号3','领导姓名3'),(104,'2030-02-26 08:06:38','员工工号4','员工姓名4','upload/renshidiaodong_touxiang4.jpg','男','13823888884','部门4','职位4','2030-02-26','调动说明4','领导账号4','领导姓名4'),(105,'2030-02-26 08:06:38','员工工号5','员工姓名5','upload/renshidiaodong_touxiang5.jpg','男','13823888885','部门5','职位5','2030-02-26','调动说明5','领导账号5','领导姓名5'),(106,'2030-02-26 08:06:38','员工工号6','员工姓名6','upload/renshidiaodong_touxiang6.jpg','男','13823888886','部门6','职位6','2030-02-26','调动说明6','领导账号6','领导姓名6'),(1645864390998,'2030-02-26 08:33:10','员工工号1','员工姓名1','upload/yuangong_touxiang1.jpg','女','13823888881','人事部','技术员','2030-02-26','这里操作调动','领导账号1','领导姓名1');
/*!40000 ALTER TABLE `renshidiaodong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,41,'领导账号1','bumenlingdao','部门领导','2li9arn3y59wohvm1rkqsku6df2ogv0l','2030-02-26 08:17:32','2030-02-26 09:38:03'),(2,1,'abo','users','管理员','d3ha8a6y2qtpuvp6abkwd4j735n1t3e2','2030-02-26 08:17:45','2030-02-26 09:37:31'),(3,51,'员工工号1','yuangong','员工','rb5brpdv232k24nx5co3b30vms0vkiv4','2030-02-26 08:27:07','2030-02-26 09:37:39');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2030-02-26 08:06:38');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangong`
--

DROP TABLE IF EXISTS `yuangong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) NOT NULL COMMENT '员工工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `renyuan` int(11) DEFAULT NULL COMMENT '人员',
  `zhiwei` varchar(200) NOT NULL COMMENT '职位',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `dizhi` varchar(200) DEFAULT NULL COMMENT '地址',
  `jiaoyujingli` varchar(200) DEFAULT NULL COMMENT '教育经历',
  `gongzuojingli` varchar(200) DEFAULT NULL COMMENT '工作经历',
  `jiatingbeijing` varchar(200) DEFAULT NULL COMMENT '家庭背景',
  `peixunjingli` varchar(200) DEFAULT NULL COMMENT '培训经历',
  `yuyannengli` varchar(200) DEFAULT NULL COMMENT '语言能力',
  `gerenzhicheng` varchar(200) DEFAULT NULL COMMENT '个人职称',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yuangonggonghao` (`yuangonggonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangong`
--

LOCK TABLES `yuangong` WRITE;
/*!40000 ALTER TABLE `yuangong` DISABLE KEYS */;
INSERT INTO `yuangong` VALUES (51,'2030-02-26 08:06:38','员工工号1','123456','员工姓名1','女','upload/yuangong_touxiang1.jpg',1,'技术员','13823888881','地址1','教育经历1','工作经历1','家庭背景1','培训经历1','语言能力1','个人职称1','领导账号1','领导姓名1','人事部'),(52,'2030-02-26 08:06:38','员工工号2','123456','员工姓名2','男','upload/yuangong_touxiang2.jpg',2,'职位2','13823888882','地址2','教育经历2','工作经历2','家庭背景2','培训经历2','语言能力2','个人职称2','领导账号2','领导姓名2','财务部'),(53,'2030-02-26 08:06:38','员工工号3','123456','员工姓名3','男','upload/yuangong_touxiang3.jpg',3,'职位3','13823888883','地址3','教育经历3','工作经历3','家庭背景3','培训经历3','语言能力3','个人职称3','领导账号3','领导姓名3','技术部'),(54,'2030-02-26 08:06:38','员工工号4','123456','员工姓名4','男','upload/yuangong_touxiang4.jpg',4,'职位4','13823888884','地址4','教育经历4','工作经历4','家庭背景4','培训经历4','语言能力4','个人职称4','领导账号4','领导姓名4','后勤部'),(55,'2030-02-26 08:06:38','员工工号5','123456','员工姓名5','男','upload/yuangong_touxiang5.jpg',5,'职位5','13823888885','地址5','教育经历5','工作经历5','家庭背景5','培训经历5','语言能力5','个人职称5','领导账号5','领导姓名5','技术部');
/*!40000 ALTER TABLE `yuangong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangonggongzi`
--

DROP TABLE IF EXISTS `yuangonggongzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangonggongzi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongzimingcheng` varchar(200) NOT NULL COMMENT '工资名称',
  `gongziyuefen` varchar(200) NOT NULL COMMENT '工资月份',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `dixin` int(11) NOT NULL COMMENT '底薪',
  `jixiao` int(11) NOT NULL COMMENT '绩效',
  `jiangjin` int(11) NOT NULL COMMENT '奖金',
  `gangweibutie` int(11) NOT NULL COMMENT '岗位补贴',
  `quanqinjiang` int(11) NOT NULL COMMENT '全勤奖',
  `jiabanfei` int(11) NOT NULL COMMENT '加班费',
  `koujixiao` int(11) NOT NULL COMMENT '扣绩效',
  `qitakoukuan` int(11) NOT NULL COMMENT '其它扣款',
  `kouwuxianyijin` int(11) NOT NULL COMMENT '扣五险一金',
  `shifagongzi` varchar(200) DEFAULT NULL COMMENT '实发工资',
  `gongzibeizhu` varchar(200) DEFAULT NULL COMMENT '工资备注',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864326834 DEFAULT CHARSET=utf8 COMMENT='员工工资';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangonggongzi`
--

LOCK TABLES `yuangonggongzi` WRITE;
/*!40000 ALTER TABLE `yuangonggongzi` DISABLE KEYS */;
INSERT INTO `yuangonggongzi` VALUES (71,'2030-02-26 08:06:38','工资名称1','一月','员工工号1','员工姓名1','性别1','部门1','职位1',1,1,1,1,1,1,1,1,1,'实发工资1','工资备注1','2030-02-26'),(72,'2030-02-26 08:06:38','工资名称2','一月','员工工号2','员工姓名2','性别2','部门2','职位2',2,2,2,2,2,2,2,2,2,'实发工资2','工资备注2','2030-02-26'),(73,'2030-02-26 08:06:38','工资名称3','一月','员工工号3','员工姓名3','性别3','部门3','职位3',3,3,3,3,3,3,3,3,3,'实发工资3','工资备注3','2030-02-26'),(74,'2030-02-26 08:06:38','工资名称4','一月','员工工号4','员工姓名4','性别4','部门4','职位4',4,4,4,4,4,4,4,4,4,'实发工资4','工资备注4','2030-02-26'),(75,'2030-02-26 08:06:38','工资名称5','一月','员工工号5','员工姓名5','性别5','部门5','职位5',5,5,5,5,5,5,5,5,5,'实发工资5','工资备注5','2030-02-26'),(76,'2030-02-26 08:06:38','工资名称6','一月','员工工号6','员工姓名6','性别6','部门6','职位6',6,6,6,6,6,6,6,6,6,'实发工资6','工资备注6','2030-02-26'),(1645864326833,'2030-02-26 08:32:06','AAA','二月','员工工号1','员工姓名1','女','人事部','技术员',1800,1000,800,600,1000,500,0,0,800,'4900','11','2030-02-26');
/*!40000 ALTER TABLE `yuangonggongzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangongjixiaokaohe`
--

DROP TABLE IF EXISTS `yuangongjixiaokaohe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangongjixiaokaohe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kaohemingcheng` varchar(200) DEFAULT NULL COMMENT '考核名称',
  `kaohefanwei` varchar(200) DEFAULT NULL COMMENT '考核范围',
  `kaohezhouqi` varchar(200) DEFAULT NULL COMMENT '考核周期',
  `kaoheyuefen` varchar(200) NOT NULL COMMENT '考核月份',
  `kaohedafen` int(11) NOT NULL COMMENT '考核打分',
  `kaohepingji` varchar(200) NOT NULL COMMENT '考核评级',
  `kaohepingjia` varchar(200) DEFAULT NULL COMMENT '考核评价',
  `kaoheneirong` longtext NOT NULL COMMENT '考核内容',
  `kaoheriqi` date DEFAULT NULL COMMENT '考核日期',
  `kaohebeizhu` varchar(200) DEFAULT NULL COMMENT '考核备注',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645863898756 DEFAULT CHARSET=utf8 COMMENT='员工绩效考核';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangongjixiaokaohe`
--

LOCK TABLES `yuangongjixiaokaohe` WRITE;
/*!40000 ALTER TABLE `yuangongjixiaokaohe` DISABLE KEYS */;
INSERT INTO `yuangongjixiaokaohe` VALUES (131,'2030-02-26 08:06:38','考核名称1','考核范围1','考核周期1','一月',1,'中','考核评价1','考核内容1','2030-02-26','考核备注1','员工工号1','员工姓名1','部门1','职位1','领导账号1','领导姓名1'),(132,'2030-02-26 08:06:38','考核名称2','考核范围2','考核周期2','一月',2,'良','考核评价2','考核内容2','2030-02-26','考核备注2','员工工号2','员工姓名2','部门2','职位2','领导账号2','领导姓名2'),(133,'2030-02-26 08:06:38','考核名称3','考核范围3','考核周期3','一月',3,'优','考核评价3','考核内容3','2030-02-26','考核备注3','员工工号3','员工姓名3','部门3','职位3','领导账号3','领导姓名3'),(134,'2030-02-26 08:06:38','考核名称4','考核范围4','考核周期4','一月',4,'优','考核评价4','考核内容4','2030-02-26','考核备注4','员工工号4','员工姓名4','部门4','职位4','领导账号4','领导姓名4'),(135,'2030-02-26 08:06:38','考核名称5','考核范围5','考核周期5','一月',5,'差','考核评价5','考核内容5','2030-02-26','考核备注5','员工工号5','员工姓名5','部门5','职位5','领导账号5','领导姓名5'),(136,'2030-02-26 08:06:38','考核名称6','考核范围6','考核周期6','一月',6,'优','考核评价6','考核内容6','2030-02-26','考核备注6','员工工号6','员工姓名6','部门6','职位6','领导账号6','领导姓名6'),(1645863898755,'2030-02-26 08:24:57','AA','AA','AA','二月',88,'优','AA','AA','2030-02-26','AA','员工工号1','员工姓名1','人事部','技术员','领导账号1','领导姓名1');
/*!40000 ALTER TABLE `yuangongjixiaokaohe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangongkaoqin`
--

DROP TABLE IF EXISTS `yuangongkaoqin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangongkaoqin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `kaoqinleixing` varchar(200) NOT NULL COMMENT '考勤类型',
  `kaoqinbeizhu` varchar(200) DEFAULT NULL COMMENT '考勤备注',
  `caozuoshijian` datetime NOT NULL COMMENT '操作时间',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864097386 DEFAULT CHARSET=utf8 COMMENT='员工考勤';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangongkaoqin`
--

LOCK TABLES `yuangongkaoqin` WRITE;
/*!40000 ALTER TABLE `yuangongkaoqin` DISABLE KEYS */;
INSERT INTO `yuangongkaoqin` VALUES (111,'2030-02-26 08:06:38','员工工号1','员工姓名1','部门1','职位1','13823888881','签到','考勤备注1','2030-02-26 16:06:38','领导账号1','领导姓名1','是','领导审核员工的考勤'),(112,'2030-02-26 08:06:38','员工工号2','员工姓名2','部门2','职位2','13823888882','签离','考勤备注2','2030-02-26 16:06:38','领导账号2','领导姓名2','是',''),(113,'2030-02-26 08:06:38','员工工号3','员工姓名3','部门3','职位3','13823888883','签到','考勤备注3','2030-02-26 16:06:38','领导账号3','领导姓名3','是',''),(114,'2030-02-26 08:06:38','员工工号4','员工姓名4','部门4','职位4','13823888884','签离','考勤备注4','2030-02-26 16:06:38','领导账号4','领导姓名4','是',''),(115,'2030-02-26 08:06:38','员工工号5','员工姓名5','部门5','职位5','13823888885','签到','考勤备注5','2030-02-26 16:06:38','领导账号5','领导姓名5','是',''),(116,'2030-02-26 08:06:38','员工工号6','员工姓名6','部门6','职位6','13823888886','签到','考勤备注6','2030-02-26 16:06:38','领导账号6','领导姓名6','是',''),(1645864097385,'2030-02-26 08:28:16','员工工号1','员工姓名1','人事部','技术员','13823888881','签离','111','2030-02-28 16:28:21','领导账号1','领导姓名1','否','');
/*!40000 ALTER TABLE `yuangongkaoqin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangongshiwu`
--

DROP TABLE IF EXISTS `yuangongshiwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangongshiwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shiwubiaoti` varchar(200) NOT NULL COMMENT '事务标题',
  `shiwuleixing` varchar(200) NOT NULL COMMENT '事务类型',
  `shiwuneirong` longtext COMMENT '事务内容',
  `shiwuriqi` date DEFAULT NULL COMMENT '事务日期',
  `shiwufujian` varchar(200) DEFAULT NULL COMMENT '事务附件',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `renshu` int(11) DEFAULT NULL COMMENT '人数',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `bumen` varchar(200) DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) DEFAULT NULL COMMENT '职位',
  `lingdaozhanghao` varchar(200) DEFAULT NULL COMMENT '领导账号',
  `lingdaoxingming` varchar(200) DEFAULT NULL COMMENT '领导姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645864146653 DEFAULT CHARSET=utf8 COMMENT='员工事务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangongshiwu`
--

LOCK TABLES `yuangongshiwu` WRITE;
/*!40000 ALTER TABLE `yuangongshiwu` DISABLE KEYS */;
INSERT INTO `yuangongshiwu` VALUES (121,'2030-02-26 08:06:38','事务标题1','调班','事务内容1','2030-02-26','','员工工号1','员工姓名1',1,'手机1','部门1','职位1','领导账号1','领导姓名1','是','这里审核员工的事务信息'),(122,'2030-02-26 08:06:38','事务标题2','离职','事务内容2','2030-02-26','','员工工号2','员工姓名2',2,'手机2','部门2','职位2','领导账号2','领导姓名2','是',''),(123,'2030-02-26 08:06:38','事务标题3','加班','事务内容3','2030-02-26','','员工工号3','员工姓名3',3,'手机3','部门3','职位3','领导账号3','领导姓名3','是',''),(124,'2030-02-26 08:06:38','事务标题4','请假','事务内容4','2030-02-26','','员工工号4','员工姓名4',4,'手机4','部门4','职位4','领导账号4','领导姓名4','是',''),(125,'2030-02-26 08:06:38','事务标题5','其它','事务内容5','2030-02-26','','员工工号5','员工姓名5',5,'手机5','部门5','职位5','领导账号5','领导姓名5','是',''),(126,'2030-02-26 08:06:38','事务标题6','请假','事务内容6','2030-02-26','','员工工号6','员工姓名6',6,'手机6','部门6','职位6','领导账号6','领导姓名6','是',''),(1645864146652,'2030-02-26 08:29:06','这里添加员工事务','加班','111','2030-02-26','upload/1645864144708.zip','员工工号1','员工姓名1',1,'13823888881','人事部','技术员','领导账号1','领导姓名1','否','');
/*!40000 ALTER TABLE `yuangongshiwu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhiwei`
--

DROP TABLE IF EXISTS `zhiwei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhiwei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhiwei` varchar(200) NOT NULL COMMENT '职位',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhiwei` (`zhiwei`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='职位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhiwei`
--

LOCK TABLES `zhiwei` WRITE;
/*!40000 ALTER TABLE `zhiwei` DISABLE KEYS */;
INSERT INTO `zhiwei` VALUES (31,'2030-02-26 08:06:38','文员'),(32,'2030-02-26 08:06:38','专员'),(33,'2030-02-26 08:06:38','技术员');
/*!40000 ALTER TABLE `zhiwei` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2030-02-27 17:55:41
