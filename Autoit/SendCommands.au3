
;===============================================================================
; Function Name:    _SendCommands
; Description:		send repetitive commands to a target
; Parameters:
; Author(s):		Santos, Jefferson
; Returns:
;===============================================================================
Func _SendCommands($szKeys, $intIterations, $bWaitInterval, $intMillisecs)

	Do
		;Send("{TAB}"
		Send($szKeys)

		If (True == $bWaitInterval) Then
			Sleep($intMillisecs)
		EndIf

		If (0 <> $intIterations) Then
			$intIterations = $intIterations - 1
		EndIf
	Until 0 <= $intIterations

EndFunc   ;==>_SendCommands