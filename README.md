# Company-Employee Microservice System
## Şirket ve Çalışan Yönetim Sistemi

A microservice-based company and employee management system built with Java Spring Boot.
Java Spring Boot ile geliştirilmiş mikroservis tabanlı şirket ve çalışan yönetim sistemi.

---

## Architecture / Mimari

```
Client → API Gateway (8083)
              ↓
   ┌──────────────────────────┐
   │  company-service  → 8081 │
   │  employee-service → 8082 │
   └──────────────────────────┘
```
---

## Services / Servisler

| Service | Port | Description |
|---------|------|-------------|
| api-gateway | 8083 | JWT Security + Request Routing / JWT Güvenlik + Yönlendirme |
| company-service | 8081 | Company CRUD Operations / Şirket CRUD İşlemleri |
| employee-service | 8082 | Employee CRUD Operations / Çalışan CRUD İşlemleri |

---

## Tech Stack / Teknolojiler

- **Java 21**
- **Spring Boot 3.5**
- **Spring Data JPA** - Database operations / Veritabanı işlemleri
- **H2 Database** - In-memory database / Bellek içi veritabanı
- **JWT (JSON Web Token)** - Authentication / Kimlik doğrulama
- **Docker** - Containerization / Konteynerizasyon
- **REST API** - Service communication / Servis iletişimi
- **Maven** - Dependency management / Bağımlılık yönetimi

---

## Features / Özellikler

- ✅ Full CRUD operations (GET, POST, PUT, DELETE)
- ✅ JWT Authentication & Authorization / JWT Kimlik Doğrulama
- ✅ Microservice architecture / Mikroservis mimarisi
- ✅ Inter-service communication via RestTemplate / Servisler arası iletişim
- ✅ API Gateway for single entry point / Tek giriş noktası
- ✅ Dockerized all services / Tüm servisler Docker ile containerize edildi

---

## API Endpoints

### Auth
| Method | URL | Description |
|--------|-----|-------------|
| POST | /login | Get JWT token / JWT token al |

### Companies / Şirketler
| Method | URL | Description |
|--------|-----|-------------|
| GET | /companies | List all / Tümünü listele |
| POST | /companies | Add new / Yeni ekle |
| PUT | /companies/{id} | Update / Güncelle |
| DELETE | /companies/{id} | Delete / Sil |

### Employees / Çalışanlar
| Method | URL | Description |
|--------|-----|-------------|
| GET | /employees | List all / Tümünü listele |
| POST | /employees | Add new / Yeni ekle |
| PUT | /employees/{id} | Update / Güncelle |
| DELETE | /employees/{id} | Delete / Sil |

---

## How to Run / Nasıl Çalıştırılır

### With Docker / Docker ile
```bash
# company-service
docker run -d -p 8081:8081 company-service

# employee-service
docker run -d -p 8082:8082 employee-service

# api-gateway
docker run -d -p 8083:8083 api-gateway
```

### Without Docker / Docker olmadan
```bash
cd company-service && mvn spring-boot:run
cd employee-service && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
```

---

## Developer / Geliştirici

**Pelin BİNGÖL**  
M.Sc. AI Engineering — İzmir Bakırçay University  
[GitHub](https://github.com/pelinbingl)
