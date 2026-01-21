package it.medialogic.codice_fiscale.utils;

/**
 * Classe di utility che raccoglie le costanti del progetto.
 *
 * @author Lorenzo Ricci
 */
public class Costanti {

    // Il costruttore privato nasconde l'implementazione implicita del costruttore pubblico.
    private Costanti() { }

    public static final String API_V1_URI = "api/v1";
    public static final String BASE_URL = API_V1_URI + "/codice-fiscale";
    public static final String GENERATORE_API_PATH = BASE_URL + "/generatore";
    public static final String ESTRATTORE_API_PATH = BASE_URL + "/estrattore";
    public static final String VALIDATORE_API_PATH = BASE_URL + "/validatore";
}
