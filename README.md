# 🚀 Merchant API Automation  

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)  
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apache-maven)  
![Tests](https://img.shields.io/badge/Tests-Automated-green?logo=testing-library)  
![Status](https://img.shields.io/badge/Status-Active-success?style=flat)

---

## 📖 Hakkında  
**MerchantApiAutomation**, satıcı (merchant) API’lerini test etmek için hazırlanmış bir **otomasyon projesidir**.  
Amaç:  
- 🔎 API uç noktalarını otomatik test etmek  
- ✅ Doğrulama (assertion) işlemlerini güvenilir şekilde yapmak  
- 🔄 CI/CD süreçlerine kolayca entegre etmek  

---

## 🛠️ Kullanılan Teknolojiler  
- ☕ **Java 17**  
- 🐘 **Maven** (bağımlılık yönetimi & build)  
- 📬 **REST Assured** (REST API testleri)  
- 🧪 **JUnit / TestNG** (test framework)  
- 📊 **Surefire Reports** (raporlama)

---

## 📂 Proje Yapısı  
MerchantApiAutomation/
│
├── src/ → Test senaryoları (Java sınıfları)
│ ├── test/java/... → API testleri
│
├── pom.xml → Maven bağımlılık yönetimi
└── README.md → Proje dokümantasyonu

yaml
Copy code

---

## ⚙️ Kurulum & Çalıştırma  

### 1️⃣ Repoyu Klonla  
```bash
git clone https://github.com/aylinkaymazm/MerchantApiAutomation.git
cd MerchantApiAutomation
2️⃣ Bağımlılıkları Yükle
bash
Copy code
mvn clean install
3️⃣ Testleri Çalıştır
bash
Copy code
mvn test
4️⃣ Raporları İncele
Maven Surefire raporları target/surefire-reports/ altında oluşur.

Gelişmiş raporlama için Allure veya ExtentReports eklenebilir.
