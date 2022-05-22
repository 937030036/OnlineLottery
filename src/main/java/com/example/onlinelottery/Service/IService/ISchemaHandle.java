package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Model.Schema;

import java.util.List;

public interface ISchemaHandle {


    TransMsg saveSchema(String name, String schemaname, String humansel, String schemasel);

    TransMsg deleteSchema(String schemaname);

    List<Schema> getSchemaList();

    TransMsg setAppSchema(Integer id,String schemaname);

    Schema getAppSchema(Integer id);
}

