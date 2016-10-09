--今日动态
select outp_num, in_hos_num, out_hos_num, at_hos_num,emergency_num, wait_bed_num, use_bed_num, exam_num, lab_num, operation_num, outp_costs, inp_costs, critical_num, died_num from
       (select nvl(sum(decode(ov.visit_status,'挂号',1,0)), 0) outp_num
          from outp_visit ov
         where to_char(ov.operate_date, 'yyyy-mm-dd') = ?) a,
       (select nvl(count(visit_no),0) in_hos_num
          from inp_visit
         where to_char(admission_date_time,'yyyy-MM-dd')=?) b,
       (select nvl(count(visit_no),0) out_hos_num
          from inp_visit
         where to_char(discharge_date_time,'yyyy-MM-dd')=?) c,
       (select count(pih.patient_id) as at_hos_num
          from pats_in_hospital pih) d,
       (select nvl(sum(decode(visit_type,'急诊',1,0)),0) emergency_num
          from outp_visit
         where to_char(visit_date,'yyyy-MM-dd')=?) n ,
       (select count(afa.apply_no) as wait_bed_num
          from apply_for_admission afa
         where afa.appoint_status = '预约' and afa.admission_status is null ) e,
       (select count(br.bed_no) as use_bed_num
          from bed_rec br where br.bed_status = '1') f,
       (select nvl(sum(g1.exam_num),0) as exam_num
         from (select count(eo.order_id) as exam_num, to_char(eo.spm_recved_date,'yyyy-mm-dd') as spm_recved_date from exam_orders eo where eo.result_status = '2' group by eo.spm_recved_date) g1 where g1.spm_recved_date = ?) g,
       (select nvl(sum(h1.lab_num),0) as lab_num
          from (select count(lo.order_id) as lab_num, to_char(lo.spm_recved_date_time,'yyyy-mm-dd') as spm_recved_date_time
                  from lab_orders lo
                  where lo.lab_status = '2'
                  group by lo.spm_recved_date_time) h1
         where h1.spm_recved_date_time = ?) h,
       (select nvl(sum(i1.operation_num),0) as operation_num
          from (select count(om.oper_no) as operation_num, to_char(om.start_date_time,'yyyy-mm-dd') as start_date_time
                  from operation_master om
                  group by om.start_date_time) i1
         where i1.start_date_time = ?) i,
       (select nvl(sum(obd.costs),0) outp_costs
       from outp_bill_detail obd
       where to_char(obd.enter_date,'yyyy-mm-dd') = ?)j,
       (select nvl(sum(ibd.costs),0) inp_costs
       from inp_bill_detail ibd
       where to_char(ibd.enter_date,'yyyy-mm-dd') = ?)k,
       (select count(al.record_id) critical_num
         from adt_log al, pats_in_hospital pih
        where al.patient_id = pih.patient_id and al.visit_no = pih.visit_no and to_char(al.log_date_time,'yyyy-mm-dd') = ? and al.action_type_code in ('A', 'B'))l,
       (select count(al.record_id) died_num
         from adt_log al, pats_in_hospital pih
        where al.patient_id = pih.patient_id and al.visit_no = pih.visit_no and to_char(al.log_date_time,'yyyy-mm-dd') = ? and al.action_type_code = 'H')m


    --昨日动态
     select a.outp_num,
                     b.in_hos_num,
                     c.out_hos_num,
                     d.outp_costs,
                     e.inp_costs,
                     f.use_bed_num,
                     g.critical_num,
                     h.died_num,
                     i.exam_num,
                     j.lab_num,
                     k.operation_num,
                     l.wait_bed_num,
                     m.at_hos_num,
                     n.emergency_num
                from (select nvl(sum(sovd.outp_num), 0) outp_num
                        from st_outp_visit_day sovd
                       where to_char(sovd.st_date, 'yyyy-mm-dd') = ?) a,
                     (select nvl(count(visit_no),0) in_hos_num from inp_visit where to_char(admission_date_time,'yyyy-MM-dd')=?) b,
                     (select nvl(count(visit_no),0) out_hos_num from inp_visit where to_char(discharge_date_time,'yyyy-MM-dd')=?) c,
                     (select count(pih.patient_id) as at_hos_num from pats_in_hospital pih) m,
                     (select nvl(sum(decode(visit_type,'急诊',1,0)),0) emergency_num from outp_visit where to_char(visit_date,'yyyy-MM-dd')=?) n,
                     (select nvl(sum(socd.costs), 0) outp_costs
                        from st_outp_costs_day socd
                       where to_char(socd.st_date, 'yyyy-mm-dd') = ?) d,
                     (select nvl(sum(sicd.costs), 0) inp_costs
                        from st_inp_costs_day sicd
                       where to_char(sicd.st_date, 'yyyy-mm-dd') = ?) e,
                    (select count(br.bed_no) as use_bed_num from bed_rec br where br.bed_status = '1') f,
                     (select nvl(sum(sild.severity_num  sild.critical_num), 0) critical_num
                        from st_inp_load_day sild
                       where to_char(sild.st_date, 'yyyy-mm-dd') = ?) g,
                     (select nvl(sum(stqd.died_num), 0) died_num
                        from st_therapy_quality_day stqd
                       where to_char(stqd.st_date, 'yyyy-mm-dd') = ?) h,
                     (select nvl(sum(sed.completed_num), 0) exam_num
                        from st_exam_day sed
                       where to_char(sed.st_date, 'yyyy-mm-dd') = ?) i,
                     (select nvl(sum(sld.completed_num), 0) lab_num
                        from st_lab_day sld
                       where to_char(sld.st_date, 'yyyy-mm-dd') = ?) j,
                     (select nvl(sum(soqd.great_oper_num  soqd.major_oper_num 
                                     soqd.medium_oper_num  soqd.minor_oper_num),
                                 0) operation_num
                        from st_operation_quality_day soqd
                       where to_char(soqd.st_date, 'yyyy-mm-dd') = ?) k,
                     (select nvl(sum(a.wait_bed_num  b.today_in_hos - c.today_appoint), 0) as wait_bed_num
                        from (select count(afa1.apply_no) as wait_bed_num
                                from apply_for_admission afa1
                               where afa1.appoint_status = '预约'
                                 and afa1.admission_status is null) a,
                             (select nvl(sum(count(afa2.apply_no)), 0) today_in_hos
                                from apply_for_admission afa2
                               where afa2.appoint_status = '预约'
                                 and afa2.admission_status is not null
                                 and to_char(afa2.apply_date, 'yyyy-mm-dd') = ?
                               group by afa2.apply_date) b,
                             (select nvl(sum(count(afa3.apply_no)), 0) today_appoint
                                from apply_for_admission afa3
                               where afa3.appoint_status = '预约'
                                 and afa3.admission_status is null
                                 and to_char(afa3.apply_date, 'yyyy-mm-dd') = ?
                               group by afa3.apply_date) c) l




--今日动态详细  和昨日动态详细中一样
select a.register_num,m.common_people,l.prior_people,a.diagnosed_people,a.not_diagnosed_people,
                   a.emergency_num,b.admitted_num,b.admitted_observ_num,
                   c.outp_charges,
                   d.inp_charges,
                   e.special_operation,e.big_operation,e.middle_operation,e.small_operation, 
                   f.null_bed_num,f.add_bed_num,
                   g.in_hos_num,
                   h.admit_prior_num,
                   i.admit_common_num,
                   j.discharge_common_num,
                   k.discharge_prior_num,
                         n.drug_costs,
                         o.clinic_costs
                       from 
                       (select nvl(count(visit_no),0) register_num,                                                  
                               nvl(sum(decode(visit_status,'接诊',1,0)),0) diagnosed_people,                        
                               nvl((count(visit_no)-sum(decode(visit_status,'接诊',1,0))),0) not_diagnosed_people,    
                   nvl(sum(decode(visit_type,'急诊',1,0)),0) emergency_num                     
                          from outp_visit
                          where to_char(visit_date,'yyyy-MM-dd')=?) a,
                       (select nvl(sum(ADMITTED_NUM),0) admitted_num,               
                          nvl(sum(ADMITTED_OBSERV_NUM),0) admitted_observ_num   
                from st_emergency_day 
                where to_char(st_date,'yyyy-MM-dd')=?) b,
                         (select nvl(sum(charges),0) outp_charges from outp_bill_detail where to_char(enter_date,'yyyy-MM-dd')=?)  c,
                         (select nvl(sum(charges),0) inp_charges from inp_bill_detail where to_char(enter_date,'yyyy-MM-dd')=?)  d,
                         (select nvl(sum(decode(operating_scale,'特',1,0)),0) special_operation,           
                       nvl(sum(decode(operating_scale,'大',1,0)),0) big_operation,                   
                   nvl(sum(decode(operating_scale,'中',1,0)),0) middle_operation,               
                   nvl(sum(decode(operating_scale,'小',1,0)),0) small_operation                  
                  from operation_master 
                 where to_char(start_date_time,'yyyy-MM-dd')= ?) e,
                       (select NVL(sum(decode(bed_status,'0',1,0)),0) null_bed_num,          
                   nvl(sum(decode(bed_approved_type,'2',1,0)),0) add_bed_num     
                   from BED_REC) f ,
                       (select sum(decode(adt_status,'4',0,1)) in_hos_num 
                   from inp_visit
                         where to_char(admission_date_time,'yyyy-MM-dd')=?) g,
                       (select nvl(count(visit_no),0) admit_prior_num     
                     from inp_visit,base_code_dict 
                  where identity = code_name 
                  and ctrvalue0='1' 
                  and to_char(admission_date_time,'yyyy-MM-dd')=?) h,
                       (select nvl(count(visit_no),0) admit_common_num     
                     from inp_visit,base_code_dict 
                  where identity = code_name 
                  and ctrvalue0='0' 
                  and to_char(admission_date_time,'yyyy-MM-dd')=?) i,
                       (select nvl(count(visit_no),0) discharge_common_num  
                     from inp_visit,base_code_dict 
                  where identity = code_name 
                  and ctrvalue0='0' 
                  and to_char(discharge_date_time,'yyyy-MM-dd')=?) j,
                       (select nvl(count(visit_no),0) discharge_prior_num  
                  from inp_visit,base_code_dict 
                  where identity = code_name 
                  and ctrvalue0='1' 
                  and to_char(discharge_date_time,'yyyy-MM-dd')=?) k,
                       (select nvl(count(visit_no),0) prior_people         
                     from outp_visit ov,base_code_dict bcd 
                  where ov.identity = bcd.code_name 
                  and bcd.ctrvalue0='1' 
                  and to_char(visit_date,'yyyy-MM-dd')=?) l,
                  (select nvl(count(visit_no),0) common_people       
                     from outp_visit ov,base_code_dict bcd 
                  where ov.identity = bcd.code_name 
                  and bcd.ctrvalue0='0' 
                  and to_char(visit_date,'yyyy-MM-dd')=?) m,
                   (SELECT nvl(sum(decode(class_on_mr,'中药',costs,'西药',costs,0)),0) drug_costs
                    FROM OUTP_BILL_DETAIL obd
                    where to_char(obd.enter_date,'yyyy-MM-dd')=?) n,
                   (select nvl(sum(costs),0) clinic_costs
                    from OUTP_BILL_DETAIL obd,pat_master_index pmi
                    where obd.patient_id = pmi.patient_id
                      and pmi.charge_type in ('新农合','军队医改','地方医保','北京医保')
                      and to_char(obd.enter_date,'yyyy-MM-dd')=?) o;


--单病种总费用

SELECT t.DIAGNOSIS_NAME,sbt.DIAGNOSIS_CODE,
                (t.item_at.item_bt.item_ct.item_dt.item_et.item_ft.item_gt.item_ht.item_jt.item_kt.item_lt.item_z) total_costs,
                t.item_a,
                t.item_b,
                t.item_c,
                t.item_d,
                t.item_e,
                t.item_f,
                t.item_g,
                t.item_h,
                t.item_j,
                t.item_k,
                t.item_l,
                t.item_z,
                (t.total_costs/patient_count) avg_costs,
                (t.priority_costs/patient_count) priority_costs,
                (t.general_costs/patient_count) general_costs,
                (t.total_costs/general_days) day_avg_costs,
                (t.priority_costs/general_days) day_priority_costs,
                (t.general_costs/general_days) day_general_costs 
                FROM 
                (SELECT d.DIAGNOSIS_NAME,d.DIAGNOSIS_CODE,
                        count(v.patient_id) patient_count,
                        sum(decode(b.ITEM_CLASS,'A',b.COSTS,0)) item_a,
                        sum(decode(b.ITEM_CLASS,'B',b.COSTS,0)) item_b,
                        sum(decode(b.ITEM_CLASS,'C',b.COSTS,0)) item_c,
                        sum(decode(b.ITEM_CLASS,'D',b.COSTS,0)) item_d,
                        sum(decode(b.ITEM_CLASS,'E',b.COSTS,0)) item_e,
                        sum(decode(b.ITEM_CLASS,'F',b.COSTS,0)) item_f,
                        sum(decode(b.ITEM_CLASS,'g',b.COSTS,0)) item_g,
                        sum(decode(b.ITEM_CLASS,'H',b.COSTS,0)) item_h,
                        sum(decode(b.ITEM_CLASS,'J',b.COSTS,0)) item_j,
                        sum(decode(b.ITEM_CLASS,'K',b.COSTS,0)) item_k,
                        sum(decode(b.ITEM_CLASS,'L',b.COSTS,0)) item_l,
                        sum(decode(b.ITEM_CLASS,'Z',b.COSTS,0)) item_z,
                        sum(nvl(v.total_costs,0)) total_costs,
                        sum(decode(i.Ctrvalue0, 1, v.TOTAL_COSTS, 0)) priority_costs,
                        sum(decode(i.Ctrvalue0, 0, nvl(v.TOTAL_COSTS,0), 0)) general_costs,
                        sum(trunc(v.DISCHARGE_DATE_TIME) - trunc(v.ADMISSION_DATE_TIME))  general_days
                 FROM DIAGNOSTIC_CATEGORY c, INP_VISIT v, DIAGNOSIS_DICT d, BASE_CODE_DICT i,INP_BILL_DETAIL b
                 WHERE (c.DIAG_TYPE = '1')
                  AND (c.DIAG_NO = 1)
                  AND I.CODETYPE_NAME = 'IDENTITY_DICT'
                  AND i.CODE_NAME=v.IDENTITY
                  AND (v.DISCHARGE_DATE_TIME >= ?)
                  AND (v.DISCHARGE_DATE_TIME < ?)
                  AND (c.PATIENT_ID = v.PATIENT_ID)
                  AND (c.VISIT_NO = v.VISIT_NO)
                  AND b.PATIENT_ID = c.PATIENT_ID
                  AND b.VISIT_NO = c.VISIT_NO
                  AND (c.DIAG_CODE = d.DIAGNOSIS_CODE)
                  AND (d.std_indicator = 1) 
                GROUP BY d.DIAGNOSIS_NAME,d.DIAGNOSIS_CODE) t


--住院患者日均费用
select temp.dept_name, temp.identity, temp.num
                  from (select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs * d.total_in_hos_days,
                                                0,
                                                0,
                                                a.costs / d.total_in_hos_days)),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where b.dept_code = a.performed_by
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-12-01','YYYY-MM-DD')
                           and d.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-12-01','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '1'
                         group by b.dept_Name, a.identity
                        union
                        select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs * d.total_in_hos_days,
                                                0,
                                                0,
                                                a.costs / d.total_in_hos_days)),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where a.performed_by = b.dept_code
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-12-01','YYYY-MM-DD')
                           and d.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-12-01','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '0'
                         group by b.dept_Name, a.identity) temp
                 where rownum <= 10 and temp.num>0



--平均费用  inpperson
select temp.dept_name, temp.identity, temp.num
                  from (select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs *
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num),
                                                        0,
                                                        0,
                                                        a.costs /
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num))),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where b.dept_code = a.performed_by
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-12-31','YYYY-MM-DD')
                           and d.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-12-31','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '1'
                         group by b.dept_Name, a.identity
                        union
                        select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs *
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num),
                                                        0,
                                                        0,
                                                        a.costs /
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num))),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where a.performed_by = b.dept_code
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-12-31','YYYY-MM-DD')
                           and d.st_date >= to_date('2015-01-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-12-31','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '0'
                         group by b.dept_Name, a.identity) temp;
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
select temp.dept_name, temp.identity, temp.num
                  from (select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs * d.total_in_hos_days,
                                                0,
                                                0,
                                                a.costs / d.total_in_hos_days)),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where b.dept_code = a.performed_by
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= ?
                           and a.st_date < ?
                           and d.st_date >= ?
                           and d.st_date < ?
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '1'
                         group by b.dept_Name, a.identity
                        union
                        select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs * d.total_in_hos_days,
                                                0,
                                                0,
                                                a.costs / d.total_in_hos_days)),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where a.performed_by = b.dept_code
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= ?
                           and a.st_date < ?
                           and d.st_date >= ?
                           and d.st_date < ?
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '0'
                         group by b.dept_Name, a.identity) temp
                 where rownum <= 10
                 
                 
                 
                 

                 
--住院患者次均费用
select temp.dept_name, temp.identity, temp.num
                  from (select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs *
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num),
                                                        0,
                                                        0,
                                                        a.costs /
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num))),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where b.dept_code = a.performed_by
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2016-05-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-06-01','YYYY-MM-DD')
                           and d.st_date >= to_date('2016-05-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-06-01','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '1'
                         group by b.dept_Name, a.identity
                        union
                        select b.dept_Name as dept_Name,
                               a.identity,
                               round(avg(decode(a.costs *
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num),
                                                        0,
                                                        0,
                                                        a.costs /
                                                        (d.normal_discharge_num 
                                                        d.trans_hos_num  d.died_num))),
                                     2) as num
                          from ST_INP_COSTS_MON      a,
                               DEPT_DICT             b,
                               Base_Code_Dict        c,
                               ST_INP_EFFICIENCY_MON d
                         where a.performed_by = b.dept_code
                           and b.dept_code = d.dept_code
                           and a.identity = d.identity
                           and a.charge_type = d.charge_type
                           and a.st_date >= to_date('2016-05-01','YYYY-MM-DD')
                           and a.st_date < to_date('2016-06-01','YYYY-MM-DD')
                           and d.st_date >= to_date('2016-05-01','YYYY-MM-DD')
                           and d.st_date < to_date('2016-06-01','YYYY-MM-DD')
                           and a.identity = c.code_Name
                           and c.codetype_name = 'IDENTITY_DICT'
                           and c.CTRVALUE0 = '0'
                         group by b.dept_Name, a.identity) temp
                 where rownum <= 10
                 
                 
                 
                 
                 
                 
                 
                 
select d.dept_Name, sum (a.costs) as num,a.identity  
                                from St_Outp_Costs_Mon a,DEPT_DICT d ,base_code_dict bcd  
                                where a.ST_DATE >= to_date('2016-02-01','YYYY-MM-DD')  and a.ST_DATE < to_date('2016-03-01','YYYY-MM-DD')
                                and a.ordered_by_dept = d.dept_code  
                                and bcd.code_name = a.identity  
                                group by (d.dept_Name,d.dept_code,a.identity) order by num 
                                
                                
SELECT NAME,NUM1,NUM2 FROM (
 
                        SELECT B.DEPT_NAME AS NAME,nvl(A.COSTS,0) AS NUM1,nvl(A.CHARGES,0) AS NUM2
                        FROM ST_OUTP_COSTS_MON A,DEPT_DICT B
                        WHERE A.ST_DATE>=to_date('2016-02-01','YYYY-MM-DD')
                          AND A.ST_DATE<to_date('2016-03-01','YYYY-MM-DD')
                          AND A.ORDERED_BY_DEPT = B.DEPT_CODE
                        ORDER BY A.COSTS DESC
                        )
                        WHERE ROWNUM<=10
                        
                        
                        
select * from (
      select a.dept_name as name,decode(a.day_num,0,0,round(a.day_num/a.pe_num,2)) as num1 from
                 (select b.dept_name,sum(NVL(sie.total_bef_oper_days,0)) as day_num,sum(NVL(sie.oper_num,0)) as pe_num
                 from st_inp_efficiency_mon sie ,dept_dict b
                 where sie.dept_code = b.DEPT_CODE
                 and sie.ST_DATE >= to_date('2016-02-01','YYYY-MM-DD')  and sie.ST_DATE < to_date('2016-03-01','YYYY-MM-DD')
                 group by b.dept_name) a
      where a.num1>0
      order by num1 desc) l
where rownum<=10




--工作效率流动人数
select name, num1, num2 from (select b.DEPT_NAME as name,  
                sum(nvl(a.ADM_OUTPS_NUM,0)+nvl(a.ADM_EMERGENCY_NUM,0)+nvl(a.ADM_OTHER_HOS_NUM,0)+nvl(a.ADM_OTHER_DEPT_NUM,0)) as num1 ,
                sum(nvl(a.NORMAL_DISCHARGE_NUM,0)+nvl(a.TRANS_HOS_NUM,0)+nvl(a.DIED_NUM,0)+nvl(a.TRANS_DEPT_NUM,0)) as num2
                from ST_INP_EFFICIENCY_MON a, DEPT_DICT b
                where a.DEPT_CODE(+) = b.DEPT_CODE  and (b.OUTP_OR_INP=1 or b.OUTP_OR_INP=2) and CLINIC_ATTR=0
                and a.ST_DATE(+) >= to_date('2016-04-01','YYYY-MM-DD')  and a.ST_DATE(+) < to_date('2016-05-01','YYYY-MM-DD')
                group by b.DEPT_NAME
                order by sum(nvl(a.NORMAL_DISCHARGE_NUM,0) nvl(a.TRANS_HOS_NUM,0) nvl(a.DIED_NUM,0) nvl(a.TRANS_DEPT_NUM,0)) desc, b.DEPT_NAME)
                where ROWNUM <= 10 and (num1+num2) > 0