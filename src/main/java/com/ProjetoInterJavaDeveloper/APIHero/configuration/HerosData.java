package com.ProjetoInterJavaDeveloper.APIHero.configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class HerosData {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration())
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Tabela_Herois");

        // Inicialização manual de alguns valores da tabela
        Item hero = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Batman")
                .withString("universe", "DC")
                .withNumber("films", 8);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Homem de ferro")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        Item hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Capitão américa")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        PutItemOutcome outcome1 = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
    }
}
