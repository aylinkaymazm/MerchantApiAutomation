Feature: Api Grocery Crud Operation


  Scenario: Get information according to
    Given connect to the server for "data/"
    When "name" field is "apple"
    Then "price" should be "3"
    And "stock" should be "100"


  Scenario: GET - success operation
    Given connect to the server for "data/"
    When status code is "200"
    Then operation is "success"


  Scenario: GET - negative case
    Given connect to the server for "data/"
    When "name" field is "apple"
    Then "price" should not be "2"
    When "name" field is "grapes"
    Then "stock" should not be "55"

  Scenario: GET - endpoint that returns according to name apple
    Given connect to the server for "data?name=apple"
    When "name" field is "apple"
    Then "price" should be "3"
    And "stock" should be "100"
    And "id" should be "1"

  Scenario: POST - the data to the endpoint
    Given post data to the endpoint "http://localhost:3000/data"
    When create data with name as "watermelon", price as "2", stock as "20"
    Then connect to the server for "data?name=watermelon"
    When "name" field is "watermelon"
    Then "price" should be "2"
    And "stock" should not be "100"
    And "id" should be "3"

  Scenario: Bad Request
#    Given connect to the server for "data/"
#    When status code is "400"
#    Then operation is "Bad Request"#


  Scenario: Not Found Request
#    Given connect to the server for "data/"
#    When status code is "404"
#    Then operation is "Not Found"