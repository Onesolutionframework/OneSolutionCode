set projectLocation=E:\MuniBala\BaseCode - Copy (2)\automation-testing
cd %projectLocation%
set classpath=%projectLocation%\frontend\target\*;%projectLocation%\lib\*
java org.testng.TestNG E:\MuniBala\BaseCode - Copy (2)\automation-testing\frontend\testng.xml
pause