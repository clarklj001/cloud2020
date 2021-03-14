## Set project path in 

~~~
PROJECT_PATH=~/projects/tutorials/cloud2020/cloud-data-redis8881
~~~


## Create and run a redis container

~~~
sudo docker run -p 6379:6379 --name redis \
-v $PROJECT_PATH/redis/conf/redis.conf:/usr/local/etc/redis/redis.conf \
-v $PROJECT_PATH/redis/data:/data \
-d redis redis-server /usr/local/etc/redis/redis.conf
~~~

## Run redis client console

~~~
sudo docker exec -it redis redis-cli
~~~

## Create and run a mysql container

~~~
sudo docker run -p 3306:3306 --name mysql \
-v $PROJECT_PATH/mysql/log:/var/log/mysql \
-v $PROJECT_PATH/mysql/data:/var/lib/mysql \
-v $PROJECT_PATH/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
~~~