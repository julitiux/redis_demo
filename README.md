# redis_demo

## Start docker using docker-compose.yml
```terminal
docker compose up -d
```

## Start docker
```termina
docker compose start
```

## Stop docker 
```termina
docker compose stop
```

## Stop and delete containers
```temrinal 
docker compose down
```

## Redis prompt 
```terminal
docker exec -it redis-demo-redis redis-cli
```

### set redis
```terminal 
SET name Julio
```

### get redis
```terminal 
GET name
```

### set 30 seconds 
```terminal
SET greeting "Hola Redis" EX 30
```

### verify the time into a variable 
```terminal 
TTL greeting
```

### you can save like this 
```temrinal 
set product:1 → ...
set product:2 → ...
set product:3 → ...
```