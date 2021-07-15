import org.springframework.cloud.contract.spec.Contract


Contract.make {
    request {
        method 'GET'
        url value('/v1/accounts?customerId=123456')
    }
    response {
        status 200
        headers {
            header('Content-Type' : value(applicationJson()))
        }
        body(
                """
         {
            "accounts": [
               {
                  "id": 1,
                  "nrb": "72249000059957936727967706",
                  "currency": "PLN",
                  "customerId": 123456,
                  "availableFunds": 65245455445455.3
               }
            ]
         }
         """
        )
    }
}
