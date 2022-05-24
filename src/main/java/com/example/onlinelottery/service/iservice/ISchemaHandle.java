package com.example.onlinelottery.service.iservice;

import com.example.onlinelottery.msg.TransMsg;
import com.example.onlinelottery.model.Schema;

import java.util.List;

public interface ISchemaHandle {


    TransMsg saveSchema(String name, String schemaname, String humansel, String schemasel);

    TransMsg deleteSchema(String schemaname);

    List<Schema> getSchemaList();

    TransMsg setAppSchema(Integer id,String schemaname);

    Schema getAppSchema(Integer id);
}

