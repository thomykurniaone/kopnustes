@regression @register

Feature: Register
        
  Scenario: Positive Case
    Given user click on hyperlink register
    And user input complete name "Thomy Kurniawan" to field fullname
    And user input phone number "087776030539" to field phone number
    And user input email valid "thomy.kurniawan1989@gmail.com" to field email
    And user input mothers name "Aminah" to field mothers name
    And user choose selected nationality WNI to field select nationality
    And user input location "Jakarta"
    And user choose location Jakarta Indonesia
    And user input code referral "123456"
    And user input password "password123" and repassword "password123"
    And user input pin number "112233"
    And user click upload photo personal and ktp and click choose from gallery
    And user click upload ktp and choose file photo from gallery
    And user click checklist on term and condition
    When user click registrasi button
    And user click ok on confirm registration
    Then system display toast with message "Registration Successful"