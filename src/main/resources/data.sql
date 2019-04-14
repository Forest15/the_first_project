/*Here, I insert the data to the organization table.*/
INSERT INTO tfp.organization ( id, name, full_name, inn, kpp, address, phone, is_active )
VALUES ( 1, 'Beeline', 'Vimpelcom', '111111111111', '111111111', 'ул. 8-го марта', '84959999990', true ) ;

INSERT INTO tfp.organization ( id, name, full_name, inn, kpp, address, phone, is_active )
VALUES ( 2, 'MTS', 'Mobile Telecom Systems', '222222222222', '222222222' ,'ул. МТС, дом 2', '84959999980', true ) ;

/*Here, I insert the data to the office table.*/
INSERT INTO tfp.office ( id, org_id, name, address, office_phone, is_active )
VALUES ( 1, 1, 'BeelineTechOffice', 'ул. Станции Билайн', '84959999991', true ) ;
   
INSERT INTO tfp.office ( id, org_id, name, address, office_phone, is_active )
VALUES ( 2, 1, 'BeelineSalesOffice', 'ул. Офиса продаж Билайн', '84959999992', true ) ;
   
INSERT INTO tfp.office ( id, org_id, name, address, office_phone, is_active )
VALUES ( 3, 2, 'MTSTechOffice', 'ул. Станции МТС', '84959999981', true ) ;
   
INSERT INTO tfp.office ( id, org_id, name, address, office_phone, is_active )
VALUES ( 4, 2, 'MTSSalesOffice', 'ул. Офиса продаж МТС', '84959999982', true ) ;
 
/*Here, I insert the data to the country table.*/
INSERT INTO tfp.country ( id, code, name )
VALUES ( 1, '643', 'Российская Федерация' ) ;

INSERT INTO tfp.country ( id, code, name )
VALUES ( 2, '276', 'ФРГ' ) ;

INSERT INTO tfp.country ( id, code, name )
VALUES ( 3, '348', 'Венгрия' ) ;

/*Here, I insert the data to the user table.*/
INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 1, 1, 1, 'Vladimir', 'Igorevich', 'Cherevko', 'admin', '*1', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 2, 2, 1, 'Vasiliy', 'Romanovich', 'Kapitonov', 'developer', '*2', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 3, 1, 2, 'Boris', 'Igorevich', 'Andreev', 'manager', '*1', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 4, 2, 2, 'Ivan', 'Vasilievich', 'Volkov', 'specialist', '*2', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 5, 1, 3, 'Petr', 'Semenovich', 'Ivanov', 'admin', '*1', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 6, 3, 3, 'Igor', 'Aleksandrovich', 'Kulagin', 'developer', '*2', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 7, 1, 4, 'Andrey', 'Andreevich', 'Fedotkin', 'manager', '*1', true ) ;

INSERT INTO tfp.user ( id, country_id, office_id, first_name, middle_name, second_name, position, user_phone, is_identified )
VALUES ( 8, 3, 4, 'Semen', 'Petrovich', 'Vasiliev', 'specialist', '*2', true ) ;

/*Here, I insert the data to the doc_type table.*/
INSERT INTO tfp.doc_type ( id, code, name )
VALUES ( 1, '21', 'Паспорт гражданина РФ' ) ;

INSERT INTO tfp.doc_type ( id, code, name )
VALUES ( 2, '12', 'Вид на жительство в РФ' ) ;

INSERT INTO tfp.doc_type ( id, code, name )
VALUES ( 3, '10', 'Паспорт иностранного гражданина' ) ;

/*Here, I insert the data to the user_doc table.*/
INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 1, 1, '11.03.88', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 1, 2, '12.03.88', false ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 2, 2, '01.05.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 2, 3, '02.05.90', false ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 3, 1, '10.06.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 4, 1, '20.06.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 5, 2, '20.07.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 6, 2, '15.09.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 7, 3, '15.10.90', true ) ;

INSERT INTO tfp.user_doc ( user_id, doc_id, doc_date, is_general )
VALUES ( 8, 3, '16.10.90', true ) ;