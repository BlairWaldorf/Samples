;===============================================================================
; Function Name:    _CopyContentWindowByClick
; Description:		Copy content from window by click in a defined position
; Parameters:
; Author(s):		Santos, Jefferson
; Returns:
;===============================================================================
Func _CopyContentWindowByClick($windowToClick, $btn, $intX, $intY)

	Local $szData
	WinActive($windowToClick)
	WinWaitActive($windowToClick)
	MouseClick($btn, $intX, $intY, 1)
	MouseUp($btn)
	Send("{CTRLDOWN}ac{CTRLUP}")
	Sleep(500)
	MouseClick($btn, $intX, $intY, 1)
	MouseUp($btn)

	$szData = ClipGet()

	Return $szData
EndFunc   ;==>_CopyContentWindowByClick
