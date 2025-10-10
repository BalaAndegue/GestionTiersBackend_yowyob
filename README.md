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