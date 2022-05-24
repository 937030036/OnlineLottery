package com.example.onlinelottery.service.serviceimpl;

import com.example.onlinelottery.dao.SchemaMapper;
import com.example.onlinelottery.dao.UserMgrMapper;
import com.example.onlinelottery.model.Schema;
import com.example.onlinelottery.msg.TransMsg;
import com.example.onlinelottery.service.iservice.ISchemaHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemaHandleService implements ISchemaHandle {
    @Autowired
    private UserMgrMapper userMgrMapper;

    @Autowired
    private SchemaMapper schemaMapper;

    @Override
    public TransMsg saveSchema(String name, String schemaname, String humansel, String schemasel) {
        Schema lotterySchema = new Schema();
        lotterySchema.setUsermgrname(name);
        lotterySchema.setSchemaname(schemaname);
        lotterySchema.setHumansel(humansel);
        lotterySchema.setSchemasel(schemasel);

        List<Schema> schemaList = schemaMapper.getSchemaList();
        for (var sc : schemaList) {
            if (sc.getSchemaname().equals(schemaname)) {
                return TransMsg.ADDSCHEMA_FAIL;
            }
        }

        schemaMapper.addSchema(lotterySchema);
        return TransMsg.ADDSCHEMA_SUCC;
    }

    @Override
    public TransMsg deleteSchema(String schemaname) {
        schemaMapper.deleteSchema(schemaname);
        return TransMsg.DELETESCHEMA_SUCC;
    }

    @Override
    public List<Schema> getSchemaList() {
        return schemaMapper.getSchemaList();
    }

    @Override
    public TransMsg setAppSchema(Integer id,String schemaname) {
        userMgrMapper.setAppSchemaById(id,schemaname);
        return TransMsg.SETSCHEMA_SUCC;
    }

    @Override
    public Schema getAppSchema(Integer id) {
        String name = userMgrMapper.getAppSchemaById(id);
        if(name==null){
            return null;
        }
        return schemaMapper.getSchemaByName(name);
    }
}

