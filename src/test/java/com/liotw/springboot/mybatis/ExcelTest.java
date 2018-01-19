package com.liotw.springboot.mybatis;


import com.liotw.springboot.mybatis.dto.ShopDTO;
import com.liotw.springboot.mybatis.utils.ExcelExportUtil;
import com.liotw.springboot.mybatis.utils.ExcelImportUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Excel Test
 *
 * @author jiangjialiang on 2017-09-12
 * @version 1.1.0
 */
public class ExcelTest {

    public static void main(String[] args) {

        /**
         * Mock数据，Java对象列表
         */
        List<ShopDTO> shopDTOList = new ArrayList<ShopDTO>();
        for (int i = 0; i < 100; i++) {
            ShopDTO shop = new ShopDTO(true, "商户"+i, (short) i, 1000+i, 10000+i, (float) (1000+i), (double) (10000+i), new Date());
            shopDTOList.add(shop);
        }
        String filePath = "F:/demo-sheet.xls";

        /**
         * Excel导出：Object 转换为 Excel
         */
        ExcelExportUtil.exportToFile(filePath, shopDTOList, shopDTOList);

        /**
         * Excel导入：Excel 转换为 Object
          */
        List<Object> list = ExcelImportUtil.importExcel(ShopDTO.class, filePath);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            ShopDTO shop = (ShopDTO) list.get(i);
            System.out.println("shopName: "+shop.getShopName());
        }

    }

}
