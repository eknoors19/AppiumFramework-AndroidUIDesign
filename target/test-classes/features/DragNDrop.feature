Feature: Verify AndroidUIDesign App Drag and Drop feature

Description: The purpose is to verify the drag and drop functionlity
	
	@DragDrop @E2E
	Scenario: Verify Drag and Drop on AndroidUIDesign App
		Given app is installed 
		When user clicks on DragAndDrop TextView Option
		And user clicks on Simple DragAndDrop button
		And user performs DragAndDrop Operation