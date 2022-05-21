package com.example.onlinelottery.Controller.Handle;

import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Service.IService.ISchemaHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class SchemaHandleCtler {

    @Autowired
    private ISchemaHandle schemaHandle;

    private TransMsg transMsg;

    @RequestMapping(value = "schema", method = RequestMethod.POST)
    String addSchema(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String schemaname = request.getParameter("schemaname");
        String human = request.getParameter("human");
        String schema = request.getParameter("schema");
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = schemaHandle.saveSchema(userMgr.getPhone(), schemaname, human, schema);
        model.addAttribute("msg", transMsg.toString());
        model.addAttribute("data", schemaHandle.getSchemaList());
        return "Schema";
    }

    @RequestMapping(value = "schema", method = RequestMethod.DELETE)
    String deleteSchema(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String schemaname = request.getParameter("schemaname");
        transMsg = schemaHandle.deleteSchema(schemaname);
        model.addAttribute("msg", transMsg.toString());
        model.addAttribute("data", schemaHandle.getSchemaList());
        return "Schema";
    }

    @RequestMapping(value = "schema", method = RequestMethod.PUT)
    String applySchema(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String schemaname = request.getParameter("schemaname");
        transMsg =schemaHandle.setAppSchema(schemaname);
        model.addAttribute("msg", transMsg.toString());
        model.addAttribute("data", schemaHandle.getSchemaList());
        return "Schema";
    }
}
