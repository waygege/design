package com.ecut.design.Config.util;



import com.ecut.design.Model.User;
import org.apache.commons.codec.binary.Hex;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.security.SecureRandom;
import java.util.UUID;


@Component
public class UUIDUtils {

  public  String  getUUID(){
      String uuid = UUID.randomUUID().toString().replaceAll("-", "");
      return uuid;
  }


}
