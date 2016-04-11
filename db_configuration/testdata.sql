-- -----------------------------------------------------
-- Test data for account
-- -----------------------------------------------------
--INSERT INTO public.account (id, email, password) VALUES (1, 'test@test.com', 'passwd');

-- -----------------------------------------------------
-- Test data for role
-- -----------------------------------------------------
INSERT INTO public.role (id, name) VALUES (1, 'Administrator');
INSERT INTO public.role (id, name) VALUES (2, 'Operator');
INSERT INTO public.role (id, name) VALUES (3, 'User');

INSERT INTO account_role VALUES (1, 1);
INSERT INTO account_role VALUES (1, 3);

-- -----------------------------------------------------
-- Test data for permission
-- -----------------------------------------------------
-- TODO

-- -----------------------------------------------------
-- Other test data
-- -----------------------------------------------------
insert into attribute_group(id, name, description) values (1, 'Личная информация', 'Описание для Личная информация');
insert into field_type(id, type_name) values (1, 'Текстовое поле');
insert into attribute_type(id, name, field_type_id, regex, required, hidden, description) values (1, 'Свободное поле', 1, '*', 0, 0, 'Без ограничений на ввод');

insert into tag(id, name, description) values (1, 'GroupA', 'Description for GroupA');

insert into person(id, first_name, last_name, description) values (1, 'F1', 'L1', 'F1 L1 description');
insert into person_account(person_id, user_id) values (1, 1);
insert into person_tag(person_id, tag_id) values (1, 1);

insert into note(id, date, value) values (1, '1971-07-13', 'User 1');
insert into person_note(person_id, note_id) values (1, 1);

insert into attribute(id, name, type_id, group_id, description) values (1, 'Email', 1, 1, 'Электронная почта');
insert into attribute(id, name, type_id, group_id, description) values (2, 'Телефон', 1, 1, 'Личный телефон');

insert into attribute_value(id, person_id, attribute_id, text_value, blob_value) values (1, 1, 2, '+7(000)000-00-00', null);
insert into attribute_value(id, person_id, attribute_id, text_value, blob_value) values (2, 1, 1, 'aaaa@mail.ru', null);
