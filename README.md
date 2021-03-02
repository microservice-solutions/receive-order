- Run the h2 database jar using java -jar <h2_db_jar_name>
	- JDBC URL: jdbc:h2:tcp://localhost/~/order

	
```
drop table ORDER_MODEL;
drop sequence ORDER_SEQUENCE;
create sequence ORDER_SEQUENCE;
create table ORDER_MODEL(ID int default ORDER_SEQUENCE.nextval primary key, PRODUCT_CODE varchar(255), QUANTITY int, TRANSACTION_ID varchar(255), USERNAME varchar(50));
```