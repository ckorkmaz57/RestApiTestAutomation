## YemekSepeti Test Otomasyon Çalışması

Testler cucumber kullanılarak BDD yaklaşımı ile yazıldı. Test senaryoları ilgili feature dosyalarının altında bulunmaktadır. RestApi servisleri Wiremock kullanılarak mock oluşturulup restAssured ile oluşturulan mock api'lere istek gönderildi.

Kullanılan java versiyonu :

* Java : JDK16

Projede kullanılan framework'ler :

* Wiremock : 2.32.0
* Cucumber : 7.2.3
* RestAssured : 4.5.1

# Testlerin Çalıştırılması

config.properties içinde bulunan Wiremock port'u ve RestAssured'un istek atarken kullandığı endpoint değiştirilebilir. Testler local'de 8081 kullanılarak yapıldı.