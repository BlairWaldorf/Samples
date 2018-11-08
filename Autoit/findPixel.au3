;===============================================================================
; Function Name:    _PixelSearch
; Description:      Searches til 2 colors in an area
; Parameters:
; Author(s):		Santos, Jefferson
; Returns:			array containing result of search: 1 to found; 0 to not found
;===============================================================================
Func _PixelSearch($handle, $left, $top, $right, $bottom, $color1, $color2)
	Local $resultValues[2]
	Local $result = -9999
	Local $intI = 0
	Local $index

	If ("" <> $color2) Then
		$intI = 1
	EndIf

	For $index = 0 To $intI Step 1
		$result = PixelSearch($left, $top, $right, $bottom, $color1, Default, Default, $handle)

		If Not @error Then
			$result = True
			$resultValues[$index] = $result
		Else
			$result = False
			$resultValues[$index] = $result
		EndIf
		$result = -9999
		$color1 = $color2
	Next
	Return $resultValues
EndFunc   ;==>_PixelSearch