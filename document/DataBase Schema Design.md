# DataBase Schema Design

## UserMgr

|             | id  | phone       | password    | balance |
|:-----------:|:---:|:------------|-------------|:-------:|
| primary key |  Y  ||||||
| foreign key |||||||
|    type     | int | varchar(13) | varchar(20) |   int   |

## #{UserMgrid}_user

|             | id  | phone       |    name     | 
|:-----------:|:---:|:------------|:-----------:|
| primary key |  Y  ||||||
| foreign key |||||||
|    type     | int | varchar(13) | varchar(10) |

* 此表不需手动创建，应在DAO层定义其创建

## #{UserMgrid}_award

|             |    grade    | name        |     pic     | 
|:-----------:|:-----------:|:------------|:-----------:|
| primary key |             ||||||
| foreign key |||||||
|    type     | varchar(10) | varchar(10) | varchar(10) |

* 此表不需手动创建，应在DAO层定义其创建


## #{UserMgrid}_history


|             |         userid          | grade       |
|:-----------:|:-----------------------:|:------------|
| primary key |                         ||||||
| foreign key | #{UserMgrname}_user(id) ||||||
|    type     |           int           | varchar(10) |

* 此表不需手动创建，应在DAO层定义其创建