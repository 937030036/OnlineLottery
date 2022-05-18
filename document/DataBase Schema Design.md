# DataBase Schema Design

## UserMgr

|             |   id   | phone  |  name  | balance |
|:-----------:|:------:|:-------|:------:|:-------:|
| primary key |   Y    ||||||
| foreign key |||||||
|    type     | String | String | String | number  |

## #{UserMgrname}_user

|             |   id   | phone  |  name  | 
|:-----------:|:------:|:-------|:------:|
| primary key |   Y    ||||||
| foreign key |||||||
|    type     | String | String | String |

* 此表不需手动创建，应在DAO层定义其创建

## #{UserMgrname}_award

|             | grade  | name   |  pic   | 
|:-----------:|:------:|:-------|:------:|
| primary key |        ||||||
| foreign key |||||||
|    type     | String | String | String |

* 此表不需手动创建，应在DAO层定义其创建


## #{UserMgrname}_history


|             |         userid          | grade  |
|:-----------:|:-----------------------:|:-------|
| primary key |                         ||||||
| foreign key | #{UserMgrname}_user(id) ||||||
|    type     |         String          | String |

* 此表不需手动创建，应在DAO层定义其创建