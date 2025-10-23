#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.

@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test for submitting the order
    Given Login with username <username> and password <password>
    When  I add product <productName> to cart
    And  Checkout <poductName> and submit the order
    Then  "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
    

    Examples: 
      |     username          |     password    |  productName      |
      | superduper1@gmail.com |   Selenium@18   |  ZARA COAT 3      |
     
     
