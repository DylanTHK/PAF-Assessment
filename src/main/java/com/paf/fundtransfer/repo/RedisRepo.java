package com.paf.fundtransfer.repo;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.paf.fundtransfer.model.TransactionDetails;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Repository
public class RedisRepo {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(TransactionDetails td) {
        String redisKey = td.getId();
        String transJson = Json.createObjectBuilder()
            .add("transactionId", td.getId())
            .add("date", Timestamp.from(Instant.now()).toString())
            .add("from_account", td.getFromAccount())
            .add("to_account", td.getToAccount())
            .add("amount", td.getAmount())
            .build().toString();

        redisTemplate.opsForValue().set(redisKey, transJson);
    }

}
