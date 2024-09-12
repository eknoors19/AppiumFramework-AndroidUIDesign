Feature: Verify AndroidUIDesign App PopUp Menu feature

Description: The purpose is to verify the pop up menu functionlity
	
	@PopUpMenu @E2E
	Scenario: Verify PopUpMenu on AndroidUIDesign App
		Given app is installed for pop up
		When user clicks on PopUp TextView Option
		And user clicks on PopUpMenu button
		And user clicks on ShowPopUpMenu button
		Then user performs Play Operation