Pour tester votre microservice Spring Boot pour la gestion des classes avec GraphQL en utilisant Postman, suivez les étapes ci-dessous :

### Étape 1: Démarrer le microservice Spring Boot

Assurez-vous que votre microservice Spring Boot est en cours d'exécution. Vous pouvez démarrer le microservice en exécutant la commande suivante dans le terminal :

```bash
mvn spring-boot:run
```

### Étape 2: Ouvrir Postman

Ouvrez Postman sur votre machine. Si vous ne l'avez pas encore installé, vous pouvez le télécharger depuis [le site officiel de Postman](https://www.postman.com/).

### Étape 3: Configurer les requêtes GraphQL

Pour tester les API GraphQL, vous devez configurer les requêtes GraphQL dans Postman. Voici comment procéder :

#### Créer une nouvelle requête

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "GraphQL Query").

2. **Configurer la requête** :
    - Sélectionnez `POST` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/graphql`.
    - Allez dans l'onglet "Body" et sélectionnez "raw".
    - Choisissez "GraphQL" dans le menu déroulant.

#### Exemple de Requêtes GraphQL

##### Lire toutes les classes

- **Body** :

  ```graphql
  query {
    getAllClasses {
      id
      nom
      matiereId
      etudiantId
      professeurId
    }
  }
  ```

##### Lire une classe par ID

- **Body** :

  ```graphql
  query {
    getClasseById(id: 1) {
      id
      nom
      matiereId
      etudiantId
      professeurId
    }
  }
  ```

##### Créer une nouvelle classe

- **Body** :

  ```graphql
  mutation {
    createClasse(nom: "Math", matiereId: 1, etudiantId: 1, professeurId: 1) {
      id
      nom
      matiereId
      etudiantId
      professeurId
    }
  }
  ```

##### Mettre à jour une classe

- **Body** :

  ```graphql
  mutation {
    updateClasse(id: 1, nom: "Science", matiereId: 2, etudiantId: 2, professeurId: 2) {
      id
      nom
      matiereId
      etudiantId
      professeurId
    }
  }
  ```

##### Supprimer une classe

- **Body** :

  ```graphql
  mutation {
    deleteClasse(id: 1)
  }
  ```

### Étape 4: Envoyer les requêtes

Pour chaque requête, cliquez sur le bouton "Send" pour envoyer la requête à votre microservice Spring Boot. Vous devriez recevoir une réponse avec les données demandées ou un message de confirmation pour les mutations.

### Exemple de Réponses

#### Lire toutes les classes

- **Réponse** :

  ```json
  {
    "data": {
      "getAllClasses": [
        {
          "id": 1,
          "nom": "Math",
          "matiereId": 1,
          "etudiantId": 1,
          "professeurId": 1
        },
        {
          "id": 2,
          "nom": "Science",
          "matiereId": 2,
          "etudiantId": 2,
          "professeurId": 2
        }
      ]
    }
  }
  ```

#### Lire une classe par ID

- **Réponse** :

  ```json
  {
    "data": {
      "getClasseById": {
        "id": 1,
        "nom": "Math",
        "matiereId": 1,
        "etudiantId": 1,
        "professeurId": 1
      }
    }
  }
  ```

#### Créer une nouvelle classe

- **Réponse** :

  ```json
  {
    "data": {
      "createClasse": {
        "id": 3,
        "nom": "Math",
        "matiereId": 1,
        "etudiantId": 1,
        "professeurId": 1
      }
    }
  }
  ```

#### Mettre à jour une classe

- **Réponse** :

  ```json
  {
    "data": {
      "updateClasse": {
        "id": 1,
        "nom": "Science",
        "matiereId": 2,
        "etudiantId": 2,
        "professeurId": 2
      }
    }
  }
  ```

#### Supprimer une classe

- **Réponse** :

  ```json
  {
    "data": {
      "deleteClasse": true
    }
  }
  ```

En suivant ces étapes, vous devriez être en mesure de tester toutes les fonctionnalités de votre microservice Spring Boot pour la gestion des classes en utilisant Postman et GraphQL.