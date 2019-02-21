package utility;


import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class APIUtility {


    public static Client client;
    public static String host ;
    public static String app;
    public static String xparameter ;
    public static String xvalue ;
    public static WebTarget webTarget;

//    public static String authorizationHeaderValue = "No Auth" ;
    public static HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().build();

    public static String usernameAndPassword = "" + ":" + "";
    public static String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );


    @BeforeClass
    public static void init() {
                client = ClientBuilder.newBuilder().build();
        webTarget = client.target("https://od-api.oxforddictionaries.com" );
//        client = ClientBuilder.newClient();
//        client.register(feature);
//        https://developer.oxforddictionaries.com/documentation#!/Dictionary32entries/get_entries_source_lang_word_id


    }

    public static void getResponse(){
        client.register(feature);
        Response response = client.target(host + app + "/" + xparameter + "/" + xvalue )
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization",authorizationHeaderValue)
        .header("Accept","application/json")
        .header("app_id","3a037048")
        .header("app_key","bf95e9dbc2ad47aaec9fb380847a4503")
                .get();
        System.out.println(response);
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());



    }

    public static String getStatus(){
        client.register(feature);
        Response response = client.target(host + app + "/" + xparameter + "/" + xvalue )
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization",authorizationHeaderValue)
                .header("Accept","application/json")
                .header("app_id","3a037048")
                .header("app_key","bf95e9dbc2ad47aaec9fb380847a4503")
                .get();
        System.out.println(response);
        System.out.println("headers: " + response.getHeaders());
        return String.valueOf(response.getStatus());


    }

    public static void targetEnglish(){
        init();
        host = "https://od-api.oxforddictionaries.com:443" ;
        app = "/api/v1/entries";
        xparameter = "en";
    }

    @Test
    public void Main(){
        host = "https://od-api.oxforddictionaries.com:443" ;
        app = "/api/v1/entries";
        xparameter = "en";
        xvalue = "test";
        getResponse();

    }

}
