# E-Commerce Database Design

A database systems project focused on designing and implementing a relational database for an e-commerce domain.

This project covers the full database design workflow, including domain analysis, conceptual modeling, relational schema design, normalization, and SQL implementation.



## Overview

This project focuses on designing a consistent and scalable relational database for an online store.

It starts with domain analysis and entity relationship modeling, continues with relational schema transformation, and concludes with SQL-based implementation of the final database structure.

It demonstrates practical knowledge of:
- domain-driven data modeling
- ER diagrams
- relational schema design
- normalization
- SQL implementation
- data integrity and relationships
- translating business requirements into a database structure

## Domain Description

The database is designed for an e-commerce system focused on selling products online.

The domain includes core business entities such as:

- users
- customers
- administrators
- products
- categories
- orders
- reviews
- addresses
- official product pages

The system models common business scenarios such as:

- customer registration
- product browsing
- order creation
- category management
- review creation
- product administration



## Key Features

- Conceptual modeling of an e-commerce domain
- ER diagram representing entities and relationships
- Relational schema derived from business requirements
- Use of primary and foreign keys
- Support for core e-commerce workflows
- SQL implementation of the designed database
- Modeling of business logic through structured relationships and constraints


## Tech Stack

- SQL
- PostgreSQL
- ER Modeling
- Relational Database Design
- Database Normalization
  
## Engineering Highlights

- Designed a relational database from business requirements
- Created an ER model for an e-commerce domain
- Transformed conceptual design into relational schema
- Applied normalization principles to improve consistency
- Modeled business rules through structured relationships and constraints
  
  
## Database Design Process

This project follows the standard relational database design workflow:

### 1. Domain Analysis
The business domain was analyzed in order to identify important entities, attributes, and relationships.

### 2. Conceptual Modeling
An ER model was created to represent the system at a high level, including inheritance, cardinalities, and key relationships.

### 3. Relational Schema Design
The conceptual model was transformed into a relational schema with tables, keys, and references.

### 4. Normalization
The schema was refined using normalization principles to reduce redundancy and improve consistency.

### 5. SQL Implementation
The final design was implemented using SQL definitions and database operations.


## Main Entities

The project includes relational modeling for entities such as:

- **User**
- **Customer**
- **Administrator**
- **Product**
- **Category**
- **Order**
- **Review**
- **Address**
- **Official Product Page**

The schema also models relationships between these entities, including customer orders, product categorization, product reviews, and administrative management workflows.


## ER Diagram

The project includes an ER diagram describing the e-commerce domain and the relationships between its entities.

<img width="786" height="505" alt="Снимок экрана 2026-03-26 175153" src="https://github.com/user-attachments/assets/cdad40ce-cf3a-4134-a247-8517dbbb2ede" />

## Documentation

Additional domain documentation and detailed ER model description are included in:

`docs/eshop-domain-description.pdf`

This documentation contains:
- domain analysis
- entity descriptions
- relationship definitions
- business logic context
- ER diagram
