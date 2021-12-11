package Model;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

//cs534_1234
public class DbConnection {

    MongoClient mongoClient = MongoClients.create("mongodb+srv://yasemin:yasemin123@cs534.9yrow.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

    MongoDatabase db = mongoClient.getDatabase("CS534");


    public MongoCollection mongoCollection = db.getCollection("Users");




}
