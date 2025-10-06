MerchantApiAutomation
1. Proje Amacı ve Kapsam

MerchantApiAutomation, muhtemelen merchant (satıcı) API’lerini test etmek / otomatikleştirmek için yazılmış bir test otomasyon çatısıdır.

API uç noktalarına istekler atar

Yanıtlara karşı doğrulamalar yapar

Sürekli entegrasyon / teslim süreçlerine entegre edilebilir

Bu tür projeler, manuel test yükünü azaltır, regresyon hatalarını yakalar ve API’lerin stabil çalışmasını sağlar.

2. Proje Yapısı / Dosya Organizasyonu

Depo içeriği şu şekilde:

MerchantApiAutomation/
│
├── .idea/                   — IDE (IntelliJ / IDE konfigürasyon) klasörü  
├── src/                     — Kaynak kod klasörü  
│   ├── … (Java test sınıfları vs.)  
│
├── pom.xml                  — Maven proje yapılandırması  
└── .gitignore                — Git yoksayma ayarları  


pom.xml: Projenin bağımlılıklarını, build ayarlarını, plugin’leri tanımlar (JUnit, RestAssured vs).

src/: Test kodları ve API çağrılarını içeren sınıflar.

3. Kullanılan Teknolojiler / Araçlar

Projeye dair dosyaların uzantıları ve yapıdan çıkarımlar:

Java dili (%.java uzantıları)

Maven proje yönetimi (pom.xml)

Muhtemelen RestAssured veya benzeri REST client + test framework

Test senaryoları / doğrulamalar (assertion)

4. Nasıl Çalıştırılır / Kullanımı

Aşağıdaki adımları izleyerek projeyi çalıştırabilirsin:

Projeyi bilgisayarına klonla:

git clone https://github.com/aylinkaymazm/MerchantApiAutomation.git


Maven ile bağımlılıkları indir:

mvn clean install


Testleri çalıştır:

mvn test


Çıkan raporları kontrol et. (Maven Surefire raporları, HTML / XML formatlı olabilir)

Eğer API tabanlı environment’lar varsa (örneğin: base URL, token), bunları application.properties veya env dosyası ile ayarlaman gerekebilir.
