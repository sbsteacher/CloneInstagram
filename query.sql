CREATE TABLE t_user(
   iuser bigINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
   email VARCHAR(50) NOT NULL,
   provider VARCHAR(10) NOT NULL DEFAULT 'local',
   pw VARCHAR(100),
   nm VARCHAR(5) NOT NULL,
   cmt VARCHAR(50) DEFAULT '' COMMENT '코멘트',
   mainimg VARCHAR(50),
   regdt DATETIME DEFAULT NOW(),
   UNIQUE(email, provider)
);