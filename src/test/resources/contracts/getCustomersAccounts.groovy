import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url value('/v1/accounts?customerId=321')
    }
    response{
        status 200
        headers{
            header('Content-Type' : value(applicationJson()))
        }
        body(
                """
                {
                    "accounts":[
                        {
                         
                                "customerId": 321,
                                "nrb": "72249000059957936727967706",
                                "currency": "SEK",
                                availableFunds: 112323.56
                        }
                    ]
                }
                """
        )
    }
}