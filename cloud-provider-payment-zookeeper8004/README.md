
## Getting up and Running...

````bash
docker-compose up
````


## Zookeeper configuration is located in /conf. One way to change it is mounting your config file as a volume:

````bash
docker run --name some-zookeeper --restart always -d -v $(pwd)/zoo.cfg:/conf/zoo.cfg zookeeper
````

## Environment variables

````bash
$ docker run -e "ZOO_INIT_LIMIT=10" --name some-zookeeper --restart always -d zookeeper
````

See: https://hub.docker.com/_/zookeeper