DROP DATABASE IF EXISTS fame;
CREATE DATABASE fame CHARACTER SET utf8 COLLATE utf8_general_ci;;
USE fame;

CREATE TABLE `t_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `holiday` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `year` varchar(45) DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  `day` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_cevdm_mp1` (
  `dt_a` varchar(200) NOT NULL,
  `dt_b` varchar(45) DEFAULT NULL,
  `dt_c` varchar(45) DEFAULT NULL,
  `dt_d` varchar(45) DEFAULT NULL,
  `dt_e` varchar(45) DEFAULT NULL,
  `dt_f` varchar(45) DEFAULT NULL,
  `dt_g` varchar(45) DEFAULT NULL,
  `dt_h` varchar(45) DEFAULT NULL,
  `dt_i` varchar(45) DEFAULT NULL,
  `dt_j` varchar(45) DEFAULT NULL,
  `dt_k` varchar(45) DEFAULT NULL,
  `dt_l` varchar(45) DEFAULT NULL,
  `dt_m` varchar(45) DEFAULT NULL,
  `dt_n` varchar(45) DEFAULT NULL,
  `dt_o` varchar(45) DEFAULT NULL,
  `dt_p` varchar(45) DEFAULT NULL,
  `dt_q` varchar(45) DEFAULT NULL,
  `dt_r` varchar(45) DEFAULT NULL,
  `dt_s` varchar(45) DEFAULT NULL,
  `dt_t` varchar(45) DEFAULT NULL,
  `dt_u` varchar(45) DEFAULT NULL,
  `dt_v` varchar(45) DEFAULT NULL,
  `dt_w` varchar(45) DEFAULT NULL,
  `dt_x` varchar(45) DEFAULT NULL,
  `dt_y` varchar(45) DEFAULT NULL,
  `dt_z` varchar(45) DEFAULT NULL,
  `dt_aa` varchar(45) DEFAULT NULL,
  `dt_ab` varchar(45) DEFAULT NULL,
  `dt_ac` varchar(45) DEFAULT NULL,
  `dt_ad` varchar(45) DEFAULT NULL,
  `dt_ae` varchar(45) DEFAULT NULL,
  `dt_af` varchar(45) DEFAULT NULL,
  `dt_ag` varchar(45) DEFAULT NULL,
  `dt_ah` varchar(45) DEFAULT NULL,
  `dt_ai` varchar(45) DEFAULT NULL,
  `dt_aj` varchar(45) DEFAULT NULL,
  `dt_ak` varchar(45) DEFAULT NULL,
  `dt_al` varchar(45) DEFAULT NULL,
  `dt_am` varchar(45) DEFAULT NULL,
  `dt_an` varchar(45) DEFAULT NULL,
  `dt_ao` varchar(45) DEFAULT NULL,
  `dt_ap` varchar(45) DEFAULT NULL,
  `dt_aq` varchar(45) DEFAULT NULL,
  `dt_ar` varchar(45) DEFAULT NULL,
  `dt_as` varchar(45) DEFAULT NULL,
  `dt_at` varchar(45) DEFAULT NULL,
  `dt_au` varchar(45) DEFAULT NULL,
  `dt_av` varchar(45) DEFAULT NULL,
  `dt_aw` varchar(45) DEFAULT NULL,
  `dt_ax` varchar(45) DEFAULT NULL,
  `dt_ay` varchar(45) DEFAULT NULL,
  `dt_az` varchar(45) DEFAULT NULL,
  `dt_ba` varchar(45) DEFAULT NULL,
  `dt_bb` varchar(45) DEFAULT NULL,
  `dt_bc` varchar(45) DEFAULT NULL,
  `dt_bd` varchar(45) DEFAULT NULL,
  `dt_be` varchar(45) DEFAULT NULL,
  `dt_bf` varchar(45) DEFAULT NULL,
  `dt_bg` varchar(45) DEFAULT NULL,
  `dt_bh` varchar(45) DEFAULT NULL,
  `dt_bi` varchar(45) DEFAULT NULL,
  `dt_bj` varchar(45) DEFAULT NULL,
  `dt_bk` varchar(45) DEFAULT NULL,
  `dt_bl` varchar(45) DEFAULT NULL,
  `dt_bm` varchar(45) DEFAULT NULL,
  `dt_bn` varchar(45) DEFAULT NULL,
  `dt_bo` varchar(45) DEFAULT NULL,
  `dt_bp` varchar(45) DEFAULT NULL,
  `dt_bq` varchar(45) DEFAULT NULL,
  `dt_br` varchar(45) DEFAULT NULL,
  `dt_bs` varchar(45) DEFAULT NULL,
  `dt_bt` varchar(45) DEFAULT NULL,
  `dt_bu` varchar(45) DEFAULT NULL,
  `dt_bv` varchar(45) DEFAULT NULL,
  `dt_bw` varchar(45) DEFAULT NULL,
  `dt_bx` varchar(45) DEFAULT NULL,
  `dt_by` varchar(45) DEFAULT NULL,
  `dt_bz` varchar(45) DEFAULT NULL,
  `dt_ca` varchar(45) DEFAULT NULL,
  `dt_cb` varchar(45) DEFAULT NULL,
  `dt_cc` varchar(45) DEFAULT NULL,
  `dt_cd` varchar(45) DEFAULT NULL,
  `dt_ce` varchar(45) DEFAULT NULL,
  `dt_cf` varchar(45) DEFAULT NULL,
  `dt_cg` varchar(45) DEFAULT NULL,
  `dt_ch` varchar(45) DEFAULT NULL,
  `dt_ci` varchar(45) DEFAULT NULL,
  `dt_cj` varchar(45) DEFAULT NULL,
  `dt_ck` varchar(45) DEFAULT NULL,
  `dt_cl` varchar(45) DEFAULT NULL,
  `dt_cm` varchar(45) DEFAULT NULL,
  `dt_cn` varchar(45) DEFAULT NULL,
  `dt_co` varchar(45) DEFAULT NULL,
  `dt_cp` varchar(45) DEFAULT NULL,
  `dt_cq` varchar(45) DEFAULT NULL,
  `dt_cr` varchar(45) DEFAULT NULL,
  `dt_cs` varchar(45) DEFAULT NULL,
  `dt_ct` varchar(45) DEFAULT NULL,
  `dt_cu` varchar(45) DEFAULT NULL,
  `dt_cv` varchar(45) DEFAULT NULL,
  `dt_cw` varchar(45) DEFAULT NULL,
  `dt_cx` varchar(45) DEFAULT NULL,
  `dt_cy` varchar(45) DEFAULT NULL,
  `dt_cz` varchar(45) DEFAULT NULL,
  `dt_da` varchar(45) DEFAULT NULL,
  `dt_db` varchar(45) DEFAULT NULL,
  `dt_dc` varchar(45) DEFAULT NULL,
  `dt_dd` varchar(45) DEFAULT NULL,
  `dt_de` varchar(45) DEFAULT NULL,
  `dt_df` varchar(45) DEFAULT NULL,
  `dt_dg` varchar(45) DEFAULT NULL,
  `dt_dh` varchar(45) DEFAULT NULL,
  `dt_di` varchar(45) DEFAULT NULL,
  `dt_dj` varchar(45) DEFAULT NULL,
  `dt_dk` varchar(45) DEFAULT NULL,
  `dt_dl` varchar(45) DEFAULT NULL,
  `dt_dm` varchar(45) DEFAULT NULL,
  `dt_dn` varchar(45) DEFAULT NULL,
  `dt_do` varchar(45) DEFAULT NULL,
  `dt_dp` varchar(45) DEFAULT NULL,
  `dt_dq` varchar(45) DEFAULT NULL,
  `dt_dr` varchar(45) DEFAULT NULL,
  `dt_ds` varchar(45) DEFAULT NULL,
  `dt_dt` varchar(45) DEFAULT NULL,
  `dt_du` varchar(45) DEFAULT NULL,
  `dt_dv` varchar(45) DEFAULT NULL,
  `dt_dw` varchar(45) DEFAULT NULL,
  `dt_dx` varchar(45) DEFAULT NULL,
  `dt_dy` varchar(45) DEFAULT NULL,
  `dt_dz` varchar(45) DEFAULT NULL,
  `dt_ea` varchar(45) DEFAULT NULL,
  `dt_eb` varchar(45) DEFAULT NULL,
  `dt_ec` varchar(45) DEFAULT NULL,
  `dt_ed` varchar(45) DEFAULT NULL,
  `dt_ee` varchar(45) DEFAULT NULL,
  `dt_ef` varchar(45) DEFAULT NULL,
  `dt_eg` varchar(45) DEFAULT NULL,
  `dt_eh` varchar(45) DEFAULT NULL,
  `dt_ei` varchar(45) DEFAULT NULL,
  `dt_ej` varchar(45) DEFAULT NULL,
  `dt_ek` varchar(45) DEFAULT NULL,
  `dt_el` varchar(45) DEFAULT NULL,
  `dt_em` varchar(45) DEFAULT NULL,
  `dt_en` varchar(45) DEFAULT NULL,
  `dt_eo` varchar(45) DEFAULT NULL,
  `dt_ep` varchar(45) DEFAULT NULL,
  `dt_eq` varchar(45) DEFAULT NULL,
  `dt_er` varchar(45) DEFAULT NULL,
  `dt_es` varchar(45) DEFAULT NULL,
  `dt_et` varchar(45) DEFAULT NULL,
  `dt_eu` varchar(45) DEFAULT NULL,
  `dt_ev` varchar(45) DEFAULT NULL,
  `dt_ew` varchar(45) DEFAULT NULL,
  `dt_ex` varchar(45) DEFAULT NULL,
  `dt_ey` varchar(45) DEFAULT NULL,
  `dt_ez` varchar(45) DEFAULT NULL,
  `dt_fa` varchar(45) DEFAULT NULL,
  `dt_fb` varchar(45) DEFAULT NULL,
  `dt_fc` varchar(45) DEFAULT NULL,
  `dt_fd` varchar(45) DEFAULT NULL,
  `dt_fe` varchar(45) DEFAULT NULL,
  `dt_ff` varchar(45) DEFAULT NULL,
  `dt_fg` varchar(45) DEFAULT NULL,
  `dt_fh` varchar(45) DEFAULT NULL,
  `dt_fi` varchar(45) DEFAULT NULL,
  `dt_fj` varchar(45) DEFAULT NULL,
  `dt_fk` varchar(45) DEFAULT NULL,
  `dt_fl` varchar(45) DEFAULT NULL,
  `dt_fm` varchar(45) DEFAULT NULL,
  `dt_fn` varchar(45) DEFAULT NULL,
  `dt_fo` varchar(45) DEFAULT NULL,
  `dt_fp` varchar(45) DEFAULT NULL,
  `dt_fq` varchar(45) DEFAULT NULL,
  `dt_fr` varchar(45) DEFAULT NULL,
  `dt_fs` varchar(45) DEFAULT NULL,
  `dt_ft` varchar(45) DEFAULT NULL,
  `dt_fu` varchar(45) DEFAULT NULL,
  `dt_fv` varchar(45) DEFAULT NULL,
  `dt_fw` varchar(45) DEFAULT NULL,
  `dt_fx` varchar(45) DEFAULT NULL,
  `dt_fy` varchar(45) DEFAULT NULL,
  `dt_fz` varchar(45) DEFAULT NULL,
  `dt_ga` varchar(45) DEFAULT NULL,
  `dt_gb` varchar(45) DEFAULT NULL,
  `dt_gc` varchar(45) DEFAULT NULL,
  `dt_gd` varchar(45) DEFAULT NULL,
  `dt_ge` varchar(45) DEFAULT NULL,
  `dt_gf` varchar(45) DEFAULT NULL,
  `dt_gg` varchar(45) DEFAULT NULL,
  `dt_gh` varchar(45) DEFAULT NULL,
  `dt_gi` varchar(45) DEFAULT NULL,
  `dt_gj` varchar(45) DEFAULT NULL,
  `dt_gk` varchar(45) DEFAULT NULL,
  `dt_gl` varchar(45) DEFAULT NULL,
  `dt_gm` varchar(45) DEFAULT NULL,
  `dt_gn` varchar(45) DEFAULT NULL,
  `dt_go` varchar(45) DEFAULT NULL,
  `dt_gp` varchar(45) DEFAULT NULL,
  `dt_gq` varchar(45) DEFAULT NULL,
  `dt_gr` varchar(45) DEFAULT NULL,
  `dt_gs` varchar(45) DEFAULT NULL,
  `dt_gt` varchar(45) DEFAULT NULL,
  `dt_gu` varchar(45) DEFAULT NULL,
  `dt_gv` varchar(45) DEFAULT NULL,
  `dt_gw` varchar(45) DEFAULT NULL,
  `dt_gx` varchar(45) DEFAULT NULL,
  `dt_gy` varchar(45) DEFAULT NULL,
  `dt_gz` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dt_a`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

CREATE TABLE `trip_distance` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) NOT NULL,
  `distance` int(10) NOT NULL DEFAULT '0',
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `duration` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `stat_accu_distance_bef_charge` (
  `vin` varchar(45) NOT NULL,
  `distance` int(8) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `stat_vehicle_charge_activity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `success` int(4) DEFAULT '0',
  `total` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `stat_vehicle_charge_time` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) NOT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `duration` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='统计充电开始时间、结束时间和持续时间';

CREATE TABLE `stat_vehicle_gear_low_duration` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `duration` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `stat_vehicle_lost_packet` (
  `vin` varchar(45) NOT NULL,
  `lost_cnt` varchar(45) NOT NULL DEFAULT '0',
  `get_cnt` varchar(45) NOT NULL DEFAULT '0',
  `start_date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `stat_vehicle_neutral_duration` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `start_time` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `duration` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `stat_vehicle_soc_bef_aft_charge` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `start_soc` varchar(45) DEFAULT NULL,
  `end_soc` varchar(45) DEFAULT NULL,
  `delta_soc` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='充电前后soc';

CREATE TABLE `stat_vehicle_trip_gear_low` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `gear_low_cnt` int(10) DEFAULT '0',
  `gear_other_cnt` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `stat_day_distance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(20) DEFAULT NULL,
  `vin` varchar(45) DEFAULT NULL,
  `start_mileage` varchar(45) DEFAULT NULL,
  `end_mileage` varchar(45) DEFAULT NULL,
  `dayDistance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into stat_day_distance(vin,end_mileage,start_mileage,dayDistance,day)
SELECT 
    a.dt_d, MAX(cast(a.dt_de as decimal)) AS max_bs,MIN(cast(a.dt_de as decimal)) AS min_bs, 
    (MAX(cast(a.dt_de as decimal))-MIN(cast(a.dt_de as decimal))) as dayDistance,LEFT(a.dt_l, 10)
FROM
    t_cevdm_mp1 a where dt_de is not null
	group by a.dt_d,LEFT(a.dt_l, 10);

CREATE TABLE `stat_vehicle_drive_soc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soc_range` varchar(100) NOT NULL,
  `counts` int(11) NOT NULL DEFAULT '0',
  `holiday_flag` varchar(10) DEFAULT NULL COMMENT '"0":natural day","1":holiday,"2":not holiday',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into stat_vehicle_drive_soc(soc_range,counts,holiday_flag)
SELECT elt(INTERVAL(cast(dt_aj as signed),0,10, 20, 30, 40, 50, 60, 70, 80, 90,100), 
	'01/soc<10%', '02/10%=<soc<20%', '03/20%=<soc<30%', '04/30%=<soc<40%', '05/40%=<soc<50%','06/50%=<soc<60%','07/60%=<soc<70%',
	'08/70%=<soc<80%', '09/80%=<soc<90%', '10/90%=<soc<100%','11/soc>=100%') as soc_range, count(dt_d) as counts,'1'
    FROM (
SELECT 
    dt_d,dt_aj
FROM
    t_cevdm_mp1 where dt_aj is not null and dt_cx = 'run' 
		and left(dt_l,10) in(select day from holiday where year = 2018)
    ) r
    GROUP BY elt(INTERVAL(cast(dt_aj as signed),0,10, 20, 30, 40, 50, 60, 70, 80, 90,100), 
	'01/soc<10%', '02/10%=<soc<20%', '03/20%=<soc<30%', '04/30%=<soc<40%', '05/40%=<soc<50%','06/50%=<soc<60%','07/60%=<soc<70%',
	'08/70%=<soc<80%', '09/80%=<soc<90%', '10/90%=<soc<100%','11/soc>=100%');

insert into stat_vehicle_drive_soc(soc_range,counts,holiday_flag)
SELECT elt(INTERVAL(cast(dt_aj as signed),0,10, 20, 30, 40, 50, 60, 70, 80, 90,100), 
	'01/soc<10%', '02/10%=<soc<20%', '03/20%=<soc<30%', '04/30%=<soc<40%', '05/40%=<soc<50%','06/50%=<soc<60%','07/60%=<soc<70%',
	'08/70%=<soc<80%', '09/80%=<soc<90%', '10/90%=<soc<100%','11/soc>=100%') as soc_range, count(dt_d) as counts,'2'
    FROM (
SELECT 
    dt_d,dt_aj
FROM
    t_cevdm_mp1 where dt_aj is not null and dt_cx = 'run' 
		and left(dt_l,10) not in(select day from holiday where year = 2018)
    ) r
    GROUP BY elt(INTERVAL(cast(dt_aj as signed),0,10, 20, 30, 40, 50, 60, 70, 80, 90,100), 
	'01/soc<10%', '02/10%=<soc<20%', '03/20%=<soc<30%', '04/30%=<soc<40%', '05/40%=<soc<50%','06/50%=<soc<60%','07/60%=<soc<70%',
	'08/70%=<soc<80%', '09/80%=<soc<90%', '10/90%=<soc<100%','11/soc>=100%');

CREATE TABLE `stat_vehicle_hybrid_mode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hybrid_mode` varchar(100) DEFAULT NULL,
  `counts` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into stat_vehicle_hybrid_mode(hybrid_mode,counts)
select fc,count(dt_d) from t_cevdm_mp1 group by fc where fc is not null;


CREATE TABLE `stat_vehicle_drving_avg_soc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(45) DEFAULT NULL,
  `avg_soc` varchar(45) DEFAULT NULL,
  `holiday_flag` varchar(10) DEFAULT NULL COMMENT '"0":natural day",1":holiday,"2":not holiday',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `data_analysis_080615`.`stat_vehicle_drving_avg_soc`
(
`vin`,
`avg_soc`,
`holiday_flag`)
SELECT 
    dt_d,sum(dt_aj)/count(dt_d) soc,'0'

FROM
    t_cevdm_mp1 where dt_aj is not null and dt_cx = 'run'
	group by dt_d;

INSERT INTO `data_analysis_080615`.`stat_vehicle_drving_avg_soc`
(
`vin`,
`avg_soc`,
`holiday_flag`)
SELECT 
    dt_d,sum(dt_aj)/count(dt_d) soc,'1'
FROM
    t_cevdm_mp1 where dt_aj is not null and dt_cx = 'run' 
		and left(dt_l,10) in(select day from holiday where year = 2018)
	group by dt_d;
	
INSERT INTO `data_analysis_080615`.`stat_vehicle_drving_avg_soc`
(
`vin`,
`avg_soc`,
`holiday_flag`)
SELECT 
    dt_d,sum(dt_aj)/count(dt_d) soc,'2'
FROM
    t_cevdm_mp1 where dt_aj is not null and dt_cx = 'run' 
		and left(dt_l,10) not in(select day from holiday where year = 2018)
	group by dt_d;
