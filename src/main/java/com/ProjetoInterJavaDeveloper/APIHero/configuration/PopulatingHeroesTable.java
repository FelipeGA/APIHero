package com.ProjetoInterJavaDeveloper.APIHero.configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.ProjetoInterJavaDeveloper.APIHero.constantes.HeroesConstant.*;

public class PopulatingHeroesTable {
    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("TabelaHerois");

        // Inicialização manual de alguns valores da tabela
        Item hero = new Item()
                .withPrimaryKey("id", "2")
                .withString("nome", "Batman")
                .withString("universo", "DC")
                .withNumber("filmes", 8);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("nome", "Homem de ferro")
                .withString("universo", "marvel")
                .withNumber("filmes", 3);

        Item hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("nome", "Capitão américa")
                .withString("universo", "marvel")
                .withNumber("filmes", 2);

        PutItemOutcome outcome1 = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
    }
}
