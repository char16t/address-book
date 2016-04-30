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
