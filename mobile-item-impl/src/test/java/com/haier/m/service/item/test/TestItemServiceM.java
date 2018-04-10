package com.haier.m.service.item.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.haier.common.ServiceResult;
import com.haier.m.entity.order.OrderInfo;
import com.haier.m.service.order.ReOrderServiceM;

import junit.framework.Assert;

public class TestItemServiceM extends TestBase {
//    @Resource
//    private ItemServiceM itemServiceM;
//    @Resource
//    private RegionService regionService;
    private ReOrderServiceM reOrderServiceM;

   @Override
    protected void init() {
//        itemServiceM = context.getBean("itemServiceM", ItemServiceM.class);
       reOrderServiceM = context.getBean("reOrderServiceM", ReOrderServiceM.class);
//        Assert.assertNotNull(itemServiceM);
        Assert.assertNotNull(reOrderServiceM);
    }

//    public void testGetItemById() {
//        print(itemServiceM.getItemById(4651));
//    }
//
//    @Test
//    public void testGetItemBySKUs() {
//        List<String> skuList = new ArrayList<String>();
//        skuList.add("BA09Q304Z");
//        skuList.add("B20141118");
//        skuList.add("GA07Z0B02");
//        skuList.add("B00TY006V");
//        skuList.add("F70500011");
//
//        print(itemServiceM.getItemBySKUs(skuList));
//    }
//
//    @Test
//    public void testGetRandomItemSKUByLimitNum() {
//        print(itemServiceM.getRandomItemSKUByLimitNum(50));
//    }
//
//    public static void main(String[] args) {
//        TestItemServiceM testSysDictionaryCfgServiceM = new TestItemServiceM();
//        try {
//            testSysDictionaryCfgServiceM.setUp();
//            testSysDictionaryCfgServiceM.testGetRegionByParentId();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.exit(0);
//    }
//
//    @Test
//    public void testGetItemForListPage() {
////        ServiceResult<List<Map<String, Object>>> result = itemServiceM.getItemForListPage(null,
////            "saleDesc", new PagerInfo(5,1),"冰箱");
//        ServiceResult<List<Map<String, Object>>> result = itemServiceM.getItemForListPage(null,
//                "saleDesc", 1000, null, new PagerInfo(5, 1),"冰箱");
//        Assert.assertNotNull(result);
//    }
//
//    @Test
//    public void testFindProductCates() {
//        ServiceResult<ProductCates> result = itemServiceM.findById(2728);
//        if (result.getSuccess()) {
//            print(result.getResult().getCateName() + ":品牌信息");
//        }
//    }
//
//    @Test
//    public void testGetRegionNameById() throws Exception{
//        ServiceResult<Region> result = regionService.getRegionNameById(2444);
//        if (result.getSuccess()) {
//            print("地区名称："+ result.getResult().getRegionName()+",城市名称："+ result.getResult().getCityName()
//            +",省份名称："+ result.getResult().getProvinceName());
//        }
//    }
//
//
//
//    public void testGetRegionByParentId() throws Exception{
//        ServiceResult<List<RegionRedis>> result = regionService.getRegionByParentId("0");
//        if (result.getSuccess()) {
//            for(RegionRedis regionRedis:result.getResult()){
//                print("ID："+ regionRedis.getId()+",地区名称："+ regionRedis.getRegionName()
//                      +",等级："+ regionRedis.getRegionType());
//            }
//        }
//    }
//
//    @Test
//    public void testGetSensitiveWords()throws Exception{
//        ServiceResult<List<String>> result = itemServiceM.getSensitiveWords();
//        print(result);
//    }
//
//    @Test
//    public void testGetDiscoverSku()throws Exception{
//        ServiceResult<List<String>> result = itemServiceM.getDiscoverSku();
//        print(result);
//    }
//
//    @Test
//    public void testGetItemBySkuList() {
//        List<String> skuList = new ArrayList<String>();
//        skuList.add("BK004003V");
//        skuList.add("BA09X0B8F");
//        skuList.add("BA09X004Z");
//
//        ServiceResult<List<Map<String, Object>>> result = itemServiceM.getItemBySkuList(null,
//                "saleDesc",null,null, new PagerInfo(5, 1),"冰箱",skuList);
//        Assert.assertNotNull(result);
//    }



    @Test
    public void testGetRegionNotContainStreet() throws Exception{
//        OrdersRecover ordersRecover = new OrdersRecover();
//        ordersRecover.setMemberId(138231226);
//        ordersRecover.setOrderId(20990090);
//        ordersRecover.setDeleteStatus(1);
//        ServiceResult<Boolean> insertOrderToDelete = reOrderServiceM.insertOrderToDelete(ordersRecover);
//        System.out.println(insertOrderToDelete.getResult());
        Map<String, Object> reQueryMap = new HashMap<String, Object>();
        reQueryMap.put("memberId", 138231226);
        ServiceResult<List<OrderInfo>> reOrderList = reOrderServiceM
                .getOrderListByConditions(reQueryMap, null, false);
        System.out.println(reOrderList.getResult().size());
        
    }


//    @Test
//    public void testGetRegionNameByIds() throws Exception{
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(213);
//        ids.add(218);
//        ids.add(215);
//        ids.add(207);
//        ServiceResult<Map<Integer,String>> result = regionService.getRegionNameByIds(ids);
//        if (result.getSuccess()) {
//            print(JsonUtil.toJson(result));
//        }
//    }

    @Test
    public void testOrderLimit(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        //获取登录人
        String modifyUser = "admin";
        map.put("consignee", 0);
        map.put("mobile", 1);
        map.put("region", 0);
        map.put("street", 1);
        map.put("billCompany", 0);
        map.put("shippingMode", 1);
        map.put("productId", 1);
        map.put("number", 3);
        ServiceResult<Boolean> updateLimitCondition = reOrderServiceM.updateLimitCondition(map, modifyUser);
        System.out.println(updateLimitCondition.getResult());
    }



}
