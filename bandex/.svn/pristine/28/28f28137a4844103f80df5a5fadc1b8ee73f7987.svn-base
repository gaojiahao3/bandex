CREATE SEQUENCE seq_agent_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 100000
  CACHE 5;

drop table if exists agent_info;

/*==============================================================*/
/* Table: agent_info                                            */
/*==============================================================*/
create table agent_info 
(
   id                   int4                           not null DEFAULT nextval('seq_agent_info'::regclass),
   sys_user_id          int4                           null,
   realname             varchar(200)                   null,
   sex                  varchar(200)                   null,
   avatar               varchar(200)                   null,
   idcard               varchar(200)                   null,
   country_id           int4                           null,
   region_id            int4                           null,
   paypal_account       varchar(200)                   null,
   settlement_rate      numeric(12,2)                  null,
   phone                varchar(200)                   null,
   "comment"            varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_AGENT_INFO primary key (id)
);



drop table if exists agent_data;

/*==============================================================*/
/* Table: agent_data                                            */
/*==============================================================*/
create table agent_data 
(
   agent_id             int4                           not null,
   total_income         numeric(12,2)                  null,
   balance              numeric(12,2)                  null,
   available_balance    numeric(12,2)                  null,
   lock_balance         numeric(12,2)                  null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_AGENT_DATA primary key (agent_id)
);



CREATE SEQUENCE seq_driver_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 2000000
  CACHE 5;

drop table if exists driver_info;

/*==============================================================*/
/* Table: driver_info                                           */
/*==============================================================*/
create table driver_info 
(
   id                   int4                           not null DEFAULT nextval('seq_driver_info'::regclass),
   username		varchar(200)                   null,
   code                 varchar(200)                   null,
   country_id           int4                           null,
   region_id            int4                           null,
   agent_id             int4                           null,
   nationality          varchar(200)                   null,
   realname             varchar(200)                   null,
   sex                  varchar(200)                   null,
   phone                varchar(200)                   null,
   avatar               varchar(200)                   null,
   car_type_id          int4                           null,
   settlement_rate      numeric(12,2)                  null,
   car_length           numeric(12,2)                  null,
   car_max_weight       numeric(12,2)                  null,
   idcard               varchar(200)                   null,
   idcard_image         varchar(200)                   null,
   driverlicense        varchar(200)                   null,
   driverlicense_image  varchar(200)                   null,
   drivinglicense_image varchar(200)                   null,
   car_image            varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   training_apply_datetime timestamp                      null,
   training_pass_datetime timestamp                      null,
   reject_reason        varchar(200)                   null,
   work_status          varchar(200)                   null,
   push_token               varchar(200)                   null,
   constraint PK_DRIVER_INFO primary key (id)
);



drop table if exists driver_data;

/*==============================================================*/
/* Table: driver_data                                           */
/*==============================================================*/
create table driver_data 
(
   driver_id            int4                           not null,
   points               int4                           null,
   avg_score            numeric(12,2)                  null,
   order_count          int4                           null,
   complete_order_count int4                           null,
   complete_order_amount numeric(12,2)                  null,
   complaint_count      int4                           null,
   last_order_datetime  timestamp                      null,
   total_income         numeric(12,2)                  null,
   balance              numeric(12,2)                  null,
   available_balance    numeric(12,2)                  null,
   lock_balance         numeric(12,2)                  null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_DRIVER_DATA primary key (driver_id)
);



drop table if exists driver_register_login;

/*==============================================================*/
/* Table: driver_register_login                                 */
/*==============================================================*/
create table driver_register_login 
(
   driver_id            int4                           not null,
   register_source      varchar(200)                   null,
   register_datetime    timestamp                      null,
   register_device_no   varchar(200)                   null,
   register_model_name  varchar(200)                   null,
   register_os_version  varchar(200)                   null,
   register_ip          varchar(200)                   null,
   login_count          int4                           null,
   last_login_datetime  timestamp                      null,
   last_login_device_no varchar(200)                   null,
   last_login_model_name varchar(200)                   null,
   last_login_os_version varchar(200)                   null,
   last_login_ip        varchar(200)                   null,
   constraint PK_DRIVER_REGISTER_LOGIN primary key (driver_id)
);


drop table if exists driver_login_token;

/*==============================================================*/
/* Table: driver_login_token                               */
/*==============================================================*/
create table driver_login_token 
(
   login_token          varchar(200)                    not null,
   driver_id          int4                           null,
   login_datetime  timestamp                      null,
   login_device_no varchar(200)                   null,
   login_model_name varchar(200)                   null,
   login_os_version varchar(200)                   null,
   login_ip        varchar(200)                   null,
   constraint PK_DRIVER_LOGIN_TOKEN primary key (login_token)
);

CREATE SEQUENCE seq_append_service
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists append_service;

/*==============================================================*/
/* Table: append_service                                        */
/*==============================================================*/
create table append_service 
(
   id                   int4                           not null DEFAULT nextval('seq_append_service'::regclass),
   service_name         varchar(200)                   null,
   service_price        numeric(12,2)                  null,
   "comment"            varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_APPEND_SERVICE primary key (id)
);



CREATE SEQUENCE seq_payment_channel
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists payment_channel;

/*==============================================================*/
/* Table: payment_channel                                       */
/*==============================================================*/
create table payment_channel 
(
   id                   int4                           not null DEFAULT nextval('seq_payment_channel'::regclass),
   name                 varchar(200)                   null,
   code                 varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_PAYMENT_CHANNEL primary key (id)
);




CREATE SEQUENCE seq_country_region
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists country_region;

/*==============================================================*/
/* Table: country_region                                        */
/*==============================================================*/
create table country_region 
(
   id                   int4                           not null DEFAULT nextval('seq_country_region'::regclass),
   parent_id            int4                           null,
   name                 varchar(200)                   null,
   code                 varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_COUNTRY_REGION primary key (id)
);



CREATE SEQUENCE seq_notice_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists notice_info;

/*==============================================================*/
/* Table: notice_info                                           */
/*==============================================================*/
create table notice_info 
(
   id                   int4                           not null DEFAULT nextval('seq_notice_info'::regclass),
   title                varchar(200)                   null,
   content              varchar(1000)                  null,
   published_datetime   timestamp                      null,
   expiry_datetime      timestamp                      null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_NOTICE_INFO primary key (id)
);




CREATE SEQUENCE seq_car_type
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists car_type;

/*==============================================================*/
/* Table: car_type                                              */
/*==============================================================*/
create table car_type 
(
   id                   int4                           not null DEFAULT nextval('seq_car_type'::regclass),
   name                 varchar(200)                   null,
   width_length         varchar(200)                   null,
   max_weight           varchar(200)                   null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_CAR_TYPE primary key (id)
);





CREATE SEQUENCE seq_pricing_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists pricing_info;

/*==============================================================*/
/* Table: pricing_info                                          */
/*==============================================================*/
create table pricing_info 
(
   id                   int4                           not null DEFAULT nextval('seq_pricing_info'::regclass),
   region_id            int4                           null,
   car_type_id          int4                           null,
   init_price           numeric(12,2)                  null,
   unit_price           numeric(12,2)                  null,
   status               varchar(200)                         null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_PRICING_INFO primary key (id)
);





CREATE SEQUENCE seq_customer_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 30000000
  CACHE 5;

drop table if exists customer_info;

/*==============================================================*/
/* Table: customer_info                                         */
/*==============================================================*/
create table customer_info 
(
   id                   int4                           not null DEFAULT nextval('seq_customer_info'::regclass),
   username		varchar(200)                   null,
   phone                varchar(200)                   null,
   avatar               varchar(200)                   null,
   nickname             varchar(200)                   null,
   status               varchar(200)                   null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   push_token               varchar(200)                   null,
   constraint PK_CUSTOMER_INFO primary key (id)
);





CREATE SEQUENCE seq_customer_like_driver
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists customer_like_driver;

/*==============================================================*/
/* Table: customer_like_driver                                  */
/*==============================================================*/
create table customer_like_driver 
(
   id                   int4                           not null DEFAULT nextval('seq_customer_like_driver'::regclass),
   customer_id          int4                           null,
   driver_id            int4                           null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_CUSTOMER_LIKE_DRIVER primary key (id)
);




CREATE SEQUENCE seq_customer_block_driver
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


drop table if exists customer_block_driver;

/*==============================================================*/
/* Table: customer_block_driver                                 */
/*==============================================================*/
create table customer_block_driver 
(
   id                   int4                           not null DEFAULT nextval('seq_customer_block_driver'::regclass),
   customer_id          int4                           null,
   driver_id            int4                           null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_CUSTOMER_BLOCK_DRIVER primary key (id)
);



drop table if exists customer_data;

/*==============================================================*/
/* Table: customer_data                                         */
/*==============================================================*/
create table customer_data 
(
   customer_id          int4                           not null,
   points               int4                           null,
   order_count          int4                           null,
   complete_order_count int4                           null,
   complete_order_amount numeric(12,2)                  null,
   complaint_count      int4                           null,
   last_order_datetime  timestamp                      null,
   total_order_amount   numeric(12,2)                  null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_CUSTOMER_DATA primary key (customer_id)
);




drop table if exists customer_register_login;

/*==============================================================*/
/* Table: customer_register_login                               */
/*==============================================================*/
create table customer_register_login 
(
   customer_id          int4                           not null,
   register_source      varchar(200)                   null,
   register_datetime    timestamp                      null,
   register_device_no   varchar(200)                   null,
   register_model_name  varchar(200)                   null,
   register_os_version  varchar(200)                   null,
   register_ip          varchar(200)                   null,
   login_count          int4                           null,
   last_login_datetime  timestamp                      null,
   last_login_device_no varchar(200)                   null,
   last_login_model_name varchar(200)                   null,
   last_login_os_version varchar(200)                   null,
   last_login_ip        varchar(200)                   null,
   constraint PK_CUSTOMER_REGISTER_LOGIN primary key (customer_id)
);


drop table if exists customer_login_token;

/*==============================================================*/
/* Table: customer_login_token                               */
/*==============================================================*/
create table customer_login_token 
(
   login_token          varchar(200)                    not null,
   customer_id          int4                           null,
   login_datetime  timestamp                      null,
   login_device_no varchar(200)                   null,
   login_model_name varchar(200)                   null,
   login_os_version varchar(200)                   null,
   login_ip        varchar(200)                   null,
   constraint PK_CUSTOMER_LOGIN_TOKEN primary key (login_token)
);


CREATE SEQUENCE seq_order_info
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 40000000
  CACHE 5;


drop table if exists order_info;

/*==============================================================*/
/* Table: order_info                                            */
/*==============================================================*/
create table order_info 
(
   id                   int4                           not null DEFAULT nextval('seq_order_info'::regclass),
   order_no             varchar(200)                   null,
   customer_id          int4                           null,
   customer_name        varchar(200)                   null,
   customer_phone       varchar(200)                   null,
   order_type           varchar(200)                   null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   update_by            int4                           null,
   car_type_id          int4                           null,
   country_id           int4                           null,
   region_id            int4                           null,
   start_place          varchar(500)                   null,
   end_place            varchar(500)                   null,
   remark               varchar(500)                   null,
   init_price           numeric(12,2)                  null,
   unit_price           numeric(12,2)                  null,
   km                   numeric(12,2)                  null,
   transport_price      numeric(12,2)                  null,
   append_price         numeric(12,2)                  null,
   order_price          numeric(12,2)                  null,
   discount_price       numeric(12,2)                  null,
   pay_price            numeric(12,2)                  null,
   status               varchar(200)                   null,
   get_order_datetime   timestamp                      null,
   driver_id            int4                           null,
   last_pay_id          int4                           null,
   real_coupon_money    numeric(12,2)                  null,
   real_pay_money       numeric(12,2)                  null,
   paid_datetime        timestamp                      null,
   complete_datetime    timestamp                      null,
   order_source         varchar(200)                   null,
   order_device_no      varchar(200)                   null,
   order_model_name     varchar(200)                   null,
   order_os_version     varchar(200)                   null,
   order_ip             varchar(200)                   null,
   constraint PK_ORDER_INFO primary key (id)
);



CREATE SEQUENCE seq_order_hub
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


drop table if exists order_hub;

/*==============================================================*/
/* Table: order_hub                                             */
/*==============================================================*/
create table order_hub 
(
   id                   int4                           not null DEFAULT nextval('seq_order_hub'::regclass),
   order_id             int4                           null,
   hub_order            int4                           null,
   hub_place            varchar(500)                   null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_ORDER_HUB primary key (id)
);



CREATE SEQUENCE seq_order_append_service
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;



drop table if exists order_append_service;

/*==============================================================*/
/* Table: order_append_service                                  */
/*==============================================================*/
create table order_append_service 
(
   id                   int4                           not null DEFAULT nextval('order_append_service'::regclass),
   order_id             int4                           null,
   append_service_id    int4                           null,
   append_service_price numeric(12,2)                  null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_ORDER_APPEND_SERVICE primary key (id)
);



CREATE SEQUENCE seq_order_coupon
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


drop table if exists order_coupon;

/*==============================================================*/
/* Table: order_coupon                                          */
/*==============================================================*/
create table order_coupon 
(
   id                   int4                           not null DEFAULT nextval('seq_order_coupon'::regclass),
   order_id             int4                           null,
   coupon_id            int4                           null,
   deduction_amount     numeric(12,2)                  null,
   constraint PK_ORDER_COUPON primary key (id)
);


CREATE SEQUENCE seq_order_payment
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists order_payment;

/*==============================================================*/
/* Table: order_payment                                         */
/*==============================================================*/
create table order_payment 
(
   id                   int4                           not null DEFAULT nextval('order_payment'::regclass),
   order_id             int4                           null,
   pay_channel_id       int4                           null,
   partner_order_no     varchar(200)                   null,
   paid_datetime        timestamp                      null,
   pay_callback_data    text                           null,
   status               varchar(200)                   null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   constraint PK_ORDER_PAYMENT primary key (id)
);



CREATE SEQUENCE seq_order_comment
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

drop table if exists order_comment;

/*==============================================================*/
/* Table: order_comment                                         */
/*==============================================================*/
create table order_comment 
(
   id                   int4                           not null DEFAULT nextval('seq_order_comment'::regclass),
   order_id             int4                           null,
   anonymous_flag       int4                           null,
   customer_id          int4                           null,
   driver_id            int4                           null,
   comment_star         numeric(12,2)                  null,
   comment_tags         varchar(200)                   null,
   comment_content      varchar(1000)                  null,
   status               varchar(200)                   null,
   create_by            int4                           null,
   create_datetime      timestamp                      null,
   update_by            int4                           null,
   update_datetime      timestamp                      null,
   constraint PK_ORDER_COMMENT primary key (id)
);



drop table if exists order_settlement_record;

/*==============================================================*/
/* Table: order_settlement_record                               */
/*==============================================================*/
create table order_settlement_record 
(
   order_id             int4                           not null,
   hq_settlement_rate   numeric(12,2)                  null,
   hq_settlement_amount numeric(12,2)                  null,
   agent_id             int4                           null,
   agent_settlement_rate numeric(12,2)                  null,
   agent_settlement_amount numeric(12,2)                  null,
   driver_id            int4                           null,
   driver_settlement_rate numeric(12,2)                  null,
   driver_settlement_amount numeric(12,2)                  null,
   settlement_datetime  timestamp                      null,
   settlement_by        int4                           null,
   create_datetime      timestamp                      null,
   update_datetime      timestamp                      null,
   update_by            int4                           null,
   constraint PK_ORDER_SETTLEMENT_RECORD primary key (order_id)
);





















CREATE SEQUENCE seq_sys_menu
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
"id" int4 NOT NULL DEFAULT nextval('seq_sys_menu'::regclass),
"menu_name" varchar(100) COLLATE "default",
"menu_code" varchar(300) COLLATE "default",
"menu_url" varchar(300) COLLATE "default",
"pid" int4,
"sort" int4,
"is_delete" int2 DEFAULT 0,
"is_show" int2,
"menu_summary" varchar(200) COLLATE "default",
"depth" int2 DEFAULT 0
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table sys_menu
-- ----------------------------
CREATE INDEX "idx_sys_menu_is_delete" ON "public"."sys_menu" USING btree (is_delete);
CREATE INDEX "idx_sys_menu_pid" ON "public"."sys_menu" USING btree (pid);
CREATE INDEX "idx_sys_menu_sort" ON "public"."sys_menu" USING btree (sort);

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD PRIMARY KEY ("id");







CREATE SEQUENCE seq_sys_role
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
"id" int4 NOT NULL DEFAULT nextval('seq_sys_role'::regclass),
"role_name" varchar(100) COLLATE "default",
"role_desc" varchar(500) COLLATE "default",
"createtime" timestamp(6),
"updatetime" timestamp(6),
"is_delete" int2 DEFAULT 0
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table sys_role
-- ----------------------------
CREATE INDEX "idx_sys_role_is_delete" ON "public"."sys_role" USING btree (is_delete);

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD PRIMARY KEY ("id");







CREATE SEQUENCE seq_sys_role_menu
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_menu";
CREATE TABLE "public"."sys_role_menu" (
"id" int4 NOT NULL DEFAULT nextval('seq_sys_role_menu'::regclass),
"role_id" int4,
"menu_id" int4,
"createtime" timestamp(6),
"updatetime" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table sys_role_menu
-- ----------------------------
CREATE INDEX "idx_sys_role_menu_menu_id" ON "public"."sys_role_menu" USING btree (menu_id);
CREATE INDEX "idx_sys_role_menu_role_id" ON "public"."sys_role_menu" USING btree (role_id);

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "public"."sys_role_menu" ADD PRIMARY KEY ("id");





CREATE SEQUENCE seq_sys_user
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
"id" int4 NOT NULL DEFAULT nextval('seq_sys_user'::regclass),
"password" varchar(128) COLLATE "default",
"last_login" timestamptz(6),
"is_superuser" bool,
"username" varchar(30) COLLATE "default",
"first_name" varchar(30) COLLATE "default",
"last_name" varchar(30) COLLATE "default",
"email" varchar(75) COLLATE "default",
"regist_type" varchar(200) COLLATE "default",
"status" varchar(50) COLLATE "default",
"date_joined" timestamptz(6),
"type" varchar(30) COLLATE "default" DEFAULT NULL::character varying,
"new_password" varchar(128) COLLATE "default",
"realname" varchar(255) COLLATE "default",
"last_login_ip" varchar(255) COLLATE "default",
"login_count" int4 DEFAULT 0,
"delete_flag" int4 DEFAULT 0,
"nick_name" varchar(255) COLLATE "default",
"fake_flag" int4 DEFAULT 0,
"default_password" varchar(50) COLLATE "default",
"phone" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD PRIMARY KEY ("id");













CREATE SEQUENCE seq_sys_user_role
  INCREMENT 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 5;


-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
"id" int4 NOT NULL DEFAULT nextval('seq_sys_user_role'::regclass),
"user_id" int4,
"role_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table sys_user_role
-- ----------------------------
CREATE INDEX "idx_sys_user_role_user_id" ON "public"."sys_user_role" USING btree (user_id);

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD PRIMARY KEY ("id");





INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('115', '菜单根目录', 'root', NULL, '-1', NULL, '0', '1', NULL, '0');

INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('125', '系统设置', 'sys', NULL, '115', '500', '0', '1', NULL, '1');

INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('469', '后台管理员', 'com.cargodd.backend.web.BackendAdminAction.list', '/system/admin/list', '125', '30', '0', '1', NULL, '2');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('773', '菜单管理', 'com.cargodd.backend.web.BackendUserRoleMenuAction.menuList', '/system/menu/list', '125', '10', '0', '1', NULL, '2');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('776', '角色管理', 'com.cargodd.backend.web.BackendUserRoleMenuAction.roleList', '/system/role/list', '125', '20', '0', '1', NULL, '2');

INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('470', '保存后台管理员', 'com.cargodd.backend.web.BackendAdminAction.save', '/system/admin/save', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('471', '删除后台管理员', 'com.cargodd.backend.web.BackendAdminAction.delete', '/system/admin/delete', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('472', '创建后台管理员', 'com.cargodd.backend.web.BackendAdminAction.create', '/system/admin/create', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('473', '禁用后台管理员', 'com.cargodd.backend.web.BackendAdminAction.disable', '/system/admin/disable', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('474', '启用后台管理员', 'com.cargodd.backend.web.BackendAdminAction.enable', '/system/admin/enable', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('475', '编辑后台管理员', 'com.cargodd.backend.web.BackendAdminAction.edit', '/system/admin/edit/{id}', '469', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('476', '修改后台管理员密码', 'com.cargodd.backend.web.BackendAdminAction.editPassword', '/system/admin/editPassword', '469', NULL, '1', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('477', '修改密码', 'com.cargodd.backend.web.BackendAdminAction.updatePassword', '/system/admin/updatePassword', '469', NULL, '0', '0', NULL, '3');

INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('780', '菜单树', 'com.cargodd.backend.web.BackendUserRoleMenuAction.treeData', '/user/system/menu/treeData', '773', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('781', '获取角色菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.menuByRole', '/user/system/menu/byRole', '773', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('782', '编辑菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.menuEdit', '/user/system/menu/edit', '773', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('783', '保存菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.menuSave', '/user/system/menu/save', '773', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('784', '删除菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.menuDelete', '/user/system/menu/delete', '773', NULL, '0', '0', NULL, '3');

INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('774', '编辑角色菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.adminRoleEdit', '/user/system/admin/roleEdit/{id}', '776', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('775', '保存角色菜单', 'com.cargodd.backend.web.BackendUserRoleMenuAction.adminRoleSave', '/user/system/admin/roleSave', '776', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('777', '编辑角色', 'com.cargodd.backend.web.BackendUserRoleMenuAction.roleEdit', '/user/system/role/edit', '776', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('778', '保存角色', 'com.cargodd.backend.web.BackendUserRoleMenuAction.roleSave', '/user/system/role/save', '776', NULL, '0', '0', NULL, '3');
INSERT INTO "public"."sys_menu" ("id", "menu_name", "menu_code", "menu_url", "pid", "sort", "is_delete", "is_show", "menu_summary", "depth") VALUES ('779', '删除角色', 'com.cargodd.backend.web.BackendUserRoleMenuAction.roleDelete', '/user/system/role/delete', '776', NULL, '0', '0', NULL, '3');
