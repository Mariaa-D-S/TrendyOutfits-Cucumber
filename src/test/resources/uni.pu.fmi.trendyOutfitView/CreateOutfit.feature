Feature: Създаване на съдържание

  Background: отваряне на приложението
    Given отваряне на приложението
    Given потребителя е логнат

  Scenario: Създаване на ново съдържание
    When потребителя въвежда име "Summer Dress", описание "A beautiful summer dress", снимка "summer_dress.jpg"
    And натиска бутона за създаване
    Then успешно създаване на съдържание

  Scenario: Създаване на съдържание без име
    When потребителя въвежда име "", описание "A beautiful summer dress", снимка "summer_dress.jpg"
    And натиска бутона за създаване
    Then вижда съобщение "Името е задължително"

  Scenario: Създаване на съдържание без описание
    When потребителя въвежда име "Summer Dress", описание "", снимка "summer_dress.jpg"
    And натиска бутона за създаване
    Then вижда съобщение "Описанието е задължително"

  Scenario: Създаване на съдържание без снимка
    When потребителя въвежда име "Summer Dress", описание "A beautiful summer dress", снимка ""
    And натиска бутона за създаване
    Then вижда съобщение "Снимката е задължителна"

  Scenario: Неуспешно създаване на съдържание
    When потребителя въвежда име "This is a very very very very very very long name that exceeds the limit", описание "A beautiful summer dress", снимка "summer_dress.jpg"
    And натиска бутона за създаване
    Then вижда съобщение "Името не може да бъде повече от 50 символа"