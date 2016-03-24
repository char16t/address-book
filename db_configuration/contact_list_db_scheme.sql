-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS "user";

CREATE TABLE IF NOT EXISTS "user" (
  id INT NOT NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `mydb`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS "role";

CREATE TABLE IF NOT EXISTS role (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `mydb`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS permission ;

CREATE TABLE IF NOT EXISTS permission (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `mydb`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_role ;

CREATE TABLE IF NOT EXISTS user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id)
 ,
  CONSTRAINT fk_user_has_role_user1
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_user_has_role_role1
    FOREIGN KEY (role_id)
    REFERENCES role (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_user_has_role_role1_idx ON user_role (role_id ASC);
CREATE INDEX fk_user_has_role_user1_idx ON user_role (user_id ASC);


-- -----------------------------------------------------
-- Table `mydb`.`role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS role_permission ;

CREATE TABLE IF NOT EXISTS role_permission (
  role_id INT NOT NULL,
  permission_id INT NOT NULL,
  PRIMARY KEY (role_id, permission_id)
 ,
  CONSTRAINT fk_role_has_permission_role1
    FOREIGN KEY (role_id)
    REFERENCES role (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_role_has_permission_permission1
    FOREIGN KEY (permission_id)
    REFERENCES permission (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_role_has_permission_permission1_idx ON role_permission (permission_id ASC);
CREATE INDEX fk_role_has_permission_role1_idx ON role_permission (role_id ASC);


-- -----------------------------------------------------
-- Table `mydb`.`person_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS person_user ;

CREATE TABLE IF NOT EXISTS person_user (
  person_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (person_id, user_id)
 ,
  CONSTRAINT fk_person_has_user_person1
    FOREIGN KEY (person_id)
    REFERENCES person (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_person_has_user_user1
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX fk_person_has_user_user1_idx ON person_user (user_id ASC);
CREATE INDEX fk_person_has_user_person1_idx ON person_user (person_id ASC);

-- -----------------------------------------------------
-- Table `addressbook`.`test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS test ;

CREATE TABLE IF NOT EXISTS test (
  id INT NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;

-- -----------------------------------------------------
-- Table `addressbook`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS person ;

CREATE TABLE IF NOT EXISTS person (
  id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `addressbook`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS tag ;

CREATE TABLE IF NOT EXISTS tag (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `addressbook`.`person_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS person_tag ;

CREATE TABLE IF NOT EXISTS person_tag (
  person_id INT NOT NULL,
  tag_id INT NOT NULL
 ,
  CONSTRAINT FK_person_tag_person_id
    FOREIGN KEY (person_id)
    REFERENCES person (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_person_tag_tag_id
    FOREIGN KEY (tag_id)
    REFERENCES tag (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX FK_person_tag_person_id_idx ON person_tag (person_id ASC);
CREATE INDEX FK_person_tag_tag_id_idx ON person_tag (tag_id ASC);


-- -----------------------------------------------------
-- Table `addressbook`.`field_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS field_type ;

CREATE TABLE IF NOT EXISTS field_type (
  id INT NOT NULL,
  type_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT type_name_UNIQUE UNIQUE  (type_name))
;


-- -----------------------------------------------------
-- Table `addressbook`.`attribute_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS attribute_type ;

CREATE TABLE IF NOT EXISTS attribute_type (
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
    REFERENCES field_type (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX FK_Attribute_type_field_type_id_idx ON attribute_type (field_type_id);


-- -----------------------------------------------------
-- Table `addressbook`.`attribute_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS attribute_group ;

CREATE TABLE IF NOT EXISTS attribute_group (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (id),
  CONSTRAINT name_UNIQUE UNIQUE  (name))
;


-- -----------------------------------------------------
-- Table `addressbook`.`attribute`
-- -----------------------------------------------------
DROP TABLE IF EXISTS attribute ;

CREATE TABLE IF NOT EXISTS attribute (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  type_id INT NOT NULL,
  group_id INT NOT NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT FK_attribute_type_id
    FOREIGN KEY (type_id)
    REFERENCES attribute_type (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_attribute_group_id
    FOREIGN KEY (group_id)
    REFERENCES attribute_group (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX FK_attribute_type_id_idx ON attribute (type_id ASC);
CREATE INDEX FK_attribute_group_id_idx ON attribute (group_id ASC);


-- -----------------------------------------------------
-- Table `addressbook`.`attribute_value`
-- -----------------------------------------------------
DROP TABLE IF EXISTS attribute_value ;

CREATE TABLE IF NOT EXISTS attribute_value (
  id INT NOT NULL,
  person_id INT NOT NULL,
  attribute_id INT NOT NULL,
  text_value VARCHAR(1024) NULL,
  blob_value BYTEA NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT FK_attribute_value_person_id
    FOREIGN KEY (person_id)
    REFERENCES person (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_attribute_value_attribute_id
    FOREIGN KEY (attribute_id)
    REFERENCES attribute (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX FK_attribute_value_person_id_idx ON attribute_value (person_id ASC);
CREATE INDEX FK_attribute_value_attribute_id_idx ON attribute_value (attribute_id ASC);


-- -----------------------------------------------------
-- Table `addressbook`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS note ;

CREATE TABLE IF NOT EXISTS note (
  id INT NOT NULL,
  date DATE NOT NULL,
  value VARCHAR(1024) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `addressbook`.`person_note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS person_note ;

CREATE TABLE IF NOT EXISTS person_note (
  person_id INT NOT NULL,
  note_id INT NOT NULL
 ,
  CONSTRAINT FK_person_note_person_id
    FOREIGN KEY (person_id)
    REFERENCES person (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_person_note_note_id
    FOREIGN KEY (note_id)
    REFERENCES note (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX FK_person_note_person_id_idx ON person_note (person_id ASC);
CREATE INDEX FK_person_note_note_id_idx ON person_note (note_id ASC);
