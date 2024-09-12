Feature: Verify AndroidUIDesign App Magical TextView feature

Description: The purpose is to verify the magical text view functionlity
	
	@MagicalTextView @E2E
	Scenario: Verify Magical Text View on AndroidUIDesign App
		Given app is installed for Magical Text
		When user clicks on Magical TextView Option
		And user fetches the Magical TextView text