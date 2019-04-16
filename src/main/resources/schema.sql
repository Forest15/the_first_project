/*Here, I create the scheme "tfp" for the first project tables.*/
CREATE SCHEMA tfp AUTHORIZATION SA ;

/*This table contains basic characteristics of organization.*/
CREATE TABLE IF NOT EXISTS tfp.organization (
-- The org id created with sequence
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- The company short name
    name VARCHAR(30) NOT NULL,
-- The company full name
    full_name VARCHAR(60) NOT NULL,
-- The company inn
    inn VARCHAR(12) NOT NULL,
-- The company kpp
    kpp VARCHAR(9) NOT NULL,
-- The company legal address
    address VARCHAR(50) NOT NULL,
-- The company phone
    phone VARCHAR(15) NOT NULL,
-- Is the company active?
    is_active BOOLEAN NOT NULL
);

CREATE INDEX ix_organization_id ON tfp.organization (id);

/*This table contains basic characteristics of office in organization. The table has m2o relationship with the organization table.*/
CREATE TABLE IF NOT EXISTS tfp.office (
-- The office id created with sequence
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- The FK references on the organization table
    org_id INTEGER,
-- The office name
    name VARCHAR(50) NOT NULL,
-- The office address
    address VARCHAR(50) NOT NULL,
-- The office phone
    office_phone VARCHAR(15) NOT NULL,
-- Is the office active?
    is_active BOOLEAN NOT NULL,
    FOREIGN KEY (org_id) REFERENCES tfp.organization(id)
);

CREATE INDEX ix_office_id ON tfp.office (id);
CREATE INDEX ix_office_org_id ON tfp.office (org_id);

/*The country table, contains id, country code, country name. Relationship with the user table is o2m*/
CREATE TABLE IF NOT EXISTS tfp.country (
-- The country id created with sequence
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- The State country code
    code VARCHAR(3) NOT NULL,
-- The country name
    name VARCHAR(60) NOT NULL
);

CREATE INDEX ix_country_id ON tfp.country (id);

/*This table contains basic characteristic of user working in office. The Table has m2o relationship with the office table, has m2o relationship with the country table and has m2m relationship with doc_type table by the user_doc junction table.*/
CREATE TABLE IF NOT EXISTS tfp.user (
-- The user id created with sequence
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- The FK references on the country table
    country_id INTEGER,
-- The FK references on the office table
    office_id INTEGER,
-- The first name of user
    first_name VARCHAR(50) NOT NULL,
-- The middle name of user
    middle_name VARCHAR(50) NOT NULL,
-- The second name of user
    second_name VARCHAR(50) NOT NULL,
-- The position of user
    position VARCHAR(20) NOT NULL,
-- The user's phone
    user_phone VARCHAR(15) NOT NULL,
-- Is the user identified?
    is_identified BOOLEAN NOT NULL,
    FOREIGN KEY (country_id) REFERENCES tfp.country(id),
    FOREIGN KEY (office_id) REFERENCES tfp.office(id)
);

CREATE INDEX ix_user_Id ON tfp.user (id);
CREATE INDEX ix_user_country_id ON tfp.user (country_id);
CREATE INDEX ix_user_office_id ON tfp.user (office_id);

/*The document type table, contains id, document code, document name. Relationship with the user table is m2m by using the user_doc table*/
CREATE TABLE IF NOT EXISTS tfp.doc_type(
-- The doc_type id created with sequence
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
-- The State Document code
    code VARCHAR(2) NOT NULL,
-- The State Document name
    name VARCHAR(60) NOT NULL
);

CREATE INDEX ix_doc_type_id ON tfp.doc_type (id);

/*The user_doc table, contains the user table PK, the doc_type table PK, document date, is_general field (Is this doc general then 1 else 0). This is the junction table for m2m relationship the user and the doc_type tables.*/
CREATE TABLE IF NOT EXISTS tfp.user_doc (
-- The first part of complex PK of the user_doc table. It is reference to the user table PK.
    user_id INTEGER NOT NULL REFERENCES tfp.user(id),
-- The second part of complex PK of the user_doc table. It is reference to the doc_type table PK.
    doc_type_id INTEGER NOT NULL REFERENCES tfp.doc_type(id),
-- Series and Number of the user document
    ser_num VARCHAR(10) NOT NULL,
-- Name of State Department which issued the document
    who_issued VARCHAR(50) NOT NULL,
-- Code of State Department whick issued the document
    dep_code VARCHAR(7),
-- The document issue date
    doc_date VARCHAR(15) NOT NULL,
-- Is the document general for this user. Only one of the user documents (for particular user) may be general.
    is_general BOOLEAN NOT NULL,
    PRIMARY KEY (user_id, doc_type_id)
);