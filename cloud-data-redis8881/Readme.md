~~~
sudo docker run -p 6379:6379 --name redis \
-v <PROJECT-PATH>/redis/redis.conf:/usr/local/etc/redis/redis.conf \
-v <PROJECT-PATH>/redis_data:/data \
-d redis redis-server /usr/local/etc/redis/redis.conf

sudo docker run -p 6379:6379 --name redis \
-v ~/projects/tutorials/cloud2020/cloud-data-redis8881/redis/redis.conf:/usr/local/etc/redis/redis.conf \
-v ~/projects/tutorials/cloud2020/cloud-data-redis8881/redis_data:/data \
-d redis redis-server /usr/local/etc/redis/redis.conf


sudo docker exec -it redis redis-cli

~~~

