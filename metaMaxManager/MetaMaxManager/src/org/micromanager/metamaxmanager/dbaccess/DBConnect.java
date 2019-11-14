package org.micromanager.metamaxmanager.dbaccess;

import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {

    String host_;
    int port_;
    String user_;
    String database_;
    char[] password_;
    MongoClient mongoClient;

    public DBConnect(String host, int port, String user, String database, char[] password) {
        this.host_ = host;
        this.port_ = port;
        this.user_ = user;
        this.database_ = database;
        this.password_ = password;
    }

    public MongoClient connect() {
        MongoCredential credential = MongoCredential.createCredential(user_, database_, password_);
        mongoClient = new MongoClient(new ServerAddress(host_, port_),
                Arrays.asList(credential));
        return mongoClient;
    }
}
