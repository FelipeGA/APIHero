package com.ProjetoInterJavaDeveloper.APIHero.modelo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.*;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "TabelaHerois")
@Getter
@Setter
public class Heroes {
    @Id
    @DynamoDBHashKey (attributeName = "id")
    private String id;

    @DynamoDBAttribute (attributeName = "nome")
    private String name;

    @DynamoDBAttribute (attributeName = "universo")
    private String universe;

    @DynamoDBAttribute (attributeName = "filmes")
    private int films;
}
