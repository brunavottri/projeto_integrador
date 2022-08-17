# Requisito_6
Feature de Autenticação e Autorização do Comprador.

- <a href="https://docs.google.com/document/d/1v_AUOkqUosuMutUrbal8I87ad0DTBTdT/edit?usp=sharing&ouid=108579776839460528384&rtpof=true&sd=true">PDF Requisito 6

## Buyer <br name="inboundOrder">

`POST /api/v1/buyer/create`<br>
Cria um novo Comprador.
<pre><code><b>Payload Example:</b>
{
    "username": "fulano",
    "password": 123456
}
 
 <b>Response:</b>
  {
    "id": 1,
    "username": "fulano",
    "password": "$2a$10$dHvX6ptnEmNZ3iKPggYTuOT20Op5RpEx4N/AYDNiS01Pd5/VFebtu"
}
 
 </code></pre>
 
`PUT /api/v1/buyer/update?id=1`<br>
Atualiza o nome de usuário e senha.
<pre><code><b>Payload Example:</b>
{
    "username": "fulanosilva",
    "password": 1234567
}
 
 <b>Response:</b>
  {
    "id": 1,
    "username": "fulanosilva",
    "password": "$2a$10$1gu4uvLQA/6QFew59/BzreIo/La0oW1hn7QlF/pgUbd5dPFUvOwxe"
}
 
 </code></pre>

 
`DELETE /api/v1/buyer/delete?id=1`<br>
Deleta um Comprador.

 
`GET /api/v1/buyer/getall`<br>
Retorna todos os Compradores.
<pre><code><b>Response Example:</b>
[
    {
        "buyerId": 2,
        "username": "fulano",
        "purchaseOrders": [
         {
          "purchaseOrderId": 2,
          "totalPrice": 131.88
          }
        ],
        "password": "$2a$10$vyueexBBUJuGIV4cUYAlruLXAV6bQOsg6tZA1MEwnyFxHNxptjMKa"
    },
    {
        "buyerId": 3,
        "username": "fulanoa",
        "purchaseOrders": [],
        "password": "$2a$10$PjNxAeHW2iaTp3lHVqJ7ROu0mGOICYHjKkdx8c7JZUg4Oh6Sj26cS"
    },
    {
        "buyerId": 4,
        "username": "fulanob",
        "purchaseOrders": [],
        "password": "$2a$10$aupY.lghxb3t9HceSIVL1Ohf/KRsJE40a7au2TZAF5Sq0HW369lp2"
    }
]
</code></pre>
