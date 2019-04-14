/*Here, I create the scheme "tfp" for the first project tables.*/
CREATE SCHEMA tfp AUTHORIZATION SA ;

/*This table contains basic characteristics of organization.*/
CREATE TABLE IF NOT EXISTS tfp.organization (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    full_name VARCHAR(60) NOT NULL,
    inn VARCHAR(12) NOT NULL,
    kpp VARCHAR(9) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    is_active BOOLEAN NOT NULL
);

CREATE INDEX ix_organization_id ON tfp.organization (id);

/*This table contains basic characteristics of office in organization. The table has m2o relationship with the organization table.*/
CREATE TABLE IF NOT EXISTS tfp.office (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    org_id INTEGER,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    office_phone VARCHAR(15) NOT NULL,
    is_active BOOLEAN NOT NULL,
    FOREIGN KEY (org_id) REFERENCES tfp.organization(id)
);

CREATE INDEX ix_office_id ON tfp.office (id);
CREATE INDEX ix_office_org_id ON tfp.office (org_id);

/*The country table, contains id, country code, country name. Relationship with the user table is o2m*/
CREATE TABLE IF NOT EXISTS tfp.country (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(3) NOT NULL,
    name VARCHAR(60) NOT NULL
);

CREATE INDEX ix_country_id ON tfp.country (id);

/*This table contains basic characteristic of user working in office. The Table has m2o relationship with the office table, has m2o relationship with the country table and has m2m relationship with doc_type table by the user_doc junction table.*/
CREATE TABLE IF NOT EXISTS tfp.user (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    country_id INTEGER,
    office_id INTEGER,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    position VARCHAR(20) NOT NULL,
    user_phone VARCHAR(15) NOT NULL,
    is_identified BOOLEAN NOT NULL,
    FOREIGN KEY (country_id) REFERENCES tfp.country(id),
    FOREIGN KEY (office_id) REFERENCES tfp.office(id)
);

CREATE INDEX ix_user_Id ON tfp.user (id);
CREATE INDEX ix_user_country_id ON tfp.user (country_id);
CREATE INDEX ix_user_office_id ON tfp.user (office_id);

/*The document type table, contains id, document code, document name. Relationship with the user table is m2m by using the user_doc table*/
CREATE TABLE IF NOT EXISTS tfp.doc_type(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(2) NOT NULL,
    name VARCHAR(60) NOT NULL
);

CREATE INDEX ix_doc_type_id ON tfp.doc_type (id);

/*The user_doc table, contains the user table PK, the doc_type table PK, document date, is_general field (Is this doc general then 1 else 0). This is the junction table for m2m relationship the user and the doc_type tables.*/
CREATE TABLE IF NOT EXISTS tfp.user_doc (
    user_id INTEGER NOT NULL REFERENCES tfp.user(id),
    doc_id INTEGER NOT NULL REFERENCES tfp.doc_type(id),
    doc_date VARCHAR(15) NOT NULL,
    is_general BOOLEAN NOT NULL,
    PRIMARY KEY (user_id, doc_id)
);