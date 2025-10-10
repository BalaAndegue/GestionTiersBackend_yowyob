# Yowyob - Système de Gestion des Tiers

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue.svg)](https://www.postgresql.org/)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.org/)
[![Swagger](https://img.shields.io/badge/Swagger-3.0-green.svg)](https://swagger.io/)

Une application Spring Boot complète pour la gestion des tiers (clients, fournisseurs, commerciaux, prospects) avec une architecture modulaire et une API RESTful.

##  Fonctionnalités

###  Modules Principaux
- ** Gestion des Clients** - Segmentation, plafond de crédit, canal d'acquisition
- ** Gestion des Fournisseurs** - Modes de paiement, délais de livraison, certifications
- ** Gestion des Commerciaux** - Commissions, zones de couverture, spécialisations
- ** Gestion des Prospects** - Potentiel, probabilité de conversion, suivi

###  Technologies
- **Backend** : Spring Boot 3.5.6, Spring Data JPA, Spring Web
- **Base de données** : PostgreSQL 15
- **Documentation API** : Swagger/OpenAPI 3.0
- **Mapping** : MapStruct
- **Sécurité** : Spring Security (configurable)
- **Build** : Maven

##  Démarrage Rapide

### Prérequis
- Java 17 ou supérieur
- Maven 3.6+
- PostgreSQL 15
- Git

### Installation

1. **Cloner le repository**
```bash
git clone https://github.com/BalaAndegue/GestionTiersBackend_yowyob.git
cd GestionTiersBackend_yowyob
```

### configuration

```bash

# Se connecter à PostgreSQL
sudo -u postgres psql

# Créer la base de données et l'utilisateur
CREATE DATABASE tiers_db;
CREATE USER tiers_user WITH PASSWORD 'tiers_password';
GRANT ALL PRIVILEGES ON DATABASE tiers_db TO tiers_user;

# Donner les permissions supplémentaires
\c tiers_db
GRANT ALL ON SCHEMA public TO tiers_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO tiers_user;
```

### configuration de l'application

```properties
# Fichier: src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tiers_db
spring.datasource.username=tiers_user
spring.datasource.password=tiers_password
```
### Lancer l'application

```bash

mvn clean spring-boot:run
```

### API Documentation
Accès à la documentation

    Swagger UI : http://localhost:8080/swagger-ui.html

    OpenAPI JSON : http://localhost:8080/api-docs

### Endpoints Principaux
- Module	Endpoint	Méthodes	Description
- Clients	/api/clients	GET, POST	Gestion des clients
- Clients	/api/clients/{id}	GET, PUT, DELETE	Opérations sur un client
- Fournisseurs	/api/fournisseurs	GET, POST	Gestion des fournisseurs
- Commerciaux	/api/commerciaux	GET, POST	Gestion des commerciaux
- Prospects	/api/prospects	GET, POST	Gestion des prospects

#### Exemple de Requête

Créer un client :

```bash

curl -X POST http://localhost:8080/api/clients \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Entreprise ABC",
    "email": "contact@abc.com",
    "phoneNumber": "+237 656 616 751",
    "segment": "ENTREPRISE",
    "plafondCredit": 100000.00
  }'
```
### Modèle de Données
Entités Principales
Tiers (Classe de base)

```java

public class Tiers {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String postalCode;
    private Pays pays;
    private SecteurActivite secteurActivite;
    // ... autres champs communs
}
```
### Spécialisations

- Client : segment, plafondCredit, canalAquisition

- Fournisseur : modePaiement, delaiLivraison, produitsPrincipaux

- Commercial : typeCommercial, commission, zonesCouvertes

- Prospect : sourceProspect, potentiel, probabilite

### Configuration
Fichier de Configuration Principal
```properties

# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/tiers_db
spring.datasource.username=tiers_user
spring.datasource.password=tiers_password

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server
server.port=8080

# Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```
## Variables d'Environnement
```bash

export DB_URL=jdbc:postgresql://localhost:5432/tiers_db
export DB_USERNAME=tiers_user
export DB_PASSWORD=tiers_password
```
### Architecture
```text

src/main/java/com/backend/
├── controllers/          # Contrôleurs REST
├── services/            # Logique métier
├── repositories/        # Accès aux données
├── entities/           # Entités JPA
├── dtos/              # Objets de transfert
├── mapper/            # Mapping DTO/Entity
└── config/            # Configurations Spring
```
### Tests
Lancer les tests

```bash

mvn test
```
### Tests d'intégration
```bash

mvn verify
```
### Déploiement
Construction du JAR
```bash

mvn clean package
```
###Exécution en production
```bash

java -jar target/yowyob-1.0.0.jar

Docker (Optionnel)
dockerfile

FROM openjdk:17-jdk-slim
COPY target/yowyob-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## Roadmap

- Intégration avec le module Banque

- Intégration avec le module Comptabilité

- Intégration avec le module Facturation

- Interface d'administration

- Rapports et statistiques

- Export Excel/PDF

### Dépannage
## Problèmes Courants

Erreur de connexion à la base de données :
```bash

# Vérifier que PostgreSQL est en cours d'exécution
sudo systemctl status postgresql

# Tester la connexion manuellement
psql -h localhost -U tiers_user -d tiers_db
```
Swagger ne charge pas :

    Vérifier que l'application est accessible sur http://localhost:8080

    Tester directement l'API : curl http://localhost:8080/api/clients

Erreurs de compilation :
```bash

mvn clean compile
```
