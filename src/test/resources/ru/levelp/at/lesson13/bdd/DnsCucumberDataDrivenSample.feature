Feature: Compare products
    In order to compare shop items characteristics
    As a user
    I want to add shop items to compare list

    Scenario Outline: Add shop items to compare list
        Given I open dns-shop Main page
        And I navigate to '<productSubcategory>' product sub-category of "<subCategory>" sub-category of "<category>" category from Menu
        When I add '<shopItems>' shop items to Compare list on the Products page
        And I click on the 'Сравнить' button in the page Header
        Then selected shop items should be displayed on the Compare page

        Examples:
            | productSubcategory | subCategory                 | category                | shopItems |
            | Смартфоны          | Смартфоны и гаджеты         | Смартфоны и фототехника | 1,2,3     |
            | Детские часы       | Смартфоны и гаджеты         | Смартфоны и фототехника | 1,5       |
            | Электронные книги  | Планшеты, электронные книги | Смартфоны и фототехника | 2,3,5     |


