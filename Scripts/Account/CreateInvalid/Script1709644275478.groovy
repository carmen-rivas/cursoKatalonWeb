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
import com.kms.katalon.core.testdata.InternalData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.util.stream.Collectors as Collectors


// Ventana del navegador
WebUI.maximizeWindow()

// Click en "Mi Cuenta"
WebUI.click(findTestObject('Pages/Account/my-Account'))
// Click en "Registrarse"
WebUI.click(findTestObject('Pages/Account/Register/a_Register'))

// Obtener datos
InternalData createInvalidData = findTestData(GlobalVariable.dataI)
List<List<String>> createInvalid = createInvalidData.getAllData()

// Obtener datos
for (int i = 0; i < createInvalid.size(); i++) {
    List<String> rowData = createInvalid.get(i);
    for (String data : rowData) {
		String name = rowData[0]
		String lastName = rowData[1]
		String email = rowData[2]
		String phoneNumber = rowData[3]
		String password = rowData[4]


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

    }
}
WebUI.closeBrowser()
