package com.mhl.service;

import com.mhl.dao.DiningTableDAO;
import com.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private final DiningTableDAO diningTableDAO = new DiningTableDAO();
    //返回所有餐桌
    public List<DiningTable> listTable(){
        return diningTableDAO.queryMulti("select * from diningtable", DiningTable.class);
    }
    //显示已有餐桌信息Id,State
    public void showTableId_State(){
        List<DiningTable> diningTables = listTable();
        for (DiningTable diningTable : diningTables) {
            System.out.println("\t\t" + diningTable.getId() + "\t\t\t" +diningTable.getState());
        }
    }
    //验证有此桌位，有则返回true，无则false
    public boolean testHaveThisTable(int id){
        List<DiningTable> diningTables = listTable();
        for (DiningTable diningTable : diningTables) {
            if(diningTable.getId() == id){
                return true;
            }
        }
        return false;
    }
    //验证此桌为空，有则返回true，无则false
    public boolean testTableAvailable(int id){
        Object o = diningTableDAO.queryScalar("select state from diningtable where id = ?", DiningTable.class, id);
        return o.equals("空");
    }
    //预定成功，设置状态：已预订，及姓名，手机号
    public boolean setStateAndTel(String orderName,String orderTel,int id){
        int effect = diningTableDAO.update
                ("update diningtable set state = ?,orderName = ?,orderTel = ? where id = ?", "已预订", orderName, orderTel,id);
        return effect > 0;
    }
}
