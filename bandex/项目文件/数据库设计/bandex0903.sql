drop table if exists common_achievement;

drop table if exists common_area;

drop table if exists common_enum;

drop table if exists common_event_info;

drop table if exists common_hospital_info;

drop table if exists common_information;

drop table if exists common_integral_basic;

drop table if exists common_product;

drop table if exists common_sport_project;

drop table if exists contact_application;

drop table if exists order_return;

drop table if exists order_return_item;

drop table if exists order_shopping_cart;

drop table if exists pro_order;

drop table if exists send_sms;

drop table if exists shopping_order;

drop table if exists sys_app_qrcode;

drop table if exists sys_resourse;

drop table if exists sys_role;

drop table if exists sys_role_resourse_ref;

drop table if exists sys_user;

drop table if exists sys_user_role_ref;

drop table if exists user_achievement;

drop table if exists user_address;

drop table if exists user_behavior;

drop table if exists user_comment;

drop table if exists user_contact_ref;

drop table if exists user_contribution;

drop table if exists user_event_ref;

drop table if exists user_group;

drop table if exists user_group_ref;

drop table if exists user_info;

drop table if exists user_integration_detail;

drop table if exists user_login;

drop table if exists user_message;

drop table if exists user_sport_lbs;

drop table if exists user_sport_ref;

drop table if exists wxpay_info;

/*==============================================================*/
/* Table: common_achievement                                    */
/*==============================================================*/
create table common_achievement
(
   id                   bigint(20) not null comment '成就id',
   achieve_name         varchar(255) comment '成就名称',
   achieve_code         varchar(40) comment '成就编码',
   achieve_type         int(4) comment '成就类型（0：走路，1：发起事件，2：参与事件，3：运动达人，4：户外达人）',
   achieve_pic          varchar(255) comment '成就图片',
   achieve_reward       bigint(20) comment '星级奖励(积分规则id)',
   achieve_kpi          varchar(40) comment '成就指标',
   achieve_kpi_value    int comment '指标值',
   kpi_unit             varchar(4) comment '指标单位',
   description          varchar(400) comment '描述',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_achievement comment '成就表
';

/*==============================================================*/
/* Table: common_area                                           */
/*==============================================================*/
create table common_area
(
   area_id              bigint(20) not null comment '区域ID',
   area_name            varchar(100) comment '区域名称',
   parent_id            bigint(20) comment '区域上级ID',
   area_type            int(4) comment '区域类型（国家0;省（直辖市）1；市2；区3）',
   area_shortname       varchar(100) comment '区域简称',
   area_longname        varchar(100) comment '区域全称',
   area_order           int comment '排序',
   long_pinyin          varchar(100) comment '长拼',
   short_pinyin         varchar(100) comment '简拼',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：删除）',
   primary key (area_id)
);

alter table common_area comment '地区基础表';

/*==============================================================*/
/* Table: common_enum                                           */
/*==============================================================*/
create table common_enum
(
   id                   bigint(20) not null comment '标识ID',
   enum_name            varchar(100) comment '枚举名称',
   enum_code            varchar(40) comment '枚举编码',
   parent_id            bigint(20) comment '父级id',
   descript             varchar(255) comment '描述',
   tag                  varchar(100) comment '标签',
   order_num            int comment '排序',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_enum comment '枚举表';

/*==============================================================*/
/* Table: common_event_info                                     */
/*==============================================================*/
create table common_event_info
(
   id                   bigint(20) not null comment '事件id',
   event_name           varchar(255) comment '事件名称',
   event_description    varchar(600) comment '事件详情',
   event_start_time     datetime comment '开始时间',
   event_end_time       datetime comment '结束时间',
   sport_id             bigint(20) comment '运动项目id',
   sport_name           varchar(255) comment '运动名称',
   sport_type           int(4) comment '运动类型（0：计时类，1：计步类）',
   sport_category       int(4) comment '运动分类（0：健身房，1;球类，2：游泳，3：跑步，4：其他）',
   start_address        varchar(255) comment '起始位置',
   product_id           bigint(20) comment '商品id(新建户外活动，联合推广活动的时候新建事件)',
   x_index              varchar(50) comment 'x坐标',
   y_index              varchar(50) comment 'y坐标',
   is_hide              int(4) comment '是否可见（0：可见，1：不可见）',
   user_id              bigint(20) comment '创建人',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_event_info comment '事件信息表
';

/*==============================================================*/
/* Table: common_hospital_info                                  */
/*==============================================================*/
create table common_hospital_info
(
   Column_1             char(10),
   Column_2             char(10),
   Column_3             char(10),
   Column_4             char(10),
   Column_5             char(10),
   Column_6             char(10),
   Column_7             char(10)
);

alter table common_hospital_info comment '暂不知道逻辑';

/*==============================================================*/
/* Table: common_information                                    */
/*==============================================================*/
create table common_information
(
   id                   bigint(20) not null comment '资讯id',
   information_name     varchar(255) comment '资讯名称',
   information_icon     varchar(255) comment '资讯图片',
   information_context  varchar(6000) comment '资讯内容',
   information_type     int(4) comment '资讯类型（0：医疗，1：保险，2：运动，3：养生，4：其他）',
   information_state    int(4) comment '资讯状态',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_information comment '资讯表';

/*==============================================================*/
/* Table: common_integral_basic                                 */
/*==============================================================*/
create table common_integral_basic
(
   id                   bigint(20) not null comment '积分规则id',
   integral_name        varchar(100) comment '积分规则名称',
   integral_code        varchar(40) comment '积分规则code',
   integral_type        int(4) comment '积分规则类型（0:注册完善信息,1:计时运动,2:计步运动,3:事件,4:邀请下载,5:分享,6:捐赠,7:购买商品,8:成就）',
   integral_description varchar(255) comment '积分规则描述',
   integral_value       int(4) comment '积分值',
   remark               varchar(255) comment '备注',
   integral_kpi_name    varchar(100) comment '积分条件名称',
   integral_kpi_type    int(4) comment '积分条件类型',
   integral_kpi_value   int(4) comment '积分条件值',
   integral_kpi_unit    varchar(10) comment '积分条件单位',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_integral_basic comment '积分规则表';

/*==============================================================*/
/* Table: common_product                                        */
/*==============================================================*/
create table common_product
(
   id                   bigint(20) not null comment '商品id',
   product_name         varchar(255) comment '商品名称',
   product_code         varchar(40) comment '商品编码',
   product_icon         varchar(255) comment '商品图片',
   product_type         int(4) comment '商品类型（0：运动装备，1：户外活动，2：联合推广活动）',
   remark               varchar(255) comment '商品备注',
   product_detail       varchar(6000) comment '商品详情',
   product_price        double(12,2) comment '商品价格',
   product_need_integral bigint(20) comment '商品积分价格(商品可以用积分兑换的情况下，运费必须为0)',
   product_freight      double(12,2) comment '商品运费',
   freight_step         double(12,2) comment '递增运费',
   proudct_state        int(4) default 0 comment '商品状态（0：初始状态，1：上架，2：下架）',
   stock                int(11) comment '库存',
   sale_num             int(11) comment '销量',
   order_num            int comment '商品排序',
   product_integral     int comment '附赠积分',
   sport_id             bigint(20) comment '活动项目',
   sport_start_time     datetime comment '活动开始时间',
   sport_end_time       datetime comment '活动结束时间',
   sport_integral       int comment '活动积分',
   return_end_day       int(4) comment '可退货天数',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_product comment '商品表';

/*==============================================================*/
/* Table: common_sport_project                                  */
/*==============================================================*/
create table common_sport_project
(
   id                   bigint(20) not null comment '运动id',
   sport_name           varchar(255) comment '运动名称',
   sport_code           varchar(40) comment '运动code',
   sport_description    varchar(5000) comment '运动详情',
   sport_type           int(4) comment '运动类型（0：计时类，1;计步类）',
   sport_category       int(4) comment '运动分类（0：健身房，1;球类，2：游泳，3：跑步，4：其他）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table common_sport_project comment '运动项目表';

/*==============================================================*/
/* Table: contact_application                                   */
/*==============================================================*/
create table contact_application
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   friend_id            bigint(20) comment '好友id',
   apply_state          int(4) default 0 comment '申请状态（0：申请中，1：申请成功，2：被拒绝）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table contact_application comment '联系人申请表';

/*==============================================================*/
/* Table: order_return                                          */
/*==============================================================*/
create table order_return
(
   id                   bigint(20) not null comment '退货单id',
   return_code          varchar(40) comment '退货单号',
   user_id              bigint(20) comment '用户id',
   link_man             varchar(100) comment '联系人',
   link_tel             varchar(150) comment '联系方式',
   order_id             bigint(20) comment '订单id',
   order_code           varchar(40) comment '订单code',
   return_time          datetime comment '退货时间',
   return_price         double(12,2) comment '退货总价',
   used_integral        int comment '使用积分',
   return_logistic_code varchar(40) comment '退货物流单号',
   return_reason        varchar(255) comment '退货原因',
   return_state         int(4) default 0 comment '退货状态（0:申请退货，1：退货中， 2：退货完成，3：终止退货）',
   return_type          int(4) comment '退货类型（1：订单退货，2：商品退货）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table order_return comment '退货订单表';

/*==============================================================*/
/* Table: order_return_item                                     */
/*==============================================================*/
create table order_return_item
(
   id                   bigint(20) not null comment 'id',
   return_id            bigint(20) comment '退货单id',
   return_code          varchar(40) comment '退货单code',
   pro_order_id         bigint(20) comment '商品订单id',
   product_id           bigint(20) comment '商品id',
   product_code         varchar(40) comment '商品code',
   product_name         varchar(255) comment '商品名称',
   product_icon         varchar(255) comment '商品图片',
   product_price        double(12,2) comment '商品单价',
   product_need_integral bigint(20) comment '商品积分价格(商品可以用积分兑换的情况下，运费必须为0)',
   return_num           int comment '退货数量',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table order_return_item comment '退货商品表';

/*==============================================================*/
/* Table: order_shopping_cart                                   */
/*==============================================================*/
create table order_shopping_cart
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   product_id           bigint(20) comment '商品id',
   product_name         varchar(255) comment '商品名称',
   product_num          int comment '商品数量',
   product_price        double(12,2) comment '商品价格',
   product_need_integral bigint(20) comment '商品积分价格(商品可以用积分兑换的情况下，运费必须为0)',
   discount_price       double(12,2) comment '折扣价',
   product_icon         varchar(255) comment '商品图片',
   is_check             int(4) comment '勾选状态（0：勾选，1：未勾选）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table order_shopping_cart comment '购物车表';

/*==============================================================*/
/* Table: pro_order                                             */
/*==============================================================*/
create table pro_order
(
   id                   bigint(20) not null comment 'id',
   order_id             bigint(20) comment '订单id',
   order_code           varchar(40) comment '订单code',
   product_id           bigint(20) comment '商品id',
   product_code         varchar(40) comment '商品编码',
   product_name         varchar(255) comment '商品名称',
   product_icon         varchar(255) comment '商品图片',
   product_price        double(12,2) comment '商品价格',
   buy_price            double(12,2) comment '购买价格',
   product_need_integral bigint(20) comment '商品积分价格(商品可以用积分兑换的情况下，运费必须为0)',
   buy_num              int comment '购买数量',
   product_state        int(4) default 1 comment '商品状态（1、正常状态；2、申请退货；3、退货中；4、退货完成；5、超过退货时间）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table pro_order comment '订单商品表';

/*==============================================================*/
/* Table: send_sms                                              */
/*==============================================================*/
create table send_sms
(
   id                   bigint(20) not null comment '标识ID',
   telphone             bigint(20) comment '用户电话',
   sms_code             int comment '验证码',
   code_state           int(4) default 0 comment '验证码状态（0：未使用，1：已使用）',
   code_type            int(4) comment '验证码类型（0：注册，1：登录）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table send_sms comment '短信验证表';

/*==============================================================*/
/* Table: shopping_order                                        */
/*==============================================================*/
create table shopping_order
(
   id                   bigint(20) not null comment '订单id',
   order_code           varchar(40) comment '订单code',
   total_price          double(12,2) comment '订单总价',
   discount_price       double(12,2) comment '折扣总价',
   freight_price        double(6,2) comment '运费',
   final_price          double(12,2) comment '付款总价',
   used_integral        int comment '使用积分',
   order_type           int(4) comment '订单类型（0：运动装备，1：户外活动，2：联合推广活动）',
   order_state          int(4) default 0 comment '订单状态（0：未付款，1：已付款，待发货，2：运输中，3：完成订单，4：已发起退货，5：退货中，6：退货完成，7：订单过期，8：订单删除）',
   is_paid              int(4) default 0 comment '是否付款（0：未付款，1：已付款）',
   pay_type             int(4) comment '付款类型(0：微信支付，1：支付宝支付，2：积分支付)',
   order_time           datetime comment '下单时间',
   paid_time            datetime comment '付款时间',
   deliver_time         datetime comment '发货时间',
   logistics_code       varchar(40) comment '物流单号',
   user_id              bigint(20) comment '用户id',
   nick_name            varchar(255) comment '用户昵称',
   address_id           bigint(20) comment '用户地址id',
   link_man             varchar(255) comment '联系人',
   link_tel             varchar(255) comment '联系电话',
   district_id          bigint(20) comment '区域id',
   district_name        varchar(255) comment '区域名称',
   order_address        varchar(255) comment '送货地址',
   return_type          int(4) default 0 comment '退货类型（0：未退货，1：订单退货，2：商品退货，3：超过退货时间）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table shopping_order comment '订单表';

/*==============================================================*/
/* Table: sys_app_qrcode                                        */
/*==============================================================*/
create table sys_app_qrcode
(
   id                   bigint(20) not null comment '标识ID',
   app_id               bigint(20) comment 'appID',
   app_name             varchar(255) comment 'app名称',
   app_type             int(4) comment 'app类型（0：android,1：ios）',
   qr_code              varchar(255) comment '二维码',
   version              varchar(20) comment '版本号',
   pkg                  varchar(255) comment '下载地址',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建id',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改id',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table sys_app_qrcode comment 'app版本表';

/*==============================================================*/
/* Table: sys_resourse                                          */
/*==============================================================*/
create table sys_resourse
(
   resource_id          bigint(20) not null comment '资源id',
   resource_code        varchar(40) comment '资源编码',
   parent_id            bigint(20) comment '父id',
   resource_name        varchar(100) comment '资源名称',
   resource_type        int(4) comment '资源类型(1菜单,2按钮)',
   resource_path        varchar(255) comment '资源地址',
   mapping_path         varchar(255) comment '对应前端请求地址',
   order_num            int comment '排序',
   icon_class           varchar(255) comment '图标',
   description          varchar(255) comment '描述',
   platform_code        varchar(40) comment '平台编码',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (resource_id)
);

alter table sys_resourse comment '系统资源表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              bigint(20) not null comment '角色id',
   role_code            varchar(40) comment '角色编码',
   role_name            varchar(100) comment '角色名称',
   description          varchar(255) comment '描述',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (role_id)
);

alter table sys_role comment '系统角色表';

/*==============================================================*/
/* Table: sys_role_resourse_ref                                 */
/*==============================================================*/
create table sys_role_resourse_ref
(
   id                   bigint(20) not null,
   role_id              bigint(20) comment '角色id',
   resource_id          bigint(20) comment '资源id',
   primary key (id)
);

alter table sys_role_resourse_ref comment '系统角色资源关联表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   bigint(20) not null comment 'id',
   sys_user_name        varchar(100) comment '系统用户名称',
   password             varchar(100) comment '密码',
   sys_user_sex         int(1) comment '性别',
   sys_user_tel         varchar(100) comment '联系方式',
   real_name            varchar(100) comment '真实姓名',
   email                varchar(100) comment '邮箱',
   sys_user_state       int(4) default 0 comment '用户状态（0：正常，1：冻结，2：删除）',
   sys_user_type        int(4) default 0 comment '用户类型（0：普通用户，1：测试用户）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table sys_user comment '系统用户表';

/*==============================================================*/
/* Table: sys_user_role_ref                                     */
/*==============================================================*/
create table sys_user_role_ref
(
   id                   bigint(20) not null comment 'id',
   sys_user_id          bigint(20) comment '系统用户id',
   role_id              bigint(20) comment '角色id',
   primary key (id)
);

alter table sys_user_role_ref comment '系统用户角色关联表';

/*==============================================================*/
/* Table: user_achievement                                      */
/*==============================================================*/
create table user_achievement
(
   id                   bigint(20) comment 'id',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   achieve_id           bigint(20) comment '成就id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   achieve_name         varchar(255) comment '成就名称',
   achieve_type         int(4) comment '成就类型（0：走路，1：发起事件，2：参与事件，3：运动达人，4：户外达人）',
   achieve_pic          varchar(255) comment '成就图片'
);

alter table user_achievement comment '用户成就表';

/*==============================================================*/
/* Table: user_address                                          */
/*==============================================================*/
create table user_address
(
   id                   bigint(20) not null comment '标识ID',
   user_id              bigint(20) comment '用户ID',
   link_man             varchar(100) comment '联系人',
   link_tel             varchar(40) comment '联系电话',
   delivery_time        datetime comment '送货时间',
   province_id          bigint(20) comment '省id',
   province_name        varchar(150) comment '省名称',
   city_id              bigint(20) comment '市id',
   city_name            varchar(150) comment '市名称',
   district_id          bigint(20) comment '区ID',
   district_name        varchar(150) comment '区名称',
   address              varchar(300) comment '地址详细信息',
   x_index              varchar(50) comment '坐标位置X坐标',
   y_index              varchar(50) comment '坐标位置y坐标',
   is_default           int(4) default 0 comment '默认地址（0：非默认，1：默认）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_address comment '用户地址表';

alter table user_address comment '用户地址表';

/*==============================================================*/
/* Table: user_behavior                                         */
/*==============================================================*/
create table user_behavior
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   user_behavior        int(4) comment '用户行为（0：邀请注册，1：转发分享，）',
   from_id              bigint(20) comment '来源id',
   description          varchar(255) comment '描述',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

alter table user_behavior comment '用户行为表







                                  -&#&';

/*==============================================================*/
/* Table: user_comment                                          */
/*==============================================================*/
create table user_comment
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   nick_name            varchar(255) comment '用户昵称',
   comment_type         int(4) comment '评论类型',
   comment              varchar(255) comment '评论内容',
   comment_from         int(4) comment '评论来源（0：保险，1：资讯，2：订单，3：APP）',
   from_id              bigint(20) comment '来源id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_comment comment '用户评论表';

/*==============================================================*/
/* Table: user_contact_ref                                      */
/*==============================================================*/
create table user_contact_ref
(
   user_id              bigint(20) comment '用户id',
   friend_id            bigint(20) comment '好友id'
);

alter table user_contact_ref comment '用户联系人关联表';

/*==============================================================*/
/* Table: user_contribution                                     */
/*==============================================================*/
create table user_contribution
(
   id                   bigint(20) not null comment 'id',
   product_id           bigint(20) comment '商品id',
   product_name         varchar(255) comment '商品名称',
   contribution_price   double(12,2) comment '捐款金额',
   user_id              bigint(20) comment '用户id',
   nick_name            varchar(255) comment '用户昵称',
   contribution_state   int(4) default 0 comment '捐款状态（0：未付款，1：已付款）',
   paid_time            datetime comment '支付时间',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_contribution comment '捐赠记录表';

/*==============================================================*/
/* Table: user_event_ref                                        */
/*==============================================================*/
create table user_event_ref
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   event_id             bigint(20) comment '事件id',
   user_event_state     int(4) comment '用户事件状态（0：未参与，1：参与中，2：完成事件，3：拒绝，4：被拒绝，5：退出，6：被踢出）',
   user_event_type      int(4) comment '用户事件类型（0：被邀请参与，1：申请参与）',
   order_id             bigint(20) comment '订单id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_event_ref comment '用户事件关联表';

/*==============================================================*/
/* Table: user_group                                            */
/*==============================================================*/
create table user_group
(
   group_id             bigint(20) not null comment '分组id',
   group_name           varchar(100) comment '分组名称',
   user_id              bigint(20) comment '用户id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (group_id)
);

alter table user_group comment '用户分组表';

/*==============================================================*/
/* Table: user_group_ref                                        */
/*==============================================================*/
create table user_group_ref
(
   group_id             bigint(20) comment '分组id',
   user_id              bigint(20) comment '用户id',
   nick_name            varchar(255) comment '用户昵称',
   user_icon            varchar(255) comment '用户头像'
);

alter table user_group_ref comment '用户分组关联表';

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              bigint(20) not null comment '用户id',
   nick_name            varchar(255) comment '用户昵称',
   user_icon            varchar(255) comment '用户头像',
   telphone             varchar(40) comment '用户电话',
   birthday             datetime comment '生日',
   sex                  int(1) comment '性别',
   height               int(4) comment '身高(cm)',
   weight               double(6,2) comment '体重(kg)',
   bmi                  double(6,2) comment 'BMI',
   hobby                varchar(100) comment '爱好',
   introduce            varchar(255) comment '自我介绍',
   gymnasium            varchar(255) comment '常去场馆',
   user_integral        int(11) default 0 comment '用户积分',
   user_state           int(4) default 0 comment '用户状态（0：正常，1：冻结，2：删除）',
   user_level           int(4) default 0 comment '用户级别（0：普通会员，1：1级会员，2：2级会员）',
   user_type            int(4) default 0 comment '用户类型（0：普通用户，1：内部用户）',
   create_time          timestamp comment '创建时间',
   create_id            bigint(20) comment '创建人',
   modify_time          datetime not null default CURRENT_TIMESTAMP comment '修改时间',
   modify_id            bigint(20) comment '修改人',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (user_id)
);

alter table user_info comment '用户详情表';

/*==============================================================*/
/* Table: user_integration_detail                               */
/*==============================================================*/
create table user_integration_detail
(
   id                   bigint(20) not null,
   user_id              bigint(20) comment '用户id',
   integral_num         bigint(20) comment '积分数值',
   integral_type        int(4) comment '积分类型（0：完善信息，1：活动，2：事件，3：参与户外活动，4：邀请注册，5：购买商品，6：转发、分享信息，7：捐赠，8：其他）',
   integral_from        int(4) comment '积分来源',
   from_id              bigint(20) comment '来源id',
   remark               varchar(255) comment '积分说明',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

alter table user_integration_detail comment '用户积分明细表';

/*==============================================================*/
/* Table: user_login                                            */
/*==============================================================*/
create table user_login
(
   id                   bigint not null comment '用户id',
   user_name            varchar(40) comment '用户名（手机）',
   wechat_id            varchar(40) comment '微信id',
   weibo_id             varchar(40) comment '微博id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table user_login comment '用户登录(账号)表';

/*==============================================================*/
/* Table: user_message                                          */
/*==============================================================*/
create table user_message
(
   id                   bigint(20) not null comment '消息id',
   user_id              bigint(20) comment '接收方',
   message              varchar(600) comment '消息内容',
   message_type         int(4) comment '消息类型（0：系统消息，1：用户消息，2：其他消息）',
   message_from         int(4) comment '消息来源（0：运动结束，1：创建事件，2：事件开始，3：事件结束，4：编辑事件，5：完善信息，6：事件邀请，7：申请联系人，8：系统通知，9：其他消息）',
   from_id              bigint(20) comment '发送方',
   event_id             bigint(20) comment '事件id',
   event_state          int(4) default 0 comment '事件状态（0：未接受，1：接受邀请，2：拒绝邀请）',
   is_read              int(4) default 0 comment '已读标识（0：未读，1：已读）',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_message comment '用户消息表';

/*==============================================================*/
/* Table: user_sport_lbs                                        */
/*==============================================================*/
create table user_sport_lbs
(
   id                   bigint(20) not null comment 'id',
   user_sport_id        bigint(20) comment '用户运动id',
   user_id              bigint(20) comment '用户id',
   x_index              varchar(50) comment 'x坐标',
   y_index              varchar(50) comment 'y坐标',
   event_time           datetime comment '运动时间',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

alter table user_sport_lbs comment '用户运动轨迹表';

/*==============================================================*/
/* Table: user_sport_ref                                        */
/*==============================================================*/
create table user_sport_ref
(
   id                   bigint(20) not null comment 'id',
   user_id              bigint(20) comment '用户id',
   event_id             bigint(20) comment '事件id',
   sport_id             bigint(20) comment '运动id',
   sport_name           varchar(255) comment '运动名称',
   sport_code           varchar(40) comment '运动code',
   sport_type           int(4) comment '运动类型（0：计时类，1：计步类）',
   sport_category       int(4) comment '运动分类（0：健身房，1;球类，2：游泳，3：跑步）',
   sport_state          int(4) default 0 comment '运动状态（0：未运动，1：完成运动，2：未达标运动）',
   sprot_start_time     datetime comment '运动开始时间',
   sprot_end_time       datetime comment '运动结束时间',
   sprot_hour           double(4,1) comment '运动时长(hour)',
   sport_distance       double(4,1) comment '运动距离(km)',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   modify_time          datetime comment '修改时间',
   delete_flag          int(4) default 0 comment '删除标识（0：未删除，1：已删除）',
   primary key (id)
);

alter table user_sport_ref comment '用户运动关联表';
