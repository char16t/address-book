import os
import sys
import traceback
import yaml

def main():
    if len(sys.argv) != 2:
        print("Usage example: " + sys.argv[0] + " initdata.yml")
        exit(1)

    yaml_file = sys.argv[1]

    if not os.path.exists(yaml_file):
        print("Can't open file", yaml_file,"for reading")
        exit(2)

    yaml_fp = open(yaml_file, 'r')

    yaml_source = yaml_fp.read()
    sql_source = ""
    yaml_data = yaml.load(yaml_source)

    #print(yaml_data)
    for role in yaml_data['roles']:
        sql_source += "insert into public.role (id, name) VALUES ({0}, '{1}');\n".format(role['id'], role['name'])

    item_id = 1
    for account in yaml_data['accounts']:
        sql_source += "insert into account(id, person_id, email, password) values({0}, {1}, '{2}', '{3}');\n".format(item_id, 'NULL', account['email'], account['pass'])
        for role_id in account['roles']:
            sql_source += "insert into account_role(user_id, role_id) values ({0},{1});\n".format(str(item_id), str(role_id))
        item_id += 1

    item_id = 1
    for tag in yaml_data['public_tags']:
        sql_source += "insert into tag(id, name, public_tag, description) values ({0}, '{1}', TRUE, NULL);\n".format(item_id, tag)
        item_id += 1

    item_id = 1
    ftype_ids = {}
    for ftype in yaml_data['field_types']:
        sql_source += "insert into field_type (id, type_name) values ({0}, '{1}');\n".format(item_id, ftype)
        ftype_ids[ftype] = item_id
        item_id += 1

    item_id = 1
    atype_ids = {}
    for atype in yaml_data['attribute_types']:
        sql_source += "insert into attribute_type (id, name, field_type_id, regex, required, hidden, description) values ({0}, '{1}', {2}, '{3}', {4}, {5}, '{6}');\n".format(item_id, atype['name'], ftype_ids[atype['type']], atype['regex'], atype['required'], atype['hidden'], atype['description'])
        atype_ids[atype['name']] = item_id
        item_id += 1

    item_id = 1
    attribute_ids = {}
    for group in yaml_data['attribute_groups']:
        sql_source += "insert into attribute_group(id, name, description) values ({0}, '{1}', '{2}');\n".format(item_id, group['name'], group['description'])
        a_id = 1
        for attribute in group['attributes']:
            sql_source += "insert into attribute (id, name, type_id, group_id, description) values ({0}, '{1}', {2}, {3}, '{4}');\n".format(a_id, attribute['name'], atype_ids[attribute['type']], item_id, attribute['description'])
            attribute_ids[attribute['name']] = a_id
            a_id += 1
        item_id += 1

    item_id = 1
    for p in yaml_data['persons']:
        sql_source += "insert into person (id, first_name, last_name, description) values ({0}, '{1}', '{2}', '{3}');\n".format(item_id, p['first_name'], p['last_name'], p['description'])
        sql_source += "insert into person_account (person_id, user_id) values ({0}, {1});\n".format(item_id, p['account'])

        for tag in p['tags']:
            sql_source += "insert into person_tag(person_id, tag_id) values ({0}, {1});\n".format(item_id, tag)

        note_id = 1
        for note in p['notes']:
            sql_source += "insert into note (id, person_id, date, value) values ({0}, {1}, '{2}', '{3}');\n".format(note_id, item_id, note['date'], note['value'])
            note_id += 1

        info_id = 1
        for i in p['info']:
            sql_source += "insert into attribute_value (id, person_id, attribute_id, text_value, blob_value) values ({0}, {1}, {2}, '{3}', NULL);\n".format(info_id, item_id, attribute_ids[i['field']], i['value'])
            info_id += 1

        item_id += 1

    yaml_fp.close()
    print(sql_source)

if __name__ == "__main__":
    main()
