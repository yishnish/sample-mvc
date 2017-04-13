[![Build Status](https://travis-ci.org/yishnish/sample-mvc.svg?branch=master)](https://travis-ci.org/yishnish/sample-mvc)    [![Coverage Status](https://coveralls.io/repos/github/yishnish/mytelnet/badge.svg)](https://coveralls.io/github/yishnish/sample-mvc)

A very basic Spring MVC webapp with simple profile, ORM and REST controller setup.

* Requirements:
    * Maven
    * Java >= 8

* Notice:
    * Databases 
        * for tests an in-memory h2 database is used if 'test' profile is active
        * for development MySQL is used
        * You will need to either create an instance of mysql server or point the dev DataSource at an existing one
        * You will need to make a dev database on the mysql server (probably name it sample_mvc_dev)         

