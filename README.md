# spring-cloud-alibaba-mall
build a mall use spring cloud alibaba

# usage 
### step1 run MySQL
be sure you have installed the MySQL.
and then import the sql scheme.

### step2 run Redis
be sure you have run the redis.

### step3 run nacos
be sure you have installed the nacos.
and then run the nacos, open the browser, enter http://localhost:8848/nacos/ to see the nacos is running.

### step4 run item, user, order, dict, gateway
open the browser, enter http://localhost:2000/order/list to see if the application is normal.

### Application Port
App | web 
-:|-:
gateway | 2000 |
user | 2100 |
item | 2200 | 
order | 2300 | 
dict | 2400 | 

# run application
```shell
./mall start gateway|user|item|order|dict|all
./mall stop gateway|user|item|order|dict|all
```

# schedule
## Done
- integration spring cloud gateway
- add the customer filter, include auth, login, add JWT
- integration mybatis-plus
- integration redis
- add vue-admin-ui

## TODO
- integration rocket mq

### Components Version
component |            version 
-:|-------------------:
JDK |                 21 |
SpringBoot |              3.5.6 |
SpringCloud |           2025.0.0 |
SpringCloud-Alibaba | 2025.0.0.0-preview | 
Lombok |            1.18.42 |
Maven |             3.9.11 | 
MySQL |               8.0+ | 
Redis |               5.0+ | 