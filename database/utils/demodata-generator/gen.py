import random
import names
import description

with open("result.sql", "a") as myfile:
    text = '''
insert into account(id, email, password) values(1, 'aaa@mail.ru', 'hash');
insert into account(id, email, password) values(2, 'bbb@mail.ru', 'hash');
insert into account(id, email, password) values(3, 'ccc@mail.ru', 'hash');
insert into account(id, email, password) values(4, 'ddd@mail.ru', 'hash');

insert into account_role(user_id, role_id) values (1, 1);
insert into account_role(user_id, role_id) values (2, 2);
insert into account_role(user_id, role_id) values (3, 3);
insert into account_role(user_id, role_id) values (4, 1);
insert into account_role(user_id, role_id) values (4, 3);

'''
    myfile.write(text)


for i in range(1, 1000):
    rgender = random.choice(['male', 'female'])
    data = (i, names.get_first_name(), names.get_last_name(), description.chomsky())
    with open("result.sql", "a") as myfile:
        text = '''insert into person(id, first_name, last_name, description) values({0},'{1}','{2}','{3}');\n'''.format(*data)
        myfile.write(text)

for i in range(1, 1000):
    if i < 250:
        with open("result.sql", "a") as myfile:
            text = '''insert into person_account(person_id, user_id) values('''+ str(i) + ''', 1);\n'''
            myfile.write(text)
    elif i < 500:
        with open("result.sql", "a") as myfile:
            text = '''insert into person_account(person_id, user_id) values('''+ str(i) + ''', 2);\n'''
            myfile.write(text)
    elif i < 750:
        with open("result.sql", "a") as myfile:
            text = '''insert into person_account(person_id, user_id) values('''+ str(i) + ''', 3);\n'''
            myfile.write(text)
    elif i < 1000:
        with open("result.sql", "a") as myfile:
            text = '''insert into person_account(person_id, user_id) values('''+ str(i) + ''', 4);\n'''
            myfile.write(text)

tags = ['Friends', 'Classmates', 'University Firends', 'Colleagues', 'Family', 'NetCracker', 'Customers', 'Best firends']
for i in range(1, len(tags)):
    tag_name = tags[i]
    data = (i, tag_name, description.chomsky())
    with open("result.sql", "a") as myfile:
        text = '''insert into tag(id, name, description) values({0},'{1}','{2}');\n'''.format(*data)
        myfile.write(text)

for i in range(1, 2000):
    with open("result.sql", "a") as myfile:
        text = '''insert into note(id, person_id, date, value) values({0}, {1}, '{2}', '{3}');\n'''.format(i, random.randrange(1, 1000), '2016-02-22', description.chomsky())
        myfile.write(text)

