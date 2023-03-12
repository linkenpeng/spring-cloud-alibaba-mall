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
