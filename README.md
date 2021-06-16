[![Java CI with Maven](https://github.com/GirijaSankar61/DistributedTransaction/actions/workflows/maven.yml/badge.svg)](https://github.com/GirijaSankar61/DistributedTransaction/actions/workflows/maven.yml)
<br/>
Problem Statement:
How to have distributed trasaction across multiple database

Solution:
Here 2 db taken into consideration
1.Mongo db
2.Mysql db

With the help of PlatformTransactionManager we have combined both JPATransactionManager and MongoTransactionManager.
If any of the tx manager reports issue then whole commit will roll back.


