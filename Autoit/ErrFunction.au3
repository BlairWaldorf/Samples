;~ ;===============================================================================
;~ ; Function Name:    _MyErrFunc
;~ ; Description:      Logs script execution errors events
;~ ; Parameters:       -
;~ ; Author(s):		Santos, Jefferson
;~ ; Returns:			No Return
;~ ;===============================================================================
;~ Start of file
Global $oMyError = ObjEvent("AutoIt.Error", "_MyErrFunc")


;~Anywhere
Func _MyErrFunc()
	$HexNumber = Hex($oMyError.number, 8)
	_WriteErrorLog(@CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "###################### w ######################" & @CRLF & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.description is: " & @TAB & $oMyError.description & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.windescription:" & @TAB & $oMyError.windescription & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.number is: " & @TAB & $HexNumber & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.lastdllerror is: " & @TAB & $oMyError.lastdllerror & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.scriptline is: " & @TAB & $oMyError.scriptline & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.source is: " & @TAB & $oMyError.source & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.helpfile is: " & @TAB & $oMyError.helpfile & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "err.helpcontext is: " & @TAB & $oMyError.helpcontext & @CRLF & _
			@HOUR & ":" & @MIN & ":" & @SEC & ": " & "###################### END LOG ERROR ######################" & @CRLF _
			)
	SetError(1) ; to check for after this function returns
EndFunc   ;==>_MyErrFunc