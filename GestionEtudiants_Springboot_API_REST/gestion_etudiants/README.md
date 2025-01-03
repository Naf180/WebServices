Pour tester votre microservice Spring Boot pour la gestion des étudiants avec Postman, suivez les étapes ci-dessous :

### Étape 1: Démarrer le microservice Spring Boot

Assurez-vous que votre microservice Spring Boot est en cours d'exécution. Vous pouvez démarrer le microservice en exécutant la commande suivante dans le terminal :

```bash
mvn spring-boot:run
```

### Étape 2: Ouvrir Postman

Ouvrez Postman sur votre machine. Si vous ne l'avez pas encore installé, vous pouvez le télécharger depuis [le site officiel de Postman](https://www.postman.com/).

### Étape 3: Créer un nouveau étudiant

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "Create Etudiant").

2. **Configurer la requête** :
    - Sélectionnez `POST` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/api/etudiants`.
    - Allez dans l'onglet "Body" et sélectionnez "raw".
    - Choisissez "JSON" dans le menu déroulant.
    - Entrez les données JSON suivantes :

      ```json
      {
        "nom": "Doe",
        "prenom": "John",
        "email": "john.doe@example.com",
        "classeId": 1,
        "matiereId": 1,
        "professeurId": 1
      }
      ```

3. **Envoyer la requête** :
    - Cliquez sur le bouton "Send".
    - Vous devriez recevoir une réponse avec le statut `200 OK` et les détails du nouvel étudiant créé.

### Étape 4: Lire tous les étudiants

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "Get All Etudiants").

2. **Configurer la requête** :
    - Sélectionnez `GET` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/api/etudiants`.

3. **Envoyer la requête** :
    - Cliquez sur le bouton "Send".
    - Vous devriez recevoir une réponse avec le statut `200 OK` et la liste de tous les étudiants.

### Étape 5: Lire un étudiant par ID

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "Get Etudiant by ID").

2. **Configurer la requête** :
    - Sélectionnez `GET` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/api/etudiants/1` (remplacez `1` par l'ID de l'étudiant que vous souhaitez récupérer).

3. **Envoyer la requête** :
    - Cliquez sur le bouton "Send".
    - Vous devriez recevoir une réponse avec le statut `200 OK` et les détails de l'étudiant correspondant à l'ID spécifié.

### Étape 6: Mettre à jour un étudiant par ID

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "Update Etudiant").

2. **Configurer la requête** :
    - Sélectionnez `PUT` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/api/etudiants/1` (remplacez `1` par l'ID de l'étudiant que vous souhaitez mettre à jour).
    - Allez dans l'onglet "Body" et sélectionnez "raw".
    - Choisissez "JSON" dans le menu déroulant.
    - Entrez les données JSON suivantes :

      ```json
      {
        "nom": "Doe",
        "prenom": "John",
        "email": "john.doe@example.com",
        "classeId": 2,
        "matiereId": 2,
        "professeurId": 2
      }
      ```

3. **Envoyer la requête** :
    - Cliquez sur le bouton "Send".
    - Vous devriez recevoir une réponse avec le statut `200 OK` et les détails de l'étudiant mis à jour.

### Étape 7: Supprimer un étudiant par ID

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "Delete Etudiant").

2. **Configurer la requête** :
    - Sélectionnez `DELETE` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/api/etudiants/1` (remplacez `1` par l'ID de l'étudiant que vous souhaitez supprimer).

3. **Envoyer la requête** :
    - Cliquez sur le bouton "Send".
    - Vous devriez recevoir une réponse avec le statut `200 OK` et un message indiquant que l'étudiant a été supprimé.

### Exemple de Requêtes Postman

#### Créer un Étudiant

- **Méthode** : POST
- **URL** : `http://localhost:8080/api/etudiants`
- **Body** :

  ```json
  {
    "nom": "Doe",
    "prenom": "John",
    "email": "john.doe@example.com",
    "classeId": 1,
    "matiereId": 1,
    "professeurId": 1
  }
  ```

#### Lire tous les Étudiants

- **Méthode** : GET
- **URL** : `http://localhost:8080/api/etudiants`

#### Lire un Étudiant par ID

- **Méthode** : GET
- **URL** : `http://localhost:8080/api/etudiants/1`

#### Mettre à jour un Étudiant par ID

- **Méthode** : PUT
- **URL** : `http://localhost:8080/api/etudiants/1`
- **Body** :

  ```json
  {
    "nom": "Doe",
    "prenom": "John",
    "email": "john.doe@example.com",
    "classeId": 2,
    "matiereId": 2,
    "professeurId": 2
  }
  ```

#### Supprimer un Étudiant par ID

- **Méthode** : DELETE
- **URL** : `http://localhost:8080/api/etudiants/1`

En suivant ces étapes, vous devriez être en mesure de tester toutes les fonctionnalités de votre microservice Spring Boot pour la gestion des étudiants en utilisant Postman.