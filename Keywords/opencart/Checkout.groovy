package opencart

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Checkout {

	@Keyword ()
	def checkout() {

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/i_Shopping Cart_fa fa-share'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Region  State_button-payment-address'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Region  State_button-shipping-address'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Add Comments About Your Order_button-_543ebe'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Terms  Conditions_agree'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Terms  Conditions_button-payment-method'))

		WebUI.click(findTestObject('Object Repository/Pages/Checkout/input_Please transfer the total amount to t_a6d3bd'))

	}
}
