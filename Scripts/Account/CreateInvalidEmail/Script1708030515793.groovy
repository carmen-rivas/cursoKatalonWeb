import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

// Ventana del navegador
WebUI.maximizeWindow()

// Click en "Mi Cuenta"
WebUI.click(findTestObject('Pages/Account/my-Account'))
// Click en "Registrarse"
WebUI.click(findTestObject('Pages/Account/Register/a_Register'))

// Datos del usuario
def name = name
def lastName = lastName
def email = email
def phoneNumber = phoneNumber
def password = password


// Ingresar datos en la página de registro
WebUI.setText(findTestObject('Pages/Account/Register/input_firstname'), name)
WebUI.setText(findTestObject('Pages/Account/Register/input_lastname'), lastName)
WebUI.setText(findTestObject('Pages/Account/Register/input_email'), email)
WebUI.setText(findTestObject('Pages/Account/Register/input_telephone'), phoneNumber)
WebUI.setText(findTestObject('Pages/Account/Register/input_password'), password)
WebUI.setText(findTestObject('Pages/Account/Register/input_confirm'), password)
WebUI.click(findTestObject('Object Repository/Pages/Account/Register/input_agree'))

// Click en "Continuar"
WebUI.click(findTestObject('Pages/Account/Register/btn_Continue'))

// Verificar que el sistema informe sobre el error
WebUI.verifyTextPresent(error, true)

WebUI.closeBrowser()
