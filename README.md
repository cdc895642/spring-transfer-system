# transfer-system

To build application :
`mvn clean compile assembly:single`

To run application :
`java -jar target/money-tranasfer-1.0-SNAPSHOT-jar-with-dependencies.jar`

After start application will be available at url :
`http://localhost:4567/`

Service work only with JSON format :
`Content-Type:	application/json`

## Operations with currencies
### Create currency
`POST /currencies`

Example of the request body :
```json
{
    "code": "RUB"
}
```
Example of the response :
```json
{
    "id": 3,
    "code": "RUB"
}
```
### Get all currencies
`GET /currencies`

Example of the response :
```json
[
  {
    "id": 1,
    "code": "USD"
  },
  {
    "id": 2,
    "code": "EUR"
  },
  {
    "id": 3,
    "code": "RUB"
  }
]
```

## Operations with clients
### Create new client
`POST /clients`

Example of the request body :
```json
{
  "name":"user",
  "email":"user@email.com"
}
```
Example of the response :
```json
{
   "id": 1,
  "name": "user",
  "email": "user@email.com"
}
```
### Get all clients
`GET /clients`

Example of the response :
```json
[
  {
    "id": 1,
    "name": "user",
    "email": "user@email.com"
  },
  {
    "id": 2,
    "name": "user1",
    "email": "user1@email.com"
  }
]
```

## Operations with accounts
### Get account by it id
`GET /accounts/:id`

**URL Parameter** : `id=[integer]` where `id` is the ID of the Account.

Example of the response :
```json
{
  "id": 1,
  "client":{
    "id": 1,
    "name": "user",
    "email": "user@email.com"
  },
  "currency":{
    "id": 1,
    "code": "USD"
  },
  "balance": 150,
  "handler":{}
}
```

### Create new account
`POST /accounts`

Example of the request body :
```json
{
  "client":{
    "id":1
  },
  "currency":{
      "id":1
  },
  "balance":100.00
}
```
Example of the response :
```json
{
  "client":{
    "id":1
  },
  "currency":{
      "id":1
  },
  "balance":100.00
}
```

### Change balance in existing account
`PUT /accounts/:id`

**URL Parameter** : `id=[integer]` where `id` is the ID of the Account.

Example of the request body :
```json
{
  "id":1,
  "balance":150.00
}
```

Example of the response :
```json
{
  "id": 1,
  "client":{
    "id": 1,
    "name": "user",
    "email": "user@email.com"
  },
  "currency":{
    "id": 1,
    "code": "USD"
  },
  "balance": 150,
  "handler":{}
}
```

## Operations with transfers
### Perform transfer
`POST /transfers`

Example of the request body :
```json
{
  "from":{
    "id":1
  },
  "to":{
    "id":2
  },
  "amount":50.00
}
```

Example of the response :
```json
{
  "from":{
    "id": 1,
    "client":{
      "id": 1,
      "name": "user",
      "email": "user@email.com"
    },
    "currency":{
      "id": 1,
      "code": "USD"
    },
    "balance": 100,
    "handler":{}
   },
  "to":{
    "id": 2,
    "client":{
      "id": 2,
      "name": "user1",
      "email": "user1@email.com"
    },
    "currency":{
      "id": 1,
      "code": "USD"
    },
    "balance": 150,
    "handler":{}
  },
  "amount": 50,
  "date":{
    "month": "JULY",
    "year": 2019,
    "dayOfMonth": 23,
    "dayOfWeek": "TUESDAY",
    "dayOfYear": 204,
    "monthValue": 7,
    "nano": 273000000,
    "second": 46,
    "hour": 16,
    "minute": 48,
    "chronology":{
      "id": "ISO",
      "calendarType": "iso8601"
    }
  },
  "finished": true
}
```