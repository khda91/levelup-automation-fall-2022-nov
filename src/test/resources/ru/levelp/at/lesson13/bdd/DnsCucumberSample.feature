Feature: Compare products
    In order to compare shop items characteristics
    As a user
    I want to add shop items to compare list

    Scenario: Add shop items to compare list
        Given I open dns-shop Main page
        And I navigate to 'Смартфоны' product sub-category of "Смартфоны и гаджеты" sub-category of "Смартфоны и фототехника" category from Menu
        When I add '1,2,3' shop items to Compare list on the Products page
        And I click on the 'Сравнить' button in the page Header
        Then selected shop items should be displayed on the Compare page

