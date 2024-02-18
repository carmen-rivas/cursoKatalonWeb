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
import org.openqa.selenium.Keys as Keys
import java.util.stream.Collectors as Collectors

// Iniciar sesión
CustomKeywords.'opencart.Login.login'()

// Obtener nombre de producto desde el archivo de datos
TestData productData = findTestData(GlobalVariable.dataF)

// Obtener nombres de productos
List<String> productName = productData.getAllData().stream().map({ def data ->
	data[0]
}).collect(Collectors.toList())

// Iterar sobre cada nombre de producto y realizar la búsqueda y agregado al carrito
for (def productN : productName) {
	// Realizar la búsqueda del producto
	CustomKeywords.'opencart.Search.searchProduct'(productN.toString())

	// Espera
	WebUI.waitForPageLoad(5)

	// Agregar al carrito
	CustomKeywords.'opencart.AddToCart.addToCart'()
	
	// Espera
	WebUI.waitForPageLoad(1)
}

// Proceso de pago
CustomKeywords.'opencart.Checkout.checkout'()

