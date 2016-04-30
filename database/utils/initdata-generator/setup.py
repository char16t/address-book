# coding=utf-8

import os

try:
    from setuptools import setup
except ImportError:
    from distutils.core import setup

def local_file(name):
    return os.path.relpath(os.path.join(os.path.dirname(__file__), name))

__version__ = None

with open(local_file("initdatagen/version.py")) as o:
    exec(o.read())

assert __version__ is not None

config = {
    'name': 'initdatagen',
    'author': 'Valeriy Manenkov',
    'author_email': 'v.manenkov@gmail.com',
    'version': __version__,
    'packages': ['initdatagen'],
    'entry_points': {
        'console_scripts': [
            'initdatagen=initdatagen.cli:main'
        ]
    },
}

setup(**config)
