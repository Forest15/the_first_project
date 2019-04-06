INSERT INTO Access ( id, version, login, password, name, is_active )
   VALUES ( 1, 0, 'Vova', 'gifecurire', 'Vladimir', true ) ;

INSERT INTO Organization ( id, version, name, full_name, inn, kpp, address, phone, is_active )
   VALUES ( 1, 0, 'Beeline', 'Vimpelcom', '111111111111', '111111111' ,'ул. 8-го марта', '100', true ) ;

INSERT INTO Organization ( id, version, name, full_name, inn, kpp, address, phone, is_active )
   VALUES ( 2, 0, 'MTS', 'Mobile Telecom Systems', '222222222222', '222222222' ,'ул. МТС, дом 2', '200', true ) ;


INSERT INTO Office ( id, version, org_id, name, address, phone, is_active )
   VALUES ( 1, 0, 1, 'BeelineTechOffice', 'ул. Станции Билайн', '909', true ) ;
   
INSERT INTO Office ( id, version, org_id, name, address, phone, is_active )
   VALUES ( 2, 0, 1, 'BeelineSalesOffice', 'ул. Офиса продаж Билайн', '910', true ) ;
   
INSERT INTO Office ( id, version, org_id, name, address, phone, is_active )
   VALUES ( 3, 0, 2, 'MTSTechOffice', 'ул. Станции МТС', '915', true ) ;   
   
INSERT INTO Office ( id, version, org_id, name, address, phone, is_active )
   VALUES ( 4, 0, 2, 'MTSSalesOffice', 'ул. Офиса продаж МТС', '916', true ) ;
 


INSERT INTO Doc_Type ( id, version, code, name )
VALUES ( 1, 0, '21', 'Паспорт гражданина РФ' ) ;

INSERT INTO Doc_Type ( id, version, code, name )
VALUES ( 2, 0, '12', 'Вид на жительство в РФ' ) ;

INSERT INTO Doc_Type ( id, version, code, name )
VALUES ( 3, 0, '10', 'Паспорт иностранного гражданина' ) ;


INSERT INTO Country ( id, version, code, name )
VALUES ( 1, 0, '643', 'Российская Федерация' ) ;

INSERT INTO Country ( id, version, code, name )
VALUES ( 2, 0, '276', 'ФРГ' ) ;

INSERT INTO Country ( id, version, code, name )
VALUES ( 3, 0, '348', 'Венгрия' ) ;


INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 1, 0, 1, 1, 1, 'Vladimir', 'Igorevich', 'Cherevko', 'admin', '111', '1111111111', '17.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 2, 0, 2, 2, 1, 'Vasiliy', 'Romanovich', 'Kapitonov', 'developer', '222', '2222222222', '18.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 3, 0, 1, 1, 2, 'Boris', 'Igorevich', 'Andreev', 'manager', '333', '3333333333', '19.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 4, 0, 3, 2, 2, 'Ivan', 'Vasilievich', 'Volkov', 'specialist', '444', '4444444444', '20.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 5, 0, 1, 1, 3, 'Petr', 'Semenovich', 'Ivanov', 'admin', '555', '5555555555', '21.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 6, 0, 2, 3, 3, 'Igor', 'Aleksandrovich', 'Kulagin', 'developer', '777', '7777777777', '22.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 7, 0, 1, 1, 4, 'Andrey', 'Andreevich', 'Fedotkin', 'manager', '888', '8888888888', '23.06.2008', true ) ;

INSERT INTO User ( id, version, doc_type_id, country_id, office_id, first_name, middle_name, second_name, position, phone, doc_number, doc_date, is_identified )
VALUES ( 8, 0, 3, 3, 4, 'Semen', 'Petrovich', 'Vasiliev', 'specialist', '999', '9999999999', '24.06.2008', true ) ;