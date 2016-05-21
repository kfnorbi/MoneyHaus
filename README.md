# Moneyhaus
##### This repository contains a Java enterprise application for managing currencies.
The development and testing were both on [Glassfish 4.0](https://glassfish.java.net/download-archive.html), using MySQL database.

#### Install guide:

1. `mvn clean install` on the main project
2. The folder `moneyhaus-ear/target` will contain the Enterprise Archive file

#### Configuriguring the application server:
1. Copy the chosen jdbc driver to the domain's lib folder
1. Add a connection pool to your database
1. In your database management run the [Quartz databse scripts](sql_scripts/tables_mysql.sql)
1. Add a datasource named `MoneyHausDS`

## Licenses & Copyright
+ The application can be distributed under the license of [MIT license](https://opensource.org/licenses/MIT)
+ The CSS template is from [Free Css](http://www.free-css.com)
    + About the licenses you can read more [here](http://www.free-css.com/copyright#terms-of-use)
+ The login form is create by [Andy Tran](http://andytran.me/)
