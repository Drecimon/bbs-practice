create database if not exists hdu_laboratory default character set utf8mb4;
use hdu_laboratory;

-- 用户模块
-- 原始用户信息表
drop table if exists user_origin;
create table if not exists user_origin (
    `id` int not null auto_increment,
    `account` char(10) not null,
    PRIMARY KEY (`id`),
    unique key (`account`)
);
insert into user_origin (account) values ('1');
insert into user_origin (account) values ('2');
insert into user_origin (account) values ('3');
insert into user_origin (account) values ('4');
insert into user_origin (account) values ('5');

-- 用户信息表
drop table if exists user_info;
create table if not exists user_info (

    `id` int not null auto_increment,
    `account` char(10) not null,
    `email` char(30) not null,
    `phone` char(13),
    `nickname` char(20) not null default 'noone',
    `introduction` varchar(100) not null default '无介绍',
    `register_time` datetime not null,
    `profile_picture` varchar(100) not null default 'C:/Users/ljlin/Desktop/default_profile_photo.jpg',
    `active` tinyint not null default 0,
    `active_id` char(32) not null,
    `isban` tinyint not null default 0,
    PRIMARY KEY (`id`),
    unique key (`account`),
    unique key (`email`),
    unique key (`phone`),
    unique key (`active_id`)
);
-- 插入测试数据
insert into user_info (account, email, phone, register_time, active, active_id) values ('1', '123@qq.com', '123451', now(), '1', '123');
insert into user_info (account, email, phone, register_time, active, active_id) values ('2', '124@qq.com', '123452', now(), '1', '124');
insert into user_info (account, email, phone, register_time, active, active_id) values ('3', '125@qq.com', '123453', now(), '1', '125');                
insert into user_info (account, email, register_time, active, active_id) values ('4', '126@qq.com', now(), '1', '126');

-- 用户授权表
drop table if exists user_auths;
create table if not exists user_auths(

    `id` int not null auto_increment,
    `user_id` int not null,
    `identity_type` enum('account', 'email', 'phone') not null,
    `identifier` varchar(30) not null,
    `credential` char(32) not null,
    PRIMARY KEY (`id`),
    unique key (`identifier`)
);
-- 插入测试数据 密码明文为123，此处为加密后的密码
insert into user_auths (user_id, identity_type, identifier, credential) values ( 1, 'account', 1, '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 1, 'email', '123@qq.com', '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 1, 'phone', '123451', '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 2, 'email', '124@qq.com', '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 2, 'account', 2, '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 3, 'email', '125@qq.com', '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 3, 'account', 3, '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 4, 'email', '126@qq.com', '202cb962ac59075b964b07152d234b70');
insert into user_auths (user_id, identity_type, identifier, credential) values ( 4, 'account', 4, '202cb962ac59075b964b07152d234b70');

--  角色权限表
drop table if exists user_role;
create table if not exists user_role (

	`id` int not null auto_increment,
    `user_id` int not null,
    `role` enum('student', 'teacher', 'admin', 'root') not null,
    PRIMARY KEY (`id`)
);
-- 插入测试数据
insert into user_role (user_id, role) values (1, 'student');
insert into user_role (user_id, role) values (2, 'student');
insert into user_role (user_id, role) values (2, 'teacher');    
insert into user_role (user_id, role) values (3, 'student');
insert into user_role (user_id, role) values (3, 'teacher');
insert into user_role (user_id, role) values (3, 'admin');
insert into user_role (user_id, role) values (4, 'student');
insert into user_role (user_id, role) values (4, 'teacher');
insert into user_role (user_id, role) values (4, 'admin');
insert into user_role (user_id, role) values (4, 'root');


-- 介绍模块
-- 研究成果表
drop table if exists intro_achievement;
create table if not exists intro_achievement (
    `id` int not null auto_increment,
    `title` varchar(200) not null,
    `content` text not null,
    `up_userid` int not null,
    `up_nickname` char(20) not null,
    `up_date` datetime not null,
    `visit_count` int not null default 0,
    PRIMARY KEY (`id`)
);

insert into intro_achievement (title, content, up_userid, up_nickname, up_date) values ('hello title', 'hello content', 1, 'noone', now());
insert into intro_achievement (title, content, up_userid, up_nickname, up_date) values ('hello title', 'hello content', 1, 'noone', now());

-- 荣誉奖项表
drop table if exists intro_award;
create table if not exists intro_award (
    `id` int not null auto_increment,
    `title` varchar(200) not null,
    `content` text not null,
    `up_userid` int not null,
    `up_nickname` char(20) not null,
    `up_date` datetime not null,
    `visit_count` int not null default 0,
    PRIMARY KEY (`id`)
);


-- 成员介绍表
drop table if exists intro_member;
create table if not exists intro_member (
    `id` int not null auto_increment,
    `member_id` int not null,
    `member_type` enum('student', 'teacher') not null,
    `member_name` char(20) not null,
    `department_id` int not null,
    PRIMARY key (`id`)
);

-- 成员申请表
drop table if exists intro_apply;
create table if not exists intro_apply (
    `id` int not null auto_increment,
    `user_id` int not null,
    `username` char(20) not null,
    `apply_type` enum('student', 'teacher') not null,
    `department_id` int not null,
    `apply_status` enum('待审核', '已通过', '已拒绝') not null,
    PRIMARY key (`id`)
);

-- 部门介绍表
drop table if exists intro_department;
create table if not exists intro_department (
    `id` int not null auto_increment,
    `name` char(20) not null,
    `description` text not null,
    PRIMARY key (`id`),
    unique key (`name`)
);


insert into intro_department (name, description) values ('test', 'hello');
insert into intro_member (member_id, member_type, member_name, department_id) values (1, 'student', 'tony', 1);


-- 招聘信息表
drop table if exists intro_job;
create table if not exists intro_job (
    `id` int not null auto_increment,
    `title` varchar(200) not null,
    `content` text not null,
    `up_userid` int not null,
    `up_nickname` char(20) not null,
    `up_date` datetime not null,
    `visit_count` int not null default 0,
    PRIMARY KEY (`id`)
);

-- 通知模块
-- 通知公告表
drop table if exists anno_announce;
create table if not exists anno_announce (
    `id` int not null auto_increment,
    `title` varchar(200) not null,
    `content` text not null,
    `up_userid` int not null,
    `up_nickname` char(20) not null,
    `up_date` datetime not null,
    `visit_count` int not null default 0,
    `save_path` varchar(200),
    PRIMARY KEY (`id`)
);

-- 通知范围表
drop table if exists anno_scope;
create table if not exists anno_scope (
    `id` int not null auto_increment,
    `announce_id` int not null,
    `department_id` tinyint not null,
    PRIMARY KEY (`id`)
)