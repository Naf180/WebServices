Pour tester votre microservice Spring Boot avec SOAP en utilisant Postman, vous devez envoyer des requêtes SOAP. Postman permet d'envoyer des requêtes SOAP en utilisant le format XML. Voici comment procéder :

### Étape 1: Démarrer le microservice Spring Boot

Assurez-vous que votre microservice Spring Boot est en cours d'exécution. Vous pouvez démarrer le microservice en exécutant la commande suivante dans le terminal :

```bash
mvn spring-boot:run
```

### Étape 2: Ouvrir Postman

Ouvrez Postman sur votre machine. Si vous ne l'avez pas encore installé, vous pouvez le télécharger depuis [le site officiel de Postman](https://www.postman.com/).

### Étape 3: Configurer une requête SOAP dans Postman

1. **Créer une nouvelle requête** :
    - Cliquez sur le bouton "New" et sélectionnez "Request".
    - Nommez votre requête (par exemple, "SOAP Request").

2. **Configurer la requête** :
    - Sélectionnez `POST` comme méthode HTTP.
    - Entrez l'URL suivante : `http://localhost:8080/ws`.
    - Allez dans l'onglet "Body" et sélectionnez "raw".
    - Choisissez "XML" dans le menu déroulant.

### Exemple de Requêtes SOAP

#### Lire une matière par ID

- **Body** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://dev.com/gestion_matieres">
     <soapenv:Header/>
     <soapenv:Body>
        <gs:GetMatiereRequest>
           <gs:id>1</gs:id>
        </gs:GetMatiereRequest>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Créer une nouvelle matière

- **Body** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://dev.com/gestion_matieres">
     <soapenv:Header/>
     <soapenv:Body>
        <gs:CreateMatiereRequest>
           <gs:nom>Math</gs:nom>
           <gs:classeId>1</gs:classeId>
           <gs:etudiantId>1</gs:etudiantId>
           <gs:professeurId>1</gs:professeurId>
        </gs:CreateMatiereRequest>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Mettre à jour une matière

- **Body** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://dev.com/gestion_matieres">
     <soapenv:Header/>
     <soapenv:Body>
        <gs:UpdateMatiereRequest>
           <gs:id>1</gs:id>
           <gs:nom>Science</gs:nom>
           <gs:classeId>2</gs:classeId>
           <gs:etudiantId>2</gs:etudiantId>
           <gs:professeurId>2</gs:professeurId>
        </gs:UpdateMatiereRequest>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Supprimer une matière

- **Body** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://dev.com/gestion_matieres">
     <soapenv:Header/>
     <soapenv:Body>
        <gs:DeleteMatiereRequest>
           <gs:id>1</gs:id>
        </gs:DeleteMatiereRequest>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

### Étape 4: Envoyer les requêtes

Pour chaque requête, cliquez sur le bouton "Send" pour envoyer la requête à votre microservice Spring Boot. Vous devriez recevoir une réponse XML avec les données demandées ou un message de confirmation pour les mutations.

### Exemple de Réponses SOAP

#### Lire une matière par ID

- **Réponse** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
     <soapenv:Body>
        <ns2:GetMatiereResponse xmlns:ns2="http://dev.com/gestion_matieres">
           <ns2:matiere>
              <ns2:id>1</ns2:id>
              <ns2:nom>Math</ns2:nom>
              <ns2:classeId>1</ns2:classeId>
              <ns2:etudiantId>1</ns2:etudiantId>
              <ns2:professeurId>1</ns2:professeurId>
           </ns2:matiere>
        </ns2:GetMatiereResponse>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Créer une nouvelle matière

- **Réponse** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
     <soapenv:Body>
        <ns2:CreateMatiereResponse xmlns:ns2="http://dev.com/gestion_matieres">
           <ns2:matiere>
              <ns2:id>2</ns2:id>
              <ns2:nom>Math</ns2:nom>
              <ns2:classeId>1</ns2:classeId>
              <ns2:etudiantId>1</ns2:etudiantId>
              <ns2:professeurId>1</ns2:professeurId>
           </ns2:matiere>
        </ns2:CreateMatiereResponse>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Mettre à jour une matière

- **Réponse** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
     <soapenv:Body>
        <ns2:UpdateMatiereResponse xmlns:ns2="http://dev.com/gestion_matieres">
           <ns2:matiere>
              <ns2:id>1</ns2:id>
              <ns2:nom>Science</ns2:nom>
              <ns2:classeId>2</ns2:classeId>
              <ns2:etudiantId>2</ns2:etudiantId>
              <ns2:professeurId>2</ns2:professeurId>
           </ns2:matiere>
        </ns2:UpdateMatiereResponse>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

#### Supprimer une matière

- **Réponse** :

  ```xml
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
     <soapenv:Body>
        <ns2:DeleteMatiereResponse xmlns:ns2="http://dev.com/gestion_matieres">
           <ns2:success>true</ns2:success>
        </ns2:DeleteMatiereResponse>
     </soapenv:Body>
  </soapenv:Envelope>
  ```

En suivant ces étapes, vous devriez être en mesure de tester toutes les fonctionnalités de votre microservice Spring Boot pour la gestion des matières en utilisant Postman et SOAP.