import os
import sys
import traceback
import yaml

def main():
    if len(sys.argv) != 3:
        print("Usage example: " + sys.argv[0] + " initdata.yml initdata.sql")
        exit(1)

    yaml_file = sys.argv[1]
    sql_file = sys.argv[2]

    if not os.path.exists(yaml_file):
        print("Can't open file", yaml_file,"for reading")
        exit(2)

    yaml_fp = open(yaml_file, 'r')
    sql_fp = open(sql_file, 'w')

    yaml_source = yaml_fp.read()
    sql_source = ""
    yaml_data = yaml.load(yaml_source)

    print(yaml_data)
    for role in yaml_data['roles']:
        sql_source += "public.role (id, name) VALUES ({0}, '{1}');\n".format(role['id'], role['name'])

    item_id = 1
    for account in yaml_data['accounts']:
        sql_source += "insert into account(id, person_id, email, password) values({0}, {1}, '{2}', '{3}');\n".format(item_id, 'NULL', account['email'], account['pass'])
        for role_id in account['roles']:
            sql_source += "insert into account_role(user_id, role_id) values ({0},{1});\n".format(str(item_id), str(role_id))
        item_id += 1

    sql_fp.write(sql_source)

    yaml_fp.close()
    sql_fp.close()

if __name__ == "__main__":
    main()
