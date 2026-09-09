# redis_demo

## Start docker 
```terminal
docker compose up -d
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