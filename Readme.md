# KonsolOyun - Java Tabanlı Oyun Mağazası Simülasyonu

KonsolOyun, Java Swing kullanılarak geliştirilmiş, Steam benzeri bir arayüze sahip kapsamlı bir oyun mağazası ve kütüphane yönetim sistemidir. Proje, Nesne Yönelimli Programlama (OOP) prensiplerini (Kalıtım, Çok Biçimlilik, Soyutlama ve Kapsülleme) temel alarak geliştirilmiştir.

## Proje Hakkında

Bu uygulama, kullanıcıların oyun satın alabileceği, bakiyelerini yönetebileceği ve sahip oldukları oyunları çalıştırabileceği bir platform sunar. Aynı zamanda yöneticiler için mağazayı yönetme ve yerli oyunlara vergi indirimi uygulama gibi gelişmiş panel özellikleri içerir.

### Ana Özellikler

- **Arayüz:** Koyu tema (Dark Mode) desteğiyle modern ve kullanıcı dostu GUI tasarımı.
- **Kullanıcı Sistemi:** Oyuncu ve Yönetici rolleri ile güvenli giriş ve kayıt sistemi.
- **Mağaza & Kütüphane:** Oyunları kategorize edilmiş şekilde listeleme, satın alma ve kütüphaneye ekleme.
- **Bakiye & Ödeme Sistemi:** Cüzdan bakiyesi ekleme ve farklı ödeme yöntemleri (Cüzdan, Kredi Kartı) desteği.
- **Veri Kalıcılığı:** `.dat` dosyaları üzerinden verilerin (oyuncular, oyunlar, kütüphane) kalıcı olarak saklanması.

## Kullanılan Teknolojiler ve Yapı

- **Dil:** Java (JDK 8+)
- **Arayüz:** Java Swing & AWT
- **Veri Saklama:** Java Serialization (Nesne Serileştirme)
- **Mimari:** Paket tabanlı temiz kod yapısı:
  - `konsoloyun.gui`: Tüm görsel pencereler (Frame ve Panel).
  - `konsoloyun.model`: Oyun, Hesap, Kutuphane gibi temel sınıflar ve Interface'ler.
  - `konsoloyun.servis`: Ödeme yöntemleri ve mantıksal servisler.
  - `konsoloyun.veri`: Mağaza yönetimi, Dosya işlemleri ve Sistem veritabanı.

## Nasıl Çalıştırılır?

Projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

### Gereksinimler

- Bilgisayarınızda **Java Development Kit (JDK)** yüklü olmalıdır (Sürüm 8 veya üzeri önerilir).
- Bir Java IDE'si (Eclipse, IntelliJ IDEA veya NetBeans) tavsiye edilir.

### Kurulum ve Çalıştırma

1.  **Repoyu Klonlayın:**
    ```bash
    git clone https://github.com/kullaniciadi/konsoloyun.git
    ```
2.  **IDE İle Açın:**
    - Kullandığınız IDE'yi açın ve "Import Project" seçeneğiyle indirdiğiniz klasörü seçin.
3.  **Main Sınıfını Bulun:**
    - `src/konsoloyun` paketi altındaki `Main.java` dosyasını bulun.
4.  **Projeyi Başlatın:**
    - `Main.java` dosyasına sağ tıklayıp **Run As > Java Application** seçeneğine tıklayın.

## Varsayılan Giriş Bilgileri

Sistemi test etmek için başlangıçta şu bilgileri kullanabilirsiniz fakat Sistem Temiz Başlangıç modunda yapılandırıldığı için başlangıçta herhangi bir oyuncu hesabı bulunmamaktadır. Giriş Yap > Yeni hesap adımlarını izleyerek kendi hesabınızı oluşturmanız gerekmektedir.

- **Yönetici Girişi:**
  - Kullanıcı Adı: `admin`
  - Şifre: `admin123`
  - Admin PIN: `9999`

## Dosya Yapısı ve OOP Kullanımı

- **Interface'ler:** `Aksiyon`, `Spor`, `AcikDunya`, `CokOyunculu` ve `Yerli` gibi arayüzler ile oyunların davranışları polimorfik olarak yönetilir.
- **Ödeme Mantığı:** `OdemeYontemi` arayüzü sayesinde Cüzdan veya Kredi Kartı ile ödeme esnek bir şekilde uygulanır.
- **Hata Yönetimi:** `YetersizBakiyeException` ve `OyunZatenVarException` gibi özel hata sınıfları ile sistem kararlılığı sağlanır.

---
*Bu proje eğitim amaçlı geliştirilmiş bir Java Swing uygulamasıdır.*
