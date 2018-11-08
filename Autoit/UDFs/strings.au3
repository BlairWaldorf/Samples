	Local $szOSIdiom = @OSLang

	$szOSIdiom = StringRight($szOSIdiom,2)		;======> only last 2 digits are important

	;Windows titles
	Global $_g_szRoteamento = "Roteamento - Internet Explorer"
	Global $_g_szPrintLabels = "Print labels (1) (Remote)"
	Global $_g_szWipedownRpa = "WipedownRPA"
	Global $_g_szMSLDispatch = "Manufacturing Services Layer - Internet Explorer"
	Global $_g_szMSLMias = "Manufacturing Services -- Webpage Dialog"
	Global $_g_szDeniedAccess = "https://mdt/denied.html - Internet Explorer"
	Global $_g_szMDTTitleLogin = "MDT - Manufacture Dell Tools - Internet Explorer"
	Global $_g_szMDTTitleHome = "MDT - BRH1 - Internet Explorer"

	;======> Address
	Global $_g_URLDispatch = "http://vcppwmslapp.vcp.amer.dell.com/MSLWeb/Forms/Burn/BurnDispatch.aspx"
	Global $_g_URLMDTLogin = "https://mdt/Login.aspx?ReturnUrl=%2f"
	Global $_g_URLMDTRouting = "https://mdt/FABRICA/StatusScan_Portables_Timer_newLine_mias.asp"
	Global $_g_URLMDTRoutingAIO
	Global $_g_URLMias = "http://vcppwmslapp.vcp.amer.dell.com/MSLWeb/Forms/Default/MasterUI.aspx"

	Global $_g_Image1 = "C:\Users\acrif\Desktop\WIPEDOWN_MIAS_IMG\1.jpg"
	Global $_g_Image2 = "C:\Users\acrif\Desktop\WIPEDOWN_MIAS_IMG\2.jpg"

	If (16 == $szOSIdiom) Then ;======> PTBR
		;======> Prompts
		Global $_g_szLOB = "ESCOLHA A LOB:" & @CRLF & @CRLF & _
									 "1: DESKTOP" & @CRLF & _
									 "2: PORTABLES" & @CRLF & _
									 "3: AIO"
		Global $_g_szMachineAnalisys =  @CRLF & "AVALIAÇÃO COSMÉTICA!" & @CRLF & _
										@CRLF & "Avalie a máquina:" & @CRLF & _
																"1: Máquina OK!" & @CRLF & _
																"2: Gaps/Riscos" & @CRLF & _
																"3: Labels irregulares"
		;======> Labels and messages
		Global $_g_szVersion = "Em caso de problemas, contate a Engenharia de Testes - VERS�O: "
		Global $_g_szIdleMsg = "Aguardando Trackcode..."
		Global $_g_szNoMatchTrackcode = "Trackcodes n�o conferem."
		Global $_g_szTrackcodeMatch = "Tackcodes conferem!"
		Global $_g_szPPIDnotFound = "PPID MB N�O ENCONTRADO!"
		Global $_g_szPPIDScanRequest = "Scaneie PPID AC Adapter"
		Global $_g_szValidPPID = "PPID V�lido!"
		Global $_g_szNotValidPPID = "PPID N�O � AC ADAPTER"
		Global $_g_szSplashScreenTitle = "Verifique a m�quina"
		Global $_g_szSplashScreenBody = "Aguardado Carregamento da p�gina"
		Global $_g_szFinished =  "Conclu�do!"
		Global $_g_szIrregularLabels = "Labels Irregulares."
		Global $_g_szCosmeticIssues = "Defeitos cosm�ticos."
		Global $_g_szTrackcode = "TRACKCODE"
		Global $_g_szLabels =  "ETIQUETA"
		Global $_g_szAtention = "ATEN��O"
		Global $_g_szAtentionBody = "Abrir PRINT LABELS no AX!"
		Global $_g_MDTLoginRequest = "Favor realizar o login no MDT para continuar."
		Global $_g_szMDTLogged = "MDT LOGADO!"
		Global $_g_SmartWipeVersion = "1.0.1"
		Global $_g_szStation1 = "Esta��o 1"
		Global $_g_szStation2 = "Esta��o 2"
		Global $_g_szStation3 = "Esta��o 3"
		Global $_g_szMachineTrackcode = "MACHINE TRACKCODE"
		Global $_g_szTravellerTrackcode = "TRAVELLER TRACKCODE"
		Global $_g_szAcAdapterPPID = "AC ADAPTER PPID"
		Global $_g_szWipedownStart = "Iniciando SmartWIPE!"
		Global $_g_szSelectStation = "Selecione a Estação"
	 Else ;======> EN
		;======> Prompts
		$_g_szLOB = "SELECT LOB" & @CRLF & @CRLF & _
									 "1: DESKTOP" & @CRLF & _
									 "2: PORTABLES" & @CRLF & _
									 "3: AIO"
		$_g_szMachineAnalisys =  @CRLF & "COMETIC ANALISYS: " & @CRLF & _
										@CRLF & "CHECK MACHINE:" & @CRLF & _
																"1: Machine OK!" & @CRLF & _
																"2: Gaps/Scratches" & @CRLF & _
																"3: Irregular Labels"
		;======> Labels and messages
		$_g_szVersion = "In case of any issue, call Test Eng - Version: "
		$_g_szIdleMsg = "Wainting for Trackcode..."
		$_g_szNoMatchTrackcode = "Trackcodes do not match."
		$_g_szTrackcodeMatch = "Tackcodes match!"
		$_g_szPPIDnotFound = "PPID MB NOT FOUND!"
		$_g_szPPIDScanRequest = "Scan PPID AC Adapter"
		$_g_szValidPPID = "PPID Valid!"
		$_g_szNotValidPPID = "PPID IS NOT AN AC ADAPTER"
		$_g_szSplashScreenTitle = "Check Machine"
		$_g_szSplashScreenBody = "Wait loading finish"
		$_g_szFinished =  "Finished!"
		$_g_szIrregularLabels = "Irregular Labels."
		$_g_szCosmeticIssues = "Cosmetic Issues."
		$_g_szTrackcode = "TRACKCODE"
		$_g_szLabels =  "LABELS"
		$_g_szAtention = "WARNING"
		$_g_szAtentionBody = "OPEN AX PRINT LABELS!"
		$_g_MDTLoginRequest = "Please, Log in MDT to continue."
		$_g_szMDTLogged = "Logged in MDT!"
		$_g_SmartWipeVersion = "1.0.1"
		$_g_szStation1 = "Station 1"
		$_g_szStation2 = "Station 2"
		$_g_szStation3 = "Station 3"
		$_g_szMachineTrackcode = "MACHINE TRACKCODE"
		$_g_szTravellerTrackcode = "TRAVELLER TRACKCODE"
		$_g_szAcAdapterPPID = "AC ADAPTER PPID"
		$_g_szWipedownStart = "Starting SmartWIPE!"
		$_g_szSelectStation = "Select Station"
	EndIf

