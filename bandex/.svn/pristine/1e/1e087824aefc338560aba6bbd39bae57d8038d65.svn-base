package com.bandex.api.dto;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Jason
 * Date: 14-5-28
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */
public class MyBasicDataSource extends  BasicDataSource {
   @Override
   public void setPassword(String password){
       try{
          super.setPassword(new String(decryptBASE64(password)));
       }catch (Exception e){
           e.printStackTrace();
       }

   }
    @Override
    public void setUsername(String username) {
        try{
            super.setUsername(new String(decryptBASE64(username)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public  byte[] decryptBASE64(String key) throws Exception {
        return (new Base64()).decode(key);
    }

    /**
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public  String encryptBASE64(byte[] key) throws Exception {
        return new String((new Base64()).encode(key));
    }
   public static void main(String[] args){
       MyBasicDataSource source=new MyBasicDataSource();
       try{
       String password="root";
       String username="root";
        String url="jdbc:oracle:thin:@10.10.2.141:1515:apptest";
       String newPassword=source.encryptBASE64(password.getBytes());
       String newUserName=source.encryptBASE64(username.getBytes());
           String newurl=source.encryptBASE64(url.getBytes());
       System.out.println("加密：username:"+newUserName+"--------------password:"+newPassword);   // root 对应的密码 cm9vdA==

       System.out.println("解密：username:"+new String(source.decryptBASE64(newUserName))+"-----------password:"+new String(source.decryptBASE64(newPassword)));
       }catch(Exception e){
          e.printStackTrace();
       }
   }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
