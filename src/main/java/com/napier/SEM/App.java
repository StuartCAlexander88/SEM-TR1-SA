package com.napier.SEM;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App {

    public static void main(String[] args)
    {
            System.out.println("Boo yah!");

            //Connect to MongoDB on local sys - port 27000
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27000")) {

            // Get Database - will create when we use
            MongoDatabase database = mongoClient.getDatabase("mydb0");
            // Get a collection from the database
            MongoCollection<Document> collection = database.getCollection("test");
            // Create a new document to store
            Document doc = new Document("name", "Stuart Alexander")
                    .append("class", "Software Engineering Methods")
                    .append("year", "2025")
                    .append("result", new Document("CW", 95).append("EX",85));
            // Add document to collection
            collection.insertOne(doc);

            // Check Document in collection
            Document myDoc = collection.find().first();
            System.out.println(myDoc.toJson());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        {
        }
    }
}

