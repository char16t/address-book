-- -----------------------------------------------------
-- Schema public
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS public CASCADE;

-- -----------------------------------------------------
-- Schema public
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS public;

-- -----------------------------------------------------
-- Table `public`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.person ;

CREATE TABLE IF NOT EXISTS public.person (
  id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;

-- -----------------------------------------------------
-- Table `public`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.tag ;

CREATE TABLE IF NOT EXISTS public.tag (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `public`.`person_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.person_tag ;

CREATE TABLE IF NOT EXISTS public.person_tag (
  person_id INT NOT NULL,
  tag_id INT NOT NULL
 ,
  CONSTRAINT FK_person_tag_person_id
    FOREIGN KEY (person_id)
    REFERENCES public.person (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_person_tag_tag_id
    FOREIGN KEY (tag_id)
    REFERENCES public.tag (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX FK_person_tag_person_id_idx ON public.person_tag (person_id);
CREATE INDEX FK_person_tag_tag_id_idx ON public.person_tag (tag_id);

-- -----------------------------------------------------
-- Table `public`.`field_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.field_type ;

CREATE TABLE IF NOT EXISTS public.field_type (
  id INT NOT NULL,
  type_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT type_name_UNIQUE UNIQUE  (type_name))
;


-- -----------------------------------------------------
-- Table `public`.`attribute_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.attribute_type ;

CREATE TABLE IF NOT EXISTS public.attribute_type (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  field_type_id INT NULL,
  regex VARCHAR(1024) NULL,
  required SMALLINT NOT NULL DEFAULT 0,
  hidden SMALLINT NOT NULL DEFAULT 0,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id),
  CONSTRAINT type_UNIQUE UNIQUE  (name)
 ,
  CONSTRAINT FK_Attribute_type_field_type_id
    FOREIGN KEY (field_type_id)
    REFERENCES public.field_type (id)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
;

CREATE INDEX FK_Attribute_type_field_type_id_idx ON public.attribute_type (field_type_id);


-- -----------------------------------------------------
-- Table `public`.`attribute_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.attribute_group ;

CREATE TABLE IF NOT EXISTS public.attribute_group (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id),
  CONSTRAINT name_UNIQUE UNIQCASCADEE;


-- -----------------------------------------------------
-- Table `public`.`attribute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.attribute ;

CREATE TABLE IF NOT EXISTS public.attribute (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  type_id INT NOT NULL,
  group_id INT NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT FK_attribute_type_id
    FOREIGN KEY (type_id)
    REFERENCES public.attribute_type (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_attribute_group_id
    FOREIGN KEY (group_id)
    REFERENCES public.attribute_group (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX FK_attribute_type_id_idx ON public.attribute (type_id);
CREATE INDEX FK_attribute_group_id_idx ON public.attribute (group_id);


-- -----------------------------------------------------
-- Table `public`.`attribute_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.attribute_value ;

CREATE TABLE IF NOT EXISTS public.attribute_value (
  id INT NOT NULL,
  person_id INT NOT NULL,
  attribute_id INT NOT NULL,
  text_value VARCHAR(1024) NULL,
  blob_value BYTEA NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT FK_attribute_value_person_id
    FOREIGN KEY (person_id)
    REFERENCES public.person (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_attribute_value_attribute_id
    FOREIGN KEY (attribute_id)
    REFERENCES public.attribute (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX FK_attribute_value_person_id_idx ON public.attribute_value (person_id);
CREATE INDEX FK_attribute_value_attribute_id_idx ON public.attribute_value (attribute_id);


-- -----------------------------------------------------
-- Table `public`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.note ;

CREATE TABLE IF NOT EXISTS public.note (
  id INT NOT NULL,
  person_id INT NOT NULL,
  date DATE NOT NULL,
  value VARCHAR(1024) NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_note_person_id
    FOREIGN KEY (person_id)
    REFERENCES public.person (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `public`.`test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.test ;

CREATE TABLE IF NOT EXISTS public.test (
  id INT NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `public`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.account ;

CREATE TABLE IF NOT EXISTS public.account (
  id INT NOT NULL,
  person_id INT NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk
    FOREIGN KEY (person_id)
    REFERENCES public.person(id)
    ON DELETE SET NULL
    ON UPDATE SET NULL
);


-- -----------------------------------------------------
-- Table `public`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.role ;

CREATE TABLE IF NOT EXISTS public.role (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `public`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.permission ;

CREATE TABLE IF NOT EXISTS public.permission (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `public`.`account_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.account_role ;

CREATE TABLE IF NOT EXISTS public.account_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id)
 ,
  CONSTRAINT fk_user_has_role_user1
    FOREIGN KEY (user_id)
    REFERENCES public.account (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_user_has_role_role1
    FOREIGN KEY (role_id)
    REFERENCES public.role (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_user_has_role_role1_idx ON public.account_role (role_id);
CREATE INDEX fk_user_has_role_user1_idx ON public.account_role (user_id);


-- -----------------------------------------------------
-- Table `public`.`role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.role_permission ;

CREATE TABLE IF NOT EXISTS public.role_permission (
  role_id INT NOT NULL,
  permission_id INT NOT NULL,
  PRIMARY KEY (role_id, permission_id)
 ,
  CONSTRAINT fk_role_has_permission_role1
    FOREIGN KEY (role_id)
    REFERENCES public.role (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_role_has_permission_permission1
    FOREIGN KEY (permission_id)
    REFERENCES public.permission (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_role_has_permission_permission1_idx ON public.role_permission (permission_id);
CREATE INDEX fk_role_has_permission_role1_idx ON public.role_permission (role_id);


-- -----------------------------------------------------
-- Table `public`.`person_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS public.person_account ;

CREATE TABLE IF NOT EXISTS public.person_account (
  person_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (person_id, user_id)
 ,
  CONSTRAINT fk_person_has_user_person1
    FOREIGN KEY (person_id)
    REFERENCES public.person (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_person_has_user_user1
    FOREIGN KEY (user_id)
    REFERENCES public.account (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE INDEX fk_person_has_user_user1_idx ON public.person_account (user_id);
CREATE INDEX fk_person_has_user_person1_idx ON public.person_account (person_id);


-- DROP SEQUENCE hibernate_sequence;
CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1000;
ALTER TABLE hibernate_sequence
  OWNER TO postgres;
