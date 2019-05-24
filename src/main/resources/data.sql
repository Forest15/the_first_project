/*Here, I insert the data to the organization table.*/
INSERT INTO tfp.organization (name, full_name, inn, kpp, address, phone, is_active )
VALUES ( 'Beeline', 'Vimpelcom', '111111111111', '111111111', 'ул. 8-го марта', '84959999990', true ) ;

INSERT INTO tfp.organization (name, full_name, inn, kpp, address, phone, is_active )
VALUES ( 'MTS', 'Mobile Telecom Systems', '222222222222', '222222222' ,'ул. МТС, дом 2', '84959999980', true ) ;

/*Here, I insert the data to the office table.*/
INSERT INTO tfp.office ( org_id, name, address, office_phone, is_active )
VALUES ( 1, 'BeelineTechOffice', 'ул. Станции Билайн', '84959999991', true ) ;
   
INSERT INTO tfp.office ( org_id, name, address, office_phone, is_active )
VALUES ( 1, 'BeelineSalesOffice', 'ул. Офиса продаж Билайн', '84959999992', true ) ;
   
INSERT INTO tfp.office ( org_id, name, address, office_phone, is_active )
VALUES ( 2, 'MTSTechOffice', 'ул. Станции МТС', '84959999981', true ) ;
   
INSERT INTO tfp.office ( org_id, name, address, office_phone, is_active )
VALUES ( 2, 'MTSSalesOffice', 'ул. Офиса продаж МТС', '84959999982', true ) ;
 
/*Here, I insert the data to the country table.*/
INSERT INTO tfp.country (code, name )
VALUES ('643', 'Российская Федерация' ) ;

INSERT INTO tfp.country (code, name )
VALUES ('276', 'ФРГ' ) ;

INSERT INTO tfp.country (code, name )
VALUES ('348', 'Венгрия' ) ;

/*Here, I insert the data to the user table.*/
INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (1, 1, 'Vladimir', 'Igorevich', 'Cherevko', 'admin', '*1', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (2, 1, 'Vasiliy', 'Romanovich', 'Kapitonov', 'developer', '*2', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (1, 2, 'Boris', 'Igorevich', 'Andreev', 'manager', '*1', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (2, 2, 'Ivan', 'Vasilievich', 'Volkov', 'specialist', '*2', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (1, 3, 'Petr', 'Semenovich', 'Ivanov', 'admin', '*1', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (3, 3, 'Igor', 'Aleksandrovich', 'Kulagin', 'developer', '*2', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (1, 4, 'Andrey', 'Andreevich', 'Fedotkin', 'manager', '*1', true ) ;

INSERT INTO tfp.user (country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES (3, 4, 'Semen', 'Petrovich', 'Vasiliev', 'specialist', '*2', true ) ;

/*Here, I insert the data to the doc_type table.*/
INSERT INTO tfp.doc_type (code, name )
VALUES ('21', 'Паспорт гражданина РФ' ) ;

INSERT INTO tfp.doc_type (code, name )
VALUES ('12', 'Вид на жительство в РФ' ) ;

INSERT INTO tfp.doc_type (code, name )
VALUES ('10', 'Паспорт иностранного гражданина' ) ;

/*Here, I insert the data to the user_doc table.*/
INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 1, 1, '9009908991', 'State Department #1', '115-551', '1988-03-11', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 1, 2, '9009908992', 'State Department #2', '115-552', '1988-03-12', false ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 2, 2, '9009908993', 'State Department #3', '115-553', '1990-05-11', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 2, 3, '9009908994', 'State Department #4', '115-554', '1990-05-02', false ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 3, 1, '9009908995', 'State Department #5', '115-555', '1990-06-10', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 4, 1, '9009908996', 'State Department #6', '115-556', '1990-06-20', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 5, 2, '9009908997', 'State Department #7', '115-557', '1990-07-20', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 6, 2, '9009908998', 'State Department #8', '115-558', '1990-07-15', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 7, 3, '9009908999', 'State Department #9', '115-559', '1990-10-15', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_type_id, ser_num, who_issued, dep_code, doc_date, is_general )
VALUES ( 8, 3, '9009908990', 'State Department #10', '115-550', '1990-10-16', true ) ;