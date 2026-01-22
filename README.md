# Codice Fiscale - Medialogic
Esercizio svolto per la prova tecnica con Medialogic Spa. <br>
L'esercizio richiede di esporre una servizio REST capace di estrarre la data di nascita e l'età di un codice fiscale.

### Setup
Il progetto è stato generato utilizzando [Spring Initializr](https://start.spring.io/) e utilizza Java 21 con Spring Boot 3.5.9 e Maven. <br>
Sono state inoltre aggiunte le seguenti librerie: <br>
- Lombok
- SpringDoc 2.8.3

### APIs
Il progetto include tre API, una per la richiesta dell'esercizio (EstrattoreApi) e due per comodità di utilizzo (GeneratoreApi, ValidatoreApi). <br>
- GeneratoreApi: Include un end-point per la "generazione" casuale di un codice fiscale da una lista predefinita
- ValidatoreApi: Include un end-point per la validazione del codice fiscale fornito come queryParam
- EstrattoreApi: Include un end-point per l'estrazione della data di nascita ed età del codice fiscale fornito come queryParam

Le API sono documentate ed utilizzabili all'indirizzo **".../api/v1/codice-fiscale/swagger-ui.html"**. <br>
Di default, l'applicativo viene hostato all'indirizzo localhost:9091. <br>

### Tests
Sono incluse nel progetto alcune classi di test per i Service utilizzati. Ciascuna classe include alcuni semplici test di esempio per ogni servizio. <br>
È inoltre disponibile nella cartella _src/main/resources/collezioni-postman/_ un file .json importabile in Postman, contenente una collection con delle chiamate di esempio.
