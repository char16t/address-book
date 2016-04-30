# addressbook-initdata-generator

Конвертер данных из YAML в SQL данных для нашей базы данных.

Установка:

```
pip3 install -r requirements.txt
python3 setup.py develop
```

Использование

```
# Example initdatagen initdata.yml initdata.sql
initdatagen [имя_yml_файла_с_данными] [имя_sql_файла_с_результатом]
```

Пример `initdata.yml`:

```
roles:
  - name: Admin
    id: 1
  - name: Operator
    id: 2
  - name: User
    id: 3

accounts:
  - email: aaa@mail.ru
    pass: hash
    roles: [1]
  - email: bbb@mail.ru
    pass: hash
    roles: [2]
  - email: ccc@mail.ru
    pass: hash
    roles: [3]
  - email: ddd@mail.ru
    pass: hash
    roles: [1,3]

```

Результат `initdata.sql`:
```
public.role (id, name) VALUES (1, 'Admin');
public.role (id, name) VALUES (2, 'Operator');
public.role (id, name) VALUES (3, 'User');
insert into account(id, person_id, email, password) values(1, NULL, 'aaa@mail.ru', 'hash');
insert into account_role(user_id, role_id) values (1,1);
insert into account(id, person_id, email, password) values(2, NULL, 'bbb@mail.ru', 'hash');
insert into account_role(user_id, role_id) values (2,2);
insert into account(id, person_id, email, password) values(3, NULL, 'ccc@mail.ru', 'hash');
insert into account_role(user_id, role_id) values (3,3);
insert into account(id, person_id, email, password) values(4, NULL, 'ddd@mail.ru', 'hash');
insert into account_role(user_id, role_id) values (4,1);
insert into account_role(user_id, role_id) values (4,3);
```
