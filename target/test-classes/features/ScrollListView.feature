Feature: Verify AndroidUIDesign App Quick Scroll Bar feature

Description: The purpose is to verify the quick scroll bar functionlity
	
	
	@QuickScrollBar @E2E
	Scenario: Verify Quick ScrollBar on AndroidUIDesign App
		Given app is installed for scroll list
		When user clicks on ListView TextView Option
		And user clicks on quick scrollbar button
		And user performs scroll Operation for country "<scrollcountry>"
	Examples:
	|scrollcountry|
	|Canada|
	
	@QuickScrollBar	@E2E
	Scenario Outline: Verify Search in a List on AndroidUIDesign App
		Given app is installed for scroll list
		When user clicks on ListView TextView Option
		And user clicks on searchable listview button
		And user performs search Operation in list for "<listcountry_name>"
	Examples:
	|listcountry_name|
	|India|
	|Netherlands|
	|ABC|

		
