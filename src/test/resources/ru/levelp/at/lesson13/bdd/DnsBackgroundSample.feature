Feature: Compare products
    In order to compare shop items characteristics
    As a user
    I want to add shop items to compare list

    Background:
        Given I open dns-shop Main page

    Scenario Outline: Add shop items to compare list
        Given I navigate to '<productSubcategory>' product sub-category of "<subCategory>" sub-category of "<category>" category from Menu
        When I add '<shopItems>' shop items to Compare list on the Products page
        And I click on the 'Сравнить' button in the page Header
        Then selected shop items should be displayed on the Compare page

        Examples:
            | productSubcategory | subCategory                 | category                | shopItems |
            | Смартфоны          | Смартфоны и гаджеты         | Смартфоны и фототехника | 1,2,3     |
            | Детские часы       | Смартфоны и гаджеты         | Смартфоны и фототехника | 1,5       |
            | Электронные книги  | Планшеты, электронные книги | Смартфоны и фототехника | 2,3,5     |


    Scenario: Add shop items to compare list
        Given I navigate to 'Смартфоны' product sub-category of "Смартфоны и гаджеты" sub-category of "Смартфоны и фототехника" category from Menu
        When I add '1,2,3' shop items to Compare list on the Products page
        And I click on the 'Сравнить' button in the page Header
        Then selected shop items should be displayed on the Compare page


        # Так писать не правильно, но можно
    Scenario: Add shop items to compare list with middle assertions
        Given I navigate to 'Смартфоны' product sub-category of "Смартфоны и гаджеты" sub-category of "Смартфоны и фототехника" category from Menu
        Then opened page name should be equal '.....'
        When I add '1,2,3' shop items to Compare list on the Products page
        Then .....
        And I click on the 'Сравнить' button in the page Header
        Then selected shop items should be displayed on the Compare page


    Scenario: bla-bla
        Given I open dns-shop Main page
        When selected shop items should be displayed on the Compare page
